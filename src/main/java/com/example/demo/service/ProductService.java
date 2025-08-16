package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {

    List<Product> products = new ArrayList<>(Arrays.asList(new Product(101, "Laptop", 65332.98), new Product(102, "Mobile", 45545), new Product(103, "Tablet", 45545)));

    public List<Product> getProducts() {
        return products;
    }

    public Product getProductById(int prodId) {
        for (Product p : products) {
            if (p.getProdId() == prodId) {
                return p;
            }
        }
        return null;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void updateProduct(Product product) {
        for (Product p : products) {
            if (p.getProdId() == product.getProdId()) {
                p.setProdName(product.getProdName());
                p.setProdPrice(product.getProdPrice());
            }
        }
    }

    public void deleteProduct(int prodId) {
        products.removeIf(p -> p.getProdId() == prodId);
    }
}
