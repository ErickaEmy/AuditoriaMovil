package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Card.kt */
/* loaded from: classes.dex */
public abstract class CardKt {
    /* renamed from: Card-F-jzlyU  reason: not valid java name */
    public static final void m440CardFjzlyU(Modifier modifier, Shape shape, long j, long j2, BorderStroke borderStroke, float f, Function2 content, Composer composer, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        composer.startReplaceableGroup(1956755640);
        Modifier modifier2 = (i2 & 1) != 0 ? Modifier.Companion : modifier;
        CornerBasedShape medium = (i2 & 2) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getMedium() : shape;
        long m454getSurface0d7_KjU = (i2 & 4) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m454getSurface0d7_KjU() : j;
        long m468contentColorForek8zF_U = (i2 & 8) != 0 ? ColorsKt.m468contentColorForek8zF_U(m454getSurface0d7_KjU, composer, (i >> 6) & 14) : j2;
        BorderStroke borderStroke2 = (i2 & 16) != 0 ? null : borderStroke;
        float m1897constructorimpl = (i2 & 32) != 0 ? Dp.m1897constructorimpl(1) : f;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1956755640, i, -1, "androidx.compose.material.Card (Card.kt:58)");
        }
        SurfaceKt.m546SurfaceFjzlyU(modifier2, medium, m454getSurface0d7_KjU, m468contentColorForek8zF_U, borderStroke2, m1897constructorimpl, content, composer, (i & 14) | (i & 112) | (i & 896) | (i & 7168) | (57344 & i) | (458752 & i) | (i & 3670016), 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
    }
}
