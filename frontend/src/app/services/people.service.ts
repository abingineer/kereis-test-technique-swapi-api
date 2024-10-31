import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { People } from '../models/people-model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class PeopleService {


  readonly endpoint = 'people'

  constructor(private http: HttpClient) { 
  }

  getPoeple(): Observable<Array<People>>  {
    return this.http.get<Array<People>>(`${environment.api_base_url}/${this.endpoint}`);
  }

  getPeopleDetailsById(id: number): Observable<People>  {
    return this.http.get<People>(`${environment.api_base_url}/${this.endpoint}/${id}`);
  }

  searchPeopleByName(title: string): Observable<Array<People>>  {
    return this.http.get<Array<People>>(`${environment.api_base_url}/${this.endpoint}/search?name=${title}`
    );
  }
}
