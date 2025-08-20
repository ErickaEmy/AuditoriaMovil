package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: ColorVectorConverter.kt */
/* loaded from: classes.dex */
public abstract class ColorVectorConverterKt {
    private static final Function1 ColorToVector = new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1
        @Override // kotlin.jvm.functions.Function1
        public final TwoWayConverter invoke(final ColorSpace colorSpace) {
            Intrinsics.checkNotNullParameter(colorSpace, "colorSpace");
            return VectorConvertersKt.TwoWayConverter(new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m14invoke8_81llA(((Color) obj).m859unboximpl());
                }

                /* renamed from: invoke-8_81llA  reason: not valid java name */
                public final AnimationVector4D m14invoke8_81llA(long j) {
                    long m847convertvNxB06k = Color.m847convertvNxB06k(j, ColorSpaces.INSTANCE.getOklab());
                    return new AnimationVector4D(Color.m845component4impl(m847convertvNxB06k), Color.m842component1impl(m847convertvNxB06k), Color.m843component2impl(m847convertvNxB06k), Color.m844component3impl(m847convertvNxB06k));
                }
            }, new Function1() { // from class: androidx.compose.animation.ColorVectorConverterKt$ColorToVector$1.2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return Color.m841boximpl(m15invokevNxB06k((AnimationVector4D) obj));
                }

                /* renamed from: invoke-vNxB06k  reason: not valid java name */
                public final long m15invokevNxB06k(AnimationVector4D vector) {
                    float coerceIn;
                    float coerceIn2;
                    float coerceIn3;
                    float coerceIn4;
                    Intrinsics.checkNotNullParameter(vector, "vector");
                    coerceIn = RangesKt___RangesKt.coerceIn(vector.getV2(), 0.0f, 1.0f);
                    coerceIn2 = RangesKt___RangesKt.coerceIn(vector.getV3(), -0.5f, 0.5f);
                    coerceIn3 = RangesKt___RangesKt.coerceIn(vector.getV4(), -0.5f, 0.5f);
                    coerceIn4 = RangesKt___RangesKt.coerceIn(vector.getV1(), 0.0f, 1.0f);
                    return Color.m847convertvNxB06k(ColorKt.Color(coerceIn, coerceIn2, coerceIn3, coerceIn4, ColorSpaces.INSTANCE.getOklab()), ColorSpace.this);
                }
            });
        }
    };

    public static final Function1 getVectorConverter(Color.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ColorToVector;
    }
}
