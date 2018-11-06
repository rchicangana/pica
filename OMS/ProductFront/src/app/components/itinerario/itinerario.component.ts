import { Component, OnInit, Input } from '@angular/core';
import { ItinerarioService } from '../../services/itinerario.service';

@Component({
  selector: 'app-itinerario',
  templateUrl: './itinerario.component.html',
  styleUrls: ['./itinerario.component.css']
})
export class ItinerarioComponent implements OnInit {

  @Input() public datosFormulario: any;
  itinerarios: any = [];

  constructor(private itinerarioService: ItinerarioService) { }

  ngOnInit() {
    this.itinerarios = this.itinerarioService.getItinierario(this.datosFormulario.idProducto).subscribe(
      (response: any) => {
        this.itinerarios = response;
      });
  }

}
