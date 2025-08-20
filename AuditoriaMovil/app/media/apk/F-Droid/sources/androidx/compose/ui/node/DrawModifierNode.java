package androidx.compose.ui.node;

import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
/* compiled from: DrawModifierNode.kt */
/* loaded from: classes.dex */
public interface DrawModifierNode extends DelegatableNode {

    /* compiled from: DrawModifierNode.kt */
    /* renamed from: androidx.compose.ui.node.DrawModifierNode$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$onMeasureResultChanged(DrawModifierNode drawModifierNode) {
        }
    }

    void draw(ContentDrawScope contentDrawScope);

    void onMeasureResultChanged();
}
