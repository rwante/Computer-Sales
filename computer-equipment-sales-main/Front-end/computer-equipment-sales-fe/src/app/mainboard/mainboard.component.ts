import { Component, OnInit } from '@angular/core';
import {MainboardService} from '../services/mainboard/mainboard.service';
import {Mainboard} from '../model/mainboard/mainboard';

@Component({
  selector: 'app-mainboard',
  templateUrl: './mainboard.component.html',
  styleUrls: ['./mainboard.component.css'],
  providers: [MainboardService]
})
export class MainboardComponent implements OnInit {

  constructor(private mainboardService: MainboardService) { }
  title = 'Ürün Listesi';
  products: Mainboard[];
  filterText = '';

  ngOnInit(): void {
    this.mainboardService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
