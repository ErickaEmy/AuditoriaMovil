package io.ktor.util;

import java.util.List;
import java.util.Set;
/* compiled from: StringValues.kt */
/* loaded from: classes.dex */
public interface StringValuesBuilder {
    void append(String str, String str2);

    void appendAll(StringValues stringValues);

    void appendAll(String str, Iterable iterable);

    void clear();

    Set entries();

    List getAll(String str);

    boolean getCaseInsensitiveName();

    boolean isEmpty();

    Set names();
}
