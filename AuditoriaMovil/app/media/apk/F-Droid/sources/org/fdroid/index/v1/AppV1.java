package org.fdroid.index.v1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.collections.MapsKt__MapsJVMKt;
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
import org.fdroid.index.IndexConverterKt;
import org.fdroid.index.v2.FileV2;
import org.fdroid.index.v2.MetadataV2;
import org.fdroid.index.v2.Screenshots;
/* compiled from: AppV1.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\bH\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 \u008f\u00012\u00020\u0001:\u0004\u008e\u0001\u008f\u0001Bí\u0002\b\u0011\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\b\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010#\u001a\u0004\u0018\u00010 \u0012\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\u000e\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010(\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*B\u008b\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u001d\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\"\u001a\u00020\u0006\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 \u0012\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%\u0012\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010+J\u000f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010Q\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010S\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010T\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010U\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010V\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010W\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010X\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Y\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010Z\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000f\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\u000b\u0010\\\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010]\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010^\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010_\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010`\u001a\u00020\u0006HÆ\u0003J\u000b\u0010a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0010\u0010b\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010c\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010d\u001a\u00020\u0006HÆ\u0003J\u0010\u0010e\u001a\u0004\u0018\u00010 HÆ\u0003¢\u0006\u0002\u0010-J\u000b\u0010f\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0017\u0010g\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%HÆ\u0003J\u0011\u0010h\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010i\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010j\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010k\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010l\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010m\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010n\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u0098\u0003\u0010o\u001a\u00020\u00002\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\"\u001a\u00020\u00062\n\b\u0002\u0010#\u001a\u0004\u0018\u00010 2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0010\b\u0002\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010pJ\u0013\u0010q\u001a\u00020r2\b\u0010s\u001a\u0004\u0018\u00010\u0001HÖ\u0003JD\u0010t\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010%j\u0004\u0018\u0001`u2\b\u0010v\u001a\u0004\u0018\u00010\u00062\u0006\u0010w\u001a\u00020\u00062\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00060yH\u0002J\t\u0010z\u001a\u00020\u0003HÖ\u0001J\u001a\u0010{\u001a\u00020|2\b\u0010}\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010w\u001a\u00020\u0006J\t\u0010~\u001a\u00020\u0006HÖ\u0001J-\u0010\u007f\u001a\u00030\u0080\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u00002\b\u0010\u0082\u0001\u001a\u00030\u0083\u00012\b\u0010\u0084\u0001\u001a\u00030\u0085\u0001HÁ\u0001¢\u0006\u0003\b\u0086\u0001J\\\u0010\u0087\u0001\u001a\u001e\u0012\u0004\u0012\u00020\u0006\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u0088\u00010\u0005\u0018\u00010%j\u0005\u0018\u0001`\u0089\u0001*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0007\u0010\u008a\u0001\u001a\u00020\u00062\u001a\u0010x\u001a\u0016\u0012\u0004\u0012\u00020&\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00050yH\u0002JG\u0010\u008b\u0001\u001a\u0018\u0012\u0004\u0012\u00020\u0006\u0012\u0005\u0012\u00030\u0088\u0001\u0018\u00010%j\u0005\u0018\u0001`\u008c\u0001*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00060yH\u0002JE\u0010\u008d\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010%j\u0004\u0018\u0001`u*\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%2\u0014\u0010x\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0006\u0012\u0004\u0018\u00010\u00060yH\u0002R\u0015\u0010\u001f\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0019\u0010'\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b1\u00100R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b2\u00103R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b4\u00103R\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b5\u00103R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b6\u00103R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b7\u00103R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b8\u00103R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b9\u00100R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b:\u00103R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b;\u00103R\u0013\u0010\u0014\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b<\u00103R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b=\u00103R\u0013\u0010!\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b>\u00103R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b?\u00103R\u0015\u0010#\u001a\u0004\u0018\u00010 ¢\u0006\n\n\u0002\u0010.\u001a\u0004\b@\u0010-R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bA\u00103R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bB\u00103R\u0011\u0010\u001d\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bC\u00103R\u0013\u0010\u0019\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bD\u00103R\u001f\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020&\u0018\u00010%¢\u0006\b\n\u0000\u001a\u0004\bE\u0010FR\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bG\u00103R\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bH\u00103R\u0011\u0010\"\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\bI\u00103R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bJ\u00103R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bK\u00103R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bL\u00103R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bM\u00103R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bN\u00103R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\bO\u00103¨\u0006\u0090\u0001"}, d2 = {"Lorg/fdroid/index/v1/AppV1;", "", "seen1", "", "categories", "", "", "antiFeatures", ErrorBundle.SUMMARY_ENTRY, "description", "changelog", "translation", "issueTracker", "sourceCode", "binaries", "name", "authorName", "authorEmail", "authorWebSite", "authorPhone", "donate", "liberapayID", "liberapay", "openCollective", "bitcoin", "litecoin", "flattrID", "suggestedVersionName", "suggestedVersionCode", "license", "webSite", "added", "", "icon", "packageName", AppListActivity.SortClause.LAST_UPDATED, "localized", "", "Lorg/fdroid/index/v1/Localized;", "allowedAPKSigningKeys", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;)V", "getAdded", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getAllowedAPKSigningKeys", "()Ljava/util/List;", "getAntiFeatures", "getAuthorEmail", "()Ljava/lang/String;", "getAuthorName", "getAuthorPhone", "getAuthorWebSite", "getBinaries", "getBitcoin", "getCategories", "getChangelog", "getDescription", "getDonate", "getFlattrID", "getIcon", "getIssueTracker", "getLastUpdated", "getLiberapay", "getLiberapayID", "getLicense", "getLitecoin", "getLocalized", "()Ljava/util/Map;", "getName", "getOpenCollective", "getPackageName", "getSourceCode", "getSuggestedVersionCode", "getSuggestedVersionName", "getSummary", "getTranslation", "getWebSite", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component26", "component27", "component28", "component29", "component3", "component30", "component31", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/util/Map;Ljava/util/List;)Lorg/fdroid/index/v1/AppV1;", "equals", "", "other", "getLocalizedTextV2", "Lorg/fdroid/index/v2/LocalizedTextV2;", "s", "locale", "selector", "Lkotlin/Function1;", "hashCode", "toMetadataV2", "Lorg/fdroid/index/v2/MetadataV2;", "preferredSigner", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$index_release", "toLocalizedFileListV2", "Lorg/fdroid/index/v2/FileV2;", "Lorg/fdroid/index/v2/LocalizedFileListV2;", "kind", "toLocalizedFileV2", "Lorg/fdroid/index/v2/LocalizedFileV2;", "toLocalizedTextV2", "$serializer", "Companion", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
@Serializable
/* loaded from: classes2.dex */
public final class AppV1 {
    private static final KSerializer[] $childSerializers;
    public static final Companion Companion = new Companion(null);
    private final Long added;
    private final List<String> allowedAPKSigningKeys;
    private final List<String> antiFeatures;
    private final String authorEmail;
    private final String authorName;
    private final String authorPhone;
    private final String authorWebSite;
    private final String binaries;
    private final String bitcoin;
    private final List<String> categories;
    private final String changelog;
    private final String description;
    private final String donate;
    private final String flattrID;
    private final String icon;
    private final String issueTracker;
    private final Long lastUpdated;
    private final String liberapay;
    private final String liberapayID;
    private final String license;
    private final String litecoin;
    private final Map<String, Localized> localized;
    private final String name;
    private final String openCollective;
    private final String packageName;
    private final String sourceCode;
    private final String suggestedVersionCode;
    private final String suggestedVersionName;
    private final String summary;
    private final String translation;
    private final String webSite;

