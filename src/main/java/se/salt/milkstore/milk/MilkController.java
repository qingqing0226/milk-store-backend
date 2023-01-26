package se.salt.milkstore.milk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.salt.milkstore.milk.dto.MilkTypeDTO;
import se.salt.milkstore.milk.dto.UpdateMilkDTO;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@CrossOrigin
@RequestMapping("/api/milk")
public class MilkController {
    @Autowired
    private MilkService milkService;

    @GetMapping
    ResponseEntity getAllMilk() {
        return ResponseEntity.ok(milkService.getAllMilk());
    }

    @GetMapping("/filter")
    ResponseEntity getMilkByTypes (@RequestBody MilkTypeDTO milkTypeDTO) {
        return ResponseEntity.ok(milkService.getByTypes(milkTypeDTO));
    }

    @PostMapping("/list")
    ResponseEntity saveMilks(@RequestBody List<Milk> milks) {
        List<Milk> saved = milks.stream().map(m -> milkService.saveMilk(m)).toList();
        return ResponseEntity.created(URI.create("/api/milk")).body(saved);
    }

    @PutMapping()
    ResponseEntity updateMilkStorage(@RequestBody UpdateMilkDTO updateMilkDTO) {
        try {
            if(updateMilkDTO.storage() < 0) {
                return ResponseEntity.badRequest().build();
            }

            Milk updated = milkService.updateMilkStorage(updateMilkDTO);
            return ResponseEntity.ok(updated);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(NOT_FOUND, e.getMessage());
        }
    }

}
