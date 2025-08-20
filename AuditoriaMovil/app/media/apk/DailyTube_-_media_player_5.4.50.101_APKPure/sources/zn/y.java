package zn;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface y extends IInterface {

    /* renamed from: hw  reason: collision with root package name */
    public static final String f15675hw = "android$support$v4$app$INotificationSideChannel".replace('$', '.');

    /* loaded from: classes.dex */
    public static class n3 {
        public static <T extends Parcelable> void n3(Parcel parcel, T t2, int i) {
            if (t2 != null) {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }
    }

    /* renamed from: zn.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0263y extends Binder implements y {

        /* renamed from: zn.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0264y implements y {
            public IBinder y;

            public C0264y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // zn.y
            public void ro(String str, int i, String str2, Notification notification) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(y.f15675hw);
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    n3.n3(obtain, notification, 0);
                    this.y.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static y mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(y.f15675hw);
            if (queryLocalInterface != null && (queryLocalInterface instanceof y)) {
                return (y) queryLocalInterface;
            }
            return new C0264y(iBinder);
        }
    }

    void ro(String str, int i, String str2, Notification notification) throws RemoteException;
}
