package org.fdroid.index.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
/* compiled from: IndexV2.kt */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 &2\u00020\u0001:\u0002%&Bm\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005j\u0004\u0018\u0001`\b\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\n\u0012\u001a\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eBQ\u0012\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b\u0012\u0016\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n\u0012\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n¢\u0006\u0002\u0010\u000fJ\u0019\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\bHÆ\u0003J\u0019\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\nHÆ\u0003J\u0019\u0010\u0016\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\nHÆ\u0003JW\u0010\u0017\u001a\u00020\u00002\u0018\b\u0002\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b2\u0018\b\u0002\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n2\u0018\b\u0002\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\nHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J&\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#HÁ\u0001¢\u0006\u0002\b$R!\u0010\u000b\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R!\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R!\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005j\u0002`\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006'"}, d2 = {"Lorg/fdroid/index/v2/CategoryV2;", "", "seen1", "", "icon", "", "", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "name", "Lorg/fdroid/index/v2/LocalizedTextV2;", "description", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getDescription", "()Ljava/util/Map;", "getIcon", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class CategoryV2 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Map<String, String> description;
    private final Map<String, FileV2> icon;
    private final Map<String, String> name;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CategoryV2 copy$default(CategoryV2 categoryV2, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            map = categoryV2.icon;
        }
        if ((i & 2) != 0) {
            map2 = categoryV2.name;
        }
        if ((i & 4) != 0) {
            map3 = categoryV2.description;
        }
        return categoryV2.copy(map, map2, map3);
    }

    public final Map<String, FileV2> component1() {
        return this.icon;
    }

    public final Map<String, String> component2() {
        return this.name;
    }

    public final Map<String, String> component3() {
        return this.description;
    }

    public final CategoryV2 copy(Map<String, FileV2> icon, Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new CategoryV2(icon, name, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CategoryV2) {
            CategoryV2 categoryV2 = (CategoryV2) obj;
            return Intrinsics.areEqual(this.icon, categoryV2.icon) && Intrinsics.areEqual(this.name, categoryV2.name) && Intrinsics.areEqual(this.description, categoryV2.description);
        }
        return false;
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.name.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        Map<String, FileV2> map = this.icon;
        Map<String, String> map2 = this.name;
        Map<String, String> map3 = this.description;
        return "CategoryV2(icon=" + map + ", name=" + map2 + ", description=" + map3 + ")";
    }

    /* compiled from: IndexV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/CategoryV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/CategoryV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return CategoryV2$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, FileV2$$serializer.INSTANCE), new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer)};
    }

    public /* synthetic */ CategoryV2(int i, Map map, Map map2, Map map3, SerializationConstructorMarker serializationConstructorMarker) {
        Map<String, String> emptyMap;
        if (2 != (i & 2)) {
            PluginExceptionsKt.throwMissingFieldException(i, 2, CategoryV2$$serializer.INSTANCE.getDescriptor());
        }
        this.icon = (i & 1) == 0 ? MapsKt__MapsKt.emptyMap() : map;
        this.name = map2;
        if ((i & 4) != 0) {
            this.description = map3;
            return;
        }
        emptyMap = MapsKt__MapsKt.emptyMap();
        this.description = emptyMap;
    }

    public CategoryV2(Map<String, FileV2> icon, Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.icon = icon;
        this.name = name;
        this.description = description;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v2.CategoryV2 r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            kotlinx.serialization.KSerializer[] r0 = org.fdroid.index.v2.CategoryV2.$childSerializers
            r1 = 0
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto La
            goto L16
        La:
            java.util.Map<java.lang.String, org.fdroid.index.v2.FileV2> r2 = r4.icon
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L1d
        L16:
            r2 = r0[r1]
            java.util.Map<java.lang.String, org.fdroid.index.v2.FileV2> r3 = r4.icon
            r5.encodeSerializableElement(r6, r1, r2, r3)
        L1d:
            r1 = 1
            r2 = r0[r1]
            java.util.Map<java.lang.String, java.lang.String> r3 = r4.name
            r5.encodeSerializableElement(r6, r1, r2, r3)
            r1 = 2
            boolean r2 = r5.shouldEncodeElementDefault(r6, r1)
            if (r2 == 0) goto L2d
            goto L39
        L2d:
            java.util.Map<java.lang.String, java.lang.String> r2 = r4.description
            java.util.Map r3 = kotlin.collections.MapsKt.emptyMap()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r2 != 0) goto L40
        L39:
            r0 = r0[r1]
            java.util.Map<java.lang.String, java.lang.String> r4 = r4.description
            r5.encodeSerializableElement(r6, r1, r0, r4)
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.CategoryV2.write$Self$index_release(org.fdroid.index.v2.CategoryV2, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    public /* synthetic */ CategoryV2(Map map, Map map2, Map map3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MapsKt__MapsKt.emptyMap() : map, map2, (i & 4) != 0 ? MapsKt__MapsKt.emptyMap() : map3);
    }
}
