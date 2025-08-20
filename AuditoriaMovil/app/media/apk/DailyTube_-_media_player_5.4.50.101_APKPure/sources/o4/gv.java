package o4;

import android.media.session.MediaSessionManager;
/* loaded from: classes.dex */
public final class gv extends v {

    /* renamed from: gv  reason: collision with root package name */
    public final MediaSessionManager.RemoteUserInfo f12142gv;

    public gv(String str, int i, int i5) {
        super(str, i, i5);
        this.f12142gv = new MediaSessionManager.RemoteUserInfo(str, i, i5);
    }

    public static String y(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        return remoteUserInfo.getPackageName();
    }

    public gv(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        super(remoteUserInfo.getPackageName(), remoteUserInfo.getPid(), remoteUserInfo.getUid());
        this.f12142gv = remoteUserInfo;
    }
}
