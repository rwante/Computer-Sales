import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ProductComponent} from './product/product.component';
import {ComputerCaseComponent} from './computer-case/computer-case.component';
import {ComputerCaseAddFormComponent} from './add-product-form/computer-case-add-form/computer-case-add-form.component';
import {DisplayCardComponent} from './display-card/display-card.component';
import {DisplayCardAddFormComponent} from './add-product-form/display-card-add-form/display-card-add-form.component';
import {HddComponent} from './hdd/hdd.component';
import {HddAddFormComponent} from './add-product-form/hdd-add-form/hdd-add-form.component';
import {LaptopComponent} from './laptop/laptop.component';
import {LaptopAddFormComponent} from './add-product-form/laptop-add-form/laptop-add-form.component';
import {MainboardComponent} from './mainboard/mainboard.component';
import {MainboardAddFormComponent} from './add-product-form/mainboard-add-form/mainboard-add-form.component';
import {MonitorComponent} from './monitor/monitor.component';
import {MonitorAddFormComponent} from './add-product-form/monitor-add-form/monitor-add-form.component';
import {ProcessorComponent} from './processor/processor.component';
import {ProcessorAddFormComponent} from './add-product-form/processor-add-form/processor-add-form.component';
import {RamComponent} from './ram/ram.component';
import {RamAddFormComponent} from './add-product-form/ram-add-form/ram-add-form.component';
import {SsdComponent} from './ssd/ssd.component';
import {SsdAddFormComponent} from './add-product-form/ssd-add-form/ssd-add-form.component';
import {AboutUsComponent} from './about-us/about-us.component';
import {HomeComponent} from './home/home.component';

const routes: Routes = [
  {path: 'home', component: HomeComponent},
  {path: 'products', component: ProductComponent},
  {path: 'computerCase', component: ComputerCaseComponent},
  {path: 'computerCase/add', component: ComputerCaseAddFormComponent},
  {path: 'displayCard', component: DisplayCardComponent},
  {path: 'displayCard/add', component: DisplayCardAddFormComponent},
  {path: 'hdd', component: HddComponent},
  {path: 'hdd/add', component: HddAddFormComponent},
  {path: 'laptop', component: LaptopComponent},
  {path: 'laptop/add', component: LaptopAddFormComponent},
  {path: 'mainboard', component: MainboardComponent},
  {path: 'mainboard/add', component: MainboardAddFormComponent},
  {path: 'monitor', component: MonitorComponent},
  {path: 'monitor/add', component: MonitorAddFormComponent},
  {path: 'processor', component: ProcessorComponent},
  {path: 'processor/add', component: ProcessorAddFormComponent},
  {path: 'ram', component: RamComponent},
  {path: 'ram/add', component: RamAddFormComponent},
  {path: 'ssd', component: SsdComponent},
  {path: 'ssd/add', component: SsdAddFormComponent},
  {path: 'about-us', component: AboutUsComponent},
  {path: '', redirectTo: 'home', pathMatch: 'full'},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
