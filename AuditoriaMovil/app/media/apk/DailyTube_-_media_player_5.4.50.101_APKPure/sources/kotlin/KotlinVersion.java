package kotlin;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
/* loaded from: classes.dex */
public final class KotlinVersion implements Comparable<KotlinVersion> {
    private final int major;
    private final int minor;
    private final int patch;
    private final int version;
    public static final Companion Companion = new Companion(null);
    public static final KotlinVersion CURRENT = KotlinVersionCurrentValue.get();

    /* loaded from: classes.dex */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public KotlinVersion(int i, int i5, int i6) {
        this.major = i;
        this.minor = i5;
        this.patch = i6;
        this.version = versionOf(i, i5, i6);
    }

    private final int versionOf(int i, int i5, int i6) {
        if (new IntRange(0, 255).contains(i) && new IntRange(0, 255).contains(i5) && new IntRange(0, 255).contains(i6)) {
            return (i << 16) + (i5 << 8) + i6;
        }
        throw new IllegalArgumentException(("Version components are out of range: " + i + '.' + i5 + '.' + i6).toString());
    }

    public boolean equals(Object obj) {
        KotlinVersion kotlinVersion;
        if (this == obj) {
            return true;
        }
        if (obj instanceof KotlinVersion) {
            kotlinVersion = (KotlinVersion) obj;
        } else {
            kotlinVersion = null;
        }
        if (kotlinVersion != null && this.version == kotlinVersion.version) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.major);
        sb.append('.');
        sb.append(this.minor);
        sb.append('.');
        sb.append(this.patch);
        return sb.toString();
    }

    @Override // java.lang.Comparable
    public int compareTo(KotlinVersion other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return this.version - other.version;
    }
}
