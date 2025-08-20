package org.fdroid.index.v1;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
/* compiled from: PackageV1.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\r\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\bJ$\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0016"}, d2 = {"Lorg/fdroid/index/v1/PermissionV1;", "", "name", "", "maxSdk", "", "(Ljava/lang/String;Ljava/lang/Integer;)V", "getMaxSdk", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "(Ljava/lang/String;Ljava/lang/Integer;)Lorg/fdroid/index/v1/PermissionV1;", "equals", "", "other", "hashCode", "toString", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable(with = PermissionV1Serializer.class)
/* loaded from: classes2.dex */
public final class PermissionV1 {
    public static final Companion Companion = new Companion(null);
    private final Integer maxSdk;
    private final String name;

    public static /* synthetic */ PermissionV1 copy$default(PermissionV1 permissionV1, String str, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            str = permissionV1.name;
        }
        if ((i & 2) != 0) {
            num = permissionV1.maxSdk;
        }
        return permissionV1.copy(str, num);
    }

    public final String component1() {
        return this.name;
    }

    public final Integer component2() {
        return this.maxSdk;
    }

    public final PermissionV1 copy(String name, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        return new PermissionV1(name, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PermissionV1) {
            PermissionV1 permissionV1 = (PermissionV1) obj;
            return Intrinsics.areEqual(this.name, permissionV1.name) && Intrinsics.areEqual(this.maxSdk, permissionV1.maxSdk);
        }
        return false;
    }

    public final Integer getMaxSdk() {
        return this.maxSdk;
    }

    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        Integer num = this.maxSdk;
        return hashCode + (num == null ? 0 : num.hashCode());
    }

    public String toString() {
        String str = this.name;
        Integer num = this.maxSdk;
        return "PermissionV1(name=" + str + ", maxSdk=" + num + ")";
    }

    /* compiled from: PackageV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/PermissionV1$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/PermissionV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return new PermissionV1Serializer();
        }
    }

    public PermissionV1(String name, Integer num) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.maxSdk = num;
    }

    public /* synthetic */ PermissionV1(String str, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : num);
    }
}
