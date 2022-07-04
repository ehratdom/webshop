package ch.zhaw.sml.iwi.meng.leantodo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Product;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductRepository;

@Component
public class ProductController {


    @Autowired
    private ProductRepository productRepository;

    public List<Product> listAllProducts(String name) {
        return productRepository.findAll();
    }
    
}
