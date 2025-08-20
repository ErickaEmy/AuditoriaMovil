package vc1;

import java.util.logging.Level;
import java.util.logging.LogRecord;
/* loaded from: classes.dex */
public final class v {
    public static final int n3(LogRecord logRecord) {
        int intValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (intValue > level.intValue()) {
            return 5;
        }
        if (logRecord.getLevel().intValue() == level.intValue()) {
            return 4;
        }
        return 3;
    }
}
