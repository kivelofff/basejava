package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

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
    protected String getPosition(Resume r) {

        return storage.containsKey(r.getUuid())? r.getUuid() : new String();
    }

    @Override
    protected void addElement(Resume r, Object pos) {
        storage.put((String)pos, r);
    }

    @Override
    protected Resume getElement(Object pos) {
        String uuid = (String) pos;
        return storage.get(uuid);
    }

    @Override
    protected void removeElement(Object pos) {
        String uuid = (String) pos;
        storage.remove(uuid);
    }

    @Override
    protected void replaceElement(Resume r, Object pos) {
        String uuid = (String) pos;
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

    @Override
    protected Object findIfExists(String uuid) {
        String pos = (String) getPosition(uuid);
        if (pos.isEmpty()) {
            throw new NotExistStorageException(uuid);
        }
        return pos;
    }

    @Override
    protected Object checkIfNotExists(String uuid) {
        String pos = (String) getPosition(uuid);
        if (!pos.isEmpty()) {
            throw new ExistStorageException(uuid);
        }
        return uuid;
    }
}
