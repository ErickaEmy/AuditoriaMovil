package androidx.compose.ui.focus;

import androidx.compose.runtime.collection.MutableVector;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FocusRequester.kt */
/* loaded from: classes.dex */
public final class FocusRequester {
    private final MutableVector focusRequesterNodes = new MutableVector(new FocusRequesterModifierNode[16], 0);
    public static final Companion Companion = new Companion(null);
    private static final FocusRequester Default = new FocusRequester();
    private static final FocusRequester Cancel = new FocusRequester();

    public final MutableVector getFocusRequesterNodes$ui_release() {
        return this.focusRequesterNodes;
    }

    public final void requestFocus() {
        focus$ui_release();
    }

    /* compiled from: FocusRequester.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final FocusRequester getDefault() {
            return FocusRequester.Default;
        }

        public final FocusRequester getCancel() {
            return FocusRequester.Cancel;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:76:0x0059, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean focus$ui_release() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.focus.FocusRequester.focus$ui_release():boolean");
    }
}
