import { Cliente } from './../models/cliente';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Api_Config } from '../config/api.config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private http: HttpClient) { }

  findById(id : any): Observable<Cliente>{
    return this.http.get<Cliente>(`${Api_Config.baseUrl}/clientes/${id}`);
  }

  findAll(): Observable<Cliente[]>{
    return this.http.get<Cliente[]>(`${Api_Config.baseUrl}/clientes`)
  }

  create(cliente: Cliente): Observable<Cliente>{
    return this.http.post<Cliente>(`${Api_Config.baseUrl}/clientes`, cliente)
  }

  update(cliente: Cliente): Observable<Cliente>{
    return this.http.put<Cliente>(`${Api_Config.baseUrl}/clientes/${cliente.id}`, cliente);
  }

  delete(id: any): Observable<Cliente>{
    return this.http.delete<Cliente>(`${Api_Config.baseUrl}/clientes/${id}`);
  }
}
