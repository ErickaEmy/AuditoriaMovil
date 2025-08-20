package androidx.compose.runtime;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: Composer.kt */
/* loaded from: classes.dex */
abstract class GroupKind {
    public static final Companion Companion = new Companion(null);
    private static final int Group = m606constructorimpl(0);
    private static final int Node = m606constructorimpl(1);
    private static final int ReusableNode = m606constructorimpl(2);

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m606constructorimpl(int i) {
        return i;
    }

    /* compiled from: Composer.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getGroup-ULZAiWs  reason: not valid java name */
        public final int m607getGroupULZAiWs() {
            return GroupKind.Group;
        }

        /* renamed from: getNode-ULZAiWs  reason: not valid java name */
        public final int m608getNodeULZAiWs() {
            return GroupKind.Node;
        }

        /* renamed from: getReusableNode-ULZAiWs  reason: not valid java name */
        public final int m609getReusableNodeULZAiWs() {
            return GroupKind.ReusableNode;
        }
    }
}
