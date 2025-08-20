package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Person;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.R$color;
import androidx.core.R$dimen;
import androidx.core.R$drawable;
import androidx.core.R$string;
import androidx.core.app.zn;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes.dex */
public class NotificationCompat {
    @SuppressLint({"ActionValue"})
    @Deprecated
    public static final String EXTRA_PEOPLE = "android.people";
    @Deprecated
    public static final int FLAG_HIGH_PRIORITY = 128;

    /* loaded from: classes.dex */
    public static class a {
        public static long a(Notification notification) {
            return notification.getTimeoutAfter();
        }

        public static CharSequence gv(Notification notification) {
            return notification.getSettingsText();
        }

        public static String n3(Notification notification) {
            return notification.getChannelId();
        }

        public static String v(Notification notification) {
            return notification.getShortcutId();
        }

        public static int y(Notification notification) {
            return notification.getBadgeIconType();
        }

        public static int zn(Notification notification) {
            return notification.getGroupAlertBehavior();
        }
    }

    /* loaded from: classes.dex */
    public static class c5 {
        public static boolean y(Notification.Action action) {
            return action.isAuthenticationRequired();
        }
    }

    /* loaded from: classes.dex */
    public static class f extends xc {

        /* renamed from: v  reason: collision with root package name */
        public CharSequence f2186v;

        /* loaded from: classes.dex */
        public static class y {
            public static Notification.BigTextStyle gv(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setSummaryText(charSequence);
            }

            public static Notification.BigTextStyle n3(Notification.Builder builder) {
                return new Notification.BigTextStyle(builder);
            }

            public static Notification.BigTextStyle y(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.bigText(charSequence);
            }

            public static Notification.BigTextStyle zn(Notification.BigTextStyle bigTextStyle, CharSequence charSequence) {
                return bigTextStyle.setBigContentTitle(charSequence);
            }
        }

        @Override // androidx.core.app.NotificationCompat.xc
        public void n3(rz.c5 c5Var) {
            Notification.BigTextStyle y2 = y.y(y.zn(y.n3(c5Var.y()), this.f2283n3), this.f2186v);
            if (this.f2282gv) {
                y.gv(y2, this.f2284zn);
            }
        }

        @NonNull
        public f s(@Nullable CharSequence charSequence) {
            this.f2186v = tl.v(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.xc
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
        }

        @Override // androidx.core.app.NotificationCompat.xc
        @NonNull
        public String zn() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }
    }

    /* loaded from: classes.dex */
    public static class fb {
        public static int y(Notification.Action action) {
            return action.getSemanticAction();
        }
    }

    /* loaded from: classes.dex */
    public static class gv {
        public static Icon y(Notification.Action action) {
            return action.getIcon();
        }
    }

    /* loaded from: classes.dex */
    public static class i9 extends xc {

        /* renamed from: a  reason: collision with root package name */
        public IconCompat f2187a;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f2188c5;

        /* renamed from: fb  reason: collision with root package name */
        public boolean f2189fb;

        /* renamed from: s  reason: collision with root package name */
        public CharSequence f2190s;

        /* renamed from: v  reason: collision with root package name */
        public IconCompat f2191v;

