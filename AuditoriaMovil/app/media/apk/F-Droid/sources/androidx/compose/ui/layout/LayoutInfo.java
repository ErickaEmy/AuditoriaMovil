package androidx.compose.ui.layout;

import androidx.compose.ui.unit.LayoutDirection;
/* compiled from: LayoutInfo.kt */
/* loaded from: classes.dex */
public interface LayoutInfo {
    LayoutCoordinates getCoordinates();

    LayoutDirection getLayoutDirection();

    boolean isPlaced();
}
