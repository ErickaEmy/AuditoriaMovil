package kotlinx.serialization.json.internal;

import kotlin.UByte;
import kotlin.UInt;
import kotlin.ULong;
import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: Composers.kt */
/* loaded from: classes2.dex */
public final class ComposerForUnsignedNumbers extends Composer {
    private final boolean forceQuoting;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposerForUnsignedNumbers(JsonWriter writer, boolean z) {
        super(writer);
        Intrinsics.checkNotNullParameter(writer, "writer");
        this.forceQuoting = z;
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(int i) {
        boolean z = this.forceQuoting;
        int m2113constructorimpl = UInt.m2113constructorimpl(i);
        if (z) {
            printQuoted(ComposerForUnsignedNumbers$$ExternalSyntheticBackport2.m(m2113constructorimpl));
        } else {
            print(ComposerForUnsignedNumbers$$ExternalSyntheticBackport3.m(m2113constructorimpl));
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(long j) {
        String m;
        String m2;
        boolean z = this.forceQuoting;
        long m2135constructorimpl = ULong.m2135constructorimpl(j);
        if (z) {
            m2 = ComposerForUnsignedNumbers$$ExternalSyntheticBackport6.m(m2135constructorimpl, 10);
            printQuoted(m2);
            return;
        }
        m = ComposerForUnsignedNumbers$$ExternalSyntheticBackport5.m(m2135constructorimpl, 10);
        print(m);
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(byte b) {
        boolean z = this.forceQuoting;
        String m2094toStringimpl = UByte.m2094toStringimpl(UByte.m2091constructorimpl(b));
        if (z) {
            printQuoted(m2094toStringimpl);
        } else {
            print(m2094toStringimpl);
        }
    }

    @Override // kotlinx.serialization.json.internal.Composer
    public void print(short s) {
        boolean z = this.forceQuoting;
        String m2161toStringimpl = UShort.m2161toStringimpl(UShort.m2158constructorimpl(s));
        if (z) {
            printQuoted(m2161toStringimpl);
        } else {
            print(m2161toStringimpl);
        }
    }
}
