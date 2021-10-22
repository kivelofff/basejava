package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Map;

public class MapStorage extends AbstractStorage {

    private final Map<String, Resume> storage;

    public MapStorage(Map<String, Resume> storage) {
        this.storage = storage;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected int getPosition(Resume r) {

        return storage.containsKey(r.getUuid())? 1 : -1;
    }

    @Override
    protected void addElement(Resume r) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void removeElement(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected void replaceElement(Resume r) {
        addElement(r);
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