    public final List<String> component1() {
        return this.categories;
    }

    public final String component10() {
        return this.name;
    }

    public final String component11() {
        return this.authorName;
    }

    public final String component12() {
        return this.authorEmail;
    }

    public final String component13() {
        return this.authorWebSite;
    }

    public final String component14() {
        return this.authorPhone;
    }

    public final String component15() {
        return this.donate;
    }

    public final String component16() {
        return this.liberapayID;
    }

    public final String component17() {
        return this.liberapay;
    }

    public final String component18() {
        return this.openCollective;
    }

    public final String component19() {
        return this.bitcoin;
    }

    public final List<String> component2() {
        return this.antiFeatures;
    }

    public final String component20() {
        return this.litecoin;
    }

    public final String component21() {
        return this.flattrID;
    }

    public final String component22() {
        return this.suggestedVersionName;
    }

    public final String component23() {
        return this.suggestedVersionCode;
    }

    public final String component24() {
        return this.license;
    }

    public final String component25() {
        return this.webSite;
    }

    public final Long component26() {
        return this.added;
    }

    public final String component27() {
        return this.icon;
    }

    public final String component28() {
        return this.packageName;
    }

    public final Long component29() {
        return this.lastUpdated;
    }

    public final String component3() {
        return this.summary;
    }

