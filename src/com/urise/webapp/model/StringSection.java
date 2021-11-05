package com.urise.webapp.model;

public class StringSection implements Section{
    protected final SectionType TYPE;
    private String info;

    public StringSection(String info, SectionType TYPE) {
        this.info = info;
        this.TYPE = TYPE;
    }

    public StringSection(SectionType TYPE) {
        this.TYPE = TYPE;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TYPE).append(System.lineSeparator()).append(info).append(System.lineSeparator());
        return sb.toString();
    }
}
