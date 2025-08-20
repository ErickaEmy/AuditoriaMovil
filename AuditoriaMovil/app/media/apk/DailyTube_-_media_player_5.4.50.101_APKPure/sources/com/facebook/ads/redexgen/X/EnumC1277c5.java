package com.facebook.ads.redexgen.X;

import com.uv.v7.R;
import java.util.Arrays;
import kotlin.Metadata;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0011\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lkotlin/annotation/AnnotationTarget;", "", "(Ljava/lang/String;I)V", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "kotlin-stdlib"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* renamed from: com.facebook.ads.redexgen.X.c5  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class EnumC1277c5 {
    public static byte[] A00;
    public static final /* synthetic */ InterfaceC0648Ga A01;
    public static final /* synthetic */ EnumC1277c5[] A02;
    public static final EnumC1277c5 A03;
    public static final EnumC1277c5 A04;
    public static final EnumC1277c5 A05;
    public static final EnumC1277c5 A06;
    public static final EnumC1277c5 A07;
    public static final EnumC1277c5 A08;
    public static final EnumC1277c5 A09;
    public static final EnumC1277c5 A0A;
    public static final EnumC1277c5 A0B;
    public static final EnumC1277c5 A0C;
    public static final EnumC1277c5 A0D;
    public static final EnumC1277c5 A0E;
    public static final EnumC1277c5 A0F;
    public static final EnumC1277c5 A0G;
    public static final EnumC1277c5 A0H;

    public static String A00(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A00, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 7);
        }
        return new String(copyOfRange);
    }

    public static void A01() {
        A00 = new byte[]{-99, -86, -86, -85, -80, -99, -80, -91, -85, -86, -69, -97, -88, -99, -81, -81, -64, -55, -66, -48, -48, -64, -52, -53, -48, -47, -49, -46, -64, -47, -52, -49, 76, 95, 87, 89, 76, 90, 90, 80, 86, 85, 120, 123, 119, 126, 118, -113, -110, -107, -114, -69, -54, -61, -72, -55, -66, -60, -61, 118, 121, 109, 107, 118, -119, Byte.MIN_VALUE, 107, 124, 115, 107, 108, 118, 111, -57, -55, -58, -57, -68, -55, -53, -48, 95, 97, 94, 95, 84, 97, 99, 104, 110, 86, 84, 99, 99, 84, 97, -80, -78, -81, -80, -91, -78, -76, -71, -65, -77, -91, -76, -76, -91, -78, 116, 121, 112, 101, 110, 115, 106, 95, 91, 102, 99, 91, 109, -41, -36, -45, -56, -30, -45, -60, -43, -60, -48, -56, -41, -56, -43, -40, -61, -50, -41, -57, -31, -46, -61, -44, -61, -49, -57, -42, -57, -44};
    }

    public static final /* synthetic */ EnumC1277c5[] A02() {
        return new EnumC1277c5[]{A04, A03, A0G, A0B, A07, A0A, A0H, A05, A09, A0C, A0D, A0E, A06, A08, A0F};
    }

    public static EnumC1277c5 valueOf(String str) {
        return (EnumC1277c5) Enum.valueOf(EnumC1277c5.class, str);
    }

    public static EnumC1277c5[] values() {
        return (EnumC1277c5[]) A02.clone();
    }

    static {
        A01();
        A04 = new EnumC1277c5(A00(16, 5, 118), 0);
        A03 = new EnumC1277c5(A00(0, 16, 85), 1);
        A0G = new EnumC1277c5(A00(124, 14, 124), 2);
        A0B = new EnumC1277c5(A00(73, 8, R.styleable.AppCompatTheme_toolbarNavigationButtonStyle), 3);
        A07 = new EnumC1277c5(A00(42, 5, 43), 4);
        A0A = new EnumC1277c5(A00(59, 14, 35), 5);
        A0H = new EnumC1277c5(A00(138, 15, 123), 6);
        A05 = new EnumC1277c5(A00(21, 11, 118), 7);
        A09 = new EnumC1277c5(A00(51, 8, R.styleable.AppCompatTheme_textColorAlertDialogListItem), 8);
        A0C = new EnumC1277c5(A00(81, 15, 8), 9);
        A0D = new EnumC1277c5(A00(96, 15, 89), 10);
        A0E = new EnumC1277c5(A00(R.styleable.AppCompatTheme_textColorSearchUrl, 4, 25), 11);
        A06 = new EnumC1277c5(A00(32, 10, 0), 12);
        A08 = new EnumC1277c5(A00(47, 4, 66), 13);
        A0F = new EnumC1277c5(A00(R.styleable.AppCompatTheme_tooltipFrameBackground, 9, 19), 14);
        EnumC1277c5[] A022 = A02();
        A02 = A022;
        A01 = AbstractC1273by.A01(A022);
    }

    public EnumC1277c5(String str, int i) {
    }
}