        /* loaded from: classes.dex */
        public static class n3 {
            public static void y(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        /* loaded from: classes.dex */
        public static class y {
            public static void gv(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            public static Notification.BigPictureStyle n3(Notification.Builder builder) {
                return new Notification.BigPictureStyle(builder);
            }

            public static void v(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }

            public static Notification.BigPictureStyle y(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                return bigPictureStyle.bigPicture(bitmap);
            }

            public static Notification.BigPictureStyle zn(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                return bigPictureStyle.setBigContentTitle(charSequence);
            }
        }

        /* loaded from: classes.dex */
        public static class zn {
            public static void n3(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setContentDescription(charSequence);
            }

            public static void y(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigPicture(icon);
            }

            public static void zn(Notification.BigPictureStyle bigPictureStyle, boolean z2) {
                bigPictureStyle.showBigPictureWhenCollapsed(z2);
            }
        }

        @NonNull
        public i9 c5(@Nullable Bitmap bitmap) {
            IconCompat fb2;
            if (bitmap == null) {
                fb2 = null;
            } else {
                fb2 = IconCompat.fb(bitmap);
            }
            this.f2191v = fb2;
            return this;
        }

        @NonNull
        public i9 i9(@Nullable CharSequence charSequence) {
            this.f2283n3 = tl.v(charSequence);
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.xc
        public void n3(rz.c5 c5Var) {
            Context context;
            int i = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle zn2 = y.zn(y.n3(c5Var.y()), this.f2283n3);
            IconCompat iconCompat = this.f2191v;
            Context context2 = null;
            if (iconCompat != null) {
                if (i >= 31) {
                    if (c5Var instanceof androidx.core.app.y) {
                        context = ((androidx.core.app.y) c5Var).a();
                    } else {
                        context = null;
                    }
                    zn.y(zn2, this.f2191v.x4(context));
                } else if (iconCompat.xc() == 1) {
                    zn2 = y.y(zn2, this.f2191v.t());
                }
            }
            if (this.f2189fb) {
                IconCompat iconCompat2 = this.f2187a;
                if (iconCompat2 == null) {
                    y.gv(zn2, null);
                } else if (i >= 23) {
                    if (c5Var instanceof androidx.core.app.y) {
                        context2 = ((androidx.core.app.y) c5Var).a();
                    }
                    n3.y(zn2, this.f2187a.x4(context2));
                } else if (iconCompat2.xc() == 1) {
                    y.gv(zn2, this.f2187a.t());
                } else {
                    y.gv(zn2, null);
                }
            }
            if (this.f2282gv) {
                y.v(zn2, this.f2284zn);
            }
            if (i >= 31) {
                zn.zn(zn2, this.f2188c5);
                zn.n3(zn2, this.f2190s);
            }
        }

        @NonNull
        public i9 s(@Nullable Bitmap bitmap) {
            IconCompat fb2;
            if (bitmap == null) {
                fb2 = null;
            } else {
                fb2 = IconCompat.fb(bitmap);
            }
            this.f2187a = fb2;
            this.f2189fb = true;
            return this;
        }

        @Override // androidx.core.app.NotificationCompat.xc
        @NonNull
        public String zn() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }
    }

    /* loaded from: classes.dex */
    public static class n3 {

        /* renamed from: a  reason: collision with root package name */
        public boolean f2192a;
        @Deprecated

        /* renamed from: c5  reason: collision with root package name */
        public int f2193c5;
        @Nullable

        /* renamed from: f  reason: collision with root package name */
        public PendingIntent f2194f;

        /* renamed from: fb  reason: collision with root package name */
        public final int f2195fb;

        /* renamed from: gv  reason: collision with root package name */
        public final rz.i9[] f2196gv;

        /* renamed from: i9  reason: collision with root package name */
        public CharSequence f2197i9;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public IconCompat f2198n3;

        /* renamed from: s  reason: collision with root package name */
        public final boolean f2199s;

        /* renamed from: t  reason: collision with root package name */
        public boolean f2200t;

        /* renamed from: v  reason: collision with root package name */
        public boolean f2201v;
        public final Bundle y;

        /* renamed from: zn  reason: collision with root package name */
        public final rz.i9[] f2202zn;

        /* loaded from: classes.dex */
        public static final class y {

            /* renamed from: a  reason: collision with root package name */
            public ArrayList<rz.i9> f2203a;

            /* renamed from: c5  reason: collision with root package name */
            public boolean f2204c5;

            /* renamed from: fb  reason: collision with root package name */
            public int f2205fb;

            /* renamed from: gv  reason: collision with root package name */
            public boolean f2206gv;

            /* renamed from: i9  reason: collision with root package name */
            public boolean f2207i9;

            /* renamed from: n3  reason: collision with root package name */
            public final CharSequence f2208n3;

            /* renamed from: s  reason: collision with root package name */
            public boolean f2209s;

            /* renamed from: v  reason: collision with root package name */
            public final Bundle f2210v;
            public final IconCompat y;

            /* renamed from: zn  reason: collision with root package name */
            public final PendingIntent f2211zn;

            public y(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
                this(iconCompat, charSequence, pendingIntent, new Bundle(), null, true, 0, true, false, false);
            }

            public final void n3() {
                if (!this.f2204c5 || this.f2211zn != null) {
                    return;
                }
                throw new NullPointerException("Contextual Actions must contain a valid PendingIntent");
            }

            @NonNull
            public n3 y() {
                rz.i9[] i9VarArr;
                n3();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList<rz.i9> arrayList3 = this.f2203a;
                if (arrayList3 != null) {
                    Iterator<rz.i9> it = arrayList3.iterator();
                    while (it.hasNext()) {
                        rz.i9 next = it.next();
                        if (next.i9()) {
                            arrayList.add(next);
                        } else {
                            arrayList2.add(next);
                        }
                    }
                }
                rz.i9[] i9VarArr2 = null;
                if (arrayList.isEmpty()) {
                    i9VarArr = null;
                } else {
                    i9VarArr = (rz.i9[]) arrayList.toArray(new rz.i9[arrayList.size()]);
                }
                if (!arrayList2.isEmpty()) {
                    i9VarArr2 = (rz.i9[]) arrayList2.toArray(new rz.i9[arrayList2.size()]);
                }
                return new n3(this.y, this.f2208n3, this.f2211zn, this.f2210v, i9VarArr2, i9VarArr, this.f2206gv, this.f2205fb, this.f2209s, this.f2204c5, this.f2207i9);
            }

            public y(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @NonNull Bundle bundle, @Nullable rz.i9[] i9VarArr, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
                this.f2206gv = true;
                this.f2209s = true;
                this.y = iconCompat;
                this.f2208n3 = tl.v(charSequence);
                this.f2211zn = pendingIntent;
                this.f2210v = bundle;
                this.f2203a = i9VarArr == null ? null : new ArrayList<>(Arrays.asList(i9VarArr));
                this.f2206gv = z2;
                this.f2205fb = i;
                this.f2209s = z3;
                this.f2204c5 = z4;
                this.f2207i9 = z5;
            }
        }

        public n3(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(i != 0 ? IconCompat.f(null, "", i) : null, charSequence, pendingIntent);
        }

        public int a() {
            return this.f2195fb;
        }

        public boolean c5() {
            return this.f2200t;
        }

        public boolean fb() {
            return this.f2192a;
        }

        @Nullable
        public IconCompat gv() {
            int i;
            if (this.f2198n3 == null && (i = this.f2193c5) != 0) {
                this.f2198n3 = IconCompat.f(null, "", i);
            }
            return this.f2198n3;
        }

        public boolean i9() {
            return this.f2199s;
        }

        public boolean n3() {
            return this.f2201v;
        }

        @Nullable
        public CharSequence s() {
            return this.f2197i9;
        }

        @Nullable
        public rz.i9[] v() {
            return this.f2202zn;
        }

        @Nullable
        public PendingIntent y() {
            return this.f2194f;
        }

        @NonNull
        public Bundle zn() {
            return this.y;
        }

        public n3(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (rz.i9[]) null, (rz.i9[]) null, true, 0, true, false, false);
        }

        public n3(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable rz.i9[] i9VarArr, @Nullable rz.i9[] i9VarArr2, boolean z2, int i5, boolean z3, boolean z4, boolean z5) {
            this(i != 0 ? IconCompat.f(null, "", i) : null, charSequence, pendingIntent, bundle, i9VarArr, i9VarArr2, z2, i5, z3, z4, z5);
        }

        public n3(@Nullable IconCompat iconCompat, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent, @Nullable Bundle bundle, @Nullable rz.i9[] i9VarArr, @Nullable rz.i9[] i9VarArr2, boolean z2, int i, boolean z3, boolean z4, boolean z5) {
            this.f2192a = true;
            this.f2198n3 = iconCompat;
            if (iconCompat != null && iconCompat.xc() == 2) {
                this.f2193c5 = iconCompat.tl();
            }
            this.f2197i9 = tl.v(charSequence);
            this.f2194f = pendingIntent;
            this.y = bundle == null ? new Bundle() : bundle;
            this.f2202zn = i9VarArr;
            this.f2196gv = i9VarArr2;
            this.f2201v = z2;
            this.f2195fb = i;
            this.f2192a = z3;
            this.f2199s = z4;
            this.f2200t = z5;
        }
    }

    /* loaded from: classes.dex */
    public static class s {
        public static LocusId gv(Notification notification) {
            return notification.getLocusId();
        }

        public static Notification.BubbleMetadata n3(Notification notification) {
            return notification.getBubbleMetadata();
        }

        public static boolean v(Notification.Action action) {
            return action.isContextual();
        }

        public static boolean y(Notification notification) {
            return notification.getAllowSystemGeneratedContextualActions();
        }

        public static int zn(RemoteInput remoteInput) {
            return remoteInput.getEditChoicesBeforeSending();
        }
    }

    /* loaded from: classes.dex */
    public static final class t {

        /* renamed from: a  reason: collision with root package name */
        public int f2212a;

        /* renamed from: fb  reason: collision with root package name */
        public String f2213fb;

