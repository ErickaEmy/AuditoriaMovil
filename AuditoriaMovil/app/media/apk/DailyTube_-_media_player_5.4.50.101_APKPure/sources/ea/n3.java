package ea;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import ea.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import kx.z6;
/* loaded from: classes.dex */
public final class n3<T extends y<T>> implements z6.y<T> {
    @Nullable

    /* renamed from: v  reason: collision with root package name */
    public final List<StreamKey> f7589v;
    public final z6.y<? extends T> y;

    public n3(z6.y<? extends T> yVar, @Nullable List<StreamKey> list) {
        this.y = yVar;
        this.f7589v = list;
    }

    @Override // kx.z6.y
    /* renamed from: n3 */
    public T y(Uri uri, InputStream inputStream) throws IOException {
        T y = this.y.y(uri, inputStream);
        List<StreamKey> list = this.f7589v;
        if (list != null && !list.isEmpty()) {
            return (T) y.y(this.f7589v);
        }
        return y;
    }
}
