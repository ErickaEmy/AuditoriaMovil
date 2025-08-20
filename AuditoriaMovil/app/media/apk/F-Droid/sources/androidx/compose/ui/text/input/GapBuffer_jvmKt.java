package androidx.compose.ui.text.input;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: GapBuffer.jvm.kt */
/* loaded from: classes.dex */
public abstract class GapBuffer_jvmKt {
    public static final void toCharArray(String str, char[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        str.getChars(i2, i3, destination, i);
    }
}
