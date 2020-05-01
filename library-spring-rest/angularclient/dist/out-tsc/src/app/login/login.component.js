import { __decorate } from "tslib";
import { Component } from '@angular/core';
import { Validators } from '@angular/forms';
import { first } from 'rxjs/operators';
// https://jasonwatmore.com/post/2018/05/16/angular-6-user-registration-and-login-example-tutorial
let LoginComponent = class LoginComponent {
    // private alertService: AlertService
    constructor(formBuilder, route, router, authenticationService) {
        this.formBuilder = formBuilder;
        this.route = route;
        this.router = router;
        this.authenticationService = authenticationService;
        this.loading = false;
        this.submitted = false;
    }
    ngOnInit() {
        this.loginForm = this.formBuilder.group({
            username: ['', Validators.required],
            password: ['', Validators.required]
        });
        // reset login status
        this.authenticationService.logout();
        // get return url from route parameters or default to '/'
        this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    }
    // convenience getter for easy access to form fields
    get f() { return this.loginForm.controls; }
    onSubmit() {
        this.submitted = true;
        // stop here if form is invalid
        if (this.loginForm.invalid) {
            return;
        }
        this.loading = true;
        this.authenticationService.login(this.f.username.value, this.f.password.value)
            .pipe(first())
            .subscribe(data => {
            console.warn('XXX LoginComponent navigate to ' + this.returnUrl);
            this.router.navigate([this.returnUrl]);
        }, error => {
            // this.alertService.error(error);
            this.loading = false;
        });
    }
};
LoginComponent = __decorate([
    Component({
        // moduleId: module.id,
        templateUrl: 'login.component.html'
    })
], LoginComponent);
export { LoginComponent };
//# sourceMappingURL=login.component.js.map