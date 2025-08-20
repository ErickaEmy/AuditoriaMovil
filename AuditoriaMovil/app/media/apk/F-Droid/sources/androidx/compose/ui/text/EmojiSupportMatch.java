package androidx.compose.ui.text;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: EmojiSupportMatch.kt */
/* loaded from: classes.dex */
public final class EmojiSupportMatch {
    public static final Companion Companion = new Companion(null);
    private static final int Default = m1513constructorimpl(0);
    private static final int None = m1513constructorimpl(1);
    private final int value;

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ EmojiSupportMatch m1512boximpl(int i) {
        return new EmojiSupportMatch(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1513constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1514equalsimpl(int i, Object obj) {
        return (obj instanceof EmojiSupportMatch) && i == ((EmojiSupportMatch) obj).m1518unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1515equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1516hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1514equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1516hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1518unboximpl() {
        return this.value;
    }

    private /* synthetic */ EmojiSupportMatch(int i) {
        this.value = i;
    }

    public String toString() {
        return m1517toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1517toStringimpl(int i) {
        if (i == Default) {
            return "EmojiSupportMatch.Default";
        }
        if (i == None) {
            return "EmojiSupportMatch.None";
        }
        return "Invalid(value=" + i + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    /* compiled from: EmojiSupportMatch.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefault-_3YsG6Y  reason: not valid java name */
        public final int m1519getDefault_3YsG6Y() {
            return EmojiSupportMatch.Default;
        }

        /* renamed from: getNone-_3YsG6Y  reason: not valid java name */
        public final int m1520getNone_3YsG6Y() {
            return EmojiSupportMatch.None;
        }
    }
}
