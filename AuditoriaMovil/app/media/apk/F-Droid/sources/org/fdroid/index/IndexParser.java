package org.fdroid.index;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonBuilder;
import kotlinx.serialization.json.JsonKt;
import org.fdroid.index.v1.IndexV1;
import org.fdroid.index.v2.Entry;
import org.fdroid.index.v2.IndexV2;
/* compiled from: IndexParser.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u000bH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lorg/fdroid/index/IndexParser;", "", "()V", "JSON", "Lkotlinx/serialization/json/Json;", "json", "getJson", "()Lkotlinx/serialization/json/Json;", "parseEntry", "Lorg/fdroid/index/v2/Entry;", "str", "", "parseV1", "Lorg/fdroid/index/v1/IndexV1;", "parseV2", "Lorg/fdroid/index/v2/IndexV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class IndexParser {
    public static final IndexParser INSTANCE = new IndexParser();
    private static volatile Json JSON;

    private IndexParser() {
    }

    public static final Json getJson() {
        Json Json$default;
        Json json = JSON;
        if (json == null) {
            synchronized (INSTANCE) {
                Json$default = JsonKt.Json$default(null, new Function1() { // from class: org.fdroid.index.IndexParser$json$1$1
                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((JsonBuilder) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(JsonBuilder Json) {
                        Intrinsics.checkNotNullParameter(Json, "$this$Json");
                        Json.setIgnoreUnknownKeys(true);
                    }
                }, 1, null);
            }
            return Json$default;
        }
        return json;
    }

    public static final IndexV1 parseV1(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Json json = getJson();
        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(IndexV1.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (IndexV1) json.decodeFromString(serializer, str);
    }

    public static final IndexV2 parseV2(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Json json = getJson();
        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(IndexV2.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (IndexV2) json.decodeFromString(serializer, str);
    }

    public static final Entry parseEntry(String str) {
        Intrinsics.checkNotNullParameter(str, "str");
        Json json = getJson();
        KSerializer serializer = SerializersKt.serializer(json.getSerializersModule(), Reflection.typeOf(Entry.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return (Entry) json.decodeFromString(serializer, str);
    }
}
