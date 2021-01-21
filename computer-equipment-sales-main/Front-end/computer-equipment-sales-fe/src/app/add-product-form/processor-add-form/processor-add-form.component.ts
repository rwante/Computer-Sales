import { Component, OnInit } from '@angular/core';
import {ProcessorService} from '../../services/processor/processor.service';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';
import {Processor} from '../../model/processor/processor';
import {ProcessorCore} from '../../model/processor/processor-core';

@Component({
  selector: 'app-processor-add-form',
  templateUrl: './processor-add-form.component.html',
  styleUrls: ['./processor-add-form.component.css'],
  providers: [ProcessorService]
})
export class ProcessorAddFormComponent implements OnInit {

  constructor(private processorService: ProcessorService) { }
  model: Processor = new Processor();
  modelCore: ProcessorCore[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.processorService.getCore().subscribe((data: any) => {
      this.modelCore = data.result;
    });
    this.processorService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(processorAddForm: NgForm): void{
    this.processorService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
