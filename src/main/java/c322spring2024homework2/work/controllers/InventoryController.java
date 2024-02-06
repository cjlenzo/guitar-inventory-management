package c322spring2024homework2.work.controllers;

import c322spring2024homework2.work.model.Guitar;
import c322spring2024homework2.work.repository.InventoryRepository;
import org.springframework.web.bind.annotation.*;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private InventoryRepository inventoryRepository;

    public InventoryController(InventoryRepository iR) {
        this.inventoryRepository = iR;
    }

    @GetMapping("/search")
    public List<Guitar> search(@RequestParam String serialNumber, @RequestParam Optional<Double> price, @RequestParam String builder, @RequestParam String model, @RequestParam String type, @RequestParam String backWood, @RequestParam String topWood) {
        try {
            Guitar searchGuitar = new Guitar(serialNumber, -1, builder, model, type, backWood, topWood);
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
            String b = data.getBuilder().toString();
            String m = data.getModel();
            String t = data.getType().toString();
            String bW = data.getBackWood().toString();
            String tW = data.getTopWood().toString();
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
