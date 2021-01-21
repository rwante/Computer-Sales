import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { CategoryComponent } from './category/category.component';
import { ComputerCaseComponent } from './computer-case/computer-case.component';
import { ProductComponent } from './product/product.component';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { ComputerCaseAddFormComponent } from './add-product-form/computer-case-add-form/computer-case-add-form.component';
import { DisplayCardComponent } from './display-card/display-card.component';
import { DisplayCardAddFormComponent } from './add-product-form/display-card-add-form/display-card-add-form.component';
import { HddComponent } from './hdd/hdd.component';
import { HddAddFormComponent } from './add-product-form/hdd-add-form/hdd-add-form.component';
import { LaptopAddFormComponent } from './add-product-form/laptop-add-form/laptop-add-form.component';
import { LaptopComponent } from './laptop/laptop.component';
import { MainboardComponent } from './mainboard/mainboard.component';
import { MainboardAddFormComponent } from './add-product-form/mainboard-add-form/mainboard-add-form.component';
import { MonitorAddFormComponent } from './add-product-form/monitor-add-form/monitor-add-form.component';
import { MonitorComponent } from './monitor/monitor.component';
import { ProcessorComponent } from './processor/processor.component';
import { ProcessorAddFormComponent } from './add-product-form/processor-add-form/processor-add-form.component';
import { RamAddFormComponent } from './add-product-form/ram-add-form/ram-add-form.component';
import { RamComponent } from './ram/ram.component';
import { SsdComponent } from './ssd/ssd.component';
import { SsdAddFormComponent } from './add-product-form/ssd-add-form/ssd-add-form.component';
import { AboutUsComponent } from './about-us/about-us.component';
import { ComputerCaseFilterPipe } from './computer-case/filter/computer-case-filter.pipe';
import { DisplayCardFilterPipe } from './display-card/filter/display-card-filter.pipe';
import { HddFilterPipe } from './hdd/filter/hdd-filter.pipe';
import { LaptopFilterPipe } from './laptop/filter/laptop-filter.pipe';
import { MainboardFilterPipe } from './mainboard/filter/mainboard-filter.pipe';
import { MonitorFilterPipe } from './monitor/filter/monitor-filter.pipe';
import { ProcessorFilterPipe } from './processor/filter/processor-filter.pipe';
import { RamFilterPipe } from './ram/filter/ram-filter.pipe';
import { SsdFilterPipe } from './ssd/filter/ssd-filter.pipe';
import { HomeComponent } from './home/home.component';
@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CategoryComponent,
    ComputerCaseComponent,
    ProductComponent,
    ComputerCaseAddFormComponent,
    DisplayCardComponent,
    DisplayCardAddFormComponent,
    HddComponent,
    HddAddFormComponent,
    LaptopAddFormComponent,
    LaptopComponent,
    MainboardComponent,
    MainboardAddFormComponent,
    MonitorAddFormComponent,
    MonitorComponent,
    ProcessorComponent,
    ProcessorAddFormComponent,
    RamAddFormComponent,
    RamComponent,
    SsdComponent,
    SsdAddFormComponent,
    AboutUsComponent,
    ComputerCaseFilterPipe,
    DisplayCardFilterPipe,
    HddFilterPipe,
    LaptopFilterPipe,
    MainboardFilterPipe,
    MonitorFilterPipe,
    ProcessorFilterPipe,
    RamFilterPipe,
    SsdFilterPipe,
    HomeComponent,
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        FormsModule,
        HttpClientModule,
        NgbModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
