import {Injectable} from '@angular/core';
import {Observable} from 'rxjs';
import {timeout} from 'rxjs/operators'; 
import {HttpParams, HttpHeaders ,HttpClient } from '@angular/common/http';
import {Currency } from '../model/Currency'
import {Filter } from '../model/Filter'


@Injectable({
  providedIn: 'root'
})
export class HttpService {

  headers: HttpHeaders = new HttpHeaders();

  url: string = 'http://localhost:9090/api'

  constructor(
      private httpClient: HttpClient
  ) { }


  currencys(): Observable<Currency[] | any> {
    return this.httpClient.get(this.url+'/evaluation/currencys/');
  }

  docs(filter: Filter): Observable<Currency[] | any> {
    return this.httpClient.post(this.url+'/evaluation/docs',filter);
  }
  
}
