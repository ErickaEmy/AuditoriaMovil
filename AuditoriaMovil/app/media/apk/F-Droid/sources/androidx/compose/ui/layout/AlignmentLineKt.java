package androidx.compose.ui.layout;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public abstract class AlignmentLineKt {
    private static final HorizontalAlignmentLine FirstBaseline = new HorizontalAlignmentLine(AlignmentLineKt$FirstBaseline$1.INSTANCE);
    private static final HorizontalAlignmentLine LastBaseline = new HorizontalAlignmentLine(AlignmentLineKt$LastBaseline$1.INSTANCE);

    public static final HorizontalAlignmentLine getFirstBaseline() {
        return FirstBaseline;
    }

    public static final HorizontalAlignmentLine getLastBaseline() {
        return LastBaseline;
    }

    public static final int merge(AlignmentLine alignmentLine, int i, int i2) {
        Intrinsics.checkNotNullParameter(alignmentLine, "<this>");
        return ((Number) alignmentLine.getMerger$ui_release().invoke(Integer.valueOf(i), Integer.valueOf(i2))).intValue();
    }
}
