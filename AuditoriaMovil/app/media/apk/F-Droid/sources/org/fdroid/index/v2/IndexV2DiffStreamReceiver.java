package org.fdroid.index.v2;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.serialization.json.JsonObject;
/* compiled from: IndexV2DiffStreamReceiver.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH&J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0016\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b\u0018\u00010\u000fH&¨\u0006\u0010"}, d2 = {"Lorg/fdroid/index/v2/IndexV2DiffStreamReceiver;", "", "onStreamEnded", "", "receivePackageMetadataDiff", "packageName", "", "packageJsonObject", "Lkotlinx/serialization/json/JsonObject;", "receiveRepoDiff", "version", "", "repoJsonObject", "receiveVersionsDiff", "versionsDiffMap", "", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface IndexV2DiffStreamReceiver {
    void onStreamEnded();

    void receivePackageMetadataDiff(String str, JsonObject jsonObject);

    void receiveRepoDiff(long j, JsonObject jsonObject);

    void receiveVersionsDiff(String str, Map<String, JsonObject> map);
}
