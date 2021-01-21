import { Component, OnInit } from '@angular/core';
import {ComputerCase} from '../model/computer-case/computer-case';
import {ComputerCaseService} from '../services/computer-case/computer-case.service';

@Component({
  selector: 'app-computer-case',
  templateUrl: './computer-case.component.html',
  styleUrls: ['./computer-case.component.css'],
  providers: [ComputerCaseService]
})

export class ComputerCaseComponent implements OnInit {

  constructor(private computerCaseService: ComputerCaseService) { }
  title = 'Ürün Listesi';
  products: ComputerCase[];
  filterText = '';
  ngOnInit(): void {
    this.computerCaseService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.products = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.productCode);
  }
}
