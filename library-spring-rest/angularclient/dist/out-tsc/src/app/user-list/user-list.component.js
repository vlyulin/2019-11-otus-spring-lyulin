import { __decorate } from "tslib";
import { Component } from '@angular/core';
let UserListComponent = class UserListComponent {
    constructor(userService, authGuard) {
        this.userService = userService;
        this.authGuard = authGuard;
    }
    ngOnInit() {
        this.userService.findAll().subscribe(data => {
            this.users = data;
        });
    }
    login(userLogin) {
        // this.authGuard.login(userLogin);
    }
};
UserListComponent = __decorate([
    Component({
        selector: 'app-user-list',
        templateUrl: './user-list.component.html',
        styleUrls: ['./user-list.component.css']
    })
], UserListComponent);
export { UserListComponent };
//# sourceMappingURL=user-list.component.js.map