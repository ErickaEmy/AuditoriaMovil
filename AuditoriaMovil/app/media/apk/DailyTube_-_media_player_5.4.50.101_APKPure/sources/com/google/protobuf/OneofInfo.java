package com.google.protobuf;

import java.lang.reflect.Field;
@CheckReturnValue
/* loaded from: classes.dex */
final class OneofInfo {

    /* renamed from: n3  reason: collision with root package name */
    public final Field f6498n3;
    public final int y;

    /* renamed from: zn  reason: collision with root package name */
    public final Field f6499zn;

    public OneofInfo(int i, Field field, Field field2) {
        this.y = i;
        this.f6498n3 = field;
        this.f6499zn = field2;
    }

    public Field getCaseField() {
        return this.f6498n3;
    }

    public int getId() {
        return this.y;
    }

    public Field getValueField() {
        return this.f6499zn;
    }
}
