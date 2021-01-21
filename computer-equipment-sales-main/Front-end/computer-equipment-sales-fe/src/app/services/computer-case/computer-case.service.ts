import { Injectable } from '@angular/core';
import {ComputerCase} from '../../model/computer-case/computer-case';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {tap, catchError} from 'rxjs/operators';
import {ComputerCasePsu} from '../../model/computer-case/computer-case-psu';
import {Stock} from '../../model/stock';

@Injectable()
export class ComputerCaseService {

  constructor(private http: HttpClient) { }
  path = 'http://localhost:8080/computerCase/';
  pathPsu = 'http://localhost:8080/computerCasePSU/';
  pathStock = 'http://localhost:8080/stock/';

  getProducts(): Observable<ComputerCase[]>{
    return this.http.get<ComputerCase[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getPsu(): Observable<ComputerCasePsu[]>{
    return this.http.get<ComputerCasePsu[]>(this.pathPsu + 'list').pipe(
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

  addProduct(computerCase: ComputerCase): Observable<ComputerCase>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<ComputerCase>(this.path + 'save', computerCase, httpOptions).pipe(
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
