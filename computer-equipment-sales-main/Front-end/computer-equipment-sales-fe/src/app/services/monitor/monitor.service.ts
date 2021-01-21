import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {Stock} from '../../model/stock';
import {Monitor} from '../../model/monitor/monitor';
import {MonitorScreen} from '../../model/monitor/monitor-screen';

@Injectable()
export class MonitorService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/monitor/';
  pathScreen = 'http://localhost:8080/monitorScreen/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<Monitor[]>{
    return this.http.get<Monitor[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getScreen(): Observable<MonitorScreen[]>{
    return this.http.get<MonitorScreen[]>(this.pathScreen + 'list').pipe(
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

  addProduct(monitor: Monitor): Observable<Monitor>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<Monitor>(this.path + 'save', monitor, httpOptions).pipe(
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
