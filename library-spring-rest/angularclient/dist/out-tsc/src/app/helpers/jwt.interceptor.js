import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let JwtInterceptor = class JwtInterceptor {
    intercept(request, next) {
        // add authorization header with jwt token if available
        console.warn('XXX Enter JwtInterceptor');
        let currentUser = JSON.parse(localStorage.getItem('currentUser'));
        console.warn('XXX Enter JwtInterceptor currentUser: ' + currentUser);
        if (currentUser && currentUser.token) {
            console.warn("XXX JwtInterceptor: " + currentUser.token);
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${currentUser.token}`
                }
            });
        }
        return next.handle(request);
    }
};
JwtInterceptor = __decorate([
    Injectable()
], JwtInterceptor);
export { JwtInterceptor };
//# sourceMappingURL=jwt.interceptor.js.map