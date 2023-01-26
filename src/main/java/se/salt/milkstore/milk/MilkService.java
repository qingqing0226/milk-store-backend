package se.salt.milkstore.milk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.salt.milkstore.milk.dto.MilkTypeDTO;
import se.salt.milkstore.milk.dto.UpdateMilkDTO;

import java.util.List;

@Service
public class MilkService {

    @Autowired
    private MilkRepository milkRepository;

    public Milk saveMilk(Milk milk) {
        return milkRepository.save(milk);
    }

    public List<Milk> getAllMilk() {
        return milkRepository.findAll();
    }

    public Milk findById(String id) {
        return milkRepository.findById(id);
    }

    public Milk updateMilkStorage(UpdateMilkDTO updateMilkDTO) {
        Milk milk = findById(updateMilkDTO.id());
        milk.setStorage(updateMilkDTO.storage());
        return saveMilk(milk);
    }

    public List<Milk> getByTypes(MilkTypeDTO milkTypeDTO) {
        return getAllMilk().stream().filter(milk -> milkTypeDTO.types().contains(milk.getType())).toList();
    }
}
