package com.revature.rms.employee.dtos;

import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.Objects;

public class GetEmployeeByFieldRequest {

    @NotEmpty
    private String field;

    @NotEmpty
    private String[] values;

    public GetEmployeeByFieldRequest() {
        super();
    }

    public GetEmployeeByFieldRequest(String field, String[] values) {
        this.field = field;
        this.values = values;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String[] getValues() {
        return values;
    }

    public void setValues(String[] value) {
        this.values = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetEmployeeByFieldRequest that = (GetEmployeeByFieldRequest) o;
        return Objects.equals(field, that.field) &&
                Objects.equals(values, that.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, values);
    }

    @Override
    public String toString() {
        return "GetEmployeeByFieldRequest{" +
                "field='" + field + '\'' +
                ", values=" + Arrays.toString(values) +
                '}';
    }

}
