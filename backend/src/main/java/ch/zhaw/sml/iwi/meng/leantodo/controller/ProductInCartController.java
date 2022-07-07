package ch.zhaw.sml.iwi.meng.leantodo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.zhaw.sml.iwi.meng.leantodo.entity.Product;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductInCart;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductInCartRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ProductRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCart;
import ch.zhaw.sml.iwi.meng.leantodo.entity.ShoppingCartRepository;
import ch.zhaw.sml.iwi.meng.leantodo.entity.UserRepository;

@Component
public class ProductInCartController {
    
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductInCartRepository productInCartRepository;

    public void addItem(ProductInCart newProductInCart, Long productId, Long shoppingCartId, int amount) {
        Product product = productRepository.getById(productId);
        newProductInCart.setAmount(amount);
        newProductInCart.setShoppingCartFK(shoppingCartId);
        newProductInCart.setProduct(product);
        productInCartRepository.save(newProductInCart);
    }
}
