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

  findById(id : any): Observable<Tecnico>{
    return this.http.get<Tecnico>(`${Api_Config.baseUrl}/tecnicos/${id}`);
  }

  findAll(): Observable<Tecnico[]>{
    return this.http.get<Tecnico[]>(`${Api_Config.baseUrl}/tecnicos`)
  }

  create(tecnico: Tecnico): Observable<Tecnico>{
    return this.http.post<Tecnico>(`${Api_Config.baseUrl}/tecnicos`, tecnico)
  }

  update(tecnico: Tecnico): Observable<Tecnico>{
    return this.http.put<Tecnico>(`${Api_Config.baseUrl}/tecnicos/${tecnico.id}`, tecnico);
  }

  delete(id: any): Observable<Tecnico>{
    return this.http.delete<Tecnico>(`${Api_Config.baseUrl}/tecnicos/${id}`);
  }
}
