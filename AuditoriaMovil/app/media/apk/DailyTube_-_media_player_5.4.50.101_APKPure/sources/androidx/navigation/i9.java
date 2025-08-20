package androidx.navigation;

import android.annotation.SuppressLint;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.c5;
import java.util.HashMap;
import java.util.Map;
@SuppressLint({"TypeParameterUnusedInFormals"})
/* loaded from: classes.dex */
public class i9 {

    /* renamed from: n3  reason: collision with root package name */
    public static final HashMap<Class<?>, String> f2813n3 = new HashMap<>();
    public final HashMap<String, c5<? extends gv>> y = new HashMap<>();

    public static boolean fb(String str) {
        if (str != null && !str.isEmpty()) {
            return true;
        }
        return false;
    }

    @NonNull
    public static String zn(@NonNull Class<? extends c5> cls) {
        HashMap<Class<?>, String> hashMap = f2813n3;
        String str = hashMap.get(cls);
        if (str == null) {
            c5.n3 n3Var = (c5.n3) cls.getAnnotation(c5.n3.class);
            if (n3Var != null) {
                str = n3Var.value();
            } else {
                str = null;
            }
            if (fb(str)) {
                hashMap.put(cls, str);
            } else {
                throw new IllegalArgumentException("No @Navigator.Name annotation found for " + cls.getSimpleName());
            }
        }
        return str;
    }

    public Map<String, c5<? extends gv>> a() {
        return this.y;
    }

    @NonNull
    public final <T extends c5<?>> T gv(@NonNull Class<T> cls) {
        return (T) v(zn(cls));
    }

    @Nullable
    public c5<? extends gv> n3(@NonNull String str, @NonNull c5<? extends gv> c5Var) {
        if (fb(str)) {
            return this.y.put(str, c5Var);
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @NonNull
    public <T extends c5<?>> T v(@NonNull String str) {
        if (fb(str)) {
            c5<? extends gv> c5Var = this.y.get(str);
            if (c5Var != null) {
                return c5Var;
            }
            throw new IllegalStateException("Could not find Navigator with name \"" + str + "\". You must call NavController.addNavigator() for each navigation type.");
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string");
    }

    @Nullable
    public final c5<? extends gv> y(@NonNull c5<? extends gv> c5Var) {
        return n3(zn(c5Var.getClass()), c5Var);
    }
}
