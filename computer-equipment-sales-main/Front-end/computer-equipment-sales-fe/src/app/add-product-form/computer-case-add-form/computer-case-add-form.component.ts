import { Component, OnInit } from '@angular/core';
import {ComputerCase} from '../../model/computer-case/computer-case';
import {ComputerCaseService} from '../../services/computer-case/computer-case.service';
import {ComputerCasePsu} from '../../model/computer-case/computer-case-psu';
import {Stock} from '../../model/stock';
import {NgForm} from '@angular/forms';

@Component({
  selector: 'app-computer-case-add-form',
  templateUrl: './computer-case-add-form.component.html',
  styleUrls: ['./computer-case-add-form.component.css'],
  providers: [ComputerCaseService]
})
export class ComputerCaseAddFormComponent implements OnInit {

  constructor(private computerCaseService: ComputerCaseService) { }
  model: ComputerCase = new ComputerCase();
  modelPsu: ComputerCasePsu[];
  modelStock: Stock[];

  ngOnInit(): void {
    this.computerCaseService.getPsu().subscribe((data: any) => {
      this.modelPsu = data.result;
    });
    this.computerCaseService.getStock().subscribe((data: any) => {
      this.modelStock = data.result;
    });
  }

  add(computerCaseAddForm: NgForm): void{
    this.computerCaseService.addProduct(this.model).subscribe(data => {
      alert('Ürün eklendi.');
    });
  }
}
