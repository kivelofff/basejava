package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Map;

public class MapFullNameStorage extends MapStorage{
    public MapFullNameStorage(Map<String, Resume> storage) {
        super(storage);
    }

    @Override
    protected String getPosition(Resume r) {
        return storage.containsKey(r.getFullName())? r.getFullName() : new String();
    }

    @Override
    protected Object getPosition(String fullname) {
        Resume resume = new Resume();
        resume.setFullName(fullname);
        return getPosition(resume);
    }
}
