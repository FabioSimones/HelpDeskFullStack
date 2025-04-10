import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Api_Config } from '../config/api.config';
import { Observable } from 'rxjs';
import { Tecnico } from '../models/tecnico';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {

  constructor(private http: HttpClient) { }

  findAll(): Observable<Tecnico[]>{
    return this.http.get<Tecnico[]>(`${Api_Config.baseUrl}/tecnicos`)
  }
}
