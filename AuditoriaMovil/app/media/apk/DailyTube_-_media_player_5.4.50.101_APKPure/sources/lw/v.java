package lw;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.List;
import kx.z6;
/* loaded from: classes.dex */
public final class v implements f {

    /* renamed from: n3  reason: collision with root package name */
    public final List<StreamKey> f10503n3;
    public final f y;

    public v(f fVar, List<StreamKey> list) {
        this.y = fVar;
        this.f10503n3 = list;
    }

    @Override // lw.f
    public z6.y<c5> n3(s sVar, @Nullable fb fbVar) {
        return new ea.n3(this.y.n3(sVar, fbVar), this.f10503n3);
    }

    @Override // lw.f
    public z6.y<c5> y() {
        return new ea.n3(this.y.y(), this.f10503n3);
    }
}
