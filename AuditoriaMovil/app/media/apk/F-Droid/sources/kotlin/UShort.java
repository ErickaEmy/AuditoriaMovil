package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UShort.kt */
/* loaded from: classes.dex */
public final class UShort implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final short data;

    /* compiled from: UShort.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UShort m2157boximpl(short s) {
        return new UShort(s);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static short m2158constructorimpl(short s) {
        return s;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2159equalsimpl(short s, Object obj) {
        return (obj instanceof UShort) && s == ((UShort) obj).m2162unboximpl();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2160hashCodeimpl(short s) {
        return s;
    }

    public boolean equals(Object obj) {
        return m2159equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2160hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ short m2162unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(m2162unboximpl() & 65535, ((UShort) obj).m2162unboximpl() & 65535);
    }

    private /* synthetic */ UShort(short s) {
        this.data = s;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2161toStringimpl(short s) {
        return String.valueOf(s & 65535);
    }

    public String toString() {
        return m2161toStringimpl(this.data);
    }
}
