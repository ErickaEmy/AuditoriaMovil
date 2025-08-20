package androidx.compose.ui.text.font;

import androidx.compose.ui.text.font.PlatformResolveInterceptor;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: FontFamilyResolver.kt */
/* loaded from: classes.dex */
public interface PlatformResolveInterceptor {
    public static final Companion Companion = Companion.$$INSTANCE;

    /* compiled from: FontFamilyResolver.kt */
    /* renamed from: androidx.compose.ui.text.font.PlatformResolveInterceptor$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static FontFamily $default$interceptFontFamily(PlatformResolveInterceptor platformResolveInterceptor, FontFamily fontFamily) {
            return fontFamily;
        }

        /* renamed from: $default$interceptFontStyle-T2F_aPo  reason: not valid java name */
        public static int m1661$default$interceptFontStyleT2F_aPo(PlatformResolveInterceptor platformResolveInterceptor, int i) {
            return i;
        }

        /* renamed from: $default$interceptFontSynthesis-Mscr08Y  reason: not valid java name */
        public static int m1662$default$interceptFontSynthesisMscr08Y(PlatformResolveInterceptor platformResolveInterceptor, int i) {
            return i;
        }

        public static FontWeight $default$interceptFontWeight(PlatformResolveInterceptor platformResolveInterceptor, FontWeight fontWeight) {
            Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
            return fontWeight;
        }
    }

    /* compiled from: FontFamilyResolver.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final PlatformResolveInterceptor Default = new PlatformResolveInterceptor() { // from class: androidx.compose.ui.text.font.PlatformResolveInterceptor$Companion$Default$1
            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
                return PlatformResolveInterceptor.CC.$default$interceptFontFamily(this, fontFamily);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            /* renamed from: interceptFontStyle-T2F_aPo */
            public /* synthetic */ int mo1613interceptFontStyleT2F_aPo(int i) {
                return PlatformResolveInterceptor.CC.m1661$default$interceptFontStyleT2F_aPo(this, i);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            /* renamed from: interceptFontSynthesis-Mscr08Y */
            public /* synthetic */ int mo1614interceptFontSynthesisMscr08Y(int i) {
                return PlatformResolveInterceptor.CC.m1662$default$interceptFontSynthesisMscr08Y(this, i);
            }

            @Override // androidx.compose.ui.text.font.PlatformResolveInterceptor
            public /* synthetic */ FontWeight interceptFontWeight(FontWeight fontWeight) {
                return PlatformResolveInterceptor.CC.$default$interceptFontWeight(this, fontWeight);
            }
        };

        private Companion() {
        }

        public final PlatformResolveInterceptor getDefault$ui_text_release() {
            return Default;
        }
    }

    FontFamily interceptFontFamily(FontFamily fontFamily);

    /* renamed from: interceptFontStyle-T2F_aPo */
    int mo1613interceptFontStyleT2F_aPo(int i);

    /* renamed from: interceptFontSynthesis-Mscr08Y */
    int mo1614interceptFontSynthesisMscr08Y(int i);

    FontWeight interceptFontWeight(FontWeight fontWeight);
}
