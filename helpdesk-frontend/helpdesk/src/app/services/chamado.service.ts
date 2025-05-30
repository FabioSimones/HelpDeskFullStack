import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Chamado } from '../models/chamado';
import { Api_Config } from '../config/api.config';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ChamadoService {

  constructor(private http: HttpClient) { }

  findById(id: any): Observable<Chamado>{
    return this.http.get<Chamado>(`${Api_Config.baseUrl}/chamados/${id}`);
  }

  findAll(){
    return this.http.get<Chamado[]>(`${Api_Config.baseUrl}/chamados`);
  }

  create(chamado: Chamado): Observable<Chamado>{
    return this.http.post<Chamado>(`${Api_Config.baseUrl}/chamados`, chamado);
  }

  update(chamado: Chamado): Observable<Chamado>{
    return this.http.put<Chamado>(`${Api_Config.baseUrl}/chamados/${chamado.id}`, chamado);
  }
}
