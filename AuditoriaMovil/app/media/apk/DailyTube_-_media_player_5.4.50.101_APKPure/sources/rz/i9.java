package rz;

import android.app.RemoteInput;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class i9 {

    /* renamed from: a  reason: collision with root package name */
    public final Bundle f13356a;

    /* renamed from: fb  reason: collision with root package name */
    public final Set<String> f13357fb;

    /* renamed from: gv  reason: collision with root package name */
    public final boolean f13358gv;

    /* renamed from: n3  reason: collision with root package name */
    public final CharSequence f13359n3;

    /* renamed from: v  reason: collision with root package name */
    public final int f13360v;
    public final String y;

    /* renamed from: zn  reason: collision with root package name */
    public final CharSequence[] f13361zn;

    /* loaded from: classes.dex */
    public static class n3 {
        public static RemoteInput.Builder gv(RemoteInput.Builder builder, String str, boolean z2) {
            return builder.setAllowDataType(str, z2);
        }

        public static Set<String> n3(Object obj) {
            return ((RemoteInput) obj).getAllowedDataTypes();
        }

        public static void y(i9 i9Var, Intent intent, Map<String, Uri> map) {
            RemoteInput.addDataResultToIntent(i9.y(i9Var), intent, map);
        }

        public static Map<String, Uri> zn(Intent intent, String str) {
            return RemoteInput.getDataResultsFromIntent(intent, str);
        }
    }

    /* loaded from: classes.dex */
    public static class y {
        public static RemoteInput n3(i9 i9Var) {
            Set<String> gv2;
            RemoteInput.Builder addExtras = new RemoteInput.Builder(i9Var.c5()).setLabel(i9Var.s()).setChoices(i9Var.v()).setAllowFreeFormInput(i9Var.zn()).addExtras(i9Var.fb());
            if (Build.VERSION.SDK_INT >= 26 && (gv2 = i9Var.gv()) != null) {
                for (String str : gv2) {
                    n3.gv(addExtras, str, true);
                }
            }
            if (Build.VERSION.SDK_INT >= 29) {
                zn.n3(addExtras, i9Var.a());
            }
            return addExtras.build();
        }

        public static void y(Object obj, Intent intent, Bundle bundle) {
            RemoteInput.addResultsToIntent((RemoteInput[]) obj, intent, bundle);
        }

        public static Bundle zn(Intent intent) {
            return RemoteInput.getResultsFromIntent(intent);
        }
    }

    /* loaded from: classes.dex */
    public static class zn {
        public static RemoteInput.Builder n3(RemoteInput.Builder builder, int i) {
            return builder.setEditChoicesBeforeSending(i);
        }

        public static int y(Object obj) {
            return ((RemoteInput) obj).getEditChoicesBeforeSending();
        }
    }

    public i9(String str, CharSequence charSequence, CharSequence[] charSequenceArr, boolean z2, int i, Bundle bundle, Set<String> set) {
        this.y = str;
        this.f13359n3 = charSequence;
        this.f13361zn = charSequenceArr;
        this.f13358gv = z2;
        this.f13360v = i;
        this.f13356a = bundle;
        this.f13357fb = set;
        if (a() == 2 && !zn()) {
            throw new IllegalArgumentException("setEditChoicesBeforeSending requires setAllowFreeFormInput");
        }
    }

    public static RemoteInput[] n3(i9[] i9VarArr) {
        if (i9VarArr == null) {
            return null;
        }
        RemoteInput[] remoteInputArr = new RemoteInput[i9VarArr.length];
        for (int i = 0; i < i9VarArr.length; i++) {
            remoteInputArr[i] = y(i9VarArr[i]);
        }
        return remoteInputArr;
    }

    public static RemoteInput y(i9 i9Var) {
        return y.n3(i9Var);
    }

    public int a() {
        return this.f13360v;
    }

    @NonNull
    public String c5() {
        return this.y;
    }

    @NonNull
    public Bundle fb() {
        return this.f13356a;
    }

    @Nullable
    public Set<String> gv() {
        return this.f13357fb;
    }

    public boolean i9() {
        if (!zn() && ((v() == null || v().length == 0) && gv() != null && !gv().isEmpty())) {
            return true;
        }
        return false;
    }

    @Nullable
    public CharSequence s() {
        return this.f13359n3;
    }

    @Nullable
    public CharSequence[] v() {
        return this.f13361zn;
    }

    public boolean zn() {
        return this.f13358gv;
    }
}
