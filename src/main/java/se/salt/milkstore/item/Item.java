package se.salt.milkstore.item;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import se.salt.milkstore.order.Order;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @Column(name = "item_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    private int liters;

    private String milkId;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    public Item() {
    }

    public Item(int liters, String milkId, Order order) {
        this.liters = liters;
        this.milkId = milkId;
        this.order = order;
    }

    public Item(String id, int liters, String milkId, Order order) {
        this.id = id;
        this.liters = liters;
        this.milkId = milkId;
        this.order = order;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLiters() {
        return liters;
    }

    public void setLiters(int liters) {
        this.liters = liters;
    }

    public String getMilkId() {
        return milkId;
    }

    public void setMilkId(String milkId) {
        this.milkId = milkId;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
