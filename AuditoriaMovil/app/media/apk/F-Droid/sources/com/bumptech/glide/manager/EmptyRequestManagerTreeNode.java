package com.bumptech.glide.manager;

import java.util.Collections;
import java.util.Set;
/* loaded from: classes.dex */
final class EmptyRequestManagerTreeNode implements RequestManagerTreeNode {
    @Override // com.bumptech.glide.manager.RequestManagerTreeNode
    public Set getDescendants() {
        return Collections.emptySet();
    }
}
