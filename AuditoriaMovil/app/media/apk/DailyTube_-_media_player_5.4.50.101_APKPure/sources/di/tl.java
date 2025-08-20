package di;

import android.net.Uri;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final /* synthetic */ class tl {
    @Nullable
    public static Uri n3(wz wzVar) {
        String n32 = wzVar.n3("exo_redir", null);
        if (n32 == null) {
            return null;
        }
        return Uri.parse(n32);
    }

    public static long y(wz wzVar) {
        return wzVar.y("exo_len", -1L);
    }
}
