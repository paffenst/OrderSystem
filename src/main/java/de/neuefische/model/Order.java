package de.neuefische.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private List<Product> products;

}