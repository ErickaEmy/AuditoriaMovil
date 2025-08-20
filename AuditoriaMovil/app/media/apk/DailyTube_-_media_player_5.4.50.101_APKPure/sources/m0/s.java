package m0;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.zip.ZipFile;
/* loaded from: classes.dex */
public final class s implements f {

    /* renamed from: gv  reason: collision with root package name */
    public final /* synthetic */ wz f10558gv;

    /* renamed from: n3  reason: collision with root package name */
    public final /* synthetic */ Set f10559n3;
    public final /* synthetic */ z y;

    /* renamed from: zn  reason: collision with root package name */
    public final /* synthetic */ AtomicBoolean f10560zn;

    public s(wz wzVar, z zVar, Set set, AtomicBoolean atomicBoolean) {
        this.f10558gv = wzVar;
        this.y = zVar;
        this.f10559n3 = set;
        this.f10560zn = atomicBoolean;
    }

    @Override // m0.f
    public final void y(ZipFile zipFile, Set set) throws IOException {
        this.f10558gv.a(this.y, set, new fb(this));
    }
}
