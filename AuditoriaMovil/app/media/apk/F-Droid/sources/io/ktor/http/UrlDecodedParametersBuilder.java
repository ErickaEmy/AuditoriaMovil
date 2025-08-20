package io.ktor.http;

import io.ktor.util.StringValues;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes.dex */
public final class UrlDecodedParametersBuilder implements ParametersBuilder {
    private final boolean caseInsensitiveName;
    private final ParametersBuilder encodedParametersBuilder;

    @Override // io.ktor.util.StringValuesBuilder
    public boolean getCaseInsensitiveName() {
        return this.caseInsensitiveName;
    }

    public UrlDecodedParametersBuilder(ParametersBuilder encodedParametersBuilder) {
        Intrinsics.checkNotNullParameter(encodedParametersBuilder, "encodedParametersBuilder");
        this.encodedParametersBuilder = encodedParametersBuilder;
        this.caseInsensitiveName = encodedParametersBuilder.getCaseInsensitiveName();
    }

    @Override // io.ktor.http.ParametersBuilder
    public Parameters build() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public List getAll(String name) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(name, "name");
        ArrayList arrayList = null;
        List<String> all = this.encodedParametersBuilder.getAll(CodecsKt.encodeURLParameter$default(name, false, 1, null));
        if (all != null) {
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(all, 10);
            arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str : all) {
                arrayList.add(CodecsKt.decodeURLQueryComponent$default(str, 0, 0, true, null, 11, null));
            }
        }
        return arrayList;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set names() {
        int collectionSizeOrDefault;
        Set set;
        Set<String> names = this.encodedParametersBuilder.names();
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(names, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        for (String str : names) {
            arrayList.add(CodecsKt.decodeURLQueryComponent$default(str, 0, 0, false, null, 15, null));
        }
        set = CollectionsKt___CollectionsKt.toSet(arrayList);
        return set;
    }

    @Override // io.ktor.util.StringValuesBuilder
    public boolean isEmpty() {
        return this.encodedParametersBuilder.isEmpty();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public Set entries() {
        return UrlDecodedParametersBuilderKt.decodeParameters(this.encodedParametersBuilder).entries();
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void append(String name, String value) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        this.encodedParametersBuilder.append(CodecsKt.encodeURLParameter$default(name, false, 1, null), CodecsKt.encodeURLParameterValue(value));
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(StringValues stringValues) {
        Intrinsics.checkNotNullParameter(stringValues, "stringValues");
        UrlDecodedParametersBuilderKt.access$appendAllEncoded(this.encodedParametersBuilder, stringValues);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void appendAll(String name, Iterable values) {
        int collectionSizeOrDefault;
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(values, "values");
        ParametersBuilder parametersBuilder = this.encodedParametersBuilder;
        String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(name, false, 1, null);
        collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(values, 10);
        ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
        Iterator it = values.iterator();
        while (it.hasNext()) {
            arrayList.add(CodecsKt.encodeURLParameterValue((String) it.next()));
        }
        parametersBuilder.appendAll(encodeURLParameter$default, arrayList);
    }

    @Override // io.ktor.util.StringValuesBuilder
    public void clear() {
        this.encodedParametersBuilder.clear();
    }
}
