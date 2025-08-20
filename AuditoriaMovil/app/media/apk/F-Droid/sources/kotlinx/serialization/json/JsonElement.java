package kotlinx.serialization.json;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.serialization.KSerializer;
/* compiled from: JsonElement.kt */
/* loaded from: classes2.dex */
public abstract class JsonElement {
    public static final Companion Companion = new Companion(null);

    public /* synthetic */ JsonElement(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* compiled from: JsonElement.kt */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return JsonElementSerializer.INSTANCE;
        }
    }

    private JsonElement() {
    }
}
