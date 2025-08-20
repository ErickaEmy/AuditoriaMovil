package androidx.compose.ui.text.input;

import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl;
import ch.qos.logback.core.CoreConstants;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: PlatformTextInputAdapter.kt */
/* loaded from: classes.dex */
public final class PlatformTextInputPluginRegistryImpl implements PlatformTextInputPluginRegistry {
    private final SnapshotStateMap adaptersByPlugin;
    private boolean adaptersMayNeedDisposal;
    private final Function2 factory;
    private PlatformTextInputPlugin focusedPlugin;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformTextInputAdapter.kt */
    /* loaded from: classes.dex */
    public final class AdapterWithRefCount {
        private final PlatformTextInputAdapter adapter;
        private final MutableIntState refCount$delegate;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public final PlatformTextInputAdapter getAdapter() {
            return this.adapter;
        }

        private final int getRefCount() {
            return this.refCount$delegate.getIntValue();
        }

        private final void setRefCount(int i) {
            this.refCount$delegate.setIntValue(i);
        }

        public AdapterWithRefCount(PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl, PlatformTextInputAdapter adapter) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            this.this$0 = platformTextInputPluginRegistryImpl;
            this.adapter = adapter;
            this.refCount$delegate = SnapshotIntStateKt.mutableIntStateOf(0);
        }

        public final void incrementRefCount() {
            setRefCount(getRefCount() + 1);
        }

        public final boolean decrementRefCount() {
            setRefCount(getRefCount() - 1);
            if (getRefCount() < 0) {
                throw new IllegalStateException(("AdapterWithRefCount.decrementRefCount called too many times (refCount=" + getRefCount() + CoreConstants.RIGHT_PARENTHESIS_CHAR).toString());
            } else if (getRefCount() == 0) {
                this.this$0.adaptersMayNeedDisposal = true;
                return true;
            } else {
                return false;
            }
        }
    }

    public PlatformTextInputPluginRegistryImpl(Function2 factory) {
        Intrinsics.checkNotNullParameter(factory, "factory");
        this.factory = factory;
        this.adaptersByPlugin = SnapshotStateKt.mutableStateMapOf();
    }

    public final PlatformTextInputAdapter getFocusedAdapter() {
        AdapterWithRefCount adapterWithRefCount = (AdapterWithRefCount) this.adaptersByPlugin.get(this.focusedPlugin);
        if (adapterWithRefCount != null) {
            return adapterWithRefCount.getAdapter();
        }
        return null;
    }

    public final AdapterHandle getOrCreateAdapter(PlatformTextInputPlugin plugin) {
        Intrinsics.checkNotNullParameter(plugin, "plugin");
        final AdapterWithRefCount adapterWithRefCount = (AdapterWithRefCount) this.adaptersByPlugin.get(plugin);
        if (adapterWithRefCount == null) {
            adapterWithRefCount = instantiateAdapter(plugin);
        }
        adapterWithRefCount.incrementRefCount();
        return new AdapterHandle(adapterWithRefCount.getAdapter(), new Function0() { // from class: androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl$getOrCreateAdapter$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                return Boolean.valueOf(PlatformTextInputPluginRegistryImpl.AdapterWithRefCount.this.decrementRefCount());
            }
        });
    }

    private final AdapterWithRefCount instantiateAdapter(PlatformTextInputPlugin platformTextInputPlugin) {
        Object invoke = this.factory.invoke(platformTextInputPlugin, new AdapterInput(this, platformTextInputPlugin));
        Intrinsics.checkNotNull(invoke, "null cannot be cast to non-null type T of androidx.compose.ui.text.input.PlatformTextInputPluginRegistryImpl.instantiateAdapter");
        AdapterWithRefCount adapterWithRefCount = new AdapterWithRefCount(this, (PlatformTextInputAdapter) invoke);
        this.adaptersByPlugin.put(platformTextInputPlugin, adapterWithRefCount);
        return adapterWithRefCount;
    }

    /* compiled from: PlatformTextInputAdapter.kt */
    /* loaded from: classes.dex */
    public static final class AdapterHandle {
        private final PlatformTextInputAdapter adapter;
        private final Function0 onDispose;

        public final PlatformTextInputAdapter getAdapter() {
            return this.adapter;
        }

        public AdapterHandle(PlatformTextInputAdapter adapter, Function0 onDispose) {
            Intrinsics.checkNotNullParameter(adapter, "adapter");
            Intrinsics.checkNotNullParameter(onDispose, "onDispose");
            this.adapter = adapter;
            this.onDispose = onDispose;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: PlatformTextInputAdapter.kt */
    /* loaded from: classes.dex */
    public final class AdapterInput implements PlatformTextInput {
        private final PlatformTextInputPlugin plugin;
        final /* synthetic */ PlatformTextInputPluginRegistryImpl this$0;

        public AdapterInput(PlatformTextInputPluginRegistryImpl platformTextInputPluginRegistryImpl, PlatformTextInputPlugin plugin) {
            Intrinsics.checkNotNullParameter(plugin, "plugin");
            this.this$0 = platformTextInputPluginRegistryImpl;
            this.plugin = plugin;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public void requestInputFocus() {
            this.this$0.focusedPlugin = this.plugin;
        }

        @Override // androidx.compose.ui.text.input.PlatformTextInput
        public void releaseInputFocus() {
            if (Intrinsics.areEqual(this.this$0.focusedPlugin, this.plugin)) {
                this.this$0.focusedPlugin = null;
            }
        }
    }
}
