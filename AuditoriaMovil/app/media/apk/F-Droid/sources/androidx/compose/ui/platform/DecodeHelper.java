package androidx.compose.ui.platform;

import android.os.Parcel;
import android.util.Base64;
import androidx.compose.ui.geometry.OffsetKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import java.util.List;
import kotlin.ULong;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidClipboardManager.android.kt */
/* loaded from: classes.dex */
public final class DecodeHelper {
    private final Parcel parcel;

    public DecodeHelper(String string) {
        Intrinsics.checkNotNullParameter(string, "string");
        Parcel obtain = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
        this.parcel = obtain;
        byte[] decode = Base64.decode(string, 0);
        obtain.unmarshall(decode, 0, decode.length);
        obtain.setDataPosition(0);
    }

    public final SpanStyle decodeSpanStyle() {
        MutableSpanStyle mutableSpanStyle;
        MutableSpanStyle mutableSpanStyle2 = r15;
        MutableSpanStyle mutableSpanStyle3 = new MutableSpanStyle(0L, 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 16383, null);
        while (this.parcel.dataAvail() > 1) {
            byte decodeByte = decodeByte();
            if (decodeByte != 1) {
                mutableSpanStyle = mutableSpanStyle2;
                if (decodeByte == 2) {
                    if (dataAvailable() < 5) {
                        break;
                    }
                    mutableSpanStyle.m1450setFontSizeR2X_6o(m1434decodeTextUnitXSAIIZE());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 3) {
                    if (dataAvailable() < 4) {
                        break;
                    }
                    mutableSpanStyle.setFontWeight(decodeFontWeight());
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte == 4) {
                    if (dataAvailable() < 1) {
                        break;
                    }
                    mutableSpanStyle.m1451setFontStylemLjRB2g(FontStyle.m1638boximpl(m1432decodeFontStyle_LCdwA()));
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (decodeByte != 5) {
                    if (decodeByte != 6) {
                        if (decodeByte != 7) {
                            if (decodeByte != 8) {
                                if (decodeByte != 9) {
                                    if (decodeByte != 10) {
                                        if (decodeByte != 11) {
                                            if (decodeByte == 12) {
                                                if (dataAvailable() < 20) {
                                                    break;
                                                }
                                                mutableSpanStyle.setShadow(decodeShadow());
                                            }
                                        } else if (dataAvailable() < 4) {
                                            break;
                                        } else {
                                            mutableSpanStyle.setTextDecoration(decodeTextDecoration());
                                        }
                                    } else if (dataAvailable() < 8) {
                                        break;
                                    } else {
                                        mutableSpanStyle.m1447setBackground8_81llA(m1431decodeColor0d7_KjU());
                                    }
                                } else if (dataAvailable() < 8) {
                                    break;
                                } else {
                                    mutableSpanStyle.setTextGeometricTransform(decodeTextGeometricTransform());
                                }
                            } else if (dataAvailable() < 4) {
                                break;
                            } else {
                                mutableSpanStyle.m1448setBaselineShift_isdbwI(BaselineShift.m1743boximpl(m1429decodeBaselineShifty9eOQZs()));
                            }
                        } else if (dataAvailable() < 5) {
                            break;
                        } else {
                            mutableSpanStyle.m1453setLetterSpacingR2X_6o(m1434decodeTextUnitXSAIIZE());
                        }
                    } else {
                        mutableSpanStyle.setFontFeatureSettings(decodeString());
                    }
                    mutableSpanStyle2 = mutableSpanStyle;
                } else if (dataAvailable() < 1) {
                    break;
                } else {
                    mutableSpanStyle.m1452setFontSynthesistDdu0R4(FontSynthesis.m1647boximpl(m1433decodeFontSynthesisGVVA2EU()));
                    mutableSpanStyle2 = mutableSpanStyle;
                }
            } else if (dataAvailable() < 8) {
                break;
            } else {
                mutableSpanStyle2.m1449setColor8_81llA(m1431decodeColor0d7_KjU());
            }
        }
        mutableSpanStyle = mutableSpanStyle2;
        return mutableSpanStyle.toSpanStyle();
    }

    /* renamed from: decodeColor-0d7_KjU  reason: not valid java name */
    public final long m1431decodeColor0d7_KjU() {
        return Color.m846constructorimpl(m1430decodeULongsVKNKU());
    }

    /* renamed from: decodeTextUnit-XSAIIZE  reason: not valid java name */
    public final long m1434decodeTextUnitXSAIIZE() {
        long m1982getUnspecifiedUIouoOA;
        byte decodeByte = decodeByte();
        if (decodeByte == 1) {
            m1982getUnspecifiedUIouoOA = TextUnitType.Companion.m1981getSpUIouoOA();
        } else if (decodeByte == 2) {
            m1982getUnspecifiedUIouoOA = TextUnitType.Companion.m1980getEmUIouoOA();
        } else {
            m1982getUnspecifiedUIouoOA = TextUnitType.Companion.m1982getUnspecifiedUIouoOA();
        }
        if (TextUnitType.m1976equalsimpl0(m1982getUnspecifiedUIouoOA, TextUnitType.Companion.m1982getUnspecifiedUIouoOA())) {
            return TextUnit.Companion.m1968getUnspecifiedXSAIIZE();
        }
        return TextUnitKt.m1969TextUnitanM5pPY(decodeFloat(), m1982getUnspecifiedUIouoOA);
    }

    public final FontWeight decodeFontWeight() {
        return new FontWeight(decodeInt());
    }

    /* renamed from: decodeFontStyle-_-LCdwA  reason: not valid java name */
    public final int m1432decodeFontStyle_LCdwA() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontStyle.Companion.m1646getNormal_LCdwA();
        }
        if (decodeByte == 1) {
            return FontStyle.Companion.m1645getItalic_LCdwA();
        }
        return FontStyle.Companion.m1646getNormal_LCdwA();
    }

    /* renamed from: decodeFontSynthesis-GVVA2EU  reason: not valid java name */
    public final int m1433decodeFontSynthesisGVVA2EU() {
        byte decodeByte = decodeByte();
        if (decodeByte == 0) {
            return FontSynthesis.Companion.m1657getNoneGVVA2EU();
        }
        if (decodeByte == 1) {
            return FontSynthesis.Companion.m1656getAllGVVA2EU();
        }
        if (decodeByte == 3) {
            return FontSynthesis.Companion.m1658getStyleGVVA2EU();
        }
        if (decodeByte == 2) {
            return FontSynthesis.Companion.m1659getWeightGVVA2EU();
        }
        return FontSynthesis.Companion.m1657getNoneGVVA2EU();
    }

    /* renamed from: decodeBaselineShift-y9eOQZs  reason: not valid java name */
    private final float m1429decodeBaselineShifty9eOQZs() {
        return BaselineShift.m1744constructorimpl(decodeFloat());
    }

    private final TextGeometricTransform decodeTextGeometricTransform() {
        return new TextGeometricTransform(decodeFloat(), decodeFloat());
    }

    private final TextDecoration decodeTextDecoration() {
        List listOf;
        int decodeInt = decodeInt();
        TextDecoration.Companion companion = TextDecoration.Companion;
        boolean z = (companion.getLineThrough().getMask() & decodeInt) != 0;
        boolean z2 = (decodeInt & companion.getUnderline().getMask()) != 0;
        if (z && z2) {
            listOf = CollectionsKt__CollectionsKt.listOf((Object[]) new TextDecoration[]{companion.getLineThrough(), companion.getUnderline()});
            return companion.combine(listOf);
        } else if (z) {
            return companion.getLineThrough();
        } else {
            if (z2) {
                return companion.getUnderline();
            }
            return companion.getNone();
        }
    }

    private final Shadow decodeShadow() {
        return new Shadow(m1431decodeColor0d7_KjU(), OffsetKt.Offset(decodeFloat(), decodeFloat()), decodeFloat(), null);
    }

    private final byte decodeByte() {
        return this.parcel.readByte();
    }

    private final int decodeInt() {
        return this.parcel.readInt();
    }

    /* renamed from: decodeULong-s-VKNKU  reason: not valid java name */
    private final long m1430decodeULongsVKNKU() {
        return ULong.m2135constructorimpl(this.parcel.readLong());
    }

    private final float decodeFloat() {
        return this.parcel.readFloat();
    }

    private final String decodeString() {
        return this.parcel.readString();
    }

    private final int dataAvailable() {
        return this.parcel.dataAvail();
    }
}
