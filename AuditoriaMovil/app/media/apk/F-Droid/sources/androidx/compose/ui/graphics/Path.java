package androidx.compose.ui.graphics;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.RoundRect;
/* compiled from: Path.kt */
/* loaded from: classes.dex */
public interface Path {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: Path.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }

    /* renamed from: addPath-Uv8p0NA */
    void mo788addPathUv8p0NA(Path path, long j);

    void addRect(Rect rect);

    void addRoundRect(RoundRect roundRect);

    void close();

    void cubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    Rect getBounds();

    /* renamed from: getFillType-Rg-k1Os */
    int mo789getFillTypeRgk1Os();

    boolean isConvex();

    boolean isEmpty();

    void lineTo(float f, float f2);

    void moveTo(float f, float f2);

    /* renamed from: op-N5in7k0 */
    boolean mo790opN5in7k0(Path path, Path path2, int i);

    void relativeCubicTo(float f, float f2, float f3, float f4, float f5, float f6);

    void relativeLineTo(float f, float f2);

    void reset();

    void rewind();

    /* renamed from: setFillType-oQ8Xj4U */
    void mo791setFillTypeoQ8Xj4U(int i);

    /* renamed from: translate-k-4lQ0M */
    void mo792translatek4lQ0M(long j);

    /* compiled from: Path.kt */
    /* renamed from: androidx.compose.ui.graphics.Path$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        static {
            Companion companion = Path.Companion;
        }

        /* renamed from: addPath-Uv8p0NA$default  reason: not valid java name */
        public static /* synthetic */ void m932addPathUv8p0NA$default(Path path, Path path2, long j, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addPath-Uv8p0NA");
            }
            if ((i & 2) != 0) {
                j = Offset.Companion.m721getZeroF1C5BW0();
            }
            path.mo788addPathUv8p0NA(path2, j);
        }
    }
}
