package io.ktor.http;

import io.ktor.util.StringValuesImpl;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Parameters.kt */
/* loaded from: classes.dex */
public final class ParametersImpl extends StringValuesImpl implements Parameters {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ParametersImpl(Map values) {
        super(true, values);
        Intrinsics.checkNotNullParameter(values, "values");
    }

    public String toString() {
        return "Parameters " + entries();
    }
}
