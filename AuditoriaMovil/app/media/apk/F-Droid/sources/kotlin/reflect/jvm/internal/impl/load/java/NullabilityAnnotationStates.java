package kotlin.reflect.jvm.internal.impl.load.java;

import java.util.Map;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.reflect.jvm.internal.impl.name.FqName;
/* compiled from: JavaNullabilityAnnotationSettings.kt */
/* loaded from: classes2.dex */
public interface NullabilityAnnotationStates {
    public static final Companion Companion = Companion.$$INSTANCE;

    Object get(FqName fqName);

    /* compiled from: JavaNullabilityAnnotationSettings.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NullabilityAnnotationStates EMPTY;

        private Companion() {
        }

        public final NullabilityAnnotationStates getEMPTY() {
            return EMPTY;
        }

        static {
            Map emptyMap;
            emptyMap = MapsKt__MapsKt.emptyMap();
            EMPTY = new NullabilityAnnotationStatesImpl(emptyMap);
        }
    }
}
