package org.fdroid.fdroid.privileged;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;
import org.fdroid.fdroid.privileged.IPrivilegedCallback;
/* loaded from: classes2.dex */
public interface IPrivilegedService extends IInterface {
    public static final String DESCRIPTOR = "org.fdroid.fdroid.privileged.IPrivilegedService";

    /* loaded from: classes2.dex */
    public static class Default implements IPrivilegedService {
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // org.fdroid.fdroid.privileged.IPrivilegedService
        public void deletePackage(String str, int i, IPrivilegedCallback iPrivilegedCallback) throws RemoteException {
        }

        @Override // org.fdroid.fdroid.privileged.IPrivilegedService
        public List<PackageInfo> getInstalledPackages(int i) throws RemoteException {
            return null;
        }

        @Override // org.fdroid.fdroid.privileged.IPrivilegedService
        public boolean hasPrivilegedPermissions() throws RemoteException {
            return false;
        }

        @Override // org.fdroid.fdroid.privileged.IPrivilegedService
        public void installPackage(Uri uri, int i, String str, IPrivilegedCallback iPrivilegedCallback) throws RemoteException {
        }
    }

    void deletePackage(String str, int i, IPrivilegedCallback iPrivilegedCallback) throws RemoteException;

    List<PackageInfo> getInstalledPackages(int i) throws RemoteException;

    boolean hasPrivilegedPermissions() throws RemoteException;

    void installPackage(Uri uri, int i, String str, IPrivilegedCallback iPrivilegedCallback) throws RemoteException;

    /* loaded from: classes2.dex */
    public static abstract class Stub extends Binder implements IPrivilegedService {
        static final int TRANSACTION_deletePackage = 3;
        static final int TRANSACTION_getInstalledPackages = 4;
        static final int TRANSACTION_hasPrivilegedPermissions = 1;
        static final int TRANSACTION_installPackage = 2;

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        public Stub() {
            attachInterface(this, IPrivilegedService.DESCRIPTOR);
        }

        public static IPrivilegedService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(IPrivilegedService.DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IPrivilegedService)) {
                return (IPrivilegedService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(IPrivilegedService.DESCRIPTOR);
            }
            if (i == 1598968902) {
                parcel2.writeString(IPrivilegedService.DESCRIPTOR);
                return true;
            }
            if (i == 1) {
                boolean hasPrivilegedPermissions = hasPrivilegedPermissions();
                parcel2.writeNoException();
                parcel2.writeInt(hasPrivilegedPermissions ? 1 : 0);
            } else if (i == 2) {
                installPackage((Uri) _Parcel.readTypedObject(parcel, Uri.CREATOR), parcel.readInt(), parcel.readString(), IPrivilegedCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 3) {
                deletePackage(parcel.readString(), parcel.readInt(), IPrivilegedCallback.Stub.asInterface(parcel.readStrongBinder()));
            } else if (i == 4) {
                List<PackageInfo> installedPackages = getInstalledPackages(parcel.readInt());
                parcel2.writeNoException();
                _Parcel.writeTypedList(parcel2, installedPackages, 1);
            } else {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            return true;
        }

        /* loaded from: classes2.dex */
        private static class Proxy implements IPrivilegedService {
            private IBinder mRemote;

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            public String getInterfaceDescriptor() {
                return IPrivilegedService.DESCRIPTOR;
            }

            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            @Override // org.fdroid.fdroid.privileged.IPrivilegedService
            public boolean hasPrivilegedPermissions() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPrivilegedService.DESCRIPTOR);
                    this.mRemote.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // org.fdroid.fdroid.privileged.IPrivilegedService
            public void installPackage(Uri uri, int i, String str, IPrivilegedCallback iPrivilegedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPrivilegedService.DESCRIPTOR);
                    _Parcel.writeTypedObject(obtain, uri, 0);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeStrongInterface(iPrivilegedCallback);
                    this.mRemote.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // org.fdroid.fdroid.privileged.IPrivilegedService
            public void deletePackage(String str, int i, IPrivilegedCallback iPrivilegedCallback) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPrivilegedService.DESCRIPTOR);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeStrongInterface(iPrivilegedCallback);
                    this.mRemote.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            @Override // org.fdroid.fdroid.privileged.IPrivilegedService
            public List<PackageInfo> getInstalledPackages(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(IPrivilegedService.DESCRIPTOR);
                    obtain.writeInt(i);
                    this.mRemote.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.createTypedArrayList(PackageInfo.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class _Parcel {
        /* JADX INFO: Access modifiers changed from: private */
        public static <T> T readTypedObject(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedObject(Parcel parcel, T t, int i) {
            if (t != null) {
                parcel.writeInt(1);
                t.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static <T extends Parcelable> void writeTypedList(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i2 = 0; i2 < size; i2++) {
                writeTypedObject(parcel, list.get(i2), i);
            }
        }
    }
}
