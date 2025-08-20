package h6;

import android.content.ContentResolver;
import android.provider.Settings;
import androidx.annotation.NonNull;
/* loaded from: classes.dex */
public class y {
    public float y(@NonNull ContentResolver contentResolver) {
        return Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f);
    }
}
