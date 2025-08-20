package h4;

import android.net.Uri;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import kx.o;
/* loaded from: classes.dex */
public class y implements kx.tl {
    @Nullable

    /* renamed from: gv  reason: collision with root package name */
    public CipherInputStream f8704gv;

    /* renamed from: n3  reason: collision with root package name */
    public final byte[] f8705n3;
    public final kx.tl y;

    /* renamed from: zn  reason: collision with root package name */
    public final byte[] f8706zn;

    public y(kx.tl tlVar, byte[] bArr, byte[] bArr2) {
        this.y = tlVar;
        this.f8705n3 = bArr;
        this.f8706zn = bArr2;
    }

    public Cipher a() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return Cipher.getInstance("AES/CBC/PKCS7Padding");
    }

    @Override // kx.tl
    public void close() throws IOException {
        if (this.f8704gv != null) {
            this.f8704gv = null;
            this.y.close();
        }
    }

    @Override // kx.tl
    public final Map<String, List<String>> fb() {
        return this.y.fb();
    }

    @Override // kx.tl
    public final void i9(o oVar) {
        v5.y.v(oVar);
        this.y.i9(oVar);
    }

    @Override // kx.tl
    @Nullable
    public final Uri n3() {
        return this.y.n3();
    }

    @Override // kx.c5
    public final int read(byte[] bArr, int i, int i5) throws IOException {
        v5.y.v(this.f8704gv);
        int read = this.f8704gv.read(bArr, i, i5);
        if (read < 0) {
            return -1;
        }
        return read;
    }

    @Override // kx.tl
    public final long y(kx.p pVar) throws IOException {
        try {
            Cipher a2 = a();
            try {
                a2.init(2, new SecretKeySpec(this.f8705n3, "AES"), new IvParameterSpec(this.f8706zn));
                kx.xc xcVar = new kx.xc(this.y, pVar);
                this.f8704gv = new CipherInputStream(xcVar, a2);
                xcVar.v();
                return -1L;
            } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                throw new RuntimeException(e2);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e3) {
            throw new RuntimeException(e3);
        }
    }
}
