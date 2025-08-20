package n3;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface y extends IInterface {

    /* renamed from: rz  reason: collision with root package name */
    public static final String f11804rz = "android$support$customtabs$ICustomTabsCallback".replace('$', '.');

    /* loaded from: classes.dex */
    public static class n3 {
        public static <T extends Parcelable> void gv(Parcel parcel, T t2, int i) {
            if (t2 != null) {
                parcel.writeInt(1);
                t2.writeToParcel(parcel, i);
                return;
            }
            parcel.writeInt(0);
        }

        public static <T> T zn(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void cs(Bundle bundle) throws RemoteException;

    void gq(int i, int i5, Bundle bundle) throws RemoteException;

    void ix(int i, Uri uri, boolean z2, Bundle bundle) throws RemoteException;

    void j(String str, Bundle bundle) throws RemoteException;

    void q5(String str, Bundle bundle) throws RemoteException;

    void w2(int i, Bundle bundle) throws RemoteException;

    Bundle x4(String str, Bundle bundle) throws RemoteException;

    /* renamed from: n3.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0162y extends Binder implements y {
        public AbstractBinderC0162y() {
            attachInterface(this, y.f11804rz);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            boolean z2;
            String str = y.f11804rz;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i != 1598968902) {
                switch (i) {
                    case 2:
                        w2(parcel.readInt(), (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        break;
                    case 3:
                        j(parcel.readString(), (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        break;
                    case 4:
                        cs((Bundle) n3.zn(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 5:
                        q5(parcel.readString(), (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        break;
                    case 6:
                        int readInt = parcel.readInt();
                        Uri uri = (Uri) n3.zn(parcel, Uri.CREATOR);
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        ix(readInt, uri, z2, (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        break;
                    case 7:
                        Bundle x42 = x4(parcel.readString(), (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        parcel2.writeNoException();
                        n3.gv(parcel2, x42, 1);
                        break;
                    case 8:
                        gq(parcel.readInt(), parcel.readInt(), (Bundle) n3.zn(parcel, Bundle.CREATOR));
                        break;
                    default:
                        return super.onTransact(i, parcel, parcel2, i5);
                }
                return true;
            }
            parcel2.writeString(str);
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }
    }
}
