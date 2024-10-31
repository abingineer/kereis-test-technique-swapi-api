import { Component, OnInit } from '@angular/core';
import { NavbarComponent } from "../layout/navbar/navbar.component";
import { FilmService } from '../../services/film.service';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [NavbarComponent, RouterLink],
  templateUrl: './home.component.html',
  styleUrl: './home.component.scss'
})
export class HomeComponent {
  menuData = [
    {
      img: 'https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcS6nZAQOeN_ZKjvU6GRBeuwXT4xMMaHwKdil08HN-cvUzuok-U6',
      title: 'Films',
      route: '/films'
    },
    {
      img: 'https://media.gqmagazine.fr/photos/6279335285895dfb1477d88c/16:9/w_1920,c_limit/Saga-Star-Wars.jpg',
      title: 'Personnage',
      route: '/personnage'
    },
    {
      img: 'https://www.sciencesetavenir.fr/assets/img/2012/10/31/images_list-r4x3w1000-57dedf4a830cd-ogle-2005-blg-390lb.jpg',
      title: 'Planètes',
      route: '/planetes'
    },
    {
      img: 'https://img.planete-starwars.com/upload/databank/2/974_trogutas.jpg',
      title: 'Espèces',
      route: '/especes'
    },
    {
      img: 'https://cdn.futura-sciences.com/sources/images/dossier/631/01-intro-631.jpg',
      title: 'Vaisseaux Spatiaux',
      route: '/vaisseaux-spatiaux'
    },
    {
      img: 'https://www.maquettes-papier.net/forumenpapier/images/uploads/ludsidious/031221_videon_interview_119_CR_836.jpg',
      title: 'Véhicules',
      route: '/vehicules'
    }
    
  ]
}
