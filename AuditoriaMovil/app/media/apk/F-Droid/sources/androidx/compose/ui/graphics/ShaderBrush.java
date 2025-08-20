package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Brush.kt */
/* loaded from: classes.dex */
public abstract class ShaderBrush extends Brush {
    private long createdSize;
    private Shader internalShader;

    /* renamed from: createShader-uvyYCjk */
    public abstract Shader mo832createShaderuvyYCjk(long j);

    public ShaderBrush() {
        super(null);
        this.createdSize = Size.Companion.m750getUnspecifiedNHjbRc();
    }

    @Override // androidx.compose.ui.graphics.Brush
    /* renamed from: applyTo-Pq9zytI */
    public final void mo831applyToPq9zytI(long j, Paint p, float f) {
        Intrinsics.checkNotNullParameter(p, "p");
        Shader shader = this.internalShader;
        if (shader == null || !Size.m742equalsimpl0(this.createdSize, j)) {
            if (Size.m747isEmptyimpl(j)) {
                shader = null;
                this.internalShader = null;
                this.createdSize = Size.Companion.m750getUnspecifiedNHjbRc();
            } else {
                shader = mo832createShaderuvyYCjk(j);
                this.internalShader = shader;
                this.createdSize = j;
            }
        }
        long mo772getColor0d7_KjU = p.mo772getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m851equalsimpl0(mo772getColor0d7_KjU, companion.m860getBlack0d7_KjU())) {
            p.mo777setColor8_81llA(companion.m860getBlack0d7_KjU());
        }
        if (!Intrinsics.areEqual(p.getShader(), shader)) {
            p.setShader(shader);
        }
        if (p.getAlpha() == f) {
            return;
        }
        p.setAlpha(f);
    }
}
