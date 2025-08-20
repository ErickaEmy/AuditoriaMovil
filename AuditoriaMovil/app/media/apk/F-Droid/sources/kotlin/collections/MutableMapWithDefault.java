package kotlin.collections;

import java.util.Map;
import kotlin.jvm.internal.markers.KMutableMap;
/* compiled from: MapWithDefault.kt */
/* loaded from: classes.dex */
interface MutableMapWithDefault extends Map, MapWithDefault, KMutableMap {
    Map getMap();
}
