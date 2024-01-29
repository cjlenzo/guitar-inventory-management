package c322spring2024homework2.work.model;

public class Guitar {

    private final String serialNumber;
    private double price;
    private final String builder;
    private final String model;
    private final String type;
    private final String backWood;
    private final String topWood;

    public Guitar() {
        serialNumber = "";
        price = -1;
        builder = "";
        model = "";
        type = "";
        backWood = "";
        topWood = "";
    }

    public Guitar(String sN, double p, String b, String m, String t, String bW, String tW) {
        serialNumber = sN;
        price = p;
        builder = b;
        model = m;
        type = t;
        backWood = bW;
        topWood = tW;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(float newPrice) {
        price = newPrice;
    }

    public String getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getBackWood() {
        return backWood;
    }

    public String getTopWood() {
        return topWood;
    }
}
