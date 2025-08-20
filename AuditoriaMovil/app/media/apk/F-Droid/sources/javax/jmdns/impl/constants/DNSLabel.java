package javax.jmdns.impl.constants;
/* loaded from: classes.dex */
public enum DNSLabel {
    Unknown("", 128),
    Standard("standard label", 0),
    Compressed("compressed label", 192),
    Extended("extended label", 64);
    
    private final String _externalName;
    private final int _index;

    public static int labelValue(int i) {
        return i & 63;
    }

    public int indexValue() {
        return this._index;
    }

    DNSLabel(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public static DNSLabel labelForByte(int i) {
        DNSLabel[] values;
        int i2 = i & 192;
        for (DNSLabel dNSLabel : values()) {
            if (dNSLabel._index == i2) {
                return dNSLabel;
            }
        }
        return Unknown;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + indexValue();
    }
}
