package org.fdroid.fdroid.compose;

import android.content.Context;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.Colors;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.MaterialThemeKt;
import androidx.compose.material.Shapes;
import androidx.compose.material.SurfaceKt;
import androidx.compose.material.TextKt;
import androidx.compose.material.Typography;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.InspectionModeKt;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.unit.TextUnitKt;
import com.google.accompanist.themeadapter.material.MdcTheme;
import com.google.accompanist.themeadapter.material.ThemeParameters;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.i18n.TextBundle;
import org.fdroid.fdroid.Preferences;
import org.fdroid.fdroid.R;
/* compiled from: ComposeUtils.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u001d\u0010\u0005\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J;\u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ;\u0010\u0010\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\b\b\u0002\u0010\u000b\u001a\u00020\n2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0004\b\u0010\u0010\u000fJ)\u0010\u0015\u001a\u00020\u00032\u0018\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00030\u0011H\u0007¢\u0006\u0004\b\u0015\u0010\u0006J\u0017\u0010\u0016\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007H\u0007¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u001a"}, d2 = {"Lorg/fdroid/fdroid/compose/ComposeUtils;", "", "Lkotlin/Function0;", "", "content", "FDroidContent", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "", TextBundle.TEXT_ENTRY, "onClick", "Landroidx/compose/ui/Modifier;", "modifier", "Landroidx/compose/ui/graphics/vector/ImageVector;", "imageVector", "FDroidButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/vector/ImageVector;Landroidx/compose/runtime/Composer;II)V", "FDroidOutlineButton", "Lkotlin/Function2;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/Lifecycle$Event;", "onEvent", "LifecycleEventListener", "CaptionText", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "<init>", "()V", "app_fullRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes2.dex */
public final class ComposeUtils {
    public static final int $stable = 0;
    public static final ComposeUtils INSTANCE = new ComposeUtils();

    private ComposeUtils() {
    }

