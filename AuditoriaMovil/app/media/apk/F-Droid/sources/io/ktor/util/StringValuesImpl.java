package io.ktor.util;

import androidx.compose.foundation.ClickableElement$$ExternalSyntheticBackport0;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: StringValues.kt */
/* loaded from: classes.dex */
public abstract class StringValuesImpl implements StringValues {
    private final boolean caseInsensitiveName;
    private final Map values;

    @Override // io.ktor.util.StringValues
    public final boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public StringValuesImpl(boolean z, Map values) {
        Intrinsics.checkNotNullParameter(values, "values");
        this.caseInsensitiveName = z;
        Map caseInsensitiveMap = z ? CollectionsKt.caseInsensitiveMap() : new LinkedHashMap();
        for (Map.Entry entry : values.entrySet()) {
            String str = (String) entry.getKey();
            List list = (List) entry.getValue();
            int size = list.size();
            ArrayList arrayList = new ArrayList(size);
            for (int i = 0; i < size; i++) {
                arrayList.add((String) list.get(i));
            }
            caseInsensitiveMap.put(str, arrayList);
        }
        this.values = caseInsensitiveMap;
    }

    @Override // io.ktor.util.StringValues
    public String get(String name) {
        Object firstOrNull;
        Intrinsics.checkNotNullParameter(name, "name");
        List listForKey = listForKey(name);
        if (listForKey != null) {
            firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(listForKey);
            return (String) firstOrNull;
        }
        return null;
    }

    @Override // io.ktor.util.StringValues
    public List getAll(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return listForKey(name);
    }

    @Override // io.ktor.util.StringValues
    public Set names() {
        return CollectionsJvmKt.unmodifiable(this.values.keySet());
    }

    @Override // io.ktor.util.StringValues
    public boolean isEmpty() {
        return this.values.isEmpty();
    }

    @Override // io.ktor.util.StringValues
    public Set entries() {
        return CollectionsJvmKt.unmodifiable(this.values.entrySet());
    }

    @Override // io.ktor.util.StringValues
    public void forEach(Function2 body) {
        Intrinsics.checkNotNullParameter(body, "body");
        for (Map.Entry entry : this.values.entrySet()) {
            body.invoke((String) entry.getKey(), (List) entry.getValue());
        }
    }

    private final List listForKey(String str) {
        return (List) this.values.get(str);
    }

    public boolean equals(Object obj) {
        boolean entriesEquals;
        if (this == obj) {
            return true;
        }
        if (obj instanceof StringValues) {
            StringValues stringValues = (StringValues) obj;
            if (this.caseInsensitiveName != stringValues.getCaseInsensitiveName()) {
                return false;
            }
            entriesEquals = StringValuesKt.entriesEquals(entries(), stringValues.entries());
            return entriesEquals;
        }
        return false;
    }

    public int hashCode() {
        int entriesHashCode;
        entriesHashCode = StringValuesKt.entriesHashCode(entries(), ClickableElement$$ExternalSyntheticBackport0.m(this.caseInsensitiveName) * 31);
        return entriesHashCode;
    }
}
