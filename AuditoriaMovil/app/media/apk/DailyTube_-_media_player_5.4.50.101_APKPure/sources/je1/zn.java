package je1;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import ie1.a;
import java.io.IOException;
import kc1.mg;
/* loaded from: classes.dex */
public final class zn<T> implements a<mg, T> {

    /* renamed from: n3  reason: collision with root package name */
    public final TypeAdapter<T> f9455n3;
    public final Gson y;

    public zn(Gson gson, TypeAdapter<T> typeAdapter) {
        this.y = gson;
        this.f9455n3 = typeAdapter;
    }

    @Override // ie1.a
    /* renamed from: y */
    public T convert(mg mgVar) throws IOException {
        JsonReader newJsonReader = this.y.newJsonReader(mgVar.charStream());
        try {
            T read = this.f9455n3.read(newJsonReader);
            if (newJsonReader.peek() == JsonToken.END_DOCUMENT) {
                return read;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            mgVar.close();
        }
    }
}
