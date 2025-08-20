package org.acra.util;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.acra.ACRA;
import org.acra.log.ACRALog;
/* compiled from: InstanceCreator.kt */
/* loaded from: classes2.dex */
public final class InstanceCreator {
    public static final InstanceCreator INSTANCE = new InstanceCreator();

    private InstanceCreator() {
    }

    public static final Object create(Class clazz, Function0 fallback) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Object create = create(clazz);
        return create == null ? fallback.invoke() : create;
    }

    public static final Object create(Class clazz) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException e) {
            ACRALog aCRALog = ACRA.log;
            String str = ACRA.LOG_TAG;
            String name = clazz.getName();
            aCRALog.e(str, "Failed to create instance of class " + name, e);
            return null;
        } catch (InstantiationException e2) {
            ACRALog aCRALog2 = ACRA.log;
            String str2 = ACRA.LOG_TAG;
            String name2 = clazz.getName();
            aCRALog2.e(str2, "Failed to create instance of class " + name2, e2);
            return null;
        }
    }
}
