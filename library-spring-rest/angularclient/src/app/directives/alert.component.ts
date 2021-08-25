import { Component, OnInit, OnDestroy } from '@angular/core';
import { Subscription, Subject } from 'rxjs';

import { AlertService } from '../services/alert.service';

@Component({
    selector: 'alert-message',
    templateUrl: './alert.component.html'
})
export class AlertComponent implements OnInit, OnDestroy {
    private subscription: Subscription;
    message: any;

    constructor(private alertService: AlertService) { }

    ngOnInit() {
        this.message = new Subject<any>();
        this.message.type = 'error';
        this.message.text = 'Alert извещение пока не работает!'; // delete  

        // Не работает получения messages
        // this.subscription = this.alertService.getMessage().subscribe(message => { 
        //     this.message = message; 
        // });
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }
}
