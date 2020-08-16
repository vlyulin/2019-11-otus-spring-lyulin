import { Injectable, SystemJsNgModuleLoader } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { User } from '../models/user';
import { Observable } from 'rxjs';

@Injectable()
export class AuthenticationService {

    private authenticateUrl: string;

    constructor(private http: HttpClient) { 
        this.authenticateUrl = 'http://localhost:8080/users/authenticate';
    }

    login(username: string, password: string) : Observable<User> {
        console.warn("XXX 123 AuthenticationService username = "+username+" password = "+password);
        // this.http.post<User>(this.authenticateUrl, { username: username, password: password }).subscribe( user => {
        //     console.warn("XXX 222 AuthenticationService got user: "+user.name);
        // });

        return this.http.post<User>(this.authenticateUrl, { username: username, password: password })
            .pipe(map(user => {
                console.warn("XXX AuthenticationService got user: "+user.name);
                // login successful if there's a jwt token in the response
                if (user && user.token) {
                    console.warn('XXX get user token: ' + user.token);
                    // store user details and jwt token in local storage to keep user logged in between page refreshes
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                console.warn('XXX AuthenticationService user '+user);
                return user;
            }));
    }

    logout() {
        // remove user from local storage to log user out
        localStorage.removeItem('currentUser');
    }
}