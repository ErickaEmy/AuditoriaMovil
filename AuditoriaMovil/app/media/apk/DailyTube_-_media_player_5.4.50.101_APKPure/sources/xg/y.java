package xg;

import androidx.annotation.NonNull;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import y5.co;
import y5.k5;
/* loaded from: classes.dex */
public abstract class y {
    @NonNull
    public static <T extends co & k5> y n3(@NonNull T t2) {
        return new n3(t2, t2.getViewModelStore());
    }

    @Deprecated
    public abstract void y(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void zn();
}
