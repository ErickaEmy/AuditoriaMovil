package androidx.compose.ui.graphics.drawscope;

import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.Path;
/* compiled from: DrawTransform.kt */
/* loaded from: classes.dex */
public interface DrawTransform {
    /* renamed from: clipPath-mtrdD-E */
    void mo1046clipPathmtrdDE(Path path, int i);

    /* renamed from: clipRect-N_I0leg */
    void mo1047clipRectN_I0leg(float f, float f2, float f3, float f4, int i);

    void inset(float f, float f2, float f3, float f4);

    /* renamed from: rotate-Uv8p0NA */
    void mo1049rotateUv8p0NA(float f, long j);

    /* renamed from: scale-0AR0LA0 */
    void mo1050scale0AR0LA0(float f, float f2, long j);

    /* renamed from: transform-58bKbWc */
    void mo1051transform58bKbWc(float[] fArr);

    void translate(float f, float f2);

    /* compiled from: DrawTransform.kt */
    /* renamed from: androidx.compose.ui.graphics.drawscope.DrawTransform$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        /* renamed from: clipPath-mtrdD-E$default  reason: not valid java name */
        public static /* synthetic */ void m1067clipPathmtrdDE$default(DrawTransform drawTransform, Path path, int i, int i2, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: clipPath-mtrdD-E");
            }
            if ((i2 & 2) != 0) {
                i = ClipOp.Companion.m840getIntersectrtfAjoo();
            }
            drawTransform.mo1046clipPathmtrdDE(path, i);
        }

        public static /* synthetic */ void translate$default(DrawTransform drawTransform, float f, float f2, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: translate");
            }
            if ((i & 1) != 0) {
                f = 0.0f;
            }
            if ((i & 2) != 0) {
                f2 = 0.0f;
            }
            drawTransform.translate(f, f2);
        }
    }
}
