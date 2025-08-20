package androidx.core.app;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.core.app.NotificationCompat;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import rz.i9;
/* loaded from: classes.dex */
public class n3 {
    public static final Object y = new Object();

    /* renamed from: n3  reason: collision with root package name */
    public static final Object f2308n3 = new Object();

    public static Bundle a(i9 i9Var) {
        Bundle bundle = new Bundle();
        bundle.putString("resultKey", i9Var.c5());
        bundle.putCharSequence("label", i9Var.s());
        bundle.putCharSequenceArray("choices", i9Var.v());
        bundle.putBoolean("allowFreeFormInput", i9Var.zn());
        bundle.putBundle("extras", i9Var.fb());
        Set<String> gv2 = i9Var.gv();
        if (gv2 != null && !gv2.isEmpty()) {
            ArrayList<String> arrayList = new ArrayList<>(gv2.size());
            for (String str : gv2) {
                arrayList.add(str);
            }
            bundle.putStringArrayList("allowedDataTypes", arrayList);
        }
        return bundle;
    }

    public static Bundle[] fb(i9[] i9VarArr) {
        if (i9VarArr == null) {
            return null;
        }
        Bundle[] bundleArr = new Bundle[i9VarArr.length];
        for (int i = 0; i < i9VarArr.length; i++) {
            bundleArr[i] = a(i9VarArr[i]);
        }
        return bundleArr;
    }

    public static Bundle[] gv(Bundle bundle, String str) {
        Parcelable[] parcelableArray = bundle.getParcelableArray(str);
        if (!(parcelableArray instanceof Bundle[]) && parcelableArray != null) {
            Bundle[] bundleArr = (Bundle[]) Arrays.copyOf(parcelableArray, parcelableArray.length, Bundle[].class);
            bundle.putParcelableArray(str, bundleArr);
            return bundleArr;
        }
        return (Bundle[]) parcelableArray;
    }

    public static i9[] n3(Bundle[] bundleArr) {
        if (bundleArr == null) {
            return null;
        }
        i9[] i9VarArr = new i9[bundleArr.length];
        for (int i = 0; i < bundleArr.length; i++) {
            i9VarArr[i] = y(bundleArr[i]);
        }
        return i9VarArr;
    }

    public static Bundle v(NotificationCompat.n3 n3Var) {
        int i;
        Bundle bundle;
        Bundle bundle2 = new Bundle();
        IconCompat gv2 = n3Var.gv();
        if (gv2 != null) {
            i = gv2.tl();
        } else {
            i = 0;
        }
        bundle2.putInt("icon", i);
        bundle2.putCharSequence("title", n3Var.s());
        bundle2.putParcelable("actionIntent", n3Var.y());
        if (n3Var.zn() != null) {
            bundle = new Bundle(n3Var.zn());
        } else {
            bundle = new Bundle();
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", n3Var.n3());
        bundle2.putBundle("extras", bundle);
        bundle2.putParcelableArray("remoteInputs", fb(n3Var.v()));
        bundle2.putBoolean("showsUserInterface", n3Var.fb());
        bundle2.putInt("semanticAction", n3Var.a());
        return bundle2;
    }

    public static i9 y(Bundle bundle) {
        ArrayList<String> stringArrayList = bundle.getStringArrayList("allowedDataTypes");
        HashSet hashSet = new HashSet();
        if (stringArrayList != null) {
            Iterator<String> it = stringArrayList.iterator();
            while (it.hasNext()) {
                hashSet.add(it.next());
            }
        }
        return new i9(bundle.getString("resultKey"), bundle.getCharSequence("label"), bundle.getCharSequenceArray("choices"), bundle.getBoolean("allowFreeFormInput"), 0, bundle.getBundle("extras"), hashSet);
    }

    public static NotificationCompat.n3 zn(Bundle bundle) {
        boolean z2;
        Bundle bundle2 = bundle.getBundle("extras");
        if (bundle2 != null) {
            z2 = bundle2.getBoolean("android.support.allowGeneratedReplies", false);
        } else {
            z2 = false;
        }
        return new NotificationCompat.n3(bundle.getInt("icon"), bundle.getCharSequence("title"), (PendingIntent) bundle.getParcelable("actionIntent"), bundle.getBundle("extras"), n3(gv(bundle, "remoteInputs")), n3(gv(bundle, "dataOnlyRemoteInputs")), z2, bundle.getInt("semanticAction"), bundle.getBoolean("showsUserInterface"), false, false);
    }
}
