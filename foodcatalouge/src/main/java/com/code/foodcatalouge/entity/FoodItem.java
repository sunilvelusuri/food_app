package com.code.foodcatalouge.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "FoodCatalouge")
@Entity
public class FoodItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String itemName;
    private String itemDescription;
    private boolean isVeg;
    private Number price;
    private Integer restaurantId;
    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer quantity;

}
