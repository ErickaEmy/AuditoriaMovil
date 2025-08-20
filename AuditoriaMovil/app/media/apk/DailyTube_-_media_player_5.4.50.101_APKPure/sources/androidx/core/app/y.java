package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class y implements rz.c5 {

    /* renamed from: c5  reason: collision with root package name */
    public RemoteViews f2310c5;

    /* renamed from: gv  reason: collision with root package name */
    public RemoteViews f2312gv;

    /* renamed from: n3  reason: collision with root package name */
    public final Notification.Builder f2313n3;

    /* renamed from: s  reason: collision with root package name */
    public int f2314s;

    /* renamed from: v  reason: collision with root package name */
    public RemoteViews f2315v;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final NotificationCompat.tl f2316zn;

    /* renamed from: a  reason: collision with root package name */
    public final List<Bundle> f2309a = new ArrayList();

    /* renamed from: fb  reason: collision with root package name */
    public final Bundle f2311fb = new Bundle();

    /* loaded from: classes.dex */
    public static class a {
        public static Notification.Builder n3(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Action.Builder y(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder zn(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {
        public static Notification.Action.Builder n3(Notification.Action.Builder builder, int i) {
            return builder.setSemanticAction(i);
        }

        public static Notification.Builder y(Notification.Builder builder, Person person) {
            return builder.addPerson(person);
        }
    }

    /* loaded from: classes.dex */
    public static class f {
        public static Notification.Builder n3(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }

        public static Notification.Action.Builder y(Notification.Action.Builder builder, boolean z2) {
            return builder.setAuthenticationRequired(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        public static Notification.Builder gv(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder n3(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder v(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }

        public static Notification.Action.Builder y(Notification.Action.Builder builder, boolean z2) {
            return builder.setAllowGeneratedReplies(z2);
        }

        public static Notification.Builder zn(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static String a(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder c5(Notification.Builder builder, boolean z2) {
            return builder.setLocalOnly(z2);
        }

        public static Notification.Builder fb(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Action gv(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder i9(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }

        public static Notification.Action.Builder n3(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Builder s(Notification.Builder builder, boolean z2) {
            return builder.setGroupSummary(z2);
        }

        public static Notification.Action.Builder v(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        public static Notification.Builder y(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder zn(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }
    }

    /* loaded from: classes.dex */
    public static class i9 {
        public static Notification.Builder gv(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }

        public static Notification.Builder n3(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Builder y(Notification.Builder builder, boolean z2) {
            return builder.setAllowSystemGeneratedContextualActions(z2);
        }

        public static Notification.Action.Builder zn(Notification.Action.Builder builder, boolean z2) {
            return builder.setContextual(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {
        public static Notification.Builder y(Notification.Builder builder, boolean z2) {
            return builder.setShowWhen(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class s {
        public static Notification.Builder a(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder fb(Notification.Builder builder, long j2) {
            return builder.setTimeoutAfter(j2);
        }

        public static Notification.Builder gv(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        public static Notification.Builder n3(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        public static Notification.Builder v(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder y(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder zn(Notification.Builder builder, boolean z2) {
            return builder.setColorized(z2);
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static Notification.Builder a(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }

        public static Notification.Builder gv(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder n3(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder v(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder y(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder zn(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }
    }

    /* renamed from: androidx.core.app.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0018y {
        public static Notification.Builder gv(Notification.Builder builder, boolean z2) {
            return builder.setUsesChronometer(z2);
        }

        public static Notification.Builder n3(Notification.Builder builder, int i) {
            return builder.setPriority(i);
        }

        public static Notification y(Notification.Builder builder) {
            return builder.build();
        }

        public static Notification.Builder zn(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSubText(charSequence);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static Notification.Builder y(Notification.Builder builder, Bundle bundle) {
            return builder.setExtras(bundle);
        }
    }

    public y(NotificationCompat.tl tlVar) {
        boolean z2;
        boolean z3;
        boolean z4;
        boolean z5;
        Icon x42;
        List<String> list;
        int i;
        Object obj;
        Bitmap t2;
        this.f2316zn = tlVar;
        Context context = tlVar.y;
        this.y = context;
        int i5 = Build.VERSION.SDK_INT;
        if (i5 >= 26) {
            this.f2313n3 = s.y(context, tlVar.f2265x);
        } else {
            this.f2313n3 = new Notification.Builder(tlVar.y);
        }
        Notification notification = tlVar.f2241j;
        Notification.Builder lights = this.f2313n3.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, tlVar.f2228c5).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS);
        if ((notification.flags & 2) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        Notification.Builder ongoing = lights.setOngoing(z2);
        if ((notification.flags & 8) != 0) {
            z3 = true;
        } else {
            z3 = false;
        }
        Notification.Builder onlyAlertOnce = ongoing.setOnlyAlertOnce(z3);
        if ((notification.flags & 16) != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Notification.Builder deleteIntent = onlyAlertOnce.setAutoCancel(z4).setDefaults(notification.defaults).setContentTitle(tlVar.f2261v).setContentText(tlVar.f2224a).setContentInfo(tlVar.f2233f).setContentIntent(tlVar.f2235fb).setDeleteIntent(notification.deleteIntent);
        PendingIntent pendingIntent = tlVar.f2255s;
        if ((notification.flags & NotificationCompat.FLAG_HIGH_PRIORITY) != 0) {
            z5 = true;
        } else {
            z5 = false;
        }
        deleteIntent.setFullScreenIntent(pendingIntent, z5).setNumber(tlVar.f2256t).setProgress(tlVar.f2269z, tlVar.f2253r, tlVar.f2266x4);
        if (i5 < 23) {
            Notification.Builder builder = this.f2313n3;
            IconCompat iconCompat = tlVar.f2240i9;
            if (iconCompat == null) {
                t2 = null;
            } else {
                t2 = iconCompat.t();
            }
            builder.setLargeIcon(t2);
        } else {
            Notification.Builder builder2 = this.f2313n3;
            IconCompat iconCompat2 = tlVar.f2240i9;
            if (iconCompat2 == null) {
                x42 = null;
            } else {
                x42 = iconCompat2.x4(context);
            }
            a.n3(builder2, x42);
        }
        C0018y.n3(C0018y.gv(C0018y.zn(this.f2313n3, tlVar.f2250p), tlVar.f2267xc), tlVar.f2258tl);
        NotificationCompat.xc xcVar = tlVar.f2263w;
        if (xcVar instanceof NotificationCompat.wz) {
            for (NotificationCompat.n3 n3Var : ((NotificationCompat.wz) xcVar).s()) {
                n3(n3Var);
            }
        } else {
            Iterator<NotificationCompat.n3> it = tlVar.f2247n3.iterator();
            while (it.hasNext()) {
                n3(it.next());
            }
        }
        Bundle bundle = tlVar.f2244mg;
        if (bundle != null) {
            this.f2311fb.putAll(bundle);
        }
        int i6 = Build.VERSION.SDK_INT;
        this.f2312gv = tlVar.f2232ej;
        this.f2315v = tlVar.f2259ud;
        n3.y(this.f2313n3, tlVar.f2264wz);
        gv.c5(this.f2313n3, tlVar.f2227c);
        gv.fb(this.f2313n3, tlVar.f2239i4);
        gv.i9(this.f2313n3, tlVar.f2246n);
        gv.s(this.f2313n3, tlVar.f2234f3);
        this.f2314s = tlVar.f2238hw;
        v.n3(this.f2313n3, tlVar.f2254rz);
        v.zn(this.f2313n3, tlVar.f2257ta);
        v.a(this.f2313n3, tlVar.f2230d);
        v.gv(this.f2313n3, tlVar.f2270z6);
        v.v(this.f2313n3, notification.sound, notification.audioAttributes);
        if (i6 < 28) {
            list = v(fb(tlVar.f2271zn), tlVar.f2251q9);
        } else {
            list = tlVar.f2251q9;
        }
        if (list != null && !list.isEmpty()) {
            for (String str : list) {
                v.y(this.f2313n3, str);
            }
        }
        this.f2310c5 = tlVar.f2225a8;
        if (tlVar.f2237gv.size() > 0) {
            Bundle bundle2 = tlVar.gv().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i8 = 0; i8 < tlVar.f2237gv.size(); i8++) {
                bundle4.putBundle(Integer.toString(i8), androidx.core.app.n3.v(tlVar.f2237gv.get(i8)));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            tlVar.gv().putBundle("android.car.EXTENSIONS", bundle2);
            this.f2311fb.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 23 && (obj = tlVar.f2260ut) != null) {
            a.zn(this.f2313n3, obj);
        }
        if (i10 >= 24) {
            zn.y(this.f2313n3, tlVar.f2244mg);
            fb.v(this.f2313n3, tlVar.f2229co);
            RemoteViews remoteViews = tlVar.f2232ej;
            if (remoteViews != null) {
                fb.zn(this.f2313n3, remoteViews);
            }
            RemoteViews remoteViews2 = tlVar.f2259ud;
            if (remoteViews2 != null) {
                fb.n3(this.f2313n3, remoteViews2);
            }
            RemoteViews remoteViews3 = tlVar.f2225a8;
            if (remoteViews3 != null) {
                fb.gv(this.f2313n3, remoteViews3);
            }
        }
        if (i10 >= 26) {
            s.n3(this.f2313n3, tlVar.f2226b);
            s.v(this.f2313n3, tlVar.f2245mt);
            s.a(this.f2313n3, tlVar.f2243k5);
            s.fb(this.f2313n3, tlVar.f2262vl);
            s.gv(this.f2313n3, tlVar.f2238hw);
            if (tlVar.f2236fh) {
                s.zn(this.f2313n3, tlVar.f2231d0);
            }
            if (!TextUtils.isEmpty(tlVar.f2265x)) {
                this.f2313n3.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i10 >= 28) {
            Iterator<androidx.core.app.zn> it2 = tlVar.f2271zn.iterator();
            while (it2.hasNext()) {
                c5.y(this.f2313n3, it2.next().i9());
            }
        }
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 29) {
            i9.y(this.f2313n3, tlVar.f2252qn);
            i9.n3(this.f2313n3, NotificationCompat.t.f(tlVar.f2248o));
            mg.n3 n3Var2 = tlVar.f2268yt;
            if (n3Var2 != null) {
                i9.gv(this.f2313n3, n3Var2.zn());
            }
        }
        if (i11 >= 31 && (i = tlVar.f2242j5) != 0) {
            f.n3(this.f2313n3, i);
        }
        if (tlVar.f2249oz) {
            if (this.f2316zn.f2234f3) {
                this.f2314s = 2;
            } else {
                this.f2314s = 1;
            }
            this.f2313n3.setVibrate(null);
            this.f2313n3.setSound(null);
            int i12 = notification.defaults & (-4);
            notification.defaults = i12;
            this.f2313n3.setDefaults(i12);
            if (i11 >= 26) {
                if (TextUtils.isEmpty(this.f2316zn.f2239i4)) {
                    gv.fb(this.f2313n3, "silent");
                }
                s.gv(this.f2313n3, this.f2314s);
            }
        }
    }

    @Nullable
    public static List<String> fb(@Nullable List<androidx.core.app.zn> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (androidx.core.app.zn znVar : list) {
            arrayList.add(znVar.c5());
        }
        return arrayList;
    }

    @Nullable
    public static List<String> v(@Nullable List<String> list, @Nullable List<String> list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        z.n3 n3Var = new z.n3(list.size() + list2.size());
        n3Var.addAll(list);
        n3Var.addAll(list2);
        return new ArrayList(n3Var);
    }

    public Context a() {
        return this.y;
    }

    public Notification gv() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return C0018y.y(this.f2313n3);
        }
        if (i >= 24) {
            Notification y = C0018y.y(this.f2313n3);
            if (this.f2314s != 0) {
                if (gv.a(y) != null && (y.flags & 512) != 0 && this.f2314s == 2) {
                    s(y);
                }
                if (gv.a(y) != null && (y.flags & 512) == 0 && this.f2314s == 1) {
                    s(y);
                }
            }
            return y;
        }
        zn.y(this.f2313n3, this.f2311fb);
        Notification y2 = C0018y.y(this.f2313n3);
        RemoteViews remoteViews = this.f2312gv;
        if (remoteViews != null) {
            y2.contentView = remoteViews;
        }
        RemoteViews remoteViews2 = this.f2315v;
        if (remoteViews2 != null) {
            y2.bigContentView = remoteViews2;
        }
        RemoteViews remoteViews3 = this.f2310c5;
        if (remoteViews3 != null) {
            y2.headsUpContentView = remoteViews3;
        }
        if (this.f2314s != 0) {
            if (gv.a(y2) != null && (y2.flags & 512) != 0 && this.f2314s == 2) {
                s(y2);
            }
            if (gv.a(y2) != null && (y2.flags & 512) == 0 && this.f2314s == 1) {
                s(y2);
            }
        }
        return y2;
    }

    public final void n3(NotificationCompat.n3 n3Var) {
        int i;
        Notification.Action.Builder v2;
        Bundle bundle;
        Icon icon;
        int i5 = Build.VERSION.SDK_INT;
        IconCompat gv2 = n3Var.gv();
        if (i5 >= 23) {
            if (gv2 != null) {
                icon = gv2.r();
            } else {
                icon = null;
            }
            v2 = a.y(icon, n3Var.s(), n3Var.y());
        } else {
            if (gv2 != null) {
                i = gv2.tl();
            } else {
                i = 0;
            }
            v2 = gv.v(i, n3Var.s(), n3Var.y());
        }
        if (n3Var.v() != null) {
            for (RemoteInput remoteInput : rz.i9.n3(n3Var.v())) {
                gv.zn(v2, remoteInput);
            }
        }
        if (n3Var.zn() != null) {
            bundle = new Bundle(n3Var.zn());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", n3Var.n3());
        int i6 = Build.VERSION.SDK_INT;
        if (i6 >= 24) {
            fb.y(v2, n3Var.n3());
        }
        bundle.putInt("android.support.action.semanticAction", n3Var.a());
        if (i6 >= 28) {
            c5.n3(v2, n3Var.a());
        }
        if (i6 >= 29) {
            i9.zn(v2, n3Var.i9());
        }
        if (i6 >= 31) {
            f.y(v2, n3Var.c5());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", n3Var.fb());
        gv.n3(v2, bundle);
        gv.y(this.f2313n3, gv.gv(v2));
    }

    public final void s(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }

    @Override // rz.c5
    public Notification.Builder y() {
        return this.f2313n3;
    }

    public Notification zn() {
        RemoteViews remoteViews;
        Bundle extras;
        RemoteViews a2;
        RemoteViews gv2;
        NotificationCompat.xc xcVar = this.f2316zn.f2263w;
        if (xcVar != null) {
            xcVar.n3(this);
        }
        if (xcVar != null) {
            remoteViews = xcVar.v(this);
        } else {
            remoteViews = null;
        }
        Notification gv3 = gv();
        if (remoteViews != null) {
            gv3.contentView = remoteViews;
        } else {
            RemoteViews remoteViews2 = this.f2316zn.f2232ej;
            if (remoteViews2 != null) {
                gv3.contentView = remoteViews2;
            }
        }
        if (xcVar != null && (gv2 = xcVar.gv(this)) != null) {
            gv3.bigContentView = gv2;
        }
        if (xcVar != null && (a2 = this.f2316zn.f2263w.a(this)) != null) {
            gv3.headsUpContentView = a2;
        }
        if (xcVar != null && (extras = NotificationCompat.getExtras(gv3)) != null) {
            xcVar.y(extras);
        }
        return gv3;
    }
}
