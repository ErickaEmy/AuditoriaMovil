package h2;

import android.content.Context;
import androidx.annotation.NonNull;
import java.util.List;
/* loaded from: classes.dex */
public interface zn<T> {
    @NonNull
    T create(@NonNull Context context);

    @NonNull
    List<Class<? extends zn<?>>> dependencies();
}
