package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.SolidColor;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: TextForegroundStyle.kt */
/* loaded from: classes.dex */
public interface TextForegroundStyle {
    public static final Companion Companion = Companion.$$INSTANCE;

    float getAlpha();

    Brush getBrush();

    /* renamed from: getColor-0d7_KjU */
    long mo1752getColor0d7_KjU();

    TextForegroundStyle merge(TextForegroundStyle textForegroundStyle);

    TextForegroundStyle takeOrElse(Function0 function0);

    /* compiled from: TextForegroundStyle.kt */
    /* renamed from: androidx.compose.ui.text.style.TextForegroundStyle$-CC */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static TextForegroundStyle $default$merge(final TextForegroundStyle textForegroundStyle, TextForegroundStyle other) {
            float takeOrElse;
            Intrinsics.checkNotNullParameter(other, "other");
            boolean z = other instanceof BrushStyle;
            if (!z || !(textForegroundStyle instanceof BrushStyle)) {
                return (!z || (textForegroundStyle instanceof BrushStyle)) ? (z || !(textForegroundStyle instanceof BrushStyle)) ? other.takeOrElse(new Function0() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$2
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public final TextForegroundStyle invoke() {
                        return TextForegroundStyle.this;
                    }
                }) : textForegroundStyle : other;
            }
            ShaderBrush value = ((BrushStyle) other).getValue();
            takeOrElse = TextDrawStyleKt.takeOrElse(other.getAlpha(), new Function0() { // from class: androidx.compose.ui.text.style.TextForegroundStyle$merge$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(TextForegroundStyle.this.getAlpha());
                }
            });
            return new BrushStyle(value, takeOrElse);
        }

        public static TextForegroundStyle $default$takeOrElse(TextForegroundStyle textForegroundStyle, Function0 other) {
            Intrinsics.checkNotNullParameter(other, "other");
            return !Intrinsics.areEqual(textForegroundStyle, Unspecified.INSTANCE) ? textForegroundStyle : (TextForegroundStyle) other.invoke();
        }
    }

    /* compiled from: TextForegroundStyle.kt */
    /* loaded from: classes.dex */
    public static final class Unspecified implements TextForegroundStyle {
        public static final Unspecified INSTANCE = new Unspecified();

        private Unspecified() {
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public float getAlpha() {
            return Float.NaN;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public Brush getBrush() {
            return null;
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
            return CC.$default$merge(this, textForegroundStyle);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
            return CC.$default$takeOrElse(this, function0);
        }

        @Override // androidx.compose.ui.text.style.TextForegroundStyle
        /* renamed from: getColor-0d7_KjU */
        public long mo1752getColor0d7_KjU() {
            return Color.Companion.m864getUnspecified0d7_KjU();
        }
    }

    /* compiled from: TextForegroundStyle.kt */
    /* loaded from: classes.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final TextForegroundStyle from(Brush brush, float f) {
            if (brush == null) {
                return Unspecified.INSTANCE;
            }
            if (brush instanceof SolidColor) {
                return m1843from8_81llA(TextDrawStyleKt.m1842modulateDxMtmZc(((SolidColor) brush).m962getValue0d7_KjU(), f));
            }
            if (brush instanceof ShaderBrush) {
                return new BrushStyle((ShaderBrush) brush, f);
            }
            throw new NoWhenBranchMatchedException();
        }

        /* renamed from: from-8_81llA */
        public final TextForegroundStyle m1843from8_81llA(long j) {
            return j != Color.Companion.m864getUnspecified0d7_KjU() ? new ColorStyle(j, null) : Unspecified.INSTANCE;
        }
    }
}
