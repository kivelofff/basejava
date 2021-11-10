package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    protected final Map<String, Resume> storage = new HashMap<>();


    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected String getPosition(Resume r) {
        String uuid = r.getUuid();
        return storage.containsKey(uuid)? uuid : null ;
    }

    @Override
    protected void addElement(Resume r, String pos) {
        storage.put(r.getUuid(), r);
    }

    @Override
    protected Resume getElement(String pos) {
        return storage.get(pos);
    }

    @Override
    protected void removeElement(String pos) {
        storage.remove(pos);
    }

    @Override
    protected void replaceElement(Resume r, String pos) {
        storage.put(pos, r);
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
    protected boolean isExists(String pos) {
        return pos!= null;
    }
}
