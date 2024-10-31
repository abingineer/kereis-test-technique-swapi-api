import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Starship } from '../models/starship-model';
import { Vehicle } from '../models/vehicle-model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class VehiculeService {

  
  readonly endpoint = 'vehicles';

  constructor(private http: HttpClient) { 
  }

  findAll(): Observable<Array<Vehicle>>  {
    return this.http.get<Array<Vehicle>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getDetails(id: number): Observable<Vehicle>  {
    return this.http.get<Vehicle>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  search(title: string): Observable<Array<Vehicle>>  {
    return this.http.get<Array<Vehicle>>(`${environment.api_base_url}/${this.endpoint}/search?name=${title}`
    );
  }
}