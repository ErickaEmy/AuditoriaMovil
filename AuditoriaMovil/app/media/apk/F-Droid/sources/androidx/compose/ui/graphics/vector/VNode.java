package androidx.compose.ui.graphics.vector;

import androidx.compose.ui.graphics.drawscope.DrawScope;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Vector.kt */
/* loaded from: classes.dex */
public abstract class VNode {
    private Function0 invalidateListener;

    private VNode() {
    }

    public /* synthetic */ VNode(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract void draw(DrawScope drawScope);

    public Function0 getInvalidateListener$ui_release() {
        return this.invalidateListener;
    }

    public void setInvalidateListener$ui_release(Function0 function0) {
        this.invalidateListener = function0;
    }

    public final void invalidate() {
        Function0 invalidateListener$ui_release = getInvalidateListener$ui_release();
        if (invalidateListener$ui_release != null) {
            invalidateListener$ui_release.invoke();
        }
    }
}
