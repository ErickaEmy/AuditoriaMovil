package org.fdroid.index.v2;

import java.util.List;
import kotlin.Metadata;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0006R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\n¨\u0006\u0011"}, d2 = {"Lorg/fdroid/index/v2/PackageManifest;", "", "featureNames", "", "", "getFeatureNames", "()Ljava/util/List;", "maxSdkVersion", "", "getMaxSdkVersion", "()Ljava/lang/Integer;", "minSdkVersion", "getMinSdkVersion", "nativecode", "getNativecode", "targetSdkVersion", "getTargetSdkVersion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface PackageManifest {
    List<String> getFeatureNames();

    Integer getMaxSdkVersion();

    Integer getMinSdkVersion();

    List<String> getNativecode();

    Integer getTargetSdkVersion();
}
