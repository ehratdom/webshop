package ch.zhaw.sml.iwi.meng.leantodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductInCartRepository;

@Component
public class ProductInCartController {
    
    @Autowired
    private ProductInCartRepository productInCartRepository;

}
