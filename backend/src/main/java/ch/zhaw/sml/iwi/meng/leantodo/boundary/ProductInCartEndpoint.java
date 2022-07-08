package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.ProductController;
import ch.zhaw.sml.iwi.meng.leantodo.controller.ProductInCartController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Product;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductInCart;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductInCartRepository;

@RestController
public class ProductInCartEndpoint {
    
    @Autowired
    private ProductInCartController productInCartController;

    @Autowired
    private ProductInCartRepository productInCartRepository;
    
    @Autowired
    private ProductController productController;

    @RequestMapping(path = "/api/newitem/{id}", method = RequestMethod.POST)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void addItem(@PathVariable(name="id", required=false) Long productId, @RequestBody ProductInCart newProductInCart, Principal principal) {
        //long productId3 = productId;
        //Long productId2 = new Long(productId3);
        productInCartController.addItem(newProductInCart, productId, 10L, 1);
    }

    @RequestMapping(path = "/api/deleteitem/{id}", method = RequestMethod.DELETE)
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public void deleteItem(@PathVariable(name="id", required=false) Long productInCartId, /*@RequestBody ProductInCart productInCart, */Principal principal) {
        productInCartController.deleteItem(productInCartId);
    }

}
