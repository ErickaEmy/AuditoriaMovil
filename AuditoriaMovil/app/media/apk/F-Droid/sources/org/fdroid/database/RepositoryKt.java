package org.fdroid.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsKt;
import kotlin.text.StringsKt___StringsKt;
import org.fdroid.index.IndexFormatVersion;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.MirrorV2;
import org.fdroid.index.v2.ReleaseChannelV2;
import org.fdroid.index.v2.RepoV2;
/* compiled from: Repository.kt */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0002\u001a2\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0014\u0010\f\u001a\u00020\r*\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a&\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a&\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00160\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0000\u001a&\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0010*\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00190\u00122\u0006\u0010\u0007\u001a\u00020\bH\u0000¨\u0006\u001a"}, d2 = {"validateCertificate", "", "certificate", "", "toCoreRepository", "Lorg/fdroid/database/CoreRepository;", "Lorg/fdroid/index/v2/RepoV2;", "repoId", "", "version", "formatVersion", "Lorg/fdroid/index/IndexFormatVersion;", "toMirror", "Lorg/fdroid/database/Mirror;", "Lorg/fdroid/index/v2/MirrorV2;", "toRepoAntiFeatures", "", "Lorg/fdroid/database/AntiFeature;", "", "Lorg/fdroid/index/v2/AntiFeatureV2;", "toRepoCategories", "Lorg/fdroid/database/Category;", "Lorg/fdroid/index/v2/CategoryV2;", "toRepoReleaseChannel", "Lorg/fdroid/database/ReleaseChannel;", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "database_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RepositoryKt {
    public static /* synthetic */ CoreRepository toCoreRepository$default(RepoV2 repoV2, long j, long j2, IndexFormatVersion indexFormatVersion, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            j = 0;
        }
        long j3 = j;
        if ((i & 4) != 0) {
            indexFormatVersion = null;
        }
        return toCoreRepository(repoV2, j3, j2, indexFormatVersion, str);
    }

    public static final CoreRepository toCoreRepository(RepoV2 repoV2, long j, long j2, IndexFormatVersion indexFormatVersion, String certificate) {
        Intrinsics.checkNotNullParameter(repoV2, "<this>");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return new CoreRepository(j, repoV2.getName(), repoV2.getIcon(), repoV2.getAddress(), repoV2.getWebBaseUrl(), repoV2.getTimestamp(), Long.valueOf(j2), indexFormatVersion, null, repoV2.getDescription(), certificate);
    }

    public static final List<AntiFeature> toRepoAntiFeatures(Map<String, AntiFeatureV2> map, long j) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, AntiFeatureV2> entry : map.entrySet()) {
            arrayList.add(new AntiFeature(j, entry.getKey(), entry.getValue().getIcon(), entry.getValue().getName(), entry.getValue().getDescription()));
        }
        return arrayList;
    }

    public static final List<Category> toRepoCategories(Map<String, CategoryV2> map, long j) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, CategoryV2> entry : map.entrySet()) {
            arrayList.add(new Category(j, entry.getKey(), entry.getValue().getIcon(), entry.getValue().getName(), entry.getValue().getDescription()));
        }
        return arrayList;
    }

    public static final List<ReleaseChannel> toRepoReleaseChannel(Map<String, ReleaseChannelV2> map, long j) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        ArrayList arrayList = new ArrayList(map.size());
        for (Map.Entry<String, ReleaseChannelV2> entry : map.entrySet()) {
            arrayList.add(new ReleaseChannel(j, entry.getKey(), null, entry.getValue().getName(), entry.getValue().getDescription(), 4, null));
        }
        return arrayList;
    }

    public static final Mirror toMirror(MirrorV2 mirrorV2, long j) {
        Intrinsics.checkNotNullParameter(mirrorV2, "<this>");
        return new Mirror(j, mirrorV2.getUrl(), mirrorV2.getLocation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void validateCertificate(String str) throws IllegalArgumentException {
        List chunked;
        Object obj;
        Integer intOrNull;
        if (str != null) {
            if (str.length() % 2 == 0) {
                chunked = StringsKt___StringsKt.chunked(str, 2);
                Iterator it = chunked.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull((String) obj, 16);
                    if (intOrNull == null) {
                        break;
                    }
                }
                if (obj == null) {
                    return;
                }
            }
            throw new IllegalArgumentException(("Invalid certificate: " + str).toString());
        }
    }
}
