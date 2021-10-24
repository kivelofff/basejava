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
    protected Resume getPosition(Resume r) {

        return storage.containsKey(r.getUuid())? r : null;
    }

    @Override
    protected void addElement(Resume r, Object pos) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(Object pos) {
        String uuid = ((Resume)pos).getUuid();
        return storage.get(uuid);
    }

    @Override
    protected void removeElement(Object pos) {
        String uuid = ((Resume)pos).getUuid();
        storage.remove(uuid);
    }

    @Override
    protected void replaceElement(Resume r, Object pos) {
        String uuid = ((Resume)pos).getUuid();
        storage.put(uuid, r);
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
