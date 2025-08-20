package androidx.compose.ui.modifier;

import androidx.compose.ui.Modifier;
/* compiled from: ModifierLocalProvider.kt */
/* loaded from: classes.dex */
public interface ModifierLocalProvider extends Modifier.Element {
    ProvidableModifierLocal getKey();

    Object getValue();
}
