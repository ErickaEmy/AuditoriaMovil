package kotlinx.serialization.json;

import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
/* compiled from: JsonEncoder.kt */
/* loaded from: classes2.dex */
public interface JsonEncoder extends Encoder, CompositeEncoder {
    Json getJson();
}
