package androidx.compose.ui.text.font;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontLoadingStrategy.kt */
/* loaded from: classes.dex */
public abstract class FontLoadingStrategy {
    public static final Companion Companion = new Companion(null);
    private static final int Blocking = m1630constructorimpl(0);
    private static final int OptionalLocal = m1630constructorimpl(1);
    private static final int Async = m1630constructorimpl(2);

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1630constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1631equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1632hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1633toStringimpl(int i) {
        if (m1631equalsimpl0(i, Blocking)) {
            return "Blocking";
        }
        if (m1631equalsimpl0(i, OptionalLocal)) {
            return "Optional";
        }
        if (m1631equalsimpl0(i, Async)) {
            return "Async";
        }
        return "Invalid(value=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: FontLoadingStrategy.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getBlocking-PKNRLFQ  reason: not valid java name */
        public final int m1635getBlockingPKNRLFQ() {
            return FontLoadingStrategy.Blocking;
        }

        /* renamed from: getOptionalLocal-PKNRLFQ  reason: not valid java name */
        public final int m1636getOptionalLocalPKNRLFQ() {
            return FontLoadingStrategy.OptionalLocal;
        }

        /* renamed from: getAsync-PKNRLFQ  reason: not valid java name */
        public final int m1634getAsyncPKNRLFQ() {
            return FontLoadingStrategy.Async;
        }
    }
}