        /* renamed from: gv  reason: collision with root package name */
        public int f2214gv;

        /* renamed from: n3  reason: collision with root package name */
        public PendingIntent f2215n3;

        /* renamed from: v  reason: collision with root package name */
        public int f2216v;
        public PendingIntent y;

        /* renamed from: zn  reason: collision with root package name */
        public IconCompat f2217zn;

        /* loaded from: classes.dex */
        public static class n3 {
            @Nullable
            public static Notification.BubbleMetadata n3(@Nullable t tVar) {
                Notification.BubbleMetadata.Builder builder;
                if (tVar == null) {
                    return null;
                }
                if (tVar.s() != null) {
                    builder = new Notification.BubbleMetadata.Builder(tVar.s());
                } else {
                    builder = new Notification.BubbleMetadata.Builder(tVar.fb(), tVar.a().r());
                }
                builder.setDeleteIntent(tVar.zn()).setAutoExpandBubble(tVar.n3()).setSuppressNotification(tVar.c5());
                if (tVar.gv() != 0) {
                    builder.setDesiredHeight(tVar.gv());
                }
                if (tVar.v() != 0) {
                    builder.setDesiredHeightResId(tVar.v());
                }
                return builder.build();
            }

            @Nullable
            public static t y(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                zn znVar;
                if (bubbleMetadata == null) {
                    return null;
                }
                if (bubbleMetadata.getShortcutId() != null) {
                    znVar = new zn(bubbleMetadata.getShortcutId());
                } else {
                    znVar = new zn(bubbleMetadata.getIntent(), IconCompat.y(bubbleMetadata.getIcon()));
                }
                znVar.n3(bubbleMetadata.getAutoExpandBubble()).zn(bubbleMetadata.getDeleteIntent()).fb(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    znVar.gv(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    znVar.v(bubbleMetadata.getDesiredHeightResId());
                }
                return znVar.y();
            }
        }

        /* loaded from: classes.dex */
        public static class y {
            @Nullable
            public static Notification.BubbleMetadata n3(@Nullable t tVar) {
                if (tVar == null || tVar.fb() == null) {
                    return null;
                }
                Notification.BubbleMetadata.Builder suppressNotification = new Notification.BubbleMetadata.Builder().setIcon(tVar.a().r()).setIntent(tVar.fb()).setDeleteIntent(tVar.zn()).setAutoExpandBubble(tVar.n3()).setSuppressNotification(tVar.c5());
                if (tVar.gv() != 0) {
                    suppressNotification.setDesiredHeight(tVar.gv());
                }
                if (tVar.v() != 0) {
                    suppressNotification.setDesiredHeightResId(tVar.v());
                }
                return suppressNotification.build();
            }

            @Nullable
            public static t y(@Nullable Notification.BubbleMetadata bubbleMetadata) {
                if (bubbleMetadata == null || bubbleMetadata.getIntent() == null) {
                    return null;
                }
                zn fb2 = new zn(bubbleMetadata.getIntent(), IconCompat.y(bubbleMetadata.getIcon())).n3(bubbleMetadata.getAutoExpandBubble()).zn(bubbleMetadata.getDeleteIntent()).fb(bubbleMetadata.isNotificationSuppressed());
                if (bubbleMetadata.getDesiredHeight() != 0) {
                    fb2.gv(bubbleMetadata.getDesiredHeight());
                }
                if (bubbleMetadata.getDesiredHeightResId() != 0) {
                    fb2.v(bubbleMetadata.getDesiredHeightResId());
                }
                return fb2.y();
            }
        }

        @Nullable
        public static Notification.BubbleMetadata f(@Nullable t tVar) {
            if (tVar == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return n3.n3(tVar);
            }
            if (i != 29) {
                return null;
            }
            return y.n3(tVar);
        }

        @Nullable
        public static t y(@Nullable Notification.BubbleMetadata bubbleMetadata) {
            if (bubbleMetadata == null) {
                return null;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 30) {
                return n3.y(bubbleMetadata);
            }
            if (i != 29) {
                return null;
            }
            return y.y(bubbleMetadata);
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public IconCompat a() {
            return this.f2217zn;
        }

        public boolean c5() {
            if ((this.f2212a & 2) != 0) {
                return true;
            }
            return false;
        }

        @Nullable
        @SuppressLint({"InvalidNullConversion"})
        public PendingIntent fb() {
            return this.y;
        }

        public int gv() {
            return this.f2214gv;
        }

        public void i9(int i) {
            this.f2212a = i;
        }

        public boolean n3() {
            if ((this.f2212a & 1) != 0) {
                return true;
            }
            return false;
        }

        @Nullable
        public String s() {
            return this.f2213fb;
        }

        public int v() {
            return this.f2216v;
        }

        @Nullable
        public PendingIntent zn() {
            return this.f2215n3;
        }

        public t(@Nullable PendingIntent pendingIntent, @Nullable PendingIntent pendingIntent2, @Nullable IconCompat iconCompat, int i, int i5, int i6, @Nullable String str) {
            this.y = pendingIntent;
            this.f2217zn = iconCompat;
            this.f2214gv = i;
            this.f2216v = i5;
            this.f2215n3 = pendingIntent2;
            this.f2212a = i6;
            this.f2213fb = str;
        }

        /* loaded from: classes.dex */
        public static final class zn {

            /* renamed from: a  reason: collision with root package name */
            public PendingIntent f2218a;

            /* renamed from: fb  reason: collision with root package name */
            public String f2219fb;

            /* renamed from: gv  reason: collision with root package name */
            public int f2220gv;

            /* renamed from: n3  reason: collision with root package name */
            public IconCompat f2221n3;

            /* renamed from: v  reason: collision with root package name */
            public int f2222v;
            public PendingIntent y;

            /* renamed from: zn  reason: collision with root package name */
            public int f2223zn;

            public zn(@NonNull String str) {
                if (!TextUtils.isEmpty(str)) {
                    this.f2219fb = str;
                    return;
                }
                throw new NullPointerException("Bubble requires a non-null shortcut id");
            }

            @NonNull
            public final zn a(int i, boolean z2) {
                if (z2) {
                    this.f2222v = i | this.f2222v;
                } else {
                    this.f2222v = (~i) & this.f2222v;
                }
                return this;
            }

            @NonNull
            public zn fb(boolean z2) {
                a(2, z2);
                return this;
            }

            @NonNull
            public zn gv(int i) {
                this.f2223zn = Math.max(i, 0);
                this.f2220gv = 0;
                return this;
            }

            @NonNull
            public zn n3(boolean z2) {
                a(1, z2);
                return this;
            }

            @NonNull
            public zn v(int i) {
                this.f2220gv = i;
                this.f2223zn = 0;
                return this;
            }

            @NonNull
            @SuppressLint({"SyntheticAccessor"})
            public t y() {
                String str = this.f2219fb;
                if (str == null && this.y == null) {
                    throw new NullPointerException("Must supply pending intent or shortcut to bubble");
                }
                if (str == null && this.f2221n3 == null) {
                    throw new NullPointerException("Must supply an icon or shortcut for the bubble");
                }
                t tVar = new t(this.y, this.f2218a, this.f2221n3, this.f2223zn, this.f2220gv, this.f2222v, str);
                tVar.i9(this.f2222v);
                return tVar;
            }

            @NonNull
            public zn zn(@Nullable PendingIntent pendingIntent) {
                this.f2218a = pendingIntent;
                return this;
            }

            public zn(@NonNull PendingIntent pendingIntent, @NonNull IconCompat iconCompat) {
                if (pendingIntent == null) {
                    throw new NullPointerException("Bubble requires non-null pending intent");
                }
                if (iconCompat != null) {
                    this.y = pendingIntent;
                    this.f2221n3 = iconCompat;
                    return;
                }
                throw new NullPointerException("Bubbles require non-null icon");
            }
        }
    }

