import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { NavbarComponent } from '../layout/navbar/navbar.component';
import { Especie } from '../../models/especie-model';
import { EspecieService } from '../../services/especie.service';
import { Vehicle } from '../../models/vehicle-model';
import { VehiculeService } from '../../services/vehicule.service';
import { LoadingComponent } from "../../shared/loading/loading.component";
import {BaseComponent} from '../../shared/base/base.component';
import {takeUntil} from 'rxjs';

@Component({
  selector: 'app-vehicule',
  standalone: true,
  imports: [NavbarComponent, FormsModule, CommonModule, LoadingComponent],
  templateUrl: './vehicule.component.html',
  styleUrl: './vehicule.component.scss'
})
export class VehiculeComponent extends BaseComponent implements OnInit {

  vehicules: Vehicle[] = [];
  searchInput = '';
  showLoading = false;
  constructor(private vehicleService: VehiculeService) {
    super();}

  ngOnInit(): void {
    this.getEspecies();
  }

  getEspecies(){
    this.showLoading = true;
    this.vehicleService.findAll().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.vehicules = response;
      this.showLoading = false;
    })
  }

    search() {
      this.showLoading = true;
      this.vehicleService.search(this.searchInput).pipe(takeUntil(this.unsubscribe$)).subscribe(response => {
         this.vehicules = response;
         this.showLoading = false;
      })
    }


}
