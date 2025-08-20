package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyboardType.kt */
/* loaded from: classes.dex */
public abstract class KeyboardType {
    public static final Companion Companion = new Companion(null);
    private static final int Text = m1702constructorimpl(1);
    private static final int Ascii = m1702constructorimpl(2);
    private static final int Number = m1702constructorimpl(3);
    private static final int Phone = m1702constructorimpl(4);
    private static final int Uri = m1702constructorimpl(5);
    private static final int Email = m1702constructorimpl(6);
    private static final int Password = m1702constructorimpl(7);
    private static final int NumberPassword = m1702constructorimpl(8);
    private static final int Decimal = m1702constructorimpl(9);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1702constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1703equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1704hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1705toStringimpl(int i) {
        return m1703equalsimpl0(i, Text) ? "Text" : m1703equalsimpl0(i, Ascii) ? "Ascii" : m1703equalsimpl0(i, Number) ? "Number" : m1703equalsimpl0(i, Phone) ? "Phone" : m1703equalsimpl0(i, Uri) ? "Uri" : m1703equalsimpl0(i, Email) ? "Email" : m1703equalsimpl0(i, Password) ? "Password" : m1703equalsimpl0(i, NumberPassword) ? "NumberPassword" : m1703equalsimpl0(i, Decimal) ? "Decimal" : "Invalid";
    }

    /* compiled from: KeyboardType.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getText-PjHm6EE  reason: not valid java name */
        public final int m1713getTextPjHm6EE() {
            return KeyboardType.Text;
        }

        /* renamed from: getAscii-PjHm6EE  reason: not valid java name */
        public final int m1706getAsciiPjHm6EE() {
            return KeyboardType.Ascii;
        }

        /* renamed from: getNumber-PjHm6EE  reason: not valid java name */
        public final int m1709getNumberPjHm6EE() {
            return KeyboardType.Number;
        }

        /* renamed from: getPhone-PjHm6EE  reason: not valid java name */
        public final int m1712getPhonePjHm6EE() {
            return KeyboardType.Phone;
        }

        /* renamed from: getUri-PjHm6EE  reason: not valid java name */
        public final int m1714getUriPjHm6EE() {
            return KeyboardType.Uri;
        }

        /* renamed from: getEmail-PjHm6EE  reason: not valid java name */
        public final int m1708getEmailPjHm6EE() {
            return KeyboardType.Email;
        }

        /* renamed from: getPassword-PjHm6EE  reason: not valid java name */
        public final int m1711getPasswordPjHm6EE() {
            return KeyboardType.Password;
        }

        /* renamed from: getNumberPassword-PjHm6EE  reason: not valid java name */
        public final int m1710getNumberPasswordPjHm6EE() {
            return KeyboardType.NumberPassword;
        }

        /* renamed from: getDecimal-PjHm6EE  reason: not valid java name */
        public final int m1707getDecimalPjHm6EE() {
            return KeyboardType.Decimal;
        }
    }
}