    /* loaded from: classes.dex */
    public static class v {
        public static boolean y(Notification.Action action) {
            return action.getAllowGeneratedReplies();
        }
    }

    /* loaded from: classes.dex */
    public static class wz extends xc {

        /* renamed from: a  reason: collision with root package name */
        public androidx.core.app.zn f2272a;

        /* renamed from: c5  reason: collision with root package name */
        public PendingIntent f2273c5;

        /* renamed from: f  reason: collision with root package name */
        public Integer f2274f;

        /* renamed from: fb  reason: collision with root package name */
        public PendingIntent f2275fb;

        /* renamed from: i9  reason: collision with root package name */
        public boolean f2276i9;

        /* renamed from: s  reason: collision with root package name */
        public PendingIntent f2277s;

        /* renamed from: t  reason: collision with root package name */
        public Integer f2278t;

        /* renamed from: tl  reason: collision with root package name */
        public IconCompat f2279tl;

        /* renamed from: v  reason: collision with root package name */
        public int f2280v;

        /* renamed from: wz  reason: collision with root package name */
        public CharSequence f2281wz;

        /* loaded from: classes.dex */
        public static class gv {
            public static Parcelable n3(Person person) {
                return person;
            }

            public static Notification.Builder y(Notification.Builder builder, Person person) {
                return builder.addPerson(person);
            }
        }

        /* loaded from: classes.dex */
        public static class n3 {
            public static Notification.Builder n3(Notification.Builder builder, String str) {
                return builder.setCategory(str);
            }

            public static Notification.Builder y(Notification.Builder builder, String str) {
                return builder.addPerson(str);
            }
        }

        /* loaded from: classes.dex */
        public static class v {
            public static Notification.CallStyle a(Notification.CallStyle callStyle, int i) {
                return callStyle.setDeclineButtonColorHint(i);
            }

            public static Notification.CallStyle c5(Notification.CallStyle callStyle, @Nullable CharSequence charSequence) {
                return callStyle.setVerificationText(charSequence);
            }

            public static Notification.CallStyle fb(Notification.CallStyle callStyle, boolean z2) {
                return callStyle.setIsVideo(z2);
            }

            public static Notification.CallStyle gv(Notification.CallStyle callStyle, int i) {
                return callStyle.setAnswerButtonColorHint(i);
            }

            public static Notification.CallStyle n3(@NonNull Person person, @NonNull PendingIntent pendingIntent) {
                return Notification.CallStyle.forOngoingCall(person, pendingIntent);
            }

            public static Notification.CallStyle s(Notification.CallStyle callStyle, @Nullable Icon icon) {
                return callStyle.setVerificationIcon(icon);
            }

            public static Notification.Action.Builder v(Notification.Action.Builder builder, boolean z2) {
                return builder.setAuthenticationRequired(z2);
            }

            public static Notification.CallStyle y(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forIncomingCall(person, pendingIntent, pendingIntent2);
            }

            public static Notification.CallStyle zn(@NonNull Person person, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
                return Notification.CallStyle.forScreeningCall(person, pendingIntent, pendingIntent2);
            }
        }

        /* loaded from: classes.dex */
        public static class y {
            public static void y(Notification.CallStyle callStyle, Notification.Builder builder) {
                callStyle.setBuilder(builder);
            }
        }

        /* loaded from: classes.dex */
        public static class zn {
            public static Notification.Action.Builder n3(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
                return new Notification.Action.Builder(icon, charSequence, pendingIntent);
            }

            public static Parcelable y(Icon icon) {
                return icon;
            }

            public static void zn(Notification.Builder builder, Icon icon) {
                builder.setLargeIcon(icon);
            }
        }

        @Nullable
        public final String c5() {
            int i = this.f2280v;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return this.y.y.getResources().getString(R$string.f2140fb);
                }
                return this.y.y.getResources().getString(R$string.f2139a);
            }
            return this.y.y.getResources().getString(R$string.f2143v);
        }

        @NonNull
        public final n3 f(int i, int i5, Integer num, int i6, PendingIntent pendingIntent) {
            if (num == null) {
                num = Integer.valueOf(mg.y.zn(this.y.y, i6));
            }
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
            spannableStringBuilder.append((CharSequence) this.y.y.getResources().getString(i5));
            spannableStringBuilder.setSpan(new ForegroundColorSpan(num.intValue()), 0, spannableStringBuilder.length(), 18);
            n3 y2 = new n3.y(IconCompat.i9(this.y.y, i), spannableStringBuilder, pendingIntent).y();
            y2.zn().putBoolean("key_action_priority", true);
            return y2;
        }

        public final boolean i9(n3 n3Var) {
            if (n3Var != null && n3Var.zn().getBoolean("key_action_priority")) {
                return true;
            }
            return false;
        }

