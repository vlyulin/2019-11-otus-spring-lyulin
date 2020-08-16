import { Component, OnInit } from '@angular/core';
import { User } from '../models/user';
import { UserService } from '../services/user.service';
// import { AuthGuard } from '../services/authguard.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {

  users: User[];

  constructor(
    private userService: UserService
    // private authGuard: AuthGuard
  ) { }

  ngOnInit(): void {
    this.userService.findAll().subscribe(data => {
          this.users = data;
        });
  }

  login( userLogin: string ) {
    // this.authGuard.login(userLogin);
  }

}
