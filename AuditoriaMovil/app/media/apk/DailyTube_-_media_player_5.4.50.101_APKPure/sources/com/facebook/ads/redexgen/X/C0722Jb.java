package com.facebook.ads.redexgen.X;

import android.text.TextUtils;
import com.facebook.ads.internal.protocol.AdErrorType;
/* renamed from: com.facebook.ads.redexgen.X.Jb  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C0722Jb {
    public final AdErrorType A00;
    public final String A01;

    public C0722Jb(int i, String str) {
        this(AdErrorType.adErrorTypeFromCode(i), str);
    }

    public C0722Jb(AdErrorType adErrorType, String str) {
        str = TextUtils.isEmpty(str) ? adErrorType.getDefaultErrorMessage() : str;
        this.A00 = adErrorType;
        this.A01 = str;
    }

    public static C0722Jb A00(AdErrorType adErrorType) {
        return new C0722Jb(adErrorType, (String) null);
    }

    public static C0722Jb A01(AdErrorType adErrorType, String str) {
        return new C0722Jb(adErrorType, str);
    }

    public static C0722Jb A02(C0723Jc c0723Jc) {
        return new C0722Jb(c0723Jc.A00(), c0723Jc.A01());
    }

    public final AdErrorType A03() {
        return this.A00;
    }

    public final String A04() {
        return this.A01;
    }
}
