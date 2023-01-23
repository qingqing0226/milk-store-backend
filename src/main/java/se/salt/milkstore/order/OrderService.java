package se.salt.milkstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.milkstore.milk.Milk;
import se.salt.milkstore.milk.MilkService;
import se.salt.milkstore.milk.dto.UpdateMilkDTO;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private MilkService milkService;

    public List<Order> getAll() {
        return orderRepository.getAllOrders();
    }

    public Order createdOrder(Order order) {
        order.getItems().stream().forEach(item -> {
            Milk milk = milkService.findById(item.getMilkId());
            int left = milk.getStorage() - item.getLiters();
            if(left < 0) throw new IllegalArgumentException();
            milk.setStorage(left);
            milkService.saveMilk(milk);
        });

        return orderRepository.saveOrder(order);
    }
}
