package m1;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import java.util.List;
import z0.x4;
/* loaded from: classes.dex */
public final class fb extends Binder {

    /* renamed from: v  reason: collision with root package name */
    public static final int f10756v;
    public final z0.x4<Bundle> y;

    static {
        int i;
        if (v5.j5.y >= 30) {
            i = IBinder.getSuggestedMaxIpcSizeBytes();
        } else {
            i = 65536;
        }
        f10756v = i;
    }

    public fb(List<Bundle> list) {
        this.y = z0.x4.d(list);
    }

    public static z0.x4<Bundle> y(IBinder iBinder) {
        int readInt;
        x4.y x42 = z0.x4.x4();
        int i = 1;
        int i5 = 0;
        while (i != 0) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInt(i5);
                try {
                    iBinder.transact(1, obtain, obtain2, 0);
                    while (true) {
                        readInt = obtain2.readInt();
                        if (readInt == 1) {
                            x42.y((Bundle) v5.y.v(obtain2.readBundle()));
                            i5++;
                        }
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    i = readInt;
                } catch (RemoteException e2) {
                    throw new RuntimeException(e2);
                }
            } catch (Throwable th) {
                obtain2.recycle();
                obtain.recycle();
                throw th;
            }
        }
        return x42.s();
    }

    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, @Nullable Parcel parcel2, int i5) throws RemoteException {
        if (i != 1) {
            return super.onTransact(i, parcel, parcel2, i5);
        }
        int i6 = 0;
        if (parcel2 == null) {
            return false;
        }
        int size = this.y.size();
        int readInt = parcel.readInt();
        while (readInt < size && parcel2.dataSize() < f10756v) {
            parcel2.writeInt(1);
            parcel2.writeBundle(this.y.get(readInt));
            readInt++;
        }
        if (readInt < size) {
            i6 = 2;
        }
        parcel2.writeInt(i6);
        return true;
    }
}
