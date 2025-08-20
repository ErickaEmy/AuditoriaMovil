package o4;

import android.media.session.MediaSessionManager;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class n3 {
    public zn y;

    public n3(@NonNull String str, int i, int i5) {
        if (str != null) {
            if (!TextUtils.isEmpty(str)) {
                if (Build.VERSION.SDK_INT >= 28) {
                    this.y = new gv(str, i, i5);
                    return;
                } else {
                    this.y = new v(str, i, i5);
                    return;
                }
            }
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        throw new NullPointerException("package shouldn't be null");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        return this.y.equals(((n3) obj).y);
    }

    public int hashCode() {
        return this.y.hashCode();
    }

    public n3(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        String y = gv.y(remoteUserInfo);
        if (y != null) {
            if (!TextUtils.isEmpty(y)) {
                this.y = new gv(remoteUserInfo);
                return;
            }
            throw new IllegalArgumentException("packageName should be nonempty");
        }
        throw new NullPointerException("package shouldn't be null");
    }
}
