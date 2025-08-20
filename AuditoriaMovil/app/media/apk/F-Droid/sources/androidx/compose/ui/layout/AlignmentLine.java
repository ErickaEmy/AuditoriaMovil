package androidx.compose.ui.layout;

import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AlignmentLine.kt */
/* loaded from: classes.dex */
public abstract class AlignmentLine {
    public static final Companion Companion = new Companion(null);
    private final Function2 merger;

    /* compiled from: AlignmentLine.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public /* synthetic */ AlignmentLine(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    public final Function2 getMerger$ui_release() {
        return this.merger;
    }

    private AlignmentLine(Function2 function2) {
        this.merger = function2;
    }
}
