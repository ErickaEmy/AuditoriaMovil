package kotlin.text;

import kotlin.ranges.CharRange;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Char.kt */
/* loaded from: classes2.dex */
public abstract class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static String titlecase(char c) {
        return _OneToManyTitlecaseMappingsKt.titlecaseImpl(c);
    }

    public static final boolean equals(char c, char c2, boolean z) {
        if (c == c2) {
            return true;
        }
        if (z) {
            char upperCase = Character.toUpperCase(c);
            char upperCase2 = Character.toUpperCase(c2);
            return upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2);
        }
        return false;
    }

    public static boolean isSurrogate(char c) {
        return new CharRange((char) 55296, (char) 57343).contains(c);
    }
}
