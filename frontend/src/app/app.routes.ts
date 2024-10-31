import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home.component';
import { Error404Component } from './pages/error404/error404.component';
import { ListFilmComponent } from './pages/list-film/list-film.component';
import { PeopleComponent } from './pages/people/people.component';
import { PlanetsComponent } from './pages/planets/planets.component';
import { EspecieComponent } from './pages/especie/especie.component';
import { StarshipComponent } from './pages/starship/starship.component';
import { VehiculeComponent } from './pages/vehicule/vehicule.component';

export const routes: Routes = [
    {
        path: '', redirectTo: 'accueil', pathMatch: "full"
    },
    {
        path: 'accueil', component: HomeComponent
    },
    {
        path: 'films', component: ListFilmComponent
    },
    {
        path: 'personnage', component: PeopleComponent
    },
    {
        path: 'planetes', component: PlanetsComponent
    },
    {
        path: 'especes', component: EspecieComponent
    },
    {
        path: 'vaisseaux-spatiaux', component: StarshipComponent
    },
    {
        path: 'vehicules', component: VehiculeComponent
    },
    {
        path: '**', component: Error404Component
    }
];
