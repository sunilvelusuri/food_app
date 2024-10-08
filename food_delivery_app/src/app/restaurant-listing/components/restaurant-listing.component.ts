import { Component } from '@angular/core';
import { Restaurant } from '../../shared-data/models/Restaurant';
import { Route, Router } from '@angular/router';
import { RestaurantService } from '../service/restaurant.service';

@Component({
  selector: 'app-restaurant-listing',
  templateUrl: './restaurant-listing.component.html',
  styleUrl: './restaurant-listing.component.css'
})
export class RestaurantListingComponent {

  public restaurantList: Restaurant[];

  ngOnInit() {
    this.getAllRestaurants();
  }

  constructor(private router: Router, private restaurantService: RestaurantService){}

  getAllRestaurants(){
    this.restaurantService.getAllRestaurants().subscribe(
      data =>{
        this.restaurantList =  data;
      }
    )
  }

  getRandomNumber(min: number, max: number): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

  getRandomImage(): string {
    const imageCount = 8; 
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`; 
  }

  getRandomRating(min: 600, max: 900): number {
    return Math.floor(Math.random() * (max - min + 1)) + min;
  }

//   window.onload = function() {
//     const randomNumber = getRandomRating();
//     document.getElementById('randomNumberSpan').textContent = randomNumber;
// };

  onButtonClick(id: number | undefined) {
    this.router.navigate(['/food-catalouge', id]);
  }

}