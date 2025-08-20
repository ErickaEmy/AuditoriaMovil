package androidx.compose.ui.platform;

import java.text.BreakIterator;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AccessibilityIterators.android.kt */
/* loaded from: classes.dex */
public class AccessibilityIterators$CharacterTextSegmentIterator extends AccessibilityIterators$AbstractTextSegmentIterator {
    private static AccessibilityIterators$CharacterTextSegmentIterator instance;
    private BreakIterator impl;
    public static final Companion Companion = new Companion(null);
    public static final int $stable = 8;

    public /* synthetic */ AccessibilityIterators$CharacterTextSegmentIterator(Locale locale, DefaultConstructorMarker defaultConstructorMarker) {
        this(locale);
    }

    private AccessibilityIterators$CharacterTextSegmentIterator(Locale locale) {
        onLocaleChanged(locale);
    }

    /* compiled from: AccessibilityIterators.android.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final AccessibilityIterators$CharacterTextSegmentIterator getInstance(Locale locale) {
            Intrinsics.checkNotNullParameter(locale, "locale");
            if (AccessibilityIterators$CharacterTextSegmentIterator.instance == null) {
                AccessibilityIterators$CharacterTextSegmentIterator.instance = new AccessibilityIterators$CharacterTextSegmentIterator(locale, null);
            }
            AccessibilityIterators$CharacterTextSegmentIterator accessibilityIterators$CharacterTextSegmentIterator = AccessibilityIterators$CharacterTextSegmentIterator.instance;
            Intrinsics.checkNotNull(accessibilityIterators$CharacterTextSegmentIterator, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.CharacterTextSegmentIterator");
            return accessibilityIterators$CharacterTextSegmentIterator;
        }
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$AbstractTextSegmentIterator
    public void initialize(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        super.initialize(text);
        BreakIterator breakIterator = this.impl;
        if (breakIterator == null) {
            Intrinsics.throwUninitializedPropertyAccessException("impl");
            breakIterator = null;
        }
        breakIterator.setText(text);
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] following(int i) {
        int length = getText().length();
        if (length > 0 && i < length) {
            if (i < 0) {
                i = 0;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    int following = breakIterator2.following(i);
                    if (following == -1) {
                        return null;
                    }
                    return getRange(i, following);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator3 = null;
                }
                i = breakIterator3.following(i);
            } while (i != -1);
            return null;
        }
        return null;
    }

    @Override // androidx.compose.ui.platform.AccessibilityIterators$TextSegmentIterator
    public int[] preceding(int i) {
        int length = getText().length();
        if (length > 0 && i > 0) {
            if (i > length) {
                i = length;
            }
            do {
                BreakIterator breakIterator = this.impl;
                if (breakIterator == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator = null;
                }
                if (breakIterator.isBoundary(i)) {
                    BreakIterator breakIterator2 = this.impl;
                    if (breakIterator2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("impl");
                        breakIterator2 = null;
                    }
                    int preceding = breakIterator2.preceding(i);
                    if (preceding == -1) {
                        return null;
                    }
                    return getRange(preceding, i);
                }
                BreakIterator breakIterator3 = this.impl;
                if (breakIterator3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("impl");
                    breakIterator3 = null;
                }
                i = breakIterator3.preceding(i);
            } while (i != -1);
            return null;
        }
        return null;
    }

    private final void onLocaleChanged(Locale locale) {
        BreakIterator characterInstance = BreakIterator.getCharacterInstance(locale);
        Intrinsics.checkNotNullExpressionValue(characterInstance, "getCharacterInstance(locale)");
        this.impl = characterInstance;
    }
}
