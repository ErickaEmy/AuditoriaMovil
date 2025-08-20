package androidx.compose.material;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt__MathJVMKt;
import kotlin.ranges.RangesKt___RangesKt;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: OutlinedTextField.kt */
/* loaded from: classes.dex */
public abstract class OutlinedTextFieldKt {
    private static final float OutlinedTextFieldInnerPadding = Dp.m1897constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m1897constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:107:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01dd  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x01f4  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x01fa  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:190:0x023a  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02ba  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0318  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0342  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x037f  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03b3  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03b5  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03d3  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03da  */
    /* JADX WARN: Removed duplicated region for block: B:294:0x03fa  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x0401  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x041b  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x047d  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x04a6  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04c5  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x0520  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0543  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x060f  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x063d  */
    /* JADX WARN: Removed duplicated region for block: B:324:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0091  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r73, final kotlin.jvm.functions.Function1 r74, androidx.compose.ui.Modifier r75, boolean r76, boolean r77, androidx.compose.ui.text.TextStyle r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, kotlin.jvm.functions.Function2 r81, kotlin.jvm.functions.Function2 r82, boolean r83, androidx.compose.ui.text.input.VisualTransformation r84, androidx.compose.foundation.text.KeyboardOptions r85, androidx.compose.foundation.text.KeyboardActions r86, boolean r87, int r88, int r89, androidx.compose.foundation.interaction.MutableInteractionSource r90, androidx.compose.ui.graphics.Shape r91, androidx.compose.material.TextFieldColors r92, androidx.compose.runtime.Composer r93, final int r94, final int r95, final int r96) {
        /*
            Method dump skipped, instructions count: 1625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2 textField, final Function3 function3, final Function2 function2, final Function2 function22, final Function2 function23, final boolean z, final float f, final Function1 onLabelMeasured, final Function2 border, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        float coerceAtLeast;
        float coerceAtLeast2;
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Intrinsics.checkNotNullParameter(textField, "textField");
        Intrinsics.checkNotNullParameter(onLabelMeasured, "onLabelMeasured");
        Intrinsics.checkNotNullParameter(border, "border");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        Composer startRestartGroup = composer.startRestartGroup(-2049536174);
        int i4 = (i & 14) == 0 ? (startRestartGroup.changed(modifier) ? 4 : 2) | i : i;
        if ((i & 112) == 0) {
            i4 |= startRestartGroup.changedInstance(textField) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= startRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= startRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(function23) ? PKIFailureInfo.unsupportedVersion : PKIFailureInfo.notAuthorized;
        }
        if ((3670016 & i) == 0) {
            i4 |= startRestartGroup.changed(z) ? PKIFailureInfo.badCertTemplate : PKIFailureInfo.signerNotTrusted;
        }
        if ((29360128 & i) == 0) {
            i4 |= startRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(onLabelMeasured) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i4 |= startRestartGroup.changedInstance(border) ? PKIFailureInfo.duplicateCertReq : 268435456;
        }
        int i5 = (i2 & 14) == 0 ? i2 | (startRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i4 & 1533916891) == 306783378 && (i5 & 11) == 2 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, i4, i5, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:476)");
            }
            Object[] objArr = {onLabelMeasured, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            startRestartGroup.startReplaceableGroup(-568225417);
            int i6 = 0;
            boolean z2 = false;
            for (int i7 = 4; i6 < i7; i7 = 4) {
                z2 |= startRestartGroup.changed(objArr[i6]);
                i6++;
            }
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (z2 || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new OutlinedTextFieldMeasurePolicy(onLabelMeasured, z, f, paddingValues);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) rememberedValue;
            LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = startRestartGroup.getCurrentCompositionLocalMap();
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            Function0 constructor = companion.getConstructor();
            Function3 modifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
            int i8 = ((((i4 << 3) & 112) << 9) & 7168) | 6;
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor);
            } else {
                startRestartGroup.useNode();
            }
            Composer m624constructorimpl = Updater.m624constructorimpl(startRestartGroup);
            Updater.m625setimpl(m624constructorimpl, outlinedTextFieldMeasurePolicy, companion.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl, currentCompositionLocalMap, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = companion.getSetCompositeKeyHash();
            if (m624constructorimpl.getInserting() || !Intrinsics.areEqual(m624constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                m624constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                m624constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            modifierMaterializerOf.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, Integer.valueOf((i8 >> 3) & 112));
            startRestartGroup.startReplaceableGroup(2058660585);
            border.invoke(startRestartGroup, Integer.valueOf((i4 >> 27) & 14));
            startRestartGroup.startReplaceableGroup(1169918076);
            if (function22 != null) {
                Modifier then = LayoutIdKt.layoutId(Modifier.Companion, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor2 = companion.getConstructor();
                Function3 modifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(then);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor2);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m624constructorimpl2 = Updater.m624constructorimpl(startRestartGroup);
                Updater.m625setimpl(m624constructorimpl2, rememberBoxMeasurePolicy, companion.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl2, currentCompositionLocalMap2, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash2 = companion.getSetCompositeKeyHash();
                if (m624constructorimpl2.getInserting() || !Intrinsics.areEqual(m624constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    m624constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    m624constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                modifierMaterializerOf2.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                function22.invoke(startRestartGroup, Integer.valueOf((i4 >> 12) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(1169918361);
            if (function23 != null) {
                Modifier then2 = LayoutIdKt.layoutId(Modifier.Companion, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.Companion.getCenter();
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, startRestartGroup, 6);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor3 = companion.getConstructor();
                Function3 modifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(then2);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor3);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m624constructorimpl3 = Updater.m624constructorimpl(startRestartGroup);
                Updater.m625setimpl(m624constructorimpl3, rememberBoxMeasurePolicy2, companion.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl3, currentCompositionLocalMap3, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash3 = companion.getSetCompositeKeyHash();
                if (m624constructorimpl3.getInserting() || !Intrinsics.areEqual(m624constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    m624constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    m624constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                modifierMaterializerOf3.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                function23.invoke(startRestartGroup, Integer.valueOf((i4 >> 15) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            float calculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float calculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion2 = Modifier.Companion;
            if (function22 != null) {
                i3 = 0;
                coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(Dp.m1897constructorimpl(calculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m1897constructorimpl(0));
                calculateStartPadding = Dp.m1897constructorimpl(coerceAtLeast2);
            } else {
                i3 = 0;
            }
            float f2 = calculateStartPadding;
            if (function23 != null) {
                coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(Dp.m1897constructorimpl(calculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m1897constructorimpl(i3));
                calculateEndPadding = Dp.m1897constructorimpl(coerceAtLeast);
            }
            Modifier m211paddingqDBjuR0$default = PaddingKt.m211paddingqDBjuR0$default(companion2, f2, 0.0f, calculateEndPadding, 0.0f, 10, null);
            startRestartGroup.startReplaceableGroup(1169919372);
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(companion2, "Hint").then(m211paddingqDBjuR0$default), startRestartGroup, Integer.valueOf((i4 >> 3) & 112));
            }
            startRestartGroup.endReplaceableGroup();
            Modifier then3 = LayoutIdKt.layoutId(companion2, "TextField").then(m211paddingqDBjuR0$default);
            startRestartGroup.startReplaceableGroup(733328855);
            Alignment.Companion companion3 = Alignment.Companion;
            MeasurePolicy rememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), true, startRestartGroup, 48);
            startRestartGroup.startReplaceableGroup(-1323940314);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = startRestartGroup.getCurrentCompositionLocalMap();
            Function0 constructor4 = companion.getConstructor();
            Function3 modifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(then3);
            if (!(startRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            startRestartGroup.startReusableNode();
            if (startRestartGroup.getInserting()) {
                startRestartGroup.createNode(constructor4);
            } else {
                startRestartGroup.useNode();
            }
            Composer m624constructorimpl4 = Updater.m624constructorimpl(startRestartGroup);
            Updater.m625setimpl(m624constructorimpl4, rememberBoxMeasurePolicy3, companion.getSetMeasurePolicy());
            Updater.m625setimpl(m624constructorimpl4, currentCompositionLocalMap4, companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash4 = companion.getSetCompositeKeyHash();
            if (m624constructorimpl4.getInserting() || !Intrinsics.areEqual(m624constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                m624constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                m624constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            modifierMaterializerOf4.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
            startRestartGroup.startReplaceableGroup(2058660585);
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            textField.invoke(startRestartGroup, Integer.valueOf((i4 >> 3) & 14));
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(-614207951);
            if (function2 != null) {
                Modifier layoutId = LayoutIdKt.layoutId(companion2, "Label");
                startRestartGroup.startReplaceableGroup(733328855);
                MeasurePolicy rememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(companion3.getTopStart(), false, startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(-1323940314);
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(startRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = startRestartGroup.getCurrentCompositionLocalMap();
                Function0 constructor5 = companion.getConstructor();
                Function3 modifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(layoutId);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor5);
                } else {
                    startRestartGroup.useNode();
                }
                Composer m624constructorimpl5 = Updater.m624constructorimpl(startRestartGroup);
                Updater.m625setimpl(m624constructorimpl5, rememberBoxMeasurePolicy4, companion.getSetMeasurePolicy());
                Updater.m625setimpl(m624constructorimpl5, currentCompositionLocalMap5, companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash5 = companion.getSetCompositeKeyHash();
                if (m624constructorimpl5.getInserting() || !Intrinsics.areEqual(m624constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                    m624constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                    m624constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                }
                modifierMaterializerOf5.invoke(SkippableUpdater.m617boximpl(SkippableUpdater.m618constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                function2.invoke(startRestartGroup, Integer.valueOf((i4 >> 9) & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.endNode();
            startRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.OutlinedTextFieldKt$OutlinedTextFieldLayout$2
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

            public final void invoke(Composer composer2, int i9) {
                OutlinedTextFieldKt.OutlinedTextFieldLayout(Modifier.this, textField, function3, function2, function22, function23, z, f, onLabelMeasured, border, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw  reason: not valid java name */
    public static final int m513calculateWidthO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        int roundToInt;
        int max = i + Math.max(i3, Math.max(MathHelpersKt.lerp(i4, 0, f), i5)) + i2;
        LayoutDirection layoutDirection = LayoutDirection.Ltr;
        roundToInt = MathKt__MathJVMKt.roundToInt((i4 + (Dp.m1897constructorimpl(paddingValues.mo219calculateLeftPaddingu2uoSUM(layoutDirection) + paddingValues.mo220calculateRightPaddingu2uoSUM(layoutDirection)) * f2)) * f);
        return Math.max(max, Math.max(roundToInt, Constraints.m1874getMinWidthimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw  reason: not valid java name */
    public static final int m512calculateHeightO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        int roundToInt;
        int max = Math.max(i3, Math.max(i5, MathHelpersKt.lerp(i4, 0, f)));
        float mo221calculateTopPaddingD9Ej5fM = paddingValues.mo221calculateTopPaddingD9Ej5fM() * f2;
        float lerp = MathHelpersKt.lerp(mo221calculateTopPaddingD9Ej5fM, Math.max(mo221calculateTopPaddingD9Ej5fM, i4 / 2.0f), f) + max;
        int m1873getMinHeightimpl = Constraints.m1873getMinHeightimpl(j);
        roundToInt = MathKt__MathJVMKt.roundToInt(lerp + (paddingValues.mo218calculateBottomPaddingD9Ej5fM() * f2));
        return Math.max(m1873getMinHeightimpl, Math.max(i, Math.max(i2, roundToInt)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int roundToInt;
        int roundToInt2;
        int roundToInt3;
        roundToInt = MathKt__MathJVMKt.roundToInt(paddingValues.mo221calculateTopPaddingD9Ej5fM() * f2);
        roundToInt2 = MathKt__MathJVMKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.Companion.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.Companion.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            int lerp = MathHelpersKt.lerp(z ? Alignment.Companion.getCenterVertically().align(placeable4.getHeight(), i) : roundToInt, -(placeable4.getHeight() / 2), f);
            roundToInt3 = MathKt__MathJVMKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f));
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, roundToInt3 + roundToInt2, lerp, 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.Companion.getCenterVertically().align(placeable3.getHeight(), i) : roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                roundToInt = Alignment.Companion.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), Math.max(roundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m1272place70tqf50$default(placementScope, placeable6, IntOffset.Companion.m1942getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM  reason: not valid java name */
    public static final Modifier m514outlineCutout12SF9DM(Modifier outlineCutout, final long j, final PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(outlineCutout, "$this$outlineCutout");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return DrawModifierKt.drawWithContent(outlineCutout, new Function1() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            /* loaded from: classes.dex */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(ContentDrawScope drawWithContent) {
                float f;
                float coerceAtLeast;
                float coerceAtLeast2;
                Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                float m745getWidthimpl = Size.m745getWidthimpl(j);
                if (m745getWidthimpl > 0.0f) {
                    f = OutlinedTextFieldKt.OutlinedTextFieldInnerPadding;
                    float mo155toPx0680j_4 = drawWithContent.mo155toPx0680j_4(f);
                    float mo155toPx0680j_42 = drawWithContent.mo155toPx0680j_4(paddingValues.mo219calculateLeftPaddingu2uoSUM(drawWithContent.getLayoutDirection())) - mo155toPx0680j_4;
                    float f2 = 2;
                    float f3 = m745getWidthimpl + mo155toPx0680j_42 + (mo155toPx0680j_4 * f2);
                    LayoutDirection layoutDirection = drawWithContent.getLayoutDirection();
                    int[] iArr = WhenMappings.$EnumSwitchMapping$0;
                    if (iArr[layoutDirection.ordinal()] == 1) {
                        coerceAtLeast = Size.m745getWidthimpl(drawWithContent.mo1040getSizeNHjbRc()) - f3;
                    } else {
                        coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(mo155toPx0680j_42, 0.0f);
                    }
                    float f4 = coerceAtLeast;
                    if (iArr[drawWithContent.getLayoutDirection().ordinal()] == 1) {
                        float m745getWidthimpl2 = Size.m745getWidthimpl(drawWithContent.mo1040getSizeNHjbRc());
                        coerceAtLeast2 = RangesKt___RangesKt.coerceAtLeast(mo155toPx0680j_42, 0.0f);
                        f3 = m745getWidthimpl2 - coerceAtLeast2;
                    }
                    float f5 = f3;
                    float m743getHeightimpl = Size.m743getHeightimpl(j);
                    float f6 = (-m743getHeightimpl) / f2;
                    float f7 = m743getHeightimpl / f2;
                    int m839getDifferencertfAjoo = ClipOp.Companion.m839getDifferencertfAjoo();
                    DrawContext drawContext = drawWithContent.getDrawContext();
                    long mo1044getSizeNHjbRc = drawContext.mo1044getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo1047clipRectN_I0leg(f4, f6, f5, f7, m839getDifferencertfAjoo);
                    drawWithContent.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo1045setSizeuvyYCjk(mo1044getSizeNHjbRc);
                    return;
                }
                drawWithContent.drawContent();
            }
        });
    }
}
