package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.n3;
import android.support.v4.media.session.y;
import android.util.Log;
import android.view.KeyEvent;
import androidx.annotation.NonNull;
import androidx.media.AudioAttributesCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import rz.a;
/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* renamed from: n3  reason: collision with root package name */
    public final MediaSessionCompat.Token f512n3;
    public final n3 y;
    @SuppressLint({"BanConcurrentHashMap"})

    /* renamed from: zn  reason: collision with root package name */
    public final ConcurrentHashMap<y, Boolean> f513zn = new ConcurrentHashMap<>();

    /* loaded from: classes.dex */
    public static class MediaControllerImplApi21 implements n3 {

        /* renamed from: v  reason: collision with root package name */
        public final MediaSessionCompat.Token f516v;
        public final MediaController y;

        /* renamed from: n3  reason: collision with root package name */
        public final Object f515n3 = new Object();

        /* renamed from: zn  reason: collision with root package name */
        public final List<y> f517zn = new ArrayList();

        /* renamed from: gv  reason: collision with root package name */
        public HashMap<y, y> f514gv = new HashMap<>();

        /* loaded from: classes.dex */
        public static class ExtraBinderRequestResultReceiver extends ResultReceiver {
            public WeakReference<MediaControllerImplApi21> y;

            public ExtraBinderRequestResultReceiver(MediaControllerImplApi21 mediaControllerImplApi21) {
                super(null);
                this.y = new WeakReference<>(mediaControllerImplApi21);
            }

            @Override // android.os.ResultReceiver
            public void onReceiveResult(int i, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.y.get();
                if (mediaControllerImplApi21 != null && bundle != null) {
                    synchronized (mediaControllerImplApi21.f515n3) {
                        mediaControllerImplApi21.f516v.a(n3.y.mt(a.y(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                        mediaControllerImplApi21.f516v.fb(xb.y.n3(bundle, "android.support.v4.media.session.SESSION_TOKEN2"));
                        mediaControllerImplApi21.gv();
                    }
                }
            }
        }

        /* loaded from: classes.dex */
        public static class y extends y.n3 {
            public y(y yVar) {
                super(yVar);
            }

            @Override // android.support.v4.media.session.y
            public void e(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.y
            public void k5() throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.y
            public void qk(CharSequence charSequence) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.y
            public void r(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.y
            public void vl(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
                throw new AssertionError();
            }

            @Override // android.support.v4.media.session.y
            public void y4(Bundle bundle) throws RemoteException {
                throw new AssertionError();
            }
        }

        public MediaControllerImplApi21(Context context, MediaSessionCompat.Token token) {
            this.f516v = token;
            this.y = new MediaController(context, (MediaSession.Token) token.v());
            if (token.zn() == null) {
                v();
            }
        }

        public void a(String str, Bundle bundle, ResultReceiver resultReceiver) {
            this.y.sendCommand(str, bundle, resultReceiver);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.n3
        public MediaMetadataCompat getMetadata() {
            MediaMetadata metadata = this.y.getMetadata();
            if (metadata != null) {
                return MediaMetadataCompat.n3(metadata);
            }
            return null;
        }

        public void gv() {
            if (this.f516v.zn() == null) {
                return;
            }
            for (y yVar : this.f517zn) {
                y yVar2 = new y(yVar);
                this.f514gv.put(yVar, yVar2);
                yVar.f522n3 = yVar2;
                try {
                    this.f516v.zn().yg(yVar2);
                    yVar.c5(13, null, null);
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                }
            }
            this.f517zn.clear();
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.n3
        public PlaybackStateCompat n3() {
            if (this.f516v.zn() != null) {
                try {
                    return this.f516v.zn().n3();
                } catch (RemoteException e2) {
                    Log.e("MediaControllerCompat", "Dead object in getPlaybackState.", e2);
                }
            }
            PlaybackState playbackState = this.y.getPlaybackState();
            if (playbackState != null) {
                return PlaybackStateCompat.y(playbackState);
            }
            return null;
        }

        public final void v() {
            a("android.support.v4.media.session.command.GET_EXTRA_BINDER", null, new ExtraBinderRequestResultReceiver(this));
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.n3
        public boolean y(KeyEvent keyEvent) {
            return this.y.dispatchMediaButtonEvent(keyEvent);
        }

        @Override // android.support.v4.media.session.MediaControllerCompat.n3
        public List<MediaSessionCompat.QueueItem> zn() {
            List<MediaSession.QueueItem> queue = this.y.getQueue();
            if (queue != null) {
                return MediaSessionCompat.QueueItem.n3(queue);
            }
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static final class gv {

        /* renamed from: gv  reason: collision with root package name */
        public final int f518gv;

        /* renamed from: n3  reason: collision with root package name */
        public final AudioAttributesCompat f519n3;

        /* renamed from: v  reason: collision with root package name */
        public final int f520v;
        public final int y;

        /* renamed from: zn  reason: collision with root package name */
        public final int f521zn;

        public gv(int i, @NonNull AudioAttributesCompat audioAttributesCompat, int i5, int i6, int i8) {
            this.y = i;
            this.f519n3 = audioAttributesCompat;
            this.f521zn = i5;
            this.f518gv = i6;
            this.f520v = i8;
        }
    }

    /* loaded from: classes.dex */
    public interface n3 {
        MediaMetadataCompat getMetadata();

        PlaybackStateCompat n3();

        boolean y(KeyEvent keyEvent);

        List<MediaSessionCompat.QueueItem> zn();
    }

    /* loaded from: classes.dex */
    public static abstract class y implements IBinder.DeathRecipient {

        /* renamed from: n3  reason: collision with root package name */
        public android.support.v4.media.session.y f522n3;
        public final MediaController.Callback y = new C0003y(this);

        /* loaded from: classes.dex */
        public static class n3 extends y.AbstractBinderC0006y {
            public final WeakReference<y> y;

            public n3(y yVar) {
                this.y = new WeakReference<>(yVar);
            }

            @Override // android.support.v4.media.session.y
            public void cy(boolean z2) throws RemoteException {
            }

            @Override // android.support.v4.media.session.y
            public void f7(int i) throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(12, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.y
            public void onEvent(String str, Bundle bundle) throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(1, str, bundle);
                }
            }

            @Override // android.support.v4.media.session.y
            public void onRepeatModeChanged(int i) throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(9, Integer.valueOf(i), null);
                }
            }

            @Override // android.support.v4.media.session.y
            public void xb(boolean z2) throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(11, Boolean.valueOf(z2), null);
                }
            }

            @Override // android.support.v4.media.session.y
            public void yk(PlaybackStateCompat playbackStateCompat) throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(2, playbackStateCompat, null);
                }
            }

            @Override // android.support.v4.media.session.y
            public void z() throws RemoteException {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.c5(13, null, null);
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$y$y  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public static class C0003y extends MediaController.Callback {
            public final WeakReference<y> y;

            public C0003y(y yVar) {
                this.y = new WeakReference<>(yVar);
            }

            @Override // android.media.session.MediaController.Callback
            public void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.y(new gv(playbackInfo.getPlaybackType(), AudioAttributesCompat.zn(playbackInfo.getAudioAttributes()), playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume()));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onExtrasChanged(Bundle bundle) {
                MediaSessionCompat.y(bundle);
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.n3(bundle);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onMetadataChanged(MediaMetadata mediaMetadata) {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.zn(MediaMetadataCompat.n3(mediaMetadata));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onPlaybackStateChanged(PlaybackState playbackState) {
                y yVar = this.y.get();
                if (yVar != null && yVar.f522n3 == null) {
                    yVar.gv(PlaybackStateCompat.y(playbackState));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueChanged(List<MediaSession.QueueItem> list) {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.v(MediaSessionCompat.QueueItem.n3(list));
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onQueueTitleChanged(CharSequence charSequence) {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.a(charSequence);
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionDestroyed() {
                y yVar = this.y.get();
                if (yVar != null) {
                    yVar.fb();
                }
            }

            @Override // android.media.session.MediaController.Callback
            public void onSessionEvent(String str, Bundle bundle) {
                MediaSessionCompat.y(bundle);
                y yVar = this.y.get();
                if (yVar != null) {
                    if (yVar.f522n3 == null || Build.VERSION.SDK_INT >= 23) {
                        yVar.s(str, bundle);
                    }
                }
            }
        }

        public void a(CharSequence charSequence) {
        }

        @Override // android.os.IBinder.DeathRecipient
        public void binderDied() {
            c5(8, null, null);
        }

        public void c5(int i, Object obj, Bundle bundle) {
        }

        public void fb() {
        }

        public void gv(PlaybackStateCompat playbackStateCompat) {
        }

        public void n3(Bundle bundle) {
        }

        public void s(String str, Bundle bundle) {
        }

        public void v(List<MediaSessionCompat.QueueItem> list) {
        }

        public void y(gv gvVar) {
        }

        public void zn(MediaMetadataCompat mediaMetadataCompat) {
        }
    }

    /* loaded from: classes.dex */
    public static class zn extends MediaControllerImplApi21 {
        public zn(Context context, MediaSessionCompat.Token token) {
            super(context, token);
        }
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat mediaSessionCompat) {
        if (mediaSessionCompat != null) {
            MediaSessionCompat.Token zn2 = mediaSessionCompat.zn();
            this.f512n3 = zn2;
            if (Build.VERSION.SDK_INT >= 29) {
                this.y = new zn(context, zn2);
                return;
            } else {
                this.y = new MediaControllerImplApi21(context, zn2);
                return;
            }
        }
        throw new IllegalArgumentException("session must not be null");
    }

    public List<MediaSessionCompat.QueueItem> gv() {
        return this.y.zn();
    }

    public MediaMetadataCompat n3() {
        return this.y.getMetadata();
    }

    public boolean y(KeyEvent keyEvent) {
        if (keyEvent != null) {
            return this.y.y(keyEvent);
        }
        throw new IllegalArgumentException("KeyEvent may not be null");
    }

    public PlaybackStateCompat zn() {
        return this.y.n3();
    }

    public MediaControllerCompat(Context context, @NonNull MediaSessionCompat.Token token) {
        if (token != null) {
            this.f512n3 = token;
            this.y = new MediaControllerImplApi21(context, token);
            return;
        }
        throw new IllegalArgumentException("sessionToken must not be null");
    }
}
