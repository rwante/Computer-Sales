import { Component, OnInit } from '@angular/core';
import {MonitorService} from '../../services/monitor/monitor.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Monitor} from '../../model/monitor/monitor';
import {MonitorScreen} from '../../model/monitor/monitor-screen';

@Component({
  selector: 'app-monitor-add-form',
  templateUrl: './monitor-add-form.component.html',
  styleUrls: ['./monitor-add-form.component.css'],
  providers: [MonitorService]
})
export class MonitorAddFormComponent implements OnInit {

  constructor(private monitorService: MonitorService) { }
  model: Monitor = new Monitor();
  modelScreen: MonitorScreen[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.monitorService.getScreen().subscribe((data: any) => {
      this.modelScreen = data.result;
    });
    this.monitorService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(monitorAddForm: NgForm): void{
    this.monitorService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
