package androidx.compose.ui.graphics;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: GraphicsLayerModifier.kt */
/* loaded from: classes.dex */
public abstract class CompositingStrategy {
    public static final Companion Companion = new Companion(null);
    private static final int Auto = m872constructorimpl(0);
    private static final int Offscreen = m872constructorimpl(1);
    private static final int ModulateAlpha = m872constructorimpl(2);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m872constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m873equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m874hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m875toStringimpl(int i) {
        return "CompositingStrategy(value=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: GraphicsLayerModifier.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getAuto--NrFUSI  reason: not valid java name */
        public final int m876getAutoNrFUSI() {
            return CompositingStrategy.Auto;
        }

        /* renamed from: getOffscreen--NrFUSI  reason: not valid java name */
        public final int m878getOffscreenNrFUSI() {
            return CompositingStrategy.Offscreen;
        }

        /* renamed from: getModulateAlpha--NrFUSI  reason: not valid java name */
        public final int m877getModulateAlphaNrFUSI() {
            return CompositingStrategy.ModulateAlpha;
        }
    }
}
