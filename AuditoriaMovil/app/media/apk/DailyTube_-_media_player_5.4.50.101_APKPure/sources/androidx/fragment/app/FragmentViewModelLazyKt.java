package androidx.fragment.app;

import androidx.lifecycle.wz;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import y5.b;
import y5.k5;
import y5.ud;
import y5.x;
/* loaded from: classes.dex */
public final class FragmentViewModelLazyKt {
    public static final /* synthetic */ <VM extends ud> Lazy<VM> activityViewModels(Fragment activityViewModels, Function0<? extends wz.n3> function0) {
        Intrinsics.checkNotNullParameter(activityViewModels, "$this$activityViewModels");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ud.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, orCreateKotlinClass, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static /* synthetic */ Lazy activityViewModels$default(Fragment activityViewModels, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(activityViewModels, "$this$activityViewModels");
        Intrinsics.reifiedOperationMarker(4, "VM");
        KClass orCreateKotlinClass = Reflection.getOrCreateKotlinClass(ud.class);
        FragmentViewModelLazyKt$activityViewModels$1 fragmentViewModelLazyKt$activityViewModels$1 = new FragmentViewModelLazyKt$activityViewModels$1(activityViewModels);
        if (function0 == null) {
            function0 = new FragmentViewModelLazyKt$activityViewModels$2(activityViewModels);
        }
        return createViewModelLazy(activityViewModels, orCreateKotlinClass, fragmentViewModelLazyKt$activityViewModels$1, function0);
    }

    public static final <VM extends ud> Lazy<VM> createViewModelLazy(final Fragment createViewModelLazy, KClass<VM> viewModelClass, Function0<? extends b> storeProducer, Function0<? extends wz.n3> function0) {
        Intrinsics.checkNotNullParameter(createViewModelLazy, "$this$createViewModelLazy");
        Intrinsics.checkNotNullParameter(viewModelClass, "viewModelClass");
        Intrinsics.checkNotNullParameter(storeProducer, "storeProducer");
        if (function0 == null) {
            function0 = new Function0<wz.n3>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$createViewModelLazy$factoryPromise$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final wz.n3 invoke() {
                    return Fragment.this.getDefaultViewModelProviderFactory();
                }
            };
        }
        return new x(viewModelClass, storeProducer, function0);
    }

    public static /* synthetic */ Lazy createViewModelLazy$default(Fragment fragment, KClass kClass, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 4) != 0) {
            function02 = null;
        }
        return createViewModelLazy(fragment, kClass, function0, function02);
    }

    public static final /* synthetic */ <VM extends ud> Lazy<VM> viewModels(Fragment viewModels, Function0<? extends k5> ownerProducer, Function0<? extends wz.n3> function0) {
        Intrinsics.checkNotNullParameter(viewModels, "$this$viewModels");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(viewModels, Reflection.getOrCreateKotlinClass(ud.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }

    public static /* synthetic */ Lazy viewModels$default(final Fragment viewModels, Function0 ownerProducer, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            ownerProducer = new Function0<Fragment>() { // from class: androidx.fragment.app.FragmentViewModelLazyKt$viewModels$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Fragment invoke() {
                    return Fragment.this;
                }
            };
        }
        if ((i & 2) != 0) {
            function0 = null;
        }
        Intrinsics.checkNotNullParameter(viewModels, "$this$viewModels");
        Intrinsics.checkNotNullParameter(ownerProducer, "ownerProducer");
        Intrinsics.reifiedOperationMarker(4, "VM");
        return createViewModelLazy(viewModels, Reflection.getOrCreateKotlinClass(ud.class), new FragmentViewModelLazyKt$viewModels$2(ownerProducer), function0);
    }
}
