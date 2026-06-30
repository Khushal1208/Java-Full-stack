package com.khushal.springwebapp.service;

import com.khushal.springwebapp.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ProductService {
    List<Product> products = new ArrayList<>(Arrays.asList(
            new Product(101,"Iphone", 50000),
            new Product(102,"Redmi", 15000),
            new Product(103,"Samsung", 5000),
            new Product(104,"Jio", 500),
            new Product(105,"Nokia", 25000)
            ));
    public List<Product> getProducts() {return products;}

    public Product getProductById(int prodId) {
        return products.stream()
                .filter(p -> p.getProdId() == prodId)
                .findFirst()
                .orElse(new Product(-1, "Product Not Found",0));
    }

    public void addProduct(Product prod){
        products.add(prod);
    }

    public void updateProduct(Product prod) {
        Product p = getProductById(prod.getProdId());
        if(p.getProdId() == -1){
            System.out.println("Product Not Found");
            return;
        }
        p.setProdName(prod.getProdName());
        p.setPrice(prod.getPrice());
    }

    public void deleteProduct(int prodId) {
        products.removeIf(p -> p.getProdId() == prodId);
    }
}
