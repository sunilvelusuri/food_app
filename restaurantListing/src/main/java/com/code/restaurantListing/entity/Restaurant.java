package com.code.restaurantListing.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor          // for getting all restaurants
@Table(name = "Restaurant")
@Entity
@EnableDiscoveryClient
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
    private String restaurantDescription;

}
