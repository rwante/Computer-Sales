import { Component, OnInit } from '@angular/core';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {RamService} from '../../services/ram/ram.service';
import {Ram} from '../../model/ram/ram';

@Component({
  selector: 'app-ram-add-form',
  templateUrl: './ram-add-form.component.html',
  styleUrls: ['./ram-add-form.component.css'],
  providers: [RamService]
})
export class RamAddFormComponent implements OnInit {

  constructor(private ramService: RamService) { }
  model: Ram = new Ram();
  modelStock: Stock[];

  ngOnInit(): void {
    this.ramService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(ramAddForm: NgForm): void{
    this.ramService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
