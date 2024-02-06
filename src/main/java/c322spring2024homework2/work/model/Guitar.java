
package c322spring2024homework2.work.model;

public class Guitar {

    private final String serialNumber;
    private double price;
    private final Builder builder;
    private final String model;
    private final Type type;
    private final Wood backWood;
    private final Wood topWood;

    public enum Builder {
        FENDER, MARTIN, GIBSON, COLLINGS, OLSON, RYAN, PRS, UNSPECIFIED;
        public String toString() {
            switch (this) {
                case FENDER: return "FENDER";
                case MARTIN: return "MARTIN";
                case GIBSON: return "GIBSON";
                case COLLINGS: return "COLLINGS";
                case OLSON: return "OLSON";
                case RYAN: return "RYAN";
                case PRS: return "PRS";
                default: return "UNSPECIFIED";
            }
        }
    }

    public enum Type {
        ACOUSTIC, ELECTRIC, UNSPECIFIED;
        public String toString() {
            switch (this) {
                case ACOUSTIC: return "ACOUSTIC";
                case ELECTRIC: return "ELECTRIC";
                default: return "UNSPECIFIED";
            }
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA, UNSPECIFIED;
        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD: return "INDIAN_ROSEWOOD";
                case BRAZILIAN_ROSEWOOD: return "BRAZILIAN_ROSEWOOD";
                case MAHOGANY: return "MAHOGANY";
                case MAPLE: return "MAPLE";
                case COCOBOLO: return "COCOBOLO";
                case CEDAR: return "CEDAR";
                case ADIRONDACK: return "ADIRONDACK";
                case ALDER: return "ALDER";
                case SITKA: return "SITKA";
                default: return "UNSPECIFIED";
            }
        }
    }

    public Guitar() {
        serialNumber = "";
        price = -1;
        builder = Builder.UNSPECIFIED;
        model = "";
        type = Type.UNSPECIFIED;
        backWood = Wood.UNSPECIFIED;
        topWood = Wood.UNSPECIFIED;
    }

    public Guitar(String sN, double p, String b, String m, String t, String bW, String tW) {
        serialNumber = sN;
        price = p;
        builder = gB(b);
        model = m;
        type = gT(t);
        backWood = gW(bW);
        topWood = gW(tW);
    }

    private Builder gB(String builder) {
        try {
            return Builder.valueOf(builder);
        } catch (Exception e) {
            return Builder.UNSPECIFIED;
        }
    }

    private Type gT(String type) {
        try {
            return Type.valueOf(type);
        } catch (Exception e) {
            return Type.UNSPECIFIED;
        }
    }

    private Wood gW(String wood) {
        try {
            return Wood.valueOf(wood);
        } catch (Exception e) {
            return Wood.UNSPECIFIED;
        }
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

    public Builder getBuilder() {
        return builder;
    }

    public String getModel() {
        return model;
    }

    public Type getType() {
        return type;
    }

    public Wood getBackWood() {
        return backWood;
    }

    public Wood getTopWood() {
        return topWood;
    }
}
