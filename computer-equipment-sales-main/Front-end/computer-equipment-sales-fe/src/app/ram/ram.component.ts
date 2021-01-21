import { Component, OnInit } from '@angular/core';
import {RamService} from '../services/ram/ram.service';
import {Ram} from '../model/ram/ram';

@Component({
  selector: 'app-ram',
  templateUrl: './ram.component.html',
  styleUrls: ['./ram.component.css'],
  providers: [RamService]
})
export class RamComponent implements OnInit {

  constructor(private ramService: RamService) { }
  title = 'Ürün Listesi';
  products: Ram[];
  filterText = '';

  ngOnInit(): void {
    this.ramService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
