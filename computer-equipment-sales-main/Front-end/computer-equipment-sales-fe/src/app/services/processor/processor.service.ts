import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Stock} from '../../model/stock';
import {Processor} from '../../model/processor/processor';
import {ProcessorCore} from '../../model/processor/processor-core';

@Injectable()
export class ProcessorService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/processor/';
  pathCore = 'http://localhost:8080/processorCore/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<Processor[]>{
    return this.http.get<Processor[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getCore(): Observable<ProcessorCore[]>{
    return this.http.get<ProcessorCore[]>(this.pathCore + 'list').pipe(
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

  addProduct(processor: Processor): Observable<Processor>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<Processor>(this.path + 'save', processor, httpOptions).pipe(
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
