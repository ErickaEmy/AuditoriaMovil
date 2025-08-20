package org.fdroid.fdroid.privileged;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
/* loaded from: classes2.dex */
public interface IPrivilegedCallback extends IInterface {
    public static final String DESCRIPTOR = "org.fdroid.fdroid.privileged.IPrivilegedCallback";

    /* loaded from: classes2.dex */
    public static class Default implements IPrivilegedCallback {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.fdroid.fdroid.privileged.IPrivilegedCallback
        public void handleResult(String str, int i) throws RemoteException {
        }
    }

    void handleResult(String str, int i) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IPrivilegedCallback {
        static final int TRANSACTION_handleResult = 1;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPrivilegedCallback.DESCRIPTOR);
        }

        public static IPrivilegedCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IPrivilegedCallback.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPrivilegedCallback)) {
                return (IPrivilegedCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPrivilegedCallback.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPrivilegedCallback.DESCRIPTOR);
                return true;
            } else if (i == 1) {
                handleResult(parcel.readString(), parcel.readInt());
                parcel2.writeNoException();
                return true;
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IPrivilegedCallback {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPrivilegedCallback.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // org.fdroid.fdroid.privileged.IPrivilegedCallback
            public void handleResult(String str, int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPrivilegedCallback.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }
}
