import { Component, OnInit } from '@angular/core';
import {MainboardService} from '../../services/mainboard/mainboard.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Mainboard} from '../../model/mainboard/mainboard';
import {MainboardRam} from '../../model/mainboard/mainboard-ram';

@Component({
  selector: 'app-mainboard-add-form',
  templateUrl: './mainboard-add-form.component.html',
  styleUrls: ['./mainboard-add-form.component.css'],
  providers: [MainboardService]
})
export class MainboardAddFormComponent implements OnInit {

  constructor(private mainboardService: MainboardService) { }
  model: Mainboard = new Mainboard();
  modelRam: MainboardRam[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.mainboardService.getRam().subscribe((data: any) => {
      this.modelRam = data.result;
    });
    this.mainboardService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(mainboardAddForm: NgForm): void{
    this.mainboardService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
