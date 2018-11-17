import { Component, OnInit, Input } from '@angular/core';
import { ItinerarioService } from '../../services/itinerario.service';
import { HospedajeService } from '../../services/hospedaje.service';
import { PaisService } from '../../services/pais.service';
import { CiudadService } from '../../services/ciudad.service';
import { EmpresaService } from '../../services/empresa.service';

@Component({
  selector: 'app-itinerario',
  templateUrl: './itinerario.component.html',
  styleUrls: ['./itinerario.component.css']
})
export class ItinerarioComponent implements OnInit {

  @Input() public datosFormulario: any;
  itinerarios: any = [];
  registro: any = {};
  panelEditar = false;
  nuevoRegistro = true;
  datosItinerario: any = {};
  errores: any = {};
  hospedajes: any = [];
  paises: any = [];
  ciudades: any = [];
  ciudadesOrigen: any = [];
  empresas: any = [];

  constructor(private itinerarioService: ItinerarioService,
    private hospedajeService: HospedajeService,
    private paisService: PaisService,
    private ciudadService: CiudadService,
    private empresaService: EmpresaService) { }

  ngOnInit() {
    this.itinerarioService.getItinierario(this.datosFormulario.idProducto).subscribe(
      (response: any) => {
        this.itinerarios = response;
      });
      this.getListas();
  }

  getListas() {
    this.hospedajeService.getHospedajes().subscribe(
      (response: any) => {
        this.hospedajes = response;
      }
    );
    this.paisService.getPaises().subscribe(
      (response: any) => {
        this.paises = response;
      }
    );
    this.empresaService.getEmpresas().subscribe(
      (response: any) => {
        this.empresas = response;
      }
    );
  }

  getCiudades(idPais) {
    this.ciudadService.getCiudades(idPais).subscribe(
      (response: any) => {
        this.ciudades = response;
      }
    );
  }

  getCiudadesOrigen(idPais) {
    this.ciudadService.getCiudades(idPais).subscribe(
      (response: any) => {
        this.ciudadesOrigen = response;
      }
    );
  }

  editar(item) {
    this.registro = item;
    Object.assign(this.datosItinerario, item);
    this.panelEditar = true;
    this.nuevoRegistro = false;
  }

  cancelar() {
    this.registro = {};
    this.panelEditar = false;
    this.nuevoRegistro = true;
    this.datosItinerario = {};
    this.errores = {};
  }

  agregar() {
    this.registro = {};
    this.panelEditar = true;
    this.nuevoRegistro = true;
    this.datosItinerario = {};
    this.errores = {};
  }


  guardar() {
    let error = false;
    this.datosItinerario.idProducto = this.datosFormulario.idProducto;
    if (!this.datosItinerario.descripcion) {
      this.errores.descripcion =
        'Debe especificar el una descripcion para el itinerario';
      error = true;
    }
    if (!this.datosItinerario.idPaisOrigen) {
      this.errores.idPaisOrigen =
        'Debe seleccionar un pais origen';
      error = true;
    }

    if (!this.datosItinerario.idCiudadOrigen) {
      this.errores.idCiudadOrigen = 'Debe seleccionar una ciudad Origen';
      error = true;
    }

    if (!this.datosItinerario.idPais) {
      this.errores.idPais =
        'Debe seleccionar un pais destino';
      error = true;
    }

    if (!this.datosItinerario.idCiudad) {
      this.errores.idCiudad = 'Debe seleccionar una ciudad destino';
      error = true;
    }

    if (!this.datosItinerario.idHospedaje) {
      this.errores.idHospedaje = 'Debe seleccionar un hospedaje';
      error = true;
    }

    if (!this.datosItinerario.idEmpresa) {
      this.errores.idEmpresa = 'Debe seleccionar un transporte';
      error = true;
    }

    if (!this.datosItinerario.tarifaTransporte) {
      this.errores.tarifaTransporte = 'Debe seleccionar una tarifa de transporte';
      error = true;
    }


    if (error) {
      return;
    }
    console.log(this.datosItinerario);
    if (this.nuevoRegistro) {
      bootbox.confirm(
        'Esta seguro que desea guardar el registro?',
        resultado => {
          this.itinerarioService
            .guardarItinerario(this.datosItinerario)
            .subscribe((response: any) => {
              if (response.codigo === 'OK') {
                this.itinerarios.push(response.object);
                bootbox.alert('Transacción realizada correctamente');
                this.panelEditar = false;
              } else {
                bootbox.alert(response.mensaje);
              }
            });
        }
      );
    }
  }


}
