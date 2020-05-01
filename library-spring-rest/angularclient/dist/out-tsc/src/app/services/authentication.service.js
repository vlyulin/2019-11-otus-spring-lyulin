import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
import { map } from 'rxjs/operators';
let AuthenticationService = class AuthenticationService {
    constructor(http) {
        this.http = http;
        this.authenticateUrl = 'http://localhost:8080/users/authenticate';
    }
    login(username, password) {
        console.warn("XXX 123 AuthenticationService username = " + username + " password = " + password);
        // this.http.post<User>(this.authenticateUrl, { username: username, password: password }).subscribe( user => {
        //     console.warn("XXX 222 AuthenticationService got user: "+user.name);
        // });
        return this.http.post(this.authenticateUrl, { username: username, password: password })
            .pipe(map(user => {
            console.warn("XXX AuthenticationService got user: " + user.name);
            // login successful if there's a jwt token in the response
            if (user && user.token) {
                console.warn('XXX get user token: ' + user.token);
                // store user details and jwt token in local storage to keep user logged in between page refreshes
                localStorage.setItem('currentUser', JSON.stringify(user));
            }
            console.warn('XXX AuthenticationService user ' + user);
            return user;
        }));
    }
    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
};
AuthenticationService = __decorate([
    Injectable()
], AuthenticationService);
export { AuthenticationService };
//# sourceMappingURL=authentication.service.js.map