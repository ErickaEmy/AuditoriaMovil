package n3;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
/* loaded from: classes.dex */
public interface zn extends IInterface {

    /* renamed from: ta  reason: collision with root package name */
    public static final String f11805ta = "android$support$customtabs$IEngagementSignalsCallback".replace('$', '.');

    /* loaded from: classes.dex */
    public static class n3 {
        public static <T> T n3(Parcel parcel, Parcelable.Creator<T> creator) {
            if (parcel.readInt() != 0) {
                return creator.createFromParcel(parcel);
            }
            return null;
        }
    }

    void onGreatestScrollPercentageIncreased(int i, Bundle bundle) throws RemoteException;

    void onSessionEnded(boolean z2, Bundle bundle) throws RemoteException;

    void onVerticalScrollEvent(boolean z2, Bundle bundle) throws RemoteException;

    /* loaded from: classes.dex */
    public static abstract class y extends Binder implements zn {
        public y() {
            attachInterface(this, zn.f11805ta);
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            String str = zn.f11805ta;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i != 1598968902) {
                boolean z2 = false;
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return super.onTransact(i, parcel, parcel2, i5);
                        }
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        }
                        onSessionEnded(z2, (Bundle) n3.n3(parcel, Bundle.CREATOR));
                    } else {
                        onGreatestScrollPercentageIncreased(parcel.readInt(), (Bundle) n3.n3(parcel, Bundle.CREATOR));
                    }
                } else {
                    if (parcel.readInt() != 0) {
                        z2 = true;
                    }
                    onVerticalScrollEvent(z2, (Bundle) n3.n3(parcel, Bundle.CREATOR));
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
