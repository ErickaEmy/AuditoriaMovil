package n3;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;
/* loaded from: classes.dex */
public interface n3 extends IInterface {

    /* renamed from: mg  reason: collision with root package name */
    public static final String f11803mg = "android$support$customtabs$ICustomTabsService".replace('$', '.');

    /* renamed from: n3.n3$n3  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0160n3 {
        public static <T extends Parcelable> void gv(Parcel parcel, T t2, int i) {
            if (t2 != null) {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }

        public static <T extends Parcelable> void zn(Parcel parcel, List<T> list, int i) {
            if (list == null) {
                parcel.writeInt(-1);
                return;
            }
            int size = list.size();
            parcel.writeInt(size);
            for (int i5 = 0; i5 < size; i5++) {
                gv(parcel, list.get(i5), i);
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class y extends Binder implements n3 {

        /* renamed from: n3.n3$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0161y implements n3 {
            public IBinder y;

            public C0161y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // n3.n3
            public boolean c(n3.y yVar, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    C0160n3.gv(obtain, bundle, 0);
                    this.y.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean i2(n3.y yVar, Uri uri) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    C0160n3.gv(obtain, uri, 0);
                    this.y.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean i4(n3.y yVar, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    obtain.writeStrongBinder(iBinder);
                    boolean z2 = false;
                    C0160n3.gv(obtain, bundle, 0);
                    this.y.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean lc(n3.y yVar) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    this.y.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean le(n3.y yVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    C0160n3.gv(obtain, uri, 0);
                    C0160n3.gv(obtain, bundle, 0);
                    C0160n3.zn(obtain, list, 0);
                    this.y.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean qj(n3.y yVar, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    C0160n3.gv(obtain, bundle, 0);
                    this.y.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public int t(n3.y yVar, String str, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    obtain.writeString(str);
                    C0160n3.gv(obtain, bundle, 0);
                    this.y.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    return obtain2.readInt();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean wf(long j2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeLong(j2);
                    boolean z2 = false;
                    this.y.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // n3.n3
            public boolean wz(n3.y yVar, Uri uri, Bundle bundle) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(n3.f11803mg);
                    obtain.writeStrongInterface(yVar);
                    boolean z2 = false;
                    C0160n3.gv(obtain, uri, 0);
                    C0160n3.gv(obtain, bundle, 0);
                    this.y.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z2 = true;
                    }
                    return z2;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static n3 mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(n3.f11803mg);
            if (queryLocalInterface != null && (queryLocalInterface instanceof n3)) {
                return (n3) queryLocalInterface;
            }
            return new C0161y(iBinder);
        }
    }

    boolean c(n3.y yVar, Bundle bundle) throws RemoteException;

    boolean i2(n3.y yVar, Uri uri) throws RemoteException;

    boolean i4(n3.y yVar, IBinder iBinder, Bundle bundle) throws RemoteException;

    boolean lc(n3.y yVar) throws RemoteException;

    boolean le(n3.y yVar, Uri uri, Bundle bundle, List<Bundle> list) throws RemoteException;

    boolean qj(n3.y yVar, Bundle bundle) throws RemoteException;

    int t(n3.y yVar, String str, Bundle bundle) throws RemoteException;

    boolean wf(long j2) throws RemoteException;

    boolean wz(n3.y yVar, Uri uri, Bundle bundle) throws RemoteException;
}
