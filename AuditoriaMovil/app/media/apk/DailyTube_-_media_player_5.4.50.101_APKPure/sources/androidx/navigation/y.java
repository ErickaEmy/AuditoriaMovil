package androidx.navigation;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.c5;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@c5.n3("activity")
/* loaded from: classes.dex */
public class y extends c5<C0022y> {

    /* renamed from: n3  reason: collision with root package name */
    public Activity f3011n3;
    public Context y;

    /* loaded from: classes.dex */
    public static final class n3 implements c5.y {
        public final int y;

        public int n3() {
            return this.y;
        }

        @Nullable
        public rz.zn y() {
            return null;
        }
    }

    /* renamed from: androidx.navigation.y$y  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0022y extends gv {

        /* renamed from: r  reason: collision with root package name */
        public String f3012r;

        /* renamed from: z  reason: collision with root package name */
        public Intent f3013z;

        public C0022y(@NonNull c5<? extends C0022y> c5Var) {
            super(c5Var);
        }

        @NonNull
        public final C0022y c(@Nullable ComponentName componentName) {
            if (this.f3013z == null) {
                this.f3013z = new Intent();
            }
            this.f3013z.setComponent(componentName);
            return this;
        }

        @NonNull
        public final C0022y d0(@Nullable Uri uri) {
            if (this.f3013z == null) {
                this.f3013z = new Intent();
            }
            this.f3013z.setData(uri);
            return this;
        }

        @Nullable
        public final Intent f3() {
            return this.f3013z;
        }

        @NonNull
        public final C0022y fh(@Nullable String str) {
            this.f3012r = str;
            return this;
        }

        @Nullable
        public final String i4() {
            return this.f3012r;
        }

        @NonNull
        public final C0022y n(@Nullable String str) {
            if (this.f3013z == null) {
                this.f3013z = new Intent();
            }
            this.f3013z.setAction(str);
            return this;
        }

        @Nullable
        public final String r() {
            Intent intent = this.f3013z;
            if (intent == null) {
                return null;
            }
            return intent.getAction();
        }

        @NonNull
        public final C0022y rz(@Nullable String str) {
            if (this.f3013z == null) {
                this.f3013z = new Intent();
            }
            this.f3013z.setPackage(str);
            return this;
        }

        @Override // androidx.navigation.gv
        @NonNull
        public String toString() {
            ComponentName x42 = x4();
            StringBuilder sb = new StringBuilder();
            sb.append(super.toString());
            if (x42 != null) {
                sb.append(" class=");
                sb.append(x42.getClassName());
            } else {
                String r2 = r();
                if (r2 != null) {
                    sb.append(" action=");
                    sb.append(r2);
                }
            }
            return sb.toString();
        }

        @Nullable
        public final ComponentName x4() {
            Intent intent = this.f3013z;
            if (intent == null) {
                return null;
            }
            return intent.getComponent();
        }

        @Override // androidx.navigation.gv
        public void xc(@NonNull Context context, @NonNull AttributeSet attributeSet) {
            super.xc(context, attributeSet);
            TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, R$styleable.y);
            String string = obtainAttributes.getString(R$styleable.f2692a);
            if (string != null) {
                string = string.replace("${applicationId}", context.getPackageName());
            }
            rz(string);
            String string2 = obtainAttributes.getString(R$styleable.f2700n3);
            if (string2 != null) {
                if (string2.charAt(0) == '.') {
                    string2 = context.getPackageName() + string2;
                }
                c(new ComponentName(context, string2));
            }
            n(obtainAttributes.getString(R$styleable.f2710zn));
            String string3 = obtainAttributes.getString(R$styleable.f2697gv);
            if (string3 != null) {
                d0(Uri.parse(string3));
            }
            fh(obtainAttributes.getString(R$styleable.f2705v));
            obtainAttributes.recycle();
        }

        @Override // androidx.navigation.gv
        public boolean z() {
            return false;
        }
    }

    public y(@NonNull Context context) {
        this.y = context;
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                this.f3011n3 = (Activity) context;
                return;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
    }

    @Override // androidx.navigation.c5
    @NonNull
    /* renamed from: a */
    public C0022y y() {
        return new C0022y(this);
    }

    @NonNull
    public final Context fb() {
        return this.y;
    }

    @Override // androidx.navigation.c5
    @Nullable
    /* renamed from: s */
    public gv n3(@NonNull C0022y c0022y, @Nullable Bundle bundle, @Nullable s sVar, @Nullable c5.y yVar) {
        Intent intent;
        int intExtra;
        if (c0022y.f3() != null) {
            Intent intent2 = new Intent(c0022y.f3());
            if (bundle != null) {
                intent2.putExtras(bundle);
                String i42 = c0022y.i4();
                if (!TextUtils.isEmpty(i42)) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(i42);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(bundle.get(group).toString()));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + i42);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            boolean z2 = yVar instanceof n3;
            if (z2) {
                intent2.addFlags(((n3) yVar).n3());
            }
            if (!(this.y instanceof Activity)) {
                intent2.addFlags(268435456);
            }
            if (sVar != null && sVar.fb()) {
                intent2.addFlags(536870912);
            }
            Activity activity = this.f3011n3;
            if (activity != null && (intent = activity.getIntent()) != null && (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) != 0) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", c0022y.f());
            Resources resources = fb().getResources();
            if (sVar != null) {
                int zn2 = sVar.zn();
                int gv2 = sVar.gv();
                if ((zn2 > 0 && resources.getResourceTypeName(zn2).equals("animator")) || (gv2 > 0 && resources.getResourceTypeName(gv2).equals("animator"))) {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(zn2) + " and popExit resource " + resources.getResourceName(gv2) + "when launching " + c0022y);
                } else {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", zn2);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", gv2);
                }
            }
            if (z2) {
                ((n3) yVar).y();
                this.y.startActivity(intent2);
            } else {
                this.y.startActivity(intent2);
            }
            if (sVar != null && this.f3011n3 != null) {
                int y = sVar.y();
                int n32 = sVar.n3();
                if ((y > 0 && resources.getResourceTypeName(y).equals("animator")) || (n32 > 0 && resources.getResourceTypeName(n32).equals("animator"))) {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(y) + " and exit resource " + resources.getResourceName(n32) + "when launching " + c0022y);
                    return null;
                } else if (y >= 0 || n32 >= 0) {
                    this.f3011n3.overridePendingTransition(Math.max(y, 0), Math.max(n32, 0));
                    return null;
                } else {
                    return null;
                }
            }
            return null;
        }
        throw new IllegalStateException("Destination " + c0022y.f() + " does not have an Intent set.");
    }

    @Override // androidx.navigation.c5
    public boolean v() {
        Activity activity = this.f3011n3;
        if (activity != null) {
            activity.finish();
            return true;
        }
        return false;
    }
}
