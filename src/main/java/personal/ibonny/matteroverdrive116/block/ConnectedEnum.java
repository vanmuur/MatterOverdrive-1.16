package personal.ibonny.matteroverdrive116.block;

import net.minecraft.util.IStringSerializable;

public enum ConnectedEnum implements IStringSerializable {
    NONE ("none"),
    N ("n"),
    S ("s"),
    E ("e"),
    W ("w"),
    NS ("ns"),
    EW ("ew"),
    NE ("ne"),
    SE ("se"),
    NW ("nw"),
    SW ("sw"),
    NWE ("new"),
    NSE ("nse"),
    SWE ("sew"),
    NSW ("nsw"),
    ALL ("news");

    private final String value;

    ConnectedEnum(String value) {
        if (value.equals("")) {
            value = "none";
        }

        this.value = value;
    }

    @Override
    public String getString() {
        return this.value;
    }

    public static ConnectedEnum valueOfLabel(String label) {
        for (ConnectedEnum e : values()) {
            if (e.value.equals(label)) {
                return e;
            }
        }

        return null;
    }
}
