import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../layout/navbar/navbar.component";
import { FilmService } from '../../services/film.service';
import { Film } from '../../models/films-model';
import { CommonModule } from '@angular/common';
import { FormControl, FormsModule } from '@angular/forms';
import { LoadingComponent } from "../../shared/loading/loading.component";
import {BaseComponent} from '../../shared/base/base.component';
import {takeUntil} from 'rxjs';

@Component({
  selector: 'app-list-film',
  standalone: true,
  imports: [NavbarComponent, CommonModule, FormsModule, LoadingComponent],
  templateUrl: './list-film.component.html',
  styleUrl: './list-film.component.scss'
})
export class ListFilmComponent extends BaseComponent implements OnInit {

  films: Film[] = [];
  search = '';
  showLoading = false;

  constructor(private filmService: FilmService) {
    super();
  }

  ngOnInit(): void {
    this.getFilms();
  }

  getFilms() {
    this.showLoading = true;
    this.filmService.getFilms().pipe(takeUntil(this.unsubscribe$))
    .subscribe(response => {
      this.films = response;
      this.showLoading = false;
    })
  }


    searchByTitle() {
      this.showLoading = true;
      this.filmService.searchFilmsByTitle(this.search).pipe(takeUntil(this.unsubscribe$)).subscribe(response => {
         this.films = response;
         this.showLoading = false;
      })
    }

}
