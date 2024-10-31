import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { People } from '../models/people-model';
import { Planet } from '../models/planet-model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PlanetsService {

 
    readonly endpoint = 'planets'

  constructor(private http: HttpClient) { 
  }

  findAll(): Observable<Array<Planet>>  {
    return this.http.get<Array<Planet>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getDetails(id: number): Observable<Planet>  {
    return this.http.get<Planet>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  search(title: string): Observable<Array<Planet>>  {
    return this.http.get<Array<Planet>>(`${environment.api_base_url}/${this.endpoint}/search?name=${title}`
    );
  }
}
