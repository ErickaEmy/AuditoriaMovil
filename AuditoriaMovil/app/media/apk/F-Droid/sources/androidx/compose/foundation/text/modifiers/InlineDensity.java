package androidx.compose.foundation.text.modifiers;

import androidx.compose.ui.unit.Density;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: InlineDensity.kt */
/* loaded from: classes.dex */
public abstract class InlineDensity {
    public static final Companion Companion = new Companion(null);
    private static final long Unspecified = m363constructorimpl(Float.NaN, Float.NaN);

    /* renamed from: constructor-impl  reason: not valid java name */
    private static long m364constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m366equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m363constructorimpl(float f, float f2) {
        return m364constructorimpl((Float.floatToIntBits(f2) & BodyPartID.bodyIdMax) | (Float.floatToIntBits(f) << 32));
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static long m365constructorimpl(Density density) {
        Intrinsics.checkNotNullParameter(density, "density");
        return m363constructorimpl(density.getDensity(), density.getFontScale());
    }

    /* compiled from: InlineDensity.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getUnspecified-L26CHvs  reason: not valid java name */
        public final long m367getUnspecifiedL26CHvs() {
            return InlineDensity.Unspecified;
        }
    }
}
