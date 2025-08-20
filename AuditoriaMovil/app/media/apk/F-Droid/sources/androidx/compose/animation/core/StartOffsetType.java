package androidx.compose.animation.core;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: AnimationSpec.kt */
/* loaded from: classes.dex */
public abstract class StartOffsetType {
    public static final Companion Companion = new Companion(null);
    private static final int Delay = m43constructorimpl(-1);
    private static final int FastForward = m43constructorimpl(1);

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m43constructorimpl(int i) {
        return i;
    }

    /* compiled from: AnimationSpec.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDelay-Eo1U57Q  reason: not valid java name */
        public final int m44getDelayEo1U57Q() {
            return StartOffsetType.Delay;
        }
    }
}
