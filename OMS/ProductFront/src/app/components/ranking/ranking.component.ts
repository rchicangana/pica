import { Component, OnInit } from '@angular/core';
import { NgbDate, NgbCalendar, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { ProductosService } from '../../services/productos.service';

@Component({
  selector: 'app-ranking',
  templateUrl: './ranking.component.html',
  styleUrls: ['./ranking.component.css']
})
export class RankingComponent implements OnInit {

  hoveredDate: NgbDate;
  verPrincipal = true;
  fromDate: NgbDate;
  toDate: NgbDate;
  elementos: any[] = [];
  prodcuto: any = {};
  errores: any = {};
  datosFormulario: any = {};
  parametros: any = {};
  page: any;
  itemsPerPage = 5;
  totalItems: any;
  previousPage: any;
  mostrarDetalle = false;
  constructor(private calendar: NgbCalendar, private productoService: ProductosService) { }

  ngOnInit() {
  }

  onDateSelection(date: NgbDate) {
    if (!this.fromDate && !this.toDate) {
      this.fromDate = date;
    } else if (this.fromDate && !this.toDate && date.after(this.fromDate)) {
      this.toDate = date;
    } else {
      this.toDate = null;
      this.fromDate = date;
    }
  }

  isHovered(date: NgbDate) {
    return this.fromDate && !this.toDate && this.hoveredDate && date.after(this.fromDate) && date.before(this.hoveredDate);
  }

  isInside(date: NgbDate) {
    return date.after(this.fromDate) && date.before(this.toDate);
  }

  isRange(date: NgbDate) {
    return date.equals(this.fromDate) || date.equals(this.toDate) || this.isInside(date) || this.isHovered(date);
  }

  buscarRanking() {
    this.errores = {};
    let error = false;
    if (!this.parametros.tipo) {
      this.errores.tipo =
        'seleccionar un tipo de consulta';
      error = true;
    }
    if (this.fromDate == null) {
      this.errores.fechas = 'Debe especificar un rango de fechas';
      error = true;
    } else {
      this.parametros.fechaini = (this.fromDate.day < 10 ? '0' + this.fromDate.day : this.fromDate.day) + ''
                                    + (this.fromDate.month < 10 ? '0' + this.fromDate.month : this.fromDate.month) + ''
                                    + this.fromDate.year;
    }

    if (this.toDate == null) {
      this.errores.fechas = 'Debe especificar un rango de fechas';
      error = true;
    } else {
      this.parametros.fechafin = (this.toDate.day < 10 ? '0' + this.toDate.day : this.toDate.day) + ''
                                        + (this.toDate.month < 10 ? '0' + this.toDate.month : this.toDate.month) + ''
                                        + this.toDate.year;
    }
    if (error) {
      return;
    }

    if ( this.parametros.tipo === 'P') {
      this.productoService.getTopProducto(this.parametros.fechaini, this.parametros.fechafin)
      .subscribe((response: any) => {
        this.elementos = response.object;
      });
    }
    if ( this.parametros.tipo === 'C') {
      this.productoService.getTopCategoria(this.parametros.fechaini, this.parametros.fechafin)
      .subscribe((response: any) => {
        this.elementos = response.object;
      });
    }

    this.mostrarDetalle = true;

  }

  detalle(item) {
    this.productoService.getProductoCodigo(item.idProducto).subscribe((response: any) => {
      this.datosFormulario = response.object;
      this.verPrincipal = false;
    });
  }

}
