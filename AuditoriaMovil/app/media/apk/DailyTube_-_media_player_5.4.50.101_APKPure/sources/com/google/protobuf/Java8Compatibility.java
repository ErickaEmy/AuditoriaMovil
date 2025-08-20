package com.google.protobuf;

import java.nio.Buffer;
/* loaded from: classes.dex */
final class Java8Compatibility {
    public static void gv(Buffer buffer, int i) {
        buffer.position(i);
    }

    public static void n3(Buffer buffer, int i) {
        buffer.limit(i);
    }

    public static void v(Buffer buffer) {
        buffer.reset();
    }

    public static void y(Buffer buffer) {
        buffer.clear();
    }

    public static void zn(Buffer buffer) {
        buffer.mark();
    }
}
