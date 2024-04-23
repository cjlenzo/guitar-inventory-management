

package c322spring2024homework2.work.repository;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import c322spring2024homework2.work.model.Guitar;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

class InventoryRepositoryTest {

    @Test
    @Order(1)
    void addOneGuitar() throws IOException {
        try {
            Guitar guitarToAdd = new Guitar("123456789", 100, Guitar.Builder.toEnum("Fender"), "Stratocaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Indian Rosewood"), Guitar.Wood.toEnum("Maple"));
            InventoryFileRepository inventoryRepository = new InventoryFileRepository();
            boolean returnValue = inventoryRepository.addGuitar(guitarToAdd);
            assertEquals(true, returnValue);
            Path path = Path.of("guitars_database.txt");
            List<String> data = Files.readAllLines(path);
            String[] guitarData = data.get(0).split(",");
            assertEquals("123456789", guitarData[0]);
            assertEquals("100.0", guitarData[1]);
            assertEquals("Fender", guitarData[2]);
            assertEquals("Stratocaster", guitarData[3]);
            assertEquals("Electric", guitarData[4]);
            assertEquals("Indian Rosewood", guitarData[5]);
            assertEquals("Maple", guitarData[6]);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(2)
    void addMultipleGuitars() {
        try {
            Guitar guitar1 = new Guitar("111111111", 100, Guitar.Builder.toEnum("Fender"), "A", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Maple"), Guitar.Wood.toEnum("Birch"));
            Guitar guitar2 = new Guitar("222222222", 300, Guitar.Builder.toEnum("Gibson"), "X", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Mahogany"), Guitar.Wood.toEnum("Spruce"));
            Guitar guitar3 = new Guitar("333333333", 150, Guitar.Builder.toEnum("Fender"), "Telecaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Oak"), Guitar.Wood.toEnum("Redwood"));
            Guitar guitar4 = new Guitar("444444444", 200, Guitar.Builder.toEnum("Gibson"), "Les Paul", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Birch"), Guitar.Wood.toEnum("Oak"));
            Guitar guitar5 = new Guitar("555555555", 250, Guitar.Builder.toEnum("Yamaha"), "M", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Spruce"), Guitar.Wood.toEnum("Maple"));
            InventoryFileRepository inventoryRepository = new InventoryFileRepository();
            boolean returnValue1 = inventoryRepository.addGuitar(guitar1);
            boolean returnValue2 = inventoryRepository.addGuitar(guitar2);
            boolean returnValue3 = inventoryRepository.addGuitar(guitar3);
            boolean returnValue4 = inventoryRepository.addGuitar(guitar4);
            boolean returnValue5 = inventoryRepository.addGuitar(guitar5);
            assertEquals(true, returnValue1);
            assertEquals(true, returnValue2);
            assertEquals(true, returnValue3);
            assertEquals(true, returnValue4);
            assertEquals(true, returnValue5);
            Path path = Path.of("guitars_database.txt");
            List<String> data = Files.readAllLines(path);
            String[] guitarData1 = data.get(1).split(",");
            String[] guitarData2 = data.get(2).split(",");
            String[] guitarData3 = data.get(3).split(",");
            String[] guitarData4 = data.get(4).split(",");
            String[] guitarData5 = data.get(5).split(",");
            assertEquals("111111111", guitarData1[0]);
            assertEquals("100.0", guitarData1[1]);
            assertEquals("Fender", guitarData1[2]);
            assertEquals("A", guitarData1[3]);
            assertEquals("Electric", guitarData1[4]);
            assertEquals("Maple", guitarData1[5]);
            assertEquals("Unspecified", guitarData1[6]);
            assertEquals("222222222", guitarData2[0]);
            assertEquals("300.0", guitarData2[1]);
            assertEquals("Gibson", guitarData2[2]);
            assertEquals("X", guitarData2[3]);
            assertEquals("Acoustic", guitarData2[4]);
            assertEquals("Mahogany", guitarData2[5]);
            assertEquals("Unspecified", guitarData2[6]);
            assertEquals("333333333", guitarData3[0]);
            assertEquals("150.0", guitarData3[1]);
            assertEquals("Fender", guitarData3[2]);
            assertEquals("Telecaster", guitarData3[3]);
            assertEquals("Electric", guitarData3[4]);
            assertEquals("Unspecified", guitarData3[5]);
            assertEquals("Unspecified", guitarData3[6]);
            assertEquals("444444444", guitarData4[0]);
            assertEquals("200.0", guitarData4[1]);
            assertEquals("Gibson", guitarData4[2]);
            assertEquals("Les Paul", guitarData4[3]);
            assertEquals("Electric", guitarData4[4]);
            assertEquals("Unspecified", guitarData4[5]);
            assertEquals("Unspecified", guitarData4[6]);
            assertEquals("555555555", guitarData5[0]);
            assertEquals("250.0", guitarData5[1]);
            assertEquals("Unspecified", guitarData5[2]);
            assertEquals("M", guitarData5[3]);
            assertEquals("Acoustic", guitarData5[4]);
            assertEquals("Unspecified", guitarData5[5]);
            assertEquals("Maple", guitarData5[6]);
        }
        catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @Order(3)
    void getGuitar() {
        try {
            Guitar guitar1 = new Guitar("111111111", 100, Guitar.Builder.toEnum("Fender"), "A", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Maple"), Guitar.Wood.toEnum("Birch"));
            Guitar guitar2 = new Guitar("222222222", 300, Guitar.Builder.toEnum("Gibson"), "X", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Mahogany"), Guitar.Wood.toEnum("Spruce"));
            Guitar guitar3 = new Guitar("333333333", 150, Guitar.Builder.toEnum("Fender"), "Telecaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Oak"), Guitar.Wood.toEnum("Redwood"));
            Guitar guitar4 = new Guitar("444444444", 200, Guitar.Builder.toEnum("Gibson"), "Les Paul", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Birch"), Guitar.Wood.toEnum("Oak"));
            Guitar guitar5 = new Guitar("555555555", 250, Guitar.Builder.toEnum("Yamaha"), "M", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Spruce"), Guitar.Wood.toEnum("Maple"));
            InventoryFileRepository inventoryRepository = new InventoryFileRepository();
            Guitar returnGuitar1 = inventoryRepository.getGuitar("111111111");
            Guitar returnGuitar2 = inventoryRepository.getGuitar("222222222");
            Guitar returnGuitar3 = inventoryRepository.getGuitar("333333333");
            Guitar returnGuitar4 = inventoryRepository.getGuitar("444444444");
            Guitar returnGuitar5 = inventoryRepository.getGuitar("555555555");
            assertEquals(guitar1.getSerialNumber(), returnGuitar1.getSerialNumber());
            assertEquals(guitar1.getPrice(), returnGuitar1.getPrice());
            assertEquals(guitar1.getBuilder(), returnGuitar1.getBuilder());
            assertEquals(guitar1.getModel(), returnGuitar1.getModel());
            assertEquals(guitar1.getType(), returnGuitar1.getType());
            assertEquals(guitar1.getBackWood(), returnGuitar1.getBackWood());
            assertEquals(guitar1.getTopWood(), returnGuitar1.getTopWood());
            assertEquals(guitar2.getSerialNumber(), returnGuitar2.getSerialNumber());
            assertEquals(guitar2.getPrice(), returnGuitar2.getPrice());
            assertEquals(guitar2.getBuilder(), returnGuitar2.getBuilder());
            assertEquals(guitar2.getModel(), returnGuitar2.getModel());
            assertEquals(guitar2.getType(), returnGuitar2.getType());
            assertEquals(guitar2.getBackWood(), returnGuitar2.getBackWood());
            assertEquals(guitar2.getTopWood(), returnGuitar2.getTopWood());
            assertEquals(guitar3.getSerialNumber(), returnGuitar3.getSerialNumber());
            assertEquals(guitar3.getPrice(), returnGuitar3.getPrice());
            assertEquals(guitar3.getBuilder(), returnGuitar3.getBuilder());
            assertEquals(guitar3.getModel(), returnGuitar3.getModel());
            assertEquals(guitar3.getType(), returnGuitar3.getType());
            assertEquals(guitar3.getBackWood(), returnGuitar3.getBackWood());
            assertEquals(guitar3.getTopWood(), returnGuitar3.getTopWood());
            assertEquals(guitar4.getSerialNumber(), returnGuitar4.getSerialNumber());
            assertEquals(guitar4.getPrice(), returnGuitar4.getPrice());
            assertEquals(guitar4.getBuilder(), returnGuitar4.getBuilder());
            assertEquals(guitar4.getModel(), returnGuitar4.getModel());
            assertEquals(guitar4.getType(), returnGuitar4.getType());
            assertEquals(guitar4.getBackWood(), returnGuitar4.getBackWood());
            assertEquals(guitar4.getTopWood(), returnGuitar4.getTopWood());
            assertEquals(guitar5.getSerialNumber(), returnGuitar5.getSerialNumber());
            assertEquals(guitar5.getPrice(), returnGuitar5.getPrice());
            assertEquals(guitar5.getBuilder(), returnGuitar5.getBuilder());
            assertEquals(guitar5.getModel(), returnGuitar5.getModel());
            assertEquals(guitar5.getType(), returnGuitar5.getType());
            assertEquals(guitar5.getBackWood(), returnGuitar5.getBackWood());
            assertEquals(guitar5.getTopWood(), returnGuitar5.getTopWood());
        }
        catch (Exception e) {
            System.out.println(e.toString());
            fail();
        }
    }

    @Test
    @Order(4)
    void search() {
        try {
            Guitar guitar0 = new Guitar("123456789", 100, Guitar.Builder.toEnum("Fender"), "Stratocaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Indian Rosewood"), Guitar.Wood.toEnum("Maple"));
            Guitar guitar1 = new Guitar("111111111", 100, Guitar.Builder.toEnum("Fender"), "A", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Maple"), Guitar.Wood.toEnum("Birch"));
            Guitar guitar2 = new Guitar("222222222", 300, Guitar.Builder.toEnum("Gibson"), "X", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Mahogany"), Guitar.Wood.toEnum("Spruce"));
            Guitar guitar3 = new Guitar("333333333", 150, Guitar.Builder.toEnum("Fender"), "Telecaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Oak"), Guitar.Wood.toEnum("Redwood"));
            Guitar guitar4 = new Guitar("444444444", 200, Guitar.Builder.toEnum("Gibson"), "Les Paul", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Birch"), Guitar.Wood.toEnum("Oak"));
            Guitar guitar5 = new Guitar("555555555", 250, Guitar.Builder.toEnum("Yamaha"), "M", Guitar.Type.toEnum("Acoustic"), Guitar.Wood.toEnum("Spruce"), Guitar.Wood.toEnum("Maple"));
            InventoryFileRepository inventoryRepository = new InventoryFileRepository();
            Guitar searchMethod1 = new Guitar("", -1, Guitar.Builder.toEnum("Fender"), "", Guitar.Type.toEnum(""), Guitar.Wood.toEnum(""), Guitar.Wood.toEnum(""));
            Guitar searchMethod2 = new Guitar("333333333", 150, Guitar.Builder.toEnum("Fender"), "Telecaster", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum("Oak"), Guitar.Wood.toEnum("Redwood"));
            Guitar searchMethod3 = new Guitar("", -1, Guitar.Builder.toEnum(""), "", Guitar.Type.toEnum("Electric"), Guitar.Wood.toEnum(""), Guitar.Wood.toEnum(""));
            // For search method 1
            List<Guitar> returnList1 = inventoryRepository.search(searchMethod1);
            assertEquals(guitar0.getSerialNumber(), returnList1.get(0).getSerialNumber());
            assertEquals(guitar0.getPrice(), returnList1.get(0).getPrice());
            assertEquals(guitar0.getBuilder(), returnList1.get(0).getBuilder());
            assertEquals(guitar0.getModel(), returnList1.get(0).getModel());
            assertEquals(guitar0.getType(), returnList1.get(0).getType());
            assertEquals(guitar0.getBackWood(), returnList1.get(0).getBackWood());
            assertEquals(guitar0.getTopWood(), returnList1.get(0).getTopWood());
            assertEquals(guitar1.getSerialNumber(), returnList1.get(1).getSerialNumber());
            assertEquals(guitar1.getPrice(), returnList1.get(1).getPrice());
            assertEquals(guitar1.getBuilder(), returnList1.get(1).getBuilder());
            assertEquals(guitar1.getModel(), returnList1.get(1).getModel());
            assertEquals(guitar1.getType(), returnList1.get(1).getType());
            assertEquals(guitar1.getBackWood(), returnList1.get(1).getBackWood());
            assertEquals(guitar1.getTopWood(), returnList1.get(1).getTopWood());
            assertEquals(guitar3.getSerialNumber(), returnList1.get(2).getSerialNumber());
            assertEquals(guitar3.getPrice(), returnList1.get(2).getPrice());
            assertEquals(guitar3.getBuilder(), returnList1.get(2).getBuilder());
            assertEquals(guitar3.getModel(), returnList1.get(2).getModel());
            assertEquals(guitar3.getType(), returnList1.get(2).getType());
            assertEquals(guitar3.getBackWood(), returnList1.get(2).getBackWood());
            assertEquals(guitar3.getTopWood(), returnList1.get(2).getTopWood());

            // For search method 2
            List<Guitar> returnList2 = inventoryRepository.search(searchMethod2);
            assertEquals(guitar3.getSerialNumber(), returnList2.get(0).getSerialNumber());
            assertEquals(guitar3.getPrice(), returnList2.get(0).getPrice());
            assertEquals(guitar3.getBuilder(), returnList2.get(0).getBuilder());
            assertEquals(guitar3.getModel(), returnList2.get(0).getModel());
            assertEquals(guitar3.getType(), returnList2.get(0).getType());
            assertEquals(guitar3.getBackWood(), returnList2.get(0).getBackWood());
            assertEquals(guitar3.getTopWood(), returnList2.get(0).getTopWood());

            // For search method 3
            List<Guitar> returnList3 = inventoryRepository.search(searchMethod3);
            assertEquals(guitar0.getSerialNumber(), returnList3.get(0).getSerialNumber());
            assertEquals(guitar0.getPrice(), returnList3.get(0).getPrice());
            assertEquals(guitar0.getBuilder(), returnList3.get(0).getBuilder());
            assertEquals(guitar0.getModel(), returnList3.get(0).getModel());
            assertEquals(guitar0.getType(), returnList3.get(0).getType());
            assertEquals(guitar0.getBackWood(), returnList3.get(0).getBackWood());
            assertEquals(guitar0.getTopWood(), returnList3.get(0).getTopWood());
            assertEquals(guitar1.getSerialNumber(), returnList3.get(1).getSerialNumber());
            assertEquals(guitar1.getPrice(), returnList3.get(1).getPrice());
            assertEquals(guitar1.getBuilder(), returnList3.get(1).getBuilder());
            assertEquals(guitar1.getModel(), returnList3.get(1).getModel());
            assertEquals(guitar1.getType(), returnList3.get(1).getType());
            assertEquals(guitar1.getBackWood(), returnList3.get(1).getBackWood());
            assertEquals(guitar1.getTopWood(), returnList3.get(1).getTopWood());
            assertEquals(guitar3.getSerialNumber(), returnList3.get(2).getSerialNumber());
            assertEquals(guitar3.getPrice(), returnList3.get(2).getPrice());
            assertEquals(guitar3.getBuilder(), returnList3.get(2).getBuilder());
            assertEquals(guitar3.getModel(), returnList3.get(2).getModel());
            assertEquals(guitar3.getType(), returnList3.get(2).getType());
            assertEquals(guitar3.getBackWood(), returnList3.get(2).getBackWood());
            assertEquals(guitar3.getTopWood(), returnList3.get(2).getTopWood());
            assertEquals(guitar4.getSerialNumber(), returnList3.get(3).getSerialNumber());
            assertEquals(guitar4.getPrice(), returnList3.get(3).getPrice());
            assertEquals(guitar4.getBuilder(), returnList3.get(3).getBuilder());
            assertEquals(guitar4.getModel(), returnList3.get(3).getModel());
            assertEquals(guitar4.getType(), returnList3.get(3).getType());
            assertEquals(guitar4.getBackWood(), returnList3.get(3).getBackWood());
            assertEquals(guitar4.getTopWood(), returnList3.get(3).getTopWood());
        }
        catch (Exception e) {
            System.out.println(e.toString());
            fail();
        }
    }
}