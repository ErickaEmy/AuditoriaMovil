package androidx.work.impl.model;
/* compiled from: WorkProgressDao.kt */
/* loaded from: classes.dex */
public interface WorkProgressDao {
    void delete(String str);

    void deleteAll();

    void insert(WorkProgress workProgress);
}
