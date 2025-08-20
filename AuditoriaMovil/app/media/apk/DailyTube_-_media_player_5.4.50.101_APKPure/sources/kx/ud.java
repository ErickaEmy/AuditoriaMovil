package kx;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Map;
import kx.tl;
/* loaded from: classes.dex */
public final class ud implements tl {
    public static final ud y = new ud();

    /* renamed from: n3  reason: collision with root package name */
    public static final tl.y f10124n3 = new tl.y() { // from class: kx.ej
        @Override // kx.tl.y
        public final tl y() {
            return ud.a();
        }
    };

    public static /* synthetic */ ud a() {
        return new ud();
    }

    @Override // kx.tl
    public /* synthetic */ Map fb() {
        return t.y(this);
    }

    @Override // kx.tl
    @Nullable
    public Uri n3() {
        return null;
    }

    @Override // kx.c5
    public int read(byte[] bArr, int i, int i5) {
        throw new UnsupportedOperationException();
    }

    @Override // kx.tl
    public long y(p pVar) throws IOException {
        throw new IOException("PlaceholderDataSource cannot be opened");
    }

    @Override // kx.tl
    public void close() {
    }

    @Override // kx.tl
    public void i9(o oVar) {
    }
}
