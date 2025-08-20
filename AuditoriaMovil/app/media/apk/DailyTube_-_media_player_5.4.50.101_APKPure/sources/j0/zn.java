package j0;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.IllegalFormatException;
import java.util.Locale;
/* loaded from: classes.dex */
public final class zn {
    public final String y;

    public zn(String str) {
        String str2;
        int myUid = Process.myUid();
        int myPid = Process.myPid();
        StringBuilder sb = new StringBuilder(39);
        sb.append("UID: [");
        sb.append(myUid);
        sb.append("]  PID: [");
        sb.append(myPid);
        sb.append("] ");
        String sb2 = sb.toString();
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = sb2.concat(valueOf);
        } else {
            str2 = new String(sb2);
        }
        this.y = str2;
    }

    public static String a(String str, String str2, @Nullable Object... objArr) {
        String str3;
        if (objArr.length > 0) {
            try {
                str2 = String.format(Locale.US, str2, objArr);
            } catch (IllegalFormatException e2) {
                String valueOf = String.valueOf(str2);
                if (valueOf.length() != 0) {
                    str3 = "Unable to format ".concat(valueOf);
                } else {
                    str3 = new String("Unable to format ");
                }
                Log.e("PlayCore", str3, e2);
                String join = TextUtils.join(", ", objArr);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 3 + String.valueOf(join).length());
                sb.append(str2);
                sb.append(" [");
                sb.append(join);
                sb.append("]");
                str2 = sb.toString();
            }
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb2.append(str);
        sb2.append(" : ");
        sb2.append(str2);
        return sb2.toString();
    }

    public final int gv(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 4)) {
            return Log.i("PlayCore", a(this.y, str, objArr));
        }
        return 0;
    }

    public final int n3(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", a(this.y, str, objArr));
        }
        return 0;
    }

    public final int v(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 5)) {
            return Log.w("PlayCore", a(this.y, str, objArr));
        }
        return 0;
    }

    public final int y(String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 3)) {
            return Log.d("PlayCore", a(this.y, str, objArr));
        }
        return 0;
    }

    public final int zn(Throwable th, String str, @Nullable Object... objArr) {
        if (Log.isLoggable("PlayCore", 6)) {
            return Log.e("PlayCore", a(this.y, str, objArr), th);
        }
        return 0;
    }
}
