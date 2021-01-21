import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from '@angular/common/http';
import {Observable, throwError} from 'rxjs';
import {catchError, tap} from 'rxjs/operators';
import {DisplayCard} from '../../model/display-card/display-card';
import {DisplayCardGpu} from '../../model/display-card/display-card-gpu';
import {DisplayCardMemory} from '../../model/display-card/display-card-memory';
import {Stock} from '../../model/stock';

@Injectable()
export class DisplayCardService {

  constructor(private http: HttpClient) { }

  path = 'http://localhost:8080/displayCard/';
  pathGPU = 'http://localhost:8080/displayCardGPU/';
  pathMemory = 'http://localhost:8080/displayCardMemory/';
  pathStock = 'http://localhost:8080/stock/';
  getProducts(): Observable<DisplayCard[]>{
    return this.http.get<DisplayCard[]>(this.path + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getGPU(): Observable<DisplayCardGpu[]>{
    return this.http.get<DisplayCardGpu[]>(this.pathGPU + 'list').pipe(
      tap(data => console.log(JSON.stringify(data))),
      catchError(this.handleError)
    );
  }

  getMemory(): Observable<DisplayCardMemory[]>{
    return this.http.get<DisplayCardMemory[]>(this.pathMemory + 'list').pipe(
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

  addProduct(displayCard: DisplayCard): Observable<DisplayCard>{
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        Authorization: 'Token'
      })
    };
    return this.http.post<DisplayCard>(this.path + 'save', displayCard, httpOptions).pipe(
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
