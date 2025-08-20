package kotlin.text;
/* loaded from: classes.dex */
class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static int digitToInt(char c2) {
        int digitOf = CharsKt__CharJVMKt.digitOf(c2, 10);
        if (digitOf >= 0) {
            return digitOf;
        }
        throw new IllegalArgumentException("Char " + c2 + " is not a decimal digit");
    }

    public static final boolean equals(char c2, char c4, boolean z2) {
        if (c2 == c4) {
            return true;
        }
        if (!z2) {
            return false;
        }
        char upperCase = Character.toUpperCase(c2);
        char upperCase2 = Character.toUpperCase(c4);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }
}
