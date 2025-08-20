package de1;

import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import vd1.zn;
/* loaded from: classes.dex */
public final class y {
    /* JADX WARN: Multi-variable type inference failed */
    public static final Pair<xd1.y, zn<?>> y(Pair<xd1.y, ? extends zn<?>> pair, KClass<?> clazz) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        ((zn) pair.getSecond()).zn().a(CollectionsKt.plus(((zn) pair.getSecond()).zn().v(), clazz));
        ((xd1.y) pair.getFirst()).v(td1.n3.y(clazz, ((zn) pair.getSecond()).zn().zn(), ((zn) pair.getSecond()).zn().gv()), (zn) pair.getSecond(), true);
        return pair;
    }
}
