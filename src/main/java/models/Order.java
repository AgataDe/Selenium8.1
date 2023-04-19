package models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<Product> products;
    private BigDecimal totalOrderPrice = new BigDecimal(0);
    Logger logger = LoggerFactory.getLogger(Order.class);
    BigDecimal shippingPrice = BigDecimal.valueOf(Integer.parseInt(System.getProperty("shipping")));


    public Order() {
        this.products = new ArrayList<>();
    }


    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if (product.getName().equals(productToAdd.getName())) {
                product.updateQuantity(productToAdd.getQuantity());
                logger.info("Update quantity of " + productToAdd);
                totalOrderPrice = totalOrderPrice.add(productToAdd.getTotalPrice());
                return;
            }
        }
        products.add(productToAdd);
        totalOrderPrice = totalOrderPrice.add(productToAdd.getTotalPrice());
        logger.info("Added product " + productToAdd + " to order.");
    }

    public BigDecimal getTotalOrderPrice() {
        BigDecimal totalOrderPrice = new BigDecimal(0);
        for (Product product : getProducts()) {
            totalOrderPrice = totalOrderPrice.add(product.getPrice());
        }
        return totalOrderPrice;
    }

    public BigDecimal getTotalOrderPriceWithShipping() {
        return totalOrderPrice.add(shippingPrice);
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }


    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", totalPrice=" + totalOrderPrice +
                '}';
    }
}
