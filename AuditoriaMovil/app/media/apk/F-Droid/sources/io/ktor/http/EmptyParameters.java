package io.ktor.http;

import io.ktor.http.Parameters;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt__SetsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Parameters.kt */
/* loaded from: classes.dex */
public final class EmptyParameters implements Parameters {
    public static final EmptyParameters INSTANCE = new EmptyParameters();

    private EmptyParameters() {
    }

    @Override // io.ktor.util.StringValues
    public List getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return null;
    }

    @Override // io.ktor.util.StringValues
    public boolean getCaseInsensitiveName() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return true;
    }

    @Override // io.ktor.util.StringValues
    public void forEach(Function2 function2) {
        Parameters.DefaultImpls.forEach(this, function2);
    }

    @Override // io.ktor.util.StringValues
    public Set names() {
        Set emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    @Override // io.ktor.util.StringValues
    public Set entries() {
        Set emptySet;
        emptySet = SetsKt__SetsKt.emptySet();
        return emptySet;
    }

    public String toString() {
        return "Parameters " + entries();
    }

    public boolean equals(Object obj) {
        return (obj instanceof Parameters) && ((Parameters) obj).isEmpty();
    }
}
