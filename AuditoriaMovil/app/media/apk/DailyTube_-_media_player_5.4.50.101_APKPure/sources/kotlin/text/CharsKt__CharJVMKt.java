package kotlin.text;

import kotlin.ranges.IntRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class CharsKt__CharJVMKt {
    public static int checkRadix(int i) {
        if (new IntRange(2, 36).contains(i)) {
            return i;
        }
        throw new IllegalArgumentException("radix " + i + " was not in valid range " + new IntRange(2, 36));
    }

    public static final int digitOf(char c2, int i) {
        return Character.digit((int) c2, i);
    }

    public static final boolean isWhitespace(char c2) {
        if (!Character.isWhitespace(c2) && !Character.isSpaceChar(c2)) {
            return false;
        }
        return true;
    }
}
