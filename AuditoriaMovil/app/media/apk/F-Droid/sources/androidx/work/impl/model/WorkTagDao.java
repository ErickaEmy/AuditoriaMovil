package androidx.work.impl.model;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: WorkTagDao.kt */
/* loaded from: classes.dex */
public interface WorkTagDao {
    void deleteByWorkSpecId(String str);

    List getTagsForWorkSpecId(String str);

    void insert(WorkTag workTag);

    void insertTags(String str, Set set);

    /* compiled from: WorkTagDao.kt */
    /* renamed from: androidx.work.impl.model.WorkTagDao$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static void $default$insertTags(WorkTagDao workTagDao, String id, Set tags) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(tags, "tags");
            Iterator it = tags.iterator();
            while (it.hasNext()) {
                workTagDao.insert(new WorkTag((String) it.next(), id));
            }
        }
    }

    /* compiled from: WorkTagDao.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static void insertTags(WorkTagDao workTagDao, String id, Set tags) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(tags, "tags");
            CC.$default$insertTags(workTagDao, id, tags);
        }
    }
}
