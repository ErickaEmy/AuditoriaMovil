package android.support.v4.media;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.media.MediaDescription;
import android.media.browse.MediaBrowser;
import android.os.BadParcelableException;
import android.os.Binder;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.n3;
import android.support.v4.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: n3  reason: collision with root package name */
    public static final boolean f472n3 = Log.isLoggable("MediaBrowserCompat", 3);
    public final gv y;

    /* loaded from: classes.dex */
    public static class CustomActionResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void y(int i, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static class ItemReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void y(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.w(bundle);
            }
            if (i == 0 && bundle != null && bundle.containsKey("media_item")) {
                Parcelable parcelable = bundle.getParcelable("media_item");
                if (parcelable != null && !(parcelable instanceof MediaItem)) {
                    throw null;
                }
                MediaItem mediaItem = (MediaItem) parcelable;
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class SearchResultReceiver extends ResultReceiver {
        @Override // android.support.v4.os.ResultReceiver
        public void y(int i, Bundle bundle) {
            if (bundle != null) {
                bundle = MediaSessionCompat.w(bundle);
            }
            if (i == 0 && bundle != null && bundle.containsKey("search_results")) {
                Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
                parcelableArray.getClass();
                ArrayList arrayList = new ArrayList(parcelableArray.length);
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
                throw null;
            }
            throw null;
        }
    }

    /* loaded from: classes.dex */
    public static class a extends v {
        public a(Context context, ComponentName componentName, zn znVar, Bundle bundle) {
            super(context, componentName, znVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {

        /* renamed from: n3  reason: collision with root package name */
        public Bundle f474n3;
        public Messenger y;

        public c5(IBinder iBinder, Bundle bundle) {
            this.y = new Messenger(iBinder);
            this.f474n3 = bundle;
        }

        public final void n3(int i, Bundle bundle, Messenger messenger) throws RemoteException {
            Message obtain = Message.obtain();
            obtain.what = i;
            obtain.arg1 = 1;
            obtain.setData(bundle);
            obtain.replyTo = messenger;
            this.y.send(obtain);
        }

        public void y(Context context, Messenger messenger) throws RemoteException {
            Bundle bundle = new Bundle();
            bundle.putString("data_package_name", context.getPackageName());
            bundle.putInt("data_calling_pid", Process.myPid());
            bundle.putBundle("data_root_hints", this.f474n3);
            n3(6, bundle, messenger);
        }

        public void zn(Messenger messenger) throws RemoteException {
            n3(7, null, messenger);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class f {

        /* renamed from: n3  reason: collision with root package name */
        public final IBinder f475n3 = new Binder();
        public final MediaBrowser.SubscriptionCallback y;

        /* renamed from: zn  reason: collision with root package name */
        public WeakReference<i9> f476zn;

        /* loaded from: classes.dex */
        public class n3 extends y {
            public n3() {
                super();
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, @NonNull List<MediaBrowser.MediaItem> list, @NonNull Bundle bundle) {
                MediaSessionCompat.y(bundle);
                f.this.n3(str, MediaItem.n3(list), bundle);
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str, @NonNull Bundle bundle) {
                MediaSessionCompat.y(bundle);
                f.this.gv(str, bundle);
            }
        }

        /* loaded from: classes.dex */
        public class y extends MediaBrowser.SubscriptionCallback {
            public y() {
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onChildrenLoaded(@NonNull String str, List<MediaBrowser.MediaItem> list) {
                i9 i9Var;
                WeakReference<i9> weakReference = f.this.f476zn;
                if (weakReference == null) {
                    i9Var = null;
                } else {
                    i9Var = weakReference.get();
                }
                if (i9Var == null) {
                    f.this.y(str, MediaItem.n3(list));
                    return;
                }
                List<MediaItem> n32 = MediaItem.n3(list);
                List<f> n33 = i9Var.n3();
                List<Bundle> zn2 = i9Var.zn();
                for (int i = 0; i < n33.size(); i++) {
                    Bundle bundle = zn2.get(i);
                    if (bundle == null) {
                        f.this.y(str, n32);
                    } else {
                        f.this.n3(str, y(n32, bundle), bundle);
                    }
                }
            }

            @Override // android.media.browse.MediaBrowser.SubscriptionCallback
            public void onError(@NonNull String str) {
                f.this.zn(str);
            }

            public List<MediaItem> y(List<MediaItem> list, Bundle bundle) {
                if (list == null) {
                    return null;
                }
                int i = bundle.getInt("android.media.browse.extra.PAGE", -1);
                int i5 = bundle.getInt("android.media.browse.extra.PAGE_SIZE", -1);
                if (i == -1 && i5 == -1) {
                    return list;
                }
                int i6 = i5 * i;
                int i8 = i6 + i5;
                if (i >= 0 && i5 >= 1 && i6 < list.size()) {
                    if (i8 > list.size()) {
                        i8 = list.size();
                    }
                    return list.subList(i6, i8);
                }
                return Collections.emptyList();
            }
        }

        public f() {
            if (Build.VERSION.SDK_INT >= 26) {
                this.y = new n3();
            } else {
                this.y = new y();
            }
        }

        public void gv(@NonNull String str, @NonNull Bundle bundle) {
        }

        public void n3(@NonNull String str, @NonNull List<MediaItem> list, @NonNull Bundle bundle) {
        }

        public void y(@NonNull String str, @NonNull List<MediaItem> list) {
        }

        public void zn(@NonNull String str) {
        }
    }

    /* loaded from: classes.dex */
    public static class fb extends a {
        public fb(Context context, ComponentName componentName, zn znVar, Bundle bundle) {
            super(context, componentName, znVar, bundle);
        }
    }

    /* loaded from: classes.dex */
    public interface gv {
        void disconnect();

        @NonNull
        MediaSessionCompat.Token y();

        void zn();
    }

    /* loaded from: classes.dex */
    public static class i9 {
        public final List<f> y = new ArrayList();

        /* renamed from: n3  reason: collision with root package name */
        public final List<Bundle> f478n3 = new ArrayList();

        public List<f> n3() {
            return this.y;
        }

        public f y(Bundle bundle) {
            for (int i = 0; i < this.f478n3.size(); i++) {
                if (o4.y.y(this.f478n3.get(i), bundle)) {
                    return this.y.get(i);
                }
            }
            return null;
        }

        public List<Bundle> zn() {
            return this.f478n3;
        }
    }

    /* loaded from: classes.dex */
    public static class n3 extends Handler {

        /* renamed from: n3  reason: collision with root package name */
        public WeakReference<Messenger> f479n3;
        public final WeakReference<s> y;

        public n3(s sVar) {
            this.y = new WeakReference<>(sVar);
        }

        @Override // android.os.Handler
        public void handleMessage(@NonNull Message message) {
            WeakReference<Messenger> weakReference = this.f479n3;
            if (weakReference != null && weakReference.get() != null && this.y.get() != null) {
                Bundle data = message.getData();
                MediaSessionCompat.y(data);
                s sVar = this.y.get();
                Messenger messenger = this.f479n3.get();
                try {
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i != 3) {
                                Log.w("MediaBrowserCompat", "Unhandled message: " + message + "\n  Client version: 1\n  Service version: " + message.arg1);
                            } else {
                                Bundle bundle = data.getBundle("data_options");
                                MediaSessionCompat.y(bundle);
                                Bundle bundle2 = data.getBundle("data_notify_children_changed_options");
                                MediaSessionCompat.y(bundle2);
                                sVar.n3(messenger, data.getString("data_media_item_id"), data.getParcelableArrayList("data_media_item_list"), bundle, bundle2);
                            }
                        } else {
                            sVar.s(messenger);
                        }
                    } else {
                        Bundle bundle3 = data.getBundle("data_root_hints");
                        MediaSessionCompat.y(bundle3);
                        sVar.a(messenger, data.getString("data_media_item_id"), (MediaSessionCompat.Token) data.getParcelable("data_media_session_token"), bundle3);
                    }
                } catch (BadParcelableException unused) {
                    Log.e("MediaBrowserCompat", "Could not unparcel the data.");
                    if (message.what == 1) {
                        sVar.s(messenger);
                    }
                }
            }
        }

        public void y(Messenger messenger) {
            this.f479n3 = new WeakReference<>(messenger);
        }
    }

    /* loaded from: classes.dex */
    public interface s {
        void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle);

        void n3(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2);

        void s(Messenger messenger);
    }

    /* loaded from: classes.dex */
    public static class v implements gv, s, zn.n3 {

        /* renamed from: a  reason: collision with root package name */
        public int f480a;

        /* renamed from: c5  reason: collision with root package name */
        public MediaSessionCompat.Token f481c5;

        /* renamed from: fb  reason: collision with root package name */
        public c5 f482fb;

        /* renamed from: i9  reason: collision with root package name */
        public Bundle f484i9;

        /* renamed from: n3  reason: collision with root package name */
        public final MediaBrowser f485n3;

        /* renamed from: s  reason: collision with root package name */
        public Messenger f486s;
        public final Context y;

        /* renamed from: zn  reason: collision with root package name */
        public final Bundle f488zn;

        /* renamed from: gv  reason: collision with root package name */
        public final n3 f483gv = new n3(this);

        /* renamed from: v  reason: collision with root package name */
        public final z.y<String, i9> f487v = new z.y<>();

        public v(Context context, ComponentName componentName, zn znVar, Bundle bundle) {
            Bundle bundle2;
            this.y = context;
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            this.f488zn = bundle2;
            bundle2.putInt("extra_client_version", 1);
            bundle2.putInt("extra_calling_pid", Process.myPid());
            znVar.gv(this);
            this.f485n3 = new MediaBrowser(context, componentName, znVar.y, bundle2);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.s
        public void a(Messenger messenger, String str, MediaSessionCompat.Token token, Bundle bundle) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.gv
        public void disconnect() {
            Messenger messenger;
            c5 c5Var = this.f482fb;
            if (c5Var != null && (messenger = this.f486s) != null) {
                try {
                    c5Var.zn(messenger);
                } catch (RemoteException unused) {
                }
            }
            this.f485n3.disconnect();
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn.n3
        public void fb() {
            this.f482fb = null;
            this.f486s = null;
            this.f481c5 = null;
            this.f483gv.y(null);
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn.n3
        public void gv() {
            try {
                Bundle extras = this.f485n3.getExtras();
                if (extras == null) {
                    return;
                }
                this.f480a = extras.getInt("extra_service_version", 0);
                IBinder y = rz.a.y(extras, "extra_messenger");
                if (y != null) {
                    this.f482fb = new c5(y, this.f488zn);
                    Messenger messenger = new Messenger(this.f483gv);
                    this.f486s = messenger;
                    this.f483gv.y(messenger);
                    try {
                        this.f482fb.y(this.y, this.f486s);
                    } catch (RemoteException unused) {
                    }
                }
                android.support.v4.media.session.n3 mt2 = n3.y.mt(rz.a.y(extras, "extra_session_binder"));
                if (mt2 != null) {
                    this.f481c5 = MediaSessionCompat.Token.n3(this.f485n3.getSessionToken(), mt2);
                }
            } catch (IllegalStateException e2) {
                Log.e("MediaBrowserCompat", "Unexpected IllegalStateException", e2);
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.s
        public void n3(Messenger messenger, String str, List<MediaItem> list, Bundle bundle, Bundle bundle2) {
            if (this.f486s != messenger) {
                return;
            }
            i9 i9Var = this.f487v.get(str);
            if (i9Var == null) {
                boolean z2 = MediaBrowserCompat.f472n3;
                return;
            }
            f y = i9Var.y(bundle);
            if (y != null) {
                if (bundle == null) {
                    if (list == null) {
                        y.zn(str);
                        return;
                    }
                    this.f484i9 = bundle2;
                    y.y(str, list);
                    this.f484i9 = null;
                } else if (list == null) {
                    y.gv(str, bundle);
                } else {
                    this.f484i9 = bundle2;
                    y.n3(str, list, bundle);
                    this.f484i9 = null;
                }
            }
        }

        @Override // android.support.v4.media.MediaBrowserCompat.s
        public void s(Messenger messenger) {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.zn.n3
        public void v() {
        }

        @Override // android.support.v4.media.MediaBrowserCompat.gv
        @NonNull
        public MediaSessionCompat.Token y() {
            if (this.f481c5 == null) {
                this.f481c5 = MediaSessionCompat.Token.y(this.f485n3.getSessionToken());
            }
            return this.f481c5;
        }

        @Override // android.support.v4.media.MediaBrowserCompat.gv
        public void zn() {
            this.f485n3.connect();
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static int n3(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getFlags();
        }

        public static MediaDescription y(MediaBrowser.MediaItem mediaItem) {
            return mediaItem.getDescription();
        }
    }

    /* loaded from: classes.dex */
    public static class zn {

        /* renamed from: n3  reason: collision with root package name */
        public n3 f489n3;
        public final MediaBrowser.ConnectionCallback y = new y();

        /* loaded from: classes.dex */
        public interface n3 {
            void fb();

            void gv();

            void v();
        }

        /* loaded from: classes.dex */
        public class y extends MediaBrowser.ConnectionCallback {
            public y() {
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnected() {
                n3 n3Var = zn.this.f489n3;
                if (n3Var != null) {
                    n3Var.gv();
                }
                zn.this.y();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionFailed() {
                n3 n3Var = zn.this.f489n3;
                if (n3Var != null) {
                    n3Var.v();
                }
                zn.this.n3();
            }

            @Override // android.media.browse.MediaBrowser.ConnectionCallback
            public void onConnectionSuspended() {
                n3 n3Var = zn.this.f489n3;
                if (n3Var != null) {
                    n3Var.fb();
                }
                zn.this.zn();
            }
        }

        public void gv(n3 n3Var) {
            this.f489n3 = n3Var;
        }

        public void n3() {
            throw null;
        }

        public void y() {
            throw null;
        }

        public void zn() {
            throw null;
        }
    }

    public MediaBrowserCompat(Context context, ComponentName componentName, zn znVar, Bundle bundle) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.y = new fb(context, componentName, znVar, bundle);
        } else if (i >= 23) {
            this.y = new a(context, componentName, znVar, bundle);
        } else {
            this.y = new v(context, componentName, znVar, bundle);
        }
    }

    public void n3() {
        this.y.disconnect();
    }

    public void y() {
        this.y.zn();
    }

    @NonNull
    public MediaSessionCompat.Token zn() {
        return this.y.y();
    }

    @SuppressLint({"BanParcelableUsage"})
    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new y();

        /* renamed from: v  reason: collision with root package name */
        public final MediaDescriptionCompat f473v;
        public final int y;

        /* loaded from: classes.dex */
        public class y implements Parcelable.Creator<MediaItem> {
            @Override // android.os.Parcelable.Creator
            /* renamed from: n3 */
            public MediaItem[] newArray(int i) {
                return new MediaItem[i];
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: y */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }
        }

        public MediaItem(@NonNull MediaDescriptionCompat mediaDescriptionCompat, int i) {
            if (mediaDescriptionCompat != null) {
                if (!TextUtils.isEmpty(mediaDescriptionCompat.s())) {
                    this.y = i;
                    this.f473v = mediaDescriptionCompat;
                    return;
                }
                throw new IllegalArgumentException("description must have a non-empty media id");
            }
            throw new IllegalArgumentException("description cannot be null");
        }

        public static List<MediaItem> n3(List<?> list) {
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

        public static MediaItem y(Object obj) {
            if (obj != null) {
                MediaBrowser.MediaItem mediaItem = (MediaBrowser.MediaItem) obj;
                return new MediaItem(MediaDescriptionCompat.y(y.y(mediaItem)), y.n3(mediaItem));
            }
            return null;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @NonNull
        public String toString() {
            return "MediaItem{mFlags=" + this.y + ", mDescription=" + this.f473v + '}';
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.y);
            this.f473v.writeToParcel(parcel, i);
        }

        public MediaItem(Parcel parcel) {
            this.y = parcel.readInt();
            this.f473v = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }
    }
}
