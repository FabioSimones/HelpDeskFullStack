import { Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatTableDataSource } from '@angular/material/table';
import { Tecnico } from 'src/app/models/tecnico';

@Component({
  selector: 'app-tecnico',
  templateUrl: './tecnico.component.html',
  styleUrls: ['./tecnico.component.css']
})
export class TecnicoComponent implements OnInit {

  ELEMENT_DATA: Tecnico[]= [
    {
      id: 1,
      nome: 'Fábio Simones',
      cpf: '123.456.789-10',
      email: 'simones.fabio1994@gmail.com',
      senha: '1234',
      perfis:['0'],
      dataCriacao: '05/04/2025'
    }
  ]

  displayedColumns: string[] = ['position', 'name', 'weight', 'symbol', 'acoes'];
  dataSource = new MatTableDataSource<Tecnico>(this.ELEMENT_DATA);


  constructor(){}

  ngOnInit(): void {
    
  }  

  @ViewChild(MatPaginator) paginator: MatPaginator;

  ngAfterViewInit() {
    this.dataSource.paginator = this.paginator;
  }

}