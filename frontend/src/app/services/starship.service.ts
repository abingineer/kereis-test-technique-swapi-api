import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Planet } from '../models/planet-model';
import { Starship } from '../models/starship-model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class StarshipService {

  readonly endpoint = 'starships';

  constructor(private http: HttpClient) { 
  }

  findAll(): Observable<Array<Starship>>  {
    return this.http.get<Array<Starship>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getDetails(id: number): Observable<Starship>  {
    return this.http.get<Starship>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  search(title: string): Observable<Array<Starship>>  {
    return this.http.get<Array<Starship>>(`${environment.api_base_url}/${this.endpoint}/search?name=${title}`
    );
  }
}