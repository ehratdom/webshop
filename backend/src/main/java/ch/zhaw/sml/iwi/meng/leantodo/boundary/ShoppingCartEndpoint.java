package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.ShoppingCartController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCart;

@RestController
public class ShoppingCartEndpoint {

    @Autowired
    private ShoppingCartController ShoppingCartController;

    
}
