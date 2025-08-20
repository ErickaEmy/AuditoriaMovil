package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
/* compiled from: ContentScale.kt */
/* loaded from: classes.dex */
public abstract class ContentScaleKt {
    /* renamed from: access$computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m1243access$computeFillHeightiLBOSCw(long j, long j2) {
        return m1247computeFillHeightiLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m1244access$computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return m1248computeFillMaxDimensioniLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m1245access$computeFillMinDimensioniLBOSCw(long j, long j2) {
        return m1249computeFillMinDimensioniLBOSCw(j, j2);
    }

    /* renamed from: access$computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m1246access$computeFillWidthiLBOSCw(long j, long j2) {
        return m1250computeFillWidthiLBOSCw(j, j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final float m1248computeFillMaxDimensioniLBOSCw(long j, long j2) {
        return Math.max(m1250computeFillWidthiLBOSCw(j, j2), m1247computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final float m1249computeFillMinDimensioniLBOSCw(long j, long j2) {
        return Math.min(m1250computeFillWidthiLBOSCw(j, j2), m1247computeFillHeightiLBOSCw(j, j2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final float m1250computeFillWidthiLBOSCw(long j, long j2) {
        return Size.m745getWidthimpl(j2) / Size.m745getWidthimpl(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final float m1247computeFillHeightiLBOSCw(long j, long j2) {
        return Size.m743getHeightimpl(j2) / Size.m743getHeightimpl(j);
    }
}
