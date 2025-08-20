package com.facebook.ads.redexgen.X;

import android.os.Parcel;
import java.io.Serializable;
/* loaded from: assets/audience_network.dex */
public abstract class LR {
    public static Serializable A00(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Serializable readSerializable = obtain.readSerializable();
        obtain.recycle();
        return readSerializable;
    }

    public static byte[] A01(Serializable serializable) {
        if (serializable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        obtain.writeSerializable(serializable);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
