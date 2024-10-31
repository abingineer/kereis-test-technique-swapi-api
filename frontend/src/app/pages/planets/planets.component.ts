import { Component, OnInit } from '@angular/core';
import { Planet } from '../../models/planet-model';
import { PlanetsService } from '../../services/planets.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../layout/navbar/navbar.component';
import { LoadingComponent } from "../../shared/loading/loading.component";
import {BaseComponent} from '../../shared/base/base.component';
import {takeUntil} from 'rxjs';

@Component({
  selector: 'app-planets',
  standalone: true,
  imports: [NavbarComponent, FormsModule, CommonModule, LoadingComponent],
  templateUrl: './planets.component.html',
  styleUrl: './planets.component.scss'
})
export class PlanetsComponent extends BaseComponent implements OnInit {

  planets: Planet[] = [];
  searchInput = '';
  showLoading = false;
  constructor(private planetService: PlanetsService) {
    super();}

  ngOnInit(): void {
    this.getPlanets();
  }
  getPlanets() {
    this.showLoading = true;
    this.planetService.findAll().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.planets = response;
      this.showLoading = false;
    })
  }

    search() {
      this.planetService.search(this.searchInput)
        .pipe(takeUntil(this.unsubscribe$))
        .subscribe(response => {
         this.planets = response;

      })
    }


}
