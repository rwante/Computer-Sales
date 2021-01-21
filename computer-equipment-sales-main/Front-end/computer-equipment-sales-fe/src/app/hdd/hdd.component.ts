import { Component, OnInit } from '@angular/core';
import {HddService} from '../services/hdd/hdd.service';
import {Hdd} from '../model/hdd/hdd';

@Component({
  selector: 'app-hdd',
  templateUrl: './hdd.component.html',
  styleUrls: ['./hdd.component.css'],
  providers: [HddService]
})
export class HddComponent implements OnInit {

  constructor(private hddService: HddService) { }

  title = 'Ürün Listesi';
  products: Hdd[];
  filterText = '';

  ngOnInit(): void {
    this.hddService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }

}