        @Override // androidx.core.app.NotificationCompat.xc
        public void n3(rz.c5 c5Var) {
            CharSequence charSequence;
            int i = Build.VERSION.SDK_INT;
            CharSequence charSequence2 = null;
            Notification.CallStyle y2 = null;
            charSequence2 = null;
            if (i >= 31) {
                int i5 = this.f2280v;
                if (i5 != 1) {
                    if (i5 != 2) {
                        if (i5 != 3) {
                            Log.isLoggable("NotifCompat", 3);
                        } else {
                            y2 = v.zn(this.f2272a.i9(), this.f2273c5, this.f2275fb);
                        }
                    } else {
                        y2 = v.n3(this.f2272a.i9(), this.f2273c5);
                    }
                } else {
                    y2 = v.y(this.f2272a.i9(), this.f2277s, this.f2275fb);
                }
                if (y2 != null) {
                    y.y(y2, c5Var.y());
                    Integer num = this.f2274f;
                    if (num != null) {
                        v.gv(y2, num.intValue());
                    }
                    Integer num2 = this.f2278t;
                    if (num2 != null) {
                        v.a(y2, num2.intValue());
                    }
                    v.c5(y2, this.f2281wz);
                    IconCompat iconCompat = this.f2279tl;
                    if (iconCompat != null) {
                        v.s(y2, iconCompat.x4(this.y.y));
                    }
                    v.fb(y2, this.f2276i9);
                    return;
                }
                return;
            }
            Notification.Builder y7 = c5Var.y();
            androidx.core.app.zn znVar = this.f2272a;
            if (znVar != null) {
                charSequence = znVar.v();
            } else {
                charSequence = null;
            }
            y7.setContentTitle(charSequence);
            Bundle bundle = this.y.f2244mg;
            if (bundle != null && bundle.containsKey("android.text")) {
                charSequence2 = this.y.f2244mg.getCharSequence("android.text");
            }
            if (charSequence2 == null) {
                charSequence2 = c5();
            }
            y7.setContentText(charSequence2);
            androidx.core.app.zn znVar2 = this.f2272a;
            if (znVar2 != null) {
                if (i >= 23 && znVar2.zn() != null) {
                    zn.zn(y7, this.f2272a.zn().x4(this.y.y));
                }
                if (i >= 28) {
                    gv.y(y7, this.f2272a.i9());
                } else {
                    n3.y(y7, this.f2272a.a());
                }
            }
            n3.n3(y7, "call");
        }

        @NonNull
        public ArrayList<n3> s() {
            n3 tl2 = tl();
            n3 t2 = t();
            ArrayList<n3> arrayList = new ArrayList<>(3);
            arrayList.add(tl2);
            ArrayList<n3> arrayList2 = this.y.f2247n3;
            int i = 2;
            if (arrayList2 != null) {
                for (n3 n3Var : arrayList2) {
                    if (n3Var.i9()) {
                        arrayList.add(n3Var);
                    } else if (!i9(n3Var) && i > 1) {
                        arrayList.add(n3Var);
                        i--;
                    }
                    if (t2 != null && i == 1) {
                        arrayList.add(t2);
                        i--;
                    }
                }
            }
            if (t2 != null && i >= 1) {
                arrayList.add(t2);
            }
            return arrayList;
        }

        @Nullable
        public final n3 t() {
            int i;
            int i5;
            int i6 = R$drawable.f2093n3;
            int i8 = R$drawable.y;
            PendingIntent pendingIntent = this.f2275fb;
            if (pendingIntent == null) {
                return null;
            }
            boolean z2 = this.f2276i9;
            if (z2) {
                i = i6;
            } else {
                i = i8;
            }
            if (z2) {
                i5 = R$string.f2142n3;
            } else {
                i5 = R$string.y;
            }
            return f(i, i5, this.f2274f, R$color.y, pendingIntent);
        }

        @NonNull
        public final n3 tl() {
            int i = R$drawable.f2094zn;
            PendingIntent pendingIntent = this.f2277s;
            if (pendingIntent == null) {
                return f(i, R$string.f2141gv, this.f2278t, R$color.f2091n3, this.f2273c5);
            }
            return f(i, R$string.f2144zn, this.f2278t, R$color.f2091n3, pendingIntent);
        }

        @Override // androidx.core.app.NotificationCompat.xc
        public void y(@NonNull Bundle bundle) {
            super.y(bundle);
            bundle.putInt("android.callType", this.f2280v);
            bundle.putBoolean("android.callIsVideo", this.f2276i9);
            androidx.core.app.zn znVar = this.f2272a;
            if (znVar != null) {
                if (Build.VERSION.SDK_INT >= 28) {
                    bundle.putParcelable("android.callPerson", gv.n3(znVar.i9()));
                } else {
                    bundle.putParcelable("android.callPersonCompat", znVar.f());
                }
            }
            IconCompat iconCompat = this.f2279tl;
            if (iconCompat != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    bundle.putParcelable("android.verificationIcon", zn.y(iconCompat.x4(this.y.y)));
                } else {
                    bundle.putParcelable("android.verificationIconCompat", iconCompat.z());
                }
            }
            bundle.putCharSequence("android.verificationText", this.f2281wz);
            bundle.putParcelable("android.answerIntent", this.f2275fb);
            bundle.putParcelable("android.declineIntent", this.f2277s);
            bundle.putParcelable("android.hangUpIntent", this.f2273c5);
            Integer num = this.f2274f;
            if (num != null) {
                bundle.putInt("android.answerColor", num.intValue());
            }
            Integer num2 = this.f2278t;
            if (num2 != null) {
                bundle.putInt("android.declineColor", num2.intValue());
            }
        }

        @Override // androidx.core.app.NotificationCompat.xc
        @NonNull
        public String zn() {
            return "androidx.core.app.NotificationCompat$CallStyle";
        }
    }

    /* loaded from: classes.dex */
    public static abstract class xc {

        /* renamed from: gv  reason: collision with root package name */
        public boolean f2282gv;

        /* renamed from: n3  reason: collision with root package name */
        public CharSequence f2283n3;
        public tl y;

        /* renamed from: zn  reason: collision with root package name */
        public CharSequence f2284zn;

        public RemoteViews a(rz.c5 c5Var) {
            return null;
        }

        public void fb(@Nullable tl tlVar) {
            if (this.y != tlVar) {
                this.y = tlVar;
                if (tlVar != null) {
                    tlVar.rz(this);
                }
            }
        }

        public RemoteViews gv(rz.c5 c5Var) {
            return null;
        }

        public abstract void n3(rz.c5 c5Var);

        public RemoteViews v(rz.c5 c5Var) {
            return null;
        }

        public void y(@NonNull Bundle bundle) {
            if (this.f2282gv) {
                bundle.putCharSequence("android.summaryText", this.f2284zn);
            }
            CharSequence charSequence = this.f2283n3;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String zn2 = zn();
            if (zn2 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", zn2);
            }
        }

