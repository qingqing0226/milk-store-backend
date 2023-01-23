package se.salt.milkstore.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.URI;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    ResponseEntity getAll() {
        return ResponseEntity.ok(orderService.getAll());
    }

    @PostMapping
    ResponseEntity createOrder(@RequestBody Order order) {
        try {
            Order created = orderService.createdOrder(order);
            return ResponseEntity.created(URI.create("/api/orders/" + created.getId())).body(created);
        } catch (NoSuchElementException n) {
            throw new ResponseStatusException(NOT_FOUND, n.getMessage());
        } catch (IllegalArgumentException i) {
            return ResponseEntity.badRequest().build();
        }
    }
}
