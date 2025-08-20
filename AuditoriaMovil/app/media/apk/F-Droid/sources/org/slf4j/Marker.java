package org.slf4j;

import java.io.Serializable;
/* loaded from: classes2.dex */
public interface Marker extends Serializable {
    boolean contains(Marker marker);

    String getName();
}
