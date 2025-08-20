package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: Switch.kt */
/* loaded from: classes.dex */
public abstract class SwitchKt {
    private static final TweenSpec AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState mutableState) {
        return ((Boolean) mutableState.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1 Switch$lambda$7(State state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$16(State state) {
        return ((Color) state.getValue()).m859unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State state) {
        return ((Color) state.getValue()).m859unboximpl();
    }

    private static final long SwitchImpl$lambda$19(State state) {
        return ((Color) state.getValue()).m859unboximpl();
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0186  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x021b  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x024a A[LOOP:0: B:115:0x0248->B:116:0x024a, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:119:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x02cd  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x030c A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:144:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0426  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0437  */
    /* JADX WARN: Removed duplicated region for block: B:169:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x011e  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x014e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Switch(final boolean r45, final kotlin.jvm.functions.Function1 r46, androidx.compose.ui.Modifier r47, boolean r48, androidx.compose.foundation.interaction.MutableInteractionSource r49, androidx.compose.material.SwitchColors r50, androidx.compose.runtime.Composer r51, final int r52, final int r53) {
        /*
            Method dump skipped, instructions count: 1099
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    static {
        float m1897constructorimpl = Dp.m1897constructorimpl(34);
        TrackWidth = m1897constructorimpl;
        TrackStrokeWidth = Dp.m1897constructorimpl(14);
        float m1897constructorimpl2 = Dp.m1897constructorimpl(20);
        ThumbDiameter = m1897constructorimpl2;
        ThumbRippleRadius = Dp.m1897constructorimpl(24);
        DefaultSwitchPadding = Dp.m1897constructorimpl(2);
        SwitchWidth = m1897constructorimpl;
        SwitchHeight = m1897constructorimpl2;
        ThumbPathLength = Dp.m1897constructorimpl(m1897constructorimpl - m1897constructorimpl2);
        AnimationSpec = new TweenSpec(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m1897constructorimpl(1);
        ThumbPressedElevation = Dp.m1897constructorimpl(6);
        SwitchVelocityThreshold = Dp.m1897constructorimpl(125);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0 function0, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer startRestartGroup = composer.startRestartGroup(70908914);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= startRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= startRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= startRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= startRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= startRestartGroup.changed(interactionSource) ? PKIFailureInfo.unsupportedVersion : PKIFailureInfo.notAuthorized;
        }
        if ((374491 & i2) == 74898 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:212)");
            }
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue == companion.getEmpty()) {
                rememberedValue = SnapshotStateKt.mutableStateListOf();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) rememberedValue;
            int i3 = (i2 >> 15) & 14;
            startRestartGroup.startReplaceableGroup(511388516);
            boolean changed = startRestartGroup.changed(interactionSource) | startRestartGroup.changed(snapshotStateList);
            Object rememberedValue2 = startRestartGroup.rememberedValue();
            if (changed || rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                startRestartGroup.updateRememberedValue(rememberedValue2);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2) rememberedValue2, startRestartGroup, i3 | 64);
            float f = snapshotStateList.isEmpty() ^ true ? ThumbPressedElevation : ThumbDefaultElevation;
            int i4 = ((i2 >> 6) & 14) | (i2 & 112) | ((i2 >> 3) & 896);
            final State trackColor = switchColors.trackColor(z2, z, startRestartGroup, i4);
            Modifier.Companion companion2 = Modifier.Companion;
            Alignment.Companion companion3 = Alignment.Companion;
            Modifier fillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(companion2, companion3.getCenter()), 0.0f, 1, null);
            startRestartGroup.startReplaceableGroup(1157296644);
            boolean changed2 = startRestartGroup.changed(trackColor);
            Object rememberedValue3 = startRestartGroup.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new Function1() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((DrawScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(DrawScope Canvas) {
                        long SwitchImpl$lambda$16;
                        Intrinsics.checkNotNullParameter(Canvas, "$this$Canvas");
                        SwitchImpl$lambda$16 = SwitchKt.SwitchImpl$lambda$16(State.this);
                        SwitchKt.m554drawTrackRPmYEkk(Canvas, SwitchImpl$lambda$16, Canvas.mo155toPx0680j_4(SwitchKt.getTrackWidth()), Canvas.mo155toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                startRestartGroup.updateRememberedValue(rememberedValue3);
            }
            startRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(fillMaxSize$default, (Function1) rememberedValue3, startRestartGroup, 0);
            State thumbColor = switchColors.thumbColor(z2, z, startRestartGroup, i4);
            ElevationOverlay elevationOverlay = (ElevationOverlay) startRestartGroup.consume(ElevationOverlayKt.getLocalElevationOverlay());
            float m1897constructorimpl = Dp.m1897constructorimpl(((Dp) startRestartGroup.consume(ElevationOverlayKt.getLocalAbsoluteElevation())).m1903unboximpl() + f);
            startRestartGroup.startReplaceableGroup(-539243578);
            long SwitchImpl$lambda$18 = (!Color.m851equalsimpl0(SwitchImpl$lambda$18(thumbColor), MaterialTheme.INSTANCE.getColors(startRestartGroup, 6).m454getSurface0d7_KjU()) || elevationOverlay == null) ? SwitchImpl$lambda$18(thumbColor) : elevationOverlay.mo479apply7g2Lkgo(SwitchImpl$lambda$18(thumbColor), m1897constructorimpl, startRestartGroup, 0);
            startRestartGroup.endReplaceableGroup();
            composer2 = startRestartGroup;
            State m25animateColorAsStateeuL9pac = SingleValueAnimationKt.m25animateColorAsStateeuL9pac(SwitchImpl$lambda$18, null, null, null, startRestartGroup, 0, 14);
            Modifier align = boxScope.align(companion2, companion3.getCenterStart());
            composer2.startReplaceableGroup(1157296644);
            boolean changed3 = composer2.changed(function0);
            Object rememberedValue4 = composer2.rememberedValue();
            if (changed3 || rememberedValue4 == companion.getEmpty()) {
                rememberedValue4 = new Function1() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        return IntOffset.m1929boximpl(m556invokeBjo55l4((Density) obj));
                    }

                    /* renamed from: invoke-Bjo55l4  reason: not valid java name */
                    public final long m556invokeBjo55l4(Density offset) {
                        int roundToInt;
                        Intrinsics.checkNotNullParameter(offset, "$this$offset");
                        roundToInt = MathKt__MathJVMKt.roundToInt(((Number) Function0.this.invoke()).floatValue());
                        return IntOffsetKt.IntOffset(roundToInt, 0);
                    }
                };
                composer2.updateRememberedValue(rememberedValue4);
            }
            composer2.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m76backgroundbw27NRU(ShadowKt.m645shadows4CzXII$default(SizeKt.m229requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(align, (Function1) rememberedValue4), interactionSource, RippleKt.m594rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composer2, 54, 4)), ThumbDiameter), f, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$19(m25animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$4
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

            public final void invoke(Composer composer3, int i5) {
                SwitchKt.SwitchImpl(BoxScope.this, z, z2, switchColors, function0, interactionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk  reason: not valid java name */
    public static final void m554drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.CC.m1060drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m710getYimpl(drawScope.mo1039getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m710getYimpl(drawScope.mo1039getCenterF1C5BW0())), f2, StrokeCap.Companion.m971getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }
}
