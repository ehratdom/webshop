package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.ShoppingCartController;

@RestController
public class ShoppingCartEndpoint {

    @Autowired
    private ShoppingCartController shoppingCartController;

    
}
