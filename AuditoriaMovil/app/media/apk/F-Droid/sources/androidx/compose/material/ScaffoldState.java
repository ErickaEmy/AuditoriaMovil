package androidx.compose.material;

import kotlin.jvm.internal.Intrinsics;
/* compiled from: Scaffold.kt */
/* loaded from: classes.dex */
public final class ScaffoldState {
    private final DrawerState drawerState;
    private final SnackbarHostState snackbarHostState;

    public final DrawerState getDrawerState() {
        return this.drawerState;
    }

    public final SnackbarHostState getSnackbarHostState() {
        return this.snackbarHostState;
    }

    public ScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState) {
        Intrinsics.checkNotNullParameter(drawerState, "drawerState");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        this.drawerState = drawerState;
        this.snackbarHostState = snackbarHostState;
    }
}
