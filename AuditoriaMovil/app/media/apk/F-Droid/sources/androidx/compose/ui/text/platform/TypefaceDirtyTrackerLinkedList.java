package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import kotlin.jvm.internal.Intrinsics;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public final class TypefaceDirtyTrackerLinkedList {
    private final Object initial;
    private final TypefaceDirtyTrackerLinkedList next;
    private final State resolveResult;

    public TypefaceDirtyTrackerLinkedList(State resolveResult, TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList) {
        Intrinsics.checkNotNullParameter(resolveResult, "resolveResult");
        this.resolveResult = resolveResult;
        this.next = typefaceDirtyTrackerLinkedList;
        this.initial = resolveResult.getValue();
    }

    public final Typeface getTypeface() {
        Object obj = this.initial;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type android.graphics.Typeface");
        return (Typeface) obj;
    }

    public final boolean isStaleResolvedFont() {
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList;
        return this.resolveResult.getValue() != this.initial || ((typefaceDirtyTrackerLinkedList = this.next) != null && typefaceDirtyTrackerLinkedList.isStaleResolvedFont());
    }
}