    public final Map<String, Localized> component30() {
        return this.localized;
    }

    public final List<String> component31() {
        return this.allowedAPKSigningKeys;
    }

    public final String component4() {
        return this.description;
    }

    public final String component5() {
        return this.changelog;
    }

    public final String component6() {
        return this.translation;
    }

    public final String component7() {
        return this.issueTracker;
    }

    public final String component8() {
        return this.sourceCode;
    }

    public final String component9() {
        return this.binaries;
    }

    public final AppV1 copy(List<String> categories, List<String> antiFeatures, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String license, String str22, Long l, String str23, String packageName, Long l2, Map<String, Localized> map, List<String> list) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        return new AppV1(categories, antiFeatures, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11, str12, str13, str14, str15, str16, str17, str18, str19, str20, str21, license, str22, l, str23, packageName, l2, map, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof AppV1) {
            AppV1 appV1 = (AppV1) obj;
            return Intrinsics.areEqual(this.categories, appV1.categories) && Intrinsics.areEqual(this.antiFeatures, appV1.antiFeatures) && Intrinsics.areEqual(this.summary, appV1.summary) && Intrinsics.areEqual(this.description, appV1.description) && Intrinsics.areEqual(this.changelog, appV1.changelog) && Intrinsics.areEqual(this.translation, appV1.translation) && Intrinsics.areEqual(this.issueTracker, appV1.issueTracker) && Intrinsics.areEqual(this.sourceCode, appV1.sourceCode) && Intrinsics.areEqual(this.binaries, appV1.binaries) && Intrinsics.areEqual(this.name, appV1.name) && Intrinsics.areEqual(this.authorName, appV1.authorName) && Intrinsics.areEqual(this.authorEmail, appV1.authorEmail) && Intrinsics.areEqual(this.authorWebSite, appV1.authorWebSite) && Intrinsics.areEqual(this.authorPhone, appV1.authorPhone) && Intrinsics.areEqual(this.donate, appV1.donate) && Intrinsics.areEqual(this.liberapayID, appV1.liberapayID) && Intrinsics.areEqual(this.liberapay, appV1.liberapay) && Intrinsics.areEqual(this.openCollective, appV1.openCollective) && Intrinsics.areEqual(this.bitcoin, appV1.bitcoin) && Intrinsics.areEqual(this.litecoin, appV1.litecoin) && Intrinsics.areEqual(this.flattrID, appV1.flattrID) && Intrinsics.areEqual(this.suggestedVersionName, appV1.suggestedVersionName) && Intrinsics.areEqual(this.suggestedVersionCode, appV1.suggestedVersionCode) && Intrinsics.areEqual(this.license, appV1.license) && Intrinsics.areEqual(this.webSite, appV1.webSite) && Intrinsics.areEqual(this.added, appV1.added) && Intrinsics.areEqual(this.icon, appV1.icon) && Intrinsics.areEqual(this.packageName, appV1.packageName) && Intrinsics.areEqual(this.lastUpdated, appV1.lastUpdated) && Intrinsics.areEqual(this.localized, appV1.localized) && Intrinsics.areEqual(this.allowedAPKSigningKeys, appV1.allowedAPKSigningKeys);
        }
        return false;
    }

    public final Long getAdded() {
        return this.added;
    }

    public final List<String> getAllowedAPKSigningKeys() {
        return this.allowedAPKSigningKeys;
    }

    public final List<String> getAntiFeatures() {
        return this.antiFeatures;
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

    public final String getBinaries() {
        return this.binaries;
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

    public final String getDescription() {
        return this.description;
    }

    public final String getDonate() {
        return this.donate;
    }

    public final String getFlattrID() {
        return this.flattrID;
    }

    public final String getIcon() {
        return this.icon;
    }

    public final String getIssueTracker() {
        return this.issueTracker;
    }

    public final Long getLastUpdated() {
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

    public final Map<String, Localized> getLocalized() {
        return this.localized;
    }

    public final String getName() {
        return this.name;
    }

    public final String getOpenCollective() {
        return this.openCollective;
    }

    public final String getPackageName() {
        return this.packageName;
    }

    public final String getSourceCode() {
        return this.sourceCode;
    }

    public final String getSuggestedVersionCode() {
        return this.suggestedVersionCode;
    }

    public final String getSuggestedVersionName() {
        return this.suggestedVersionName;
    }

    public final String getSummary() {
        return this.summary;
    }

    public final String getTranslation() {
        return this.translation;
    }

    public final String getWebSite() {
        return this.webSite;
    }

    public int hashCode() {
        int hashCode = ((this.categories.hashCode() * 31) + this.antiFeatures.hashCode()) * 31;
        String str = this.summary;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.description;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.changelog;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.translation;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.issueTracker;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.sourceCode;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.binaries;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.name;
        int hashCode9 = (hashCode8 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.authorName;
        int hashCode10 = (hashCode9 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.authorEmail;
        int hashCode11 = (hashCode10 + (str10 == null ? 0 : str10.hashCode())) * 31;
        String str11 = this.authorWebSite;
        int hashCode12 = (hashCode11 + (str11 == null ? 0 : str11.hashCode())) * 31;
        String str12 = this.authorPhone;
        int hashCode13 = (hashCode12 + (str12 == null ? 0 : str12.hashCode())) * 31;
        String str13 = this.donate;
        int hashCode14 = (hashCode13 + (str13 == null ? 0 : str13.hashCode())) * 31;
        String str14 = this.liberapayID;
        int hashCode15 = (hashCode14 + (str14 == null ? 0 : str14.hashCode())) * 31;
        String str15 = this.liberapay;
        int hashCode16 = (hashCode15 + (str15 == null ? 0 : str15.hashCode())) * 31;
        String str16 = this.openCollective;
        int hashCode17 = (hashCode16 + (str16 == null ? 0 : str16.hashCode())) * 31;
        String str17 = this.bitcoin;
        int hashCode18 = (hashCode17 + (str17 == null ? 0 : str17.hashCode())) * 31;
        String str18 = this.litecoin;
        int hashCode19 = (hashCode18 + (str18 == null ? 0 : str18.hashCode())) * 31;
        String str19 = this.flattrID;
        int hashCode20 = (hashCode19 + (str19 == null ? 0 : str19.hashCode())) * 31;
        String str20 = this.suggestedVersionName;
        int hashCode21 = (hashCode20 + (str20 == null ? 0 : str20.hashCode())) * 31;
        String str21 = this.suggestedVersionCode;
        int hashCode22 = (((hashCode21 + (str21 == null ? 0 : str21.hashCode())) * 31) + this.license.hashCode()) * 31;
        String str22 = this.webSite;
        int hashCode23 = (hashCode22 + (str22 == null ? 0 : str22.hashCode())) * 31;
        Long l = this.added;
        int hashCode24 = (hashCode23 + (l == null ? 0 : l.hashCode())) * 31;
        String str23 = this.icon;
        int hashCode25 = (((hashCode24 + (str23 == null ? 0 : str23.hashCode())) * 31) + this.packageName.hashCode()) * 31;
        Long l2 = this.lastUpdated;
        int hashCode26 = (hashCode25 + (l2 == null ? 0 : l2.hashCode())) * 31;
        Map<String, Localized> map = this.localized;
        int hashCode27 = (hashCode26 + (map == null ? 0 : map.hashCode())) * 31;
        List<String> list = this.allowedAPKSigningKeys;
        return hashCode27 + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        List<String> list = this.categories;
        List<String> list2 = this.antiFeatures;
        String str = this.summary;
        String str2 = this.description;
        String str3 = this.changelog;
        String str4 = this.translation;
        String str5 = this.issueTracker;
        String str6 = this.sourceCode;
        String str7 = this.binaries;
        String str8 = this.name;
        String str9 = this.authorName;
        String str10 = this.authorEmail;
        String str11 = this.authorWebSite;
        String str12 = this.authorPhone;
        String str13 = this.donate;
        String str14 = this.liberapayID;
        String str15 = this.liberapay;
        String str16 = this.openCollective;
        String str17 = this.bitcoin;
        String str18 = this.litecoin;
        String str19 = this.flattrID;
        String str20 = this.suggestedVersionName;
        String str21 = this.suggestedVersionCode;
        String str22 = this.license;
        String str23 = this.webSite;
        Long l = this.added;
        String str24 = this.icon;
        String str25 = this.packageName;
        Long l2 = this.lastUpdated;
        Map<String, Localized> map = this.localized;
        List<String> list3 = this.allowedAPKSigningKeys;
        return "AppV1(categories=" + list + ", antiFeatures=" + list2 + ", summary=" + str + ", description=" + str2 + ", changelog=" + str3 + ", translation=" + str4 + ", issueTracker=" + str5 + ", sourceCode=" + str6 + ", binaries=" + str7 + ", name=" + str8 + ", authorName=" + str9 + ", authorEmail=" + str10 + ", authorWebSite=" + str11 + ", authorPhone=" + str12 + ", donate=" + str13 + ", liberapayID=" + str14 + ", liberapay=" + str15 + ", openCollective=" + str16 + ", bitcoin=" + str17 + ", litecoin=" + str18 + ", flattrID=" + str19 + ", suggestedVersionName=" + str20 + ", suggestedVersionCode=" + str21 + ", license=" + str22 + ", webSite=" + str23 + ", added=" + l + ", icon=" + str24 + ", packageName=" + str25 + ", lastUpdated=" + l2 + ", localized=" + map + ", allowedAPKSigningKeys=" + list3 + ")";
    }

    /* compiled from: AppV1.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lorg/fdroid/index/v1/AppV1$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lorg/fdroid/index/v1/AppV1;", "index_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KSerializer serializer() {
            return AppV1$$serializer.INSTANCE;
        }
    }

    static {
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        $childSerializers = new KSerializer[]{new ArrayListSerializer(stringSerializer), new ArrayListSerializer(stringSerializer), null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, new LinkedHashMapSerializer(stringSerializer, Localized$$serializer.INSTANCE), new ArrayListSerializer(stringSerializer)};
    }

    public /* synthetic */ AppV1(int i, List list, List list2, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String str22, String str23, Long l, String str24, String str25, Long l2, Map map, List list3, SerializationConstructorMarker serializationConstructorMarker) {
        if (142606336 != (i & 142606336)) {
            PluginExceptionsKt.throwMissingFieldException(i, 142606336, AppV1$$serializer.INSTANCE.getDescriptor());
        }
        this.categories = (i & 1) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list;
        this.antiFeatures = (i & 2) == 0 ? CollectionsKt__CollectionsKt.emptyList() : list2;
        if ((i & 4) == 0) {
            this.summary = null;
        } else {
            this.summary = str;
        }
        if ((i & 8) == 0) {
            this.description = null;
        } else {
            this.description = str2;
        }
        if ((i & 16) == 0) {
            this.changelog = null;
        } else {
            this.changelog = str3;
        }
        if ((i & 32) == 0) {
            this.translation = null;
        } else {
            this.translation = str4;
        }
        if ((i & 64) == 0) {
            this.issueTracker = null;
        } else {
            this.issueTracker = str5;
        }
        if ((i & 128) == 0) {
            this.sourceCode = null;
        } else {
            this.sourceCode = str6;
        }
        if ((i & 256) == 0) {
            this.binaries = null;
        } else {
            this.binaries = str7;
        }
        if ((i & 512) == 0) {
            this.name = null;
        } else {
            this.name = str8;
        }
        if ((i & 1024) == 0) {
            this.authorName = null;
        } else {
            this.authorName = str9;
        }
        if ((i & 2048) == 0) {
            this.authorEmail = null;
        } else {
            this.authorEmail = str10;
        }
        if ((i & PKIFailureInfo.certConfirmed) == 0) {
            this.authorWebSite = null;
        } else {
            this.authorWebSite = str11;
        }
        if ((i & 8192) == 0) {
            this.authorPhone = null;
        } else {
            this.authorPhone = str12;
        }
        if ((i & 16384) == 0) {
            this.donate = null;
        } else {
            this.donate = str13;
        }
        if ((32768 & i) == 0) {
            this.liberapayID = null;
        } else {
            this.liberapayID = str14;
        }
        if ((65536 & i) == 0) {
            this.liberapay = null;
        } else {
            this.liberapay = str15;
        }
        if ((131072 & i) == 0) {
            this.openCollective = null;
        } else {
            this.openCollective = str16;
        }
        if ((262144 & i) == 0) {
            this.bitcoin = null;
        } else {
            this.bitcoin = str17;
        }
        if ((524288 & i) == 0) {
            this.litecoin = null;
        } else {
            this.litecoin = str18;
        }
        if ((1048576 & i) == 0) {
            this.flattrID = null;
        } else {
            this.flattrID = str19;
        }
        if ((2097152 & i) == 0) {
            this.suggestedVersionName = null;
        } else {
            this.suggestedVersionName = str20;
        }
        if ((4194304 & i) == 0) {
            this.suggestedVersionCode = null;
        } else {
            this.suggestedVersionCode = str21;
        }
        this.license = str22;
        if ((16777216 & i) == 0) {
            this.webSite = null;
        } else {
            this.webSite = str23;
        }
        if ((33554432 & i) == 0) {
            this.added = null;
        } else {
            this.added = l;
        }
        if ((67108864 & i) == 0) {
            this.icon = null;
        } else {
            this.icon = str24;
        }
        this.packageName = str25;
        if ((268435456 & i) == 0) {
            this.lastUpdated = null;
        } else {
            this.lastUpdated = l2;
        }
        if ((536870912 & i) == 0) {
            this.localized = null;
        } else {
            this.localized = map;
        }
        if ((i & 1073741824) == 0) {
            this.allowedAPKSigningKeys = null;
        } else {
            this.allowedAPKSigningKeys = list3;
        }
    }

    public AppV1(List<String> categories, List<String> antiFeatures, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, String str18, String str19, String str20, String str21, String license, String str22, Long l, String str23, String packageName, Long l2, Map<String, Localized> map, List<String> list) {
        Intrinsics.checkNotNullParameter(categories, "categories");
        Intrinsics.checkNotNullParameter(antiFeatures, "antiFeatures");
        Intrinsics.checkNotNullParameter(license, "license");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.categories = categories;
        this.antiFeatures = antiFeatures;
        this.summary = str;
        this.description = str2;
        this.changelog = str3;
        this.translation = str4;
        this.issueTracker = str5;
        this.sourceCode = str6;
        this.binaries = str7;
        this.name = str8;
        this.authorName = str9;
        this.authorEmail = str10;
        this.authorWebSite = str11;
        this.authorPhone = str12;
        this.donate = str13;
        this.liberapayID = str14;
        this.liberapay = str15;
        this.openCollective = str16;
        this.bitcoin = str17;
        this.litecoin = str18;
        this.flattrID = str19;
        this.suggestedVersionName = str20;
        this.suggestedVersionCode = str21;
        this.license = license;
        this.webSite = str22;
        this.added = l;
        this.icon = str23;
        this.packageName = packageName;
        this.lastUpdated = l2;
        this.localized = map;
        this.allowedAPKSigningKeys = list;
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x002f, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r3) == false) goto L148;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void write$Self$index_release(org.fdroid.index.v1.AppV1 r4, kotlinx.serialization.encoding.CompositeEncoder r5, kotlinx.serialization.descriptors.SerialDescriptor r6) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.AppV1.write$Self$index_release(org.fdroid.index.v1.AppV1, kotlinx.serialization.encoding.CompositeEncoder, kotlinx.serialization.descriptors.SerialDescriptor):void");
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ AppV1(java.util.List r35, java.util.List r36, java.lang.String r37, java.lang.String r38, java.lang.String r39, java.lang.String r40, java.lang.String r41, java.lang.String r42, java.lang.String r43, java.lang.String r44, java.lang.String r45, java.lang.String r46, java.lang.String r47, java.lang.String r48, java.lang.String r49, java.lang.String r50, java.lang.String r51, java.lang.String r52, java.lang.String r53, java.lang.String r54, java.lang.String r55, java.lang.String r56, java.lang.String r57, java.lang.String r58, java.lang.String r59, java.lang.Long r60, java.lang.String r61, java.lang.String r62, java.lang.Long r63, java.util.Map r64, java.util.List r65, int r66, kotlin.jvm.internal.DefaultConstructorMarker r67) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.fdroid.index.v1.AppV1.<init>(java.util.List, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Long, java.lang.String, java.lang.String, java.lang.Long, java.util.Map, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public static /* synthetic */ MetadataV2 toMetadataV2$default(AppV1 appV1, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = IndexConverterKt.DEFAULT_LOCALE;
        }
        return appV1.toMetadataV2(str, str2);
    }

    public final MetadataV2 toMetadataV2(String str, String locale) {
        String str2;
        String str3;
        Map<String, FileV2> map;
        Map<String, FileV2> mapOf;
        Intrinsics.checkNotNullParameter(locale, "locale");
        Map<String, String> localizedTextV2 = getLocalizedTextV2(this.name, locale, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getName();
            }
        });
        Map<String, String> localizedTextV22 = getLocalizedTextV2(this.summary, locale, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$2
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSummary();
            }
        });
        Map<String, String> localizedTextV23 = getLocalizedTextV2(this.description, locale, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$3
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getDescription();
            }
        });
        Long l = this.added;
        long longValue = l != null ? l.longValue() : 0L;
        Long l2 = this.lastUpdated;
        long longValue2 = l2 != null ? l2.longValue() : 0L;
        String str4 = this.webSite;
        String str5 = this.changelog;
        String str6 = this.license;
        String str7 = this.sourceCode;
        String str8 = this.issueTracker;
        String str9 = this.translation;
        List<String> list = this.categories;
        String str10 = this.authorName;
        String str11 = this.authorEmail;
        String str12 = this.authorWebSite;
        String str13 = this.authorPhone;
        String str14 = this.donate;
        List emptyList = str14 == null ? CollectionsKt__CollectionsKt.emptyList() : CollectionsKt__CollectionsJVMKt.listOf(str14);
        String str15 = this.liberapayID;
        String str16 = this.liberapay;
        String str17 = this.openCollective;
        String str18 = this.bitcoin;
        String str19 = this.litecoin;
        String str20 = this.flattrID;
        Map<String, FileV2> localizedFileV2 = toLocalizedFileV2(this.localized, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$4
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getIcon();
            }
        });
        if (localizedFileV2 == null) {
            String str21 = this.icon;
            if (str21 != null) {
                str2 = str8;
                StringBuilder sb = new StringBuilder();
                str3 = str7;
                sb.append("/icons/");
                sb.append(str21);
                mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(locale, new FileV2(sb.toString(), (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null)));
                map = mapOf;
            } else {
                str2 = str8;
                str3 = str7;
                map = null;
            }
        } else {
            str2 = str8;
            str3 = str7;
            map = localizedFileV2;
        }
        Map<String, FileV2> localizedFileV22 = toLocalizedFileV2(this.localized, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$6
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getFeatureGraphic();
            }
        });
        Map<String, FileV2> localizedFileV23 = toLocalizedFileV2(this.localized, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$7
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getPromoGraphic();
            }
        });
        Map<String, FileV2> localizedFileV24 = toLocalizedFileV2(this.localized, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$8
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getTvBanner();
            }
        });
        Map<String, String> localizedTextV24 = toLocalizedTextV2(this.localized, new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$9
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getVideo();
            }
        });
        Screenshots screenshots = new Screenshots(toLocalizedFileListV2(this.localized, "phoneScreenshots", new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$10
            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getPhoneScreenshots();
            }
        }), toLocalizedFileListV2(this.localized, "sevenInchScreenshots", new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$11
            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getSevenInchScreenshots();
            }
        }), toLocalizedFileListV2(this.localized, "tenInchScreenshots", new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$12
            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getTenInchScreenshots();
            }
        }), toLocalizedFileListV2(this.localized, "wearScreenshots", new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$13
            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getWearScreenshots();
            }
        }), toLocalizedFileListV2(this.localized, "tvScreenshots", new Function1() { // from class: org.fdroid.index.v1.AppV1$toMetadataV2$14
            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Localized it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getTvScreenshots();
            }
        }));
        return new MetadataV2(localizedTextV2, localizedTextV22, localizedTextV23, longValue, longValue2, str4, str5, str6, str3, str2, str9, str, list, str10, str11, str12, str13, emptyList, str15, str16, str17, str18, str19, str20, map, localizedFileV22, localizedFileV23, localizedFileV24, localizedTextV24, screenshots.isNull() ^ true ? screenshots : null);
    }

    private final Map<String, String> getLocalizedTextV2(String str, String str2, Function1 function1) {
        Map<String, String> mapOf;
        if (str != null) {
            mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to(str2, str));
            return mapOf;
        }
        Map<String, Localized> map = this.localized;
        if (map != null) {
            return toLocalizedTextV2(map, function1);
        }
        return null;
    }

    private final Map<String, String> toLocalizedTextV2(Map<String, Localized> map, final Function1 function1) {
        if (map == null) {
            return null;
        }
        return IndexConverterKt.mapValuesNotNull(map, new Function1() { // from class: org.fdroid.index.v1.AppV1$toLocalizedTextV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Map.Entry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return (String) Function1.this.invoke(it.getValue());
            }
        });
    }

    private final Map<String, FileV2> toLocalizedFileV2(Map<String, Localized> map, final Function1 function1) {
        if (map == null) {
            return null;
        }
        return IndexConverterKt.mapValuesNotNull(map, new Function1() { // from class: org.fdroid.index.v1.AppV1$toLocalizedFileV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final FileV2 invoke(Map.Entry it) {
                Intrinsics.checkNotNullParameter(it, "it");
                String str = (String) Function1.this.invoke(it.getValue());
                if (str != null) {
                    String packageName = this.getPackageName();
                    Object key = it.getKey();
                    return new FileV2("/" + packageName + "/" + key + "/" + str, (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null);
                }
                return null;
            }
        });
    }

    private final Map<String, List<FileV2>> toLocalizedFileListV2(Map<String, Localized> map, final String str, final Function1 function1) {
        if (map == null) {
            return null;
        }
        return IndexConverterKt.mapValuesNotNull(map, new Function1() { // from class: org.fdroid.index.v1.AppV1$toLocalizedFileListV2$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final List invoke(Map.Entry it) {
                int collectionSizeOrDefault;
                Intrinsics.checkNotNullParameter(it, "it");
                List list = (List) Function1.this.invoke(it.getValue());
                if (list != null) {
                    AppV1 appV1 = this;
                    String str2 = str;
                    collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                    ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                    Iterator it2 = list.iterator();
                    while (it2.hasNext()) {
                        String packageName = appV1.getPackageName();
                        Object key = it.getKey();
                        arrayList.add(new FileV2("/" + packageName + "/" + key + "/" + str2 + "/" + ((String) it2.next()), (String) null, (Long) null, (String) null, 14, (DefaultConstructorMarker) null));
                    }
                    return arrayList;
                }
                return null;
            }
        });
    }
}
