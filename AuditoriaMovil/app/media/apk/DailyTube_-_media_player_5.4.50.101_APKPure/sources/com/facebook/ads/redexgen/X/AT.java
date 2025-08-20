package com.facebook.ads.redexgen.X;

import android.media.AudioAttributes;
/* loaded from: assets/audience_network.dex */
public final class AT {
    public static final AT A04 = new AS().A00();
    public AudioAttributes A00;
    public final int A01;
    public final int A02;
    public final int A03;

    public AT(int i, int i5, int i6) {
        this.A01 = i;
        this.A02 = i5;
        this.A03 = i6;
    }

    public final AudioAttributes A00() {
        if (this.A00 == null) {
            this.A00 = new AudioAttributes.Builder().setContentType(this.A01).setFlags(this.A02).setUsage(this.A03).build();
        }
        return this.A00;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AT at = (AT) obj;
        return this.A01 == at.A01 && this.A02 == at.A02 && this.A03 == at.A03;
    }

    public final int hashCode() {
        int result = this.A01;
        int result2 = this.A03;
        return (((((17 * 31) + result) * 31) + this.A02) * 31) + result2;
    }
}
