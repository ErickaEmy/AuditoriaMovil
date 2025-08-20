package androidx.compose.animation.core;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.DpKt;
import androidx.compose.ui.unit.DpOffset;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FloatCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: VectorConverters.kt */
/* loaded from: classes.dex */
public abstract class VectorConvertersKt {
    private static final TwoWayConverter FloatToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$1
        public final AnimationVector1D invoke(float f) {
            return new AnimationVector1D(f);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).floatValue());
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$FloatToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Float invoke(AnimationVector1D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Float.valueOf(it.getValue());
        }
    });
    private static final TwoWayConverter IntToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$1
        public final AnimationVector1D invoke(int i) {
            return new AnimationVector1D(i);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return invoke(((Number) obj).intValue());
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Integer invoke(AnimationVector1D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf((int) it.getValue());
        }
    });
    private static final TwoWayConverter DpToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m49invoke0680j_4(((Dp) obj).m1903unboximpl());
        }

        /* renamed from: invoke-0680j_4  reason: not valid java name */
        public final AnimationVector1D m49invoke0680j_4(float f) {
            return new AnimationVector1D(f);
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Dp.m1895boximpl(m50invokeu2uoSUM((AnimationVector1D) obj));
        }

        /* renamed from: invoke-u2uoSUM  reason: not valid java name */
        public final float m50invokeu2uoSUM(AnimationVector1D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Dp.m1897constructorimpl(it.getValue());
        }
    });
    private static final TwoWayConverter DpOffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m47invokejoFl9I(((DpOffset) obj).m1916unboximpl());
        }

        /* renamed from: invoke-jo-Fl9I  reason: not valid java name */
        public final AnimationVector2D m47invokejoFl9I(long j) {
            return new AnimationVector2D(DpOffset.m1912getXD9Ej5fM(j), DpOffset.m1913getYD9Ej5fM(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$DpOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return DpOffset.m1908boximpl(m48invokegVRvYmI((AnimationVector2D) obj));
        }

        /* renamed from: invoke-gVRvYmI  reason: not valid java name */
        public final long m48invokegVRvYmI(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return DpKt.m1906DpOffsetYgX7TsA(Dp.m1897constructorimpl(it.getV1()), Dp.m1897constructorimpl(it.getV2()));
        }
    });
    private static final TwoWayConverter SizeToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m57invokeuvyYCjk(((Size) obj).m749unboximpl());
        }

        /* renamed from: invoke-uvyYCjk  reason: not valid java name */
        public final AnimationVector2D m57invokeuvyYCjk(long j) {
            return new AnimationVector2D(Size.m745getWidthimpl(j), Size.m743getHeightimpl(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$SizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Size.m739boximpl(m58invoke7Ah8Wj8((AnimationVector2D) obj));
        }

        /* renamed from: invoke-7Ah8Wj8  reason: not valid java name */
        public final long m58invoke7Ah8Wj8(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return SizeKt.Size(it.getV1(), it.getV2());
        }
    });
    private static final TwoWayConverter OffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m55invokek4lQ0M(((Offset) obj).m718unboximpl());
        }

        /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
        public final AnimationVector2D m55invokek4lQ0M(long j) {
            return new AnimationVector2D(Offset.m709getXimpl(j), Offset.m710getYimpl(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$OffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return Offset.m698boximpl(m56invoketuRUvjQ((AnimationVector2D) obj));
        }

        /* renamed from: invoke-tuRUvjQ  reason: not valid java name */
        public final long m56invoketuRUvjQ(AnimationVector2D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return OffsetKt.Offset(it.getV1(), it.getV2());
        }
    });
    private static final TwoWayConverter IntOffsetToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m51invokegyyYBs(((IntOffset) obj).m1941unboximpl());
        }

        /* renamed from: invoke--gyyYBs  reason: not valid java name */
        public final AnimationVector2D m51invokegyyYBs(long j) {
            return new AnimationVector2D(IntOffset.m1937getXimpl(j), IntOffset.m1938getYimpl(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntOffsetToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntOffset.m1929boximpl(m52invokeBjo55l4((AnimationVector2D) obj));
        }

        /* renamed from: invoke-Bjo55l4  reason: not valid java name */
        public final long m52invokeBjo55l4(AnimationVector2D it) {
            int roundToInt;
            int roundToInt2;
            Intrinsics.checkNotNullParameter(it, "it");
            roundToInt = MathKt__MathJVMKt.roundToInt(it.getV1());
            roundToInt2 = MathKt__MathJVMKt.roundToInt(it.getV2());
            return IntOffsetKt.IntOffset(roundToInt, roundToInt2);
        }
    });
    private static final TwoWayConverter IntSizeToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return m53invokeozmzZPI(((IntSize) obj).m1954unboximpl());
        }

        /* renamed from: invoke-ozmzZPI  reason: not valid java name */
        public final AnimationVector2D m53invokeozmzZPI(long j) {
            return new AnimationVector2D(IntSize.m1951getWidthimpl(j), IntSize.m1950getHeightimpl(j));
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$IntSizeToVector$2
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return IntSize.m1946boximpl(m54invokeYEO4UFw((AnimationVector2D) obj));
        }

        /* renamed from: invoke-YEO4UFw  reason: not valid java name */
        public final long m54invokeYEO4UFw(AnimationVector2D it) {
            int roundToInt;
            int roundToInt2;
            Intrinsics.checkNotNullParameter(it, "it");
            roundToInt = MathKt__MathJVMKt.roundToInt(it.getV1());
            roundToInt2 = MathKt__MathJVMKt.roundToInt(it.getV2());
            return IntSizeKt.IntSize(roundToInt, roundToInt2);
        }
    });
    private static final TwoWayConverter RectToVector = TwoWayConverter(new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final AnimationVector4D invoke(Rect it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new AnimationVector4D(it.getLeft(), it.getTop(), it.getRight(), it.getBottom());
        }
    }, new Function1() { // from class: androidx.compose.animation.core.VectorConvertersKt$RectToVector$2
        @Override // kotlin.jvm.functions.Function1
        public final Rect invoke(AnimationVector4D it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Rect(it.getV1(), it.getV2(), it.getV3(), it.getV4());
        }
    });

    public static final TwoWayConverter getVectorConverter(Offset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return OffsetToVector;
    }

    public static final TwoWayConverter getVectorConverter(Rect.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return RectToVector;
    }

    public static final TwoWayConverter getVectorConverter(Size.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return SizeToVector;
    }

    public static final TwoWayConverter getVectorConverter(Dp.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return DpToVector;
    }

    public static final TwoWayConverter getVectorConverter(DpOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return DpOffsetToVector;
    }

    public static final TwoWayConverter getVectorConverter(IntOffset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntOffsetToVector;
    }

    public static final TwoWayConverter getVectorConverter(IntSize.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return IntSizeToVector;
    }

    public static final TwoWayConverter getVectorConverter(FloatCompanionObject floatCompanionObject) {
        Intrinsics.checkNotNullParameter(floatCompanionObject, "<this>");
        return FloatToVector;
    }

    public static final TwoWayConverter getVectorConverter(IntCompanionObject intCompanionObject) {
        Intrinsics.checkNotNullParameter(intCompanionObject, "<this>");
        return IntToVector;
    }

    public static final float lerp(float f, float f2, float f3) {
        return (f * (1 - f3)) + (f2 * f3);
    }

    public static final TwoWayConverter TwoWayConverter(Function1 convertToVector, Function1 convertFromVector) {
        Intrinsics.checkNotNullParameter(convertToVector, "convertToVector");
        Intrinsics.checkNotNullParameter(convertFromVector, "convertFromVector");
        return new TwoWayConverterImpl(convertToVector, convertFromVector);
    }
}
