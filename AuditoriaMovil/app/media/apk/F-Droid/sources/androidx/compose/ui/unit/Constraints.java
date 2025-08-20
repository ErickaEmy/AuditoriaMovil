package androidx.compose.ui.unit;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Constraints.kt */
/* loaded from: classes.dex */
public final class Constraints {
    private final long value;
    public static final Companion Companion = new Companion(null);
    private static final int[] MinHeightOffsets = {18, 20, 17, 15};
    private static final int[] WidthMask = {65535, 262143, 32767, 8191};
    private static final int[] HeightMask = {32767, 8191, 65535, 262143};

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Constraints m1860boximpl(long j) {
        return new Constraints(j);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m1861constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1864equalsimpl(long j, Object obj) {
        return (obj instanceof Constraints) && j == ((Constraints) obj).m1877unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1865equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: getFocusIndex-impl  reason: not valid java name */
    private static final int m1866getFocusIndeximpl(long j) {
        return (int) (j & 3);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1875hashCodeimpl(long j) {
        return FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(j);
    }

    public boolean equals(Object obj) {
        return m1864equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1875hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ long m1877unboximpl() {
        return this.value;
    }

    private /* synthetic */ Constraints(long j) {
        this.value = j;
    }

    /* renamed from: getMinWidth-impl  reason: not valid java name */
    public static final int m1874getMinWidthimpl(long j) {
        return ((int) (j >> 2)) & WidthMask[m1866getFocusIndeximpl(j)];
    }

    /* renamed from: getMaxWidth-impl  reason: not valid java name */
    public static final int m1872getMaxWidthimpl(long j) {
        int i = ((int) (j >> 33)) & WidthMask[m1866getFocusIndeximpl(j)];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getMinHeight-impl  reason: not valid java name */
    public static final int m1873getMinHeightimpl(long j) {
        int m1866getFocusIndeximpl = m1866getFocusIndeximpl(j);
        return ((int) (j >> MinHeightOffsets[m1866getFocusIndeximpl])) & HeightMask[m1866getFocusIndeximpl];
    }

    /* renamed from: getMaxHeight-impl  reason: not valid java name */
    public static final int m1871getMaxHeightimpl(long j) {
        int m1866getFocusIndeximpl = m1866getFocusIndeximpl(j);
        int i = ((int) (j >> (MinHeightOffsets[m1866getFocusIndeximpl] + 31))) & HeightMask[m1866getFocusIndeximpl];
        if (i == 0) {
            return Integer.MAX_VALUE;
        }
        return i - 1;
    }

    /* renamed from: getHasBoundedWidth-impl  reason: not valid java name */
    public static final boolean m1868getHasBoundedWidthimpl(long j) {
        return (((int) (j >> 33)) & WidthMask[m1866getFocusIndeximpl(j)]) != 0;
    }

    /* renamed from: getHasBoundedHeight-impl  reason: not valid java name */
    public static final boolean m1867getHasBoundedHeightimpl(long j) {
        int m1866getFocusIndeximpl = m1866getFocusIndeximpl(j);
        return (((int) (j >> (MinHeightOffsets[m1866getFocusIndeximpl] + 31))) & HeightMask[m1866getFocusIndeximpl]) != 0;
    }

    /* renamed from: getHasFixedWidth-impl  reason: not valid java name */
    public static final boolean m1870getHasFixedWidthimpl(long j) {
        return m1872getMaxWidthimpl(j) == m1874getMinWidthimpl(j);
    }

    /* renamed from: getHasFixedHeight-impl  reason: not valid java name */
    public static final boolean m1869getHasFixedHeightimpl(long j) {
        return m1871getMaxHeightimpl(j) == m1873getMinHeightimpl(j);
    }

    /* renamed from: copy-Zbe2FdA$default  reason: not valid java name */
    public static /* synthetic */ long m1863copyZbe2FdA$default(long j, int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i = m1874getMinWidthimpl(j);
        }
        int i6 = i;
        if ((i5 & 2) != 0) {
            i2 = m1872getMaxWidthimpl(j);
        }
        int i7 = i2;
        if ((i5 & 4) != 0) {
            i3 = m1873getMinHeightimpl(j);
        }
        int i8 = i3;
        if ((i5 & 8) != 0) {
            i4 = m1871getMaxHeightimpl(j);
        }
        return m1862copyZbe2FdA(j, i6, i7, i8, i4);
    }

    /* renamed from: copy-Zbe2FdA  reason: not valid java name */
    public static final long m1862copyZbe2FdA(long j, int i, int i2, int i3, int i4) {
        if (i3 < 0 || i < 0) {
            throw new IllegalArgumentException(("minHeight(" + i3 + ") and minWidth(" + i + ") must be >= 0").toString());
        } else if (i2 < i && i2 != Integer.MAX_VALUE) {
            throw new IllegalArgumentException(("maxWidth(" + i2 + ") must be >= minWidth(" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else if (i4 < i3 && i4 != Integer.MAX_VALUE) {
            throw new IllegalArgumentException(("maxHeight(" + i4 + ") must be >= minHeight(" + i3 + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
        } else {
            return Companion.m1878createConstraintsZbe2FdA$ui_unit_release(i, i2, i3, i4);
        }
    }

    public String toString() {
        return m1876toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1876toStringimpl(long j) {
        int m1872getMaxWidthimpl = m1872getMaxWidthimpl(j);
        String valueOf = m1872getMaxWidthimpl == Integer.MAX_VALUE ? "Infinity" : String.valueOf(m1872getMaxWidthimpl);
        int m1871getMaxHeightimpl = m1871getMaxHeightimpl(j);
        String valueOf2 = m1871getMaxHeightimpl != Integer.MAX_VALUE ? String.valueOf(m1871getMaxHeightimpl) : "Infinity";
        return "Constraints(minWidth = " + m1874getMinWidthimpl(j) + ", maxWidth = " + valueOf + ", minHeight = " + m1873getMinHeightimpl(j) + ", maxHeight = " + valueOf2 + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: Constraints.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: fixed-JhjzzOo  reason: not valid java name */
        public final long m1879fixedJhjzzOo(int i, int i2) {
            if (i < 0 || i2 < 0) {
                throw new IllegalArgumentException(("width(" + i + ") and height(" + i2 + ") must be >= 0").toString());
            }
            return m1878createConstraintsZbe2FdA$ui_unit_release(i, i, i2, i2);
        }

        /* renamed from: fixedWidth-OenEA2s  reason: not valid java name */
        public final long m1880fixedWidthOenEA2s(int i) {
            if (i < 0) {
                throw new IllegalArgumentException(("width(" + i + ") must be >= 0").toString());
            }
            return m1878createConstraintsZbe2FdA$ui_unit_release(i, i, 0, Integer.MAX_VALUE);
        }

        /* renamed from: createConstraints-Zbe2FdA$ui_unit_release  reason: not valid java name */
        public final long m1878createConstraintsZbe2FdA$ui_unit_release(int i, int i2, int i3, int i4) {
            long j;
            int i5 = i4 == Integer.MAX_VALUE ? i3 : i4;
            int bitsNeedForSize = bitsNeedForSize(i5);
            int i6 = i2 == Integer.MAX_VALUE ? i : i2;
            int bitsNeedForSize2 = bitsNeedForSize(i6);
            if (bitsNeedForSize + bitsNeedForSize2 > 31) {
                throw new IllegalArgumentException("Can't represent a width of " + i6 + " and height of " + i5 + " in Constraints");
            }
            if (bitsNeedForSize2 == 13) {
                j = 3;
            } else if (bitsNeedForSize2 == 18) {
                j = 1;
            } else if (bitsNeedForSize2 == 15) {
                j = 2;
            } else if (bitsNeedForSize2 != 16) {
                throw new IllegalStateException("Should only have the provided constants.");
            } else {
                j = 0;
            }
            int i7 = i2 == Integer.MAX_VALUE ? 0 : i2 + 1;
            int i8 = i4 != Integer.MAX_VALUE ? i4 + 1 : 0;
            int i9 = Constraints.MinHeightOffsets[(int) j];
            return Constraints.m1861constructorimpl((i7 << 33) | j | (i << 2) | (i3 << i9) | (i8 << (i9 + 31)));
        }

        private final int bitsNeedForSize(int i) {
            if (i < 8191) {
                return 13;
            }
            if (i < 32767) {
                return 15;
            }
            if (i < 65535) {
                return 16;
            }
            if (i < 262143) {
                return 18;
            }
            throw new IllegalArgumentException("Can't represent a size of " + i + " in Constraints");
        }
    }
}
