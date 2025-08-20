package io.ktor.util;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AttributesJvm.kt */
/* loaded from: classes.dex */
final class HashMapAttributes extends AttributesJvmBase {
    private final Map map = new HashMap();

    @Override // io.ktor.util.AttributesJvmBase
    protected Map getMap() {
        return this.map;
    }

    @Override // io.ktor.util.Attributes
    public Object computeIfAbsent(AttributeKey key, Function0 block) {
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(block, "block");
        Object obj = getMap().get(key);
        if (obj != null) {
            return obj;
        }
        Object invoke = block.invoke();
        Object put = getMap().put(key, invoke);
        if (put != null) {
            invoke = put;
        }
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type T of io.ktor.util.HashMapAttributes.computeIfAbsent");
        return invoke;
    }
}
