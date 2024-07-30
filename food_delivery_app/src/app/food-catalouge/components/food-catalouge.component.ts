// import { Component } from '@angular/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Route, Router } from '@angular/router';
import { FoodItemService } from '../service/fooditem.service';
import { FoodCatalougePage } from '../../shared-data/models/FoodCatalougePage';
import { FoodItem } from '../../shared-data/models/FoodItem';
import { Restaurant } from '../../shared-data/models/Restaurant';

@Component({
  selector: 'app-food-catalouge',
  templateUrl: './food-catalouge.component.html',
  styleUrl: './food-catalouge.component.css'
})


export class FoodCatalougeComponent {

  restaurantId: number;
  foodItemResponse : FoodCatalougePage;
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCatalougePage;

  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router:Router){}
    

  ngOnInit(){

    this.route.paramMap.subscribe(params => {
      // this.restaurantId = +params.get('id');
      this.restaurantId = +(params.get('id') ?? 0)
    });

    this.getFoodItemsByRestaurant(this.restaurantId);
  }
  

  getFoodItemsByRestaurant(restaurant: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurant).subscribe(
      data => {
        this.foodItemResponse = data;
      }
    )
  }


  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (index === -1) {
      this.foodItemCart.push(food);
    } else {
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex(item => item.id === food.id);
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        this.foodItemCart[index] = food;
      }

    }
  }  


  onCheckOut() {
    this.foodItemCart;
    this.orderSummary = {
      foodItemList: [],
      restaurant:{
        id: 1,
        name:"No name",
        address: "No address",
        city: "No data",
        restaurantDescription: "No data"
      }
    }
    this.orderSummary.foodItemList = this.foodItemCart;
    this.orderSummary.restaurant = this.foodItemResponse.restaurant;
    this.router.navigate(['/order-summary'], { queryParams: { data: JSON.stringify(this.orderSummary) } });
  }

}

