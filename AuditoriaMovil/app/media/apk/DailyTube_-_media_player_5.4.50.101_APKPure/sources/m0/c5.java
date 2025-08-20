package m0;

import java.io.IOException;
import java.util.Set;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class c5 implements f {

    /* renamed from: n3  reason: collision with root package name */
    public final /* synthetic */ z f10553n3;
    public final /* synthetic */ Set y;

    /* renamed from: zn  reason: collision with root package name */
    public final /* synthetic */ wz f10554zn;

    public c5(wz wzVar, Set set, z zVar) {
        this.f10554zn = wzVar;
        this.y = set;
        this.f10553n3 = zVar;
    }

    @Override // m0.f
    public final void y(ZipFile zipFile, Set set) throws IOException {
        this.y.addAll(wz.y(this.f10554zn, set, this.f10553n3, zipFile));
    }
}
