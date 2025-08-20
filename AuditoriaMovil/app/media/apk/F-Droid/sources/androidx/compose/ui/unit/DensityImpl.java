package androidx.compose.ui.unit;

import androidx.compose.ui.unit.Density;
import ch.qos.logback.core.CoreConstants;
/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Density.kt */
/* loaded from: classes.dex */
public final class DensityImpl implements Density {
    private final float density;
    private final float fontScale;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DensityImpl) {
            DensityImpl densityImpl = (DensityImpl) obj;
            return Float.compare(this.density, densityImpl.density) == 0 && Float.compare(this.fontScale, densityImpl.fontScale) == 0;
        }
        return false;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getDensity() {
        return this.density;
    }

    @Override // androidx.compose.ui.unit.Density
    public float getFontScale() {
        return this.fontScale;
    }

    public int hashCode() {
        return (Float.floatToIntBits(this.density) * 31) + Float.floatToIntBits(this.fontScale);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo150roundToPx0680j_4(float f) {
        return Density.CC.m1887$default$roundToPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo151toDpu2uoSUM(float f) {
        float m1897constructorimpl;
        m1897constructorimpl = Dp.m1897constructorimpl(f / getDensity());
        return m1897constructorimpl;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo152toDpu2uoSUM(int i) {
        float m1897constructorimpl;
        m1897constructorimpl = Dp.m1897constructorimpl(i / getDensity());
        return m1897constructorimpl;
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo153toDpSizekrfVVM(long j) {
        return Density.CC.m1890$default$toDpSizekrfVVM(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo154toPxR2X_6o(long j) {
        return Density.CC.m1891$default$toPxR2X_6o(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo155toPx0680j_4(float f) {
        return Density.CC.m1892$default$toPx0680j_4(this, f);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo156toSizeXkaWNTQ(long j) {
        return Density.CC.m1893$default$toSizeXkaWNTQ(this, j);
    }

    @Override // androidx.compose.ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo157toSpkPz2Gy4(float f) {
        long sp;
        sp = TextUnitKt.getSp(f / (getFontScale() * getDensity()));
        return sp;
    }

    public String toString() {
        return "DensityImpl(density=" + this.density + ", fontScale=" + this.fontScale + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public DensityImpl(float f, float f2) {
        this.density = f;
        this.fontScale = f2;
    }
}
