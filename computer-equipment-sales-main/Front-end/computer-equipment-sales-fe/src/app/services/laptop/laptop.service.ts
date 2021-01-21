import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Stock} from '../../model/stock';
import {Laptop} from '../../model/laptop/laptop';
import {LaptopGpu} from '../../model/laptop/laptop-gpu';
import {LaptopProcessor} from '../../model/laptop/laptop-processor';
import {LaptopHdd} from '../../model/laptop/laptop-hdd';
import {LaptopRam} from '../../model/laptop/laptop-ram';
import {LaptopSsd} from '../../model/laptop/laptop-ssd';
import {LaptopScreen} from '../../model/laptop/laptop-screen';

@Injectable()
export class LaptopService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/laptop/';
  pathGpu = 'http://localhost:8080/laptopGPU/';
  pathProcessor = 'http://localhost:8080/laptopProcessor/';
  pathHdd = 'http://localhost:8080/laptopHDD/';
  pathRam = 'http://localhost:8080/laptopRAM/';
  pathSsd = 'http://localhost:8080/laptopSSD/';
  pathScreen = 'http://localhost:8080/laptopScreen/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<Laptop[]>{
    return this.http.get<Laptop[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getGpu(): Observable<LaptopGpu[]>{
    return this.http.get<LaptopGpu[]>(this.pathGpu + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getProcessor(): Observable<LaptopProcessor[]>{
    return this.http.get<LaptopProcessor[]>(this.pathProcessor + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getHdd(): Observable<LaptopHdd[]>{
    return this.http.get<LaptopHdd[]>(this.pathHdd + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getRam(): Observable<LaptopRam[]>{
    return this.http.get<LaptopRam[]>(this.pathRam + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getSsd(): Observable<LaptopSsd[]>{
    return this.http.get<LaptopSsd[]>(this.pathSsd + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getScreen(): Observable<LaptopScreen[]>{
    return this.http.get<LaptopScreen[]>(this.pathScreen + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getStock(): Observable<Stock[]>{
    return this.http.get<Stock[]>(this.pathStock + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  addProduct(laptop: Laptop): Observable<Laptop>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<Laptop>(this.path + 'save', laptop, httpOptions).pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  // tslint:disable-next-line:typedef
  handleError(err: HttpErrorResponse){
    let errorMessage = '';
    if (err.error instanceof ErrorEvent){
      errorMessage = 'bir hata oluştu' + err.error.message;
    }else {
      errorMessage = 'Sistemsel bir hata';
    }
    return throwError(errorMessage);
  }
}
