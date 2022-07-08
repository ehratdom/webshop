package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ch.zhaw.sml.iwi.meng.leantodo.controller.ProductInCartController;

@RestController
public class ProductInCartEndpoint {
    
    @Autowired
    private ProductInCartController productInCartController;

    @RequestMapping(path = "/api/newitem/{id}", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void addItem(@PathVariable Long id, /*@RequestBody ProductInCart newProductInCart, */Principal principal) {
        //long productId3 = productId;
        //Long productId2 = new Long(productId3);
        productInCartController.addItem(id, 10L, 1);
    }

    @RequestMapping(path = "/api/deleteitem/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void deleteItem(@PathVariable Long id, /*@RequestBody ProductInCart productInCart, */Principal principal) {
        productInCartController.deleteItem(id);
    }
}

