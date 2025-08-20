package androidx.compose.foundation.text;

import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: HeightInLinesModifier.kt */
/* loaded from: classes.dex */
public abstract class HeightInLinesModifierKt {
    public static final void validateMinMaxLines(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            throw new IllegalArgumentException(("both minLines " + i + " and maxLines " + i2 + " must be greater than zero").toString());
        } else if (i <= i2) {
        } else {
            throw new IllegalArgumentException(("minLines " + i + " must be less than or equal to maxLines " + i2).toString());
        }
    }

    public static final Modifier heightInLines(Modifier modifier, final TextStyle textStyle, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(textStyle, "textStyle");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(obj);
                invoke((InspectorInfo) null);
                return Unit.INSTANCE;
            }

            public final void invoke(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                throw null;
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.foundation.text.HeightInLinesModifierKt$heightInLines$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
            }

            public final Modifier invoke(Modifier composed, Composer composer, int i3) {
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                composer.startReplaceableGroup(408240218);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(408240218, i3, -1, "androidx.compose.foundation.text.heightInLines.<anonymous> (HeightInLinesModifier.kt:58)");
                }
                HeightInLinesModifierKt.validateMinMaxLines(i, i2);
                if (i == 1 && i2 == Integer.MAX_VALUE) {
                    Modifier.Companion companion = Modifier.Companion;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer.endReplaceableGroup();
                    return companion;
                }
                Density density = (Density) composer.consume(CompositionLocalsKt.getLocalDensity());
                FontFamily.Resolver resolver = (FontFamily.Resolver) composer.consume(CompositionLocalsKt.getLocalFontFamilyResolver());
                LayoutDirection layoutDirection = (LayoutDirection) composer.consume(CompositionLocalsKt.getLocalLayoutDirection());
                TextStyle textStyle2 = textStyle;
                composer.startReplaceableGroup(511388516);
                boolean changed = composer.changed(textStyle2) | composer.changed(layoutDirection);
                Object rememberedValue = composer.rememberedValue();
                if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                    rememberedValue = TextStyleKt.resolveDefaults(textStyle2, layoutDirection);
                    composer.updateRememberedValue(rememberedValue);
                }
                composer.endReplaceableGroup();
                TextStyle textStyle3 = (TextStyle) rememberedValue;
                composer.startReplaceableGroup(511388516);
                boolean changed2 = composer.changed(resolver) | composer.changed(textStyle3);
                Object rememberedValue2 = composer.rememberedValue();
                if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                    FontFamily fontFamily = textStyle3.getFontFamily();
                    FontWeight fontWeight = textStyle3.getFontWeight();
                    if (fontWeight == null) {
                        fontWeight = FontWeight.Companion.getNormal();
                    }
                    FontStyle m1599getFontStyle4Lr2A7w = textStyle3.m1599getFontStyle4Lr2A7w();
                    int m1644unboximpl = m1599getFontStyle4Lr2A7w != null ? m1599getFontStyle4Lr2A7w.m1644unboximpl() : FontStyle.Companion.m1646getNormal_LCdwA();
                    FontSynthesis m1600getFontSynthesisZQGJjVo = textStyle3.m1600getFontSynthesisZQGJjVo();
                    rememberedValue2 = resolver.mo1626resolveDPcqOEQ(fontFamily, fontWeight, m1644unboximpl, m1600getFontSynthesisZQGJjVo != null ? m1600getFontSynthesisZQGJjVo.m1655unboximpl() : FontSynthesis.Companion.m1656getAllGVVA2EU());
                    composer.updateRememberedValue(rememberedValue2);
                }
                composer.endReplaceableGroup();
                State state = (State) rememberedValue2;
                Object[] objArr = {density, resolver, textStyle, layoutDirection, state.getValue()};
                composer.startReplaceableGroup(-568225417);
                boolean z = false;
                for (int i4 = 0; i4 < 5; i4++) {
                    z |= composer.changed(objArr[i4]);
                }
                Object rememberedValue3 = composer.rememberedValue();
                if (z || rememberedValue3 == Composer.Companion.getEmpty()) {
                    rememberedValue3 = Integer.valueOf(IntSize.m1950getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement(), 1)));
                    composer.updateRememberedValue(rememberedValue3);
                }
                composer.endReplaceableGroup();
                int intValue = ((Number) rememberedValue3).intValue();
                Object[] objArr2 = {density, resolver, textStyle, layoutDirection, state.getValue()};
                composer.startReplaceableGroup(-568225417);
                boolean z2 = false;
                for (int i5 = 0; i5 < 5; i5++) {
                    z2 |= composer.changed(objArr2[i5]);
                }
                Object rememberedValue4 = composer.rememberedValue();
                if (z2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                    rememberedValue4 = Integer.valueOf(IntSize.m1950getHeightimpl(TextFieldDelegateKt.computeSizeForDefaultText(textStyle3, density, resolver, TextFieldDelegateKt.getEmptyTextReplacement() + '\n' + TextFieldDelegateKt.getEmptyTextReplacement(), 2)));
                    composer.updateRememberedValue(rememberedValue4);
                }
                composer.endReplaceableGroup();
                int intValue2 = ((Number) rememberedValue4).intValue() - intValue;
                int i6 = i;
                Integer valueOf = i6 == 1 ? null : Integer.valueOf(((i6 - 1) * intValue2) + intValue);
                int i7 = i2;
                Integer valueOf2 = i7 != Integer.MAX_VALUE ? Integer.valueOf(intValue + (intValue2 * (i7 - 1))) : null;
                Modifier m227heightInVpY3zN4 = SizeKt.m227heightInVpY3zN4(Modifier.Companion, valueOf != null ? density.mo152toDpu2uoSUM(valueOf.intValue()) : Dp.Companion.m1905getUnspecifiedD9Ej5fM(), valueOf2 != null ? density.mo152toDpu2uoSUM(valueOf2.intValue()) : Dp.Companion.m1905getUnspecifiedD9Ej5fM());
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                composer.endReplaceableGroup();
                return m227heightInVpY3zN4;
            }
        });
    }
}
