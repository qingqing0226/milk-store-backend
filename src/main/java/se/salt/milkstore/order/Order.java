package se.salt.milkstore.order;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import se.salt.milkstore.item.Item;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @OneToMany(mappedBy = "order")
    private Set<Item> items;

    public Order() {
    }

    public Order(Set<Item> items) {
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Set<Item> getItems() {
        return items;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }
}
