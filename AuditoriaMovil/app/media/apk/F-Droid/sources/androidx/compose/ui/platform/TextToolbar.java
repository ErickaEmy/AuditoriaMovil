package androidx.compose.ui.platform;

import androidx.compose.ui.geometry.Rect;
import kotlin.jvm.functions.Function0;
/* compiled from: TextToolbar.kt */
/* loaded from: classes.dex */
public interface TextToolbar {
    TextToolbarStatus getStatus();

    void hide();

    void showMenu(Rect rect, Function0 function0, Function0 function02, Function0 function03, Function0 function04);
}
