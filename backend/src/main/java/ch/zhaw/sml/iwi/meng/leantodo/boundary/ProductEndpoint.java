package ch.zhaw.sml.iwi.meng.leantodo.boundary;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ch.zhaw.sml.iwi.meng.leantodo.controller.ProductController;
import ch.zhaw.sml.iwi.meng.leantodo.entity.Product;

@RestController
public class ProductEndpoint {
    
    @Autowired
    private ProductController productController;

    @RequestMapping(path = "/api/products", method = RequestMethod.GET, produces = "application/json")
    @PreAuthorize("isAuthenticated() AND hasRole('USER')")
    public List<Product> me(Principal principal) {
        return productController.listAllProducts();
    }
}
