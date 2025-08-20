package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UByte.kt */
/* loaded from: classes.dex */
public final class UByte implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final byte data;

    /* compiled from: UByte.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UByte m2090boximpl(byte b) {
        return new UByte(b);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static byte m2091constructorimpl(byte b) {
        return b;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2092equalsimpl(byte b, Object obj) {
        return (obj instanceof UByte) && b == ((UByte) obj).m2095unboximpl();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2093hashCodeimpl(byte b) {
        return b;
    }

    public boolean equals(Object obj) {
        return m2092equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2093hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ byte m2095unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return Intrinsics.compare(m2095unboximpl() & 255, ((UByte) obj).m2095unboximpl() & 255);
    }

    private /* synthetic */ UByte(byte b) {
        this.data = b;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2094toStringimpl(byte b) {
        return String.valueOf(b & 255);
    }

    public String toString() {
        return m2094toStringimpl(this.data);
    }
}
