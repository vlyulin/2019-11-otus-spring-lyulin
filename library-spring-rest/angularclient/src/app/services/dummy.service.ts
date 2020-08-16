import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';

// Сервис для демонстрации работы error.interceptior при Unauthorized доступе 
@Injectable({
  providedIn: 'root'
})
export class DummyService {

  private usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/dummyService';
  }

  public getServiceMessage(): Observable<String> {
      return this.http.get<String>(this.usersUrl);
  }
}
