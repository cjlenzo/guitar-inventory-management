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
            System.out.println("Serial Number: " + serialNumber);
            System.out.println("Builder: " + b);
            System.out.println("Model: " + model);
            System.out.println("Type: " + t);
            System.out.println("Back Wood: " + bW);
            System.out.println("Top Wood: " + tW);
            List<Guitar> guitars = inventoryRepository.search(serialNumber.isEmpty() ? null : serialNumber,
                                                              price.isPresent() ? price.get().doubleValue() : null,
                                                              b.toString().equals("Unspecified") ? null : b.toString(),
                                                              model.isEmpty() ? null : model,
                                                              t.toString().equals("Unspecified") ? null : t.toString(),
                                                              bW.toString().equals("Unspecified") ? null : bW.toString(),
                                                              tW.toString().equals("Unspecified") ? null : tW.toString());
            System.out.println(guitars.size() + " guitars found.");
            return guitars;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @PostMapping
    public Guitar add(@RequestBody Guitar data) {
        try {
            String sN = data.getSerialNumber();
            double p = data.getPrice();
            Guitar.Builder b = data.getBuilder();
            String m = data.getModel();
            Guitar.Type t = data.getType();
            Guitar.Wood bW = data.getBackWood();
            Guitar.Wood tW = data.getTopWood();
            Guitar newGuitar = new Guitar(sN, p, b, m, t, bW, tW);
            Guitar returnValue = inventoryRepository.save(newGuitar);
            return returnValue;
        }
        catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/find/{sN}")
    public Guitar find(@PathVariable String sN) {
        try {
            return inventoryRepository.findBySerialNumber(sN);
        }
        catch (Exception e) {
            return null;
        }
    }
}
