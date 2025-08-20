package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import ch.qos.logback.core.CoreConstants;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
/* compiled from: Arrangement.kt */
/* loaded from: classes.dex */
public final class Arrangement {
    public static final Arrangement INSTANCE = new Arrangement();
    private static final Horizontal Start = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$Start$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo189getSpacingD9Ej5fM() {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(0);
            return m1897constructorimpl;
        }

        public String toString() {
            return "Arrangement#Start";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, sizes, outPositions, true);
            }
        }
    };
    private static final Horizontal End = new Horizontal() { // from class: androidx.compose.foundation.layout.Arrangement$End$1
        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo189getSpacingD9Ej5fM() {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(0);
            return m1897constructorimpl;
        }

        public String toString() {
            return "Arrangement#End";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, true);
            }
        }
    };
    private static final Vertical Top = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Top$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public /* synthetic */ float mo189getSpacingD9Ej5fM() {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(0);
            return m1897constructorimpl;
        }

        public String toString() {
            return "Arrangement#Top";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeLeftOrTop$foundation_layout_release(sizes, outPositions, false);
        }
    };
    private static final Vertical Bottom = new Vertical() { // from class: androidx.compose.foundation.layout.Arrangement$Bottom$1
        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
        public /* synthetic */ float mo189getSpacingD9Ej5fM() {
            float m1897constructorimpl;
            m1897constructorimpl = Dp.m1897constructorimpl(0);
            return m1897constructorimpl;
        }

        public String toString() {
            return "Arrangement#Bottom";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i, sizes, outPositions, false);
        }
    };
    private static final HorizontalOrVertical Center = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$Center$1
        private final float spacing = Dp.m1897constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo189getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#Center";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeCenter$foundation_layout_release(i, sizes, outPositions, false);
        }
    };
    private static final HorizontalOrVertical SpaceEvenly = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceEvenly$1
        private final float spacing = Dp.m1897constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo189getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceEvenly";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i, sizes, outPositions, false);
        }
    };
    private static final HorizontalOrVertical SpaceBetween = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceBetween$1
        private final float spacing = Dp.m1897constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo189getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceBetween";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceBetween$foundation_layout_release(i, sizes, outPositions, false);
        }
    };
    private static final HorizontalOrVertical SpaceAround = new HorizontalOrVertical() { // from class: androidx.compose.foundation.layout.Arrangement$SpaceAround$1
        private final float spacing = Dp.m1897constructorimpl(0);

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo189getSpacingD9Ej5fM() {
            return this.spacing;
        }

        public String toString() {
            return "Arrangement#SpaceAround";
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (layoutDirection == LayoutDirection.Ltr) {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, sizes, outPositions, false);
            } else {
                Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, sizes, outPositions, true);
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            Arrangement.INSTANCE.placeSpaceAround$foundation_layout_release(i, sizes, outPositions, false);
        }
    };

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public interface HorizontalOrVertical extends Horizontal, Vertical {
    }

    private Arrangement() {
    }

    public final Vertical getBottom() {
        return Bottom;
    }

    public final HorizontalOrVertical getCenter() {
        return Center;
    }

    public final Horizontal getEnd() {
        return End;
    }

    public final Horizontal getStart() {
        return Start;
    }

    public final Vertical getTop() {
        return Top;
    }

    /* renamed from: spacedBy-0680j_4  reason: not valid java name */
    public final HorizontalOrVertical m187spacedBy0680j_4(float f) {
        return new SpacedAligned(f, true, new Function2() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
                return Integer.valueOf(Alignment.Companion.getStart().align(0, i, layoutDirection));
            }
        }, null);
    }

    /* renamed from: spacedBy-D5KLDUw  reason: not valid java name */
    public final Vertical m188spacedByD5KLDUw(float f, final Alignment.Vertical alignment) {
        Intrinsics.checkNotNullParameter(alignment, "alignment");
        return new SpacedAligned(f, false, new Function2() { // from class: androidx.compose.foundation.layout.Arrangement$spacedBy$3
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            public final Integer invoke(int i, LayoutDirection layoutDirection) {
                Intrinsics.checkNotNullParameter(layoutDirection, "<anonymous parameter 1>");
                return Integer.valueOf(Alignment.Vertical.this.align(0, i));
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
            }
        }, null);
    }

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public static final class SpacedAligned implements HorizontalOrVertical {
        private final Function2 alignment;
        private final boolean rtlMirror;
        private final float space;
        private final float spacing;

        public /* synthetic */ SpacedAligned(float f, boolean z, Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
            this(f, z, function2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof SpacedAligned) {
                SpacedAligned spacedAligned = (SpacedAligned) obj;
                return Dp.m1899equalsimpl0(this.space, spacedAligned.space) && this.rtlMirror == spacedAligned.rtlMirror && Intrinsics.areEqual(this.alignment, spacedAligned.alignment);
            }
            return false;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal, androidx.compose.foundation.layout.Arrangement.Vertical
        /* renamed from: getSpacing-D9Ej5fM */
        public float mo189getSpacingD9Ej5fM() {
            return this.spacing;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public int hashCode() {
            int m1900hashCodeimpl = Dp.m1900hashCodeimpl(this.space) * 31;
            boolean z = this.rtlMirror;
            int i = z;
            if (z != 0) {
                i = 1;
            }
            int i2 = (m1900hashCodeimpl + i) * 31;
            Function2 function2 = this.alignment;
            return i2 + (function2 == null ? 0 : function2.hashCode());
        }

        private SpacedAligned(float f, boolean z, Function2 function2) {
            this.space = f;
            this.rtlMirror = z;
            this.alignment = function2;
            this.spacing = f;
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Horizontal
        public void arrange(Density density, int i, int[] sizes, LayoutDirection layoutDirection, int[] outPositions) {
            int i2;
            int i3;
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            if (sizes.length == 0) {
                return;
            }
            int mo150roundToPx0680j_4 = density.mo150roundToPx0680j_4(this.space);
            boolean z = this.rtlMirror && layoutDirection == LayoutDirection.Rtl;
            Arrangement arrangement = Arrangement.INSTANCE;
            if (z) {
                i2 = 0;
                i3 = 0;
                for (int length = sizes.length - 1; -1 < length; length--) {
                    int i4 = sizes[length];
                    int min = Math.min(i2, i - i4);
                    outPositions[length] = min;
                    i3 = Math.min(mo150roundToPx0680j_4, (i - min) - i4);
                    i2 = outPositions[length] + i4 + i3;
                }
            } else {
                int length2 = sizes.length;
                int i5 = 0;
                i2 = 0;
                i3 = 0;
                int i6 = 0;
                while (i5 < length2) {
                    int i7 = sizes[i5];
                    int min2 = Math.min(i2, i - i7);
                    outPositions[i6] = min2;
                    int min3 = Math.min(mo150roundToPx0680j_4, (i - min2) - i7);
                    int i8 = outPositions[i6] + i7 + min3;
                    i5++;
                    i6++;
                    i3 = min3;
                    i2 = i8;
                }
            }
            int i9 = i2 - i3;
            Function2 function2 = this.alignment;
            if (function2 == null || i9 >= i) {
                return;
            }
            int intValue = ((Number) function2.invoke(Integer.valueOf(i - i9), layoutDirection)).intValue();
            int length3 = outPositions.length;
            for (int i10 = 0; i10 < length3; i10++) {
                outPositions[i10] = outPositions[i10] + intValue;
            }
        }

        @Override // androidx.compose.foundation.layout.Arrangement.Vertical
        public void arrange(Density density, int i, int[] sizes, int[] outPositions) {
            Intrinsics.checkNotNullParameter(density, "<this>");
            Intrinsics.checkNotNullParameter(sizes, "sizes");
            Intrinsics.checkNotNullParameter(outPositions, "outPositions");
            arrange(density, i, sizes, LayoutDirection.Ltr, outPositions);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.rtlMirror ? "" : "Absolute");
            sb.append("Arrangement#spacedAligned(");
            sb.append((Object) Dp.m1901toStringimpl(this.space));
            sb.append(", ");
            sb.append(this.alignment);
            sb.append(CoreConstants.RIGHT_PARENTHESIS_CHAR);
            return sb.toString();
        }
    }

    public final void placeSpaceBetween$foundation_layout_release(int i, int[] size, int[] outPosition, boolean z) {
        int lastIndex;
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        if (size.length == 0) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        for (int i4 : size) {
            i3 += i4;
        }
        lastIndex = ArraysKt___ArraysKt.getLastIndex(size);
        float max = (i - i3) / Math.max(lastIndex, 1);
        float f = (z && size.length == 1) ? max : 0.0f;
        if (z) {
            for (int length = size.length - 1; -1 < length; length--) {
                int i5 = size[length];
                roundToInt = MathKt__MathJVMKt.roundToInt(f);
                outPosition[length] = roundToInt;
                f += i5 + max;
            }
            return;
        }
        int length2 = size.length;
        int i6 = 0;
        while (i2 < length2) {
            int i7 = size[i2];
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f);
            outPosition[i6] = roundToInt2;
            f += i7 + max;
            i2++;
            i6++;
        }
    }

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public interface Horizontal {
        void arrange(Density density, int i, int[] iArr, LayoutDirection layoutDirection, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        float mo189getSpacingD9Ej5fM();

        /* compiled from: Arrangement.kt */
        /* renamed from: androidx.compose.foundation.layout.Arrangement$Horizontal$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
        }
    }

    /* compiled from: Arrangement.kt */
    /* loaded from: classes.dex */
    public interface Vertical {
        void arrange(Density density, int i, int[] iArr, int[] iArr2);

        /* renamed from: getSpacing-D9Ej5fM */
        float mo189getSpacingD9Ej5fM();

        /* compiled from: Arrangement.kt */
        /* renamed from: androidx.compose.foundation.layout.Arrangement$Vertical$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
        }
    }

    public final void placeRightOrBottom$foundation_layout_release(int i, int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : size) {
            i3 += i4;
        }
        int i5 = i - i3;
        if (z) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i6 = size[length];
                outPosition[length] = i5;
                i5 += i6;
            }
        } else {
            int length2 = size.length;
            int i7 = 0;
            while (i2 < length2) {
                int i8 = size[i2];
                outPosition[i7] = i5;
                i5 += i8;
                i2++;
                i7++;
            }
        }
    }

    public final void placeLeftOrTop$foundation_layout_release(int[] size, int[] outPosition, boolean z) {
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int i = 0;
        if (z) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i2 = size[length];
                outPosition[length] = i;
                i += i2;
            }
        } else {
            int length2 = size.length;
            int i3 = 0;
            int i4 = 0;
            while (i < length2) {
                int i5 = size[i];
                outPosition[i3] = i4;
                i4 += i5;
                i++;
                i3++;
            }
        }
    }

    public final void placeCenter$foundation_layout_release(int i, int[] size, int[] outPosition, boolean z) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : size) {
            i3 += i4;
        }
        float f = (i - i3) / 2;
        if (z) {
            int length = size.length;
            while (true) {
                length--;
                if (-1 >= length) {
                    return;
                }
                int i5 = size[length];
                roundToInt = MathKt__MathJVMKt.roundToInt(f);
                outPosition[length] = roundToInt;
                f += i5;
            }
        } else {
            int length2 = size.length;
            int i6 = 0;
            while (i2 < length2) {
                int i7 = size[i2];
                roundToInt2 = MathKt__MathJVMKt.roundToInt(f);
                outPosition[i6] = roundToInt2;
                f += i7;
                i2++;
                i6++;
            }
        }
    }

    public final void placeSpaceEvenly$foundation_layout_release(int i, int[] size, int[] outPosition, boolean z) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : size) {
            i3 += i4;
        }
        float length = (i - i3) / (size.length + 1);
        if (z) {
            float f = length;
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i5 = size[length2];
                roundToInt = MathKt__MathJVMKt.roundToInt(f);
                outPosition[length2] = roundToInt;
                f += i5 + length;
            }
            return;
        }
        int length3 = size.length;
        float f2 = length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = size[i2];
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f2);
            outPosition[i6] = roundToInt2;
            f2 += i7 + length;
            i2++;
            i6++;
        }
    }

    public final void placeSpaceAround$foundation_layout_release(int i, int[] size, int[] outPosition, boolean z) {
        int roundToInt;
        int roundToInt2;
        Intrinsics.checkNotNullParameter(size, "size");
        Intrinsics.checkNotNullParameter(outPosition, "outPosition");
        int i2 = 0;
        int i3 = 0;
        for (int i4 : size) {
            i3 += i4;
        }
        float length = (size.length == 0) ^ true ? (i - i3) / size.length : 0.0f;
        float f = length / 2;
        if (z) {
            for (int length2 = size.length - 1; -1 < length2; length2--) {
                int i5 = size[length2];
                roundToInt = MathKt__MathJVMKt.roundToInt(f);
                outPosition[length2] = roundToInt;
                f += i5 + length;
            }
            return;
        }
        int length3 = size.length;
        int i6 = 0;
        while (i2 < length3) {
            int i7 = size[i2];
            roundToInt2 = MathKt__MathJVMKt.roundToInt(f);
            outPosition[i6] = roundToInt2;
            f += i7 + length;
            i2++;
            i6++;
        }
    }
}
