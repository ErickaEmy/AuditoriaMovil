package androidx.lifecycle;

import android.app.Application;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.MutableCreationExtras;
import java.lang.reflect.InvocationTargetException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: ViewModelProvider.kt */
/* loaded from: classes.dex */
public class ViewModelProvider {
    private final CreationExtras defaultCreationExtras;
    private final Factory factory;
    private final ViewModelStore store;

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class OnRequeryFactory {
        public abstract void onRequery(ViewModel viewModel);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStore store, Factory factory) {
        this(store, factory, null, 4, null);
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public ViewModelProvider(ViewModelStore store, Factory factory, CreationExtras defaultCreationExtras) {
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(factory, "factory");
        Intrinsics.checkNotNullParameter(defaultCreationExtras, "defaultCreationExtras");
        this.store = store;
        this.factory = factory;
        this.defaultCreationExtras = defaultCreationExtras;
    }

    public /* synthetic */ ViewModelProvider(ViewModelStore viewModelStore, Factory factory, CreationExtras creationExtras, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(viewModelStore, factory, (i & 4) != 0 ? CreationExtras.Empty.INSTANCE : creationExtras);
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public interface Factory {
        ViewModel create(Class cls);

        ViewModel create(Class cls, CreationExtras creationExtras);

        /* compiled from: ViewModelProvider.kt */
        /* renamed from: androidx.lifecycle.ViewModelProvider$Factory$-CC  reason: invalid class name */
        /* loaded from: classes.dex */
        public abstract /* synthetic */ class CC {
            public static ViewModel $default$create(Factory factory, Class modelClass) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                throw new UnsupportedOperationException("Factory.create(String) is unsupported.  This Factory requires `CreationExtras` to be passed into `create` method.");
            }

            public static ViewModel $default$create(Factory factory, Class modelClass, CreationExtras extras) {
                Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                Intrinsics.checkNotNullParameter(extras, "extras");
                return factory.create(modelClass);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner owner) {
        this(owner.getViewModelStore(), AndroidViewModelFactory.Companion.defaultFactory$lifecycle_viewmodel_release(owner), ViewModelProviderGetKt.defaultCreationExtras(owner));
        Intrinsics.checkNotNullParameter(owner, "owner");
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ViewModelProvider(ViewModelStoreOwner owner, Factory factory) {
        this(owner.getViewModelStore(), factory, ViewModelProviderGetKt.defaultCreationExtras(owner));
        Intrinsics.checkNotNullParameter(owner, "owner");
        Intrinsics.checkNotNullParameter(factory, "factory");
    }

    public ViewModel get(Class modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        String canonicalName = modelClass.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return get("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, modelClass);
    }

    public ViewModel get(String key, Class modelClass) {
        ViewModel create;
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        ViewModel viewModel = this.store.get(key);
        if (modelClass.isInstance(viewModel)) {
            Factory factory = this.factory;
            OnRequeryFactory onRequeryFactory = factory instanceof OnRequeryFactory ? (OnRequeryFactory) factory : null;
            if (onRequeryFactory != null) {
                Intrinsics.checkNotNull(viewModel);
                onRequeryFactory.onRequery(viewModel);
            }
            Intrinsics.checkNotNull(viewModel, "null cannot be cast to non-null type T of androidx.lifecycle.ViewModelProvider.get");
            return viewModel;
        }
        MutableCreationExtras mutableCreationExtras = new MutableCreationExtras(this.defaultCreationExtras);
        mutableCreationExtras.set(NewInstanceFactory.VIEW_MODEL_KEY, key);
        try {
            create = this.factory.create(modelClass, mutableCreationExtras);
        } catch (AbstractMethodError unused) {
            create = this.factory.create(modelClass);
        }
        this.store.put(key, create);
        return create;
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class NewInstanceFactory implements Factory {
        public static final Companion Companion = new Companion(null);
        public static final CreationExtras.Key VIEW_MODEL_KEY = Companion.ViewModelKeyImpl.INSTANCE;
        private static NewInstanceFactory sInstance;

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public /* synthetic */ ViewModel create(Class cls, CreationExtras creationExtras) {
            return Factory.CC.$default$create(this, cls, creationExtras);
        }

        @Override // androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            try {
                Object newInstance = modelClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                Intrinsics.checkNotNullExpressionValue(newInstance, "{\n                modelC…wInstance()\n            }");
                return (ViewModel) newInstance;
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e);
            } catch (InstantiationException e2) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e2);
            } catch (NoSuchMethodException e3) {
                throw new RuntimeException("Cannot create an instance of " + modelClass, e3);
            }
        }

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: classes.dex */
            private static final class ViewModelKeyImpl implements CreationExtras.Key {
                public static final ViewModelKeyImpl INSTANCE = new ViewModelKeyImpl();

                private ViewModelKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final NewInstanceFactory getInstance() {
                if (NewInstanceFactory.sInstance == null) {
                    NewInstanceFactory.sInstance = new NewInstanceFactory();
                }
                NewInstanceFactory newInstanceFactory = NewInstanceFactory.sInstance;
                Intrinsics.checkNotNull(newInstanceFactory);
                return newInstanceFactory;
            }
        }
    }

    /* compiled from: ViewModelProvider.kt */
    /* loaded from: classes.dex */
    public static class AndroidViewModelFactory extends NewInstanceFactory {
        private static AndroidViewModelFactory sInstance;
        private final Application application;
        public static final Companion Companion = new Companion(null);
        public static final CreationExtras.Key APPLICATION_KEY = Companion.ApplicationKeyImpl.INSTANCE;

        private AndroidViewModelFactory(Application application, int i) {
            this.application = application;
        }

        public AndroidViewModelFactory() {
            this(null, 0);
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public AndroidViewModelFactory(Application application) {
            this(application, 0);
            Intrinsics.checkNotNullParameter(application, "application");
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass, CreationExtras extras) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Intrinsics.checkNotNullParameter(extras, "extras");
            if (this.application != null) {
                return create(modelClass);
            }
            Application application = (Application) extras.get(APPLICATION_KEY);
            if (application != null) {
                return create(modelClass, application);
            }
            if (AndroidViewModel.class.isAssignableFrom(modelClass)) {
                throw new IllegalArgumentException("CreationExtras must have an application by `APPLICATION_KEY`");
            }
            return super.create(modelClass);
        }

        @Override // androidx.lifecycle.ViewModelProvider.NewInstanceFactory, androidx.lifecycle.ViewModelProvider.Factory
        public ViewModel create(Class modelClass) {
            Intrinsics.checkNotNullParameter(modelClass, "modelClass");
            Application application = this.application;
            if (application == null) {
                throw new UnsupportedOperationException("AndroidViewModelFactory constructed with empty constructor works only with create(modelClass: Class<T>, extras: CreationExtras).");
            }
            return create(modelClass, application);
        }

        private final ViewModel create(Class cls, Application application) {
            if (AndroidViewModel.class.isAssignableFrom(cls)) {
                try {
                    ViewModel viewModel = (ViewModel) cls.getConstructor(Application.class).newInstance(application);
                    Intrinsics.checkNotNullExpressionValue(viewModel, "{\n                try {\n…          }\n            }");
                    return viewModel;
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e);
                } catch (InstantiationException e2) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e2);
                } catch (NoSuchMethodException e3) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e3);
                } catch (InvocationTargetException e4) {
                    throw new RuntimeException("Cannot create an instance of " + cls, e4);
                }
            }
            return super.create(cls);
        }

        /* compiled from: ViewModelProvider.kt */
        /* loaded from: classes.dex */
        public static final class Companion {

            /* compiled from: ViewModelProvider.kt */
            /* loaded from: classes.dex */
            private static final class ApplicationKeyImpl implements CreationExtras.Key {
                public static final ApplicationKeyImpl INSTANCE = new ApplicationKeyImpl();

                private ApplicationKeyImpl() {
                }
            }

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Factory defaultFactory$lifecycle_viewmodel_release(ViewModelStoreOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                return owner instanceof HasDefaultViewModelProviderFactory ? ((HasDefaultViewModelProviderFactory) owner).getDefaultViewModelProviderFactory() : NewInstanceFactory.Companion.getInstance();
            }

            public final AndroidViewModelFactory getInstance(Application application) {
                Intrinsics.checkNotNullParameter(application, "application");
                if (AndroidViewModelFactory.sInstance == null) {
                    AndroidViewModelFactory.sInstance = new AndroidViewModelFactory(application);
                }
                AndroidViewModelFactory androidViewModelFactory = AndroidViewModelFactory.sInstance;
                Intrinsics.checkNotNull(androidViewModelFactory);
                return androidViewModelFactory;
            }
        }
    }
}
