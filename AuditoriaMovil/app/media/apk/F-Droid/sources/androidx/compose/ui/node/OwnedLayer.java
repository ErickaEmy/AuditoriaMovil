package androidx.compose.ui.node;

import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.RenderEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
/* compiled from: OwnedLayer.kt */
/* loaded from: classes.dex */
public interface OwnedLayer {
    void destroy();

    void drawLayer(Canvas canvas);

    void invalidate();

    /* renamed from: isInLayer-k-4lQ0M  reason: not valid java name */
    boolean mo1388isInLayerk4lQ0M(long j);

    void mapBounds(MutableRect mutableRect, boolean z);

    /* renamed from: mapOffset-8S9VItk  reason: not valid java name */
    long mo1389mapOffset8S9VItk(long j, boolean z);

    /* renamed from: move--gyyYBs  reason: not valid java name */
    void mo1390movegyyYBs(long j);

    /* renamed from: resize-ozmzZPI  reason: not valid java name */
    void mo1391resizeozmzZPI(long j);

    void reuseLayer(Function1 function1, Function0 function0);

    void updateDisplayList();

    /* renamed from: updateLayerProperties-dDxr-wY  reason: not valid java name */
    void mo1392updateLayerPropertiesdDxrwY(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, long j, Shape shape, boolean z, RenderEffect renderEffect, long j2, long j3, int i, LayoutDirection layoutDirection, Density density);
}
