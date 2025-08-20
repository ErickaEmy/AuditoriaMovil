package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import kotlin.jvm.functions.Function0;
/* compiled from: ContentAlpha.kt */
/* loaded from: classes.dex */
public abstract class ContentAlphaKt {
    private static final ProvidableCompositionLocal LocalContentAlpha = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ContentAlphaKt$LocalContentAlpha$1
        @Override // kotlin.jvm.functions.Function0
        public final Float invoke() {
            return Float.valueOf(1.0f);
        }
    }, 1, null);

    public static final ProvidableCompositionLocal getLocalContentAlpha() {
        return LocalContentAlpha;
    }
}
