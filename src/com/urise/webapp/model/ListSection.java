package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class ListSection implements Section{
    protected final SectionType TYPE;
    protected List<String> info;

    public ListSection(List<String> info, SectionType TYPE) {
        this.info = info;
        this.TYPE = TYPE;
    }

    public ListSection(SectionType TYPE) {
        this.info = new ArrayList<>();
        this.TYPE = TYPE;
    }

    public void addElement(String s) {
        info.add(s);
    }

    public boolean removeElement(String s) {
        return info.remove(s);
    }


}
