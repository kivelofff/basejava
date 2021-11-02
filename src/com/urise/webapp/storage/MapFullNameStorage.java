package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Map;

public class MapFullNameStorage extends AbstractMapStorage{


    @Override
    protected String getPosition(Resume r) {
        return storage.containsKey(r.getFullName())? r.getFullName() : new String();
    }

    @Override
    public void save(Resume r) {
        Object pos = checkIfNotExists(r.getFullName());
        addElement(r, pos);
    }

    @Override
    public void update(Resume r) {
        findIfExists(r.getFullName());
        replaceElement(r, findIfExists(r.getFullName()));
    }

    @Override
    protected Object getPosition(String fullname) {
        Resume resume = new Resume();
        resume.setFullName(fullname);
        return getPosition(resume);
    }
}
