package models;

import java.math.BigDecimal;


public class Product {
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;


    public Product(String name, BigDecimal price, int quantity, BigDecimal totalPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }


    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice = this.price.multiply(BigDecimal.valueOf(quantity));
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void updateQuantity(int quantity) {
        this.quantity += quantity;
        this.totalPrice = this.price.multiply(BigDecimal.valueOf(quantity));
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
