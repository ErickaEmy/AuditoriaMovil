package f8;

import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.Map;
/* loaded from: classes.dex */
public final class rz {
    @Nullable
    public static Pair<Long, Long> n3(com.google.android.exoplayer2.drm.gv gvVar) {
        Map<String, String> a2 = gvVar.a();
        if (a2 == null) {
            return null;
        }
        return new Pair<>(Long.valueOf(y(a2, "LicenseDurationRemaining")), Long.valueOf(y(a2, "PlaybackDurationRemaining")));
    }

    public static long y(Map<String, String> map, String str) {
        if (map != null) {
            try {
                String str2 = map.get(str);
                if (str2 != null) {
                    return Long.parseLong(str2);
                }
                return -9223372036854775807L;
            } catch (NumberFormatException unused) {
                return -9223372036854775807L;
            }
        }
        return -9223372036854775807L;
    }
}
