package di;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
/* loaded from: classes.dex */
public final class a {

    /* renamed from: zn  reason: collision with root package name */
    public static final String[] f7248zn = {"name", "length", "last_touch_timestamp"};

    /* renamed from: n3  reason: collision with root package name */
    public String f7249n3;
    public final da.n3 y;

    public a(da.n3 n3Var) {
        this.y = n3Var;
    }

    public static String gv(String str) {
        return "ExoPlayerCacheFileMetadata" + str;
    }

    public static void y(SQLiteDatabase sQLiteDatabase, String str) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
    }

    public void a(String str) throws da.y {
        v5.y.v(this.f7249n3);
        try {
            this.y.getWritableDatabase().delete(this.f7249n3, "name = ?", new String[]{str});
        } catch (SQLException e2) {
            throw new da.y(e2);
        }
    }

    public void fb(Set<String> set) throws da.y {
        v5.y.v(this.f7249n3);
        try {
            SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
            writableDatabase.beginTransactionNonExclusive();
            for (String str : set) {
                writableDatabase.delete(this.f7249n3, "name = ?", new String[]{str});
            }
            writableDatabase.setTransactionSuccessful();
            writableDatabase.endTransaction();
        } catch (SQLException e2) {
            throw new da.y(e2);
        }
    }

    public Map<String, v> n3() throws da.y {
        try {
            Cursor zn2 = zn();
            HashMap hashMap = new HashMap(zn2.getCount());
            while (zn2.moveToNext()) {
                hashMap.put((String) v5.y.v(zn2.getString(0)), new v(zn2.getLong(1), zn2.getLong(2)));
            }
            zn2.close();
            return hashMap;
        } catch (SQLException e2) {
            throw new da.y(e2);
        }
    }

    public void s(String str, long j2, long j4) throws da.y {
        v5.y.v(this.f7249n3);
        try {
            SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("name", str);
            contentValues.put("length", Long.valueOf(j2));
            contentValues.put("last_touch_timestamp", Long.valueOf(j4));
            writableDatabase.replaceOrThrow(this.f7249n3, null, contentValues);
        } catch (SQLException e2) {
            throw new da.y(e2);
        }
    }

    public void v(long j2) throws da.y {
        try {
            String hexString = Long.toHexString(j2);
            this.f7249n3 = gv(hexString);
            if (da.gv.n3(this.y.getReadableDatabase(), 2, hexString) != 1) {
                SQLiteDatabase writableDatabase = this.y.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                da.gv.gv(writableDatabase, 2, hexString, 1);
                y(writableDatabase, this.f7249n3);
                writableDatabase.execSQL("CREATE TABLE " + this.f7249n3 + " (name TEXT PRIMARY KEY NOT NULL,length INTEGER NOT NULL,last_touch_timestamp INTEGER NOT NULL)");
                writableDatabase.setTransactionSuccessful();
                writableDatabase.endTransaction();
            }
        } catch (SQLException e2) {
            throw new da.y(e2);
        }
    }

    public final Cursor zn() {
        v5.y.v(this.f7249n3);
        return this.y.getReadableDatabase().query(this.f7249n3, f7248zn, null, null, null, null, null);
    }
}
