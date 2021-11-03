package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class AbstractMapStorage extends AbstractStorage{
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    public void clear() {
        storage.clear();
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
    protected List<Resume> getAllElements() {
        return new ArrayList<>(List.copyOf(storage.values()));
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
