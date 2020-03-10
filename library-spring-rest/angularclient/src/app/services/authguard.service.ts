import { Injectable } from '@angular/core';
import { Router, CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot } from '@angular/router';
import { HttpClient, HttpHeaders } from '@angular/common/http';

// https://stackoverflow.com/questions/34331478/angular-redirect-to-login-page
@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {

  private isConnectedUrl: string;
  private loginUrl: string;
  private logoffUrl: string;

  private connected: boolean = false;

  constructor(
    private router: Router,
    private http: HttpClient
  ) {
    this.isConnectedUrl = 'http://localhost:8080/isConnected';
    this.loginUrl = 'http://localhost:8080/login/';
    this.logoffUrl = 'http://localhost:8080/logoff';
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot) {
          if (this.connected) return true;
          // not logged in so redirect to login page with the return url
          this.router.navigate(['/users'], { queryParams: { returnUrl: state.url }});
          return false;
      }

  login(userLogin: string) : void {
    this.http.get(this.loginUrl + userLogin).subscribe();
    this.http.get(this.isConnectedUrl).subscribe( val => {
      if(val == true) {
        console.log("Login: connected", val);
        this.connected = true;
        this.router.navigate(['advancedBookSearch']);
      }
      else {
        console.log("Login: Not connected", val);
        this.connected = false;
      }
    });
  }

  logoff() : void {
      this.http.get(this.logoffUrl).subscribe();
      this.connected = false;
    }

}
