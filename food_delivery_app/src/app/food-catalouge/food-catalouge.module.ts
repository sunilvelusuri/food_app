import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { FoodCatalougeRoutingModule } from './food-catalouge-routing.module';
import { FoodCatalougeComponent } from './components/food-catalouge.component';


@NgModule({
  declarations: [FoodCatalougeComponent],
  imports: [
    CommonModule,
    FoodCatalougeRoutingModule
  ],
  exports:[FoodCatalougeComponent]
})
export class FoodCatalougeModule { }
