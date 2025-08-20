package l;

import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public abstract class c5 {
    public static final String y = f.a("InputMerger");

    public static c5 y(String str) {
        try {
            return (c5) Class.forName(str).newInstance();
        } catch (Exception e2) {
            f zn2 = f.zn();
            String str2 = y;
            zn2.n3(str2, "Trouble instantiating + " + str, e2);
            return null;
        }
    }

    @NonNull
    public abstract androidx.work.n3 n3(@NonNull List<androidx.work.n3> list);
}
