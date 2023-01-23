package se.salt.milkstore.milk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MilkRepository {
    @Autowired
    private JpaMilkRepository jpaMilkRepository;

    public Milk save(Milk milk) {
        return jpaMilkRepository.save(milk);
    }

    public List<Milk> findAll() {
        return Streamable.of(jpaMilkRepository.findAll()).toList();
    }

    public Milk findById(String id) {
        return jpaMilkRepository.findById(id).orElseThrow();
    }
}
