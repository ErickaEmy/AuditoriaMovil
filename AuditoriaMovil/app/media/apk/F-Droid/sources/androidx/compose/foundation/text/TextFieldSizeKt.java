package androidx.compose.foundation.text;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutModifierKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
/* compiled from: TextFieldSize.kt */
/* loaded from: classes.dex */
public abstract class TextFieldSizeKt {
    public static final Modifier textFieldMinSize(Modifier modifier, final TextStyle style) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(style, "style");
        return ComposedModifierKt.composed$default(modifier, null, new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r12v0, types: [androidx.compose.runtime.Composer] */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r3v3 */
            public final Modifier invoke(Modifier composed, Composer composer, int i) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(1582736677);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1582736677, i, -1, "androidx.compose.foundation.text.textFieldMinSize.<anonymous> (TextFieldSize.kt:37)");
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                TextStyle textStyle = TextStyle.this;
                composer.startReplaceableGroup(511388516);
                boolean changed = composer.changed(textStyle) | composer.changed(layoutDirection);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = TextStyleKt.resolveDefaults(textStyle, layoutDirection);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                TextStyle textStyle2 = rememberedValue;
                composer.startReplaceableGroup(511388516);
                boolean changed2 = composer.changed(resolver) | composer.changed(textStyle2);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    FontFamily fontFamily = textStyle2.getFontFamily();
                    FontWeight fontWeight = textStyle2.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.Companion.getNormal();
                    }
                    FontStyle m1599getFontStyle4Lr2A7w = textStyle2.m1599getFontStyle4Lr2A7w();
                    int m1644unboximpl = m1599getFontStyle4Lr2A7w != null ? m1599getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA();
                    FontSynthesis m1600getFontSynthesisZQGJjVo = textStyle2.m1600getFontSynthesisZQGJjVo();
                    rememberedValue2 = resolver.mo1626resolveDPcqOEQ(fontFamily, fontWeight, m1644unboximpl, m1600getFontSynthesisZQGJjVo != null ? m1600getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU());
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                State state = rememberedValue2;
                TextStyle textStyle3 = TextStyle.this;
                composer.startReplaceableGroup(-492369756);
                Object rememberedValue3 = composer.rememberedValue();
                TextFieldSize textFieldSize = rememberedValue3;
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    TextFieldSize textFieldSize2 = new TextFieldSize(layoutDirection, density, resolver, textStyle3, state.getValue());
                    composer.updateRememberedValue(textFieldSize2);
                    textFieldSize = textFieldSize2;
                }
                composer.endReplaceableGroup();
                final TextFieldSize textFieldSize3 = (TextFieldSize) textFieldSize;
                textFieldSize3.update(layoutDirection, density, resolver, textStyle2, state.getValue());
                Modifier layout = LayoutModifierKt.layout(Modifier.Companion, new Function3() { // from class: androidx.compose.foundation.text.TextFieldSizeKt$textFieldMinSize$1.1
                    {
                        super(3);
                    }

                    @Override // kotlin.jvm.functions.Function3
                    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                        return m350invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m1877unboximpl());
                    }

                    /* renamed from: invoke-3p2s80s  reason: not valid java name */
                    public final MeasureResult m350invoke3p2s80s(MeasureScope layout2, Measurable measurable, long j) {
                        int coerceIn;
                        int coerceIn2;
                        Intrinsics.checkNotNullParameter(layout2, "$this$layout");
                        Intrinsics.checkNotNullParameter(measurable, "measurable");
                        SizeKt.m225defaultMinSizeVpY3zN4$default(Modifier.Companion, 0.0f, 0.0f, 3, null);
                        long m349getMinSizeYbymL2g = TextFieldSize.this.m349getMinSizeYbymL2g();
                        coerceIn = RangesKt___RangesKt.coerceIn(IntSize.m1951getWidthimpl(m349getMinSizeYbymL2g), Constraints.m1874getMinWidthimpl(j), Constraints.m1872getMaxWidthimpl(j));
                        coerceIn2 = RangesKt___RangesKt.coerceIn(IntSize.m1950getHeightimpl(m349getMinSizeYbymL2g), Constraints.m1873getMinHeightimpl(j), Constraints.m1871getMaxHeightimpl(j));
                        final Placeable mo1251measureBRTryo0 = measurable.mo1251measureBRTryo0(Constraints.m1863copyZbe2FdA$default(j, coerceIn, 0, coerceIn2, 0, 10, null));
                        return MeasureScope.CC.layout$default(layout2, mo1251measureBRTryo0.getWidth(), mo1251measureBRTryo0.getHeight(), null, new Function1() { // from class: androidx.compose.foundation.text.TextFieldSizeKt.textFieldMinSize.1.1.1
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((Placeable.PlacementScope) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Placeable.PlacementScope layout3) {
                                Intrinsics.checkNotNullParameter(layout3, "$this$layout");
                                Placeable.PlacementScope.placeRelative$default(layout3, Placeable.this, 0, 0, 0.0f, 4, null);
                            }
                        }, 4, null);
                    }
                });
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return layout;
            }
        }, 1, null);
    }
}
