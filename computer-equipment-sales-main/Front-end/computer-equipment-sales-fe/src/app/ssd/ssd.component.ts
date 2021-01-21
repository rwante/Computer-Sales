import { Component, OnInit } from '@angular/core';
import {SsdService} from '../services/ssd/ssd.service';
import {Ssd} from '../model/ssd/ssd';

@Component({
  selector: 'app-ssd',
  templateUrl: './ssd.component.html',
  styleUrls: ['./ssd.component.css'],
  providers: [SsdService]
})
export class SsdComponent implements OnInit {

  constructor(private ssdService: SsdService) { }
  title = 'Ürün Listesi';
  products: Ssd[];
  filterText = '';

  ngOnInit(): void {
    this.ssdService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
