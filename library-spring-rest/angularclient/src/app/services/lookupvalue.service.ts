import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { LookupValue } from '../models/lookup-value';

@Injectable({
  providedIn: 'root'
})
export class LookupValueService {

  private lookupValuesUrl: string;

  constructor(private http: HttpClient) {
    this.lookupValuesUrl = 'http://localhost:8080/lookupValues/';
  }

  public getLookupValues(language: String) : Observable<LookupValue[]>
  {
    return this.http.get<LookupValue[]>(this.lookupValuesUrl+language);
  }
}
