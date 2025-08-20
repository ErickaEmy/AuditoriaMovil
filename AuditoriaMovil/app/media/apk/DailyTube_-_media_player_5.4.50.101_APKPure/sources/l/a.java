package l;

import android.app.Notification;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: n3  reason: collision with root package name */
    public final int f10198n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final Notification f10199zn;

    public a(int i, @NonNull Notification notification, int i5) {
        this.y = i;
        this.f10199zn = notification;
        this.f10198n3 = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || a.class != obj.getClass()) {
            return false;
        }
        a aVar = (a) obj;
        if (this.y != aVar.y || this.f10198n3 != aVar.f10198n3) {
            return false;
        }
        return this.f10199zn.equals(aVar.f10199zn);
    }

    public int hashCode() {
        return (((this.y * 31) + this.f10198n3) * 31) + this.f10199zn.hashCode();
    }

    @NonNull
    public Notification n3() {
        return this.f10199zn;
    }

    public String toString() {
        return "ForegroundInfo{mNotificationId=" + this.y + ", mForegroundServiceType=" + this.f10198n3 + ", mNotification=" + this.f10199zn + '}';
    }

    public int y() {
        return this.f10198n3;
    }

    public int zn() {
        return this.y;
    }
}
