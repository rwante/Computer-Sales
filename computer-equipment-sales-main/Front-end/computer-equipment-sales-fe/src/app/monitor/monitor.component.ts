import { Component, OnInit } from '@angular/core';
import {MonitorService} from '../services/monitor/monitor.service';
import {Monitor} from '../model/monitor/monitor';

@Component({
  selector: 'app-monitor',
  templateUrl: './monitor.component.html',
  styleUrls: ['./monitor.component.css'],
  providers: [MonitorService]
})
export class MonitorComponent implements OnInit {

  constructor(private monitorService: MonitorService) { }
  title = 'Ürün Listesi';
  products: Monitor[];
  filterText = '';

  ngOnInit(): void {
    this.monitorService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
