package org.fdroid.index.v2;

import androidx.compose.animation.FlingCalculator$FlingInfo$$ExternalSyntheticBackport0;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.i18n.ErrorBundle;
import org.fdroid.fdroid.views.apps.AppListActivity;
/* compiled from: PackageV2.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\bE\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u0081\u00012\u00020\u0001:\u0004\u0080\u0001\u0081\u0001BÝ\u0003\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u001a\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001a\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0015\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\u001a\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001a\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001a\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001a\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001a\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\b\u0010(\u001a\u0004\u0018\u00010)\u0012\b\u0010*\u001a\u0004\u0018\u00010+¢\u0006\u0002\u0010,Bý\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#\u0012\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007\u0012\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010-J\u001d\u0010Q\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010U\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015HÆ\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010\\\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010`\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u001d\u0010b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#HÆ\u0003J\u001d\u0010c\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#HÆ\u0003J\u001d\u0010d\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#HÆ\u0003J\u001d\u0010e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#HÆ\u0003J\u001d\u0010f\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\u001d\u0010g\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007HÆ\u0003J\u000b\u0010h\u001a\u0004\u0018\u00010)HÆ\u0003J\t\u0010i\u001a\u00020\u000bHÆ\u0003J\t\u0010j\u001a\u00020\u000bHÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0085\u0004\u0010o\u001a\u00020\u00002\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u001c\b\u0002\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\u001c\b\u0002\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\u000e\b\u0002\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u00152\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\u001c\b\u0002\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#2\u001c\b\u0002\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#2\u001c\b\u0002\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#2\u001c\b\u0002\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#2\u001c\b\u0002\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u00072\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)HÆ\u0001J\u0013\u0010p\u001a\u00020q2\b\u0010r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010s\u001a\u00020\u0003HÖ\u0001J\t\u0010t\u001a\u00020\u0006HÖ\u0001J\u001c\u0010u\u001a\u00020v2\u0014\u0010w\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\"\u0012\u0004\u0012\u00020v0xJ&\u0010y\u001a\u00020v2\u0006\u0010z\u001a\u00020\u00002\u0006\u0010{\u001a\u00020|2\u0006\u0010}\u001a\u00020~HÁ\u0001¢\u0006\u0002\b\u007fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u00101R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b3\u00101R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00101R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00101R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\b\n\u0000\u001a\u0004\b6\u00107R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00101R%\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00060\u0015¢\u0006\b\n\u0000\u001a\u0004\b;\u00107R%\u0010$\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#¢\u0006\b\n\u0000\u001a\u0004\b<\u0010:R\u0013\u0010 \u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00101R%\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#¢\u0006\b\n\u0000\u001a\u0004\b>\u0010:R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00101R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010/R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u00101R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u00101R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u00101R\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bD\u00101R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\bE\u0010:R\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bF\u00101R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u00101R%\u0010%\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#¢\u0006\b\n\u0000\u001a\u0004\bH\u0010:R\u0013\u0010(\u001a\u0004\u0018\u00010)¢\u0006\b\n\u0000\u001a\u0004\bI\u0010JR\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u00101R%\u0010\b\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\bL\u0010:R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u00101R%\u0010&\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\"\u0018\u00010\u0005j\u0004\u0018\u0001`#¢\u0006\b\n\u0000\u001a\u0004\bN\u0010:R%\u0010'\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\bO\u0010:R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bP\u00101¨\u0006\u0082\u0001"}, d2 = {"Lorg/fdroid/index/v2/MetadataV2;", "", "seen1", "", "name", "", "", "Lorg/fdroid/index/v2/LocalizedTextV2;", ErrorBundle.SUMMARY_ENTRY, "description", "added", "", AppListActivity.SortClause.LAST_UPDATED, "webSite", "changelog", "license", "sourceCode", "issueTracker", "translation", "preferredSigner", "categories", "", "authorName", "authorEmail", "authorWebSite", "authorPhone", "donate", "liberapayID", "liberapay", "openCollective", "bitcoin", "litecoin", "flattrID", "icon", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileV2;", "featureGraphic", "promoGraphic", "tvBanner", "video", "screenshots", "Lorg/fdroid/index/v2/Screenshots;", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lorg/fdroid/index/v2/Screenshots;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;JJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Lorg/fdroid/index/v2/Screenshots;)V", "getAdded", "()J", "getAuthorEmail", "()Ljava/lang/String;", "getAuthorName", "getAuthorPhone", "getAuthorWebSite", "getBitcoin", "getCategories", "()Ljava/util/List;", "getChangelog", "getDescription", "()Ljava/util/Map;", "getDonate", "getFeatureGraphic", "getFlattrID", "getIcon", "getIssueTracker", "getLastUpdated", "getLiberapay", "getLiberapayID", "getLicense", "getLitecoin", "getName", "getOpenCollective", "getPreferredSigner", "getPromoGraphic", "getScreenshots", "()Lorg/fdroid/index/v2/Screenshots;", "getSourceCode", "getSummary", "getTranslation", "getTvBanner", "getVideo", "getWebSite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "toString", "walkFiles", "", "fileConsumer", "Lkotlin/Function1;", "write$Self", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class MetadataV2 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final long added;
    private final String authorEmail;
    private final String authorName;
    private final String authorPhone;
    private final String authorWebSite;
    private final String bitcoin;
    private final List<String> categories;
    private final String changelog;
    private final Map<String, String> description;
    private final List<String> donate;
    private final Map<String, FileV2> featureGraphic;
    private final String flattrID;
    private final Map<String, FileV2> icon;
    private final String issueTracker;
    private final long lastUpdated;
    private final String liberapay;
    private final String liberapayID;
    private final String license;
    private final String litecoin;
    private final Map<String, String> name;
    private final String openCollective;
    private final String preferredSigner;
    private final Map<String, FileV2> promoGraphic;
    private final Screenshots screenshots;
    private final String sourceCode;
    private final Map<String, String> summary;
    private final String translation;
    private final Map<String, FileV2> tvBanner;
    private final Map<String, String> video;
    private final String webSite;

    public final Map<String, String> component1() {
        return this.name;
    }

    public final String component10() {
        return this.issueTracker;
    }

    public final String component11() {
        return this.translation;
    }

    public final String component12() {
        return this.preferredSigner;
    }

    public final List<String> component13() {
        return this.categories;
    }

    public final String component14() {
        return this.authorName;
    }

    public final String component15() {
        return this.authorEmail;
    }

    public final String component16() {
        return this.authorWebSite;
    }

    public final String component17() {
        return this.authorPhone;
    }

    public final List<String> component18() {
        return this.donate;
    }

    public final String component19() {
        return this.liberapayID;
    }

    public final Map<String, String> component2() {
        return this.summary;
    }

    public final String component20() {
        return this.liberapay;
    }

    public final String component21() {
        return this.openCollective;
    }

    public final String component22() {
        return this.bitcoin;
    }

    public final String component23() {
        return this.litecoin;
    }

    public final String component24() {
        return this.flattrID;
    }

    public final Map<String, FileV2> component25() {
        return this.icon;
    }

    public final Map<String, FileV2> component26() {
        return this.featureGraphic;
    }

    public final Map<String, FileV2> component27() {
        return this.promoGraphic;
    }

    public final Map<String, FileV2> component28() {
        return this.tvBanner;
    }

    public final Map<String, String> component29() {
        return this.video;
    }

    public final Map<String, String> component3() {
        return this.description;
    }

    public final Screenshots component30() {
        return this.screenshots;
    }

    public final long component4() {
        return this.added;
    }

    public final long component5() {
        return this.lastUpdated;
    }

    public final String component6() {
        return this.webSite;
    }

    public final String component7() {
        return this.changelog;
    }

    public final String component8() {
        return this.license;
    }

    public final String component9() {
        return this.sourceCode;
    }

    public final MetadataV2 copy(Map<String, String> map, Map<String, String> map2, Map<String, String> map3, long j, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> categories, String str8, String str9, String str10, String str11, List<String> donate, String str12, String str13, String str14, String str15, String str16, String str17, Map<String, FileV2> map4, Map<String, FileV2> map5, Map<String, FileV2> map6, Map<String, FileV2> map7, Map<String, String> map8, Screenshots screenshots) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(donate, "donate");
        return new MetadataV2(map, map2, map3, j, j2, str, str2, str3, str4, str5, str6, str7, categories, str8, str9, str10, str11, donate, str12, str13, str14, str15, str16, str17, map4, map5, map6, map7, map8, screenshots);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof MetadataV2) {
            MetadataV2 metadataV2 = (MetadataV2) obj;
            return Intrinsics.areEqual(this.name, metadataV2.name) && Intrinsics.areEqual(this.summary, metadataV2.summary) && Intrinsics.areEqual(this.description, metadataV2.description) && this.added == metadataV2.added && this.lastUpdated == metadataV2.lastUpdated && Intrinsics.areEqual(this.webSite, metadataV2.webSite) && Intrinsics.areEqual(this.changelog, metadataV2.changelog) && Intrinsics.areEqual(this.license, metadataV2.license) && Intrinsics.areEqual(this.sourceCode, metadataV2.sourceCode) && Intrinsics.areEqual(this.issueTracker, metadataV2.issueTracker) && Intrinsics.areEqual(this.translation, metadataV2.translation) && Intrinsics.areEqual(this.preferredSigner, metadataV2.preferredSigner) && Intrinsics.areEqual(this.categories, metadataV2.categories) && Intrinsics.areEqual(this.authorName, metadataV2.authorName) && Intrinsics.areEqual(this.authorEmail, metadataV2.authorEmail) && Intrinsics.areEqual(this.authorWebSite, metadataV2.authorWebSite) && Intrinsics.areEqual(this.authorPhone, metadataV2.authorPhone) && Intrinsics.areEqual(this.donate, metadataV2.donate) && Intrinsics.areEqual(this.liberapayID, metadataV2.liberapayID) && Intrinsics.areEqual(this.liberapay, metadataV2.liberapay) && Intrinsics.areEqual(this.openCollective, metadataV2.openCollective) && Intrinsics.areEqual(this.bitcoin, metadataV2.bitcoin) && Intrinsics.areEqual(this.litecoin, metadataV2.litecoin) && Intrinsics.areEqual(this.flattrID, metadataV2.flattrID) && Intrinsics.areEqual(this.icon, metadataV2.icon) && Intrinsics.areEqual(this.featureGraphic, metadataV2.featureGraphic) && Intrinsics.areEqual(this.promoGraphic, metadataV2.promoGraphic) && Intrinsics.areEqual(this.tvBanner, metadataV2.tvBanner) && Intrinsics.areEqual(this.video, metadataV2.video) && Intrinsics.areEqual(this.screenshots, metadataV2.screenshots);
        }
        return false;
    }

    public final long getAdded() {
        return this.added;
    }

    public final String getAuthorEmail() {
        return this.authorEmail;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final String getAuthorPhone() {
        return this.authorPhone;
    }

    public final String getAuthorWebSite() {
        return this.authorWebSite;
    }

    public final String getBitcoin() {
        return this.bitcoin;
    }

    public final List<String> getCategories() {
        return this.categories;
    }

    public final String getChangelog() {
        return this.changelog;
    }

    public final Map<String, String> getDescription() {
        return this.description;
    }

    public final List<String> getDonate() {
        return this.donate;
    }

    public final Map<String, FileV2> getFeatureGraphic() {
        return this.featureGraphic;
    }

    public final String getFlattrID() {
        return this.flattrID;
    }

    public final Map<String, FileV2> getIcon() {
        return this.icon;
    }

    public final String getIssueTracker() {
        return this.issueTracker;
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    public final String getLiberapay() {
        return this.liberapay;
    }

    public final String getLiberapayID() {
        return this.liberapayID;
    }

    public final String getLicense() {
        return this.license;
    }

    public final String getLitecoin() {
        return this.litecoin;
    }

    public final Map<String, String> getName() {
        return this.name;
    }

    public final String getOpenCollective() {
        return this.openCollective;
    }

    public final String getPreferredSigner() {
        return this.preferredSigner;
    }

    public final Map<String, FileV2> getPromoGraphic() {
        return this.promoGraphic;
    }

    public final Screenshots getScreenshots() {
        return this.screenshots;
    }

    public final String getSourceCode() {
        return this.sourceCode;
    }

    public final Map<String, String> getSummary() {
        return this.summary;
    }

    public final String getTranslation() {
        return this.translation;
    }

    public final Map<String, FileV2> getTvBanner() {
        return this.tvBanner;
    }

    public final Map<String, String> getVideo() {
        return this.video;
    }

    public final String getWebSite() {
        return this.webSite;
    }

    public int hashCode() {
        Map<String, String> map = this.name;
        int hashCode = (map == null ? 0 : map.hashCode()) * 31;
        Map<String, String> map2 = this.summary;
        int hashCode2 = (hashCode + (map2 == null ? 0 : map2.hashCode())) * 31;
        Map<String, String> map3 = this.description;
        int hashCode3 = (((((hashCode2 + (map3 == null ? 0 : map3.hashCode())) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.added)) * 31) + FlingCalculator$FlingInfo$$ExternalSyntheticBackport0.m(this.lastUpdated)) * 31;
        String str = this.webSite;
        int hashCode4 = (hashCode3 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.changelog;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.license;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.sourceCode;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.issueTracker;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.translation;
        int hashCode9 = (hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.preferredSigner;
        int hashCode10 = (((hashCode9 + (str7 == null ? 0 : str7.hashCode())) * 31) + this.categories.hashCode()) * 31;
        String str8 = this.authorName;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.authorEmail;
        int hashCode12 = (hashCode11 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.authorWebSite;
        int hashCode13 = (hashCode12 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.authorPhone;
        int hashCode14 = (((hashCode13 + (str11 == null ? 0 : str11.hashCode())) * 31) + this.donate.hashCode()) * 31;
        String str12 = this.liberapayID;
        int hashCode15 = (hashCode14 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.liberapay;
        int hashCode16 = (hashCode15 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.openCollective;
        int hashCode17 = (hashCode16 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.bitcoin;
        int hashCode18 = (hashCode17 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.litecoin;
        int hashCode19 = (hashCode18 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.flattrID;
        int hashCode20 = (hashCode19 + (str17 == null ? 0 : str17.hashCode())) * 31;
        Map<String, FileV2> map4 = this.icon;
        int hashCode21 = (hashCode20 + (map4 == null ? 0 : map4.hashCode())) * 31;
        Map<String, FileV2> map5 = this.featureGraphic;
        int hashCode22 = (hashCode21 + (map5 == null ? 0 : map5.hashCode())) * 31;
        Map<String, FileV2> map6 = this.promoGraphic;
        int hashCode23 = (hashCode22 + (map6 == null ? 0 : map6.hashCode())) * 31;
        Map<String, FileV2> map7 = this.tvBanner;
        int hashCode24 = (hashCode23 + (map7 == null ? 0 : map7.hashCode())) * 31;
        Map<String, String> map8 = this.video;
        int hashCode25 = (hashCode24 + (map8 == null ? 0 : map8.hashCode())) * 31;
        Screenshots screenshots = this.screenshots;
        return hashCode25 + (screenshots != null ? screenshots.hashCode() : 0);
    }

    public String toString() {
        Map<String, String> map = this.name;
        Map<String, String> map2 = this.summary;
        Map<String, String> map3 = this.description;
        long j = this.added;
        long j2 = this.lastUpdated;
        String str = this.webSite;
        String str2 = this.changelog;
        String str3 = this.license;
        String str4 = this.sourceCode;
        String str5 = this.issueTracker;
        String str6 = this.translation;
        String str7 = this.preferredSigner;
        List<String> list = this.categories;
        String str8 = this.authorName;
        String str9 = this.authorEmail;
        String str10 = this.authorWebSite;
        String str11 = this.authorPhone;
        List<String> list2 = this.donate;
        String str12 = this.liberapayID;
        String str13 = this.liberapay;
        String str14 = this.openCollective;
        String str15 = this.bitcoin;
        String str16 = this.litecoin;
        String str17 = this.flattrID;
        Map<String, FileV2> map4 = this.icon;
        Map<String, FileV2> map5 = this.featureGraphic;
        Map<String, FileV2> map6 = this.promoGraphic;
        Map<String, FileV2> map7 = this.tvBanner;
        Map<String, String> map8 = this.video;
        Screenshots screenshots = this.screenshots;
        return "MetadataV2(name=" + map + ", summary=" + map2 + ", description=" + map3 + ", added=" + j + ", lastUpdated=" + j2 + ", webSite=" + str + ", changelog=" + str2 + ", license=" + str3 + ", sourceCode=" + str4 + ", issueTracker=" + str5 + ", translation=" + str6 + ", preferredSigner=" + str7 + ", categories=" + list + ", authorName=" + str8 + ", authorEmail=" + str9 + ", authorWebSite=" + str10 + ", authorPhone=" + str11 + ", donate=" + list2 + ", liberapayID=" + str12 + ", liberapay=" + str13 + ", openCollective=" + str14 + ", bitcoin=" + str15 + ", litecoin=" + str16 + ", flattrID=" + str17 + ", icon=" + map4 + ", featureGraphic=" + map5 + ", promoGraphic=" + map6 + ", tvBanner=" + map7 + ", video=" + map8 + ", screenshots=" + screenshots + ")";
    }

    /* compiled from: PackageV2.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v2/MetadataV2$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v2/MetadataV2;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return MetadataV2$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        FileV2$$serializer fileV2$$serializer = FileV2$$serializer.INSTANCE;
        $childSerializers = new KSerializer[]{new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer), null, null, null, null, null, null, null, null, null, new ArrayListSerializer(stringSerializer), null, null, null, null, new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, fileV2$$serializer), new LinkedHashMapSerializer(stringSerializer, fileV2$$serializer), new LinkedHashMapSerializer(stringSerializer, fileV2$$serializer), new LinkedHashMapSerializer(stringSerializer, fileV2$$serializer), new LinkedHashMapSerializer(stringSerializer, stringSerializer), null};
    }

    public /* synthetic */ MetadataV2(int i, Map map, Map map2, Map map3, long j, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, String str8, String str9, String str10, String str11, List list2, String str12, String str13, String str14, String str15, String str16, String str17, Map map4, Map map5, Map map6, Map map7, Map map8, Screenshots screenshots, SerializationConstructorMarker serializationConstructorMarker) {
        if (24 != (i & 24)) {
            PluginExceptionsKt.throwMissingFieldException(i, 24, MetadataV2$$serializer.INSTANCE.getDescriptor());
        }
        if ((i & 1) == 0) {
            this.name = null;
        } else {
            this.name = map;
        }
        if ((i & 2) == 0) {
            this.summary = null;
        } else {
            this.summary = map2;
        }
        if ((i & 4) == 0) {
            this.description = null;
        } else {
            this.description = map3;
        }
        this.added = j;
        this.lastUpdated = j2;
        if ((i & 32) == 0) {
            this.webSite = null;
        } else {
            this.webSite = str;
        }
        if ((i & 64) == 0) {
            this.changelog = null;
        } else {
            this.changelog = str2;
        }
        if ((i & 128) == 0) {
            this.license = null;
        } else {
            this.license = str3;
        }
        if ((i & 256) == 0) {
            this.sourceCode = null;
        } else {
            this.sourceCode = str4;
        }
        if ((i & 512) == 0) {
            this.issueTracker = null;
        } else {
            this.issueTracker = str5;
        }
        if ((i & 1024) == 0) {
            this.translation = null;
        } else {
            this.translation = str6;
        }
        if ((i & 2048) == 0) {
            this.preferredSigner = null;
        } else {
            this.preferredSigner = str7;
        }
        this.categories = (i & PKIFailureInfo.certConfirmed) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        if ((i & 8192) == 0) {
            this.authorName = null;
        } else {
            this.authorName = str8;
        }
        if ((i & 16384) == 0) {
            this.authorEmail = null;
        } else {
            this.authorEmail = str9;
        }
        if ((32768 & i) == 0) {
            this.authorWebSite = null;
        } else {
            this.authorWebSite = str10;
        }
        if ((65536 & i) == 0) {
            this.authorPhone = null;
        } else {
            this.authorPhone = str11;
        }
        this.donate = (131072 & i) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        if ((262144 & i) == 0) {
            this.liberapayID = null;
        } else {
            this.liberapayID = str12;
        }
        if ((524288 & i) == 0) {
            this.liberapay = null;
        } else {
            this.liberapay = str13;
        }
        if ((1048576 & i) == 0) {
            this.openCollective = null;
        } else {
            this.openCollective = str14;
        }
        if ((2097152 & i) == 0) {
            this.bitcoin = null;
        } else {
            this.bitcoin = str15;
        }
        if ((4194304 & i) == 0) {
            this.litecoin = null;
        } else {
            this.litecoin = str16;
        }
        if ((8388608 & i) == 0) {
            this.flattrID = null;
        } else {
            this.flattrID = str17;
        }
        if ((16777216 & i) == 0) {
            this.icon = null;
        } else {
            this.icon = map4;
        }
        if ((33554432 & i) == 0) {
            this.featureGraphic = null;
        } else {
            this.featureGraphic = map5;
        }
        if ((67108864 & i) == 0) {
            this.promoGraphic = null;
        } else {
            this.promoGraphic = map6;
        }
        if ((134217728 & i) == 0) {
            this.tvBanner = null;
        } else {
            this.tvBanner = map7;
        }
        if ((268435456 & i) == 0) {
            this.video = null;
        } else {
            this.video = map8;
        }
        if ((i & PKIFailureInfo.duplicateCertReq) == 0) {
            this.screenshots = null;
        } else {
            this.screenshots = screenshots;
        }
    }

    public MetadataV2(Map<String, String> map, Map<String, String> map2, Map<String, String> map3, long j, long j2, String str, String str2, String str3, String str4, String str5, String str6, String str7, List<String> categories, String str8, String str9, String str10, String str11, List<String> donate, String str12, String str13, String str14, String str15, String str16, String str17, Map<String, FileV2> map4, Map<String, FileV2> map5, Map<String, FileV2> map6, Map<String, FileV2> map7, Map<String, String> map8, Screenshots screenshots) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(donate, "donate");
        this.name = map;
        this.summary = map2;
        this.description = map3;
        this.added = j;
        this.lastUpdated = j2;
        this.webSite = str;
        this.changelog = str2;
        this.license = str3;
        this.sourceCode = str4;
        this.issueTracker = str5;
        this.translation = str6;
        this.preferredSigner = str7;
        this.categories = categories;
        this.authorName = str8;
        this.authorEmail = str9;
        this.authorWebSite = str10;
        this.authorPhone = str11;
        this.donate = donate;
        this.liberapayID = str12;
        this.liberapay = str13;
        this.openCollective = str14;
        this.bitcoin = str15;
        this.litecoin = str16;
        this.flattrID = str17;
        this.icon = map4;
        this.featureGraphic = map5;
        this.promoGraphic = map6;
        this.tvBanner = map7;
        this.video = map8;
        this.screenshots = screenshots;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x00e3, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x014f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L128;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v2.MetadataV2 r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            Method dump skipped, instructions count: 597
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.MetadataV2.write$Self$index_release(org.fdroid.index.v2.MetadataV2, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ MetadataV2(java.util.Map r37, java.util.Map r38, java.util.Map r39, long r40, long r42, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.util.List r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.util.List r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.String r60, java.lang.String r61, java.lang.String r62, java.util.Map r63, java.util.Map r64, java.util.Map r65, java.util.Map r66, java.util.Map r67, org.fdroid.index.v2.Screenshots r68, int r69, kotlin.jvm.internal.DefaultConstructorMarker r70) {
        /*
            Method dump skipped, instructions count: 281
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v2.MetadataV2.<init>(java.util.Map, java.util.Map, java.util.Map, long, long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.Map, java.util.Map, java.util.Map, java.util.Map, java.util.Map, org.fdroid.index.v2.Screenshots, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final void walkFiles(Function1 fileConsumer) {
        Map<String, List<FileV2>> tv;
        Collection<List<FileV2>> values;
        Map<String, List<FileV2>> wear;
        Collection<List<FileV2>> values2;
        Map<String, List<FileV2>> tenInch;
        Collection<List<FileV2>> values3;
        Map<String, List<FileV2>> sevenInch;
        Collection<List<FileV2>> values4;
        Map<String, List<FileV2>> phone;
        Collection<List<FileV2>> values5;
        Collection<FileV2> values6;
        Collection<FileV2> values7;
        Collection<FileV2> values8;
        Collection<FileV2> values9;
        Intrinsics.checkNotNullParameter(fileConsumer, "fileConsumer");
        Map<String, FileV2> map = this.icon;
        if (map != null && (values9 = map.values()) != null) {
            for (FileV2 fileV2 : values9) {
                fileConsumer.invoke(fileV2);
            }
        }
        Map<String, FileV2> map2 = this.featureGraphic;
        if (map2 != null && (values8 = map2.values()) != null) {
            for (FileV2 fileV22 : values8) {
                fileConsumer.invoke(fileV22);
            }
        }
        Map<String, FileV2> map3 = this.promoGraphic;
        if (map3 != null && (values7 = map3.values()) != null) {
            for (FileV2 fileV23 : values7) {
                fileConsumer.invoke(fileV23);
            }
        }
        Map<String, FileV2> map4 = this.tvBanner;
        if (map4 != null && (values6 = map4.values()) != null) {
            for (FileV2 fileV24 : values6) {
                fileConsumer.invoke(fileV24);
            }
        }
        Screenshots screenshots = this.screenshots;
        if (screenshots != null && (phone = screenshots.getPhone()) != null && (values5 = phone.values()) != null) {
            Iterator<T> it = values5.iterator();
            while (it.hasNext()) {
                for (Object obj : (List) it.next()) {
                    fileConsumer.invoke(obj);
                }
            }
        }
        Screenshots screenshots2 = this.screenshots;
        if (screenshots2 != null && (sevenInch = screenshots2.getSevenInch()) != null && (values4 = sevenInch.values()) != null) {
            Iterator<T> it2 = values4.iterator();
            while (it2.hasNext()) {
                for (Object obj2 : (List) it2.next()) {
                    fileConsumer.invoke(obj2);
                }
            }
        }
        Screenshots screenshots3 = this.screenshots;
        if (screenshots3 != null && (tenInch = screenshots3.getTenInch()) != null && (values3 = tenInch.values()) != null) {
            Iterator<T> it3 = values3.iterator();
            while (it3.hasNext()) {
                for (Object obj3 : (List) it3.next()) {
                    fileConsumer.invoke(obj3);
                }
            }
        }
        Screenshots screenshots4 = this.screenshots;
        if (screenshots4 != null && (wear = screenshots4.getWear()) != null && (values2 = wear.values()) != null) {
            Iterator<T> it4 = values2.iterator();
            while (it4.hasNext()) {
                for (Object obj4 : (List) it4.next()) {
                    fileConsumer.invoke(obj4);
                }
            }
        }
        Screenshots screenshots5 = this.screenshots;
        if (screenshots5 == null || (tv = screenshots5.getTv()) == null || (values = tv.values()) == null) {
            return;
        }
        Iterator<T> it5 = values.iterator();
        while (it5.hasNext()) {
            for (Object obj5 : (List) it5.next()) {
                fileConsumer.invoke(obj5);
            }
        }
    }
}
