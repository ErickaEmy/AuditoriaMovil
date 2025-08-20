package androidx.room;

import android.content.Context;
import androidx.room.RoomDatabase;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
/* compiled from: Room.kt */
/* loaded from: classes.dex */
public final class Room {
    public static final Room INSTANCE = new Room();

    private Room() {
    }

    public static final Object getGeneratedImplementation(Class klass, String suffix) {
        String replace$default;
        String str;
        Intrinsics.checkNotNullParameter(klass, "klass");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Package r0 = klass.getPackage();
        Intrinsics.checkNotNull(r0);
        String fullPackage = r0.getName();
        String canonicalName = klass.getCanonicalName();
        Intrinsics.checkNotNull(canonicalName);
        Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
        if (fullPackage.length() != 0) {
            canonicalName = canonicalName.substring(fullPackage.length() + 1);
            Intrinsics.checkNotNullExpressionValue(canonicalName, "this as java.lang.String).substring(startIndex)");
        }
        String str2 = canonicalName;
        StringBuilder sb = new StringBuilder();
        replace$default = StringsKt__StringsJVMKt.replace$default(str2, (char) CoreConstants.DOT, '_', false, 4, (Object) null);
        sb.append(replace$default);
        sb.append(suffix);
        String sb2 = sb.toString();
        try {
            if (fullPackage.length() == 0) {
                str = sb2;
            } else {
                str = fullPackage + CoreConstants.DOT + sb2;
            }
            Class<?> cls = Class.forName(str, true, klass.getClassLoader());
            Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of androidx.room.Room.getGeneratedImplementation>");
            return cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (ClassNotFoundException unused) {
            throw new RuntimeException("Cannot find implementation for " + klass.getCanonicalName() + ". " + sb2 + " does not exist");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("Cannot access the constructor " + klass.getCanonicalName());
        } catch (InstantiationException unused3) {
            throw new RuntimeException("Failed to create an instance of " + klass.getCanonicalName());
        }
    }

    public static final RoomDatabase.Builder inMemoryDatabaseBuilder(Context context, Class klass) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(klass, "klass");
        return new RoomDatabase.Builder(context, klass, null);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0020  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final androidx.room.RoomDatabase.Builder databaseBuilder(android.content.Context r2, java.lang.Class r3, java.lang.String r4) {
        /*
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "klass"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            r0 = 1
            if (r4 == 0) goto L16
            boolean r1 = kotlin.text.StringsKt.isBlank(r4)
            if (r1 == 0) goto L14
            goto L16
        L14:
            r1 = 0
            goto L17
        L16:
            r1 = r0
        L17:
            r0 = r0 ^ r1
            if (r0 == 0) goto L20
            androidx.room.RoomDatabase$Builder r0 = new androidx.room.RoomDatabase$Builder
            r0.<init>(r2, r3, r4)
            return r0
        L20:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r3 = "Cannot build a database with null or empty name. If you are trying to create an in memory database, use Room.inMemoryDatabaseBuilder"
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.Room.databaseBuilder(android.content.Context, java.lang.Class, java.lang.String):androidx.room.RoomDatabase$Builder");
    }
}
