package androidx.compose.ui.window;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.State;
import androidx.compose.ui.unit.IntRect;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidPopup.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidPopup_androidKt {
    private static final ProvidableCompositionLocal LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.ui.window.AndroidPopup_androidKt$LocalPopupTestTag$1
        @Override // kotlin.jvm.functions.Function0
        public final String invoke() {
            return "DEFAULT_TEST_TAG";
        }
    }, 1, null);

    public static final Function2 Popup$lambda$1(State state) {
        return (Function2) state.getValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:114:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x016a  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:175:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Popup(final androidx.compose.ui.window.PopupPositionProvider r35, kotlin.jvm.functions.Function0 r36, androidx.compose.ui.window.PopupProperties r37, final kotlin.jvm.functions.Function2 r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidPopup_androidKt.Popup(androidx.compose.ui.window.PopupPositionProvider, kotlin.jvm.functions.Function0, androidx.compose.ui.window.PopupProperties, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final boolean isFlagSecureEnabled(View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        ViewGroup.LayoutParams layoutParams = view.getRootView().getLayoutParams();
        WindowManager.LayoutParams layoutParams2 = layoutParams instanceof WindowManager.LayoutParams ? (WindowManager.LayoutParams) layoutParams : null;
        return (layoutParams2 == null || (layoutParams2.flags & 8192) == 0) ? false : true;
    }

    public static final IntRect toIntBounds(Rect rect) {
        return new IntRect(rect.left, rect.top, rect.right, rect.bottom);
    }
}
