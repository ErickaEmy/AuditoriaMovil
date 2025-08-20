package org.fdroid.database;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
/* compiled from: RepositoryDao.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0014\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bH&J\u0014\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\t0\bH&J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\tH&J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013H&J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016H&J\u001e\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\tH&J\u001e\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\tH&J$\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u001d\u001a\u0004\u0018\u00010\u00192\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H&¨\u0006\u001f"}, d2 = {"Lorg/fdroid/database/RepositoryDao;", "", "clearAll", "", "deleteRepository", "repoId", "", "getLiveCategories", "Landroidx/lifecycle/LiveData;", "", "Lorg/fdroid/database/Category;", "getLiveRepositories", "Lorg/fdroid/database/Repository;", "getRepositories", "getRepository", "insert", "initialRepo", "Lorg/fdroid/database/InitialRepository;", "newRepository", "Lorg/fdroid/database/NewRepository;", "setRepositoryEnabled", "enabled", "", "updateDisabledMirrors", "disabledMirrors", "", "updateUserMirrors", "mirrors", "updateUsernameAndPassword", "username", "password", "database_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface RepositoryDao {
    void clearAll();

    void deleteRepository(long j);

    LiveData getLiveCategories();

    LiveData getLiveRepositories();

    List<Repository> getRepositories();

    Repository getRepository(long j);

    long insert(InitialRepository initialRepository);

    long insert(NewRepository newRepository);

    void setRepositoryEnabled(long j, boolean z);

    void updateDisabledMirrors(long j, List<String> list);

    void updateUserMirrors(long j, List<String> list);

    void updateUsernameAndPassword(long j, String str, String str2);
}