        @Nullable
        public String zn() {
            return null;
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static CharSequence a(RemoteInput remoteInput) {
            return remoteInput.getLabel();
        }

        public static String c5(Notification notification) {
            return notification.getSortKey();
        }

        public static RemoteInput[] fb(Notification.Action action) {
            return action.getRemoteInputs();
        }

        public static Bundle gv(RemoteInput remoteInput) {
            return remoteInput.getExtras();
        }

        public static CharSequence[] n3(RemoteInput remoteInput) {
            return remoteInput.getChoices();
        }

        public static String s(RemoteInput remoteInput) {
            return remoteInput.getResultKey();
        }

        public static String v(Notification notification) {
            return notification.getGroup();
        }

        public static boolean y(RemoteInput remoteInput) {
            return remoteInput.getAllowFreeFormInput();
        }

        public static Bundle zn(Notification.Action action) {
            return action.getExtras();
        }
    }

    @Nullable
    public static n3 getAction(@NonNull Notification notification, int i) {
        return getActionCompatFromAction(notification.actions[i]);
    }

    @NonNull
    public static n3 getActionCompatFromAction(@NonNull Notification.Action action) {
        rz.i9[] i9VarArr;
        int i;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        int i6;
        RemoteInput[] fb2 = zn.fb(action);
        IconCompat iconCompat = null;
        if (fb2 == null) {
            i9VarArr = null;
        } else {
            rz.i9[] i9VarArr2 = new rz.i9[fb2.length];
            for (int i8 = 0; i8 < fb2.length; i8++) {
                RemoteInput remoteInput = fb2[i8];
                String s2 = zn.s(remoteInput);
                CharSequence a2 = zn.a(remoteInput);
                CharSequence[] n32 = zn.n3(remoteInput);
                boolean y2 = zn.y(remoteInput);
                if (Build.VERSION.SDK_INT >= 29) {
                    i = s.zn(remoteInput);
                } else {
                    i = 0;
                }
                i9VarArr2[i8] = new rz.i9(s2, a2, n32, y2, i, zn.gv(remoteInput), null);
            }
            i9VarArr = i9VarArr2;
        }
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24) {
            if (!zn.zn(action).getBoolean("android.support.allowGeneratedReplies") && !v.y(action)) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = zn.zn(action).getBoolean("android.support.allowGeneratedReplies");
        }
        boolean z5 = z2;
        boolean z7 = zn.zn(action).getBoolean("android.support.action.showsUserInterface", true);
        if (i10 >= 28) {
            i5 = fb.y(action);
        } else {
            i5 = zn.zn(action).getInt("android.support.action.semanticAction", 0);
        }
        int i11 = i5;
        if (i10 >= 29) {
            z3 = s.v(action);
        } else {
            z3 = false;
        }
        if (i10 >= 31) {
            z4 = c5.y(action);
        } else {
            z4 = false;
        }
        if (i10 >= 23) {
            if (gv.y(action) == null && (i6 = action.icon) != 0) {
                return new n3(i6, action.title, action.actionIntent, zn.zn(action), i9VarArr, (rz.i9[]) null, z5, i11, z7, z3, z4);
            }
            if (gv.y(action) != null) {
                iconCompat = IconCompat.n3(gv.y(action));
            }
            return new n3(iconCompat, action.title, action.actionIntent, zn.zn(action), i9VarArr, (rz.i9[]) null, z5, i11, z7, z3, z4);
        }
        return new n3(action.icon, action.title, action.actionIntent, zn.zn(action), i9VarArr, (rz.i9[]) null, z5, i11, z7, z3, z4);
    }

    public static int getActionCount(@NonNull Notification notification) {
        Notification.Action[] actionArr = notification.actions;
        if (actionArr != null) {
            return actionArr.length;
        }
        return 0;
    }

    public static boolean getAllowSystemGeneratedContextualActions(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return s.y(notification);
        }
        return false;
    }

    public static boolean getAutoCancel(@NonNull Notification notification) {
        if ((notification.flags & 16) != 0) {
            return true;
        }
        return false;
    }

