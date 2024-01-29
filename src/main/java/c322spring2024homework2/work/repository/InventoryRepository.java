package c322spring2024homework2.work.repository;

import c322spring2024homework2.work.model.Guitar;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryRepository {

    private static final String NEW_LINE = System.lineSeparator();

    private static final String DATABASE_NAME = "guitars_database.txt";

    public InventoryRepository() throws IOException {
        Path path = Path.of(DATABASE_NAME);
        if (!Files.exists(path)) {
            Files.createFile(path);
        }
    }

    private static void appendToFile(Path path, String content) throws IOException {
        Files.write(path, content.getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }

    public boolean addGuitar(Guitar guitarToAdd) throws IOException {
        Path path = Path.of(DATABASE_NAME);
        String data = guitarToAdd.getSerialNumber() + "," + guitarToAdd.getPrice() + "," + guitarToAdd.getBuilder() + "," + guitarToAdd.getModel() + "," + guitarToAdd.getType() + "," + guitarToAdd.getBackWood() + "," + guitarToAdd.getTopWood() + NEW_LINE;
        Guitar foundGuitarWithSameSerial = getGuitar(guitarToAdd.getSerialNumber());
        if (foundGuitarWithSameSerial == null) {
            appendToFile(path, data);
        }
        return true;
    }

    public Guitar getGuitar(String serialNumber) throws IOException {
        Guitar returnGuitar = null;
        Path path = Path.of(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        boolean found = false;
        for (String line: data) {
            String[] guitarData = line.split(",");
            String checkSN = guitarData[0];
            if (checkSN.equals(serialNumber)) {
                double checkPrice = Double.parseDouble(guitarData[1]);
                String checkBuilder = guitarData[2];
                String checkModel = guitarData[3];
                String checkType = guitarData[4];
                String checkBackWood = guitarData[5];
                String checkTopWood = guitarData[6];
                returnGuitar = new Guitar(checkSN, checkPrice, checkBuilder, checkModel, checkType, checkBackWood, checkTopWood);
                found = true;
                break;
            }
        }
        if (found) {
            return returnGuitar;
        }
        else {
            return null;
        }
    }

    public List<Guitar> search(Guitar searchGuitar) throws IOException {
        List<Guitar> returnList = new ArrayList<>();
        Path path = Path.of(DATABASE_NAME);
        List<String> data = Files.readAllLines(path);
        for (String line: data) {
            String[] guitarData = line.split(",");
            String checkSN = guitarData[0];
            double checkPrice = Double.parseDouble(guitarData[1]);
            String checkBuilder = guitarData[2];
            String checkModel = guitarData[3];
            String checkType = guitarData[4];
            String checkBackWood = guitarData[5];
            String checkTopWood = guitarData[6];
            if (searchGuitar.getSerialNumber().equals(checkSN) || searchGuitar.getSerialNumber().isEmpty()) {
                if (searchGuitar.getPrice() == checkPrice || searchGuitar.getPrice() == -1) {
                    if (searchGuitar.getBuilder().equals(checkBuilder) || searchGuitar.getBuilder().isEmpty()) {
                        if (searchGuitar.getModel().equals(checkModel) || searchGuitar.getModel().isEmpty()) {
                            if (searchGuitar.getType().equals(checkType) || searchGuitar.getType().isEmpty()) {
                                if (searchGuitar.getBackWood().equals(checkBackWood) || searchGuitar.getBackWood().isEmpty()) {
                                    if (searchGuitar.getTopWood().equals(checkTopWood) || searchGuitar.getTopWood().isEmpty()) {
                                        Guitar guitar = new Guitar(checkSN, checkPrice, checkBuilder, checkModel, checkType, checkBackWood, checkTopWood);
                                        returnList.add(guitar);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return returnList;
    }
}
