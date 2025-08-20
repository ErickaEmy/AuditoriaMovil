package androidx.compose.ui.geometry;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: MutableRect.kt */
/* loaded from: classes.dex */
public abstract class MutableRectKt {
    public static final Rect toRect(MutableRect mutableRect) {
        Intrinsics.checkNotNullParameter(mutableRect, "<this>");
        return new Rect(mutableRect.getLeft(), mutableRect.getTop(), mutableRect.getRight(), mutableRect.getBottom());
    }
}
