import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { PublishingHouse } from '../models/publishing-house';

@Injectable({
  providedIn: 'root'
})
export class PublishingHouseService {

  private publishingHousesUrl: string;
  private getPublishingHouseUrl: string;

  constructor(private http: HttpClient) {
    this.publishingHousesUrl = 'http://localhost:8080/publishingHouses';
    this.getPublishingHouseUrl = 'http://localhost:8080/publishingHouse/';
  }

  public getPublishingHouses() : Observable<PublishingHouse[]>
  {
      return this.http.get<PublishingHouse[]>(this.publishingHousesUrl);
  }

  public getAuthor( publishingHouseId : number | string ) : Observable<PublishingHouse> {
      const url = this.getPublishingHouseUrl + publishingHouseId;
      return this.http.get<PublishingHouse>(url);
  }
}
