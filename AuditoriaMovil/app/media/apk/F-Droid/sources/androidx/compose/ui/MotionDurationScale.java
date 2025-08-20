package androidx.compose.ui;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: MotionDurationScale.kt */
/* loaded from: classes.dex */
public interface MotionDurationScale extends CoroutineContext.Element {
    public static final Key Key = Key.$$INSTANCE;

    /* compiled from: MotionDurationScale.kt */
    /* loaded from: classes.dex */
    public static final class Key implements CoroutineContext.Key {
        static final /* synthetic */ Key $$INSTANCE = new Key();

        private Key() {
        }
    }

    float getScaleFactor();

    /* compiled from: MotionDurationScale.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static Object fold(MotionDurationScale motionDurationScale, Object obj, Function2 operation) {
            Intrinsics.checkNotNullParameter(operation, "operation");
            return CoroutineContext.Element.DefaultImpls.fold(motionDurationScale, obj, operation);
        }

        public static CoroutineContext.Element get(MotionDurationScale motionDurationScale, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.get(motionDurationScale, key);
        }

        public static CoroutineContext minusKey(MotionDurationScale motionDurationScale, CoroutineContext.Key key) {
            Intrinsics.checkNotNullParameter(key, "key");
            return CoroutineContext.Element.DefaultImpls.minusKey(motionDurationScale, key);
        }

        public static CoroutineContext plus(MotionDurationScale motionDurationScale, CoroutineContext context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return CoroutineContext.Element.DefaultImpls.plus(motionDurationScale, context);
        }
    }

    /* compiled from: MotionDurationScale.kt */
    /* renamed from: androidx.compose.ui.MotionDurationScale$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
    }
}
