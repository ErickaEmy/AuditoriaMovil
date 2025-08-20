package androidx.compose.ui.autofill;

import android.util.SparseArray;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.autofill.AutofillValue;
import androidx.appcompat.app.ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0;
import java.util.Map;
import kotlin.NotImplementedError;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: AndroidAutofill.android.kt */
/* loaded from: classes.dex */
public abstract class AndroidAutofill_androidKt {
    public static final void populateViewStructure(AndroidAutofill androidAutofill, ViewStructure root) {
        Intrinsics.checkNotNullParameter(androidAutofill, "<this>");
        Intrinsics.checkNotNullParameter(root, "root");
        int addChildCount = AutofillApi23Helper.INSTANCE.addChildCount(root, androidAutofill.getAutofillTree().getChildren().size());
        for (Map.Entry entry : androidAutofill.getAutofillTree().getChildren().entrySet()) {
            int intValue = ((Number) entry.getKey()).intValue();
            ToolbarActionBar$$ExternalSyntheticThrowCCEIfNotNull0.m(entry.getValue());
            AutofillApi23Helper autofillApi23Helper = AutofillApi23Helper.INSTANCE;
            ViewStructure newChild = autofillApi23Helper.newChild(root, addChildCount);
            if (newChild != null) {
                AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
                AutofillId autofillId = autofillApi26Helper.getAutofillId(root);
                Intrinsics.checkNotNull(autofillId);
                autofillApi26Helper.setAutofillId(newChild, autofillId, intValue);
                autofillApi23Helper.setId(newChild, intValue, androidAutofill.getView().getContext().getPackageName(), null, null);
                autofillApi26Helper.setAutofillType(newChild, 1);
                throw null;
            }
            addChildCount++;
        }
    }

    public static final void performAutofill(AndroidAutofill androidAutofill, SparseArray values) {
        Intrinsics.checkNotNullParameter(androidAutofill, "<this>");
        Intrinsics.checkNotNullParameter(values, "values");
        int size = values.size();
        for (int i = 0; i < size; i++) {
            int keyAt = values.keyAt(i);
            AutofillValue value = AndroidAutofill_androidKt$$ExternalSyntheticApiModelOutline0.m(values.get(keyAt));
            AutofillApi26Helper autofillApi26Helper = AutofillApi26Helper.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(value, "value");
            if (autofillApi26Helper.isText(value)) {
                androidAutofill.getAutofillTree().performAutofill(keyAt, autofillApi26Helper.textValue(value).toString());
            } else if (autofillApi26Helper.isDate(value)) {
                throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for date");
            } else if (autofillApi26Helper.isList(value)) {
                throw new NotImplementedError("An operation is not implemented: b/138604541: Add onFill() callback for list");
            } else if (autofillApi26Helper.isToggle(value)) {
                throw new NotImplementedError("An operation is not implemented: b/138604541:  Add onFill() callback for toggle");
            }
        }
    }
}
