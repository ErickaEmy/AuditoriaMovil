package javax.jmdns.impl.constants;

import ch.qos.logback.classic.spi.CallerData;
import kellinwood.security.zipsigner.ZipSigner;
import org.bouncycastle.pqc.crypto.rainbow.util.GF2Field;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/* loaded from: classes.dex */
public enum DNSRecordClass {
    CLASS_UNKNOWN(CallerData.NA, 0),
    CLASS_IN("in", 1),
    CLASS_CS("cs", 2),
    CLASS_CH("ch", 3),
    CLASS_HS("hs", 4),
    CLASS_NONE(ZipSigner.KEY_NONE, 254),
    CLASS_ANY("any", GF2Field.MASK);
    
    private static Logger logger = LoggerFactory.getLogger(DNSRecordClass.class.getName());
    private final String _externalName;
    private final int _index;

    public int indexValue() {
        return this._index;
    }

    public boolean isUnique(int i) {
        return (this == CLASS_UNKNOWN || (i & 32768) == 0) ? false : true;
    }

    DNSRecordClass(String str, int i) {
        this._externalName = str;
        this._index = i;
    }

    public static DNSRecordClass classForIndex(int i) {
        DNSRecordClass[] values;
        int i2 = i & 32767;
        for (DNSRecordClass dNSRecordClass : values()) {
            if (dNSRecordClass._index == i2) {
                return dNSRecordClass;
            }
        }
        logger.warn("Could not find record class for index: {}", Integer.valueOf(i));
        return CLASS_UNKNOWN;
    }

    @Override // java.lang.Enum
    public String toString() {
        return name() + " index " + indexValue();
    }
}
