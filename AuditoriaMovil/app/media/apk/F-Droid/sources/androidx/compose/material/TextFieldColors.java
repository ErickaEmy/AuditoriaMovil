package androidx.compose.material;

import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.State;
/* compiled from: TextFieldDefaults.kt */
/* loaded from: classes.dex */
public interface TextFieldColors {
    State backgroundColor(boolean z, Composer composer, int i);

    State cursorColor(boolean z, Composer composer, int i);

    State indicatorColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i);

    State labelColor(boolean z, boolean z2, InteractionSource interactionSource, Composer composer, int i);

    State leadingIconColor(boolean z, boolean z2, Composer composer, int i);

    State placeholderColor(boolean z, Composer composer, int i);

    State textColor(boolean z, Composer composer, int i);

    State trailingIconColor(boolean z, boolean z2, Composer composer, int i);
}
