import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
// import { HttpClient, HttpHeaders } from '@angular/common/http';
// https://stackoverflow.com/questions/34331478/angular-redirect-to-login-page
// Angular 2/5 User Registration and Login Example & Tutorial
// https://jasonwatmore.com/post/2016/09/29/angular-2-user-registration-and-login-example-tutorial
// Protecting Routes using Guards in Angular
// https://blog.thoughtram.io/angular/2016/07/18/guards-in-angular-2.html
// @Injectable({
//   providedIn: 'root'
// })
let AuthGuard = class AuthGuard {
    // private isConnectedUrl: string;
    // private loginUrl: string;
    // private logoffUrl: string;
    // private connected: boolean = false;
    // constructor(
    //   private router: Router,
    //   private http: HttpClient
    // ) {
    //   this.isConnectedUrl = 'http://localhost:8080/isConnected';
    //   this.loginUrl = 'http://localhost:8080/login/';
    //   this.logoffUrl = 'http://localhost:8080/logoff';
    // }
    constructor(router) {
        this.router = router;
    }
    canActivate(route, state) {
        return true; // del
        if (localStorage.getItem('currentUser')) {
            // logged in so return true
            return true;
        }
        // not logged in so redirect to login page with the return url
        console.warn('XXX state.url = [' + state.url + ']');
        this.router.navigate(['/login'], { queryParams: { returnUrl: state.url } });
        return false;
    }
};
AuthGuard = __decorate([
    Injectable()
], AuthGuard);
export { AuthGuard };
//# sourceMappingURL=authguard.service.js.map