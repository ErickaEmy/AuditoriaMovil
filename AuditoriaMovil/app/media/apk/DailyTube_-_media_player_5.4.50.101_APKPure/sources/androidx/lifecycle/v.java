package androidx.lifecycle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.concurrent.atomic.AtomicReference;
import y5.mt;
/* loaded from: classes.dex */
public abstract class v {
    @NonNull
    public AtomicReference<Object> y = new AtomicReference<>();

    /* loaded from: classes.dex */
    public enum n3 {
        ON_CREATE,
        ON_START,
        ON_RESUME,
        ON_PAUSE,
        ON_STOP,
        ON_DESTROY,
        ON_ANY;

        @Nullable
        public static n3 a(@NonNull zn znVar) {
            int i = y.y[znVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ON_RESUME;
                }
                return ON_START;
            }
            return ON_CREATE;
        }

        @Nullable
        public static n3 v(@NonNull zn znVar) {
            int i = y.y[znVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 5) {
                        return null;
                    }
                    return ON_CREATE;
                }
                return ON_RESUME;
            }
            return ON_START;
        }

        @Nullable
        public static n3 y(@NonNull zn znVar) {
            int i = y.y[znVar.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return null;
                    }
                    return ON_PAUSE;
                }
                return ON_STOP;
            }
            return ON_DESTROY;
        }

        @NonNull
        public zn gv() {
            switch (y.f2653n3[ordinal()]) {
                case 1:
                case 2:
                    return zn.CREATED;
                case 3:
                case 4:
                    return zn.STARTED;
                case 5:
                    return zn.RESUMED;
                case 6:
                    return zn.DESTROYED;
                default:
                    throw new IllegalArgumentException(this + " has no target state");
            }
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class y {

        /* renamed from: n3  reason: collision with root package name */
        public static final /* synthetic */ int[] f2653n3;
        public static final /* synthetic */ int[] y;

        static {
            int[] iArr = new int[n3.values().length];
            f2653n3 = iArr;
            try {
                iArr[n3.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2653n3[n3.ON_STOP.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2653n3[n3.ON_START.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2653n3[n3.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f2653n3[n3.ON_RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f2653n3[n3.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f2653n3[n3.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            int[] iArr2 = new int[zn.values().length];
            y = iArr2;
            try {
                iArr2[zn.CREATED.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                y[zn.STARTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                y[zn.RESUMED.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                y[zn.DESTROYED.ordinal()] = 4;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                y[zn.INITIALIZED.ordinal()] = 5;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    /* loaded from: classes.dex */
    public enum zn {
        DESTROYED,
        INITIALIZED,
        CREATED,
        STARTED,
        RESUMED;

        public boolean y(@NonNull zn znVar) {
            if (compareTo(znVar) >= 0) {
                return true;
            }
            return false;
        }
    }

    @NonNull
    public abstract zn n3();

    public abstract void y(@NonNull mt mtVar);

    public abstract void zn(@NonNull mt mtVar);
}
