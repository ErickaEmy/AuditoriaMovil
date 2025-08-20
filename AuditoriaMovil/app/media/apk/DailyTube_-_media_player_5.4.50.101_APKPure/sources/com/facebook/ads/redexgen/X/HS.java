package com.facebook.ads.redexgen.X;

import android.util.SparseArray;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
/* loaded from: assets/audience_network.dex */
public final class HS {
    public static byte[] A08;
    public static String[] A09 = {"tUmPyJA995IehdlgYh1M2HtFJdqk2qFq", "MsgCzq1VVfM7rzT56hJDHksvV5yXe4gF", "4HQ7m4N6DkH9M0uOuKNVPqKigOQvjf6k", "N6cNHUUPL7Fh24xE6qmpU0ogNc5efwpW", "s0cCARPqV4C670oPtvU1gEMcVzhG", "NrezJK25om3nHdODHZffKD7POu79MIOp", "J5KrgCJUtsnBlTAtkJ9UTDt78OFQHXma", "N8WE0W2EMF4cGNiI42Wit4NkXIy23rap"};
    public I6 A00;
    public boolean A01;
    public final SparseArray<String> A02;
    public final C0674Hc A03;
    public final HashMap<String, HR> A04;
    public final Cipher A05;
    public final SecretKeySpec A06;
    public final boolean A07;

    public static String A02(int i, int i5, int i6) {
        byte[] copyOfRange = Arrays.copyOfRange(A08, i, i + i5);
        for (int i8 = 0; i8 < copyOfRange.length; i8++) {
            copyOfRange[i8] = (byte) ((copyOfRange[i8] - i6) - 50);
        }
        return new String(copyOfRange);
    }

    public static void A05() {
        A08 = new byte[]{-90, -86, -72, -36, -32, -18, -54, -34, -35, -34, -54, -21, -26, -34, -18, -48, -21, -36, -33, -33, -28, -23, -30, -45, -44, -78, -80, -78, -73, -76, -77, -82, -78, -66, -67, -61, -76, -67, -61, -82, -72, -67, -77, -76, -57, 125, -76, -57, -72};
    }

    static {
        A05();
    }

