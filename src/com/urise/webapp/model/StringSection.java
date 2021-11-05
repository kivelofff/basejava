package com.urise.webapp.model;

public class StringSection implements Section{
    protected final SectionType TYPE;
    private final String info;

    public StringSection(String info, SectionType TYPE) {
        this.info = info;
        this.TYPE = TYPE;
    }

    public String getInfo() {
        return info;
    }
}
