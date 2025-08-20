package androidx.compose.ui.semantics;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: SemanticsProperties.kt */
/* loaded from: classes.dex */
public final class Role {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Button = m1476constructorimpl(0);
    private static final int Checkbox = m1476constructorimpl(1);
    private static final int Switch = m1476constructorimpl(2);
    private static final int RadioButton = m1476constructorimpl(3);
    private static final int Tab = m1476constructorimpl(4);
    private static final int Image = m1476constructorimpl(5);
    private static final int DropdownList = m1476constructorimpl(6);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ Role m1475boximpl(int i) {
        return new Role(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    private static int m1476constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1477equalsimpl(int i, Object obj) {
        return (obj instanceof Role) && i == ((Role) obj).m1481unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1478equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1479hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1477equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1479hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1481unboximpl() {
        return this.value;
    }

    private /* synthetic */ Role(int i) {
        this.value = i;
    }

    /* compiled from: SemanticsProperties.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getButton-o7Vup1c  reason: not valid java name */
        public final int m1482getButtono7Vup1c() {
            return Role.Button;
        }

        /* renamed from: getCheckbox-o7Vup1c  reason: not valid java name */
        public final int m1483getCheckboxo7Vup1c() {
            return Role.Checkbox;
        }

        /* renamed from: getSwitch-o7Vup1c  reason: not valid java name */
        public final int m1487getSwitcho7Vup1c() {
            return Role.Switch;
        }

        /* renamed from: getRadioButton-o7Vup1c  reason: not valid java name */
        public final int m1486getRadioButtono7Vup1c() {
            return Role.RadioButton;
        }

        /* renamed from: getTab-o7Vup1c  reason: not valid java name */
        public final int m1488getTabo7Vup1c() {
            return Role.Tab;
        }

        /* renamed from: getImage-o7Vup1c  reason: not valid java name */
        public final int m1485getImageo7Vup1c() {
            return Role.Image;
        }

        /* renamed from: getDropdownList-o7Vup1c  reason: not valid java name */
        public final int m1484getDropdownListo7Vup1c() {
            return Role.DropdownList;
        }
    }

    public String toString() {
        return m1480toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1480toStringimpl(int i) {
        return m1478equalsimpl0(i, Button) ? "Button" : m1478equalsimpl0(i, Checkbox) ? "Checkbox" : m1478equalsimpl0(i, Switch) ? "Switch" : m1478equalsimpl0(i, RadioButton) ? "RadioButton" : m1478equalsimpl0(i, Tab) ? "Tab" : m1478equalsimpl0(i, Image) ? "Image" : m1478equalsimpl0(i, DropdownList) ? "DropdownList" : "Unknown";
    }
}
