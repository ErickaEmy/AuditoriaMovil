package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.CreationExtras;
/* compiled from: HasDefaultViewModelProviderFactory.kt */
/* loaded from: classes.dex */
public interface HasDefaultViewModelProviderFactory {
    CreationExtras getDefaultViewModelCreationExtras();

    ViewModelProvider.Factory getDefaultViewModelProviderFactory();

    /* compiled from: HasDefaultViewModelProviderFactory.kt */
    /* renamed from: androidx.lifecycle.HasDefaultViewModelProviderFactory$-CC  reason: invalid class name */
    /* loaded from: classes.dex */
    public abstract /* synthetic */ class CC {
        public static CreationExtras $default$getDefaultViewModelCreationExtras(HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory) {
            return CreationExtras.Empty.INSTANCE;
        }
    }
}
