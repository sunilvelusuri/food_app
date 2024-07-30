import { FoodItem } from "../../shared-data/models/FoodItem";
import { Restaurant } from "../../shared-data/models/Restaurant";

export interface OrderDTO{

    foodItemList?: FoodItem[];
    userId?: number;
    restaurant?: Restaurant;
}