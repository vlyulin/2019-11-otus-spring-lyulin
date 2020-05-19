import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { LocalStorageService, SessionStorageService } from 'ngx-webstorage';

import { SERVER_API_URL } from 'app/app.constants';
import { Login } from 'app/core/login/login.model';

type JwtToken = {
  id_token: string;
};

@Injectable({ providedIn: 'root' })
export class AuthServerProvider {
  constructor(private http: HttpClient, private $localStorage: LocalStorageService, private $sessionStorage: SessionStorageService) {}

  getToken(): string {
    return this.$localStorage.retrieve('authenticationToken') || this.$sessionStorage.retrieve('authenticationToken') || '';
  }

  login(credentials: Login): Observable<void> {
    return this.http
      .post<JwtToken>(SERVER_API_URL + 'api/authenticate', credentials)
      .pipe(map(response => this.authenticateSuccess(response, credentials.oracletoken, credentials.rememberMe))); // VL

    // VL пытался разобраться с jsonp
    // const tokenUrl = "https://egxt-dev4.fa.em2.oraclecloud.com/fscmRestApi/tokenrelay";
    // return this.http.jsonp<JwtToken>(tokenUrl, 'callback')
    //     .pipe(map( data => {
    //         console.warn('XXX: ' + data);
    //         return this.authenticateSuccess(data, credentials.rememberMe);
    //     }));
  }

  logout(): Observable<void> {
    return new Observable(observer => {
      this.$localStorage.clear('authenticationToken');
      this.$sessionStorage.clear('authenticationToken');
      observer.complete();
    });
  }

  private authenticateSuccess(response: JwtToken, oracletoken: string, rememberMe: boolean): void { // VL
    const jwt = response.id_token;
    if (rememberMe) {
      this.$localStorage.store('authenticationToken', jwt);
      this.$localStorage.store('oracletoken',oracletoken); // VL
    } else {
      this.$sessionStorage.store('authenticationToken', jwt);
      this.$sessionStorage.store('oracletoken',oracletoken);
    }
  }
}
