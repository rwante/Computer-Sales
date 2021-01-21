import { Component, OnInit } from '@angular/core';
import {LaptopService} from '../services/laptop/laptop.service';
import {Laptop} from '../model/laptop/laptop';

@Component({
  selector: 'app-laptop',
  templateUrl: './laptop.component.html',
  styleUrls: ['./laptop.component.css'],
  providers: [LaptopService]
})
export class LaptopComponent implements OnInit {

  constructor(private laptopService: LaptopService) { }
  title = 'Ürün Listesi';
  products: Laptop[];
  filterText = '';

  ngOnInit(): void {
    this.laptopService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
