package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* compiled from: FontFamily.kt */
/* loaded from: classes.dex */
public abstract class FontFamily {
    private final boolean canLoadSynchronously;
    public static final Companion Companion = new Companion(null);
    private static final SystemFontFamily Default = new DefaultFontFamily();
    private static final GenericFontFamily SansSerif = new GenericFontFamily("sans-serif", "FontFamily.SansSerif");
    private static final GenericFontFamily Serif = new GenericFontFamily("serif", "FontFamily.Serif");
    private static final GenericFontFamily Monospace = new GenericFontFamily("monospace", "FontFamily.Monospace");
    private static final GenericFontFamily Cursive = new GenericFontFamily("cursive", "FontFamily.Cursive");

    public /* synthetic */ FontFamily(boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(z);
    }

    private FontFamily(boolean z) {
        this.canLoadSynchronously = z;
    }

    /* compiled from: FontFamily.kt */
    /* loaded from: classes.dex */
    public interface Resolver {
        /* renamed from: resolve-DPcqOEQ  reason: not valid java name */
        State mo1626resolveDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2);

        /* compiled from: FontFamily.kt */
        /* renamed from: androidx.compose.ui.text.font.FontFamily$Resolver$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            /* renamed from: resolve-DPcqOEQ$default  reason: not valid java name */
            public static /* synthetic */ State m1627resolveDPcqOEQ$default(Resolver resolver, FontFamily fontFamily, FontWeight fontWeight, int i, int i2, int i3, Object obj) {
                if (obj == null) {
                    if ((i3 & 1) != 0) {
                        fontFamily = null;
                    }
                    if ((i3 & 2) != 0) {
                        fontWeight = FontWeight.Companion.getNormal();
                    }
                    if ((i3 & 4) != 0) {
                        i = FontStyle.Companion.m1646getNormal_LCdwA();
                    }
                    if ((i3 & 8) != 0) {
                        i2 = FontSynthesis.Companion.m1656getAllGVVA2EU();
                    }
                    return resolver.mo1626resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
                }
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resolve-DPcqOEQ");
            }
        }
    }

    /* compiled from: FontFamily.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final SystemFontFamily getDefault() {
            return FontFamily.Default;
        }

        public final GenericFontFamily getSansSerif() {
            return FontFamily.SansSerif;
        }

        public final GenericFontFamily getSerif() {
            return FontFamily.Serif;
        }

        public final GenericFontFamily getMonospace() {
            return FontFamily.Monospace;
        }

        public final GenericFontFamily getCursive() {
            return FontFamily.Cursive;
        }
    }
}
