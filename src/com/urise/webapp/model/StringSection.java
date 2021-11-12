package com.urise.webapp.model;

import java.util.Objects;

public class StringSection implements Section{
    private String info;

    public StringSection(String info) {
        Objects.requireNonNull(info, "content must be not null!");
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        return "StringSection{" +
                "info='" + info + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StringSection that = (StringSection) o;

        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return info.hashCode();
    }
}
