package mt;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.LocaleList;
import android.text.TextUtils;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import mt.y;
/* loaded from: classes.dex */
public final class gv {
    @Nullable

    /* renamed from: n3  reason: collision with root package name */
    public final Bundle f11534n3;
    @NonNull
    public final Intent y;

    /* loaded from: classes.dex */
    public static class y {
        @Nullable
        public static String y() {
            LocaleList adjustedDefault = LocaleList.getAdjustedDefault();
            if (adjustedDefault.size() > 0) {
                return adjustedDefault.get(0).toLanguageTag();
            }
            return null;
        }
    }

    public gv(@NonNull Intent intent, @Nullable Bundle bundle) {
        this.y = intent;
        this.f11534n3 = bundle;
    }

    public void y(@NonNull Context context, @NonNull Uri uri) {
        this.y.setData(uri);
        mg.y.xc(context, this.y, this.f11534n3);
    }

    /* loaded from: classes.dex */
    public static final class n3 {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public SparseArray<Bundle> f11535a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public Bundle f11537fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public Bundle f11538gv;
        @Nullable

        /* renamed from: v  reason: collision with root package name */
        public ArrayList<Bundle> f11541v;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public ArrayList<Bundle> f11542zn;
        public final Intent y = new Intent("android.intent.action.VIEW");

        /* renamed from: n3  reason: collision with root package name */
        public final y.C0156y f11539n3 = new y.C0156y();

        /* renamed from: s  reason: collision with root package name */
        public int f11540s = 0;

        /* renamed from: c5  reason: collision with root package name */
        public boolean f11536c5 = true;

        public n3() {
        }

        @NonNull
        public n3 a(int i) {
            if (i >= 0 && i <= 2) {
                this.f11540s = i;
                if (i == 1) {
                    this.y.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", true);
                } else if (i == 2) {
                    this.y.putExtra("android.support.customtabs.extra.SHARE_MENU_ITEM", false);
                } else {
                    this.y.removeExtra("android.support.customtabs.extra.SHARE_MENU_ITEM");
                }
                return this;
            }
            throw new IllegalArgumentException("Invalid value for the shareState argument");
        }

        @NonNull
        public n3 fb(boolean z2) {
            this.y.putExtra("android.support.customtabs.extra.ENABLE_URLBAR_HIDING", z2);
            return this;
        }

        @NonNull
        public n3 gv(@NonNull c5 c5Var) {
            this.y.setPackage(c5Var.a().getPackageName());
            v(c5Var.v(), c5Var.fb());
            return this;
        }

        public final void n3() {
            Bundle bundle;
            String y = y.y();
            if (!TextUtils.isEmpty(y)) {
                if (this.y.hasExtra("com.android.browser.headers")) {
                    bundle = this.y.getBundleExtra("com.android.browser.headers");
                } else {
                    bundle = new Bundle();
                }
                if (!bundle.containsKey("Accept-Language")) {
                    bundle.putString("Accept-Language", y);
                    this.y.putExtra("com.android.browser.headers", bundle);
                }
            }
        }

        public final void v(@Nullable IBinder iBinder, @Nullable PendingIntent pendingIntent) {
            Bundle bundle = new Bundle();
            rz.a.n3(bundle, "android.support.customtabs.extra.SESSION", iBinder);
            if (pendingIntent != null) {
                bundle.putParcelable("android.support.customtabs.extra.SESSION_ID", pendingIntent);
            }
            this.y.putExtras(bundle);
        }

        @NonNull
        public gv y() {
            if (!this.y.hasExtra("android.support.customtabs.extra.SESSION")) {
                v(null, null);
            }
            ArrayList<Bundle> arrayList = this.f11542zn;
            if (arrayList != null) {
                this.y.putParcelableArrayListExtra("android.support.customtabs.extra.MENU_ITEMS", arrayList);
            }
            ArrayList<Bundle> arrayList2 = this.f11541v;
            if (arrayList2 != null) {
                this.y.putParcelableArrayListExtra("android.support.customtabs.extra.TOOLBAR_ITEMS", arrayList2);
            }
            this.y.putExtra("android.support.customtabs.extra.EXTRA_ENABLE_INSTANT_APPS", this.f11536c5);
            this.y.putExtras(this.f11539n3.y().y());
            Bundle bundle = this.f11537fb;
            if (bundle != null) {
                this.y.putExtras(bundle);
            }
            if (this.f11535a != null) {
                Bundle bundle2 = new Bundle();
                bundle2.putSparseParcelableArray("androidx.browser.customtabs.extra.COLOR_SCHEME_PARAMS", this.f11535a);
                this.y.putExtras(bundle2);
            }
            this.y.putExtra("androidx.browser.customtabs.extra.SHARE_STATE", this.f11540s);
            if (Build.VERSION.SDK_INT >= 24) {
                n3();
            }
            return new gv(this.y, this.f11538gv);
        }

        @NonNull
        public n3 zn(@NonNull mt.y yVar) {
            this.f11537fb = yVar.y();
            return this;
        }

        public n3(@Nullable c5 c5Var) {
            if (c5Var != null) {
                gv(c5Var);
            }
        }
    }
}
