package di;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import v5.j5;
import z0.c;
import z0.en;
/* loaded from: classes.dex */
public class t {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public zn f7284a;

    /* renamed from: gv  reason: collision with root package name */
    public final SparseBooleanArray f7285gv;

    /* renamed from: n3  reason: collision with root package name */
    public final SparseArray<String> f7286n3;

    /* renamed from: v  reason: collision with root package name */
    public zn f7287v;
    public final HashMap<String, f> y;

    /* renamed from: zn  reason: collision with root package name */
    public final SparseBooleanArray f7288zn;

    /* loaded from: classes.dex */
    public static final class y implements zn {

        /* renamed from: v  reason: collision with root package name */
        public static final String[] f7295v = {"id", "key", "metadata"};

        /* renamed from: gv  reason: collision with root package name */
        public String f7296gv;

        /* renamed from: n3  reason: collision with root package name */
        public final SparseArray<f> f7297n3 = new SparseArray<>();
        public final da.n3 y;

        /* renamed from: zn  reason: collision with root package name */
        public String f7298zn;

        public y(da.n3 n3Var) {
            this.y = n3Var;
        }

        public static void c5(da.n3 n3Var, String str) throws da.y {
            try {
                String tl2 = tl(str);
                SQLiteDatabase writableDatabase = n3Var.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                da.gv.zn(writableDatabase, 1, str);
                f(writableDatabase, tl2);
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new da.y(e2);
            }
        }

        public static void f(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String tl(String str) {
            return "ExoPlayerCacheIndex" + str;
        }

        @Override // di.t.zn
        public void a(HashMap<String, f> hashMap) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                wz(writableDatabase);
                for (f fVar : hashMap.values()) {
                    s(writableDatabase, fVar);
                }
                writableDatabase.setTransactionSuccessful();
                this.f7297n3.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new da.y(e2);
            }
        }

        @Override // di.t.zn
        public void delete() throws da.y {
            c5(this.y, (String) v5.y.v(this.f7298zn));
        }

        @Override // di.t.zn
        public void fb(HashMap<String, f> hashMap, SparseArray<String> sparseArray) throws IOException {
            boolean z2;
            if (this.f7297n3.size() == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            v5.y.fb(z2);
            try {
                if (da.gv.n3(this.y.getReadableDatabase(), 1, (String) v5.y.v(this.f7298zn)) != 1) {
                    SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    wz(writableDatabase);
                    writableDatabase.setTransactionSuccessful();
                    writableDatabase.endTransaction();
                }
                Cursor t2 = t();
                while (t2.moveToNext()) {
                    f fVar = new f(t2.getInt(0), (String) v5.y.v(t2.getString(1)), t.mt(new DataInputStream(new ByteArrayInputStream(t2.getBlob(2)))));
                    hashMap.put(fVar.f7256n3, fVar);
                    sparseArray.put(fVar.y, fVar.f7256n3);
                }
                t2.close();
            } catch (SQLiteException e2) {
                hashMap.clear();
                sparseArray.clear();
                throw new da.y(e2);
            }
        }

        @Override // di.t.zn
        public void gv(HashMap<String, f> hashMap) throws IOException {
            if (this.f7297n3.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.f7297n3.size(); i++) {
                    f valueAt = this.f7297n3.valueAt(i);
                    if (valueAt == null) {
                        i9(writableDatabase, this.f7297n3.keyAt(i));
                    } else {
                        s(writableDatabase, valueAt);
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f7297n3.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new da.y(e2);
            }
        }

        public final void i9(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) v5.y.v(this.f7296gv), "id = ?", new String[]{Integer.toString(i)});
        }

        @Override // di.t.zn
        public void n3(f fVar) {
            this.f7297n3.put(fVar.y, fVar);
        }

