package org.dhis2.data.forms.dataentry.fields.coordinate;

import android.support.annotation.NonNull;

import org.dhis2.data.forms.dataentry.fields.FieldViewModel;
import com.google.auto.value.AutoValue;

import javax.annotation.Nonnull;

/**
 * QUADRAM. Created by frodriguez on 1/24/2018.
 */

@AutoValue
public abstract class CoordinateViewModel extends FieldViewModel {
    public static FieldViewModel create(String id, String label, Boolean mandatory, String value, String section,Boolean editable,String description) {
        return new AutoValue_CoordinateViewModel(id, label, mandatory, value, section, null, editable, null, null, null,description);
    }

    @Override
    public FieldViewModel setMandatory() {
        return new AutoValue_CoordinateViewModel(uid(), label(), true, value(), programStageSection(), null, editable(), null, warning(), error(),description());
    }

    @NonNull
    @Override
    public FieldViewModel withWarning(@NonNull String warning) {
        return new AutoValue_CoordinateViewModel(uid(), label(), mandatory(), value(), programStageSection(), null, editable(), null, warning, error(),description());
    }

    @NonNull
    @Override
    public FieldViewModel withError(@NonNull String error) {
        return new AutoValue_CoordinateViewModel(uid(), label(), mandatory(), value(), programStageSection(), null, editable(), null, warning(), error,description());
    }

    @Nonnull
    @Override
    public FieldViewModel withValue(String data) {
        return new AutoValue_CoordinateViewModel(uid(), label(), mandatory(), data, programStageSection(), null, false, null, warning(), error(),description());
    }
}
