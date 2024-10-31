import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Especie } from '../models/especie-model';
import { environment } from '../../environments/environment.development';


@Injectable({
  providedIn: 'root'
})
export class EspecieService {

 
  readonly endpoint = 'especies'

  constructor(private http: HttpClient) { 
  }

  findAll(): Observable<Array<Especie>>  {
    return this.http.get<Array<Especie>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getDetails(id: number): Observable<Especie>  {
    return this.http.get<Especie>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  search(title: string): Observable<Array<Especie>>  {
    return this.http.get<Array<Especie>>(`${environment.api_base_url}/${this.endpoint}/search?name=${title}`
    );
  }
}
