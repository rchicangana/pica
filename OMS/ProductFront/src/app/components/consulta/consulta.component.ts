import { Component, OnInit } from '@angular/core';
import { ProductosService } from 'src/app/services/productos.service';

@Component({
  selector: 'app-consulta',
  templateUrl: './consulta.component.html',
  styles: []
})
export class ConsultaComponent implements OnInit {

  elementos: any[] = [];
  panelEditar = false;
  panelAdicional = false;
  registro: any = {};
  nuevoRegistro = true;
  datosFormulario: any = {};
  errores: any = {};
  page: any;
  itemsPerPage = 5;
  totalItems: any;
  previousPage: any;
  tiposProducto: any[];
  comodin: string;
  codigo: number;


  constructor(private productosService: ProductosService) { }

  ngOnInit() {
    this.productosService.getProductos(0, this.comodin).subscribe((data: any) => {
      console.log(data);
      this.elementos = data.object;
      this.page = 1;
      if (data.cantidad > 100 || data.cantidad == null) {
        data.cantidad = 100;
      }
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
    this.productosService.getProductos((this.page - 1) * this.itemsPerPage,
     (this.comodin === '' ? '*' : this.comodin)).subscribe((data: any) => {
      this.elementos = data.object;
    });
  }

  loadDataCodigo() {
    this.productosService.getProductoCodigo(this.codigo).subscribe((data: any) => {
      this.totalItems = 1;
      this.elementos = [];
      this.elementos.push(data.object);
    });
  }

  verDetalle(item){
    this.registro = item;
    Object.assign(this.datosFormulario, item);
    this.panelEditar = true;
    this.nuevoRegistro = false;
    this.panelAdicional = true;
  }

  cancelar() {
    this.registro = {};
    this.panelEditar = false;
    this.nuevoRegistro = true;
    this.datosFormulario = {};
    this.errores = {};
    this.panelAdicional = false;
  }

}
