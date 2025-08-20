package androidx.compose.foundation.text.modifiers;

import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: MinLinesConstrainer.kt */
/* loaded from: classes.dex */
public abstract class MinLinesConstrainerKt {
    private static final String EmptyTextReplacement;
    private static final String TwoLineTextReplacement;

    static {
        String repeat;
        repeat = StringsKt__StringsJVMKt.repeat("H", 10);
        EmptyTextReplacement = repeat;
        TwoLineTextReplacement = repeat + '\n' + repeat;
    }
}