    public final void FDroidContent(final Function2 content, Composer composer, final int i) {
        int i2;
        ThemeParameters createMdcTheme;
        Colors colors;
        TextStyle m1594copyv2rsoow;
        TextStyle m1594copyv2rsoow2;
        TextStyle m1594copyv2rsoow3;
        Typography copy;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer startRestartGroup = composer.startRestartGroup(1453036291);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(content) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1453036291, i2, -1, "org.fdroid.fdroid.compose.ComposeUtils.FDroidContent (ComposeUtils.kt:38)");
            }
            createMdcTheme = MdcTheme.createMdcTheme(r11, (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection()), (r15 & 4) != 0 ? AndroidDensity_androidKt.Density((Context) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext())) : null, (r15 & 8) != 0, (r15 & 16) != 0, (r15 & 32) == 0 ? false : true, (r15 & 64) != 0 ? false : false, (r15 & 128) == 0 ? false : false);
            Colors component1 = createMdcTheme.component1();
            Typography component2 = createMdcTheme.component2();
            Shapes component3 = createMdcTheme.component3();
            startRestartGroup.startReplaceableGroup(248607143);
            startRestartGroup.startReplaceableGroup(248607111);
            if (component1 == null) {
                component1 = MaterialTheme.INSTANCE.getColors(startRestartGroup, MaterialTheme.$stable);
            }
            Colors colors2 = component1;
            startRestartGroup.endReplaceableGroup();
            if (((Boolean) startRestartGroup.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue() || colors2.isLight() || !Preferences.get().isPureBlack()) {
                if (colors2.isLight()) {
                    colors = colors2;
                } else {
                    colors = colors2.m442copypvPzIIM((r43 & 1) != 0 ? colors2.m450getPrimary0d7_KjU() : 0L, (r43 & 2) != 0 ? colors2.m451getPrimaryVariant0d7_KjU() : 0L, (r43 & 4) != 0 ? colors2.m452getSecondary0d7_KjU() : 0L, (r43 & 8) != 0 ? colors2.m453getSecondaryVariant0d7_KjU() : 0L, (r43 & 16) != 0 ? colors2.m443getBackground0d7_KjU() : 0L, (r43 & 32) != 0 ? colors2.m454getSurface0d7_KjU() : ColorKt.Color(4280163870L), (r43 & 64) != 0 ? colors2.m444getError0d7_KjU() : 0L, (r43 & 128) != 0 ? colors2.m447getOnPrimary0d7_KjU() : 0L, (r43 & 256) != 0 ? colors2.m448getOnSecondary0d7_KjU() : 0L, (r43 & 512) != 0 ? colors2.m445getOnBackground0d7_KjU() : 0L, (r43 & 1024) != 0 ? colors2.m449getOnSurface0d7_KjU() : 0L, (r43 & 2048) != 0 ? colors2.m446getOnError0d7_KjU() : 0L, (r43 & PKIFailureInfo.certConfirmed) != 0 ? colors2.isLight() : false);
                }
            } else {
                colors = colors2.m442copypvPzIIM((r43 & 1) != 0 ? colors2.m450getPrimary0d7_KjU() : 0L, (r43 & 2) != 0 ? colors2.m451getPrimaryVariant0d7_KjU() : 0L, (r43 & 4) != 0 ? colors2.m452getSecondary0d7_KjU() : 0L, (r43 & 8) != 0 ? colors2.m453getSecondaryVariant0d7_KjU() : 0L, (r43 & 16) != 0 ? colors2.m443getBackground0d7_KjU() : Color.Companion.m860getBlack0d7_KjU(), (r43 & 32) != 0 ? colors2.m454getSurface0d7_KjU() : ColorKt.Color(4280163870L), (r43 & 64) != 0 ? colors2.m444getError0d7_KjU() : 0L, (r43 & 128) != 0 ? colors2.m447getOnPrimary0d7_KjU() : 0L, (r43 & 256) != 0 ? colors2.m448getOnSecondary0d7_KjU() : 0L, (r43 & 512) != 0 ? colors2.m445getOnBackground0d7_KjU() : 0L, (r43 & 1024) != 0 ? colors2.m449getOnSurface0d7_KjU() : 0L, (r43 & 2048) != 0 ? colors2.m446getOnError0d7_KjU() : 0L, (r43 & PKIFailureInfo.certConfirmed) != 0 ? colors2.isLight() : false);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(248607571);
            if (component2 == null) {
                copy = null;
            } else {
                m1594copyv2rsoow = r20.m1594copyv2rsoow((r48 & 1) != 0 ? r20.spanStyle.m1560getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r20.spanStyle.m1561getFontSizeXSAIIZE() : 0L, (r48 & 4) != 0 ? r20.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r20.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? r20.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? r20.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r20.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r20.spanStyle.m1564getLetterSpacingXSAIIZE() : TextUnitKt.getEm(0), (r48 & 256) != 0 ? r20.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? r20.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r20.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r20.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? r20.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r20.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r20.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r20.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? r20.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? r20.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? r20.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? r20.platformStyle : null, (r48 & PKIFailureInfo.badCertTemplate) != 0 ? r20.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? r20.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? r20.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? component2.getBody1().paragraphStyle.getTextMotion() : null);
                m1594copyv2rsoow2 = r21.m1594copyv2rsoow((r48 & 1) != 0 ? r21.spanStyle.m1560getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r21.spanStyle.m1561getFontSizeXSAIIZE() : 0L, (r48 & 4) != 0 ? r21.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r21.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? r21.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? r21.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r21.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r21.spanStyle.m1564getLetterSpacingXSAIIZE() : TextUnitKt.getEm(0), (r48 & 256) != 0 ? r21.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? r21.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r21.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r21.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? r21.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r21.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r21.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r21.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? r21.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? r21.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? r21.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? r21.platformStyle : null, (r48 & PKIFailureInfo.badCertTemplate) != 0 ? r21.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? r21.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? r21.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? component2.getBody2().paragraphStyle.getTextMotion() : null);
                m1594copyv2rsoow3 = r23.m1594copyv2rsoow((r48 & 1) != 0 ? r23.spanStyle.m1560getColor0d7_KjU() : ColorResources_androidKt.colorResource(R.color.fdroid_caption, startRestartGroup, 0), (r48 & 2) != 0 ? r23.spanStyle.m1561getFontSizeXSAIIZE() : TextUnitKt.getSp(12), (r48 & 4) != 0 ? r23.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r23.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? r23.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? r23.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r23.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r23.spanStyle.m1564getLetterSpacingXSAIIZE() : 0L, (r48 & 256) != 0 ? r23.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? r23.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r23.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r23.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? r23.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r23.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r23.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r23.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? r23.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? r23.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? r23.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? r23.platformStyle : null, (r48 & PKIFailureInfo.badCertTemplate) != 0 ? r23.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? r23.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? r23.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? component2.getCaption().paragraphStyle.getTextMotion() : null);
                copy = component2.copy((r28 & 1) != 0 ? component2.h1 : null, (r28 & 2) != 0 ? component2.h2 : null, (r28 & 4) != 0 ? component2.h3 : null, (r28 & 8) != 0 ? component2.h4 : null, (r28 & 16) != 0 ? component2.h5 : null, (r28 & 32) != 0 ? component2.h6 : null, (r28 & 64) != 0 ? component2.subtitle1 : null, (r28 & 128) != 0 ? component2.subtitle2 : null, (r28 & 256) != 0 ? component2.body1 : m1594copyv2rsoow, (r28 & 512) != 0 ? component2.body2 : m1594copyv2rsoow2, (r28 & 1024) != 0 ? component2.button : null, (r28 & 2048) != 0 ? component2.caption : m1594copyv2rsoow3, (r28 & PKIFailureInfo.certConfirmed) != 0 ? component2.overline : null);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(248607559);
            if (copy == null) {
                copy = MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable);
            }
            startRestartGroup.endReplaceableGroup();
            startRestartGroup.startReplaceableGroup(248608095);
            if (component3 == null) {
                component3 = MaterialTheme.INSTANCE.getShapes(startRestartGroup, MaterialTheme.$stable);
            }
            startRestartGroup.endReplaceableGroup();
            MaterialThemeKt.MaterialTheme(colors, copy, component3, ComposableLambdaKt.composableLambda(startRestartGroup, 649438895, true, new Function2() { // from class: org.fdroid.fdroid.compose.ComposeUtils$FDroidContent$2
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    if ((i3 & 11) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(649438895, i3, -1, "org.fdroid.fdroid.compose.ComposeUtils.FDroidContent.<anonymous> (ComposeUtils.kt:69)");
                    }
                    SurfaceKt.m546SurfaceFjzlyU(null, null, 0L, 0L, null, 0.0f, Function2.this, composer2, 0, 63);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), startRestartGroup, 3072, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.compose.ComposeUtils$FDroidContent$3
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

                public final void invoke(Composer composer2, int i3) {
                    ComposeUtils.this.FDroidContent(content, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void FDroidButton(final java.lang.String r21, final kotlin.jvm.functions.Function0 r22, androidx.compose.ui.Modifier r23, androidx.compose.ui.graphics.vector.ImageVector r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.compose.ComposeUtils.FDroidButton(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void FDroidOutlineButton(final java.lang.String r21, final kotlin.jvm.functions.Function0 r22, androidx.compose.ui.Modifier r23, androidx.compose.ui.graphics.vector.ImageVector r24, androidx.compose.runtime.Composer r25, final int r26, final int r27) {
        /*
            Method dump skipped, instructions count: 283
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.fdroid.compose.ComposeUtils.FDroidOutlineButton(java.lang.String, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.ui.graphics.vector.ImageVector, androidx.compose.runtime.Composer, int, int):void");
    }

    public final void LifecycleEventListener(final Function2 onEvent, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(onEvent, "onEvent");
        Composer startRestartGroup = composer.startRestartGroup(-910953084);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changedInstance(onEvent) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-910953084, i2, -1, "org.fdroid.fdroid.compose.ComposeUtils.LifecycleEventListener (ComposeUtils.kt:131)");
            }
            State rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onEvent, startRestartGroup, i2 & 14);
            State rememberUpdatedState2 = SnapshotStateKt.rememberUpdatedState(startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalLifecycleOwner()), startRestartGroup, 8);
            Object value = rememberUpdatedState2.getValue();
            startRestartGroup.startReplaceableGroup(1430957396);
            boolean changed = startRestartGroup.changed(rememberUpdatedState2) | startRestartGroup.changed(rememberUpdatedState);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (changed || rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = new ComposeUtils$LifecycleEventListener$1$1(rememberUpdatedState2, rememberUpdatedState);
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            EffectsKt.DisposableEffect(value, (Function1) rememberedValue, startRestartGroup, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.compose.ComposeUtils$LifecycleEventListener$2
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

                public final void invoke(Composer composer2, int i3) {
                    ComposeUtils.this.LifecycleEventListener(onEvent, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void CaptionText(final String text, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(text, "text");
        Composer startRestartGroup = composer.startRestartGroup(-1851403916);
        if ((i & 14) == 0) {
            i2 = (startRestartGroup.changed(text) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !startRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1851403916, i2, -1, "org.fdroid.fdroid.compose.ComposeUtils.CaptionText (ComposeUtils.kt:152)");
            }
            float f = 0;
            composer2 = startRestartGroup;
            TextKt.m581Text4IGK_g(text, PaddingKt.m210paddingqDBjuR0(Modifier.Companion, Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(16), Dp.m1897constructorimpl(f), Dp.m1897constructorimpl(4)), 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(startRestartGroup, MaterialTheme.$stable).getCaption(), composer2, (i2 & 14) | 48, 0, 65532);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: org.fdroid.fdroid.compose.ComposeUtils$CaptionText$1
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

                public final void invoke(Composer composer3, int i3) {
                    ComposeUtils.this.CaptionText(text, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
