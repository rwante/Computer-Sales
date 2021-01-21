import { Component, OnInit } from '@angular/core';
import {DisplayCardService} from '../../services/display-card/display-card.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {DisplayCard} from '../../model/display-card/display-card';
import {DisplayCardGpu} from '../../model/display-card/display-card-gpu';
import {DisplayCardMemory} from '../../model/display-card/display-card-memory';

@Component({
  selector: 'app-display-card-add-form',
  templateUrl: './display-card-add-form.component.html',
  styleUrls: ['./display-card-add-form.component.css'],
  providers: [DisplayCardService]
})
export class DisplayCardAddFormComponent implements OnInit {

  constructor(private displayCardService: DisplayCardService) { }
  model: DisplayCard = new DisplayCard();
  modelGpu: DisplayCardGpu[];
  modelMemory: DisplayCardMemory[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.displayCardService.getGPU().subscribe((data: any) => {
      this.modelGpu = data.result;
    });
    this.displayCardService.getMemory().subscribe((data: any) => {
      this.modelMemory = data.result;
    });
    this.displayCardService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(displayCardAddForm: NgForm): void{
    this.displayCardService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }

}
