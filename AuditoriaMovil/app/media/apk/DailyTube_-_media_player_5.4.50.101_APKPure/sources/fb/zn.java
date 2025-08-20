package fb;

import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fb.y;
/* loaded from: classes.dex */
public final class zn extends y<String, Boolean> {
    @Override // fb.y
    @Nullable
    /* renamed from: n3 */
    public y.C0100y<Boolean> getSynchronousResult(@NonNull Context context, @Nullable String str) {
        if (str == null) {
            return new y.C0100y<>(Boolean.FALSE);
        }
        if (mg.y.y(context, str) == 0) {
            return new y.C0100y<>(Boolean.TRUE);
        }
        return null;
    }

    @Override // fb.y
    @NonNull
    /* renamed from: y */
    public Intent createIntent(@NonNull Context context, @NonNull String str) {
        return n3.n3(new String[]{str});
    }

    @Override // fb.y
    @NonNull
    /* renamed from: zn */
    public Boolean parseResult(int i, @Nullable Intent intent) {
        if (intent != null && i == -1) {
            int[] intArrayExtra = intent.getIntArrayExtra("androidx.activity.result.contract.extra.PERMISSION_GRANT_RESULTS");
            if (intArrayExtra != null && intArrayExtra.length != 0) {
                boolean z2 = false;
                if (intArrayExtra[0] == 0) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            }
            return Boolean.FALSE;
        }
        return Boolean.FALSE;
    }
}
