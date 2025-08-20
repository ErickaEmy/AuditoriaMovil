package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
/* compiled from: KProperty2Impl.kt */
/* loaded from: classes2.dex */
public final class KMutableProperty2Impl extends KProperty2Impl implements KMutableProperty {
    private final Lazy _setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty2Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KMutableProperty2Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty2Impl.Setter invoke() {
                return new KMutableProperty2Impl.Setter(KMutableProperty2Impl.this);
            }
        });
        this._setter = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty
    public Setter getSetter() {
        return (Setter) this._setter.getValue();
    }

    public void set(Object obj, Object obj2, Object obj3) {
        getSetter().call(obj, obj2, obj3);
    }

    /* compiled from: KProperty2Impl.kt */
    /* loaded from: classes2.dex */
    public static final class Setter extends KPropertyImpl.Setter implements Function3 {
        private final KMutableProperty2Impl property;

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty2Impl getProperty() {
            return this.property;
        }

        public Setter(KMutableProperty2Impl property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            m2184invoke(obj, obj2, obj3);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public void m2184invoke(Object obj, Object obj2, Object obj3) {
            getProperty().set(obj, obj2, obj3);
        }
    }
}
