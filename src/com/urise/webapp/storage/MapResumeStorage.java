package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume>{
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void addElement(Resume r, Resume pos) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(Resume pos) {
        return storage.get(pos.getUuid());
    }

    @Override
    protected void removeElement(Resume pos) {
        storage.remove(pos.getUuid());
    }

    @Override
    protected void replaceElement(Resume r, Resume pos) {
        storage.put(pos.getUuid(), r);
    }

    @Override
    protected List<Resume> getAllElements() {
        return List.copyOf(storage.values());
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExists(Resume pos) {
        return pos != null;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected Resume getPosition(Resume r) {
        return getElement(r);
    }

}
