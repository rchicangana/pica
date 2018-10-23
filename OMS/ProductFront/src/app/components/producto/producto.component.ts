import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../../services/productos.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styleUrls: []
})
export class ProductoComponent implements OnInit {
  elementos: any[] = [];
  panelEditar = false;
  registro: any = {};
  nuevoRegistro = true;
  datosFormulario: any = {};
  errores: any = {};
  page: any;
  itemsPerPage = 5;
  totalItems: any;
  previousPage: any;



  constructor(private productosService: ProductosService) {}

  ngOnInit() {
    this.productosService.getProductos(0).subscribe((data: any) => {
      console.log(data);
      this.elementos = data;
      this.page = 1;
      this.totalItems = Math.round(data.cantidad);
    });
  }

  loadPage(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.loadData();
    }
  }

  loadData() {
    this.productosService.getProductos((this.page - 1) * this.itemsPerPage).subscribe((data: any) => {
      this.elementos = data;
    });
  }

  cancelar() {
    this.registro = {};
    this.panelEditar = false;
    this.nuevoRegistro = true;
    this.datosFormulario = {};
    this.errores = {};
  }

  agregar() {
    this.registro = {};
    this.panelEditar = true;
    this.nuevoRegistro = true;
    this.datosFormulario = {};
    this.errores = {};
  }

  editar(item: any) {
    this.registro = item;
    Object.assign(this.datosFormulario, item);
    this.panelEditar = true;
    this.nuevoRegistro = false;
    console.log(item);
  }

  guardar() {
    let error = false;
    if (!this.datosFormulario.nombreProducto) {
      this.errores.nombreProducto =
        'Debe especificar el nombre del producto';
      error = true;
    }
    if (!this.datosFormulario.descripcion) {
      this.errores.descripcion =
        'Debe especificar la descripcion del producto';
      error = true;
    }
    if (error) {
      return;
    }
    console.log(this.datosFormulario);
    if (this.nuevoRegistro) {
      bootbox.confirm(
        'Esta seguro que desea guardar el registro?',
        resultado => {
          this.productosService
            .guardarProducto(this.datosFormulario)
            .subscribe((response: any) => {
              if (response.codigo === 'OK') {
                this.elementos.push(response.object);
                bootbox.alert('Transacción realizada correctamente');
                this.cancelar();
              } else {
                bootbox.alert(response.mensaje);
              }
            });
        }
      );
    } else {
      bootbox.confirm(
        'Esta seguro que desea editar el registro?',
        resultado => {
          this.productosService
            .editarProducto(this.datosFormulario)
            .subscribe((response: any) => {
              if (response.codigo === 'OK') {
                Object.assign(this.registro, response.object);
                bootbox.alert('Transacción realizada correctamente');
                this.cancelar();
              } else {
                bootbox.alert(response.mensaje);
              }
            });
        }
      );
    }
  }
}
