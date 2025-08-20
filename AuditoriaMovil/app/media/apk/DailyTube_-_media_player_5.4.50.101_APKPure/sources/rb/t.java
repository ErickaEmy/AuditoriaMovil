package rb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface t extends IInterface {
    void co(String[] strArr) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class y extends Binder implements t {

        /* renamed from: rb.t$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0202y implements t {
            public IBinder y;

            public C0202y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // rb.t
            public void co(String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationCallback");
                    obtain.writeStringArray(strArr);
                    this.y.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public y() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationCallback");
        }

        public static t mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof t)) {
                return (t) queryLocalInterface;
            }
            return new C0202y(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationCallback");
            }
            if (i != 1598968902) {
                if (i != 1) {
                    return super.onTransact(i, parcel, parcel2, i5);
                }
                co(parcel.createStringArray());
                return true;
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationCallback");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
