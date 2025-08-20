package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAdBase;
import com.uv.v7.R;
import java.util.Arrays;
/* loaded from: assets/audience_network.dex */
public enum JL {
    A05(0, NativeAdBase.MediaCacheFlag.NONE),
    A04(1, NativeAdBase.MediaCacheFlag.ALL);
    
    public static byte[] A02;
    public final long A00;
    public final NativeAdBase.MediaCacheFlag A01;

    public static String A01(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A02, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] ^ i6) ^ R.styleable.AppCompatTheme_textColorSearchUrl);
        }
        return new String(copyOfRange);
    }

    public static void A02() {
        A02 = new byte[]{70, 75, 75, 34, 35, 34, 41};
    }

    static {
        A02();
    }

    JL(long j2, NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        this.A00 = j2;
        this.A01 = mediaCacheFlag;
    }

    public static JL A00(NativeAdBase.MediaCacheFlag mediaCacheFlag) {
        JL[] values;
        for (JL jl : values()) {
            if (jl.A01 == mediaCacheFlag) {
                return jl;
            }
        }
        return null;
    }
}
