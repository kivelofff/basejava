package com.urise.webapp.model;

import java.util.HashMap;
import java.util.Map;

public class MapSection<T> implements Section{
    protected final SectionType TYPE;
    protected final HashMap<T, String> info;

    public MapSection(HashMap<T, String> info, SectionType type) {
        this.info = info;
        TYPE = type;
    }

    public MapSection(SectionType type) {
        this.info = new HashMap<>();
        TYPE = type;
    }

    public void addElement (T key, String value) {
        info.put(key, value);
    }

    public boolean removeElement(T key) {
        return info.remove(key) != null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(TYPE);
        for (Map.Entry<T, String> e : info.entrySet()){
            sb.append(e.getKey()).append(": ").append(e.getValue()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
