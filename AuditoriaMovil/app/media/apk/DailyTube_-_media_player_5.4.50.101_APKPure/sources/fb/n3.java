package fb;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fb.y;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class n3 extends y<String[], Map<String, Boolean>> {
    @NonNull
    public static Intent n3(@NonNull String[] strArr) {
        return new Intent("androidx.activity.result.contract.action.REQUEST_PERMISSIONS").putExtra("androidx.activity.result.contract.extra.PERMISSIONS", strArr);
    }

    @Override // fb.y
    @NonNull
    /* renamed from: gv */
    public Map<String, Boolean> parseResult(int i, @Nullable Intent intent) {
        boolean z2;
        if (i != -1) {
            return Collections.emptyMap();
        }
        if (intent == null) {
            return Collections.emptyMap();
        }
        String[] stringArrayExtra = intent.getStringArrayExtra("androidx.activity.result.contract.extra.PERMISSIONS");
        int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
        if (intArrayExtra != null && stringArrayExtra != null) {
            HashMap hashMap = new HashMap();
            int length = stringArrayExtra.length;
            for (int i5 = 0; i5 < length; i5++) {
                String str = stringArrayExtra[i5];
                if (intArrayExtra[i5] == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                hashMap.put(str, Boolean.valueOf(z2));
            }
            return hashMap;
        }
        return Collections.emptyMap();
    }

    @Override // fb.y
    @NonNull
    /* renamed from: y */
    public Intent createIntent(@NonNull Context context, @NonNull String[] strArr) {
        return n3(strArr);
    }

    @Override // fb.y
    @Nullable
    /* renamed from: zn */
    public y.C0100y<Map<String, Boolean>> getSynchronousResult(@NonNull Context context, @Nullable String[] strArr) {
        boolean z2;
        if (strArr != null && strArr.length != 0) {
            z.y yVar = new z.y();
            boolean z3 = true;
            for (String str : strArr) {
                if (mg.y.y(context, str) == 0) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                yVar.put(str, Boolean.valueOf(z2));
                if (!z2) {
                    z3 = false;
                }
            }
            if (z3) {
                return new y.C0100y<>(yVar);
            }
            return null;
        }
        return new y.C0100y<>(Collections.emptyMap());
    }
}
