package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: UInt.kt */
/* loaded from: classes.dex */
public final class UInt implements Comparable {
    public static final Companion Companion = new Companion(null);
    private final int data;

    /* compiled from: UInt.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ UInt m2112boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m2113constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m2114equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).m2117unboximpl();
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m2115hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m2114equalsimpl(this.data, obj);
    }

    public int hashCode() {
        return m2115hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m2117unboximpl() {
        return this.data;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return UnsignedKt.uintCompare(m2117unboximpl(), ((UInt) obj).m2117unboximpl());
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m2116toStringimpl(int i) {
        return String.valueOf(i & BodyPartID.bodyIdMax);
    }

    public String toString() {
        return m2116toStringimpl(this.data);
    }
}
