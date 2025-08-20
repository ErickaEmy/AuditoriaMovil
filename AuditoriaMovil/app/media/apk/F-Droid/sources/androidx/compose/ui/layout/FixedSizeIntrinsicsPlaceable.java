package androidx.compose.ui.layout;

import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Layout.kt */
/* loaded from: classes.dex */
final class FixedSizeIntrinsicsPlaceable extends Placeable {
    @Override // androidx.compose.ui.layout.Measured
    public int get(AlignmentLine alignmentLine) {
        Intrinsics.checkNotNullParameter(alignmentLine, "alignmentLine");
        return Integer.MIN_VALUE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno  reason: not valid java name */
    public void mo1252placeAtf8xVGno(long j, float f, Function1 function1) {
    }

    public FixedSizeIntrinsicsPlaceable(int i, int i2) {
        m1270setMeasuredSizeozmzZPI(IntSizeKt.IntSize(i, i2));
    }
}
