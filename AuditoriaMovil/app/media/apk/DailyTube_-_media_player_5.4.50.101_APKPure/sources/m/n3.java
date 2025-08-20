package m;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.Build;
import android.os.CancellationSignal;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import rb.i4;
import u0.fb;
import u0.i9;
/* loaded from: classes.dex */
public final class n3 {
    public static final Cursor n3(i4 db, i9 sqLiteQuery, boolean z2, CancellationSignal cancellationSignal) {
        int i;
        Intrinsics.checkNotNullParameter(db, "db");
        Intrinsics.checkNotNullParameter(sqLiteQuery, "sqLiteQuery");
        Cursor query = db.query(sqLiteQuery, cancellationSignal);
        if (z2 && (query instanceof AbstractWindowedCursor)) {
            AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
            int count = abstractWindowedCursor.getCount();
            if (abstractWindowedCursor.hasWindow()) {
                i = abstractWindowedCursor.getWindow().getNumRows();
            } else {
                i = count;
            }
            if (Build.VERSION.SDK_INT < 23 || i < count) {
                return y.y(query);
            }
            return query;
        }
        return query;
    }

    public static final void y(fb db) {
        Intrinsics.checkNotNullParameter(db, "db");
        List createListBuilder = CollectionsKt.createListBuilder();
        Cursor rb2 = db.rb("SELECT name FROM sqlite_master WHERE type = 'trigger'");
        try {
            Cursor cursor = rb2;
            while (cursor.moveToNext()) {
                createListBuilder.add(cursor.getString(0));
            }
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(rb2, null);
            for (String triggerName : CollectionsKt.build(createListBuilder)) {
                Intrinsics.checkNotNullExpressionValue(triggerName, "triggerName");
                if (StringsKt.startsWith$default(triggerName, "room_fts_content_sync_", false, 2, (Object) null)) {
                    db.execSQL("DROP TRIGGER IF EXISTS " + triggerName);
                }
            }
        } finally {
        }
    }

    public static final int zn(File databaseFile) throws IOException {
        Intrinsics.checkNotNullParameter(databaseFile, "databaseFile");
        FileChannel channel = new FileInputStream(databaseFile).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60L, 4L, true);
            channel.position(60L);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i = allocate.getInt();
                CloseableKt.closeFinally(channel, null);
                return i;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(channel, th);
                throw th2;
            }
        }
    }
}
