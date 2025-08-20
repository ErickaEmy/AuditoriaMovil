package rs;

import android.support.v4.media.session.MediaSessionCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import rz.c5;
/* loaded from: classes.dex */
public class n3 extends NotificationCompat.xc {

    /* renamed from: a  reason: collision with root package name */
    public MediaSessionCompat.Token f13340a;

    /* renamed from: v  reason: collision with root package name */
    public int[] f13341v;

    public n3 c5(int... iArr) {
        this.f13341v = iArr;
        return this;
    }

    @Override // androidx.core.app.NotificationCompat.xc
    public RemoteViews gv(c5 c5Var) {
        return null;
    }

    @Override // androidx.core.app.NotificationCompat.xc
    public void n3(c5 c5Var) {
        y.gv(c5Var.y(), y.n3(y.y(), this.f13341v, this.f13340a));
    }

    public n3 s(MediaSessionCompat.Token token) {
        this.f13340a = token;
        return this;
    }

    @Override // androidx.core.app.NotificationCompat.xc
    public RemoteViews v(c5 c5Var) {
        return null;
    }
}
