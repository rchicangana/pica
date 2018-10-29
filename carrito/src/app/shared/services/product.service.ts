import { Injectable } from "@angular/core";
import { ToastOptions, ToastyService, ToastyConfig } from "ng2-toasty";
import { Product } from "../models/product";
import { AuthService } from "./auth.service";
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable()
export class ProductService {
  products: Product[];
  product: Product;
  //apiUrl :string = "./Usuario.svc/Usuario";
  apiUrl :string = "ProductService/services/producto";
  // favouriteProducts
  //favouriteProducts: AngularFireList<FavouriteProduct>;
  //cartProducts: AngularFireList<FavouriteProduct>;

  // NavbarCounts
  navbarCartCount = 0;
  navbarFavProdCount = 0;

  constructor(
    private authService: AuthService,
    private toastyService: ToastyService,
    private http: HttpClient,
    private toastyConfig: ToastyConfig
  ) {
    // Toaster Config
    this.toastyConfig.position = "top-right";
    this.toastyConfig.theme = "material";

    if (this.authService.isLoggedIn()) {
      this.calculateFavProductCounts();
      this.calculateCartProductCounts();
    } else {
      this.calculateLocalFavProdCounts();
      this.calculateLocalCartProdCounts();
    }
  }

  getProducts() {
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    //return this.http.get(this.apiUrl+'/productos', { headers });
    return this.http.get(this.apiUrl+'/buscarDescripcion/0/10/*', { headers });
  }

  getProductsS( tipo?:String, termino?:String ) {
  const headers = new HttpHeaders({'Content-Type': 'application/json'});
  //return this.http.get(this.apiUrl+'/productos', { headers });
console.log ('captura del tipo:'+tipo+' y termino'+termino)
if (tipo == 'D'){
if ( termino == '*'){
    console.log (this.apiUrl+'/buscarDescripcion/0/10/*');
  return this.http.get(this.apiUrl+'/buscarDescripcion/0/10/*', { headers });
  }
  else {
    console.log (this.apiUrl+'/buscarDescripcion/0/10/'+termino);
  return this.http.get(this.apiUrl+'/buscarDescripcion/0/10/'+termino, { headers });
  }
}
else if (tipo == 'C'){
  if ( termino == '0'){
console.log (this.apiUrl+'/buscarProducto/0');
      return this.http.get(this.apiUrl+'/buscarProducto/1', { headers });
      }
      else {
        console.log (this.apiUrl+'/buscarProducto/'+termino);
      return this.http.get(this.apiUrl+'/buscarProducto/'+termino, { headers });


      }
}
if (tipo == 'P'){
if ( termino == '*'){
      console.log (this.apiUrl+'/buscarDescripcion/0/10/*');
    return this.http.get(this.apiUrl+'/buscarDescripcion/0/10/*', { headers });
    }
    else {
      console.log (this.apiUrl+'/buscarDescripcion/0/10/'+termino);
    return this.http.get(this.apiUrl+'/buscarDescripcion/0/10/'+termino, { headers });
    }
  }


else {console.log("Busqueda sin parametro valido")}
}

  createProduct(data: Product) {
    this.products.push(data);
  }

  getProductById(key: string) {
    //this.product = this.db.object("product/" + key);
    //return this.product;
    const headers = new HttpHeaders({'Content-Type': 'application/json'});
    //return this.http.get(this.apiUrl+'/productos/buscar/'+key, { headers });
    return this.http.get(this.apiUrl+'/buscarProducto/'+key, { headers });
  }

  updateProduct(data: Product) {
    //this.products.update(data.$key, data);
  }

  deleteProduct(key: string) {
    //this.products.remove(key);
  }

  /*
   ----------  Favourite Product Function  ----------
  */

  // Get Favourite Product based on userId
  getUsersFavouriteProduct() {
    const user = this.authService.getLoggedInUser();
    /*this.favouriteProducts = this.db.list("favouriteProducts", ref =>
      ref.orderByChild("userId").equalTo(user.$key)
    );
    return this.favouriteProducts;*/
  }

