import { Component, OnInit } from '@angular/core';
import {ComputerCase} from '../model/computer-case/computer-case';
import {DisplayCard} from '../model/display-card/display-card';
import {Hdd} from '../model/hdd/hdd';
import {Laptop} from '../model/laptop/laptop';
import {Mainboard} from '../model/mainboard/mainboard';
import {Monitor} from '../model/monitor/monitor';
import {Processor} from '../model/processor/processor';
import {Ram} from '../model/ram/ram';
import {Ssd} from '../model/ssd/ssd';
import {ComputerCaseService} from '../services/computer-case/computer-case.service';
import {DisplayCardService} from '../services/display-card/display-card.service';
import {HddService} from '../services/hdd/hdd.service';
import {LaptopService} from '../services/laptop/laptop.service';
import {MainboardService} from '../services/mainboard/mainboard.service';
import {MonitorService} from '../services/monitor/monitor.service';
import {ProcessorService} from '../services/processor/processor.service';
import {RamService} from '../services/ram/ram.service';
import {SsdService} from '../services/ssd/ssd.service';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css'],
  providers: [ComputerCaseService, DisplayCardService, HddService, LaptopService, MainboardService,
              MonitorService, ProcessorService, RamService, SsdService]
})
export class ProductComponent implements OnInit {

  constructor(
    private computerCaseService: ComputerCaseService,
    private displayCardService: DisplayCardService,
    private hddService: HddService,
    private laptopService: LaptopService,
    private mainboardService: MainboardService,
    private monitorService: MonitorService,
    private processorService: ProcessorService,
    private ramService: RamService,
    private ssdService: SsdService,
    ) { }
  title = 'Ürün Listesi';
  productsComputerCase: ComputerCase[];
  productsDisplayCard: DisplayCard[];
  productsHdd: Hdd[];
  productsLaptop: Laptop[];
  productsMainboard: Mainboard[];
  productsMonitor: Monitor[];
  productsProcessor: Processor[];
  productsRam: Ram[];
  productsSsd: Ssd[];

  ngOnInit(): void {
    this.computerCaseService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsComputerCase = data.result;
      }
    });
    this.displayCardService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsDisplayCard = data.result;
      }
    });
    this.hddService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsHdd = data.result;
      }
    });
    this.laptopService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsLaptop = data.result;
      }
    });
    this.mainboardService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsMainboard = data.result;
      }
    });
    this.monitorService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsMonitor = data.result;
      }
    });
    this.processorService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsProcessor = data.result;
      }
    });
    this.ramService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsRam = data.result;
      }
    });
    this.ssdService.getProducts().subscribe((data: any) => {
      if (data.result[0] !== undefined) {
        this.productsSsd = data.result;
      }
    });
  }

  addToCard(product): void{
    alert('Sepete Eklendi: ' + product.brand);
  }

}
