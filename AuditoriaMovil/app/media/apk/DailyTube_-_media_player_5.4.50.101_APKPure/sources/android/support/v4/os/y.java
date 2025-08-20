package android.support.v4.os;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface y extends IInterface {

    /* renamed from: n3  reason: collision with root package name */
    public static final String f584n3 = "android$support$v4$os$IResultReceiver".replace('$', '.');

    /* loaded from: classes.dex */
    public static class n3 {
        public static <T> T n3(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    /* renamed from: android.support.v4.os.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0008y extends Binder implements y {

        /* renamed from: android.support.v4.os.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0009y implements y {
            public IBinder y;

            public C0009y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }
        }

        public AbstractBinderC0008y() {
            attachInterface(this, y.f584n3);
        }

        public static y mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(y.f584n3);
            if (queryLocalInterface != null && (queryLocalInterface instanceof y)) {
                return (y) queryLocalInterface;
            }
            return new C0009y(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            String str = y.f584n3;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            } else if (i != 1) {
                return super.onTransact(i, parcel, parcel2, i5);
            } else {
                ra(parcel.readInt(), (Bundle) n3.n3(parcel, Bundle.CREATOR));
                return true;
            }
        }
    }

    void ra(int i, Bundle bundle) throws RemoteException;
}
