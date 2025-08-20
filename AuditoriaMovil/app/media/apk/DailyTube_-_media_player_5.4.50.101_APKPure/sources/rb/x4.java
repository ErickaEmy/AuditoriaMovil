package rb;

import android.content.Context;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rb.i4;
/* loaded from: classes.dex */
public final class x4 {
    public static final x4 y = new x4();

    public static final <T, C> T n3(Class<C> klass, String suffix) {
        String str;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Package r1 = klass.getPackage();
        Intrinsics.checkNotNull(r1);
        String fullPackage = r1.getName();
        String canonicalName = klass.getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            Intrinsics.checkNotNullExpressionValue(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = canonicalName;
        String str3 = StringsKt.replace$default(str2, '.', '_', false, 4, (Object) null) + suffix;
        try {
            if (fullPackage.length() == 0) {
                str = str3;
            } else {
                str = fullPackage + '.' + str3;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return (T) cls.newInstance();
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + str3 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass + ".canonicalName");
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass + ".canonicalName");
        }
    }

    public static final <T extends i4> i4.y<T> y(Context context, Class<T> klass, String str) {
        boolean z2;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        if (str != null && !StringsKt.isBlank(str)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (!z2) {
            return new i4.y<>(context, klass, str);
        }
        throw new IllegalArgumentException("Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder");
    }

    public static final <T extends i4> i4.y<T> zn(Context context, Class<T> klass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return new i4.y<>(context, klass, null);
    }
}