        public final void s(SQLiteDatabase sQLiteDatabase, f fVar) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            t.r(fVar.gv(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(fVar.y));
            contentValues.put("key", fVar.f7256n3);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) v5.y.v(this.f7296gv), null, contentValues);
        }

        public final Cursor t() {
            return this.y.getReadableDatabase().query((String) v5.y.v(this.f7296gv), f7295v, null, null, null, null, null);
        }

        @Override // di.t.zn
        public void v(long j2) {
            String hexString = Long.toHexString(j2);
            this.f7298zn = hexString;
            this.f7296gv = tl(hexString);
        }

        public final void wz(SQLiteDatabase sQLiteDatabase) throws da.y {
            da.gv.gv(sQLiteDatabase, 1, (String) v5.y.v(this.f7298zn), 1);
            f(sQLiteDatabase, (String) v5.y.v(this.f7296gv));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f7296gv + " (id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)");
        }

        @Override // di.t.zn
        public void y(f fVar, boolean z2) {
            if (z2) {
                this.f7297n3.delete(fVar.y);
            } else {
                this.f7297n3.put(fVar.y, null);
            }
        }

        @Override // di.t.zn
        public boolean zn() throws da.y {
            try {
                if (da.gv.n3(this.y.getReadableDatabase(), 1, (String) v5.y.v(this.f7298zn)) != -1) {
                    return true;
                }
                return false;
            } catch (SQLException e2) {
                throw new da.y(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface zn {
        void a(HashMap<String, f> hashMap) throws IOException;

        void delete() throws IOException;

        void fb(HashMap<String, f> hashMap, SparseArray<String> sparseArray) throws IOException;

        void gv(HashMap<String, f> hashMap) throws IOException;

        void n3(f fVar);

        void v(long j2);

        void y(f fVar, boolean z2);

        boolean zn() throws IOException;
    }

    public t(@Nullable da.n3 n3Var, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        boolean z4;
        y yVar;
        if (n3Var == null && file == null) {
            z4 = false;
        } else {
            z4 = true;
        }
        v5.y.fb(z4);
        this.y = new HashMap<>();
        this.f7286n3 = new SparseArray<>();
        this.f7288zn = new SparseBooleanArray();
        this.f7285gv = new SparseBooleanArray();
        if (n3Var != null) {
            yVar = new y(n3Var);
        } else {
            yVar = null;
        }
        n3 n3Var2 = file != null ? new n3(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (yVar != null && (n3Var2 == null || !z3)) {
            this.f7287v = yVar;
            this.f7284a = n3Var2;
            return;
        }
        this.f7287v = (zn) j5.i9(n3Var2);
        this.f7284a = yVar;
    }

    @SuppressLint({"GetInstance"})
    public static Cipher c5() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (j5.y == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    public static w mt(DataInputStream dataInputStream) throws IOException {
        int readInt = dataInputStream.readInt();
        HashMap hashMap = new HashMap();
        for (int i = 0; i < readInt; i++) {
            String readUTF = dataInputStream.readUTF();
            int readInt2 = dataInputStream.readInt();
            if (readInt2 >= 0) {
                int min = Math.min(readInt2, 10485760);
                byte[] bArr = j5.f14357a;
                int i5 = 0;
                while (i5 != readInt2) {
                    int i6 = i5 + min;
                    bArr = Arrays.copyOf(bArr, i6);
                    dataInputStream.readFully(bArr, i5, min);
                    min = Math.min(readInt2 - i6, 10485760);
                    i5 = i6;
                }
                hashMap.put(readUTF, bArr);
            } else {
                throw new IOException("Invalid value size: " + readInt2);
            }
        }
        return new w(hashMap);
    }

    public static void r(w wVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> a2 = wVar.a();
        dataOutputStream.writeInt(a2.size());
        for (Map.Entry<String, byte[]> entry : a2) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public static int tl(SparseArray<String> sparseArray) {
        int keyAt;
        int size = sparseArray.size();
        int i = 0;
        if (size == 0) {
            keyAt = 0;
        } else {
            keyAt = sparseArray.keyAt(size - 1) + 1;
        }
        if (keyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            return i;
        }
        return keyAt;
    }

    public static boolean w(String str) {
        return str.startsWith("cached_content_index.exi");
    }

    public static /* synthetic */ Cipher y() throws NoSuchPaddingException, NoSuchAlgorithmException {
        return c5();
    }

    public int a(String str) {
        return wz(str).y;
    }

    public void co() {
        en it = c.x4(this.y.keySet()).iterator();
        while (it.hasNext()) {
            p((String) it.next());
        }
    }

    @Nullable
    public String f(int i) {
        return this.f7286n3.get(i);
    }

    @Nullable
    public f fb(String str) {
        return this.y.get(str);
    }

    public final f gv(String str) {
        int tl2 = tl(this.f7286n3);
        f fVar = new f(tl2, str);
        this.y.put(str, fVar);
        this.f7286n3.put(tl2, str);
        this.f7285gv.put(tl2, true);
        this.f7287v.n3(fVar);
        return fVar;
    }

    public wz i9(String str) {
        f fb2 = fb(str);
        if (fb2 != null) {
            return fb2.gv();
        }
        return w.f7300zn;
    }

    public void p(String str) {
        f fVar = this.y.get(str);
        if (fVar != null && fVar.fb() && fVar.c5()) {
            this.y.remove(str);
            int i = fVar.y;
            boolean z2 = this.f7285gv.get(i);
            this.f7287v.y(fVar, z2);
            if (z2) {
                this.f7286n3.remove(i);
                this.f7285gv.delete(i);
                return;
            }
            this.f7286n3.put(i, null);
            this.f7288zn.put(i, true);
        }
    }

    public Collection<f> s() {
        return Collections.unmodifiableCollection(this.y.values());
    }

    public Set<String> t() {
        return this.y.keySet();
    }

    public void v(String str, xc xcVar) {
        f wz2 = wz(str);
        if (wz2.n3(xcVar)) {
            this.f7287v.n3(wz2);
        }
    }

    public f wz(String str) {
        f fVar = this.y.get(str);
        if (fVar == null) {
            return gv(str);
        }
        return fVar;
    }

    public void xc(long j2) throws IOException {
        zn znVar;
        this.f7287v.v(j2);
        zn znVar2 = this.f7284a;
        if (znVar2 != null) {
            znVar2.v(j2);
        }
        if (!this.f7287v.zn() && (znVar = this.f7284a) != null && znVar.zn()) {
            this.f7284a.fb(this.y, this.f7286n3);
            this.f7287v.a(this.y);
        } else {
            this.f7287v.fb(this.y, this.f7286n3);
        }
        zn znVar3 = this.f7284a;
        if (znVar3 != null) {
            znVar3.delete();
            this.f7284a = null;
        }
    }

    public void z() throws IOException {
        this.f7287v.gv(this.y);
        int size = this.f7288zn.size();
        for (int i = 0; i < size; i++) {
            this.f7286n3.remove(this.f7288zn.keyAt(i));
        }
        this.f7288zn.clear();
        this.f7285gv.clear();
    }

    /* loaded from: classes.dex */
    public static class n3 implements zn {

        /* renamed from: a  reason: collision with root package name */
        public boolean f7289a;
        @Nullable

        /* renamed from: fb  reason: collision with root package name */
        public co f7290fb;
        @Nullable

        /* renamed from: gv  reason: collision with root package name */
        public final SecureRandom f7291gv;
        @Nullable

        /* renamed from: n3  reason: collision with root package name */
        public final Cipher f7292n3;

        /* renamed from: v  reason: collision with root package name */
        public final v5.n3 f7293v;
        public final boolean y;
        @Nullable

        /* renamed from: zn  reason: collision with root package name */
        public final SecretKeySpec f7294zn;

        public n3(File file, @Nullable byte[] bArr, boolean z2) {
            boolean z3;
            Cipher cipher;
            SecretKeySpec secretKeySpec;
            if (bArr == null && z2) {
                z3 = false;
            } else {
                z3 = true;
            }
            v5.y.fb(z3);
            if (bArr != null) {
                v5.y.y(bArr.length == 16);
                try {
                    cipher = t.y();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e2) {
                    throw new IllegalStateException(e2);
                }
            } else {
                v5.y.y(!z2);
                cipher = null;
                secretKeySpec = null;
            }
            this.y = z2;
            this.f7292n3 = cipher;
            this.f7294zn = secretKeySpec;
            this.f7291gv = z2 ? new SecureRandom() : null;
            this.f7293v = new v5.n3(file);
        }

        @Override // di.t.zn
        public void a(HashMap<String, f> hashMap) throws IOException {
            t(hashMap);
            this.f7289a = false;
        }

        public final f c5(int i, DataInputStream dataInputStream) throws IOException {
            w mt2;
            int readInt = dataInputStream.readInt();
            String readUTF = dataInputStream.readUTF();
            if (i >= 2) {
                mt2 = t.mt(dataInputStream);
            } else {
                long readLong = dataInputStream.readLong();
                xc xcVar = new xc();
                xc.fb(xcVar, readLong);
                mt2 = w.f7300zn.v(xcVar);
            }
            return new f(readInt, readUTF, mt2);
        }

        @Override // di.t.zn
        public void delete() {
            this.f7293v.y();
        }

        public final void f(f fVar, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(fVar.y);
            dataOutputStream.writeUTF(fVar.f7256n3);
            t.r(fVar.gv(), dataOutputStream);
        }

        @Override // di.t.zn
        public void fb(HashMap<String, f> hashMap, SparseArray<String> sparseArray) {
            v5.y.fb(!this.f7289a);
            if (!i9(hashMap, sparseArray)) {
                hashMap.clear();
                sparseArray.clear();
                this.f7293v.y();
            }
        }

        @Override // di.t.zn
        public void gv(HashMap<String, f> hashMap) throws IOException {
            if (!this.f7289a) {
                return;
            }
            a(hashMap);
        }

        public final boolean i9(HashMap<String, f> hashMap, SparseArray<String> sparseArray) {
            BufferedInputStream bufferedInputStream;
            DataInputStream dataInputStream;
            boolean z2;
            if (!this.f7293v.zn()) {
                return true;
            }
            DataInputStream dataInputStream2 = null;
            try {
                bufferedInputStream = new BufferedInputStream(this.f7293v.gv());
                dataInputStream = new DataInputStream(bufferedInputStream);
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
            }
            try {
                int readInt = dataInputStream.readInt();
                if (readInt >= 0 && readInt <= 2) {
                    if ((dataInputStream.readInt() & 1) != 0) {
                        if (this.f7292n3 == null) {
                            j5.wz(dataInputStream);
                            return false;
                        }
                        byte[] bArr = new byte[16];
                        dataInputStream.readFully(bArr);
                        try {
                            this.f7292n3.init(2, (Key) j5.i9(this.f7294zn), new IvParameterSpec(bArr));
                            dataInputStream = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f7292n3));
                        } catch (InvalidAlgorithmParameterException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e3) {
                            e = e3;
                            throw new IllegalStateException(e);
                        }
                    } else if (this.y) {
                        this.f7289a = true;
                    }
                    int readInt2 = dataInputStream.readInt();
                    int i = 0;
                    for (int i5 = 0; i5 < readInt2; i5++) {
                        f c52 = c5(readInt, dataInputStream);
                        hashMap.put(c52.f7256n3, c52);
                        sparseArray.put(c52.y, c52.f7256n3);
                        i += s(c52, readInt);
                    }
                    int readInt3 = dataInputStream.readInt();
                    if (dataInputStream.read() == -1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (readInt3 == i && z2) {
                        j5.wz(dataInputStream);
                        return true;
                    }
                    j5.wz(dataInputStream);
                    return false;
                }
                j5.wz(dataInputStream);
                return false;
            } catch (IOException unused2) {
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    j5.wz(dataInputStream2);
                }
                return false;
            } catch (Throwable th2) {
                th = th2;
                dataInputStream2 = dataInputStream;
                if (dataInputStream2 != null) {
                    j5.wz(dataInputStream2);
                }
                throw th;
            }
        }

        @Override // di.t.zn
        public void n3(f fVar) {
            this.f7289a = true;
        }

        public final int s(f fVar, int i) {
            int hashCode = (fVar.y * 31) + fVar.f7256n3.hashCode();
            if (i < 2) {
                long y = tl.y(fVar.gv());
                return (hashCode * 31) + ((int) (y ^ (y >>> 32)));
            }
            return (hashCode * 31) + fVar.gv().hashCode();
        }

        public final void t(HashMap<String, f> hashMap) throws IOException {
            co coVar;
            DataOutputStream dataOutputStream;
            DataOutputStream dataOutputStream2 = null;
            try {
                OutputStream a2 = this.f7293v.a();
                co coVar2 = this.f7290fb;
                if (coVar2 == null) {
                    this.f7290fb = new co(a2);
                } else {
                    coVar2.y(a2);
                }
                coVar = this.f7290fb;
                dataOutputStream = new DataOutputStream(coVar);
            } catch (Throwable th) {
                th = th;
            }
            try {
                dataOutputStream.writeInt(2);
                int i = 0;
                dataOutputStream.writeInt(this.y ? 1 : 0);
                if (this.y) {
                    byte[] bArr = new byte[16];
                    ((SecureRandom) j5.i9(this.f7291gv)).nextBytes(bArr);
                    dataOutputStream.write(bArr);
                    try {
                        ((Cipher) j5.i9(this.f7292n3)).init(1, (Key) j5.i9(this.f7294zn), new IvParameterSpec(bArr));
                        dataOutputStream.flush();
                        dataOutputStream = new DataOutputStream(new CipherOutputStream(coVar, this.f7292n3));
                    } catch (InvalidAlgorithmParameterException e2) {
                        e = e2;
                        throw new IllegalStateException(e);
                    } catch (InvalidKeyException e3) {
                        e = e3;
                        throw new IllegalStateException(e);
                    }
                }
                dataOutputStream.writeInt(hashMap.size());
                for (f fVar : hashMap.values()) {
                    f(fVar, dataOutputStream);
                    i += s(fVar, 2);
                }
                dataOutputStream.writeInt(i);
                this.f7293v.n3(dataOutputStream);
                j5.wz(null);
            } catch (Throwable th2) {
                th = th2;
                dataOutputStream2 = dataOutputStream;
                j5.wz(dataOutputStream2);
                throw th;
            }
        }

        @Override // di.t.zn
        public void y(f fVar, boolean z2) {
            this.f7289a = true;
        }

        @Override // di.t.zn
        public boolean zn() {
            return this.f7293v.zn();
        }

        @Override // di.t.zn
        public void v(long j2) {
        }
    }
}
