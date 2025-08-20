package androidx.work.impl.model;

import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Preference.kt */
/* loaded from: classes.dex */
public final class Preference {
    private final String key;
    private final Long value;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Preference) {
            Preference preference = (Preference) obj;
            return Intrinsics.areEqual(this.key, preference.key) && Intrinsics.areEqual(this.value, preference.value);
        }
        return false;
    }

    public final String getKey() {
        return this.key;
    }

    public final Long getValue() {
        return this.value;
    }

    public int hashCode() {
        int hashCode = this.key.hashCode() * 31;
        Long l = this.value;
        return hashCode + (l == null ? 0 : l.hashCode());
    }

    public String toString() {
        return "Preference(key=" + this.key + ", value=" + this.value + CoreConstants.RIGHT_PARENTHESIS_CHAR;
    }

    public Preference(String key, Long l) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.key = key;
        this.value = l;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public Preference(String key, boolean z) {
        this(key, Long.valueOf(z ? 1L : 0L));
        Intrinsics.checkNotNullParameter(key, "key");
    }
}
