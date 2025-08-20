package nc1;

import java.io.IOException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zc1.i9;
import zc1.rz;
/* loaded from: classes.dex */
public class v extends i9 {

    /* renamed from: v  reason: collision with root package name */
    public final Function1<IOException, Unit> f11897v;
    public boolean y;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public v(rz delegate, Function1<? super IOException, Unit> onException) {
        super(delegate);
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(onException, "onException");
        this.f11897v = onException;
    }

    public void close() {
        if (this.y) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.y = true;
            this.f11897v.invoke(e2);
        }
    }

    public void flush() {
        if (this.y) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.y = true;
            this.f11897v.invoke(e2);
        }
    }

    public void write(zc1.v source, long j2) {
        Intrinsics.checkNotNullParameter(source, "source");
        if (this.y) {
            source.skip(j2);
            return;
        }
        try {
            super.write(source, j2);
        } catch (IOException e2) {
            this.y = true;
            this.f11897v.invoke(e2);
        }
    }
}
