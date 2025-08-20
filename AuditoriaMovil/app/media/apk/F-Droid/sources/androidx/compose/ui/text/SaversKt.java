package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Savers.kt */
/* loaded from: classes.dex */
public abstract class SaversKt {
    private static final Saver AnnotatedStringSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, AnnotatedString it) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            List spanStyles = it.getSpanStyles();
            saver = SaversKt.AnnotationRangeListSaver;
            List paragraphStyles = it.getParagraphStyles();
            saver2 = SaversKt.AnnotationRangeListSaver;
            List annotations$ui_text_release = it.getAnnotations$ui_text_release();
            saver3 = SaversKt.AnnotationRangeListSaver;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(it.getText()), SaversKt.save(spanStyles, saver, Saver), SaversKt.save(paragraphStyles, saver2, Saver), SaversKt.save(annotations$ui_text_release, saver3, Saver));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotatedStringSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString invoke(Object it) {
            Saver saver;
            Saver saver2;
            Saver saver3;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(1);
            saver = SaversKt.AnnotationRangeListSaver;
            Boolean bool = Boolean.FALSE;
            List list2 = null;
            List list3 = (Intrinsics.areEqual(obj, bool) || obj == null) ? null : (List) saver.restore(obj);
            Object obj2 = list.get(2);
            saver2 = SaversKt.AnnotationRangeListSaver;
            List list4 = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (List) saver2.restore(obj2);
            Object obj3 = list.get(0);
            String str = obj3 != null ? (String) obj3 : null;
            Intrinsics.checkNotNull(str);
            if (list3 == null || list3.isEmpty()) {
                list3 = null;
            }
            if (list4 == null || list4.isEmpty()) {
                list4 = null;
            }
            Object obj4 = list.get(3);
            saver3 = SaversKt.AnnotationRangeListSaver;
            if (!Intrinsics.areEqual(obj4, bool) && obj4 != null) {
                list2 = (List) saver3.restore(obj4);
            }
            return new AnnotatedString(str, list3, list4, list2);
        }
    });
    private static final Saver AnnotationRangeListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, List it) {
            Saver saver;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            ArrayList arrayList = new ArrayList(it.size());
            int size = it.size();
            for (int i = 0; i < size; i++) {
                saver = SaversKt.AnnotationRangeSaver;
                arrayList.add(SaversKt.save((AnnotatedString.Range) it.get(i), saver, Saver));
            }
            return arrayList;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final List invoke(Object it) {
            Saver saver;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                saver = SaversKt.AnnotationRangeSaver;
                AnnotatedString.Range range = null;
                if (!Intrinsics.areEqual(obj, Boolean.FALSE) && obj != null) {
                    range = (AnnotatedString.Range) saver.restore(obj);
                }
                Intrinsics.checkNotNull(range);
                arrayList.add(range);
            }
            return arrayList;
        }
    });
    private static final Saver AnnotationRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$1

        /* compiled from: Savers.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, AnnotatedString.Range it) {
            AnnotationType annotationType;
            Object save;
            ArrayList arrayListOf;
            Saver saver;
            Saver saver2;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Object item = it.getItem();
            if (item instanceof ParagraphStyle) {
                annotationType = AnnotationType.Paragraph;
            } else if (item instanceof SpanStyle) {
                annotationType = AnnotationType.Span;
            } else if (item instanceof VerbatimTtsAnnotation) {
                annotationType = AnnotationType.VerbatimTts;
            } else {
                annotationType = item instanceof UrlAnnotation ? AnnotationType.Url : AnnotationType.String;
            }
            int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (i == 1) {
                Object item2 = it.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                save = SaversKt.save((ParagraphStyle) item2, SaversKt.getParagraphStyleSaver(), Saver);
            } else if (i == 2) {
                Object item3 = it.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                save = SaversKt.save((SpanStyle) item3, SaversKt.getSpanStyleSaver(), Saver);
            } else if (i == 3) {
                Object item4 = it.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                saver = SaversKt.VerbatimTtsAnnotationSaver;
                save = SaversKt.save((VerbatimTtsAnnotation) item4, saver, Saver);
            } else if (i == 4) {
                Object item5 = it.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                saver2 = SaversKt.UrlAnnotationSaver;
                save = SaversKt.save((UrlAnnotation) item5, saver2, Saver);
            } else if (i != 5) {
                throw new NoWhenBranchMatchedException();
            } else {
                save = SaversKt.save(it.getItem());
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(annotationType), save, SaversKt.save(Integer.valueOf(it.getStart())), SaversKt.save(Integer.valueOf(it.getEnd())), SaversKt.save(it.getTag()));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$AnnotationRangeSaver$2

        /* compiled from: Savers.kt */
        /* loaded from: classes.dex */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[AnnotationType.values().length];
                try {
                    iArr[AnnotationType.Paragraph.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[AnnotationType.Span.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[AnnotationType.Url.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[AnnotationType.String.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // kotlin.jvm.functions.Function1
        public final AnnotatedString.Range invoke(Object it) {
            Saver saver;
            Saver saver2;
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            AnnotationType annotationType = obj != null ? (AnnotationType) obj : null;
            Intrinsics.checkNotNull(annotationType);
            Object obj2 = list.get(2);
            Integer num = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj3 = list.get(3);
            Integer num2 = obj3 != null ? (Integer) obj3 : null;
            Intrinsics.checkNotNull(num2);
            int intValue2 = num2.intValue();
            Object obj4 = list.get(4);
            String str = obj4 != null ? (String) obj4 : null;
            Intrinsics.checkNotNull(str);
            int i = WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()];
            if (i == 1) {
                Object obj5 = list.get(1);
                Saver paragraphStyleSaver = SaversKt.getParagraphStyleSaver();
                if (!Intrinsics.areEqual(obj5, Boolean.FALSE) && obj5 != null) {
                    r1 = (ParagraphStyle) paragraphStyleSaver.restore(obj5);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range(r1, intValue, intValue2, str);
            } else if (i == 2) {
                Object obj6 = list.get(1);
                Saver spanStyleSaver = SaversKt.getSpanStyleSaver();
                if (!Intrinsics.areEqual(obj6, Boolean.FALSE) && obj6 != null) {
                    r1 = (SpanStyle) spanStyleSaver.restore(obj6);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range(r1, intValue, intValue2, str);
            } else if (i == 3) {
                Object obj7 = list.get(1);
                saver = SaversKt.VerbatimTtsAnnotationSaver;
                if (!Intrinsics.areEqual(obj7, Boolean.FALSE) && obj7 != null) {
                    r1 = (VerbatimTtsAnnotation) saver.restore(obj7);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range(r1, intValue, intValue2, str);
            } else if (i != 4) {
                if (i == 5) {
                    Object obj8 = list.get(1);
                    r1 = obj8 != null ? (String) obj8 : null;
                    Intrinsics.checkNotNull(r1);
                    return new AnnotatedString.Range(r1, intValue, intValue2, str);
                }
                throw new NoWhenBranchMatchedException();
            } else {
                Object obj9 = list.get(1);
                saver2 = SaversKt.UrlAnnotationSaver;
                if (!Intrinsics.areEqual(obj9, Boolean.FALSE) && obj9 != null) {
                    r1 = (UrlAnnotation) saver2.restore(obj9);
                }
                Intrinsics.checkNotNull(r1);
                return new AnnotatedString.Range(r1, intValue, intValue2, str);
            }
        }
    });
    private static final Saver VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, VerbatimTtsAnnotation it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return SaversKt.save(it.getVerbatim());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$VerbatimTtsAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final VerbatimTtsAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new VerbatimTtsAnnotation((String) it);
        }
    });
    private static final Saver UrlAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, UrlAnnotation it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return SaversKt.save(it.getUrl());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$UrlAnnotationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final UrlAnnotation invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new UrlAnnotation((String) it);
        }
    });
    private static final Saver ParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, ParagraphStyle it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(it.m1541getTextAlignbuA522U()), SaversKt.save(it.m1543getTextDirectionmmuk1to()), SaversKt.save(TextUnit.m1958boximpl(it.m1540getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), Saver), SaversKt.save(it.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), Saver));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ParagraphStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final ParagraphStyle invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            TextAlign textAlign = obj != null ? (TextAlign) obj : null;
            Object obj2 = list.get(1);
            TextDirection textDirection = obj2 != null ? (TextDirection) obj2 : null;
            Object obj3 = list.get(2);
            Saver saver = SaversKt.getSaver(TextUnit.Companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (TextUnit) saver.restore(obj3);
            Intrinsics.checkNotNull(textUnit);
            long m1967unboximpl = textUnit.m1967unboximpl();
            Object obj4 = list.get(3);
            return new ParagraphStyle(textAlign, textDirection, m1967unboximpl, (Intrinsics.areEqual(obj4, bool) || obj4 == null) ? null : (TextIndent) SaversKt.getSaver(TextIndent.Companion).restore(obj4), null, null, null, null, null, 496, null);
        }
    });
    private static final Saver SpanStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, SpanStyle it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            Color m841boximpl = Color.m841boximpl(it.m1560getColor0d7_KjU());
            Color.Companion companion = Color.Companion;
            TextUnit m1958boximpl = TextUnit.m1958boximpl(it.m1561getFontSizeXSAIIZE());
            TextUnit.Companion companion2 = TextUnit.Companion;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(m841boximpl, SaversKt.getSaver(companion), Saver), SaversKt.save(m1958boximpl, SaversKt.getSaver(companion2), Saver), SaversKt.save(it.getFontWeight(), SaversKt.getSaver(FontWeight.Companion), Saver), SaversKt.save(it.m1562getFontStyle4Lr2A7w()), SaversKt.save(it.m1563getFontSynthesisZQGJjVo()), SaversKt.save(-1), SaversKt.save(it.getFontFeatureSettings()), SaversKt.save(TextUnit.m1958boximpl(it.m1564getLetterSpacingXSAIIZE()), SaversKt.getSaver(companion2), Saver), SaversKt.save(it.m1559getBaselineShift5SSeXJ0(), SaversKt.getSaver(BaselineShift.Companion), Saver), SaversKt.save(it.getTextGeometricTransform(), SaversKt.getSaver(TextGeometricTransform.Companion), Saver), SaversKt.save(it.getLocaleList(), SaversKt.getSaver(LocaleList.Companion), Saver), SaversKt.save(Color.m841boximpl(it.m1558getBackground0d7_KjU()), SaversKt.getSaver(companion), Saver), SaversKt.save(it.getTextDecoration(), SaversKt.getSaver(TextDecoration.Companion), Saver), SaversKt.save(it.getShadow(), SaversKt.getSaver(Shadow.Companion), Saver));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$SpanStyleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final SpanStyle invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Color.Companion companion = Color.Companion;
            Saver saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            Color color = (Intrinsics.areEqual(obj, bool) || obj == null) ? null : (Color) saver.restore(obj);
            Intrinsics.checkNotNull(color);
            long m859unboximpl = color.m859unboximpl();
            Object obj2 = list.get(1);
            TextUnit.Companion companion2 = TextUnit.Companion;
            TextUnit textUnit = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (TextUnit) SaversKt.getSaver(companion2).restore(obj2);
            Intrinsics.checkNotNull(textUnit);
            long m1967unboximpl = textUnit.m1967unboximpl();
            Object obj3 = list.get(2);
            FontWeight fontWeight = (Intrinsics.areEqual(obj3, bool) || obj3 == null) ? null : (FontWeight) SaversKt.getSaver(FontWeight.Companion).restore(obj3);
            Object obj4 = list.get(3);
            FontStyle fontStyle = obj4 != null ? (FontStyle) obj4 : null;
            Object obj5 = list.get(4);
            FontSynthesis fontSynthesis = obj5 != null ? (FontSynthesis) obj5 : null;
            Object obj6 = list.get(6);
            String str = obj6 != null ? (String) obj6 : null;
            Object obj7 = list.get(7);
            TextUnit textUnit2 = (Intrinsics.areEqual(obj7, bool) || obj7 == null) ? null : (TextUnit) SaversKt.getSaver(companion2).restore(obj7);
            Intrinsics.checkNotNull(textUnit2);
            long m1967unboximpl2 = textUnit2.m1967unboximpl();
            Object obj8 = list.get(8);
            BaselineShift baselineShift = (Intrinsics.areEqual(obj8, bool) || obj8 == null) ? null : (BaselineShift) SaversKt.getSaver(BaselineShift.Companion).restore(obj8);
            Object obj9 = list.get(9);
            TextGeometricTransform textGeometricTransform = (Intrinsics.areEqual(obj9, bool) || obj9 == null) ? null : (TextGeometricTransform) SaversKt.getSaver(TextGeometricTransform.Companion).restore(obj9);
            Object obj10 = list.get(10);
            LocaleList localeList = (Intrinsics.areEqual(obj10, bool) || obj10 == null) ? null : (LocaleList) SaversKt.getSaver(LocaleList.Companion).restore(obj10);
            Object obj11 = list.get(11);
            Color color2 = (Intrinsics.areEqual(obj11, bool) || obj11 == null) ? null : (Color) SaversKt.getSaver(companion).restore(obj11);
            Intrinsics.checkNotNull(color2);
            long m859unboximpl2 = color2.m859unboximpl();
            Object obj12 = list.get(12);
            TextDecoration textDecoration = (Intrinsics.areEqual(obj12, bool) || obj12 == null) ? null : (TextDecoration) SaversKt.getSaver(TextDecoration.Companion).restore(obj12);
            Object obj13 = list.get(13);
            return new SpanStyle(m859unboximpl, m1967unboximpl, fontWeight, fontStyle, fontSynthesis, null, str, m1967unboximpl2, baselineShift, textGeometricTransform, localeList, m859unboximpl2, textDecoration, (Intrinsics.areEqual(obj13, bool) || obj13 == null) ? null : (Shadow) SaversKt.getSaver(Shadow.Companion).restore(obj13), null, null, 49184, null);
        }
    });
    private static final Saver TextDecorationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextDecoration it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.getMask());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextDecorationSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextDecoration invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new TextDecoration(((Integer) it).intValue());
        }
    });
    private static final Saver TextGeometricTransformSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextGeometricTransform it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(Float.valueOf(it.getScaleX()), Float.valueOf(it.getSkewX()));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextGeometricTransformSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextGeometricTransform invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
        }
    });
    private static final Saver TextIndentSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, TextIndent it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            TextUnit m1958boximpl = TextUnit.m1958boximpl(it.m1844getFirstLineXSAIIZE());
            TextUnit.Companion companion = TextUnit.Companion;
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(m1958boximpl, SaversKt.getSaver(companion), Saver), SaversKt.save(TextUnit.m1958boximpl(it.m1845getRestLineXSAIIZE()), SaversKt.getSaver(companion), Saver));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextIndentSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final TextIndent invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            TextUnit.Companion companion = TextUnit.Companion;
            Saver saver = SaversKt.getSaver(companion);
            Boolean bool = Boolean.FALSE;
            TextUnit textUnit = null;
            TextUnit textUnit2 = (Intrinsics.areEqual(obj, bool) || obj == null) ? null : (TextUnit) saver.restore(obj);
            Intrinsics.checkNotNull(textUnit2);
            long m1967unboximpl = textUnit2.m1967unboximpl();
            Object obj2 = list.get(1);
            Saver saver2 = SaversKt.getSaver(companion);
            if (!Intrinsics.areEqual(obj2, bool) && obj2 != null) {
                textUnit = (TextUnit) saver2.restore(obj2);
            }
            Intrinsics.checkNotNull(textUnit);
            return new TextIndent(m1967unboximpl, textUnit.m1967unboximpl(), null);
        }
    });
    private static final Saver FontWeightSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, FontWeight it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return Integer.valueOf(it.getWeight());
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$FontWeightSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final FontWeight invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new FontWeight(((Integer) it).intValue());
        }
    });
    private static final Saver BaselineShiftSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1546invoke8a2Sb4w((SaverScope) obj, ((BaselineShift) obj2).m1749unboximpl());
        }

        /* renamed from: invoke-8a2Sb4w  reason: not valid java name */
        public final Object m1546invoke8a2Sb4w(SaverScope Saver, float f) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return Float.valueOf(f);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$BaselineShiftSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-jTk7eUs  reason: not valid java name */
        public final BaselineShift invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return BaselineShift.m1743boximpl(BaselineShift.m1744constructorimpl(((Float) it).floatValue()));
        }
    });
    private static final Saver TextRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1552invokeFDrldGo((SaverScope) obj, ((TextRange) obj2).m1589unboximpl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-FDrldGo  reason: not valid java name */
        public final Object m1552invokeFDrldGo(SaverScope Saver, long j) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Integer.valueOf(TextRange.m1585getStartimpl(j))), SaversKt.save(Integer.valueOf(TextRange.m1580getEndimpl(j))));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextRangeSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-VqIyPBM  reason: not valid java name */
        public final TextRange invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Integer num = obj != null ? (Integer) obj : null;
            Intrinsics.checkNotNull(num);
            int intValue = num.intValue();
            Object obj2 = list.get(1);
            Integer num2 = obj2 != null ? (Integer) obj2 : null;
            Intrinsics.checkNotNull(num2);
            return TextRange.m1573boximpl(TextRangeKt.TextRange(intValue, num2.intValue()));
        }
    });
    private static final Saver ShadowSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, Shadow it) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Color.m841boximpl(it.m952getColor0d7_KjU()), SaversKt.getSaver(Color.Companion), Saver), SaversKt.save(Offset.m698boximpl(it.m953getOffsetF1C5BW0()), SaversKt.getSaver(Offset.Companion), Saver), SaversKt.save(Float.valueOf(it.getBlurRadius())));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ShadowSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Shadow invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Saver saver = SaversKt.getSaver(Color.Companion);
            Boolean bool = Boolean.FALSE;
            Color color = (Intrinsics.areEqual(obj, bool) || obj == null) ? null : (Color) saver.restore(obj);
            Intrinsics.checkNotNull(color);
            long m859unboximpl = color.m859unboximpl();
            Object obj2 = list.get(1);
            Offset offset = (Intrinsics.areEqual(obj2, bool) || obj2 == null) ? null : (Offset) SaversKt.getSaver(Offset.Companion).restore(obj2);
            Intrinsics.checkNotNull(offset);
            long m718unboximpl = offset.m718unboximpl();
            Object obj3 = list.get(2);
            Float f = obj3 != null ? (Float) obj3 : null;
            Intrinsics.checkNotNull(f);
            return new Shadow(m859unboximpl, m718unboximpl, f.floatValue(), null);
        }
    });
    private static final Saver ColorSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1548invoke4WTKRHQ((SaverScope) obj, ((Color) obj2).m859unboximpl());
        }

        /* renamed from: invoke-4WTKRHQ  reason: not valid java name */
        public final Object m1548invoke4WTKRHQ(SaverScope Saver, long j) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            return ULong.m2134boximpl(j);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4  reason: not valid java name */
        public final Color invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return Color.m841boximpl(Color.m846constructorimpl(((ULong) it).m2140unboximpl()));
        }
    });
    private static final Saver TextUnitSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1554invokempE4wyQ((SaverScope) obj, ((TextUnit) obj2).m1967unboximpl());
        }

        /* renamed from: invoke-mpE4wyQ  reason: not valid java name */
        public final Object m1554invokempE4wyQ(SaverScope Saver, long j) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(TextUnit.m1964getValueimpl(j))), SaversKt.save(TextUnitType.m1973boximpl(TextUnit.m1963getTypeUIouoOA(j))));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$TextUnitSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-XNhUCwk  reason: not valid java name */
        public final TextUnit invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            Object obj = list.get(0);
            Float f = obj != null ? (Float) obj : null;
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj2 = list.get(1);
            TextUnitType textUnitType = obj2 != null ? (TextUnitType) obj2 : null;
            Intrinsics.checkNotNull(textUnitType);
            return TextUnit.m1958boximpl(TextUnitKt.m1969TextUnitanM5pPY(floatValue, textUnitType.m1979unboximpl()));
        }
    });
    private static final Saver OffsetSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return m1550invokeUv8p0NA((SaverScope) obj, ((Offset) obj2).m718unboximpl());
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
        public final Object m1550invokeUv8p0NA(SaverScope Saver, long j) {
            ArrayList arrayListOf;
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            if (Offset.m706equalsimpl0(j, Offset.Companion.m720getUnspecifiedF1C5BW0())) {
                return Boolean.FALSE;
            }
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(SaversKt.save(Float.valueOf(Offset.m709getXimpl(j))), SaversKt.save(Float.valueOf(Offset.m710getYimpl(j))));
            return arrayListOf;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$OffsetSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-x-9fifI  reason: not valid java name */
        public final Offset invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            if (Intrinsics.areEqual(it, Boolean.FALSE)) {
                return Offset.m698boximpl(Offset.Companion.m720getUnspecifiedF1C5BW0());
            }
            List list = (List) it;
            Object obj = list.get(0);
            Float f = obj != null ? (Float) obj : null;
            Intrinsics.checkNotNull(f);
            float floatValue = f.floatValue();
            Object obj2 = list.get(1);
            Float f2 = obj2 != null ? (Float) obj2 : null;
            Intrinsics.checkNotNull(f2);
            return Offset.m698boximpl(OffsetKt.Offset(floatValue, f2.floatValue()));
        }
    });
    private static final Saver LocaleListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, LocaleList it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            List localeList = it.getLocaleList();
            ArrayList arrayList = new ArrayList(localeList.size());
            int size = localeList.size();
            for (int i = 0; i < size; i++) {
                arrayList.add(SaversKt.save((Locale) localeList.get(i), SaversKt.getSaver(Locale.Companion), Saver));
            }
            return arrayList;
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$LocaleListSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final LocaleList invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            List list = (List) it;
            ArrayList arrayList = new ArrayList(list.size());
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Object obj = list.get(i);
                Saver saver = SaversKt.getSaver(Locale.Companion);
                Locale locale = null;
                if (!Intrinsics.areEqual(obj, Boolean.FALSE) && obj != null) {
                    locale = (Locale) saver.restore(obj);
                }
                Intrinsics.checkNotNull(locale);
                arrayList.add(locale);
            }
            return new LocaleList(arrayList);
        }
    });
    private static final Saver LocaleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$1
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(SaverScope Saver, Locale it) {
            Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
            Intrinsics.checkNotNullParameter(it, "it");
            return it.toLanguageTag();
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$LocaleSaver$2
        @Override // kotlin.jvm.functions.Function1
        public final Locale invoke(Object it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return new Locale((String) it);
        }
    });

    public static final Saver getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    public static final Saver getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    public static final Saver getSaver(Offset.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return OffsetSaver;
    }

    public static final Saver getSaver(Color.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ColorSaver;
    }

    public static final Saver getSaver(Shadow.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return ShadowSaver;
    }

    public static final Saver getSaver(TextRange.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextRangeSaver;
    }

    public static final Saver getSaver(FontWeight.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return FontWeightSaver;
    }

    public static final Saver getSaver(Locale.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return LocaleSaver;
    }

    public static final Saver getSaver(LocaleList.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return LocaleListSaver;
    }

    public static final Saver getSaver(BaselineShift.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return BaselineShiftSaver;
    }

    public static final Saver getSaver(TextDecoration.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextDecorationSaver;
    }

    public static final Saver getSaver(TextGeometricTransform.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextGeometricTransformSaver;
    }

    public static final Saver getSaver(TextIndent.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextIndentSaver;
    }

    public static final Saver getSaver(TextUnit.Companion companion) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        return TextUnitSaver;
    }

    public static final Saver getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    public static final Object save(Object obj) {
        return obj;
    }

    public static final Object save(Object obj, Saver saver, SaverScope scope) {
        Object save;
        Intrinsics.checkNotNullParameter(saver, "saver");
        Intrinsics.checkNotNullParameter(scope, "scope");
        return (obj == null || (save = saver.save(scope, obj)) == null) ? Boolean.FALSE : save;
    }
}