  // Adding New product to favourite if logged else to localStorage
  addFavouriteProduct(data: Product): void {
    // Toast Product Already exists
    const toastAlreadyExists: ToastOptions = {
      title: "El paquete ya fue agregado antes",
      msg: "Ya agregaste este paquete a tus favoritos",
      showClose: true,
      timeout: 5000,
      theme: "material"
    };

    // Toaster Adding
    const toastAdd: ToastOptions = {
      title: "Agrenado Paquete",
      msg: "Agregando paquete a favoritos",
      showClose: true,
      timeout: 5000,
      theme: "material"
    };

    let a: Product[];
    a = JSON.parse(localStorage.getItem("avf_item")) || [];
    a.push(data);
    this.toastyService.wait(toastAdd);
    setTimeout(() => {
      localStorage.setItem("avf_item", JSON.stringify(a));
      this.calculateLocalFavProdCounts();
    }, 1500);
  }

  // Fetching unsigned users favourite proucts
  getLocalFavouriteProducts(): Product[] {
    const products: Product[] =
      JSON.parse(localStorage.getItem("avf_item")) || [];

    return products;
  }

  // Removing Favourite Product from Database
  removeFavourite(key: string) {
    //this.favouriteProducts.remove(key);
  }

  // Removing Favourite Product from localStorage
  removeLocalFavourite(product: Product) {
    const products: Product[] = JSON.parse(localStorage.getItem("avf_item"));

    for (let i = 0; i < products.length; i++) {
      if (products[i].idProducto === product.idProducto) {
        products.splice(i, 1);
        break;
      }
    }
    // ReAdding the products after remove
    localStorage.setItem("avf_item", JSON.stringify(products));

    this.calculateLocalFavProdCounts();
  }

  // Returning Local Products Count
  calculateLocalFavProdCounts() {
    this.navbarFavProdCount = this.getLocalFavouriteProducts().length;
  }

  // Calculating FavProductsCount and storing it in variable
  calculateFavProductCounts() {
    const x = this.getUsersFavouriteProduct()
      /*.snapshotChanges()
      .subscribe(data => {
        this.navbarFavProdCount = data.length;
      });*/
  }

  /*
   ----------  Cart Product Function  ----------
  */

  // Fetching Cart Products based on userId
  getUsersCartProducts() {
    const user = this.authService.getLoggedInUser();
    /*this.cartProducts = this.db.list("cartProducts", ref =>
      ref.orderByChild("userId").equalTo(user.$key)
    );
    return this.cartProducts;*/
  }

  // Adding new Product to cart db if  else localStorage
  addToCart(data: Product): void {
    let a: Product[];

    a = JSON.parse(localStorage.getItem("avct_item")) || [];

    a.push(data);

    const toastOption: ToastOptions = {
      title: "Agregando el paquete al carrito",
      msg: "Paquete agregado al carrito",
      showClose: true,
      timeout: 1000,
      theme: "material"
    };
    this.toastyService.wait(toastOption);
    setTimeout(() => {
      localStorage.setItem("avct_item", JSON.stringify(a));
      this.calculateLocalCartProdCounts();
    }, 500);
  }

  // Removing Cart product from db
  removeCart(key: string) {
    //this.cartProducts.remove(key);
  }

  // Removing cart from local
  removeLocalCartProduct(product: Product) {
    const products: Product[] = JSON.parse(localStorage.getItem("avct_item"));

    for (let i = 0; i < products.length; i++) {
      if (products[i].idProducto === product.idProducto) {
        products.splice(i, 1);
        break;
      }
    }
    // ReAdding the products after remove
    localStorage.setItem("avct_item", JSON.stringify(products));

    this.calculateLocalCartProdCounts();
  }

  // Fetching Locat CartsProducts
  getLocalCartProducts(): Product[] {
    const products: Product[] =
      JSON.parse(localStorage.getItem("avct_item")) || [];

    return products;
  }

  // returning LocalCarts Product Count
  calculateLocalCartProdCounts() {
    this.navbarCartCount = this.getLocalCartProducts().length;
  }

  // Calculating Cart products count and assigning to variable
  calculateCartProductCounts() {
    const x = this.getUsersCartProducts()
     /*.snapshotChanges()
      .subscribe(data => {
        this.navbarCartCount = data.length;
      });*/
  }
}

export class FavouriteProduct {
  product: Product;
  productId: string;
  userId: string;
}
