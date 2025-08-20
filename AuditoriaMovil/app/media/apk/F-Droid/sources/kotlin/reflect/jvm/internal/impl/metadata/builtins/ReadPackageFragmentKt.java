package kotlin.reflect.jvm.internal.impl.metadata.builtins;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.ExtensionRegistryLite;
/* compiled from: readPackageFragment.kt */
/* loaded from: classes2.dex */
public abstract class ReadPackageFragmentKt {
    public static final Pair readBuiltinsPackageFragment(InputStream inputStream) {
        ProtoBuf$PackageFragment protoBuf$PackageFragment;
        Intrinsics.checkNotNullParameter(inputStream, "<this>");
        try {
            BuiltInsBinaryVersion readFrom = BuiltInsBinaryVersion.Companion.readFrom(inputStream);
            if (readFrom.isCompatibleWithCurrentCompilerVersion()) {
                ExtensionRegistryLite newInstance = ExtensionRegistryLite.newInstance();
                BuiltInsProtoBuf.registerAllExtensions(newInstance);
                protoBuf$PackageFragment = ProtoBuf$PackageFragment.parseFrom(inputStream, newInstance);
            } else {
                protoBuf$PackageFragment = null;
            }
            Pair pair = TuplesKt.to(protoBuf$PackageFragment, readFrom);
            CloseableKt.closeFinally(inputStream, null);
            return pair;
        } finally {
        }
    }
}
