package da;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import m1.kp;
import v5.j5;
/* loaded from: classes.dex */
public final class gv {
    static {
        kp.y("goog.exo.database");
    }

    public static void gv(SQLiteDatabase sQLiteDatabase, int i, String str, int i5) throws y {
        try {
            sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS ExoPlayerVersions (feature INTEGER NOT NULL,instance_uid TEXT NOT NULL,version INTEGER NOT NULL,PRIMARY KEY (feature, instance_uid))");
            ContentValues contentValues = new ContentValues();
            contentValues.put("feature", Integer.valueOf(i));
            contentValues.put("instance_uid", str);
            contentValues.put("version", Integer.valueOf(i5));
            sQLiteDatabase.replaceOrThrow("ExoPlayerVersions", null, contentValues);
        } catch (SQLException e2) {
            throw new y(e2);
        }
    }

    public static int n3(SQLiteDatabase sQLiteDatabase, int i, String str) throws y {
        try {
            if (!j5.i3(sQLiteDatabase, "ExoPlayerVersions")) {
                return -1;
            }
            Cursor query = sQLiteDatabase.query("ExoPlayerVersions", new String[]{"version"}, "feature = ? AND instance_uid = ?", y(i, str), null, null, null);
            if (query.getCount() == 0) {
                query.close();
                return -1;
            }
            query.moveToNext();
            int i5 = query.getInt(0);
            query.close();
            return i5;
        } catch (SQLException e2) {
            throw new y(e2);
        }
    }

    public static String[] y(int i, String str) {
        return new String[]{Integer.toString(i), str};
    }

    public static void zn(SQLiteDatabase sQLiteDatabase, int i, String str) throws y {
        try {
            if (!j5.i3(sQLiteDatabase, "ExoPlayerVersions")) {
                return;
            }
            sQLiteDatabase.delete("ExoPlayerVersions", "feature = ? AND instance_uid = ?", y(i, str));
        } catch (SQLException e2) {
            throw new y(e2);
        }
    }
}
