import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Title } from '@angular/platform-browser';
import { Observable } from 'rxjs';
import { Film

  
 } from '../models/films-model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  
  readonly endpoint = 'films';

  constructor(private http: HttpClient) { 
  }

  getFilms(): Observable<Array<Film>>  {
    return this.http.get<Array<Film>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getFilmDetailsById(id: number): Observable<Film>  {
    return this.http.get<Film>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  searchFilmsByTitle(title: string): Observable<Array<Film>>  {
    return this.http.get<Array<Film>>(`${environment.api_base_url}/${this.endpoint}/search?title=${title}`
    );
  }
}
