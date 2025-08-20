package kotlinx.serialization.json.internal;

import org.bouncycastle.asn1.cmc.BodyPartID;
/* compiled from: R8$$SyntheticClass */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class ComposerForUnsignedNumbers$$ExternalSyntheticBackport2 {
    public static /* synthetic */ String m(int i) {
        String l;
        l = Long.toString(i & BodyPartID.bodyIdMax, 10);
        return l;
    }
}
