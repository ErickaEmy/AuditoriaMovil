package d1;

import w0.xc;
/* loaded from: classes.dex */
public final class zn {
    public static boolean n3(char[] cArr, char c2) {
        for (char c4 : cArr) {
            if (c4 == c2) {
                return true;
            }
        }
        return false;
    }

    public static char y(long j2) {
        boolean z2;
        char c2 = (char) j2;
        if (c2 == j2) {
            z2 = true;
        } else {
            z2 = false;
        }
        xc.c5(z2, "Out of range: %s", j2);
        return c2;
    }

    public static char zn(byte b2, byte b3) {
        return (char) ((b2 << 8) | (b3 & 255));
    }
}
