package org.acra.util;

import android.os.Bundle;
import android.os.PersistableBundle;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: bundle.kt */
/* loaded from: classes2.dex */
public abstract class BundleKt {
    public static final PersistableBundle toPersistableBundle(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
        PersistableBundle persistableBundle = new PersistableBundle();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            if (isPersistableBundleType(obj)) {
                Intrinsics.checkNotNull(str);
                put(persistableBundle, str, obj);
            }
        }
        return persistableBundle;
    }

    private static final boolean isPersistableBundleType(Object obj) {
        return (obj instanceof PersistableBundle) || (obj instanceof Integer) || (obj instanceof int[]) || (obj instanceof Long) || (obj instanceof long[]) || (obj instanceof Double) || (obj instanceof double[]) || (obj instanceof String) || ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) || (obj instanceof Boolean) || (obj instanceof boolean[]);
    }

    private static final void put(PersistableBundle persistableBundle, String str, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("Unable to determine type of null values".toString());
        }
        if (obj instanceof Integer) {
            persistableBundle.putInt(str, ((Number) obj).intValue());
        } else if (obj instanceof int[]) {
            persistableBundle.putIntArray(str, (int[]) obj);
        } else if (obj instanceof Long) {
            persistableBundle.putLong(str, ((Number) obj).longValue());
        } else if (obj instanceof long[]) {
            persistableBundle.putLongArray(str, (long[]) obj);
        } else if (obj instanceof Double) {
            persistableBundle.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof double[]) {
            persistableBundle.putDoubleArray(str, (double[]) obj);
        } else if (obj instanceof String) {
            persistableBundle.putString(str, (String) obj);
        } else if ((obj instanceof Object[]) && (((Object[]) obj) instanceof String[])) {
            persistableBundle.putStringArray(str, (String[]) obj);
        } else if (obj instanceof Boolean) {
            persistableBundle.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof boolean[]) {
            persistableBundle.putBooleanArray(str, (boolean[]) obj);
        } else if (obj instanceof PersistableBundle) {
            persistableBundle.putAll((PersistableBundle) obj);
        } else {
            String simpleName = obj.getClass().getSimpleName();
            throw new IllegalArgumentException("Objects of type " + simpleName + " can not be put into a PersistableBundle");
        }
    }
}
