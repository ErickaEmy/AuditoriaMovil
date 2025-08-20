package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Collection;
/* loaded from: classes.dex */
public abstract class Collections2 {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean safeContains(Collection collection, Object obj) {
        Preconditions.checkNotNull(collection);
        try {
            return collection.contains(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }
}
