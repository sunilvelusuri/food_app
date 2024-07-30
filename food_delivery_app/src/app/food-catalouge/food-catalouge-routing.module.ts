import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FoodCatalougeComponent } from './components/food-catalouge.component';

const routes: Routes = [
  { path: 'food-catalouge/:id', component: FoodCatalougeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class FoodCatalougeRoutingModule { }
