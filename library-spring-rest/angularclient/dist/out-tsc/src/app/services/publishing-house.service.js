import { __decorate } from "tslib";
import { Injectable } from '@angular/core';
let PublishingHouseService = class PublishingHouseService {
    constructor(http) {
        this.http = http;
        this.publishingHousesUrl = 'http://localhost:8080/publishingHouses';
        this.getPublishingHouseUrl = 'http://localhost:8080/publishingHouse/';
    }
    getPublishingHouses() {
        return this.http.get(this.publishingHousesUrl);
    }
    getAuthor(publishingHouseId) {
        const url = this.getPublishingHouseUrl + publishingHouseId;
        return this.http.get(url);
    }
};
PublishingHouseService = __decorate([
    Injectable({
        providedIn: 'root'
    })
], PublishingHouseService);
export { PublishingHouseService };
//# sourceMappingURL=publishing-house.service.js.map