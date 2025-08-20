package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.TextStyleKt;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: TextFieldImpl.kt */
/* loaded from: classes.dex */
public abstract class TextFieldImplKt {
    private static final Modifier IconDefaultSizeModifier;
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m1897constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m1897constructorimpl(12);

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final void CommonDecorationBox(final TextFieldType type, final String value, final Function2 innerTextField, final VisualTransformation visualTransformation, final Function2 function2, Function2 function22, Function2 function23, Function2 function24, boolean z, boolean z2, boolean z3, final InteractionSource interactionSource, final PaddingValues contentPadding, final TextFieldColors colors, Function2 function25, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        int i5;
        InputPhase inputPhase;
        Composer composer2;
        final Function2 function26;
        final Function2 function27;
        final Function2 function28;
        final boolean z4;
        final boolean z5;
        final boolean z6;
        final Function2 function29;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(innerTextField, "innerTextField");
        Intrinsics.checkNotNullParameter(visualTransformation, "visualTransformation");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(contentPadding, "contentPadding");
        Intrinsics.checkNotNullParameter(colors, "colors");
        Composer startRestartGroup = composer.startRestartGroup(-712568069);
        if ((i3 & 1) != 0) {
            i4 = i | 6;
        } else if ((i & 14) == 0) {
            i4 = (startRestartGroup.changed(type) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i3 & 2) != 0) {
            i4 |= 48;
        } else if ((i & 112) == 0) {
            i4 |= startRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i3 & 4) != 0) {
            i4 |= 384;
        } else if ((i & 896) == 0) {
            i4 |= startRestartGroup.changedInstance(innerTextField) ? 256 : 128;
        }
        if ((i3 & 8) != 0) {
            i4 |= 3072;
        } else if ((i & 7168) == 0) {
            i4 |= startRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i3 & 16) != 0) {
            i4 |= 24576;
        } else if ((57344 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        int i6 = i3 & 32;
        if (i6 != 0) {
            i4 |= 196608;
        } else if ((i & 458752) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? PKIFailureInfo.unsupportedVersion : PKIFailureInfo.notAuthorized;
        }
        int i7 = i3 & 64;
        if (i7 != 0) {
            i4 |= 1572864;
        } else if ((i & 3670016) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? PKIFailureInfo.badCertTemplate : PKIFailureInfo.signerNotTrusted;
        }
        int i8 = i3 & 128;
        if (i8 != 0) {
            i4 |= 12582912;
        } else if ((i & 29360128) == 0) {
            i4 |= startRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        int i9 = i3 & 256;
        if (i9 != 0) {
            i4 |= 100663296;
        } else if ((i & 234881024) == 0) {
            i4 |= startRestartGroup.changed(z) ? 67108864 : 33554432;
        }
        int i10 = i3 & 512;
        if (i10 != 0) {
            i4 |= 805306368;
        } else if ((i & 1879048192) == 0) {
            i4 |= startRestartGroup.changed(z2) ? PKIFailureInfo.duplicateCertReq : 268435456;
        }
        int i11 = i3 & 1024;
        if (i11 != 0) {
            i5 = i2 | 6;
        } else if ((i2 & 14) == 0) {
            i5 = i2 | (startRestartGroup.changed(z3) ? 4 : 2);
        } else {
            i5 = i2;
        }
        if ((i3 & 2048) != 0) {
            i5 |= 48;
        } else if ((i2 & 112) == 0) {
            i5 |= startRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int i12 = i5;
        if ((i3 & PKIFailureInfo.certConfirmed) != 0) {
            i12 |= 384;
        } else if ((i2 & 896) == 0) {
            i12 |= startRestartGroup.changed(contentPadding) ? 256 : 128;
        }
        if ((i3 & 8192) != 0) {
            i12 |= 3072;
        } else if ((i2 & 7168) == 0) {
            i12 |= startRestartGroup.changed(colors) ? 2048 : 1024;
        }
        int i13 = i3 & 16384;
        if (i13 != 0) {
            i12 |= 24576;
        } else if ((i2 & 57344) == 0) {
            i12 |= startRestartGroup.changedInstance(function25) ? 16384 : 8192;
        }
        if ((i4 & 1533916891) != 306783378 || (46811 & i12) != 9362 || !startRestartGroup.getSkipping()) {
            Function2 function210 = i6 != 0 ? null : function22;
            Function2 function211 = i7 != 0 ? null : function23;
            Function2 function212 = i8 != 0 ? null : function24;
            boolean z7 = i9 != 0 ? false : z;
            boolean z8 = i10 != 0 ? true : z2;
            boolean z9 = i11 != 0 ? false : z3;
            Function2 function213 = i13 != 0 ? null : function25;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-712568069, i4, i12, "androidx.compose.material.CommonDecorationBox (TextFieldImpl.kt:63)");
            }
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(value) | startRestartGroup.changed(visualTransformation);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            final String text = ((TransformedText) rememberedValue).getText().getText();
            if (((Boolean) FocusInteractionKt.collectIsFocusedAsState(interactionSource, startRestartGroup, (i12 >> 3) & 14).getValue()).booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            final int i14 = i4;
            final boolean z10 = z8;
            final boolean z11 = z9;
            final int i15 = i12;
            Function3 function3 = new Function3() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$labelColor$1
                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    return Color.m841boximpl(m575invokeXeAY9LY((InputPhase) obj, (Composer) obj2, ((Number) obj3).intValue()));
                }

                /* renamed from: invoke-XeAY9LY  reason: not valid java name */
                public final long m575invokeXeAY9LY(InputPhase it, Composer composer3, int i16) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    composer3.startReplaceableGroup(697243846);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(697243846, i16, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:91)");
                    }
                    TextFieldColors textFieldColors = TextFieldColors.this;
                    boolean z12 = z10;
                    boolean z13 = it == InputPhase.UnfocusedEmpty ? false : z11;
                    InteractionSource interactionSource2 = interactionSource;
                    int i17 = i15;
                    long m859unboximpl = ((Color) textFieldColors.labelColor(z12, z13, interactionSource2, composer3, ((i14 >> 27) & 14) | ((i17 << 3) & 896) | (i17 & 7168)).getValue()).m859unboximpl();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    composer3.endReplaceableGroup();
                    return m859unboximpl;
                }
            };
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(startRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long m1597getColor0d7_KjU = subtitle1.m1597getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            boolean z12 = (Color.m851equalsimpl0(m1597getColor0d7_KjU, companion.m864getUnspecified0d7_KjU()) && !Color.m851equalsimpl0(caption.m1597getColor0d7_KjU(), companion.m864getUnspecified0d7_KjU())) || (!Color.m851equalsimpl0(subtitle1.m1597getColor0d7_KjU(), companion.m864getUnspecified0d7_KjU()) && Color.m851equalsimpl0(caption.m1597getColor0d7_KjU(), companion.m864getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            startRestartGroup.startReplaceableGroup(2129141006);
            long m1597getColor0d7_KjU2 = materialTheme.getTypography(startRestartGroup, 6).getCaption().m1597getColor0d7_KjU();
            if (z12 && m1597getColor0d7_KjU2 == companion.m864getUnspecified0d7_KjU()) {
                m1597getColor0d7_KjU2 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m859unboximpl();
            }
            long j = m1597getColor0d7_KjU2;
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(2129141197);
            long m1597getColor0d7_KjU3 = materialTheme.getTypography(startRestartGroup, 6).getSubtitle1().m1597getColor0d7_KjU();
            if (z12 && m1597getColor0d7_KjU3 == companion.m864getUnspecified0d7_KjU()) {
                m1597getColor0d7_KjU3 = ((Color) function3.invoke(inputPhase2, startRestartGroup, 0)).m859unboximpl();
            }
            long j2 = m1597getColor0d7_KjU3;
            startRestartGroup.endReplaceableGroup();
            final Function2 function214 = function210;
            final boolean z13 = z9;
            final int i16 = i12;
            final boolean z14 = z8;
            final Function2 function215 = function211;
            final Function2 function216 = function212;
            final boolean z15 = z7;
            final boolean z16 = z12;
            final Function2 function217 = function213;
            composer2 = startRestartGroup;
            textFieldTransitionScope.m580TransitionDTcfvLk(inputPhase2, j, j2, function3, function2 != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new Function6() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3

                /* compiled from: TextFieldImpl.kt */
                /* loaded from: classes.dex */
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[TextFieldType.values().length];
                        try {
                            iArr[TextFieldType.Filled.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[TextFieldType.Outlined.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                /* JADX INFO: Access modifiers changed from: package-private */
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(6);
                }

                @Override // kotlin.jvm.functions.Function6
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
                    m573invokeRIQooxk(((Number) obj).floatValue(), ((Color) obj2).m859unboximpl(), ((Color) obj3).m859unboximpl(), ((Number) obj4).floatValue(), (Composer) obj5, ((Number) obj6).intValue());
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Type inference failed for: r14v0 */
                /* JADX WARN: Type inference failed for: r14v1, types: [int, boolean] */
                /* JADX WARN: Type inference failed for: r14v12 */
                /* renamed from: invoke-RIQooxk  reason: not valid java name */
                public final void m573invokeRIQooxk(final float f, final long j3, final long j4, final float f2, Composer composer3, int i17) {
                    int i18;
                    ?? r14;
                    ComposableLambda composableLambda;
                    ComposableLambda composableLambda2;
                    if ((i17 & 14) == 0) {
                        i18 = (composer3.changed(f) ? 4 : 2) | i17;
                    } else {
                        i18 = i17;
                    }
                    if ((i17 & 112) == 0) {
                        i18 |= composer3.changed(j3) ? 32 : 16;
                    }
                    if ((i17 & 896) == 0) {
                        i18 |= composer3.changed(j4) ? 256 : 128;
                    }
                    if ((i17 & 7168) == 0) {
                        i18 |= composer3.changed(f2) ? 2048 : 1024;
                    }
                    final int i19 = i18;
                    if ((46811 & i19) != 9362 || !composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(341865432, i19, -1, "androidx.compose.material.CommonDecorationBox.<anonymous> (TextFieldImpl.kt:118)");
                        }
                        final Function2 function218 = Function2.this;
                        if (function218 != null) {
                            final boolean z17 = z16;
                            r14 = 1;
                            composableLambda = ComposableLambdaKt.composableLambda(composer3, 362863774, true, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLabel$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i20) {
                                    TextStyle textStyle;
                                    TextStyle m1594copyv2rsoow;
                                    if ((i20 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(362863774, i20, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:121)");
                                        }
                                        MaterialTheme materialTheme2 = MaterialTheme.INSTANCE;
                                        TextStyle lerp = TextStyleKt.lerp(materialTheme2.getTypography(composer4, 6).getSubtitle1(), materialTheme2.getTypography(composer4, 6).getCaption(), f);
                                        boolean z18 = z17;
                                        long j5 = j3;
                                        if (z18) {
                                            m1594copyv2rsoow = lerp.m1594copyv2rsoow((r48 & 1) != 0 ? lerp.spanStyle.m1560getColor0d7_KjU() : j5, (r48 & 2) != 0 ? lerp.spanStyle.m1561getFontSizeXSAIIZE() : 0L, (r48 & 4) != 0 ? lerp.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? lerp.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? lerp.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? lerp.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? lerp.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? lerp.spanStyle.m1564getLetterSpacingXSAIIZE() : 0L, (r48 & 256) != 0 ? lerp.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? lerp.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? lerp.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? lerp.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? lerp.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? lerp.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? lerp.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? lerp.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? lerp.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? lerp.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? lerp.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? lerp.platformStyle : null, (r48 & PKIFailureInfo.badCertTemplate) != 0 ? lerp.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? lerp.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? lerp.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? lerp.paragraphStyle.getTextMotion() : null);
                                            textStyle = m1594copyv2rsoow;
                                        } else {
                                            textStyle = lerp;
                                        }
                                        TextFieldImplKt.m572DecorationeuL9pac(j4, textStyle, null, function218, composer4, ((i19 >> 6) & 14) | 384, 0);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                        } else {
                            r14 = 1;
                            composableLambda = null;
                        }
                        if (function214 == null || text.length() != 0 || f2 <= 0.0f) {
                            composableLambda2 = null;
                        } else {
                            final TextFieldColors textFieldColors = colors;
                            final boolean z18 = z14;
                            final int i20 = i14;
                            final int i21 = i16;
                            final Function2 function219 = function214;
                            composableLambda2 = ComposableLambdaKt.composableLambda(composer3, 1120552650, r14, new Function3() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedPlaceholder$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                                    invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Modifier modifier, Composer composer4, int i22) {
                                    int i23;
                                    Intrinsics.checkNotNullParameter(modifier, "modifier");
                                    if ((i22 & 14) == 0) {
                                        i23 = (composer4.changed(modifier) ? 4 : 2) | i22;
                                    } else {
                                        i23 = i22;
                                    }
                                    if ((i23 & 91) != 18 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(1120552650, i22, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:137)");
                                        }
                                        Modifier alpha = AlphaKt.alpha(modifier, f2);
                                        TextFieldColors textFieldColors2 = textFieldColors;
                                        boolean z19 = z18;
                                        int i24 = i20;
                                        int i25 = i21;
                                        Function2 function220 = function219;
                                        composer4.startReplaceableGroup(733328855);
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), false, composer4, 0);
                                        composer4.startReplaceableGroup(-1323940314);
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                                        Function0 constructor = companion2.getConstructor();
                                        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(alpha);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m624constructorimpl = Updater.m624constructorimpl(composer4);
                                        Updater.m625setimpl(m624constructorimpl, rememberBoxMeasurePolicy, companion2.getSetMeasurePolicy());
                                        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion2.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = companion2.getSetCompositeKeyHash();
                                        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        TextFieldImplKt.m572DecorationeuL9pac(((Color) textFieldColors2.placeholderColor(z19, composer4, ((i24 >> 27) & 14) | ((i25 >> 6) & 112)).getValue()).m859unboximpl(), MaterialTheme.INSTANCE.getTypography(composer4, 6).getSubtitle1(), null, function220, composer4, (i24 >> 6) & 7168, 4);
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                        }
                        final String m545getString4foXLRw = Strings_androidKt.m545getString4foXLRw(Strings.Companion.m540getDefaultErrorMessageUdPEhr4(), composer3, 6);
                        Modifier.Companion companion2 = Modifier.Companion;
                        Object valueOf = Boolean.valueOf(z13);
                        final boolean z19 = z13;
                        composer3.startReplaceableGroup(511388516);
                        boolean changed2 = composer3.changed(valueOf) | composer3.changed(m545getString4foXLRw);
                        Object rememberedValue2 = composer3.rememberedValue();
                        if (changed2 || rememberedValue2 == Composer.Companion.getEmpty()) {
                            rememberedValue2 = new Function1() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decorationBoxModifier$1$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    invoke((SemanticsPropertyReceiver) obj);
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(SemanticsPropertyReceiver semantics) {
                                    Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                                    if (z19) {
                                        SemanticsPropertiesKt.error(semantics, m545getString4foXLRw);
                                    }
                                }
                            };
                            composer3.updateRememberedValue(rememberedValue2);
                        }
                        composer3.endReplaceableGroup();
                        Modifier semantics$default = SemanticsModifierKt.semantics$default(companion2, false, (Function1) rememberedValue2, r14, null);
                        composer3.startReplaceableGroup(-1083197605);
                        TextFieldColors textFieldColors2 = colors;
                        boolean z20 = z14;
                        boolean z21 = z13;
                        int i22 = i16;
                        final long m859unboximpl = ((Color) textFieldColors2.leadingIconColor(z20, z21, composer3, ((i14 >> 27) & 14) | ((i22 << 3) & 112) | ((i22 >> 3) & 896)).getValue()).m859unboximpl();
                        composer3.endReplaceableGroup();
                        final Function2 function220 = function215;
                        ComposableLambda composableLambda3 = function220 != null ? ComposableLambdaKt.composableLambda(composer3, 1505327088, r14, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedLeading$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i23) {
                                if ((i23 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(1505327088, i23, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:160)");
                                }
                                TextFieldImplKt.m572DecorationeuL9pac(m859unboximpl, null, null, function220, composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        composer3.startReplaceableGroup(-1083197162);
                        TextFieldColors textFieldColors3 = colors;
                        boolean z22 = z14;
                        boolean z23 = z13;
                        int i23 = i16;
                        final long m859unboximpl2 = ((Color) textFieldColors3.trailingIconColor(z22, z23, composer3, ((i14 >> 27) & 14) | ((i23 << 3) & 112) | ((i23 >> 3) & 896)).getValue()).m859unboximpl();
                        composer3.endReplaceableGroup();
                        final Function2 function221 = function216;
                        ComposableLambda composableLambda4 = function221 != null ? ComposableLambdaKt.composableLambda(composer3, -1894727196, r14, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$decoratedTrailing$1$1
                            /* JADX INFO: Access modifiers changed from: package-private */
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                invoke((Composer) obj, ((Number) obj2).intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer4, int i24) {
                                if ((i24 & 11) == 2 && composer4.getSkipping()) {
                                    composer4.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1894727196, i24, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous>.<anonymous> (TextFieldImpl.kt:171)");
                                }
                                TextFieldImplKt.m572DecorationeuL9pac(m859unboximpl2, null, null, function221, composer4, 0, 6);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }) : null;
                        int i24 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                        if (i24 == r14) {
                            composer3.startReplaceableGroup(-1083196826);
                            Function2 function222 = innerTextField;
                            boolean z24 = z15;
                            PaddingValues paddingValues = contentPadding;
                            int i25 = i14;
                            TextFieldKt.TextFieldLayout(semantics$default, function222, composableLambda, composableLambda2, composableLambda3, composableLambda4, z24, f, paddingValues, composer3, ((i16 << 18) & 234881024) | ((i25 >> 6) & 3670016) | ((i25 >> 3) & 112) | ((i19 << 21) & 29360128));
                            composer3.endReplaceableGroup();
                        } else if (i24 == 2) {
                            composer3.startReplaceableGroup(-1083196270);
                            composer3.startReplaceableGroup(-492369756);
                            Object rememberedValue3 = composer3.rememberedValue();
                            Composer.Companion companion3 = Composer.Companion;
                            if (rememberedValue3 == companion3.getEmpty()) {
                                rememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.m739boximpl(Size.Companion.m751getZeroNHjbRc()), null, 2, null);
                                composer3.updateRememberedValue(rememberedValue3);
                            }
                            composer3.endReplaceableGroup();
                            final MutableState mutableState = (MutableState) rememberedValue3;
                            final PaddingValues paddingValues2 = contentPadding;
                            final Function2 function223 = function217;
                            final int i26 = i16;
                            ComposableLambda composableLambda5 = ComposableLambdaKt.composableLambda(composer3, 139886979, r14, new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$drawBorder$1
                                /* JADX INFO: Access modifiers changed from: package-private */
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(2);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                                    invoke((Composer) obj, ((Number) obj2).intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i27) {
                                    if ((i27 & 11) != 2 || !composer4.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(139886979, i27, -1, "androidx.compose.material.CommonDecorationBox.<anonymous>.<anonymous> (TextFieldImpl.kt:193)");
                                        }
                                        Modifier m514outlineCutout12SF9DM = OutlinedTextFieldKt.m514outlineCutout12SF9DM(LayoutIdKt.layoutId(Modifier.Companion, "border"), ((Size) MutableState.this.getValue()).m749unboximpl(), paddingValues2);
                                        Function2 function224 = function223;
                                        int i28 = i26;
                                        composer4.startReplaceableGroup(733328855);
                                        MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.Companion.getTopStart(), true, composer4, 48);
                                        composer4.startReplaceableGroup(-1323940314);
                                        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer4, 0);
                                        CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
                                        ComposeUiNode.Companion companion4 = ComposeUiNode.Companion;
                                        Function0 constructor = companion4.getConstructor();
                                        Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(m514outlineCutout12SF9DM);
                                        if (!(composer4.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer4.startReusableNode();
                                        if (composer4.getInserting()) {
                                            composer4.createNode(constructor);
                                        } else {
                                            composer4.useNode();
                                        }
                                        Composer m624constructorimpl = Updater.m624constructorimpl(composer4);
                                        Updater.m625setimpl(m624constructorimpl, rememberBoxMeasurePolicy, companion4.getSetMeasurePolicy());
                                        Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion4.getSetResolvedCompositionLocals());
                                        Function2 setCompositeKeyHash = companion4.getSetCompositeKeyHash();
                                        if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                                            m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                                            m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                                        }
                                        modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(composer4)), composer4, 0);
                                        composer4.startReplaceableGroup(2058660585);
                                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                                        composer4.startReplaceableGroup(1661576646);
                                        if (function224 != null) {
                                            function224.invoke(composer4, Integer.valueOf((i28 >> 12) & 14));
                                        }
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        composer4.endNode();
                                        composer4.endReplaceableGroup();
                                        composer4.endReplaceableGroup();
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer4.skipToGroupEnd();
                                }
                            });
                            Function2 function224 = innerTextField;
                            boolean z25 = z15;
                            Object valueOf2 = Float.valueOf(f);
                            composer3.startReplaceableGroup(511388516);
                            boolean changed3 = composer3.changed(valueOf2) | composer3.changed(mutableState);
                            Object rememberedValue4 = composer3.rememberedValue();
                            if (changed3 || rememberedValue4 == companion3.getEmpty()) {
                                rememberedValue4 = new Function1() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$1$1
                                    /* JADX INFO: Access modifiers changed from: package-private */
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    @Override // kotlin.jvm.functions.Function1
                                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                        m574invokeuvyYCjk(((Size) obj).m749unboximpl());
                                        return Unit.INSTANCE;
                                    }

                                    /* renamed from: invoke-uvyYCjk  reason: not valid java name */
                                    public final void m574invokeuvyYCjk(long j5) {
                                        float m745getWidthimpl = Size.m745getWidthimpl(j5) * f;
                                        float m743getHeightimpl = Size.m743getHeightimpl(j5) * f;
                                        if (Size.m745getWidthimpl(((Size) mutableState.getValue()).m749unboximpl()) == m745getWidthimpl && Size.m743getHeightimpl(((Size) mutableState.getValue()).m749unboximpl()) == m743getHeightimpl) {
                                            return;
                                        }
                                        mutableState.setValue(Size.m739boximpl(SizeKt.Size(m745getWidthimpl, m743getHeightimpl)));
                                    }
                                };
                                composer3.updateRememberedValue(rememberedValue4);
                            }
                            composer3.endReplaceableGroup();
                            PaddingValues paddingValues3 = contentPadding;
                            int i27 = i14;
                            OutlinedTextFieldKt.OutlinedTextFieldLayout(semantics$default, function224, composableLambda2, composableLambda, composableLambda3, composableLambda4, z25, f, (Function1) rememberedValue4, composableLambda5, paddingValues3, composer3, ((i19 << 21) & 29360128) | ((i27 >> 6) & 3670016) | ((i27 >> 3) & 112) | 805306368, (i16 >> 6) & 14);
                            composer3.endReplaceableGroup();
                        } else {
                            composer3.startReplaceableGroup(-1083194783);
                            composer3.endReplaceableGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer3.skipToGroupEnd();
                }
            }), composer2, 1769472);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function26 = function210;
            function27 = function211;
            function28 = function212;
            z4 = z7;
            z5 = z8;
            z6 = z9;
            function29 = function213;
        } else {
            startRestartGroup.skipToGroupEnd();
            function26 = function22;
            function27 = function23;
            function28 = function24;
            z4 = z;
            z5 = z2;
            z6 = z3;
            function29 = function25;
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer3, int i17) {
                TextFieldImplKt.CommonDecorationBox(TextFieldType.this, value, innerTextField, visualTransformation, function2, function26, function27, function28, z4, z5, z6, interactionSource, contentPadding, colors, function29, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004a  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
    /* renamed from: Decoration-euL9pac  reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m572DecorationeuL9pac(final long r15, androidx.compose.ui.text.TextStyle r17, java.lang.Float r18, final kotlin.jvm.functions.Function2 r19, androidx.compose.runtime.Composer r20, final int r21, final int r22) {
        /*
            Method dump skipped, instructions count: 253
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m572DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Intrinsics.checkNotNullParameter(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 48;
        IconDefaultSizeModifier = androidx.compose.foundation.layout.SizeKt.m224defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(f));
    }
}
