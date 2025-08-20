package kx;

import androidx.annotation.Nullable;
import java.io.IOException;
/* loaded from: classes.dex */
public final class w {
    public static void y(@Nullable tl tlVar) {
        if (tlVar != null) {
            try {
                tlVar.close();
            } catch (IOException unused) {
            }
        }
    }
}
