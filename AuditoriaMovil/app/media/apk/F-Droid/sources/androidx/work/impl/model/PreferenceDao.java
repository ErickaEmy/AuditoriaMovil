package androidx.work.impl.model;
/* compiled from: PreferenceDao.kt */
/* loaded from: classes.dex */
public interface PreferenceDao {
    Long getLongValue(String str);

    void insertPreference(Preference preference);
}
