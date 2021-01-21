import { Component, OnInit } from '@angular/core';
import {Category} from '../model/category';

@Component({
  selector: 'app-category',
  templateUrl: './category.component.html',
  styleUrls: ['./category.component.css']
})
export class CategoryComponent implements OnInit {

  constructor() { }
  title =  'Kategoriler';
  categories: Category[] = [
    {id : 1, name : 'Laptop'},
    {id : 2, name : 'Bilgisayar Kasası'},
    {id : 3, name : 'Ekran Kartı'},
    {id : 4, name : 'Hard Disk'},
    {id : 5, name : 'Ana Kart'},
    {id : 6, name : 'Monitör'},
    {id : 7, name : 'İşlemci'},
    {id : 8, name : 'RAM'},
    {id : 9, name : 'SSD'},
  ];

  ngOnInit(): void {
  }

}
