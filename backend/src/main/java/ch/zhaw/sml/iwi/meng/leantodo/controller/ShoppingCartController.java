package ch.zhaw.sml.iwi.meng.leantodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCartRepository;

@Component
public class ShoppingCartController {

    @Autowired
    private ShoppingCartRepository shoppingCartRepository;

    
}
