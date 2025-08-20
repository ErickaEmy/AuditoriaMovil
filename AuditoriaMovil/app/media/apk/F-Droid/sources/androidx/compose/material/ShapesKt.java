package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;
/* compiled from: Shapes.kt */
/* loaded from: classes.dex */
public abstract class ShapesKt {
    private static final ProvidableCompositionLocal LocalShapes = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.ShapesKt$LocalShapes$1
        @Override // kotlin.jvm.functions.Function0
        public final Shapes invoke() {
            return new Shapes(null, null, null, 7, null);
        }
    });

    public static final ProvidableCompositionLocal getLocalShapes() {
        return LocalShapes;
    }
}
