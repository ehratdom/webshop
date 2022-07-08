package ch.zhaw.sml.iwi.meng.leantodo.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class ProductInCart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    @ManyToOne
    @JoinColumn(name = "p_id")
    private Product product;

    private Long shoppingCartFK;

    private int amount;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setShoppingCartFK(Long shoppingCartFK) {
        this.shoppingCartFK = shoppingCartFK;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getShoppingCartFK() {
        return shoppingCartFK;
    }
    
}
