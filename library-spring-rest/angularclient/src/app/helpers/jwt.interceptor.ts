import { Injectable } from '@angular/core';
import { HttpRequest, HttpHandler, HttpEvent, HttpInterceptor } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class JwtInterceptor implements HttpInterceptor {
    intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        // add authorization header with jwt token if available
        console.warn('XXX Enter JwtInterceptor');
        
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        console.warn('XXX Enter JwtInterceptor currentUser: ' + currentUser);
        
        if (currentUser && currentUser.token) {
            console.warn("XXX JwtInterceptor: "+currentUser.token);
            request = request.clone({
                setHeaders: { 
                    Authorization: `Bearer ${currentUser.token}`
                }
            });
        }

        return next.handle(request);
    }
}
