package kotlin.reflect.jvm.internal.impl.utils;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
/* compiled from: functions.kt */
/* loaded from: classes2.dex */
public abstract class FunctionsKt {
    private static final Function1 IDENTITY = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$IDENTITY$1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return obj;
        }
    };
    private static final Function1 ALWAYS_TRUE = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_TRUE$1
        @Override // kotlin.jvm.functions.Function1
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    };
    private static final Function1 ALWAYS_NULL = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$ALWAYS_NULL$1
        @Override // kotlin.jvm.functions.Function1
        public final Void invoke(Object obj) {
            return null;
        }
    };
    private static final Function1 DO_NOTHING = new Function1() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2228invoke(Object obj) {
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2228invoke(obj);
            return Unit.INSTANCE;
        }
    };
    private static final Function2 DO_NOTHING_2 = new Function2() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_2$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2229invoke(Object obj, Object obj2) {
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            m2229invoke(obj, obj2);
            return Unit.INSTANCE;
        }
    };
    private static final Function3 DO_NOTHING_3 = new Function3() { // from class: kotlin.reflect.jvm.internal.impl.utils.FunctionsKt$DO_NOTHING_3$1
        /* renamed from: invoke  reason: collision with other method in class */
        public final void m2230invoke(Object obj, Object obj2, Object obj3) {
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m2230invoke(obj, obj2, obj3);
            return Unit.INSTANCE;
        }
    };

    public static final Function1 alwaysTrue() {
        return ALWAYS_TRUE;
    }

    public static final Function3 getDO_NOTHING_3() {
        return DO_NOTHING_3;
    }
}
