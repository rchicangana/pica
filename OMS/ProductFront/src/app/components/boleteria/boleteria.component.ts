import { Component, OnInit, Input } from '@angular/core';
import { BoleteriaService } from '../../services/boleteria.service';
import { NgbDate, NgbDateStruct } from '@ng-bootstrap/ng-bootstrap';

@Component({
  selector: 'app-boleteria',
  templateUrl: './boleteria.component.html',
  styles: []
})
export class BoleteriaComponent implements OnInit {

  @Input() public datosFormulario: any;
  datosBoleta: any = {};
  nuevoRegistro = true;
  errores: any = {};
  fechaCal: NgbDateStruct;

  constructor(private boleteriaService: BoleteriaService) { }

  ngOnInit() {
    this.boleteriaService.getBoleta(this.datosFormulario.idProducto).subscribe(
      (response: any) => {
        this.datosBoleta = response;
        const fecha: NgbDate = new NgbDate(response.fecha.substring(6, 10),
        +response.fecha.substring(3, 5),
        +response.fecha.substring(0, 2));
this.fechaCal = fecha;
        if (response != null) {
          this.nuevoRegistro = false;
        }
      }
    );
  }

  guardar() {
    let error = false;
    this.datosBoleta.productoId = this.datosFormulario.idProducto;
    if (!this.datosBoleta.tiquetes) {
      this.errores.tiquetes =
        'Debe especificarnumero de boletos';
      error = true;
    }
    if (!this.datosBoleta.localidad) {
      this.errores.localidad =
        'Debe ingresar la localidad de la boleta';
      error = true;
    }

    if (!this.fechaCal) {
      this.errores.fecha = 'Debe seleccionar unla fecha';
      error = true;
    } else {
      this.datosBoleta.fecha = (this.fechaCal.day < 10 ? '0' + this.fechaCal.day : this.fechaCal.day) + '/'
      + (this.fechaCal.month < 10 ? '0' + this.fechaCal.month : this.fechaCal.month) + '/'
      + this.fechaCal.year;
    }

    if (!this.datosBoleta.valor) {
      this.errores.valor =
        'Debe ingresar un valor';
      error = true;
    }

    if (error) {
      return;
    }
    console.log(this.datosBoleta);
    if (this.nuevoRegistro) {
      bootbox.confirm(
        'Esta seguro que desea guardar el registro?',
        resultado => {
          this.boleteriaService
            .guardarBoleteria(this.datosBoleta)
            .subscribe((response: any) => {
              if (response.codigo === 'OK') {
                this.datosBoleta  = response.object;
                bootbox.alert('Transacción realizada correctamente');
                this.nuevoRegistro = false;
              } else {
                bootbox.alert(response.mensaje);
              }
            });
        }
      );
    }
  }

}
