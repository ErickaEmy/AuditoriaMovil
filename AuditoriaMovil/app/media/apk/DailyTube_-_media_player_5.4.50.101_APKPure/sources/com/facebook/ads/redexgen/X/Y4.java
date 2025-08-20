package com.facebook.ads.redexgen.X;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.facebook.ads.internal.exoplayer2.thirdparty.Format;
import com.facebook.ads.internal.exoplayer2.thirdparty.metadata.Metadata;
import java.util.Iterator;
import java.util.List;
/* loaded from: assets/audience_network.dex */
public final class Y4 implements InterfaceC0701Id, InterfaceC0519Aj, InterfaceC0639Fr, DZ, SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    public static String[] A01 = {"nMHZhEZSp5EcTMzj890UQSIKsf7nOssk", "WLzxKTE2vNTMCpqDs", "SfczCGFglH", "X5aT15p3N3rGxVL5g", "GbnJfxrb9aQYK7s9S1Y8QTSWgx7P8ZxV", "tLWa3XxeFvyx8wOT4", "wILb6N7ReXeeP8cmU", "dyBLf42uqj"};
    public final /* synthetic */ EH A00;

    public Y4(EH eh) {
        this.A00 = eh;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAo(String str, long j2, long j4) {
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0519Aj) it.next()).AAo(str, j2, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAp(BC bc) {
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            InterfaceC0519Aj interfaceC0519Aj = (InterfaceC0519Aj) it.next();
            String[] strArr = A01;
            if (strArr[1].length() != strArr[6].length()) {
                throw new RuntimeException();
            }
            A01[4] = "5uZ3F86UAJ67QZD2oUJwcWpEFJTFqeup";
            interfaceC0519Aj.AAp(bc);
        }
        EH.A04(this.A00, null);
        EH.A06(this.A00, null);
        EH.A00(this.A00, 0);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAq(BC bc) {
        EH.A06(this.A00, bc);
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0519Aj) it.next()).AAq(bc);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAr(Format format) {
        EH.A04(this.A00, format);
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0519Aj) it.next()).AAr(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAs(int i) {
        EH.A00(this.A00, i);
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0519Aj) it.next()).AAs(i);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0519Aj
    public final void AAt(int i, long j2, long j4) {
        Iterator it = EH.A0D(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0519Aj) it.next()).AAt(i, j2, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0639Fr
    public final void ABF(List<C0635Fn> list) {
        EH.A08(this.A00, list);
        Iterator it = EH.A09(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0639Fr) it.next()).ABF(list);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ABN(int i, long j2) {
        Iterator it = EH.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0701Id) it.next()).ABN(i, j2);
        }
    }

    @Override // com.facebook.ads.redexgen.X.DZ
    public final void ACK(Metadata metadata) {
        Iterator it = EH.A0A(this.A00).iterator();
        while (it.hasNext()) {
            ((DZ) it.next()).ACK(metadata);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ACt(Surface surface) {
        if (EH.A01(this.A00) == surface) {
            Iterator it = EH.A0C(this.A00).iterator();
            while (it.hasNext()) {
                it.next();
            }
        }
        Iterator it2 = EH.A0B(this.A00).iterator();
        while (it2.hasNext()) {
            ((InterfaceC0701Id) it2.next()).ACt(surface);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ADU(String str, long j2, long j4) {
        Iterator it = EH.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0701Id) it.next()).ADU(str, j2, j4);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ADV(BC bc) {
        Iterator it = EH.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0701Id) it.next()).ADV(bc);
        }
        EH.A03(this.A00, null);
        String[] strArr = A01;
        if (strArr[1].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        A01[0] = "zG8NefRqMKYqbgzRufdCrC4W5rqrDhRZ";
        EH.A05(this.A00, null);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ADW(BC bc) {
        EH.A05(this.A00, bc);
        Iterator it = EH.A0B(this.A00).iterator();
        while (true) {
            boolean hasNext = it.hasNext();
            if (A01[0].charAt(5) == '7') {
                throw new RuntimeException();
            }
            A01[4] = "B3QwduSxUwudXX0SLqqw26pCzLpqq2sU";
            if (hasNext) {
                ((InterfaceC0701Id) it.next()).ADW(bc);
            } else {
                return;
            }
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ADa(Format format) {
        EH.A03(this.A00, format);
        Iterator it = EH.A0B(this.A00).iterator();
        while (it.hasNext()) {
            ((InterfaceC0701Id) it.next()).ADa(format);
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC0701Id
    public final void ADf(int i, int i5, int i6, float f4) {
        Iterator it = EH.A0C(this.A00).iterator();
        while (it.hasNext()) {
            ((IU) it.next()).ADf(i, i5, i6, f4);
        }
        Iterator it2 = EH.A0B(this.A00).iterator();
        while (true) {
            boolean hasNext = it2.hasNext();
            String[] strArr = A01;
            if (strArr[3].length() != strArr[5].length()) {
                throw new RuntimeException();
            }
            A01[4] = "2vUTxC8fdDWhhRkArIujhTo4qLvFXYNt";
            if (hasNext) {
                ((InterfaceC0701Id) it2.next()).ADf(i, i5, i6, f4);
            } else {
                return;
            }
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i5) {
        EH.A0H(this.A00, new Surface(surfaceTexture), true);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        EH.A0H(this.A00, null, true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i5) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i5, int i6) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        EH.A0H(this.A00, surfaceHolder.getSurface(), false);
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        EH.A0H(this.A00, null, false);
    }
}
