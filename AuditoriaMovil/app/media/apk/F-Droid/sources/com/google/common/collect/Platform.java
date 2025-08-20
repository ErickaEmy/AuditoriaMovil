package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;
/* loaded from: classes.dex */
abstract class Platform {
    private static final Logger logger = Logger.getLogger(Platform.class.getName());

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Map newHashMapWithExpectedSize(int i) {
        return Maps.newHashMapWithExpectedSize(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Set newHashSetWithExpectedSize(int i) {
        return Sets.newHashSetWithExpectedSize(i);
    }
}
