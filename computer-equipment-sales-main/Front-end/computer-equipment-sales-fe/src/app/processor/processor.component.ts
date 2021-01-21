import { Component, OnInit } from '@angular/core';
import {ComputerCaseService} from '../services/computer-case/computer-case.service';
import {ComputerCase} from '../model/computer-case/computer-case';
import {ProcessorService} from '../services/processor/processor.service';
import {Processor} from '../model/processor/processor';

@Component({
  selector: 'app-processor',
  templateUrl: './processor.component.html',
  styleUrls: ['./processor.component.css'],
  providers: [ProcessorService]
})
export class ProcessorComponent implements OnInit {

  constructor(private processorService: ProcessorService) { }
  title = 'Ürün Listesi';
  products: Processor[];
  filterText = '';

  ngOnInit(): void {
    this.processorService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }

}
