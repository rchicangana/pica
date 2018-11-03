import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-itinerario',
  templateUrl: './itinerario.component.html',
  styleUrls: ['./itinerario.component.css']
})
export class ItinerarioComponent implements OnInit {

  @Input() public datosFormulario: any;

  constructor() { }

  ngOnInit() {
  }

}
