package se.salt.milkstore.milk;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "milk")
public class Milk {
    @Id
    @Column(name = "milk_id")
    private String id;

    private String name;

    private String type;

    private int storage;

    public Milk() {
    }

    public Milk(String id, String name, String type, int storage) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.storage = storage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }
}
