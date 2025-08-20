package com.google.common.collect;
/* loaded from: classes.dex */
abstract class CollectPreconditions {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static int checkNonnegative(int i, String str) {
        if (i >= 0) {
            return i;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i);
    }
}
