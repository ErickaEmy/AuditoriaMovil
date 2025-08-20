package qh;

import android.os.Bundle;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public final class gv {
    public byte[] y(List<n3> list) {
        ArrayList<Bundle> gv2 = v5.gv.gv(list);
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("c", gv2);
        Parcel obtain = Parcel.obtain();
        obtain.writeBundle(bundle);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }
}
