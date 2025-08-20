package org.fdroid.database;

import androidx.lifecycle.LiveData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import org.fdroid.index.v2.PackageVersionV2;
/* compiled from: VersionDao.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\b\u001a\u00020\tH&J@\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00110\u0010H&¨\u0006\u0012"}, d2 = {"Lorg/fdroid/database/VersionDao;", "", "getAppVersions", "Landroidx/lifecycle/LiveData;", "", "Lorg/fdroid/database/AppVersion;", "repoId", "", "packageName", "", "insert", "", "packageVersions", "", "Lorg/fdroid/index/v2/PackageVersionV2;", "checkIfCompatible", "Lkotlin/Function1;", "", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface VersionDao {
    LiveData getAppVersions(long j, String str);

    LiveData getAppVersions(String str);

    void insert(long j, String str, Map<String, PackageVersionV2> map, Function1 function1);
}
