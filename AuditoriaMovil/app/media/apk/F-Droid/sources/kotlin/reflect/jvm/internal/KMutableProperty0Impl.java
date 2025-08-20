package kotlin.reflect.jvm.internal;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KMutableProperty;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
/* compiled from: KProperty0Impl.kt */
/* loaded from: classes2.dex */
public final class KMutableProperty0Impl extends KProperty0Impl implements KMutableProperty {
    private final Lazy _setter;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KMutableProperty0Impl(KDeclarationContainerImpl container, PropertyDescriptor descriptor) {
        super(container, descriptor);
        Lazy lazy;
        Intrinsics.checkNotNullParameter(container, "container");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlin.reflect.jvm.internal.KMutableProperty0Impl$_setter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final KMutableProperty0Impl.Setter invoke() {
                return new KMutableProperty0Impl.Setter(KMutableProperty0Impl.this);
            }
        });
        this._setter = lazy;
    }

    @Override // kotlin.reflect.KMutableProperty
    public Setter getSetter() {
        return (Setter) this._setter.getValue();
    }

    public void set(Object obj) {
        getSetter().call(obj);
    }

    /* compiled from: KProperty0Impl.kt */
    /* loaded from: classes2.dex */
    public static final class Setter extends KPropertyImpl.Setter implements Function1 {
        private final KMutableProperty0Impl property;

        @Override // kotlin.reflect.jvm.internal.KPropertyImpl.Accessor, kotlin.reflect.KProperty.Accessor
        public KMutableProperty0Impl getProperty() {
            return this.property;
        }

        public Setter(KMutableProperty0Impl property) {
            Intrinsics.checkNotNullParameter(property, "property");
            this.property = property;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            m2182invoke(obj);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke  reason: collision with other method in class */
        public void m2182invoke(Object obj) {
            getProperty().set(obj);
        }
    }
}
