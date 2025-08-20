package fb;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.ActivityResult;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes.dex */
public final class gv extends y<Intent, ActivityResult> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // fb.y
    @NonNull
    public ActivityResult parseResult(int i, @Nullable Intent intent) {
        return new ActivityResult(i, intent);
    }

    @Override // fb.y
    @NonNull
    /* renamed from: y */
    public Intent createIntent(@NonNull Context context, @NonNull Intent intent) {
        return intent;
    }
}
