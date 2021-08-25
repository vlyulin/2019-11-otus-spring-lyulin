import { Component, OnInit } from '@angular/core';
import { DummyService } from '../services/dummy.service';

@Component({
  selector: 'app-dummy',
  templateUrl: './dummy.component.html',
  styleUrls: ['./dummy.component.css']
})
export class DummyComponent implements OnInit {

  dummyMessage: String;

  constructor(
    private dummyService: DummyService
  ) { }

  ngOnInit(): void {
	this.dummyService.getServiceMessage().subscribe(data => {
          this.dummyMessage = data;
        });
  }

}
