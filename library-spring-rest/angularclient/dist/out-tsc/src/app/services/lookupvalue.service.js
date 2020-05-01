import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let LookupValueService = class LookupValueService {
    constructor(http) {
        this.http = http;
        this.lookupValuesUrl = 'http://localhost:8080/lookupValues/';
    }
    getLookupValues(language) {
        return this.http.get(this.lookupValuesUrl + language);
    }
};
LookupValueService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], LookupValueService);
export { LookupValueService };
//# sourceMappingURL=lookupvalue.service.js.map