package m1;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public class ne extends IOException {
    public final boolean contentIsMalformed;
    public final int dataType;

    public ne(@Nullable String str, @Nullable Throwable th, boolean z2, int i) {
        super(str, th);
        this.contentIsMalformed = z2;
        this.dataType = i;
    }

    public static ne a(@Nullable String str, @Nullable Throwable th) {
        return new ne(str, th, false, 4);
    }

    public static ne gv(@Nullable String str, @Nullable Throwable th) {
        return new ne(str, th, true, 0);
    }

    public static ne s(@Nullable String str) {
        return new ne(str, null, false, 1);
    }

    public static ne v(@Nullable String str, @Nullable Throwable th) {
        return new ne(str, th, true, 4);
    }

    public static ne y(@Nullable String str, @Nullable Throwable th) {
        return new ne(str, th, true, 1);
    }
}