    public HS(File file, byte[] bArr, boolean z2) {
        this.A07 = z2;
        if (bArr != null) {
            AbstractC0672Ha.A03(bArr.length == 16);
            try {
                this.A05 = A03();
                this.A06 = new SecretKeySpec(bArr, A02(0, 3, 51));
            } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                throw new IllegalStateException(e2);
            }
        } else {
            AbstractC0672Ha.A04(!z2);
            this.A05 = null;
            this.A06 = null;
        }
        this.A04 = new HashMap<>();
        this.A02 = new SparseArray<>();
        this.A03 = new C0674Hc(new File(file, A02(25, 24, 29)));
    }

    public static int A00(SparseArray<String> idToKey) {
        int id;
        int size = idToKey.size();
        if (size == 0) {
            id = 0;
        } else {
            int size2 = size - 1;
            id = idToKey.keyAt(size2) + 1;
        }
        if (id < 0) {
            id = 0;
            while (id < size) {
                int size3 = idToKey.keyAt(id);
                if (id != size3) {
                    break;
                }
                id++;
            }
        }
        return id;
    }

    private HR A01(String str) {
        int id = A00(this.A02);
        HR cachedContent = new HR(id, str);
        A06(cachedContent);
        this.A01 = true;
        return cachedContent;
    }

    public static Cipher A03() throws NoSuchPaddingException, NoSuchAlgorithmException {
        int i = IF.A02;
        String A02 = A02(3, 20, 105);
        if (i == 18) {
            try {
                return Cipher.getInstance(A02, A02(23, 2, 95));
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance(A02);
    }

    private void A04() throws HI {
        try {
            try {
                OutputStream outputStream = this.A03.A03();
                I6 i6 = this.A00;
                if (i6 == null) {
                    this.A00 = new I6(outputStream);
                } else {
                    i6.A00(outputStream);
                }
                DataOutputStream output = new DataOutputStream(this.A00);
                DataOutputStream dataOutputStream = output;
                dataOutputStream.writeInt(2);
                dataOutputStream.writeInt(this.A07 ? 1 : 0);
                if (this.A07) {
                    byte[] bArr = new byte[16];
                    new Random().nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        this.A05.init(1, this.A06, new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        DataOutputStream output2 = new DataOutputStream(new CipherOutputStream(this.A00, this.A05));
                        dataOutputStream = output2;
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                        throw new IllegalStateException(e2);
                    }
                }
                dataOutputStream.writeInt(this.A04.size());
                int i = 0;
                for (HR hr : this.A04.values()) {
                    hr.A0A(dataOutputStream);
                    i += hr.A03(2);
                }
                dataOutputStream.writeInt(i);
                this.A03.A06(dataOutputStream);
                IF.A0X(null);
            } catch (IOException e3) {
                throw new HI(e3);
            }
        } catch (Throwable th) {
            IF.A0X(null);
            throw th;
        }
    }

    private void A06(HR hr) {
        this.A04.put(hr.A03, hr);
        this.A02.put(hr.A02, hr.A03);
    }

    private boolean A07() {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(this.A03.A04());
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            int hashCode = dataInputStream.readInt();
            if (hashCode < 0 || hashCode > 2) {
                IF.A0X(dataInputStream);
                if (A09[5].charAt(29) != 'y') {
                    A09[2] = "8D0UmEy2ZnW8UG7osX1W3JX0L9oaaEfw";
                    return false;
                }
            } else {
                if ((dataInputStream.readInt() & 1) != 0) {
                    if (this.A05 == null) {
                        IF.A0X(dataInputStream);
                        return false;
                    }
                    byte[] bArr = new byte[16];
                    dataInputStream.readFully(bArr);
                    try {
                        this.A05.init(2, this.A06, new IvParameterSpec(bArr));
                        DataInputStream input = new DataInputStream(new CipherInputStream(bufferedInputStream, this.A05));
                        dataInputStream = input;
                    } catch (InvalidAlgorithmParameterException | InvalidKeyException e2) {
                        throw new IllegalStateException(e2);
                    }
                } else if (this.A07) {
                    this.A01 = true;
                }
                int i = dataInputStream.readInt();
                int flags = 0;
                int i5 = 0;
                while (true) {
                    if (i5 < i) {
                        HR A00 = HR.A00(hashCode, dataInputStream);
                        A06(A00);
                        flags += A00.A03(hashCode);
                        if (A09[7].charAt(6) != '2') {
                            break;
                        }
                        String[] strArr = A09;
                        strArr[1] = "ZJbY63HcUYk99Ksy3hc0bS2ufxQ5OOHz";
                        strArr[0] = "iZFtciO5IqW0OGKPKhOgdI0MA24Af7Lq";
                        i5++;
                    } else {
                        int readInt = dataInputStream.readInt();
                        boolean z2 = dataInputStream.read() == -1;
                        if (readInt != flags || !z2) {
                            IF.A0X(dataInputStream);
                            if (A09[2].charAt(4) == 'm') {
                                A09[4] = "rTGlFpYWexwUg47qt5zizIuZpLnI";
                                return false;
                            }
                        } else {
                            IF.A0X(dataInputStream);
                            return true;
                        }
                    }
                }
            }
            throw new RuntimeException();
        } catch (IOException unused) {
            if (0 != 0) {
                IF.A0X(null);
            }
            return false;
        } catch (Throwable th) {
            if (0 != 0) {
                IF.A0X(null);
            }
            throw th;
        }
    }

    public final int A08(String str) {
        return A0A(str).A02;
    }

    public final HR A09(String str) {
        return this.A04.get(str);
    }

    public final HR A0A(String str) {
        HR cachedContent = this.A04.get(str);
        return cachedContent == null ? A01(str) : cachedContent;
    }

    public final HU A0B(String str) {
        HR cachedContent = A09(str);
        return cachedContent != null ? cachedContent.A05() : C1035Vh.A04;
    }

    public final String A0C(int i) {
        return this.A02.get(i);
    }

    public final Collection<HR> A0D() {
        return this.A04.values();
    }

    public final void A0E() {
        AbstractC0672Ha.A04(!this.A01);
        if (!A07()) {
            this.A03.A05();
            this.A04.clear();
            this.A02.clear();
        }
    }

    public final void A0F() {
        String[] strArr = new String[this.A04.size()];
        this.A04.keySet().toArray(strArr);
        for (String str : strArr) {
            A0H(str);
        }
    }

    public final void A0G() throws HI {
        if (!this.A01) {
            return;
        }
        A04();
        this.A01 = false;
    }

    public final void A0H(String str) {
        HR hr = this.A04.get(str);
        if (hr != null && hr.A0C() && !hr.A0D()) {
            this.A04.remove(str);
            this.A02.remove(hr.A02);
            if (A09[7].charAt(6) != '2') {
                throw new RuntimeException();
            }
            A09[7] = "jdWRL72EOrbCMRK3hJiACfcup0he26HP";
            this.A01 = true;
        }
    }

    public final void A0I(String str, HW hw2) {
        HR cachedContent = A0A(str);
        if (cachedContent.A0F(hw2)) {
            this.A01 = true;
        }
    }
}
