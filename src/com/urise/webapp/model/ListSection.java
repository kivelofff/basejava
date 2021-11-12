package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection implements Section{

    protected List<String> info;

    public ListSection(List<String> info) {
        this.info = info;
    }

    public ListSection() {
        this.info = new ArrayList<>();
    }

    public void addElement(String s) {
        info.add(s);
    }

    public boolean removeElement(String s) {
        return info.remove(s);
    }

    @Override
    public String toString() {
        return "ListSection{" +
                "info=" + info +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListSection that = (ListSection) o;

        return info.equals(that.info);
    }

    @Override
    public int hashCode() {
        return info.hashCode();
    }
}
