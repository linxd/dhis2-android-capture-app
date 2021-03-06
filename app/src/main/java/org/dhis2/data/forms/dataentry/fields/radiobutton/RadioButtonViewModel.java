package org.dhis2.data.forms.dataentry.fields.radiobutton;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

import org.dhis2.data.forms.dataentry.fields.FieldViewModel;
import org.hisp.dhis.android.core.common.ValueType;

import java.util.Locale;

import javax.annotation.Nonnull;

/**
 * QUADRAM. Created by frodriguez on 1/24/2018.
 */
@AutoValue
public abstract class RadioButtonViewModel extends FieldViewModel {

    public enum Value {
        CHECKED("true"), CHECKED_NO("false"), UNCHECKED("");

        @NonNull
        private final String value;

        Value(@NonNull String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @NonNull
    public abstract Boolean mandatory();


    @NonNull
    public abstract ValueType valueType();

    @NonNull
    public static RadioButtonViewModel fromRawValue(@NonNull String id, @NonNull String label, @NonNull ValueType type,
                                                    @NonNull Boolean mandatory, @Nullable String value, @Nullable String section, Boolean editable, @Nullable String description) {
        if (value == null) {
            return new AutoValue_RadioButtonViewModel(id, label, null, section, null, editable, null, null, null, description, mandatory, type);
        } else if (value.toLowerCase(Locale.US).equals(Value.CHECKED.toString())) {
            return new AutoValue_RadioButtonViewModel(id, label, Value.CHECKED.toString(), section, null, editable, null, null, null, description, mandatory, type);
        } else if (value.toLowerCase(Locale.US).equals(Value.UNCHECKED.toString())) {
            return new AutoValue_RadioButtonViewModel(id, label, Value.UNCHECKED.toString(), section, null, editable, null, null, null, description, mandatory, type);
        } else if (value.toLowerCase(Locale.US).equals(Value.CHECKED_NO.toString())) {
            return new AutoValue_RadioButtonViewModel(id, label, Value.CHECKED_NO.toString(), section, null, editable, null, null, null, description, mandatory, type);
        } else {
            throw new IllegalArgumentException("Unsupported value: " + value);
        }
    }

    @Override
    public FieldViewModel setMandatory() {
        return new AutoValue_RadioButtonViewModel(uid(), label(), value(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning(), error(), description(), true, valueType());
    }

    @NonNull
    @Override
    public FieldViewModel withError(@NonNull String error) {
        return new AutoValue_RadioButtonViewModel(uid(), label(), value(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning(), error, description(), mandatory(), valueType());
    }

    @NonNull
    @Override
    public FieldViewModel withWarning(@NonNull String warning) {
        return new AutoValue_RadioButtonViewModel(uid(), label(), value(), programStageSection(), allowFutureDate(), editable(), optionSet(), warning, error(), description(), mandatory(), valueType());
    }

    @Nonnull
    @Override
    public FieldViewModel withValue(String data) {
        return new AutoValue_RadioButtonViewModel(uid(), label(), data, programStageSection(), allowFutureDate(), false, optionSet(), warning(), error(), description(), mandatory(), valueType());
    }
}
