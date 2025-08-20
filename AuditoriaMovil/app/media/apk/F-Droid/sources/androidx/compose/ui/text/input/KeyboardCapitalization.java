package androidx.compose.ui.text.input;

import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: KeyboardCapitalization.kt */
/* loaded from: classes.dex */
public abstract class KeyboardCapitalization {
    public static final Companion Companion = new Companion(null);
    private static final int None = m1694constructorimpl(0);
    private static final int Characters = m1694constructorimpl(1);
    private static final int Words = m1694constructorimpl(2);
    private static final int Sentences = m1694constructorimpl(3);

    /* renamed from: constructor-impl  reason: not valid java name */
    public static int m1694constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m1695equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m1696hashCodeimpl(int i) {
        return i;
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m1697toStringimpl(int i) {
        return m1695equalsimpl0(i, None) ? "None" : m1695equalsimpl0(i, Characters) ? "Characters" : m1695equalsimpl0(i, Words) ? "Words" : m1695equalsimpl0(i, Sentences) ? "Sentences" : "Invalid";
    }

    /* compiled from: KeyboardCapitalization.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getNone-IUNYP9k  reason: not valid java name */
        public final int m1699getNoneIUNYP9k() {
            return KeyboardCapitalization.None;
        }

        /* renamed from: getCharacters-IUNYP9k  reason: not valid java name */
        public final int m1698getCharactersIUNYP9k() {
            return KeyboardCapitalization.Characters;
        }

        /* renamed from: getWords-IUNYP9k  reason: not valid java name */
        public final int m1701getWordsIUNYP9k() {
            return KeyboardCapitalization.Words;
        }

        /* renamed from: getSentences-IUNYP9k  reason: not valid java name */
        public final int m1700getSentencesIUNYP9k() {
            return KeyboardCapitalization.Sentences;
        }
    }
}
