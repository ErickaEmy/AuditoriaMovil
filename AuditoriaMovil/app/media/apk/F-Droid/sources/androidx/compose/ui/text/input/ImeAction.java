package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: ImeAction.kt */
/* loaded from: classes.dex */
public final class ImeAction {
    private final int value;
    public static final Companion Companion = new Companion(null);
    private static final int Default = m1676constructorimpl(1);
    private static final int None = m1676constructorimpl(0);
    private static final int Go = m1676constructorimpl(2);
    private static final int Search = m1676constructorimpl(3);
    private static final int Send = m1676constructorimpl(4);
    private static final int Previous = m1676constructorimpl(5);
    private static final int Next = m1676constructorimpl(6);
    private static final int Done = m1676constructorimpl(7);

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ ImeAction m1675boximpl(int i) {
        return new ImeAction(i);
    }

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1676constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m1677equalsimpl(int i, Object obj) {
        return (obj instanceof ImeAction) && i == ((ImeAction) obj).m1681unboximpl();
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1678equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1679hashCodeimpl(int i) {
        return i;
    }

    public boolean equals(Object obj) {
        return m1677equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1679hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ int m1681unboximpl() {
        return this.value;
    }

    private /* synthetic */ ImeAction(int i) {
        this.value = i;
    }

    public String toString() {
        return m1680toStringimpl(this.value);
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1680toStringimpl(int i) {
        return m1678equalsimpl0(i, None) ? "None" : m1678equalsimpl0(i, Default) ? "Default" : m1678equalsimpl0(i, Go) ? "Go" : m1678equalsimpl0(i, Search) ? "Search" : m1678equalsimpl0(i, Send) ? "Send" : m1678equalsimpl0(i, Previous) ? "Previous" : m1678equalsimpl0(i, Next) ? "Next" : m1678equalsimpl0(i, Done) ? "Done" : "Invalid";
    }

    /* compiled from: ImeAction.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getDefault-eUduSuo  reason: not valid java name */
        public final int m1682getDefaulteUduSuo() {
            return ImeAction.Default;
        }

        /* renamed from: getNone-eUduSuo  reason: not valid java name */
        public final int m1686getNoneeUduSuo() {
            return ImeAction.None;
        }

        /* renamed from: getGo-eUduSuo  reason: not valid java name */
        public final int m1684getGoeUduSuo() {
            return ImeAction.Go;
        }

        /* renamed from: getSearch-eUduSuo  reason: not valid java name */
        public final int m1688getSearcheUduSuo() {
            return ImeAction.Search;
        }

        /* renamed from: getSend-eUduSuo  reason: not valid java name */
        public final int m1689getSendeUduSuo() {
            return ImeAction.Send;
        }

        /* renamed from: getPrevious-eUduSuo  reason: not valid java name */
        public final int m1687getPreviouseUduSuo() {
            return ImeAction.Previous;
        }

        /* renamed from: getNext-eUduSuo  reason: not valid java name */
        public final int m1685getNexteUduSuo() {
            return ImeAction.Next;
        }

        /* renamed from: getDone-eUduSuo  reason: not valid java name */
        public final int m1683getDoneeUduSuo() {
            return ImeAction.Done;
        }
    }
}
