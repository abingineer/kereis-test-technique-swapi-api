import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../layout/navbar/navbar.component';
import { Especie } from '../../models/especie-model';
import { EspecieService } from '../../services/especie.service';
import { LoadingComponent } from '../../shared/loading/loading.component';
import {Subject, takeUntil} from 'rxjs';
import {BaseComponent} from '../../shared/base/base.component';

@Component({
  selector: 'app-especie',
  standalone: true,
  imports: [NavbarComponent, FormsModule, CommonModule, LoadingComponent],
  templateUrl: './especie.component.html',
  styleUrl: './especie.component.scss'
})
export class EspecieComponent extends BaseComponent implements OnInit {

  especes: Especie[] = [];
  searchInput = '';
  showLoading = false;
  constructor(private especieService: EspecieService) {
    super();
  }
  ngOnInit(): void {
    this.getEspecies();
  }

  getEspecies(){
    this.showLoading = true;
    this.especieService.findAll().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.especes = response;
      this.showLoading = false;
    })
  }

    search() {
      this.showLoading = true;
      this.especieService.search(this.searchInput).pipe(takeUntil(this.unsubscribe$)).subscribe(response => {
         this.especes = response;
         this.showLoading = false;
      })
    }


}
