package androidx.compose.material.icons.filled;

import androidx.compose.material.icons.Icons;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathBuilder;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import kotlin.jvm.internal.Intrinsics;
import org.bouncycastle.asn1.BERTags;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
/* compiled from: ArrowBack.kt */
/* loaded from: classes.dex */
public abstract class ArrowBackKt {
    private static ImageVector _arrowBack;

    public static final ImageVector getArrowBack(Icons.Filled filled) {
        ImageVector.Builder m1080addPathoIyEayM;
        Intrinsics.checkNotNullParameter(filled, "<this>");
        ImageVector imageVector = _arrowBack;
        if (imageVector != null) {
            Intrinsics.checkNotNull(imageVector);
            return imageVector;
        }
        ImageVector.Builder builder = new ImageVector.Builder("Filled.ArrowBack", Dp.m1897constructorimpl(24.0f), Dp.m1897constructorimpl(24.0f), 24.0f, 24.0f, 0L, 0, false, BERTags.FLAGS, null);
        int defaultFillType = VectorKt.getDefaultFillType();
        SolidColor solidColor = new SolidColor(Color.Companion.m860getBlack0d7_KjU(), null);
        int m970getButtKaPHkGw = StrokeCap.Companion.m970getButtKaPHkGw();
        int m980getBevelLxFBmk8 = StrokeJoin.Companion.m980getBevelLxFBmk8();
        PathBuilder pathBuilder = new PathBuilder();
        pathBuilder.moveTo(20.0f, 11.0f);
        pathBuilder.horizontalLineTo(7.83f);
        pathBuilder.lineToRelative(5.59f, -5.59f);
        pathBuilder.lineTo(12.0f, 4.0f);
        pathBuilder.lineToRelative(-8.0f, 8.0f);
        pathBuilder.lineToRelative(8.0f, 8.0f);
        pathBuilder.lineToRelative(1.41f, -1.41f);
        pathBuilder.lineTo(7.83f, 13.0f);
        pathBuilder.horizontalLineTo(20.0f);
        pathBuilder.verticalLineToRelative(-2.0f);
        pathBuilder.close();
        m1080addPathoIyEayM = builder.m1080addPathoIyEayM(pathBuilder.getNodes(), (r30 & 2) != 0 ? VectorKt.getDefaultFillType() : defaultFillType, (r30 & 4) != 0 ? "" : "", (r30 & 8) != 0 ? null : solidColor, (r30 & 16) != 0 ? 1.0f : 1.0f, (r30 & 32) == 0 ? null : null, (r30 & 64) != 0 ? 1.0f : 1.0f, (r30 & 128) != 0 ? 0.0f : 1.0f, (r30 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : m970getButtKaPHkGw, (r30 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : m980getBevelLxFBmk8, (r30 & 1024) != 0 ? 4.0f : 1.0f, (r30 & 2048) != 0 ? 0.0f : 0.0f, (r30 & PKIFailureInfo.certConfirmed) == 0 ? 0.0f : 1.0f, (r30 & 8192) == 0 ? 0.0f : 0.0f);
        ImageVector build = m1080addPathoIyEayM.build();
        _arrowBack = build;
        Intrinsics.checkNotNull(build);
        return build;
    }
}
