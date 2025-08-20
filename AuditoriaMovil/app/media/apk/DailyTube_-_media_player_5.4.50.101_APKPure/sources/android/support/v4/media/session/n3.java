package android.support.v4.media.session;

import android.app.PendingIntent;
import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.y;
import android.text.TextUtils;
import android.view.KeyEvent;
import java.util.List;
/* loaded from: classes.dex */
public interface n3 extends IInterface {

    /* loaded from: classes.dex */
    public static abstract class y extends Binder implements n3 {

        /* renamed from: android.support.v4.media.session.n3$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0005y implements n3 {

            /* renamed from: v  reason: collision with root package name */
            public static n3 f579v;
            public IBinder y;

            public C0005y(IBinder iBinder) {
                this.y = iBinder;
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.y;
            }

            @Override // android.support.v4.media.session.n3
            public MediaMetadataCompat getMetadata() throws RemoteException {
                MediaMetadataCompat mediaMetadataCompat;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.y.transact(27, obtain, obtain2, 0) && y.i3() != null) {
                        return y.i3().getMetadata();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        mediaMetadataCompat = MediaMetadataCompat.CREATOR.createFromParcel(obtain2);
                    } else {
                        mediaMetadataCompat = null;
                    }
                    return mediaMetadataCompat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.n3
            public PlaybackStateCompat n3() throws RemoteException {
                PlaybackStateCompat playbackStateCompat;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.y.transact(28, obtain, obtain2, 0) && y.i3() != null) {
                        return y.i3().n3();
                    }
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        playbackStateCompat = PlaybackStateCompat.CREATOR.createFromParcel(obtain2);
                    } else {
                        playbackStateCompat = null;
                    }
                    return playbackStateCompat;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.support.v4.media.session.n3
            public boolean x(KeyEvent keyEvent) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    boolean z2 = true;
                    if (keyEvent != null) {
                        obtain.writeInt(1);
                        keyEvent.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (!this.y.transact(2, obtain, obtain2, 0) && y.i3() != null) {
                        boolean x2 = y.i3().x(keyEvent);
                        obtain2.recycle();
                        obtain.recycle();
                        return x2;
                    }
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z2 = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z2;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.support.v4.media.session.n3
            public void yg(android.support.v4.media.session.y yVar) throws RemoteException {
                IBinder iBinder;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (yVar != null) {
                        iBinder = yVar.asBinder();
                    } else {
                        iBinder = null;
                    }
                    obtain.writeStrongBinder(iBinder);
                    if (!this.y.transact(3, obtain, obtain2, 0) && y.i3() != null) {
                        y.i3().yg(yVar);
                        obtain2.recycle();
                        obtain.recycle();
                        return;
                    }
                    obtain2.readException();
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.support.v4.media.session.n3
            public List<MediaSessionCompat.QueueItem> zn() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.media.session.IMediaSession");
                    if (!this.y.transact(29, obtain, obtain2, 0) && y.i3() != null) {
                        return y.i3().zn();
                    }
                    obtain2.readException();
                    return obtain2.createTypedArrayList(MediaSessionCompat.QueueItem.CREATOR);
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public y() {
            attachInterface(this, "android.support.v4.media.session.IMediaSession");
        }

        public static n3 i3() {
            return C0005y.f579v;
        }

        public static n3 mt(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.media.session.IMediaSession");
            if (queryLocalInterface != null && (queryLocalInterface instanceof n3)) {
                return (n3) queryLocalInterface;
            }
            return new C0005y(iBinder);
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i5) throws RemoteException {
            Bundle bundle;
            Uri uri;
            Uri uri2;
            RatingCompat ratingCompat;
            if (i != 1598968902) {
                boolean z2 = false;
                MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper = null;
                Bundle bundle2 = null;
                MediaDescriptionCompat mediaDescriptionCompat = null;
                MediaDescriptionCompat mediaDescriptionCompat2 = null;
                MediaDescriptionCompat mediaDescriptionCompat3 = null;
                Bundle bundle3 = null;
                Bundle bundle4 = null;
                Bundle bundle5 = null;
                Bundle bundle6 = null;
                RatingCompat ratingCompat2 = null;
                Bundle bundle7 = null;
                Bundle bundle8 = null;
                Bundle bundle9 = null;
                KeyEvent keyEvent = null;
                switch (i) {
                    case 1:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        } else {
                            bundle = null;
                        }
                        if (parcel.readInt() != 0) {
                            resultReceiverWrapper = MediaSessionCompat.ResultReceiverWrapper.CREATOR.createFromParcel(parcel);
                        }
                        u(readString, bundle, resultReceiverWrapper);
                        parcel2.writeNoException();
                        return true;
                    case 2:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            keyEvent = (KeyEvent) KeyEvent.CREATOR.createFromParcel(parcel);
                        }
                        boolean x2 = x(keyEvent);
                        parcel2.writeNoException();
                        parcel2.writeInt(x2 ? 1 : 0);
                        return true;
                    case 3:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        yg(y.AbstractBinderC0006y.mt(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 4:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        pq(y.AbstractBinderC0006y.mt(parcel.readStrongBinder()));
                        parcel2.writeNoException();
                        return true;
                    case 5:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        boolean g2 = g();
                        parcel2.writeNoException();
                        parcel2.writeInt(g2 ? 1 : 0);
                        return true;
                    case 6:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String packageName = getPackageName();
                        parcel2.writeNoException();
                        parcel2.writeString(packageName);
                        return true;
                    case 7:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String tag = getTag();
                        parcel2.writeNoException();
                        parcel2.writeString(tag);
                        return true;
                    case 8:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        PendingIntent w4 = w();
                        parcel2.writeNoException();
                        if (w4 != null) {
                            parcel2.writeInt(1);
                            w4.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 9:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        long s2 = s();
                        parcel2.writeNoException();
                        parcel2.writeLong(s2);
                        return true;
                    case 10:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        ParcelableVolumeInfo x52 = x5();
                        parcel2.writeNoException();
                        if (x52 != null) {
                            parcel2.writeInt(1);
                            x52.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 11:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        l(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 12:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        rb(parcel.readInt(), parcel.readInt(), parcel.readString());
                        parcel2.writeNoException();
                        return true;
                    case 13:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        play();
                        parcel2.writeNoException();
                        return true;
                    case 14:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString2 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle9 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        rz(readString2, bundle9);
                        parcel2.writeNoException();
                        return true;
                    case 15:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString3 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle8 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        mg(readString3, bundle8);
                        parcel2.writeNoException();
                        return true;
                    case 16:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            uri = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle7 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        ta(uri, bundle7);
                        parcel2.writeNoException();
                        return true;
                    case 17:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        ct(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 18:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        pause();
                        parcel2.writeNoException();
                        return true;
                    case 19:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        stop();
                        parcel2.writeNoException();
                        return true;
                    case 20:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        next();
                        parcel2.writeNoException();
                        return true;
                    case 21:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        previous();
                        parcel2.writeNoException();
                        return true;
                    case 22:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        o0();
                        parcel2.writeNoException();
                        return true;
                    case 23:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        y5();
                        parcel2.writeNoException();
                        return true;
                    case 24:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        fb(parcel.readLong());
                        parcel2.writeNoException();
                        return true;
                    case 25:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            ratingCompat2 = RatingCompat.CREATOR.createFromParcel(parcel);
                        }
                        kp(ratingCompat2);
                        parcel2.writeNoException();
                        return true;
                    case 26:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString4 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle6 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        i9(readString4, bundle6);
                        parcel2.writeNoException();
                        return true;
                    case 27:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        MediaMetadataCompat metadata = getMetadata();
                        parcel2.writeNoException();
                        if (metadata != null) {
                            parcel2.writeInt(1);
                            metadata.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 28:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        PlaybackStateCompat n32 = n3();
                        parcel2.writeNoException();
                        if (n32 != null) {
                            parcel2.writeInt(1);
                            n32.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 29:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        List<MediaSessionCompat.QueueItem> zn2 = zn();
                        parcel2.writeNoException();
                        parcel2.writeTypedList(zn2);
                        return true;
                    case 30:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        CharSequence pz2 = pz();
                        parcel2.writeNoException();
                        if (pz2 != null) {
                            parcel2.writeInt(1);
                            TextUtils.writeToParcel(pz2, parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 31:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        Bundle extras = getExtras();
                        parcel2.writeNoException();
                        if (extras != null) {
                            parcel2.writeInt(1);
                            extras.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 32:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        int p2 = p();
                        parcel2.writeNoException();
                        parcel2.writeInt(p2);
                        return true;
                    case 33:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        prepare();
                        parcel2.writeNoException();
                        return true;
                    case 34:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString5 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle5 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        f3(readString5, bundle5);
                        parcel2.writeNoException();
                        return true;
                    case 35:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        String readString6 = parcel.readString();
                        if (parcel.readInt() != 0) {
                            bundle4 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        bk(readString6, bundle4);
                        parcel2.writeNoException();
                        return true;
                    case 36:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            uri2 = (Uri) Uri.CREATOR.createFromParcel(parcel);
                        } else {
                            uri2 = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle3 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        tl(uri2, bundle3);
                        parcel2.writeNoException();
                        return true;
                    case 37:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        int c52 = c5();
                        parcel2.writeNoException();
                        parcel2.writeInt(c52);
                        return true;
                    case 38:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        boolean f4 = f();
                        parcel2.writeNoException();
                        parcel2.writeInt(f4 ? 1 : 0);
                        return true;
                    case 39:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        gv(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 40:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        }
                        o4(z2);
                        parcel2.writeNoException();
                        return true;
                    case 41:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            mediaDescriptionCompat3 = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        }
                        u0(mediaDescriptionCompat3);
                        parcel2.writeNoException();
                        return true;
                    case 42:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            mediaDescriptionCompat2 = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        }
                        yt(mediaDescriptionCompat2, parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 43:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            mediaDescriptionCompat = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        }
                        m(mediaDescriptionCompat);
                        parcel2.writeNoException();
                        return true;
                    case 44:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        ut(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 45:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        boolean q92 = q9();
                        parcel2.writeNoException();
                        parcel2.writeInt(q92 ? 1 : 0);
                        return true;
                    case 46:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            z2 = true;
                        }
                        vp(z2);
                        parcel2.writeNoException();
                        return true;
                    case 47:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        int oz2 = oz();
                        parcel2.writeNoException();
                        parcel2.writeInt(oz2);
                        return true;
                    case 48:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        v(parcel.readInt());
                        parcel2.writeNoException();
                        return true;
                    case 49:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        ad(parcel.readFloat());
                        parcel2.writeNoException();
                        return true;
                    case 50:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        Bundle n2 = n();
                        parcel2.writeNoException();
                        if (n2 != null) {
                            parcel2.writeInt(1);
                            n2.writeToParcel(parcel2, 1);
                        } else {
                            parcel2.writeInt(0);
                        }
                        return true;
                    case 51:
                        parcel.enforceInterface("android.support.v4.media.session.IMediaSession");
                        if (parcel.readInt() != 0) {
                            ratingCompat = RatingCompat.CREATOR.createFromParcel(parcel);
                        } else {
                            ratingCompat = null;
                        }
                        if (parcel.readInt() != 0) {
                            bundle2 = (Bundle) Bundle.CREATOR.createFromParcel(parcel);
                        }
                        b(ratingCompat, bundle2);
                        parcel2.writeNoException();
                        return true;
                    default:
                        return super.onTransact(i, parcel, parcel2, i5);
                }
            }
            parcel2.writeString("android.support.v4.media.session.IMediaSession");
            return true;
        }
    }

    void ad(float f4) throws RemoteException;

    void b(RatingCompat ratingCompat, Bundle bundle) throws RemoteException;

    void bk(String str, Bundle bundle) throws RemoteException;

    int c5() throws RemoteException;

    void ct(long j2) throws RemoteException;

    boolean f() throws RemoteException;

    void f3(String str, Bundle bundle) throws RemoteException;

    void fb(long j2) throws RemoteException;

    boolean g() throws RemoteException;

    Bundle getExtras() throws RemoteException;

    MediaMetadataCompat getMetadata() throws RemoteException;

    String getPackageName() throws RemoteException;

    String getTag() throws RemoteException;

    void gv(int i) throws RemoteException;

    void i9(String str, Bundle bundle) throws RemoteException;

    void kp(RatingCompat ratingCompat) throws RemoteException;

    void l(int i, int i5, String str) throws RemoteException;

    void m(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void mg(String str, Bundle bundle) throws RemoteException;

    Bundle n() throws RemoteException;

    PlaybackStateCompat n3() throws RemoteException;

    void next() throws RemoteException;

    void o0() throws RemoteException;

    void o4(boolean z2) throws RemoteException;

    int oz() throws RemoteException;

    int p() throws RemoteException;

    void pause() throws RemoteException;

    void play() throws RemoteException;

    void pq(android.support.v4.media.session.y yVar) throws RemoteException;

    void prepare() throws RemoteException;

    void previous() throws RemoteException;

    CharSequence pz() throws RemoteException;

    boolean q9() throws RemoteException;

    void rb(int i, int i5, String str) throws RemoteException;

    void rz(String str, Bundle bundle) throws RemoteException;

    long s() throws RemoteException;

    void stop() throws RemoteException;

    void ta(Uri uri, Bundle bundle) throws RemoteException;

    void tl(Uri uri, Bundle bundle) throws RemoteException;

    void u(String str, Bundle bundle, MediaSessionCompat.ResultReceiverWrapper resultReceiverWrapper) throws RemoteException;

    void u0(MediaDescriptionCompat mediaDescriptionCompat) throws RemoteException;

    void ut(int i) throws RemoteException;

    void v(int i) throws RemoteException;

    void vp(boolean z2) throws RemoteException;

    PendingIntent w() throws RemoteException;

    boolean x(KeyEvent keyEvent) throws RemoteException;

    ParcelableVolumeInfo x5() throws RemoteException;

    void y5() throws RemoteException;

    void yg(android.support.v4.media.session.y yVar) throws RemoteException;

    void yt(MediaDescriptionCompat mediaDescriptionCompat, int i) throws RemoteException;

    List<MediaSessionCompat.QueueItem> zn() throws RemoteException;
}
