package rb;

import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes.dex */
public final class f3 {
    public static final f3 y = new f3();

    public static final String y(String hash) {
        Intrinsics.checkNotNullParameter(hash, "hash");
        return "INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '" + hash + "')";
    }
}
