import { Component, OnInit, Input } from '@angular/core';
import {  FileUploader, FileSelectDirective } from 'ng2-file-upload/ng2-file-upload';
import { ImagenesService } from '../../services/imagenes.service';


@Component({
  selector: 'app-cargarimagenes',
  templateUrl: './cargarimagenes.component.html',
  styleUrls: ['./cargarimagenes.component.css']
})
export class CargarimagenesComponent implements OnInit {

  @Input() public datosFormulario: any;
  inputFile: any;
  imagenes: any[] = [];
  datosImagenProducto: any = {};
  imageSrc = '';
  errores: any = {};

  constructor(private imagenesService: ImagenesService) { }

  ngOnInit() {
    this.imagenesService.getImagenes(this.datosFormulario.idProducto).subscribe((data: any) => { this.imagenes = data; });
  }

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

  cargarImagen() {
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

}
