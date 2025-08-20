package io.ktor.http;

import io.ktor.util.StringValues;
import io.ktor.util.StringValuesBuilder;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: UrlDecodedParametersBuilder.kt */
/* loaded from: classes.dex */
public abstract class UrlDecodedParametersBuilderKt {
    public static final /* synthetic */ void access$appendAllEncoded(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        appendAllEncoded(stringValuesBuilder, stringValues);
    }

    public static final Parameters decodeParameters(StringValuesBuilder parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        appendAllDecoded(ParametersBuilder$default, parameters);
        return ParametersBuilder$default.build();
    }

    public static final ParametersBuilder encodeParameters(StringValues parameters) {
        Intrinsics.checkNotNullParameter(parameters, "parameters");
        ParametersBuilder ParametersBuilder$default = ParametersKt.ParametersBuilder$default(0, 1, null);
        appendAllEncoded(ParametersBuilder$default, parameters);
        return ParametersBuilder$default;
    }

    private static final void appendAllDecoded(StringValuesBuilder stringValuesBuilder, StringValuesBuilder stringValuesBuilder2) {
        int collectionSizeOrDefault;
        for (String str : stringValuesBuilder2.names()) {
            List<String> all = stringValuesBuilder2.getAll(str);
            if (all == null) {
                all = CollectionsKt__CollectionsKt.emptyList();
            }
            String decodeURLQueryComponent$default = CodecsKt.decodeURLQueryComponent$default(str, 0, 0, false, null, 15, null);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(all, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str2 : all) {
                arrayList.add(CodecsKt.decodeURLQueryComponent$default(str2, 0, 0, true, null, 11, null));
            }
            stringValuesBuilder.appendAll(decodeURLQueryComponent$default, arrayList);
        }
    }

    public static final void appendAllEncoded(StringValuesBuilder stringValuesBuilder, StringValues stringValues) {
        int collectionSizeOrDefault;
        for (String str : stringValues.names()) {
            List<String> all = stringValues.getAll(str);
            if (all == null) {
                all = CollectionsKt__CollectionsKt.emptyList();
            }
            String encodeURLParameter$default = CodecsKt.encodeURLParameter$default(str, false, 1, null);
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(all, 10);
            ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
            for (String str2 : all) {
                arrayList.add(CodecsKt.encodeURLParameterValue(str2));
            }
            stringValuesBuilder.appendAll(encodeURLParameter$default, arrayList);
        }
    }
}
