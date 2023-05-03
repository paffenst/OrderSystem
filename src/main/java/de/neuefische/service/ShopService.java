package de.neuefische.service;

import de.neuefische.model.Order;
import de.neuefische.model.Product;
import de.neuefische.repo.OrderRepo;
import de.neuefische.repo.ProductRepo;

import java.util.*;

public class ShopService {
    private final ProductRepo productRepo;
    private final OrderRepo orderRepo;
    public ShopService(ProductRepo productRepo, OrderRepo orderRepo) {
        this.productRepo = productRepo;
        this.orderRepo = orderRepo;
    }

    public Product getProduct(int id) {
        return productRepo.getProduct(id);
    }

    public Order getOrder(int orderId) {
        return orderRepo.getOrder(orderId);
    }

    public void addOrder(int orderId, List<Integer> productIds) {
        List<Product> products = new ArrayList<>();
        for (int productId : productIds) {
            Product product = productRepo.getProduct(productId);
            products.add(product);
        }

        Order order = new Order(orderId, products);
        orderRepo.addOrder(order);
    }
    public List<Product> listProducts() {
        return productRepo.listProducts();
    }
    public List<Order> listOrders() {
        return orderRepo.listOrders();
    }

}