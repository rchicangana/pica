import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';


@Component({
  selector: 'app-consultarcampana',
  templateUrl: './campanas.component.html',
  styleUrls: ['./campanas.component.scss']
})
export class ConsultarcampanaComponent implements OnInit {
campanas:any;

  constructor(

                      private router:Router,
                      private http:HttpClient

  ) {

    this.http.get('/WsOmsREST1/rest/WsCampannas/obtenerCampanna/1/10').subscribe(campanas1=>{

        //this.campanas = _campanaService.getCampanas();
        this.campanas=campanas1;
       console.log(this.campanas);
       // console.log(this.campanas.nombreCampanna)
       // console.log(this.campanas.producto.nombreProducto)
       return this.campanas;
     }


);

  }

  ngOnInit() {
  }

}
