import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NavComponent } from './components/nav/nav.component';
import { HomeComponent } from './components/home/home.component';
import { TecnicoComponent } from './components/tecnico/tecnico.component';
import { LoginComponent } from './components/login/login.component';
import { AuthGuard } from './auth/auth.guard';
import { TecnicoCreateComponent } from './components/tecnico/tecnico-create/tecnico-create.component';

const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path:'',
    component: NavComponent,
    canActivate:[AuthGuard],
    children:[
      {
        path: 'home',
        component: HomeComponent
      },
      {
        path:'tecnicos',
        component: TecnicoComponent
      },
      {
        path:'tecnicos/create',
        component: TecnicoCreateComponent
      }
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
