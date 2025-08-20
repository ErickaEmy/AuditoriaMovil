package androidx.navigation;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.gv;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/* loaded from: classes.dex */
public abstract class c5<D extends gv> {

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    /* loaded from: classes.dex */
    public @interface n3 {
        String value();
    }

    /* loaded from: classes.dex */
    public interface y {
    }

    @Nullable
    public Bundle gv() {
        return null;
    }

    @Nullable
    public abstract gv n3(@NonNull D d2, @Nullable Bundle bundle, @Nullable s sVar, @Nullable y yVar);

    public abstract boolean v();

    @NonNull
    public abstract D y();

    public void zn(@NonNull Bundle bundle) {
    }
}
