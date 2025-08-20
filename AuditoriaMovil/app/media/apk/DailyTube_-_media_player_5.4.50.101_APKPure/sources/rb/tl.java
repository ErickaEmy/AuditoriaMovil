package rb;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import rb.t;
/* loaded from: classes.dex */
public interface tl extends IInterface {
    int a(t tVar, String str) throws RemoteException;

    void eb(int i, String[] strArr) throws RemoteException;

    void o(t tVar, int i) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class y extends Binder implements tl {

        /* renamed from: rb.tl$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0203y implements tl {
            public IBinder y;

            public C0203y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // rb.tl
            public int a(t tVar, String str) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongInterface(tVar);
                    obtain.writeString(str);
                    this.y.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // rb.tl
            public void eb(int i, String[] strArr) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeInt(i);
                    obtain.writeStringArray(strArr);
                    this.y.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // rb.tl
            public void o(t tVar, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("androidx.room.IMultiInstanceInvalidationService");
                    obtain.writeStrongInterface(tVar);
                    obtain.writeInt(i);
                    this.y.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public y() {
            attachInterface(this, "androidx.room.IMultiInstanceInvalidationService");
        }

        public static tl mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("androidx.room.IMultiInstanceInvalidationService");
            if (queryLocalInterface != null && (queryLocalInterface instanceof tl)) {
                return (tl) queryLocalInterface;
            }
            return new C0203y(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface("androidx.room.IMultiInstanceInvalidationService");
            }
            if (i != 1598968902) {
                if (i != 1) {
                    if (i != 2) {
                        if (i != 3) {
                            return super.onTransact(i, parcel, parcel2, i5);
                        }
                        eb(parcel.readInt(), parcel.createStringArray());
                    } else {
                        o(t.y.mt(parcel.readStrongBinder()), parcel.readInt());
                        parcel2.writeNoException();
                    }
                } else {
                    int a2 = a(t.y.mt(parcel.readStrongBinder()), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(a2);
                }
                return true;
            }
            parcel2.writeString("androidx.room.IMultiInstanceInvalidationService");
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
