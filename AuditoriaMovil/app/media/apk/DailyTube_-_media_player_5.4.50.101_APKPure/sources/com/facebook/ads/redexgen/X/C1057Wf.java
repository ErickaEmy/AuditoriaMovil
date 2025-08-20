package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.emsg.EventMessage;
import java.nio.ByteBuffer;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.Wf  reason: case insensitive filesystem */
/* loaded from: assets/audience_network.dex */
public final class C1057Wf implements DW {
    /* JADX WARN: Failed to parse debug info
    java.lang.ArrayIndexOutOfBoundsException
     */
    @Override // com.facebook.ads.redexgen.X.DW
    public final Metadata A51(E3 e3) {
        ByteBuffer byteBuffer = e3.A01;
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        C0697Hz c0697Hz = new C0697Hz(array, limit);
        String A0Q = c0697Hz.A0Q();
        String A0Q2 = c0697Hz.A0Q();
        long A0M = c0697Hz.A0M();
        return new Metadata(new EventMessage(A0Q, A0Q2, IF.A0F(c0697Hz.A0M(), 1000L, A0M), c0697Hz.A0M(), Arrays.copyOfRange(array, c0697Hz.A06(), limit), IF.A0F(c0697Hz.A0M(), 1000000L, A0M)));
    }
}
