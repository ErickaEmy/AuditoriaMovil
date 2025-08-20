package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.media.MediaDescription;
import android.media.MediaMetadata;
import android.media.Rating;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.net.Uri;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.os.SystemClock;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.support.v4.media.session.n3;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class MediaSessionCompat {

    /* renamed from: gv  reason: collision with root package name */
    public static int f523gv;

    /* renamed from: n3  reason: collision with root package name */
    public final MediaControllerCompat f524n3;
    public final zn y;

    /* renamed from: zn  reason: collision with root package name */
    public final ArrayList<s> f525zn;

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public MediaSession.QueueItem f526fb;

        /* renamed from: v  reason: collision with root package name */
        public final long f527v;
        public final MediaDescriptionCompat y;

        /* loaded from: classes.dex */
        public static class n3 {
            public static MediaDescription n3(MediaSession.QueueItem queueItem) {
                return queueItem.getDescription();
            }

            public static MediaSession.QueueItem y(MediaDescription mediaDescription, long j2) {
                return new MediaSession.QueueItem(mediaDescription, j2);
            }

            public static long zn(MediaSession.QueueItem queueItem) {
                return queueItem.getQueueId();
            }
        }

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<QueueItem> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public QueueItem[] newArray(int i) {
                return new QueueItem[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public QueueItem createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        }

        public QueueItem(MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            this(null, mediaDescriptionCompat, j2);
        }

        public static List<QueueItem> n3(List<?> list) {
            if (list != null) {
                ArrayList arrayList = new ArrayList(list.size());
                Iterator<?> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(y(it.next()));
                }
                return arrayList;
            }
            return null;
        }

        public static QueueItem y(Object obj) {
            if (obj != null) {
                MediaSession.QueueItem queueItem = (MediaSession.QueueItem) obj;
                return new QueueItem(queueItem, MediaDescriptionCompat.y(n3.n3(queueItem)), n3.zn(queueItem));
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public long gv() {
            return this.f527v;
        }

        public String toString() {
            return "MediaSession.QueueItem {Description=" + this.y + ", Id=" + this.f527v + " }";
        }

        public Object v() {
            MediaSession.QueueItem queueItem = this.f526fb;
            if (queueItem == null) {
                MediaSession.QueueItem y2 = n3.y((MediaDescription) this.y.fb(), this.f527v);
                this.f526fb = y2;
                return y2;
            }
            return queueItem;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.y.writeToParcel(parcel, i);
            parcel.writeLong(this.f527v);
        }

        public MediaDescriptionCompat zn() {
            return this.y;
        }

        public QueueItem(MediaSession.QueueItem queueItem, MediaDescriptionCompat mediaDescriptionCompat, long j2) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null");
            }
            if (j2 != -1) {
                this.y = mediaDescriptionCompat;
                this.f527v = j2;
                this.f526fb = queueItem;
                return;
            }
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }

        public QueueItem(Parcel parcel) {
            this.y = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f527v = parcel.readLong();
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new y();
        public ResultReceiver y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<ResultReceiverWrapper> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public ResultReceiverWrapper[] newArray(int i) {
                return new ResultReceiverWrapper[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public ResultReceiverWrapper createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        }

        public ResultReceiverWrapper(Parcel parcel) {
            this.y = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            this.y.writeToParcel(parcel, i);
        }
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new y();

        /* renamed from: fb  reason: collision with root package name */
        public android.support.v4.media.session.n3 f528fb;

        /* renamed from: s  reason: collision with root package name */
        public xb.gv f529s;

        /* renamed from: v  reason: collision with root package name */
        public final Object f530v;
        public final Object y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<Token> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public Token[] newArray(int i) {
                return new Token[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public Token createFromParcel(Parcel parcel) {
                return new Token(parcel.readParcelable(null));
            }
        }

        public Token(Object obj) {
            this(obj, null, null);
        }

        public static Token n3(Object obj, android.support.v4.media.session.n3 n3Var) {
            if (obj != null) {
                if (obj instanceof MediaSession.Token) {
                    return new Token(obj, n3Var);
                }
                throw new IllegalArgumentException("token is not a valid MediaSession.Token object");
            }
            return null;
        }

        public static Token y(Object obj) {
            return n3(obj, null);
        }

        public void a(android.support.v4.media.session.n3 n3Var) {
            synchronized (this.y) {
                this.f528fb = n3Var;
            }
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f530v;
            if (obj2 == null) {
                if (token.f530v == null) {
                    return true;
                }
                return false;
            }
            Object obj3 = token.f530v;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }

        public void fb(xb.gv gvVar) {
            synchronized (this.y) {
                this.f529s = gvVar;
            }
        }

        public xb.gv gv() {
            xb.gv gvVar;
            synchronized (this.y) {
                gvVar = this.f529s;
            }
            return gvVar;
        }

        public int hashCode() {
            Object obj = this.f530v;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public Object v() {
            return this.f530v;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeParcelable((Parcelable) this.f530v, i);
        }

        public android.support.v4.media.session.n3 zn() {
            android.support.v4.media.session.n3 n3Var;
            synchronized (this.y) {
                n3Var = this.f528fb;
            }
            return n3Var;
        }

        public Token(Object obj, android.support.v4.media.session.n3 n3Var) {
            this(obj, n3Var, null);
        }

        public Token(Object obj, android.support.v4.media.session.n3 n3Var, xb.gv gvVar) {
            this.y = new Object();
            this.f530v = obj;
            this.f528fb = n3Var;
            this.f529s = gvVar;
        }
    }

    /* loaded from: classes.dex */
    public static class fb extends a {
        public fb(Context context, String str, xb.gv gvVar, Bundle bundle) {
            super(context, str, gvVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.gv
        public MediaSession w(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class gv implements zn {

        /* renamed from: c5  reason: collision with root package name */
        public MediaMetadataCompat f532c5;

        /* renamed from: f  reason: collision with root package name */
        public boolean f533f;

        /* renamed from: fb  reason: collision with root package name */
        public PlaybackStateCompat f534fb;

        /* renamed from: gv  reason: collision with root package name */
        public Bundle f535gv;

        /* renamed from: i9  reason: collision with root package name */
        public int f536i9;

        /* renamed from: n3  reason: collision with root package name */
        public final Token f537n3;

        /* renamed from: s  reason: collision with root package name */
        public List<QueueItem> f538s;

        /* renamed from: t  reason: collision with root package name */
        public int f539t;

        /* renamed from: tl  reason: collision with root package name */
        public int f540tl;

        /* renamed from: wz  reason: collision with root package name */
        public n3 f542wz;

        /* renamed from: xc  reason: collision with root package name */
        public o4.n3 f543xc;
        public final MediaSession y;

        /* renamed from: zn  reason: collision with root package name */
        public final Object f544zn = new Object();

        /* renamed from: v  reason: collision with root package name */
        public boolean f541v = false;

        /* renamed from: a  reason: collision with root package name */
        public final RemoteCallbackList<android.support.v4.media.session.y> f531a = new RemoteCallbackList<>();

        /* loaded from: classes.dex */
        public class y extends n3.y {
            public y() {
            }

            @Override // android.support.v4.media.session.n3
            public void ad(float f4) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void b(RatingCompat ratingCompat, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void bk(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public int c5() {
                return gv.this.f539t;
            }

            @Override // android.support.v4.media.session.n3
            public void ct(long j2) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public boolean f() {
                return false;
            }

            @Override // android.support.v4.media.session.n3
            public void f3(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void fb(long j2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public boolean g() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public Bundle getExtras() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public MediaMetadataCompat getMetadata() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public String getPackageName() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public String getTag() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void gv(int i) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void i9(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void kp(RatingCompat ratingCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void l(int i, int i5, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void m(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void mg(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public Bundle n() {
                if (gv.this.f535gv == null) {
                    return null;
                }
                return new Bundle(gv.this.f535gv);
            }

            @Override // android.support.v4.media.session.n3
            public PlaybackStateCompat n3() {
                gv gvVar = gv.this;
                return MediaSessionCompat.gv(gvVar.f534fb, gvVar.f532c5);
            }

            @Override // android.support.v4.media.session.n3
            public void next() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void o0() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void o4(boolean z2) throws RemoteException {
            }

            @Override // android.support.v4.media.session.n3
            public int oz() {
                return gv.this.f540tl;
            }

            @Override // android.support.v4.media.session.n3
            public int p() {
                return gv.this.f536i9;
            }

            @Override // android.support.v4.media.session.n3
            public void pause() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void play() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void pq(android.support.v4.media.session.y yVar) {
                gv.this.f531a.unregister(yVar);
                Binder.getCallingPid();
                Binder.getCallingUid();
                synchronized (gv.this.f544zn) {
                    gv.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.n3
            public void prepare() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void previous() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public CharSequence pz() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public boolean q9() {
                return gv.this.f533f;
            }

            @Override // android.support.v4.media.session.n3
            public void rb(int i, int i5, String str) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void rz(String str, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public long s() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void stop() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void ta(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void tl(Uri uri, Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void u(String str, Bundle bundle, ResultReceiverWrapper resultReceiverWrapper) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void u0(MediaDescriptionCompat mediaDescriptionCompat) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void ut(int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void v(int i) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void vp(boolean z2) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public PendingIntent w() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public boolean x(KeyEvent keyEvent) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public ParcelableVolumeInfo x5() {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void y5() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public void yg(android.support.v4.media.session.y yVar) {
                if (gv.this.f541v) {
                    return;
                }
                gv.this.f531a.register(yVar, new o4.n3("android.media.session.MediaController", Binder.getCallingPid(), Binder.getCallingUid()));
                synchronized (gv.this.f544zn) {
                    gv.this.getClass();
                }
            }

            @Override // android.support.v4.media.session.n3
            public void yt(MediaDescriptionCompat mediaDescriptionCompat, int i) {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.n3
            public List<QueueItem> zn() {
                return null;
            }
        }

        public gv(Context context, String str, xb.gv gvVar, Bundle bundle) {
            MediaSession w4 = w(context, str, bundle);
            this.y = w4;
            this.f537n3 = new Token(w4.getSessionToken(), new y(), gvVar);
            this.f535gv = bundle;
            zn(3);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void a(n3 n3Var, Handler handler) {
            MediaSession.Callback callback;
            synchronized (this.f544zn) {
                try {
                    this.f542wz = n3Var;
                    MediaSession mediaSession = this.y;
                    if (n3Var == null) {
                        callback = null;
                    } else {
                        callback = n3Var.f548v;
                    }
                    mediaSession.setCallback(callback, handler);
                    if (n3Var != null) {
                        n3Var.jz(this, handler);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void c5(PlaybackStateCompat playbackStateCompat) {
            PlaybackState playbackState;
            this.f534fb = playbackStateCompat;
            synchronized (this.f544zn) {
                for (int beginBroadcast = this.f531a.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                    try {
                        this.f531a.getBroadcastItem(beginBroadcast).yk(playbackStateCompat);
                    } catch (RemoteException unused) {
                    }
                }
                this.f531a.finishBroadcast();
            }
            MediaSession mediaSession = this.y;
            if (playbackStateCompat == null) {
                playbackState = null;
            } else {
                playbackState = (PlaybackState) playbackStateCompat.fb();
            }
            mediaSession.setPlaybackState(playbackState);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public String f() {
            if (Build.VERSION.SDK_INT < 24) {
                return null;
            }
            try {
                return (String) this.y.getClass().getMethod("getCallingPackage", null).invoke(this.y, null);
            } catch (Exception e2) {
                Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e2);
                return null;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void fb(MediaMetadataCompat mediaMetadataCompat) {
            MediaMetadata mediaMetadata;
            this.f532c5 = mediaMetadataCompat;
            MediaSession mediaSession = this.y;
            if (mediaMetadataCompat == null) {
                mediaMetadata = null;
            } else {
                mediaMetadata = (MediaMetadata) mediaMetadataCompat.v();
            }
            mediaSession.setMetadata(mediaMetadata);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void gv(int i) {
            if (this.f539t != i) {
                this.f539t = i;
                synchronized (this.f544zn) {
                    for (int beginBroadcast = this.f531a.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f531a.getBroadcastItem(beginBroadcast).onRepeatModeChanged(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f531a.finishBroadcast();
                }
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void i9(o4.n3 n3Var) {
            synchronized (this.f544zn) {
                this.f543xc = n3Var;
            }
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public boolean isActive() {
            return this.y.isActive();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public PlaybackStateCompat n3() {
            return this.f534fb;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void release() {
            this.f541v = true;
            this.f531a.kill();
            if (Build.VERSION.SDK_INT == 27) {
                try {
                    Field declaredField = this.y.getClass().getDeclaredField("mCallback");
                    declaredField.setAccessible(true);
                    Handler handler = (Handler) declaredField.get(this.y);
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                } catch (Exception e2) {
                    Log.w("MediaSessionCompat", "Exception happened while accessing MediaSession.mCallback.", e2);
                }
            }
            this.y.setCallback(null);
            this.y.release();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void s(List<QueueItem> list) {
            this.f538s = list;
            if (list == null) {
                this.y.setQueue(null);
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (QueueItem queueItem : list) {
                arrayList.add((MediaSession.QueueItem) queueItem.v());
            }
            this.y.setQueue(arrayList);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public n3 t() {
            n3 n3Var;
            synchronized (this.f544zn) {
                n3Var = this.f542wz;
            }
            return n3Var;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void tl(PendingIntent pendingIntent) {
            this.y.setMediaButtonReceiver(pendingIntent);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void v(int i) {
            if (this.f540tl != i) {
                this.f540tl = i;
                synchronized (this.f544zn) {
                    for (int beginBroadcast = this.f531a.beginBroadcast() - 1; beginBroadcast >= 0; beginBroadcast--) {
                        try {
                            this.f531a.getBroadcastItem(beginBroadcast).f7(i);
                        } catch (RemoteException unused) {
                        }
                    }
                    this.f531a.finishBroadcast();
                }
            }
        }

        public MediaSession w(Context context, String str, Bundle bundle) {
            return new MediaSession(context, str);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public void wz(boolean z2) {
            this.y.setActive(z2);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public o4.n3 xc() {
            o4.n3 n3Var;
            synchronized (this.f544zn) {
                n3Var = this.f543xc;
            }
            return n3Var;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        public Token y() {
            return this.f537n3;
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.zn
        @SuppressLint({"WrongConstant"})
        public void zn(int i) {
            this.y.setFlags(i | 3);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class n3 {

        /* renamed from: f  reason: collision with root package name */
        public y f545f;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f546fb;
        public final Object y = new Object();

        /* renamed from: v  reason: collision with root package name */
        public final MediaSession.Callback f548v = new C0004n3();

        /* renamed from: s  reason: collision with root package name */
        public WeakReference<zn> f547s = new WeakReference<>(null);

        /* renamed from: android.support.v4.media.session.MediaSessionCompat$n3$n3  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0004n3 extends MediaSession.Callback {
            public C0004n3() {
            }

            public final gv n3() {
                gv gvVar;
                synchronized (n3.this.y) {
                    gvVar = (gv) n3.this.f547s.get();
                }
                if (gvVar == null || n3.this != gvVar.t()) {
                    return null;
                }
                return gvVar;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCommand(String str, Bundle bundle, ResultReceiver resultReceiver) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                try {
                    QueueItem queueItem = null;
                    IBinder asBinder = null;
                    queueItem = null;
                    if (str.equals("android.support.v4.media.session.command.GET_EXTRA_BINDER")) {
                        Bundle bundle2 = new Bundle();
                        Token y = n32.y();
                        android.support.v4.media.session.n3 zn2 = y.zn();
                        if (zn2 != null) {
                            asBinder = zn2.asBinder();
                        }
                        rz.a.n3(bundle2, "android.support.v4.media.session.EXTRA_BINDER", asBinder);
                        xb.y.zn(bundle2, "android.support.v4.media.session.SESSION_TOKEN2", y.gv());
                        resultReceiver.send(0, bundle2);
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM")) {
                        n3.this.zn((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.ADD_QUEUE_ITEM_AT")) {
                        n3.this.fb((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"), bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM")) {
                        n3.this.b((MediaDescriptionCompat) bundle.getParcelable("android.support.v4.media.session.command.ARGUMENT_MEDIA_DESCRIPTION"));
                    } else if (str.equals("android.support.v4.media.session.command.REMOVE_QUEUE_ITEM_AT")) {
                        if (n32.f538s != null) {
                            int i = bundle.getInt("android.support.v4.media.session.command.ARGUMENT_INDEX", -1);
                            if (i >= 0 && i < n32.f538s.size()) {
                                queueItem = n32.f538s.get(i);
                            }
                            if (queueItem != null) {
                                n3.this.b(queueItem.zn());
                            }
                        }
                    } else {
                        n3.this.w(str, bundle, resultReceiver);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the extra data.");
                }
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onCustomAction(String str, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                try {
                    if (str.equals("android.support.v4.media.session.action.PLAY_FROM_URI")) {
                        Bundle bundle2 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.y(bundle2);
                        n3.this.d((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle2);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE")) {
                        n3.this.z6();
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_MEDIA_ID")) {
                        String string = bundle.getString("android.support.v4.media.session.action.ARGUMENT_MEDIA_ID");
                        Bundle bundle3 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.y(bundle3);
                        n3.this.ej(string, bundle3);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_SEARCH")) {
                        String string2 = bundle.getString("android.support.v4.media.session.action.ARGUMENT_QUERY");
                        Bundle bundle4 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.y(bundle4);
                        n3.this.ud(string2, bundle4);
                    } else if (str.equals("android.support.v4.media.session.action.PREPARE_FROM_URI")) {
                        Bundle bundle5 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.y(bundle5);
                        n3.this.a8((Uri) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_URI"), bundle5);
                    } else if (str.equals("android.support.v4.media.session.action.SET_CAPTIONING_ENABLED")) {
                        n3.this.hw(bundle.getBoolean("android.support.v4.media.session.action.ARGUMENT_CAPTIONING_ENABLED"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_REPEAT_MODE")) {
                        n3.this.oz(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_REPEAT_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_SHUFFLE_MODE")) {
                        n3.this.ut(bundle.getInt("android.support.v4.media.session.action.ARGUMENT_SHUFFLE_MODE"));
                    } else if (str.equals("android.support.v4.media.session.action.SET_RATING")) {
                        Bundle bundle6 = bundle.getBundle("android.support.v4.media.session.action.ARGUMENT_EXTRAS");
                        MediaSessionCompat.y(bundle6);
                        n3.this.j((RatingCompat) bundle.getParcelable("android.support.v4.media.session.action.ARGUMENT_RATING"), bundle6);
                    } else if (str.equals("android.support.v4.media.session.action.SET_PLAYBACK_SPEED")) {
                        n3.this.j5(bundle.getFloat("android.support.v4.media.session.action.ARGUMENT_PLAYBACK_SPEED", 1.0f));
                    } else {
                        n3.this.p(str, bundle);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaSessionCompat", "Could not unparcel the data.");
                }
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onFastForward() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.mt();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public boolean onMediaButtonEvent(Intent intent) {
                gv n32 = n3();
                if (n32 == null) {
                    return false;
                }
                zn(n32);
                boolean n2 = n3.this.n(intent);
                y(n32);
                if (!n2 && !super.onMediaButtonEvent(intent)) {
                    return false;
                }
                return true;
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPause() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.c();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlay() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.fh();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromMediaId(String str, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.mg(str, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromSearch(String str, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.ta(str, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPlayFromUri(Uri uri, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.d(uri, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepare() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.z6();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromMediaId(String str, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.ej(str, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromSearch(String str, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.ud(str, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onPrepareFromUri(Uri uri, Bundle bundle) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                MediaSessionCompat.y(bundle);
                zn(n32);
                n3.this.a8(uri, bundle);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onRewind() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.k5();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSeekTo(long j2) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.vl(j2);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetPlaybackSpeed(float f4) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.j5(f4);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSetRating(Rating rating) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.o(RatingCompat.y(rating));
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToNext() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.q9();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToPrevious() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.k();
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onSkipToQueueItem(long j2) {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.f7(j2);
                y(n32);
            }

            @Override // android.media.session.MediaSession.Callback
            public void onStop() {
                gv n32 = n3();
                if (n32 == null) {
                    return;
                }
                zn(n32);
                n3.this.en();
                y(n32);
            }

            public final void y(zn znVar) {
                znVar.i9(null);
            }

            public final void zn(zn znVar) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                String f4 = znVar.f();
                if (TextUtils.isEmpty(f4)) {
                    f4 = "android.media.session.MediaController";
                }
                znVar.i9(new o4.n3(f4, -1, -1));
            }
        }

        /* loaded from: classes.dex */
        public class y extends Handler {
            public y(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                zn znVar;
                n3 n3Var;
                y yVar;
                if (message.what == 1) {
                    synchronized (n3.this.y) {
                        znVar = n3.this.f547s.get();
                        n3Var = n3.this;
                        yVar = n3Var.f545f;
                    }
                    if (znVar != null && n3Var == znVar.t() && yVar != null) {
                        znVar.i9((o4.n3) message.obj);
                        n3.this.y(znVar, yVar);
                        znVar.i9(null);
                    }
                }
            }
        }

        public void a8(Uri uri, Bundle bundle) {
        }

        public void b(MediaDescriptionCompat mediaDescriptionCompat) {
        }

        public void c() {
        }

        public void d(Uri uri, Bundle bundle) {
        }

        public void ej(String str, Bundle bundle) {
        }

        public void en() {
        }

        public void f7(long j2) {
        }

        public void fb(MediaDescriptionCompat mediaDescriptionCompat, int i) {
        }

        public void fh() {
        }

        public void hw(boolean z2) {
        }

        public void j(RatingCompat ratingCompat, Bundle bundle) {
        }

        public void j5(float f4) {
        }

        public void jz(zn znVar, Handler handler) {
            synchronized (this.y) {
                try {
                    this.f547s = new WeakReference<>(znVar);
                    y yVar = this.f545f;
                    y yVar2 = null;
                    if (yVar != null) {
                        yVar.removeCallbacksAndMessages(null);
                    }
                    if (znVar != null && handler != null) {
                        yVar2 = new y(handler.getLooper());
                    }
                    this.f545f = yVar2;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void k() {
        }

        public void k5() {
        }

        public void mg(String str, Bundle bundle) {
        }

        public void mt() {
        }

        public boolean n(Intent intent) {
            zn znVar;
            y yVar;
            KeyEvent keyEvent;
            long n32;
            if (Build.VERSION.SDK_INT >= 27) {
                return false;
            }
            synchronized (this.y) {
                znVar = this.f547s.get();
                yVar = this.f545f;
            }
            if (znVar == null || yVar == null || (keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT")) == null || keyEvent.getAction() != 0) {
                return false;
            }
            o4.n3 xc2 = znVar.xc();
            int keyCode = keyEvent.getKeyCode();
            if (keyCode != 79 && keyCode != 85) {
                y(znVar, yVar);
                return false;
            }
            if (keyEvent.getRepeatCount() == 0) {
                if (this.f546fb) {
                    yVar.removeMessages(1);
                    this.f546fb = false;
                    PlaybackStateCompat n33 = znVar.n3();
                    if (n33 == null) {
                        n32 = 0;
                    } else {
                        n32 = n33.n3();
                    }
                    if ((n32 & 32) != 0) {
                        q9();
                    }
                } else {
                    this.f546fb = true;
                    yVar.sendMessageDelayed(yVar.obtainMessage(1, xc2), ViewConfiguration.getDoubleTapTimeout());
                }
            } else {
                y(znVar, yVar);
            }
            return true;
        }

        public void o(RatingCompat ratingCompat) {
        }

        public void oz(int i) {
        }

        public void p(String str, Bundle bundle) {
        }

        public void q9() {
        }

        public void ta(String str, Bundle bundle) {
        }

        public void ud(String str, Bundle bundle) {
        }

        public void ut(int i) {
        }

        public void vl(long j2) {
        }

        public void w(String str, Bundle bundle, ResultReceiver resultReceiver) {
        }

        public void y(zn znVar, Handler handler) {
            long n32;
            boolean z2;
            boolean z3;
            if (!this.f546fb) {
                return;
            }
            boolean z4 = false;
            this.f546fb = false;
            handler.removeMessages(1);
            PlaybackStateCompat n33 = znVar.n3();
            if (n33 == null) {
                n32 = 0;
            } else {
                n32 = n33.n3();
            }
            if (n33 != null && n33.c5() == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((516 & n32) != 0) {
                z3 = true;
            } else {
                z3 = false;
            }
            if ((n32 & 514) != 0) {
                z4 = true;
            }
            if (z2 && z4) {
                c();
            } else if (!z2 && z3) {
                fh();
            }
        }

        public void z6() {
        }

        public void zn(MediaDescriptionCompat mediaDescriptionCompat) {
        }
    }

    /* loaded from: classes.dex */
    public interface s {
        void y();
    }

    /* loaded from: classes.dex */
    public static class v extends gv {
        public v(Context context, String str, xb.gv gvVar, Bundle bundle) {
            super(context, str, gvVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    public class y extends n3 {
        public y() {
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void a(n3 n3Var, Handler handler);

        void c5(PlaybackStateCompat playbackStateCompat);

        String f();

        void fb(MediaMetadataCompat mediaMetadataCompat);

        void gv(int i);

        void i9(o4.n3 n3Var);

        boolean isActive();

        PlaybackStateCompat n3();

        void release();

        void s(List<QueueItem> list);

        n3 t();

        void tl(PendingIntent pendingIntent);

        void v(int i);

        void wz(boolean z2);

        o4.n3 xc();

        Token y();

        void zn(int i);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent) {
        this(context, str, componentName, pendingIntent, null);
    }

    public static PlaybackStateCompat gv(PlaybackStateCompat playbackStateCompat, MediaMetadataCompat mediaMetadataCompat) {
        long gv2;
        long j2;
        if (playbackStateCompat != null) {
            long j4 = -1;
            if (playbackStateCompat.s() != -1) {
                if (playbackStateCompat.c5() == 3 || playbackStateCompat.c5() == 4 || playbackStateCompat.c5() == 5) {
                    if (playbackStateCompat.gv() > 0) {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        long v2 = (playbackStateCompat.v() * ((float) (elapsedRealtime - gv2))) + playbackStateCompat.s();
                        if (mediaMetadataCompat != null && mediaMetadataCompat.y("android.media.metadata.DURATION")) {
                            j4 = mediaMetadataCompat.gv("android.media.metadata.DURATION");
                        }
                        if (j4 >= 0 && v2 > j4) {
                            j2 = j4;
                        } else if (v2 < 0) {
                            j2 = 0;
                        } else {
                            j2 = v2;
                        }
                        return new PlaybackStateCompat.gv(playbackStateCompat).c5(playbackStateCompat.c5(), j2, playbackStateCompat.v(), elapsedRealtime).n3();
                    }
                    return playbackStateCompat;
                }
                return playbackStateCompat;
            }
            return playbackStateCompat;
        }
        return playbackStateCompat;
    }

    @Nullable
    public static Bundle w(@Nullable Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        y(bundle);
        try {
            bundle.isEmpty();
            return bundle;
        } catch (BadParcelableException unused) {
            Log.e("MediaSessionCompat", "Could not unparcel the data.");
            return null;
        }
    }

    public static void y(@Nullable Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public void a() {
        this.y.release();
    }

    public void c5(int i) {
        this.y.zn(i);
    }

    public void f(MediaMetadataCompat mediaMetadataCompat) {
        this.y.fb(mediaMetadataCompat);
    }

    public void fb(boolean z2) {
        this.y.wz(z2);
        Iterator<s> it = this.f525zn.iterator();
        while (it.hasNext()) {
            it.next().y();
        }
    }

    public void i9(PendingIntent pendingIntent) {
        this.y.tl(pendingIntent);
    }

    public MediaControllerCompat n3() {
        return this.f524n3;
    }

    public void s(n3 n3Var, Handler handler) {
        if (n3Var == null) {
            this.y.a(null, null);
            return;
        }
        zn znVar = this.y;
        if (handler == null) {
            handler = new Handler();
        }
        znVar.a(n3Var, handler);
    }

    public void t(PlaybackStateCompat playbackStateCompat) {
        this.y.c5(playbackStateCompat);
    }

    public void tl(List<QueueItem> list) {
        if (list != null) {
            HashSet hashSet = new HashSet();
            for (QueueItem queueItem : list) {
                if (queueItem != null) {
                    if (hashSet.contains(Long.valueOf(queueItem.gv()))) {
                        Log.e("MediaSessionCompat", "Found duplicate queue id: " + queueItem.gv(), new IllegalArgumentException("id of each queue item should be unique"));
                    }
                    hashSet.add(Long.valueOf(queueItem.gv()));
                } else {
                    throw new IllegalArgumentException("queue shouldn't have null items");
                }
            }
        }
        this.y.s(list);
    }

    public boolean v() {
        return this.y.isActive();
    }

    public void wz(int i) {
        this.y.gv(i);
    }

    public void xc(int i) {
        this.y.v(i);
    }

    public Token zn() {
        return this.y.y();
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle) {
        this(context, str, componentName, pendingIntent, bundle, null);
    }

    public MediaSessionCompat(@NonNull Context context, @NonNull String str, @Nullable ComponentName componentName, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable xb.gv gvVar) {
        this.f525zn = new ArrayList<>();
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                if (componentName == null && (componentName = eb.y.y(context)) == null) {
                    Log.w("MediaSessionCompat", "Couldn't find a unique registered media button receiver in the given context.");
                }
                if (componentName != null && pendingIntent == null) {
                    Intent intent = new Intent("android.intent.action.MEDIA_BUTTON");
                    intent.setComponent(componentName);
                    pendingIntent = PendingIntent.getBroadcast(context, 0, intent, Build.VERSION.SDK_INT >= 31 ? 33554432 : 0);
                }
                int i = Build.VERSION.SDK_INT;
                if (i >= 29) {
                    this.y = new fb(context, str, gvVar, bundle);
                } else if (i >= 28) {
                    this.y = new a(context, str, gvVar, bundle);
                } else if (i >= 22) {
                    this.y = new v(context, str, gvVar, bundle);
                } else {
                    this.y = new gv(context, str, gvVar, bundle);
                }
                s(new y(), new Handler(Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper()));
                this.y.tl(pendingIntent);
                this.f524n3 = new MediaControllerCompat(context, this);
                if (f523gv == 0) {
                    f523gv = (int) (TypedValue.applyDimension(1, 320.0f, context.getResources().getDisplayMetrics()) + 0.5f);
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("tag must not be null or empty");
        }
        throw new IllegalArgumentException("context must not be null");
    }

    /* loaded from: classes.dex */
    public static class a extends v {
        public a(Context context, String str, xb.gv gvVar, Bundle bundle) {
            super(context, str, gvVar, bundle);
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.gv, android.support.v4.media.session.MediaSessionCompat.zn
        @NonNull
        public final o4.n3 xc() {
            return new o4.n3(this.y.getCurrentControllerInfo());
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.gv, android.support.v4.media.session.MediaSessionCompat.zn
        public void i9(o4.n3 n3Var) {
        }
    }
}
