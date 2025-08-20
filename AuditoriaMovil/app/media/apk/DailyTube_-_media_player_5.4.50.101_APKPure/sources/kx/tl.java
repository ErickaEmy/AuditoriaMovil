package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public interface tl extends c5 {

    /* loaded from: classes.dex */
    public interface y {
        tl y();
    }

    void close() throws IOException;

    Map<String, List<String>> fb();

    void i9(o oVar);

    @Nullable
    Uri n3();

    long y(p pVar) throws IOException;
}
