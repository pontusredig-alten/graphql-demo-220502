package se.iths.graphqldemo220502.entity;

import javax.persistence.*;

@Entity
public class ItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String category;
    private int quantity;
    private double price;
    @ManyToOne
    private UserEntity user;

    public ItemEntity(String name, String category, int quantity, double price, UserEntity user) {
        this.name = name;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
        this.user = user;
    }

    public ItemEntity() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
