import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Stock} from '../../model/stock';
import {Ssd} from '../../model/ssd/ssd';

@Injectable()
export class SsdService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/ssd/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<Ssd[]>{
    return this.http.get<Ssd[]>(this.path + 'list').pipe(
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

  addProduct(ssd: Ssd): Observable<Ssd>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<Ssd>(this.path + 'save', ssd, httpOptions).pipe(
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
