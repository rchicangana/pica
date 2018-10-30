import {
  Component,
  OnInit,
  Input,
  OnChanges,
  SimpleChange,
  SimpleChanges
} from "@angular/core";
import { Product } from "../../shared/models/product";
import { Tarifa } from "../../shared/models/tarifa";

@Component({
  selector: "app-cart-calculator",
  templateUrl: "./cart-calculator.component.html",
  styleUrls: ["./cart-calculator.component.scss"]
})
export class CartCalculatorComponent implements OnInit, OnChanges {
  @Input() products: Tarifa[];

  totalValue :number = 0;
  constructor() {}

  ngOnChanges(changes: SimpleChanges) {
    const dataChanges: SimpleChange = changes.products;

    const products: Tarifa[] = dataChanges.currentValue;
    this.totalValue = 0;
    products.forEach(product => {
      console.log(
        "Agregando: " + product.boleteriaDTO.productoId + " $ " + product.total
      );
      let valor:number = product.total.valueOf();
      this.totalValue = this.totalValue + valor;
    });
  }

  ngOnInit() {}
}
