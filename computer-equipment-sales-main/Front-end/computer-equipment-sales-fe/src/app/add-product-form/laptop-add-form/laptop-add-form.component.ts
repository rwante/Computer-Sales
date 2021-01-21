import { Component, OnInit } from '@angular/core';
import {LaptopService} from '../../services/laptop/laptop.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Laptop} from '../../model/laptop/laptop';
import {LaptopGpu} from '../../model/laptop/laptop-gpu';
import {LaptopProcessor} from '../../model/laptop/laptop-processor';
import {LaptopHdd} from '../../model/laptop/laptop-hdd';
import {LaptopRam} from '../../model/laptop/laptop-ram';
import {LaptopSsd} from '../../model/laptop/laptop-ssd';
import {LaptopScreen} from '../../model/laptop/laptop-screen';

@Component({
  selector: 'app-laptop-add-form',
  templateUrl: './laptop-add-form.component.html',
  styleUrls: ['./laptop-add-form.component.css'],
  providers: [LaptopService]
})
export class LaptopAddFormComponent implements OnInit {

  constructor(private laptopService: LaptopService) { }
  model: Laptop = new Laptop();
  modelGpu: LaptopGpu[];
  modelProcessor: LaptopProcessor[];
  modelHdd: LaptopHdd[];
  modelRam: LaptopRam[];
  modelSsd: LaptopSsd[];
  modelScreen: LaptopScreen[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.laptopService.getGpu().subscribe((data: any) => {
      this.modelGpu = data.result;
    });
    this.laptopService.getProcessor().subscribe((data: any) => {
      this.modelProcessor = data.result;
    });
    this.laptopService.getHdd().subscribe((data: any) => {
      this.modelHdd = data.result;
    });
    this.laptopService.getRam().subscribe((data: any) => {
      this.modelRam = data.result;
    });
    this.laptopService.getSsd().subscribe((data: any) => {
      this.modelSsd = data.result;
    });
    this.laptopService.getScreen().subscribe((data: any) => {
      this.modelScreen = data.result;
    });
    this.laptopService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(laptopAddForm: NgForm): void{
    this.laptopService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }

}
