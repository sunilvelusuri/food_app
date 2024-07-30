import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { HeaderModule } from './header/header.module';
import { AppRoutingModule } from './app-routing.module';
import { RestaurantListingModule } from './restaurant-listing/restaurant-listing.module';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FoodCatalougeModule } from './food-catalouge/food-catalouge.module';


@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HeaderModule,
    RestaurantListingModule,
    HttpClientModule,
    FoodCatalougeModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }