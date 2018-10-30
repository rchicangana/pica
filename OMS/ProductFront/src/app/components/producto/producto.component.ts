import { Component, OnInit } from '@angular/core';
import { ProductosService } from '../../services/productos.service';
import { NgbDate, NgbCalendar, NgbDateStruct} from '@ng-bootstrap/ng-bootstrap';
import { TipoproductoService } from '../../services/tipoproducto.service';
import {  FileUploader, FileSelectDirective } from 'ng2-file-upload/ng2-file-upload';
import { ImagenesService } from '../../services/imagenes.service';

@Component({
  selector: 'app-producto',
  templateUrl: './producto.component.html',
  styles: [`
    .custom-day {
      text-align: center;
      padding: 0.185rem 0.25rem;
      display: inline-block;
      height: 2rem;
      width: 2rem;
    }
    .custom-day.focused {
      background-color: #e6e6e6;
    }
    .custom-day.range, .custom-day:hover {
      background-color: rgb(2, 117, 216);
      color: white;
    }
    .custom-day.faded {
      background-color: rgba(2, 117, 216, 0.5);
    }
  `]
})
export class ProductoComponent implements OnInit {
  hoveredDate: NgbDate;
  inputFile: any;
  fromDate: NgbDate;
  toDate: NgbDate;
  elementos: any[] = [];
  imagenes: any[] = [];
  datosImagenProducto: any = {};
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

  private imageSrc = '';

  handleInputChange(e) {
    const file = e.dataTransfer ? e.dataTransfer.files[0] : e.target.files[0];
    const pattern = /image-*/;
    const reader = new FileReader();
    if (!file.type.match(pattern)) {
      alert('invalid format');
      return;
    }
    reader.onload = this._handleReaderLoaded.bind(this);
    reader.readAsDataURL(file);
  }
  _handleReaderLoaded(e) {
    const reader = e.target;
    this.imageSrc = reader.result;
  }

  constructor(private productosService: ProductosService,
    private calendar: NgbCalendar,
    private tipoproductoService: TipoproductoService,
    private imagenesService: ImagenesService) {
    this.fromDate = calendar.getToday();
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

  ngOnInit() {
    this.productosService.getProductos(0).subscribe((data: any) => {
      console.log(data);
      this.elementos = data.object;
      this.page = 1;
      this.totalItems = Math.round(data.cantidad);
    });
    this.tipoproductoService.getTiposProducto().subscribe((data: any) => { this.tiposProducto = data; });
  }

  loadPage(page: number) {
    if (page !== this.previousPage) {
      this.previousPage = page;
      this.loadData();
    }
  }

  loadData() {
    this.productosService.getProductos((this.page - 1) * this.itemsPerPage).subscribe((data: any) => {
      this.elementos = data.object;
    });
  }

  cancelar() {
    this.registro = {};
    this.panelEditar = false;
    this.nuevoRegistro = true;
    this.datosFormulario = {};
    this.errores = {};
    this.panelAdicional = false;
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
    this.panelAdicional = true;
    console.log(item);
    const fecSalida: NgbDate = new NgbDate(+item.fechaSalida.substring(6, 10),
                                      +item.fechaSalida.substring(3, 5),
                                      +item.fechaSalida.substring(0, 2));
    const fecRegreso: NgbDate = new NgbDate(+item.fechaLlegada.substring(6, 10),
                                      +item.fechaLlegada.substring(3, 5),
                                      +item.fechaLlegada.substring(0, 2));
    this.fromDate = fecSalida;
    this.toDate = fecRegreso;
    this.consultarImagenes(item.idProducto);
  }

  consultarImagenes(idProducto: number) {
    this.imagenesService.getImagenes(idProducto).subscribe((data: any) => { this.imagenes = data; });
  }

  borrarImagen(imagen: any) {
    this.imagenesService.borrarImagenProducto(imagen.idImagenProducto).subscribe(
      (response: any) => {
        if (response.codigo === 'OK') {
          const indice = this.imagenes.indexOf(imagen);
          this.imagenes.splice(indice, 1);
          bootbox.alert('Transacción realizada correctamente');
        } else {
          bootbox.alert(response.mensaje);
        }
      });
  }

  cargarImagen(){
    let error = false;
    if (!this.imageSrc) {
      this.errores.imagenProducto =
        'Debe seleccionar una imagen para realizar la carga';
      error = true;
    }
    if (error) {
      return;
    }
    this.datosImagenProducto.imagen = this.imageSrc.replace('data:image/jpeg;base64,', '');
    this.datosImagenProducto.esprincipal = 1;
    this.datosImagenProducto.idProducto = this.datosFormulario.idProducto;
    this.imagenesService.guardarImagenProducto(this.datosImagenProducto).subscribe(
      (response: any) => {
        if (response.codigo === 'OK') {
          this.imagenes.push(response.object);
          bootbox.alert('Transacción realizada correctamente');
          this.imageSrc = '';
          this.inputFile = '';
        } else {
          bootbox.alert(response.mensaje);
        }
      });

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

    if (this.fromDate == null) {
      this.errores.fechas = 'Debe especificar un rango de fechas';
      error = true;
    } else {
      this.datosFormulario.fechaSalida = (this.fromDate.day < 10 ? '0' + this.fromDate.day : this.fromDate.day) + '/'
                                        + (this.fromDate.month < 10 ? '0' + this.fromDate.month : this.fromDate.month) + '/'
                                        + this.fromDate.year;
    }

    if (this.toDate == null) {
      this.errores.fechas = 'Debe especificar un rango de fechas';
      error = true;
    } else {
      this.datosFormulario.fechaLlegada = (this.toDate.day < 10 ? '0' + this.toDate.day : this.toDate.day) + '/'
                                        + (this.toDate.month < 10 ? '0' + this.toDate.month : this.toDate.month) + '/'
                                        + this.toDate.year;
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
                this.panelAdicional = true;
                this.consultarImagenes(response.object.idProducto);
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
              } else {
                bootbox.alert(response.mensaje);
              }
            });
        }
      );
    }
  }
}

