import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Stock} from '../../model/stock';
import {Mainboard} from '../../model/mainboard/mainboard';
import {MainboardRam} from '../../model/mainboard/mainboard-ram';

@Injectable()
export class MainboardService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/mainboard/';
  pathRam = 'http://localhost:8080/mainboardRAM/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<Mainboard[]>{
    return this.http.get<Mainboard[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getRam(): Observable<MainboardRam[]>{
    return this.http.get<MainboardRam[]>(this.pathRam + 'list').pipe(
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

  addProduct(mainboard: Mainboard): Observable<Mainboard>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<Mainboard>(this.path + 'save', mainboard, httpOptions).pipe(
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
