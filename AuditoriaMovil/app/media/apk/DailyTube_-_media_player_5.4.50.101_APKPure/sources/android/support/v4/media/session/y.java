package android.support.v4.media.session;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import java.util.List;
/* loaded from: classes.dex */
public interface y extends IInterface {

    /* renamed from: android.support.v4.media.session.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static abstract class AbstractBinderC0006y extends Binder implements y {

        /* renamed from: android.support.v4.media.session.y$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0007y implements y {

            /* renamed from: v  reason: collision with root package name */
            public static y f580v;
            public IBinder y;

            public C0007y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // android.support.v4.media.session.y
            public void f7(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    if (!this.y.transact(12, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().f7(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.y
            public void k5() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (!this.y.transact(2, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().k5();
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.y
            public void onRepeatModeChanged(int i) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeInt(i);
                    if (!this.y.transact(9, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().onRepeatModeChanged(i);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.y
            public void r(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    obtain.writeTypedList(list);
                    if (!this.y.transact(5, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().r(list);
                    }
                } finally {
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.y
            public void vl(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (mediaMetadataCompat != null) {
                        obtain.writeInt(1);
                        mediaMetadataCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.y.transact(4, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().vl(mediaMetadataCompat);
                        obtain.recycle();
                        return;
                    }
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.support.v4.media.session.y
            public void yk(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaControllerCallback");
                    if (playbackStateCompat != null) {
                        obtain.writeInt(1);
                        playbackStateCompat.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.y.transact(3, obtain, null, 1) && AbstractBinderC0006y.i3() != null) {
                        AbstractBinderC0006y.i3().yk(playbackStateCompat);
                        obtain.recycle();
                        return;
                    }
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public AbstractBinderC0006y() {
            attachInterface(this, "android.support.v4.media.session.IMediaControllerCallback");
        }

        public static y i3() {
            return C0007y.f580v;
        }

        public static y mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaControllerCallback");
            if (queryLocalInterface != null && (queryLocalInterface instanceof y)) {
                return (y) queryLocalInterface;
            }
            return new C0007y(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            if (i != 1598968902) {
                boolean z2 = false;
                Bundle bundle = null;
                ParcelableVolumeInfo parcelableVolumeInfo = null;
                Bundle bundle2 = null;
                CharSequence charSequence = null;
                MediaMetadataCompat mediaMetadataCompat = null;
                PlaybackStateCompat playbackStateCompat = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        onEvent(readString, bundle);
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        k5();
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            playbackStateCompat = PlaybackStateCompat.CREATOR.createFromParcel(parcel);
                        }
                        yk(playbackStateCompat);
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(parcel);
                        }
                        vl(mediaMetadataCompat);
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        r(parcel.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR));
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
                        }
                        qk(charSequence);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        y4(bundle2);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            parcelableVolumeInfo = ParcelableVolumeInfo.CREATOR.createFromParcel(parcel);
                        }
                        e(parcelableVolumeInfo);
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        onRepeatModeChanged(parcel.readInt());
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        }
                        cy(z2);
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        }
                        xb(z2);
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        f7(parcel.readInt());
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaControllerCallback");
                        z();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaControllerCallback");
            return true;
        }
    }

    void cy(boolean z2) throws RemoteException;

    void e(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException;

    void f7(int i) throws RemoteException;

    void k5() throws RemoteException;

    void onEvent(String str, Bundle bundle) throws RemoteException;

    void onRepeatModeChanged(int i) throws RemoteException;

    void qk(CharSequence charSequence) throws RemoteException;

    void r(List<MediaSessionCompat.QueueItem> list) throws RemoteException;

    void vl(MediaMetadataCompat mediaMetadataCompat) throws RemoteException;

    void xb(boolean z2) throws RemoteException;

    void y4(Bundle bundle) throws RemoteException;

    void yk(PlaybackStateCompat playbackStateCompat) throws RemoteException;

    void z() throws RemoteException;
}
