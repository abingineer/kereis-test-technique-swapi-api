import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../layout/navbar/navbar.component";
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { People } from '../../models/people-model';
import { PeopleService } from '../../services/people.service';
import { LoadingComponent } from "../../shared/loading/loading.component";
import {BaseComponent} from '../../shared/base/base.component';
import {takeUntil} from 'rxjs';

@Component({
  selector: 'app-people',
  standalone: true,
  imports: [NavbarComponent, FormsModule, CommonModule, LoadingComponent],
  templateUrl: './people.component.html',
  styleUrl: './people.component.scss'
})
export class PeopleComponent extends BaseComponent implements OnInit {

  people: People[] = [];
  searchInput = '';
  showLoading = false;
  constructor(private peopleService: PeopleService) {
    super();}

  ngOnInit(): void {
    this.getPeople();
  }

  getPeople() {
    this.showLoading = true;
    this.peopleService.getPoeple().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.people = response;
       this.showLoading = false;
    })
  }

    search() {
      console.log(this.search);

      this.peopleService.searchPeopleByName(this.searchInput).pipe(takeUntil(this.unsubscribe$)).subscribe(response => {
         this.people = response;
         console.log("response", response);

      })
    }


}
