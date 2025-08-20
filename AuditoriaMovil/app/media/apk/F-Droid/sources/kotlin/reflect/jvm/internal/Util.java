package kotlin.reflect.jvm.internal;
/* loaded from: classes2.dex */
abstract class Util {
    public static Object getEnumConstantByName(Class cls, String str) {
        return Enum.valueOf(cls, str);
    }
}
