package je1;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonWriter;
import ie1.a;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import kc1.fh;
import kc1.i4;
import zc1.v;
/* loaded from: classes.dex */
public final class n3<T> implements a<T, fh> {

    /* renamed from: n3  reason: collision with root package name */
    public final TypeAdapter<T> f9454n3;
    public final Gson y;

    /* renamed from: zn  reason: collision with root package name */
    public static final i4 f9453zn = i4.v("application/json; charset=UTF-8");

    /* renamed from: gv  reason: collision with root package name */
    public static final Charset f9452gv = Charset.forName("UTF-8");

    public n3(Gson gson, TypeAdapter<T> typeAdapter) {
        this.y = gson;
        this.f9454n3 = typeAdapter;
    }

    @Override // ie1.a
    /* renamed from: y */
    public fh convert(T t2) throws IOException {
        v vVar = new v();
        JsonWriter newJsonWriter = this.y.newJsonWriter(new OutputStreamWriter(vVar.q5(), f9452gv));
        this.f9454n3.write(newJsonWriter, t2);
        newJsonWriter.close();
        return fh.create(f9453zn, vVar.bk());
    }
}
