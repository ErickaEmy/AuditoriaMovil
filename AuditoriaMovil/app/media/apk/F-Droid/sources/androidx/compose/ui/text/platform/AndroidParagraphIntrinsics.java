package androidx.compose.ui.text.platform;

import android.graphics.Typeface;
import androidx.compose.runtime.State;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.ParagraphIntrinsics;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.LayoutIntrinsics;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.extensions.TextPaintExtensions_androidKt;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidParagraphIntrinsics.android.kt */
/* loaded from: classes.dex */
public final class AndroidParagraphIntrinsics implements ParagraphIntrinsics {
    private final CharSequence charSequence;
    private final Density density;
    private final boolean emojiCompatProcessed;
    private final FontFamily.Resolver fontFamilyResolver;
    private final LayoutIntrinsics layoutIntrinsics;
    private final List placeholders;
    private TypefaceDirtyTrackerLinkedList resolvedTypefaces;
    private final List spanStyles;
    private final TextStyle style;
    private final String text;
    private final int textDirectionHeuristic;
    private final AndroidTextPaint textPaint;

    public final CharSequence getCharSequence$ui_text_release() {
        return this.charSequence;
    }

    public final FontFamily.Resolver getFontFamilyResolver() {
        return this.fontFamilyResolver;
    }

    public final LayoutIntrinsics getLayoutIntrinsics$ui_text_release() {
        return this.layoutIntrinsics;
    }

    public final TextStyle getStyle() {
        return this.style;
    }

    public final int getTextDirectionHeuristic$ui_text_release() {
        return this.textDirectionHeuristic;
    }

    public final AndroidTextPaint getTextPaint$ui_text_release() {
        return this.textPaint;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v0, types: [java.util.List, java.util.Collection, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v3, types: [java.util.ArrayList] */
    public AndroidParagraphIntrinsics(String text, TextStyle style, List spanStyles, List placeholders, FontFamily.Resolver fontFamilyResolver, Density density) {
        boolean hasEmojiCompat;
        AnnotatedString.Range range;
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(spanStyles, "spanStyles");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        Intrinsics.checkNotNullParameter(density, "density");
        this.text = text;
        this.style = style;
        this.spanStyles = spanStyles;
        this.placeholders = placeholders;
        this.fontFamilyResolver = fontFamilyResolver;
        this.density = density;
        AndroidTextPaint androidTextPaint = new AndroidTextPaint(1, density.getDensity());
        this.textPaint = androidTextPaint;
        hasEmojiCompat = AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(style);
        this.emojiCompatProcessed = !hasEmojiCompat ? false : ((Boolean) EmojiCompatStatus.INSTANCE.getFontLoaded().getValue()).booleanValue();
        this.textDirectionHeuristic = AndroidParagraphIntrinsics_androidKt.m1724resolveTextDirectionHeuristics9GRLPo0(style.m1606getTextDirectionmmuk1to(), style.getLocaleList());
        Function4 function4 = new Function4() { // from class: androidx.compose.ui.text.platform.AndroidParagraphIntrinsics$resolveTypeface$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(4);
            }

            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return m1723invokeDPcqOEQ((FontFamily) obj, (FontWeight) obj2, ((FontStyle) obj3).m1644unboximpl(), ((FontSynthesis) obj4).m1655unboximpl());
            }

            /* renamed from: invoke-DPcqOEQ  reason: not valid java name */
            public final Typeface m1723invokeDPcqOEQ(FontFamily fontFamily, FontWeight fontWeight, int i, int i2) {
                TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList;
                Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
                State mo1626resolveDPcqOEQ = AndroidParagraphIntrinsics.this.getFontFamilyResolver().mo1626resolveDPcqOEQ(fontFamily, fontWeight, i, i2);
                if (!(mo1626resolveDPcqOEQ instanceof TypefaceResult.Immutable)) {
                    typefaceDirtyTrackerLinkedList = AndroidParagraphIntrinsics.this.resolvedTypefaces;
                    TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList2 = new TypefaceDirtyTrackerLinkedList(mo1626resolveDPcqOEQ, typefaceDirtyTrackerLinkedList);
                    AndroidParagraphIntrinsics.this.resolvedTypefaces = typefaceDirtyTrackerLinkedList2;
                    return typefaceDirtyTrackerLinkedList2.getTypeface();
                }
                Object value = mo1626resolveDPcqOEQ.getValue();
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type android.graphics.Typeface");
                return (Typeface) value;
            }
        };
        TextPaintExtensions_androidKt.setTextMotion(androidTextPaint, style.getTextMotion());
        SpanStyle applySpanStyle = TextPaintExtensions_androidKt.applySpanStyle(androidTextPaint, style.toSpanStyle(), function4, density, !spanStyles.isEmpty());
        if (applySpanStyle != null) {
            int size = spanStyles.size() + 1;
            spanStyles = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    range = new AnnotatedString.Range(applySpanStyle, 0, this.text.length());
                } else {
                    range = (AnnotatedString.Range) this.spanStyles.get(i - 1);
                }
                spanStyles.add(range);
            }
        }
        CharSequence createCharSequence = AndroidParagraphHelper_androidKt.createCharSequence(this.text, this.textPaint.getTextSize(), this.style, spanStyles, this.placeholders, this.density, function4, this.emojiCompatProcessed);
        this.charSequence = createCharSequence;
        this.layoutIntrinsics = new LayoutIntrinsics(createCharSequence, this.textPaint, this.textDirectionHeuristic);
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return this.layoutIntrinsics.getMaxIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return this.layoutIntrinsics.getMinIntrinsicWidth();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        boolean hasEmojiCompat;
        TypefaceDirtyTrackerLinkedList typefaceDirtyTrackerLinkedList = this.resolvedTypefaces;
        if (typefaceDirtyTrackerLinkedList == null || !typefaceDirtyTrackerLinkedList.isStaleResolvedFont()) {
            if (!this.emojiCompatProcessed) {
                hasEmojiCompat = AndroidParagraphIntrinsics_androidKt.getHasEmojiCompat(this.style);
                if (!hasEmojiCompat || !((Boolean) EmojiCompatStatus.INSTANCE.getFontLoaded().getValue()).booleanValue()) {
                }
            }
            return false;
        }
        return true;
    }
}
