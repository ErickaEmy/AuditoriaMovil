package androidx.compose.ui.platform;

import android.view.ActionMode;
import android.view.View;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.platform.actionmodecallback.FloatingTextActionModeCallback;
import androidx.compose.ui.platform.actionmodecallback.TextActionModeCallback;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidTextToolbar.android.kt */
/* loaded from: classes.dex */
public final class AndroidTextToolbar implements TextToolbar {
    private ActionMode actionMode;
    private TextToolbarStatus status;
    private final TextActionModeCallback textActionModeCallback;
    private final View view;

    @Override // androidx.compose.ui.platform.TextToolbar
    public TextToolbarStatus getStatus() {
        return this.status;
    }

    public AndroidTextToolbar(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        this.view = view;
        this.textActionModeCallback = new TextActionModeCallback(new Function0() { // from class: androidx.compose.ui.platform.AndroidTextToolbar$textActionModeCallback$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Object invoke() {
                m1423invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke  reason: collision with other method in class */
            public final void m1423invoke() {
                AndroidTextToolbar.this.actionMode = null;
            }
        }, null, null, null, null, null, 62, null);
        this.status = TextToolbarStatus.Hidden;
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void showMenu(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04) {
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.textActionModeCallback.setRect(rect);
        this.textActionModeCallback.setOnCopyRequested(function0);
        this.textActionModeCallback.setOnCutRequested(function03);
        this.textActionModeCallback.setOnPasteRequested(function02);
        this.textActionModeCallback.setOnSelectAllRequested(function04);
        ActionMode actionMode = this.actionMode;
        if (actionMode == null) {
            this.status = TextToolbarStatus.Shown;
            this.actionMode = TextToolbarHelperMethods.INSTANCE.startActionMode(this.view, new FloatingTextActionModeCallback(this.textActionModeCallback), 1);
        } else if (actionMode != null) {
            actionMode.invalidate();
        }
    }

    @Override // androidx.compose.ui.platform.TextToolbar
    public void hide() {
        this.status = TextToolbarStatus.Hidden;
        ActionMode actionMode = this.actionMode;
        if (actionMode != null) {
            actionMode.finish();
        }
        this.actionMode = null;
    }
}
