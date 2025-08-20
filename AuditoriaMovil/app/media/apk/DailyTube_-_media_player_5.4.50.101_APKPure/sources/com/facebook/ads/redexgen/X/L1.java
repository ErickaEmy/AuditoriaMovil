package com.facebook.ads.redexgen.X;

import com.facebook.ads.AdError;
import com.facebook.ads.internal.protocol.AdErrorType;
/* loaded from: assets/audience_network.dex */
public abstract class L1 {
    public static AdError A00(C0722Jb c0722Jb) {
        if (c0722Jb.A03().isPublicError()) {
            return new AdError(c0722Jb.A03().getErrorCode(), c0722Jb.A04());
        }
        return new AdError(AdErrorType.UNKNOWN_ERROR.getErrorCode(), AdErrorType.UNKNOWN_ERROR.getDefaultErrorMessage());
    }
}
