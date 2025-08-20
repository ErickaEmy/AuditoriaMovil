package androidx.compose.ui.layout;

import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: SubcomposeLayout.kt */
/* loaded from: classes.dex */
public interface SubcomposeIntermediateMeasureScope extends SubcomposeMeasureScope {
    Function2 getLookaheadMeasurePolicy();

    List measurablesForSlot(Object obj);

    /* compiled from: SubcomposeLayout.kt */
    /* renamed from: androidx.compose.ui.layout.SubcomposeIntermediateMeasureScope$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static List $default$subcompose(SubcomposeIntermediateMeasureScope subcomposeIntermediateMeasureScope, Object obj, Function2 content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return subcomposeIntermediateMeasureScope.measurablesForSlot(obj);
        }
    }
}
