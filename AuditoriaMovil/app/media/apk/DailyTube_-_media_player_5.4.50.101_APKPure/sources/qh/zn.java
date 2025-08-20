package qh;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import z0.x4;
/* loaded from: classes.dex */
public final class zn {
    public x4<n3> y(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        Bundle readBundle = obtain.readBundle(Bundle.class.getClassLoader());
        obtain.recycle();
        return v5.gv.n3(n3.f12845ct, (ArrayList) v5.y.v(readBundle.getParcelableArrayList("c")));
    }
}
