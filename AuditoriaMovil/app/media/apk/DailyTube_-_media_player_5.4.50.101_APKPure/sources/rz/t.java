package rz;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f13364a;
    @Nullable

    /* renamed from: fb  reason: collision with root package name */
    public ArrayList<Uri> f13365fb;
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public ArrayList<String> f13366gv;
    @NonNull

    /* renamed from: n3  reason: collision with root package name */
    public final Intent f13367n3;
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public ArrayList<String> f13368v;
    @NonNull
    public final Context y;
    @Nullable

    /* renamed from: zn  reason: collision with root package name */
    public CharSequence f13369zn;

    public t(@NonNull Context context) {
        Activity activity;
        this.y = (Context) vl.s.fb(context);
        Intent action = new Intent().setAction("android.intent.action.SEND");
        this.f13367n3 = action;
        action.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
        action.addFlags(524288);
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                activity = null;
                break;
            }
        }
        if (activity != null) {
            ComponentName componentName = activity.getComponentName();
            this.f13367n3.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f13367n3.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
        }
    }

    @NonNull
    public t a(@Nullable Uri uri) {
        this.f13365fb = null;
        if (uri != null) {
            y(uri);
        }
        return this;
    }

    @NonNull
    public t fb(@Nullable String str) {
        this.f13367n3.setType(str);
        return this;
    }

    @NonNull
    public Intent gv() {
        ArrayList<String> arrayList = this.f13366gv;
        if (arrayList != null) {
            n3("android.intent.extra.EMAIL", arrayList);
            this.f13366gv = null;
        }
        ArrayList<String> arrayList2 = this.f13368v;
        if (arrayList2 != null) {
            n3("android.intent.extra.CC", arrayList2);
            this.f13368v = null;
        }
        ArrayList<String> arrayList3 = this.f13364a;
        if (arrayList3 != null) {
            n3("android.intent.extra.BCC", arrayList3);
            this.f13364a = null;
        }
        ArrayList<Uri> arrayList4 = this.f13365fb;
        if (arrayList4 != null && arrayList4.size() > 1) {
            this.f13367n3.setAction("android.intent.action.SEND_MULTIPLE");
            this.f13367n3.putParcelableArrayListExtra("android.intent.extra.STREAM", this.f13365fb);
            f.n3(this.f13367n3, this.f13365fb);
        } else {
            this.f13367n3.setAction("android.intent.action.SEND");
            ArrayList<Uri> arrayList5 = this.f13365fb;
            if (arrayList5 != null && !arrayList5.isEmpty()) {
                this.f13367n3.putExtra("android.intent.extra.STREAM", this.f13365fb.get(0));
                f.n3(this.f13367n3, this.f13365fb);
            } else {
                this.f13367n3.removeExtra("android.intent.extra.STREAM");
                f.zn(this.f13367n3);
            }
        }
        return this.f13367n3;
    }

    public final void n3(String str, ArrayList<String> arrayList) {
        int i;
        String[] stringArrayExtra = this.f13367n3.getStringArrayExtra(str);
        if (stringArrayExtra != null) {
            i = stringArrayExtra.length;
        } else {
            i = 0;
        }
        String[] strArr = new String[arrayList.size() + i];
        arrayList.toArray(strArr);
        if (stringArrayExtra != null) {
            System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), i);
        }
        this.f13367n3.putExtra(str, strArr);
    }

    public void s() {
        this.y.startActivity(zn());
    }

    @NonNull
    public t v(@Nullable CharSequence charSequence) {
        this.f13369zn = charSequence;
        return this;
    }

    @NonNull
    public t y(@NonNull Uri uri) {
        if (this.f13365fb == null) {
            this.f13365fb = new ArrayList<>();
        }
        this.f13365fb.add(uri);
        return this;
    }

    @NonNull
    public Intent zn() {
        return Intent.createChooser(gv(), this.f13369zn);
    }
}
