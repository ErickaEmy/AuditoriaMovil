package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitType;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public final class EncodeHelper {
    private Parcel parcel;

    public EncodeHelper() {
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final void reset() {
        this.parcel.recycle();
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
    }

    public final String encodedString() {
        String encodeToString = Base64.encodeToString(this.parcel.marshall(), 0);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(bytes, Base64.DEFAULT)");
        return encodeToString;
    }

    public final void encode(SpanStyle spanStyle) {
        Intrinsics.checkNotNullParameter(spanStyle, "spanStyle");
        long m1560getColor0d7_KjU = spanStyle.m1560getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (!Color.m851equalsimpl0(m1560getColor0d7_KjU, companion.m864getUnspecified0d7_KjU())) {
            encode((byte) 1);
            m1440encode8_81llA(spanStyle.m1560getColor0d7_KjU());
        }
        long m1561getFontSizeXSAIIZE = spanStyle.m1561getFontSizeXSAIIZE();
        TextUnit.Companion companion2 = TextUnit.Companion;
        if (!TextUnit.m1961equalsimpl0(m1561getFontSizeXSAIIZE, companion2.m1968getUnspecifiedXSAIIZE())) {
            encode((byte) 2);
            m1437encodeR2X_6o(spanStyle.m1561getFontSizeXSAIIZE());
        }
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight != null) {
            encode((byte) 3);
            encode(fontWeight);
        }
        FontStyle m1562getFontStyle4Lr2A7w = spanStyle.m1562getFontStyle4Lr2A7w();
        if (m1562getFontStyle4Lr2A7w != null) {
            int m1644unboximpl = m1562getFontStyle4Lr2A7w.m1644unboximpl();
            encode((byte) 4);
            m1442encodenzbMABs(m1644unboximpl);
        }
        FontSynthesis m1563getFontSynthesisZQGJjVo = spanStyle.m1563getFontSynthesisZQGJjVo();
        if (m1563getFontSynthesisZQGJjVo != null) {
            int m1655unboximpl = m1563getFontSynthesisZQGJjVo.m1655unboximpl();
            encode((byte) 5);
            m1439encode6p3vJLY(m1655unboximpl);
        }
        String fontFeatureSettings = spanStyle.getFontFeatureSettings();
        if (fontFeatureSettings != null) {
            encode((byte) 6);
            encode(fontFeatureSettings);
        }
        if (!TextUnit.m1961equalsimpl0(spanStyle.m1564getLetterSpacingXSAIIZE(), companion2.m1968getUnspecifiedXSAIIZE())) {
            encode((byte) 7);
            m1437encodeR2X_6o(spanStyle.m1564getLetterSpacingXSAIIZE());
        }
        BaselineShift m1559getBaselineShift5SSeXJ0 = spanStyle.m1559getBaselineShift5SSeXJ0();
        if (m1559getBaselineShift5SSeXJ0 != null) {
            float m1749unboximpl = m1559getBaselineShift5SSeXJ0.m1749unboximpl();
            encode((byte) 8);
            m1438encode4Dl_Bck(m1749unboximpl);
        }
        TextGeometricTransform textGeometricTransform = spanStyle.getTextGeometricTransform();
        if (textGeometricTransform != null) {
            encode((byte) 9);
            encode(textGeometricTransform);
        }
        if (!Color.m851equalsimpl0(spanStyle.m1558getBackground0d7_KjU(), companion.m864getUnspecified0d7_KjU())) {
            encode((byte) 10);
            m1440encode8_81llA(spanStyle.m1558getBackground0d7_KjU());
        }
        TextDecoration textDecoration = spanStyle.getTextDecoration();
        if (textDecoration != null) {
            encode((byte) 11);
            encode(textDecoration);
        }
        Shadow shadow = spanStyle.getShadow();
        if (shadow != null) {
            encode((byte) 12);
            encode(shadow);
        }
    }

    /* renamed from: encode-8_81llA  reason: not valid java name */
    public final void m1440encode8_81llA(long j) {
        m1441encodeVKZWuLQ(j);
    }

    /* renamed from: encode--R2X_6o  reason: not valid java name */
    public final void m1437encodeR2X_6o(long j) {
        long m1963getTypeUIouoOA = TextUnit.m1963getTypeUIouoOA(j);
        TextUnitType.Companion companion = TextUnitType.Companion;
        byte b = 0;
        if (!TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1982getUnspecifiedUIouoOA())) {
            if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1981getSpUIouoOA())) {
                b = 1;
            } else if (TextUnitType.m1976equalsimpl0(m1963getTypeUIouoOA, companion.m1980getEmUIouoOA())) {
                b = 2;
            }
        }
        encode(b);
        if (TextUnitType.m1976equalsimpl0(TextUnit.m1963getTypeUIouoOA(j), companion.m1982getUnspecifiedUIouoOA())) {
            return;
        }
        encode(TextUnit.m1964getValueimpl(j));
    }

    public final void encode(FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, "fontWeight");
        encode(fontWeight.getWeight());
    }

    /* renamed from: encode-nzbMABs  reason: not valid java name */
    public final void m1442encodenzbMABs(int i) {
        FontStyle.Companion companion = FontStyle.Companion;
        byte b = 0;
        if (!FontStyle.m1641equalsimpl0(i, companion.m1646getNormal_LCdwA()) && FontStyle.m1641equalsimpl0(i, companion.m1645getItalic_LCdwA())) {
            b = 1;
        }
        encode(b);
    }

    /* renamed from: encode-6p3vJLY  reason: not valid java name */
    public final void m1439encode6p3vJLY(int i) {
        FontSynthesis.Companion companion = FontSynthesis.Companion;
        byte b = 0;
        if (!FontSynthesis.m1650equalsimpl0(i, companion.m1657getNoneGVVA2EU())) {
            if (FontSynthesis.m1650equalsimpl0(i, companion.m1656getAllGVVA2EU())) {
                b = 1;
            } else if (FontSynthesis.m1650equalsimpl0(i, companion.m1659getWeightGVVA2EU())) {
                b = 2;
            } else if (FontSynthesis.m1650equalsimpl0(i, companion.m1658getStyleGVVA2EU())) {
                b = 3;
            }
        }
        encode(b);
    }

    /* renamed from: encode-4Dl_Bck  reason: not valid java name */
    public final void m1438encode4Dl_Bck(float f) {
        encode(f);
    }

    public final void encode(TextGeometricTransform textGeometricTransform) {
        Intrinsics.checkNotNullParameter(textGeometricTransform, "textGeometricTransform");
        encode(textGeometricTransform.getScaleX());
        encode(textGeometricTransform.getSkewX());
    }

    public final void encode(TextDecoration textDecoration) {
        Intrinsics.checkNotNullParameter(textDecoration, "textDecoration");
        encode(textDecoration.getMask());
    }

    public final void encode(Shadow shadow) {
        Intrinsics.checkNotNullParameter(shadow, "shadow");
        m1440encode8_81llA(shadow.m952getColor0d7_KjU());
        encode(Offset.m709getXimpl(shadow.m953getOffsetF1C5BW0()));
        encode(Offset.m710getYimpl(shadow.m953getOffsetF1C5BW0()));
        encode(shadow.getBlurRadius());
    }

    public final void encode(byte b) {
        this.parcel.writeByte(b);
    }

    public final void encode(int i) {
        this.parcel.writeInt(i);
    }

    public final void encode(float f) {
        this.parcel.writeFloat(f);
    }

    /* renamed from: encode-VKZWuLQ  reason: not valid java name */
    public final void m1441encodeVKZWuLQ(long j) {
        this.parcel.writeLong(j);
    }

    public final void encode(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        this.parcel.writeString(string);
    }
}
