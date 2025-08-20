package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: VisibilityThresholds.kt */
/* loaded from: classes.dex */
public abstract class VisibilityThresholdsKt {
    private static final Rect rectVisibilityThreshold;
    private static final Map visibilityThresholdMap;

    public static final int getVisibilityThreshold(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return 1;
    }

    public static final Rect getVisibilityThreshold(Rect.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return rectVisibilityThreshold;
    }

    public static final Map getVisibilityThresholdMap() {
        return visibilityThresholdMap;
    }

    static {
        Map mapOf;
        Float valueOf = Float.valueOf(0.5f);
        rectVisibilityThreshold = new Rect(0.5f, 0.5f, 0.5f, 0.5f);
        TwoWayConverter vectorConverter = VectorConvertersKt.getVectorConverter(IntCompanionObject.INSTANCE);
        Float valueOf2 = Float.valueOf(1.0f);
        TwoWayConverter vectorConverter2 = VectorConvertersKt.getVectorConverter(Dp.Companion);
        Float valueOf3 = Float.valueOf(0.1f);
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(vectorConverter, valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntSize.Companion), valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(IntOffset.Companion), valueOf2), TuplesKt.to(VectorConvertersKt.getVectorConverter(FloatCompanionObject.INSTANCE), Float.valueOf(0.01f)), TuplesKt.to(VectorConvertersKt.getVectorConverter(Rect.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Size.Companion), valueOf), TuplesKt.to(VectorConvertersKt.getVectorConverter(Offset.Companion), valueOf), TuplesKt.to(vectorConverter2, valueOf3), TuplesKt.to(VectorConvertersKt.getVectorConverter(DpOffset.Companion), valueOf3));
        visibilityThresholdMap = mapOf;
    }

    public static final long getVisibilityThreshold(IntOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntOffsetKt.IntOffset(1, 1);
    }

    public static final long getVisibilityThreshold(Offset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return OffsetKt.Offset(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(Size.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SizeKt.Size(0.5f, 0.5f);
    }

    public static final long getVisibilityThreshold(IntSize.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntSizeKt.IntSize(1, 1);
    }

    public static final float getVisibilityThreshold(Dp.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return Dp.m1897constructorimpl(0.1f);
    }
}