    public static int getBadgeIconType(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.y(notification);
        }
        return 0;
    }

    @Nullable
    public static t getBubbleMetadata(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 29) {
            return t.y(s.n3(notification));
        }
        return null;
    }

    @Nullable
    public static String getCategory(@NonNull Notification notification) {
        return notification.category;
    }

    @Nullable
    public static String getChannelId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.n3(notification);
        }
        return null;
    }

    public static int getColor(@NonNull Notification notification) {
        return notification.color;
    }

    @Nullable
    public static CharSequence getContentInfo(@NonNull Notification notification) {
        return notification.extras.getCharSequence("android.infoText");
    }

    @Nullable
    public static CharSequence getContentText(@NonNull Notification notification) {
        return notification.extras.getCharSequence("android.text");
    }

    @Nullable
    public static CharSequence getContentTitle(@NonNull Notification notification) {
        return notification.extras.getCharSequence("android.title");
    }

    @Nullable
    public static Bundle getExtras(@NonNull Notification notification) {
        return notification.extras;
    }

    @Nullable
    public static String getGroup(@NonNull Notification notification) {
        return zn.v(notification);
    }

    public static int getGroupAlertBehavior(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.zn(notification);
        }
        return 0;
    }

    public static boolean getHighPriority(@NonNull Notification notification) {
        if ((notification.flags & FLAG_HIGH_PRIORITY) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static List<n3> getInvisibleActions(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        Bundle bundle = notification.extras.getBundle("android.car.EXTENSIONS");
        if (bundle == null) {
            return arrayList;
        }
        Bundle bundle2 = bundle.getBundle("invisible_actions");
        if (bundle2 != null) {
            for (int i = 0; i < bundle2.size(); i++) {
                arrayList.add(androidx.core.app.n3.zn(bundle2.getBundle(Integer.toString(i))));
            }
        }
        return arrayList;
    }

    public static boolean getLocalOnly(@NonNull Notification notification) {
        if ((notification.flags & 256) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static mg.n3 getLocusId(@NonNull Notification notification) {
        LocusId gv2;
        if (Build.VERSION.SDK_INT < 29 || (gv2 = s.gv(notification)) == null) {
            return null;
        }
        return mg.n3.gv(gv2);
    }

    @NonNull
    public static Notification[] getNotificationArrayFromBundle(@NonNull Bundle bundle, @NonNull String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Notification[]) && parcelableArray != null) {
            Notification[] notificationArr = new Notification[parcelableArray.length];
            for (int i = 0; i < parcelableArray.length; i++) {
                notificationArr[i] = (Notification) parcelableArray[i];
            }
            bundle.putParcelableArray(str, notificationArr);
            return notificationArr;
        }
        return (Notification[]) parcelableArray;
    }

    public static boolean getOngoing(@NonNull Notification notification) {
        if ((notification.flags & 2) != 0) {
            return true;
        }
        return false;
    }

    public static boolean getOnlyAlertOnce(@NonNull Notification notification) {
        if ((notification.flags & 8) != 0) {
            return true;
        }
        return false;
    }

    @NonNull
    public static List<androidx.core.app.zn> getPeople(@NonNull Notification notification) {
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 28) {
            ArrayList parcelableArrayList = notification.extras.getParcelableArrayList("android.people.list");
            if (parcelableArrayList != null && !parcelableArrayList.isEmpty()) {
                Iterator it = parcelableArrayList.iterator();
                while (it.hasNext()) {
                    arrayList.add(androidx.core.app.zn.y((Person) it.next()));
                }
            }
        } else {
            String[] stringArray = notification.extras.getStringArray(EXTRA_PEOPLE);
            if (stringArray != null && stringArray.length != 0) {
                for (String str : stringArray) {
                    arrayList.add(new zn.C0019zn().fb(str).y());
                }
            }
        }
        return arrayList;
    }

    @Nullable
    public static Notification getPublicVersion(@NonNull Notification notification) {
        return notification.publicVersion;
    }

    @Nullable
    public static CharSequence getSettingsText(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.gv(notification);
        }
        return null;
    }

    @Nullable
    public static String getShortcutId(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.v(notification);
        }
        return null;
    }

    public static boolean getShowWhen(@NonNull Notification notification) {
        return notification.extras.getBoolean("android.showWhen");
    }

    @Nullable
    public static String getSortKey(@NonNull Notification notification) {
        return zn.c5(notification);
    }

    @Nullable
    public static CharSequence getSubText(@NonNull Notification notification) {
        return notification.extras.getCharSequence("android.subText");
    }

    public static long getTimeoutAfter(@NonNull Notification notification) {
        if (Build.VERSION.SDK_INT >= 26) {
            return a.a(notification);
        }
        return 0L;
    }

    public static boolean getUsesChronometer(@NonNull Notification notification) {
        return notification.extras.getBoolean("android.showChronometer");
    }

    public static int getVisibility(@NonNull Notification notification) {
        return notification.visibility;
    }

    public static boolean isGroupSummary(@NonNull Notification notification) {
        if ((notification.flags & 512) != 0) {
            return true;
        }
        return false;
    }

    @Nullable
    public static Bitmap reduceLargeIconSize(@NonNull Context context, @Nullable Bitmap bitmap) {
        if (bitmap != null && Build.VERSION.SDK_INT < 27) {
            Resources resources = context.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R$dimen.f2092n3);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(R$dimen.y);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(dimensionPixelSize / Math.max(1, bitmap.getWidth()), dimensionPixelSize2 / Math.max(1, bitmap.getHeight()));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(bitmap.getWidth() * min), (int) Math.ceil(bitmap.getHeight() * min), true);
        }
        return bitmap;
    }

    /* loaded from: classes.dex */
    public static class tl {

        /* renamed from: a  reason: collision with root package name */
        public CharSequence f2224a;

        /* renamed from: a8  reason: collision with root package name */
        public RemoteViews f2225a8;

        /* renamed from: b  reason: collision with root package name */
        public int f2226b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f2227c;

        /* renamed from: c5  reason: collision with root package name */
        public RemoteViews f2228c5;

        /* renamed from: co  reason: collision with root package name */
        public CharSequence[] f2229co;

        /* renamed from: d  reason: collision with root package name */
        public int f2230d;

        /* renamed from: d0  reason: collision with root package name */
        public boolean f2231d0;

        /* renamed from: ej  reason: collision with root package name */
        public RemoteViews f2232ej;

        /* renamed from: f  reason: collision with root package name */
        public CharSequence f2233f;

        /* renamed from: f3  reason: collision with root package name */
        public boolean f2234f3;

        /* renamed from: fb  reason: collision with root package name */
        public PendingIntent f2235fb;

        /* renamed from: fh  reason: collision with root package name */
        public boolean f2236fh;

        /* renamed from: gv  reason: collision with root package name */
        public ArrayList<n3> f2237gv;

        /* renamed from: hw  reason: collision with root package name */
        public int f2238hw;

        /* renamed from: i4  reason: collision with root package name */
        public String f2239i4;

        /* renamed from: i9  reason: collision with root package name */
        public IconCompat f2240i9;

        /* renamed from: j  reason: collision with root package name */
        public Notification f2241j;

        /* renamed from: j5  reason: collision with root package name */
        public int f2242j5;

        /* renamed from: k5  reason: collision with root package name */
        public String f2243k5;

        /* renamed from: mg  reason: collision with root package name */
        public Bundle f2244mg;

        /* renamed from: mt  reason: collision with root package name */
        public CharSequence f2245mt;

        /* renamed from: n  reason: collision with root package name */
        public String f2246n;

        /* renamed from: n3  reason: collision with root package name */
        public ArrayList<n3> f2247n3;

        /* renamed from: o  reason: collision with root package name */
        public t f2248o;

        /* renamed from: oz  reason: collision with root package name */
        public boolean f2249oz;

        /* renamed from: p  reason: collision with root package name */
        public CharSequence f2250p;
        @Deprecated

        /* renamed from: q9  reason: collision with root package name */
        public ArrayList<String> f2251q9;

        /* renamed from: qn  reason: collision with root package name */
        public boolean f2252qn;

        /* renamed from: r  reason: collision with root package name */
        public int f2253r;

        /* renamed from: rz  reason: collision with root package name */
        public String f2254rz;

        /* renamed from: s  reason: collision with root package name */
        public PendingIntent f2255s;

        /* renamed from: t  reason: collision with root package name */
        public int f2256t;

        /* renamed from: ta  reason: collision with root package name */
        public int f2257ta;

        /* renamed from: tl  reason: collision with root package name */
        public int f2258tl;

        /* renamed from: ud  reason: collision with root package name */
        public RemoteViews f2259ud;

        /* renamed from: ut  reason: collision with root package name */
        public Object f2260ut;

        /* renamed from: v  reason: collision with root package name */
        public CharSequence f2261v;

        /* renamed from: vl  reason: collision with root package name */
        public long f2262vl;

        /* renamed from: w  reason: collision with root package name */
        public xc f2263w;

        /* renamed from: wz  reason: collision with root package name */
        public boolean f2264wz;

        /* renamed from: x  reason: collision with root package name */
        public String f2265x;

        /* renamed from: x4  reason: collision with root package name */
        public boolean f2266x4;

        /* renamed from: xc  reason: collision with root package name */
        public boolean f2267xc;
        public Context y;

        /* renamed from: yt  reason: collision with root package name */
        public mg.n3 f2268yt;

        /* renamed from: z  reason: collision with root package name */
        public int f2269z;

        /* renamed from: z6  reason: collision with root package name */
        public Notification f2270z6;
        @NonNull

        /* renamed from: zn  reason: collision with root package name */
        public ArrayList<androidx.core.app.zn> f2271zn;

        /* loaded from: classes.dex */
        public static class y {
            public static AudioAttributes.Builder gv(AudioAttributes.Builder builder, int i) {
                return builder.setLegacyStreamType(i);
            }

            public static AudioAttributes.Builder n3() {
                return new AudioAttributes.Builder();
            }

            public static AudioAttributes.Builder v(AudioAttributes.Builder builder, int i) {
                return builder.setUsage(i);
            }

            public static AudioAttributes y(AudioAttributes.Builder builder) {
                return builder.build();
            }

            public static AudioAttributes.Builder zn(AudioAttributes.Builder builder, int i) {
                return builder.setContentType(i);
            }
        }

        public tl(@NonNull Context context, @NonNull String str) {
            this.f2247n3 = new ArrayList<>();
            this.f2271zn = new ArrayList<>();
            this.f2237gv = new ArrayList<>();
            this.f2264wz = true;
            this.f2227c = false;
            this.f2257ta = 0;
            this.f2230d = 0;
            this.f2226b = 0;
            this.f2238hw = 0;
            this.f2242j5 = 0;
            Notification notification = new Notification();
            this.f2241j = notification;
            this.y = context;
            this.f2265x = str;
            notification.when = System.currentTimeMillis();
            this.f2241j.audioStreamType = -1;
            this.f2258tl = 0;
            this.f2251q9 = new ArrayList<>();
            this.f2252qn = true;
        }

        @Nullable
        public static CharSequence v(@Nullable CharSequence charSequence) {
            if (charSequence == null) {
                return charSequence;
            }
            if (charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        @NonNull
        public tl a(boolean z2) {
            mt(16, z2);
            return this;
        }

        @NonNull
        public tl c(boolean z2) {
            this.f2264wz = z2;
            return this;
        }

        @NonNull
        public tl c5(int i) {
            this.f2257ta = i;
            return this;
        }

        @NonNull
        public tl co(@Nullable String str) {
            this.f2239i4 = str;
            return this;
        }

        @NonNull
        public tl d(int i) {
            this.f2230d = i;
            return this;
        }

        @NonNull
        public tl d0(int i) {
            this.f2241j.icon = i;
            return this;
        }

        @NonNull
        public tl f(@Nullable PendingIntent pendingIntent) {
            this.f2235fb = pendingIntent;
            return this;
        }

        @NonNull
        public tl f3(boolean z2) {
            mt(2, z2);
            return this;
        }

        @NonNull
        public tl fb(@Nullable String str) {
            this.f2254rz = str;
            return this;
        }

        @NonNull
        public tl fh(@Nullable Uri uri) {
            Notification notification = this.f2241j;
            notification.sound = uri;
            notification.audioStreamType = -1;
            AudioAttributes.Builder v2 = y.v(y.zn(y.n3(), 4), 5);
            this.f2241j.audioAttributes = y.y(v2);
            return this;
        }

        @NonNull
        public Bundle gv() {
            if (this.f2244mg == null) {
                this.f2244mg = new Bundle();
            }
            return this.f2244mg;
        }

        @NonNull
        public tl i4(int i) {
            this.f2256t = i;
            return this;
        }

        @NonNull
        public tl i9(@Nullable RemoteViews remoteViews) {
            this.f2241j.contentView = remoteViews;
            return this;
        }

        @NonNull
        public tl mg(@Nullable CharSequence charSequence) {
            this.f2241j.tickerText = v(charSequence);
            return this;
        }

        public final void mt(int i, boolean z2) {
            if (z2) {
                Notification notification = this.f2241j;
                notification.flags = i | notification.flags;
                return;
            }
            Notification notification2 = this.f2241j;
            notification2.flags = (~i) & notification2.flags;
        }

        @NonNull
        public tl n(int i) {
            this.f2258tl = i;
            return this;
        }

        @NonNull
        public tl n3(@Nullable n3 n3Var) {
            if (n3Var != null) {
                this.f2247n3.add(n3Var);
            }
            return this;
        }

        @NonNull
        public tl p(@Nullable PendingIntent pendingIntent) {
            this.f2241j.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public tl r(int i, int i5, int i6) {
            int i8;
            Notification notification = this.f2241j;
            notification.ledARGB = i;
            notification.ledOnMS = i5;
            notification.ledOffMS = i6;
            if (i5 != 0 && i6 != 0) {
                i8 = 1;
            } else {
                i8 = 0;
            }
            notification.flags = i8 | (notification.flags & (-2));
            return this;
        }

        @NonNull
        public tl rz(@Nullable xc xcVar) {
            if (this.f2263w != xcVar) {
                this.f2263w = xcVar;
                if (xcVar != null) {
                    xcVar.fb(this);
                }
            }
            return this;
        }

        @NonNull
        public tl s(@NonNull String str) {
            this.f2265x = str;
            return this;
        }

        @NonNull
        public tl t(@Nullable CharSequence charSequence) {
            this.f2224a = v(charSequence);
            return this;
        }

        @NonNull
        public tl ta(@Nullable long[] jArr) {
            this.f2241j.vibrate = jArr;
            return this;
        }

        @NonNull
        public tl tl(@Nullable CharSequence charSequence) {
            this.f2261v = v(charSequence);
            return this;
        }

        @NonNull
        public tl w(int i) {
            Notification notification = this.f2241j;
            notification.defaults = i;
            if ((i & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public tl wz(@Nullable RemoteViews remoteViews) {
            this.f2259ud = remoteViews;
            return this;
        }

        @NonNull
        public tl x4(boolean z2) {
            this.f2227c = z2;
            return this;
        }

        @NonNull
        public tl xc(@Nullable RemoteViews remoteViews) {
            this.f2232ej = remoteViews;
            return this;
        }

        @NonNull
        public tl y(int i, @Nullable CharSequence charSequence, @Nullable PendingIntent pendingIntent) {
            this.f2247n3.add(new n3(i, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public tl z(@Nullable Bitmap bitmap) {
            IconCompat fb2;
            if (bitmap == null) {
                fb2 = null;
            } else {
                fb2 = IconCompat.fb(NotificationCompat.reduceLargeIconSize(this.y, bitmap));
            }
            this.f2240i9 = fb2;
            return this;
        }

        @NonNull
        public tl z6(long j2) {
            this.f2241j.when = j2;
            return this;
        }

        @NonNull
        public Notification zn() {
            return new androidx.core.app.y(this).zn();
        }

        @Deprecated
        public tl(@NonNull Context context) {
            this(context, null);
        }
    }
}
