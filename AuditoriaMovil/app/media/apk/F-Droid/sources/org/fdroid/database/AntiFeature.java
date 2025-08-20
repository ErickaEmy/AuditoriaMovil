package org.fdroid.database;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.fdroid.index.v2.FileV2;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0087\b\u0018\u0000 '2\u00020\u0001:\u0001'B_\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0016\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t\u0012\u0016\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000b\u0012\u0016\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000b¢\u0006\u0002\u0010\rJ\u000e\u0010\u0016\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0017J\u000e\u0010\u0018\u001a\u00020\u0005HÀ\u0003¢\u0006\u0002\b\u0019J\u0019\u0010\u001a\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tHÆ\u0003J\u001e\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000bHÀ\u0003¢\u0006\u0002\b\u001cJ\u001e\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000bHÀ\u0003¢\u0006\u0002\b\u001eJk\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0018\b\u0002\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000b2\u0018\b\u0002\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000bHÆ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\u0005HÖ\u0001R$\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR$\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007j\u0002`\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R$\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007j\u0002`\u000bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lorg/fdroid/database/AntiFeature;", "Lorg/fdroid/database/RepoAttribute;", "repoId", "", "id", "", "icon", "", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "name", "Lorg/fdroid/index/v2/LocalizedTextV2;", "description", "(JLjava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getDescription$database_release", "()Ljava/util/Map;", "getIcon", "getId$database_release", "()Ljava/lang/String;", "getName$database_release", "getRepoId$database_release", "()J", "component1", "component1$database_release", "component2", "component2$database_release", "component3", "component4", "component4$database_release", "component5", "component5$database_release", "copy", "equals", "", "other", "", "hashCode", "", "toString", "Companion", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AntiFeature extends RepoAttribute {
    public static final Companion Companion = new Companion(null);
    public static final String TABLE = "AntiFeature";
    private final Map<String, String> description;
    private final Map<String, FileV2> icon;
    private final String id;
    private final Map<String, String> name;
    private final long repoId;

    /* compiled from: Repository.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/fdroid/database/AntiFeature$Companion;", "", "()V", "TABLE", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public static /* synthetic */ AntiFeature copy$default(AntiFeature antiFeature, long j, String str, Map map, Map map2, Map map3, int i, Object obj) {
        if ((i & 1) != 0) {
            j = antiFeature.repoId;
        }
        long j2 = j;
        if ((i & 2) != 0) {
            str = antiFeature.id;
        }
        String str2 = str;
        Map<String, FileV2> map4 = map;
        if ((i & 4) != 0) {
            map4 = antiFeature.icon;
        }
        Map map5 = map4;
        Map<String, String> map6 = map2;
        if ((i & 8) != 0) {
            map6 = antiFeature.name;
        }
        Map map7 = map6;
        Map<String, String> map8 = map3;
        if ((i & 16) != 0) {
            map8 = antiFeature.description;
        }
        return antiFeature.copy(j2, str2, map5, map7, map8);
    }

    public final long component1$database_release() {
        return this.repoId;
    }

    public final String component2$database_release() {
        return this.id;
    }

    public final Map<String, FileV2> component3() {
        return this.icon;
    }

    public final Map<String, String> component4$database_release() {
        return this.name;
    }

    public final Map<String, String> component5$database_release() {
        return this.description;
    }

    public final AntiFeature copy(long j, String id, Map<String, FileV2> icon, Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        return new AntiFeature(j, id, icon, name, description);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AntiFeature) {
            AntiFeature antiFeature = (AntiFeature) obj;
            return this.repoId == antiFeature.repoId && Intrinsics.areEqual(this.id, antiFeature.id) && Intrinsics.areEqual(this.icon, antiFeature.icon) && Intrinsics.areEqual(this.name, antiFeature.name) && Intrinsics.areEqual(this.description, antiFeature.description);
        }
        return false;
    }

    @Override // org.fdroid.database.RepoAttribute
    public Map<String, String> getDescription$database_release() {
        return this.description;
    }

    @Override // org.fdroid.database.RepoAttribute
    public Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final String getId$database_release() {
        return this.id;
    }

    @Override // org.fdroid.database.RepoAttribute
    public Map<String, String> getName$database_release() {
        return this.name;
    }

    public final long getRepoId$database_release() {
        return this.repoId;
    }

    public int hashCode() {
        return (((((((FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.repoId) * 31) + this.id.hashCode()) * 31) + this.icon.hashCode()) * 31) + this.name.hashCode()) * 31) + this.description.hashCode();
    }

    public String toString() {
        long j = this.repoId;
        String str = this.id;
        Map<String, FileV2> map = this.icon;
        Map<String, String> map2 = this.name;
        Map<String, String> map3 = this.description;
        return "AntiFeature(repoId=" + j + ", id=" + str + ", icon=" + map + ", name=" + map2 + ", description=" + map3 + ")";
    }

    public AntiFeature(long j, String id, Map<String, FileV2> icon, Map<String, String> name, Map<String, String> description) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(description, "description");
        this.repoId = j;
        this.id = id;
        this.icon = icon;
        this.name = name;
        this.description = description;
    }
}
