package androidx.compose.material;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import kotlin.jvm.functions.Function0;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: Typography.kt */
/* loaded from: classes.dex */
public abstract class TypographyKt {
    private static final TextStyle DefaultTextStyle;
    private static final ProvidableCompositionLocal LocalTypography;

    public static final TextStyle getDefaultTextStyle() {
        return DefaultTextStyle;
    }

    public static final ProvidableCompositionLocal getLocalTypography() {
        return LocalTypography;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextStyle withDefaultFontFamily(TextStyle textStyle, FontFamily fontFamily) {
        TextStyle m1594copyv2rsoow;
        if (textStyle.getFontFamily() != null) {
            return textStyle;
        }
        m1594copyv2rsoow = textStyle.m1594copyv2rsoow((r48 & 1) != 0 ? textStyle.spanStyle.m1560getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? textStyle.spanStyle.m1561getFontSizeXSAIIZE() : 0L, (r48 & 4) != 0 ? textStyle.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? textStyle.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? textStyle.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? textStyle.spanStyle.getFontFamily() : fontFamily, (r48 & 64) != 0 ? textStyle.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? textStyle.spanStyle.m1564getLetterSpacingXSAIIZE() : 0L, (r48 & 256) != 0 ? textStyle.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? textStyle.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? textStyle.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? textStyle.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? textStyle.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? textStyle.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? textStyle.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? textStyle.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? textStyle.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? textStyle.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? textStyle.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? textStyle.platformStyle : null, (r48 & PKIFailureInfo.badCertTemplate) != 0 ? textStyle.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? textStyle.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? textStyle.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? textStyle.paragraphStyle.getTextMotion() : null);
        return m1594copyv2rsoow;
    }

    static {
        TextStyle m1594copyv2rsoow;
        m1594copyv2rsoow = r1.m1594copyv2rsoow((r48 & 1) != 0 ? r1.spanStyle.m1560getColor0d7_KjU() : 0L, (r48 & 2) != 0 ? r1.spanStyle.m1561getFontSizeXSAIIZE() : 0L, (r48 & 4) != 0 ? r1.spanStyle.getFontWeight() : null, (r48 & 8) != 0 ? r1.spanStyle.m1562getFontStyle4Lr2A7w() : null, (r48 & 16) != 0 ? r1.spanStyle.m1563getFontSynthesisZQGJjVo() : null, (r48 & 32) != 0 ? r1.spanStyle.getFontFamily() : null, (r48 & 64) != 0 ? r1.spanStyle.getFontFeatureSettings() : null, (r48 & 128) != 0 ? r1.spanStyle.m1564getLetterSpacingXSAIIZE() : 0L, (r48 & 256) != 0 ? r1.spanStyle.m1559getBaselineShift5SSeXJ0() : null, (r48 & 512) != 0 ? r1.spanStyle.getTextGeometricTransform() : null, (r48 & 1024) != 0 ? r1.spanStyle.getLocaleList() : null, (r48 & 2048) != 0 ? r1.spanStyle.m1558getBackground0d7_KjU() : 0L, (r48 & PKIFailureInfo.certConfirmed) != 0 ? r1.spanStyle.getTextDecoration() : null, (r48 & 8192) != 0 ? r1.spanStyle.getShadow() : null, (r48 & 16384) != 0 ? r1.spanStyle.getDrawStyle() : null, (r48 & 32768) != 0 ? r1.paragraphStyle.m1541getTextAlignbuA522U() : null, (r48 & PKIFailureInfo.notAuthorized) != 0 ? r1.paragraphStyle.m1543getTextDirectionmmuk1to() : null, (r48 & PKIFailureInfo.unsupportedVersion) != 0 ? r1.paragraphStyle.m1540getLineHeightXSAIIZE() : 0L, (r48 & PKIFailureInfo.transactionIdInUse) != 0 ? r1.paragraphStyle.getTextIndent() : null, (r48 & PKIFailureInfo.signerNotTrusted) != 0 ? r1.platformStyle : DefaultPlatformTextStyle_androidKt.defaultPlatformTextStyle(), (r48 & PKIFailureInfo.badCertTemplate) != 0 ? r1.paragraphStyle.getLineHeightStyle() : null, (r48 & PKIFailureInfo.badSenderNonce) != 0 ? r1.paragraphStyle.m1538getLineBreakLgCVezo() : null, (r48 & 4194304) != 0 ? r1.paragraphStyle.m1536getHyphensEaSxIns() : null, (r48 & 8388608) != 0 ? TextStyle.Companion.getDefault().paragraphStyle.getTextMotion() : null);
        DefaultTextStyle = m1594copyv2rsoow;
        LocalTypography = CompositionLocalKt.staticCompositionLocalOf(new Function0() { // from class: androidx.compose.material.TypographyKt$LocalTypography$1
            @Override // kotlin.jvm.functions.Function0
            public final Typography invoke() {
                return new Typography(null, null, null, null, null, null, null, null, null, null, null, null, null, null, 16383, null);
            }
        });
    }
}
