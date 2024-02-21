
package c322spring2024homework2.work.model;

import com.fasterxml.jackson.annotation.JsonCreator;

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
                case FENDER: return "Fender";
                case MARTIN: return "Martin";
                case GIBSON: return "Gibson";
                case COLLINGS: return "Collings";
                case OLSON: return "Olson";
                case RYAN: return "Ryan";
                case PRS: return "Prs";
                default: return "Unspecified";
            }
        }

        public static Builder toEnum(String value) {
            switch (value.toLowerCase().strip()) {
                case "fender": return Builder.FENDER;
                case "martin": return Builder.MARTIN;
                case "gibson": return Builder.GIBSON;
                case "collings": return Builder.COLLINGS;
                case "olson": return Builder.OLSON;
                case "ryan": return Builder.RYAN;
                case "prs": return Builder.PRS;
                default: return Builder.UNSPECIFIED;
            }
        }

        @JsonCreator
        public static Builder fromString(String value) {
            return Builder.toEnum(value);
        }
    }

    public enum Type {
        ACOUSTIC, ELECTRIC, UNSPECIFIED;
        public String toString() {
            switch (this) {
                case ACOUSTIC: return "Acoustic";
                case ELECTRIC: return "Electric";
                default: return "Unspecified";
            }
        }

        public static Type toEnum(String value) {
            switch (value.toLowerCase().strip()) {
                case "acoustic": return Type.ACOUSTIC;
                case "electric": return Type.ELECTRIC;
                default: return Type.UNSPECIFIED;
            }
        }

        @JsonCreator
        public static Type fromString(String value) {
            return Type.toEnum(value);
        }
    }

    public enum Wood {
        INDIAN_ROSEWOOD, BRAZILIAN_ROSEWOOD, MAHOGANY, MAPLE, COCOBOLO, CEDAR, ADIRONDACK, ALDER, SITKA, UNSPECIFIED;
        public String toString() {
            switch (this) {
                case INDIAN_ROSEWOOD: return "Indian Rosewood";
                case BRAZILIAN_ROSEWOOD: return "Brazilian Rosewood";
                case MAHOGANY: return "Mahogany";
                case MAPLE: return "Maple";
                case COCOBOLO: return "Cocobolo";
                case CEDAR: return "Cedar";
                case ADIRONDACK: return "Adirondack";
                case ALDER: return "Alder";
                case SITKA: return "Sitka";
                default: return "Unspecified";
            }
        }

        public static Wood toEnum(String value) {
            switch (value.toLowerCase().strip()) {
                case "indian rosewood": return Wood.INDIAN_ROSEWOOD;
                case "brazilian rosewood": return Wood.BRAZILIAN_ROSEWOOD;
                case "mahogany": return Wood.MAHOGANY;
                case "maple": return Wood.MAPLE;
                case "cocobolo": return Wood.COCOBOLO;
                case "cedar": return Wood.CEDAR;
                case "adirondack": return Wood.ADIRONDACK;
                case "alder": return Wood.ALDER;
                case "sitka": return Wood.SITKA;
                default: return Wood.UNSPECIFIED;
            }
        }

        @JsonCreator
        public static Wood fromString(String value) {
            return Wood.toEnum(value);
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

    public Guitar(String sN, double p, Builder b, String m, Type t, Wood bW, Wood tW) {
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
