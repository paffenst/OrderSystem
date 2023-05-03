package de.neuefische.controller;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.service.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ShopController {

    private final ShopService shopService;


    @GetMapping("products")
    public List<Product> listProducts() {
        return shopService.listProducts();
    }

    @GetMapping("products/{id}")
    public Product getProduct(@PathVariable int id) {
        return shopService.getProduct(id);
    }

    @PostMapping("products/")
    public void addProduct(@RequestBody Product product) {
        shopService.addProduct(product);
    }

    @GetMapping("orders")
    public List<Order> listOrders() {
        return shopService.listOrders();
    }

    @GetMapping("orders/{id}")
    public Order getOrder(@PathVariable String id) {
        return shopService.getOrder(id);
    }

    @PostMapping("orders/")
    public void addOrder(@RequestBody List<Integer> productIds) {
        shopService.addOrder(productIds);
    }

}