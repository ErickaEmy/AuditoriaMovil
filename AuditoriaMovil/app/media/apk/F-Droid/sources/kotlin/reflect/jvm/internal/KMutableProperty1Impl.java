package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty1;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
/* compiled from: KProperty1Impl.kt */
/* loaded from: classes2.dex */
public final class KMutableProperty1Impl extends KProperty1Impl implements KMutableProperty1 {
    private final Lazy _setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl container, String name, String signature, Object obj) {
        super(container, name, signature, obj);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(signature, "signature");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.Setter invoke() {
                return new KMutableProperty1Impl.Setter(KMutableProperty1Impl.this);
            }
        });
        this._setter = lazy;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty1Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KMutableProperty1Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty1Impl.Setter invoke() {
                return new KMutableProperty1Impl.Setter(KMutableProperty1Impl.this);
            }
        });
        this._setter = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty1, kotlin.reflect.KMutableProperty
    public Setter getSetter() {
        return (Setter) this._setter.getValue();
    }

    public void set(Object obj, Object obj2) {
        getSetter().call(obj, obj2);
    }

    /* compiled from: KProperty1Impl.kt */
    /* loaded from: classes2.dex */
    public static final class Setter extends KPropertyImpl.Setter implements KMutableProperty1.Setter {
        private final KMutableProperty1Impl property;

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty1Impl getProperty() {
            return this.property;
        }

        public Setter(KMutableProperty1Impl property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            m2183invoke(obj, obj2);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public void m2183invoke(Object obj, Object obj2) {
            getProperty().set(obj, obj2);
        }
    }
}
