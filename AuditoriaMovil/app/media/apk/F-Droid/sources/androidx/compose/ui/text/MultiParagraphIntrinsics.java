package androidx.compose.ui.text;

import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MultiParagraphIntrinsics.kt */
/* loaded from: classes.dex */
public final class MultiParagraphIntrinsics implements ParagraphIntrinsics {
    private final AnnotatedString annotatedString;
    private final List infoList;
    private final Lazy maxIntrinsicWidth$delegate;
    private final Lazy minIntrinsicWidth$delegate;
    private final List placeholders;

    public final AnnotatedString getAnnotatedString() {
        return this.annotatedString;
    }

    public final List getInfoList$ui_text_release() {
        return this.infoList;
    }

    public final List getPlaceholders() {
        return this.placeholders;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public boolean getHasStaleResolvedFonts() {
        List list = this.infoList;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            if (((ParagraphIntrinsicInfo) list.get(i)).getIntrinsics().getHasStaleResolvedFonts()) {
                return true;
            }
        }
        return false;
    }

    public MultiParagraphIntrinsics(AnnotatedString annotatedString, TextStyle style, List placeholders, Density density, FontFamily.Resolver fontFamilyResolver) {
        Lazy lazy;
        Lazy lazy2;
        AnnotatedString substringWithoutParagraphStyles;
        List localPlaceholders;
        AnnotatedString annotatedString2 = annotatedString;
        Intrinsics.checkNotNullParameter(annotatedString2, "annotatedString");
        Intrinsics.checkNotNullParameter(style, "style");
        Intrinsics.checkNotNullParameter(placeholders, "placeholders");
        Intrinsics.checkNotNullParameter(density, "density");
        Intrinsics.checkNotNullParameter(fontFamilyResolver, "fontFamilyResolver");
        this.annotatedString = annotatedString2;
        this.placeholders = placeholders;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        lazy = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$minIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                int lastIndex;
                Object obj;
                ParagraphIntrinsics intrinsics;
                List infoList$ui_text_release = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if (infoList$ui_text_release.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = infoList$ui_text_release.get(0);
                    float minIntrinsicWidth = ((ParagraphIntrinsicInfo) obj2).getIntrinsics().getMinIntrinsicWidth();
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(infoList$ui_text_release);
                    int i = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = infoList$ui_text_release.get(i);
                            float minIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj3).getIntrinsics().getMinIntrinsicWidth();
                            if (Float.compare(minIntrinsicWidth, minIntrinsicWidth2) < 0) {
                                obj2 = obj3;
                                minIntrinsicWidth = minIntrinsicWidth2;
                            }
                            if (i == lastIndex) {
                                break;
                            }
                            i++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                return Float.valueOf((paragraphIntrinsicInfo == null || (intrinsics = paragraphIntrinsicInfo.getIntrinsics()) == null) ? 0.0f : intrinsics.getMinIntrinsicWidth());
            }
        });
        this.minIntrinsicWidth$delegate = lazy;
        lazy2 = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new Function0() { // from class: androidx.compose.ui.text.MultiParagraphIntrinsics$maxIntrinsicWidth$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                int lastIndex;
                Object obj;
                ParagraphIntrinsics intrinsics;
                List infoList$ui_text_release = MultiParagraphIntrinsics.this.getInfoList$ui_text_release();
                if (infoList$ui_text_release.isEmpty()) {
                    obj = null;
                } else {
                    Object obj2 = infoList$ui_text_release.get(0);
                    float maxIntrinsicWidth = ((ParagraphIntrinsicInfo) obj2).getIntrinsics().getMaxIntrinsicWidth();
                    lastIndex = CollectionsKt__CollectionsKt.getLastIndex(infoList$ui_text_release);
                    int i = 1;
                    if (1 <= lastIndex) {
                        while (true) {
                            Object obj3 = infoList$ui_text_release.get(i);
                            float maxIntrinsicWidth2 = ((ParagraphIntrinsicInfo) obj3).getIntrinsics().getMaxIntrinsicWidth();
                            if (Float.compare(maxIntrinsicWidth, maxIntrinsicWidth2) < 0) {
                                obj2 = obj3;
                                maxIntrinsicWidth = maxIntrinsicWidth2;
                            }
                            if (i == lastIndex) {
                                break;
                            }
                            i++;
                        }
                    }
                    obj = obj2;
                }
                ParagraphIntrinsicInfo paragraphIntrinsicInfo = (ParagraphIntrinsicInfo) obj;
                return Float.valueOf((paragraphIntrinsicInfo == null || (intrinsics = paragraphIntrinsicInfo.getIntrinsics()) == null) ? 0.0f : intrinsics.getMaxIntrinsicWidth());
            }
        });
        this.maxIntrinsicWidth$delegate = lazy2;
        ParagraphStyle paragraphStyle = style.toParagraphStyle();
        List normalizedParagraphStyles = AnnotatedStringKt.normalizedParagraphStyles(annotatedString2, paragraphStyle);
        ArrayList arrayList = new ArrayList(normalizedParagraphStyles.size());
        int size = normalizedParagraphStyles.size();
        int i = 0;
        while (i < size) {
            AnnotatedString.Range range = (AnnotatedString.Range) normalizedParagraphStyles.get(i);
            substringWithoutParagraphStyles = AnnotatedStringKt.substringWithoutParagraphStyles(annotatedString2, range.getStart(), range.getEnd());
            ParagraphStyle resolveTextDirection = resolveTextDirection((ParagraphStyle) range.getItem(), paragraphStyle);
            String text = substringWithoutParagraphStyles.getText();
            TextStyle merge = style.merge(resolveTextDirection);
            List spanStyles = substringWithoutParagraphStyles.getSpanStyles();
            localPlaceholders = MultiParagraphIntrinsicsKt.getLocalPlaceholders(getPlaceholders(), range.getStart(), range.getEnd());
            arrayList.add(new ParagraphIntrinsicInfo(ParagraphIntrinsicsKt.ParagraphIntrinsics(text, merge, spanStyles, localPlaceholders, density, fontFamilyResolver), range.getStart(), range.getEnd()));
            i++;
            annotatedString2 = annotatedString;
        }
        this.infoList = arrayList;
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMinIntrinsicWidth() {
        return ((Number) this.minIntrinsicWidth$delegate.getValue()).floatValue();
    }

    @Override // androidx.compose.ui.text.ParagraphIntrinsics
    public float getMaxIntrinsicWidth() {
        return ((Number) this.maxIntrinsicWidth$delegate.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ParagraphStyle resolveTextDirection(ParagraphStyle paragraphStyle, ParagraphStyle paragraphStyle2) {
        ParagraphStyle m1535copyNH1kkwU;
        TextDirection m1543getTextDirectionmmuk1to = paragraphStyle.m1543getTextDirectionmmuk1to();
        if (m1543getTextDirectionmmuk1to != null) {
            m1543getTextDirectionmmuk1to.m1836unboximpl();
            return paragraphStyle;
        }
        m1535copyNH1kkwU = paragraphStyle.m1535copyNH1kkwU((r22 & 1) != 0 ? paragraphStyle.textAlign : null, (r22 & 2) != 0 ? paragraphStyle.textDirection : paragraphStyle2.m1543getTextDirectionmmuk1to(), (r22 & 4) != 0 ? paragraphStyle.lineHeight : 0L, (r22 & 8) != 0 ? paragraphStyle.textIndent : null, (r22 & 16) != 0 ? paragraphStyle.platformStyle : null, (r22 & 32) != 0 ? paragraphStyle.lineHeightStyle : null, (r22 & 64) != 0 ? paragraphStyle.lineBreak : null, (r22 & 128) != 0 ? paragraphStyle.hyphens : null, (r22 & 256) != 0 ? paragraphStyle.textMotion : null);
        return m1535copyNH1kkwU;
    }
}
