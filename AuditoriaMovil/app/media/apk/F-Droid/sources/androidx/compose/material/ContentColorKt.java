package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.functions.Function0;
/* compiled from: ContentColor.kt */
/* loaded from: classes.dex */
public abstract class ContentColorKt {
    private static final ProvidableCompositionLocal LocalContentColor = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.ContentColorKt$LocalContentColor$1
        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Object invoke() {
            return Color.m841boximpl(m478invoke0d7_KjU());
        }

        /* renamed from: invoke-0d7_KjU  reason: not valid java name */
        public final long m478invoke0d7_KjU() {
            return Color.Companion.m860getBlack0d7_KjU();
        }
    }, 1, null);

    public static final ProvidableCompositionLocal getLocalContentColor() {
        return LocalContentColor;
    }
}
