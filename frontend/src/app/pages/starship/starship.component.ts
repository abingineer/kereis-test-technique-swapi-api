import { Component, OnInit } from '@angular/core';
import { Especie } from '../../models/especie-model';
import { EspecieService } from '../../services/especie.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../layout/navbar/navbar.component';
import { StarshipService } from '../../services/starship.service';
import { Starship } from '../../models/starship-model';
import { LoadingComponent } from "../../shared/loading/loading.component";
import {BaseComponent} from '../../shared/base/base.component';
import {takeUntil} from 'rxjs';

@Component({
  selector: 'app-starship',
  standalone: true,
  imports: [NavbarComponent, FormsModule, CommonModule, LoadingComponent],
  templateUrl: './starship.component.html',
  styleUrl: './starship.component.scss'
})
export class StarshipComponent extends BaseComponent implements OnInit {

  starships: Starship[] = [];
  searchInput = '';
  showLoading = false;
  constructor(private starshipService: StarshipService) {
    super();}

  ngOnInit(): void {
    this.getStarships();
  }

  getStarships(){
    this.showLoading = true;
    this.starshipService.findAll().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.starships = response;
      this.showLoading = false;
    })
  }

    search() {
      this.showLoading = true;
      this.starshipService.search(this.searchInput).pipe(takeUntil(this.unsubscribe$)).subscribe(response => {
         this.starships = response;
         this.showLoading = false;
      })
    }


}
