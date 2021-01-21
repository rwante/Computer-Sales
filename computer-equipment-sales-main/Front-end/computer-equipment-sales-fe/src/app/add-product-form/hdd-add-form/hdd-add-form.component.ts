import { Component, OnInit } from '@angular/core';
import {HddService} from '../../services/hdd/hdd.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Hdd} from '../../model/hdd/hdd';

@Component({
  selector: 'app-hdd-add-form',
  templateUrl: './hdd-add-form.component.html',
  styleUrls: ['./hdd-add-form.component.css'],
  providers: [HddService]
})
export class HddAddFormComponent implements OnInit {

  constructor(private hddService: HddService) { }
  model: Hdd = new Hdd();
  modelStock: Stock[];

  ngOnInit(): void {
    this.hddService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(hddAddForm: NgForm): void{
    this.hddService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }

}
