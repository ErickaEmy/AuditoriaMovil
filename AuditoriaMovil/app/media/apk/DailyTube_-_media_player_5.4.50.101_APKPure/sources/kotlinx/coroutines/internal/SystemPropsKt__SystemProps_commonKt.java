package kotlinx.coroutines.internal;

import kotlin.text.StringsKt;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final /* synthetic */ class SystemPropsKt__SystemProps_commonKt {
    public static final boolean systemProp(String str, boolean z2) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp != null ? Boolean.parseBoolean(systemProp) : z2;
    }

    public static /* synthetic */ int systemProp$default(String str, int i, int i5, int i6, int i8, Object obj) {
        if ((i8 & 4) != 0) {
            i5 = 1;
        }
        if ((i8 & 8) != 0) {
            i6 = Integer.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, i, i5, i6);
    }

    public static final int systemProp(String str, int i, int i5, int i6) {
        return (int) SystemPropsKt.systemProp(str, i, i5, i6);
    }

    public static /* synthetic */ long systemProp$default(String str, long j2, long j4, long j6, int i, Object obj) {
        if ((i & 4) != 0) {
            j4 = 1;
        }
        long j7 = j4;
        if ((i & 8) != 0) {
            j6 = Long.MAX_VALUE;
        }
        return SystemPropsKt.systemProp(str, j2, j7, j6);
    }

    public static final long systemProp(String str, long j2, long j4, long j6) {
        String systemProp = SystemPropsKt.systemProp(str);
        if (systemProp == null) {
            return j2;
        }
        Long longOrNull = StringsKt.toLongOrNull(systemProp);
        if (longOrNull == null) {
            throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + systemProp + '\'').toString());
        }
        long longValue = longOrNull.longValue();
        if (j4 > longValue || longValue > j6) {
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j4 + ".." + j6 + ", but is '" + longValue + '\'').toString());
        }
        return longValue;
    }

    public static final String systemProp(String str, String str2) {
        String systemProp = SystemPropsKt.systemProp(str);
        return systemProp == null ? str2 : systemProp;
    }
}
