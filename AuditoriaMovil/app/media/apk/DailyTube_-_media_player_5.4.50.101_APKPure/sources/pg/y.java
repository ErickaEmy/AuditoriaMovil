package pg;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import free.daily.tube.background.dtoapp.MxApp;
/* loaded from: classes.dex */
public class y {
    public static final String y = MxApp.class.toString();

    @Nullable
    public static SharedPreferences zn(Application application, String str, int i) {
        return n3.a(application, str, i);
    }

    public void a(Application application, @NonNull Configuration configuration) {
        new n3().tl(application, configuration);
    }

    public void c5(Application application, int i) {
        new n3().w(application, i);
    }

    public void fb(Application application) {
        new n3().wz(application);
    }

    public boolean gv(Context context) {
        return new n3().i9(context);
    }

    @Nullable
    public String n3(Context context) {
        return new n3().v(context);
    }

    public void s(Application application) {
        new n3().xc(application);
    }

    public void v(Application application) {
        new n3().t(application);
    }

    public void y(Context context, Application application, Long l2) {
        new n3().y(context, application, l2);
    }
}
