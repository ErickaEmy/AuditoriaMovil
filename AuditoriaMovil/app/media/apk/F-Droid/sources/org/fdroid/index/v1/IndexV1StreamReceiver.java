package org.fdroid.index.v1;

import java.util.Map;
import kotlin.Metadata;
import org.fdroid.index.v2.AntiFeatureV2;
import org.fdroid.index.v2.CategoryV2;
import org.fdroid.index.v2.MetadataV2;
import org.fdroid.index.v2.PackageVersionV2;
import org.fdroid.index.v2.ReleaseChannelV2;
import org.fdroid.index.v2.RepoV2;
/* compiled from: IndexV1StreamReceiver.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007H&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH&J\u001a\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H&JD\u0010\u0011\u001a\u00020\u00032\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00130\u00072\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00150\u00072\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00170\u0007H&¨\u0006\u0018"}, d2 = {"Lorg/fdroid/index/v1/IndexV1StreamReceiver;", "", "receive", "", "packageName", "", "v", "", "Lorg/fdroid/index/v2/PackageVersionV2;", "m", "Lorg/fdroid/index/v2/MetadataV2;", "repo", "Lorg/fdroid/index/v2/RepoV2;", "version", "", "updateAppMetadata", "preferredSigner", "updateRepo", "antiFeatures", "Lorg/fdroid/index/v2/AntiFeatureV2;", "categories", "Lorg/fdroid/index/v2/CategoryV2;", "releaseChannels", "Lorg/fdroid/index/v2/ReleaseChannelV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IndexV1StreamReceiver {
    void receive(String str, Map<String, PackageVersionV2> map);

    void receive(String str, MetadataV2 metadataV2);

    void receive(RepoV2 repoV2, long j);

    void updateAppMetadata(String str, String str2);

    void updateRepo(Map<String, AntiFeatureV2> map, Map<String, CategoryV2> map2, Map<String, ReleaseChannelV2> map3);
}
