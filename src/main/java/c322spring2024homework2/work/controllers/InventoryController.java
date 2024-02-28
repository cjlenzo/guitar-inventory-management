package c322spring2024homework2.work.controllers;

import c322spring2024homework2.work.model.Guitar;
import c322spring2024homework2.work.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository iR) {
        this.inventoryRepository = iR;
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam String serialNumber, @RequestParam Optional<Double> price, @RequestParam String builder, @RequestParam String model, @RequestParam String type, @RequestParam String backWood, @RequestParam String topWood) {
        try {
            Guitar.Builder b = Guitar.Builder.toEnum(builder);
            Guitar.Type t = Guitar.Type.toEnum(type);
            Guitar.Wood bW = Guitar.Wood.toEnum(backWood);
            Guitar.Wood tW = Guitar.Wood.toEnum(topWood);
            Guitar searchGuitar = new Guitar(serialNumber, -1, b, model, t, bW, tW);
            if (price.isPresent()) {
                float newPrice = price.get().floatValue();
                searchGuitar.setPrice(newPrice);
                return inventoryRepository.search(searchGuitar);
            }
            else {
                return inventoryRepository.search(searchGuitar);
            }
        }
        catch (IOException e) {
            return null;
        }
    }

    @PostMapping
    public boolean add(@RequestBody Guitar data) {
        try {
            String sN = data.getSerialNumber();
            double p = data.getPrice();
            Guitar.Builder b = data.getBuilder();
            String m = data.getModel();
            Guitar.Type t = data.getType();
            Guitar.Wood bW = data.getBackWood();
            Guitar.Wood tW = data.getTopWood();
            Guitar newGuitar = new Guitar(sN, p, b, m, t, bW, tW);
            boolean returnValue = inventoryRepository.addGuitar(newGuitar);
            return returnValue;
        }
        catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/find/{sN}")
    public Guitar find(@PathVariable String sN) {
        try {
            return inventoryRepository.getGuitar(sN);
        }
        catch (Exception e) {
            return null;
        }
    }
}
