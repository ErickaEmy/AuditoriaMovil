package rb;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.Intrinsics;
import rb.i4;
import u0.s;
/* loaded from: classes.dex */
public class s {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f13241a;

    /* renamed from: c5  reason: collision with root package name */
    public final Executor f13242c5;

    /* renamed from: co  reason: collision with root package name */
    public final boolean f13243co;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f13244f;

    /* renamed from: fb  reason: collision with root package name */
    public final i4.gv f13245fb;

    /* renamed from: gv  reason: collision with root package name */
    public final i4.v f13246gv;

    /* renamed from: i9  reason: collision with root package name */
    public final Intent f13247i9;

    /* renamed from: mt  reason: collision with root package name */
    public final List<Object> f13248mt;

    /* renamed from: n3  reason: collision with root package name */
    public final String f13249n3;

    /* renamed from: p  reason: collision with root package name */
    public final List<Object> f13250p;

    /* renamed from: s  reason: collision with root package name */
    public final Executor f13251s;

    /* renamed from: t  reason: collision with root package name */
    public final boolean f13252t;

    /* renamed from: tl  reason: collision with root package name */
    public final Set<Integer> f13253tl;

    /* renamed from: v  reason: collision with root package name */
    public final List<i4.n3> f13254v;

    /* renamed from: w  reason: collision with root package name */
    public final Callable<InputStream> f13255w;

    /* renamed from: wz  reason: collision with root package name */
    public final String f13256wz;

    /* renamed from: xc  reason: collision with root package name */
    public final File f13257xc;
    public final Context y;

    /* renamed from: zn  reason: collision with root package name */
    public final s.zn f13258zn;

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"LambdaLast"})
    public s(Context context, String str, s.zn sqliteOpenHelperFactory, i4.v migrationContainer, List<? extends i4.n3> list, boolean z2, i4.gv journalMode, Executor queryExecutor, Executor transactionExecutor, Intent intent, boolean z3, boolean z4, Set<Integer> set, String str2, File file, Callable<InputStream> callable, i4.a aVar, List<? extends Object> typeConverters, List<Object> autoMigrationSpecs) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(sqliteOpenHelperFactory, "sqliteOpenHelperFactory");
        Intrinsics.checkNotNullParameter(migrationContainer, "migrationContainer");
        Intrinsics.checkNotNullParameter(journalMode, "journalMode");
        Intrinsics.checkNotNullParameter(queryExecutor, "queryExecutor");
        Intrinsics.checkNotNullParameter(transactionExecutor, "transactionExecutor");
        Intrinsics.checkNotNullParameter(typeConverters, "typeConverters");
        Intrinsics.checkNotNullParameter(autoMigrationSpecs, "autoMigrationSpecs");
        this.y = context;
        this.f13249n3 = str;
        this.f13258zn = sqliteOpenHelperFactory;
        this.f13246gv = migrationContainer;
        this.f13254v = list;
        this.f13241a = z2;
        this.f13245fb = journalMode;
        this.f13251s = queryExecutor;
        this.f13242c5 = transactionExecutor;
        this.f13247i9 = intent;
        this.f13244f = z3;
        this.f13252t = z4;
        this.f13253tl = set;
        this.f13256wz = str2;
        this.f13257xc = file;
        this.f13255w = callable;
        this.f13250p = typeConverters;
        this.f13248mt = autoMigrationSpecs;
        this.f13243co = intent != null;
    }

    public boolean y(int i, int i5) {
        if ((i > i5 && this.f13252t) || !this.f13244f) {
            return false;
        }
        Set<Integer> set = this.f13253tl;
        if (set != null && set.contains(Integer.valueOf(i))) {
            return false;
        }
        return true;
    }
}
