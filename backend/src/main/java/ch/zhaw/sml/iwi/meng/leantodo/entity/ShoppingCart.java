package ch.zhaw.sml.iwi.meng.leantodo.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class ShoppingCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String totalPrice;

    @OneToMany(mappedBy="shoppingCartFK")
    private List<ProductInCart> products;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ProductInCart> getProducts() {
        return products;
    }

    public void setProducts(List<ProductInCart> products) {
        this.products = products;
    }
    
}
