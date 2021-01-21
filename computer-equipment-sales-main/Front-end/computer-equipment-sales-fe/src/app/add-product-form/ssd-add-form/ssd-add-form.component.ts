import { Component, OnInit } from '@angular/core';
import {SsdService} from '../../services/ssd/ssd.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Ssd} from '../../model/ssd/ssd';

@Component({
  selector: 'app-ssd-add-form',
  templateUrl: './ssd-add-form.component.html',
  styleUrls: ['./ssd-add-form.component.css'],
  providers: [SsdService]
})
export class SsdAddFormComponent implements OnInit {

  constructor(private ssdService: SsdService) { }
  model: Ssd = new Ssd();
  modelStock: Stock[];

  ngOnInit(): void {
    this.ssdService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(ssdAddForm: NgForm): void{
    this.ssdService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
