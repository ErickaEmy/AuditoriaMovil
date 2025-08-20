package com.facebook.ads.redexgen.X;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import java.util.Arrays;
/* renamed from: com.facebook.ads.redexgen.X.2C  reason: invalid class name */
/* loaded from: assets/audience_network.dex */
public final class C2C extends Handler {
    public static byte[] A07;
    public static String[] A08 = {"7XGwSkVk3T00tnH9cVPKelrEGcawiCjw", "CQOuonMXQSYezZedNwAjlRkGSLi3aOjj", "mesEj11OvP9", "VZOpRMX1bgsh5uSD6zrhQF9CMqqU", "qOEuTvvHdf1ojQl77Cm2nWjluxHjpHjj", "MJ8oyn1cMPaioU5SW8VDhXvuoMQhG6hY", "cRCjMWliQ8bJ7V8UELoizUhtI", "6BrNpk2twP0gV2txjXjpJVsF16rKzLtO"};
    public Messenger A00;
    public boolean A01;
    public final ServiceConnection A02;
    public final Handler A03;
    public final Messenger A04;
    public final C1115Ym A05;
    public final KT A06;

    public static String A05(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A07, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 17);
        }
        return new String(copyOfRange);
    }

    public static void A06() {
        A07 = new byte[]{-121, -102, -104, -102, -98, -85, -102, -103, 85, -99, -106, -93, -103, -88, -99, -106, -96, -102, 85, -101, -106, -98, -95, -102, -103, 97, 85, -104, -92, -103, -102, 111, 85};
        if (A08[7].length() != 32) {
            throw new RuntimeException();
        }
        A08[2] = "iPGKfbxDLhp";
    }

    static {
        A06();
    }

    public C2C(C1115Ym c1115Ym) {
        super(Looper.getMainLooper());
        this.A03 = new Handler(Looper.getMainLooper());
        this.A02 = new ServiceConnection() { // from class: com.facebook.ads.redexgen.X.2B
            @Override // android.content.ServiceConnection
            public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                Handler handler;
                KT kt;
                Messenger messenger;
                handler = C2C.this.A03;
                kt = C2C.this.A06;
                handler.removeCallbacks(kt);
                C2C.this.A00 = new Messenger(iBinder);
                try {
                    C2C c2c = C2C.this;
                    messenger = c2c.A00;
                    c2c.A07(messenger);
                } catch (RemoteException unused) {
                }
            }

            @Override // android.content.ServiceConnection
            public final void onServiceDisconnected(ComponentName componentName) {
                C2C.this.A09();
            }
        };
        this.A05 = c1115Ym;
        this.A04 = new Messenger(this);
        this.A06 = new C1172aK(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A07(Messenger messenger) throws RemoteException {
        Message obtain = Message.obtain((Handler) null, 1);
        obtain.replyTo = this.A04;
        obtain.setData(C2L.A00(this.A05));
        messenger.send(obtain);
    }

    public final void A09() {
        if (this.A01) {
            this.A01 = false;
            this.A05.unbindService(this.A02);
            this.A00 = null;
        }
    }

    public final void A0A(boolean z2) {
        boolean A04 = C2A.A04(this.A05, z2, this.A02);
        this.A01 = A04;
        if (A04) {
            this.A03.postDelayed(this.A06, AbstractC0707Ik.A01(this.A05));
        } else {
            AbstractC04618b.A04(this.A05);
        }
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (message.what == 2) {
                C2A.A02(this.A05, message);
                return;
            }
            if (message.what != 20 && message.what != 40) {
                int i = message.what;
                String[] strArr = A08;
                if (strArr[3].length() == strArr[6].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A08;
                strArr2[0] = "5lsY8x9xkiXLhEKEYZZQTOwXL0bMYXCm";
                strArr2[4] = "auOM5sEdxjbOnZ2p0JjStgKAzUZMZJar";
                if (i != 30) {
                    return;
                }
            }
            if (message.what == 20) {
                AbstractC0707Ik.A06(this.A05);
            }
            String str = A05(0, 33, 36) + message.what;
            AbstractC04618b.A04(this.A05);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
