package kotlinx.serialization.json;

import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.KSerializer;
/* compiled from: JsonElement.kt */
/* loaded from: classes2.dex */
public final class JsonNull extends JsonPrimitive {
    private static final /* synthetic */ Lazy $cachedSerializer$delegate;
    public static final JsonNull INSTANCE = new JsonNull();
    private static final String content = "null";

    @Override // kotlinx.serialization.json.JsonPrimitive
    public String getContent() {
        return content;
    }

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() { // from class: kotlinx.serialization.json.JsonNull$$cachedSerializer$delegate$1
            @Override // kotlin.jvm.functions.Function0
            public final KSerializer invoke() {
                return JsonNullSerializer.INSTANCE;
            }
        });
        $cachedSerializer$delegate = lazy;
    }

    private JsonNull() {
        super(null);
    }
}
