package kotlinx.coroutines.channels;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class ChannelResult<T> {
    public static final Companion Companion = new Companion(null);
    private static final Failed failed = new Failed();
    private final Object holder;

    /* loaded from: classes.dex */
    public static final class Closed extends Failed {
        public final Throwable cause;

        public Closed(Throwable th) {
            this.cause = th;
        }

        public boolean equals(Object obj) {
            if ((obj instanceof Closed) && Intrinsics.areEqual(this.cause, ((Closed) obj).cause)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            Throwable th = this.cause;
            if (th != null) {
                return th.hashCode();
            }
            return 0;
        }

        @Override // kotlinx.coroutines.channels.ChannelResult.Failed
        public String toString() {
            return "Closed(" + this.cause + ')';
        }
    }

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: closed-JP2dKIU  reason: not valid java name */
        public final <E> Object m96closedJP2dKIU(Throwable th) {
            return ChannelResult.m87constructorimpl(new Closed(th));
        }

        /* renamed from: failure-PtdJZtk  reason: not valid java name */
        public final <E> Object m97failurePtdJZtk() {
            return ChannelResult.m87constructorimpl(ChannelResult.failed);
        }

        /* renamed from: success-JP2dKIU  reason: not valid java name */
        public final <E> Object m98successJP2dKIU(E e2) {
            return ChannelResult.m87constructorimpl(e2);
        }

        private Companion() {
        }
    }

    /* loaded from: classes.dex */
    public static class Failed {
        public String toString() {
            return "Failed";
        }
    }

    private /* synthetic */ ChannelResult(Object obj) {
        this.holder = obj;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ChannelResult m86boximpl(Object obj) {
        return new ChannelResult(obj);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static <T> Object m87constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m88equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof ChannelResult) && Intrinsics.areEqual(obj, ((ChannelResult) obj2).m95unboximpl());
    }

    /* renamed from: exceptionOrNull-impl  reason: not valid java name */
    public static final Throwable m89exceptionOrNullimpl(Object obj) {
        Closed closed;
        if (obj instanceof Closed) {
            closed = (Closed) obj;
        } else {
            closed = null;
        }
        if (closed == null) {
            return null;
        }
        return closed.cause;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOrNull-impl  reason: not valid java name */
    public static final T m90getOrNullimpl(Object obj) {
        if (obj instanceof Failed) {
            return null;
        }
        return obj;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m91hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isClosed-impl  reason: not valid java name */
    public static final boolean m92isClosedimpl(Object obj) {
        return obj instanceof Closed;
    }

    /* renamed from: isSuccess-impl  reason: not valid java name */
    public static final boolean m93isSuccessimpl(Object obj) {
        return !(obj instanceof Failed);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m94toStringimpl(Object obj) {
        if (obj instanceof Closed) {
            return ((Closed) obj).toString();
        }
        return "Value(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m88equalsimpl(this.holder, obj);
    }

    public int hashCode() {
        return m91hashCodeimpl(this.holder);
    }

    public String toString() {
        return m94toStringimpl(this.holder);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ Object m95unboximpl() {
        return this.holder;
    }
}
