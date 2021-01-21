import { Component, OnInit } from '@angular/core';
import {DisplayCardService} from '../services/display-card/display-card.service';
import {DisplayCard} from '../model/display-card/display-card';

@Component({
  selector: 'app-display-card',
  templateUrl: './display-card.component.html',
  styleUrls: ['./display-card.component.css'],
  providers: [DisplayCardService]
})
export class DisplayCardComponent implements OnInit {

  constructor(private displayCardService: DisplayCardService) { }

  title = 'Ürün Listesi';
  products: DisplayCard[];
  filterText = '';

  ngOnInit(): void {
    this.displayCardService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined){
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }

}
