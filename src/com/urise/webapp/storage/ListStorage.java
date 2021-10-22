package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage{

    private final List<Resume> storage;

    public ListStorage(List<Resume> storage) {
        this.storage = storage;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    protected int getPosition(Resume r) {
        return Collections.binarySearch(storage, r);
    }

    @Override
    protected void addElement(Resume r) {
        storage.add(r);
    }

    @Override
    protected Resume getElement(String uuid) {
        return storage.get(getPosition(uuid));
    }

    @Override
    protected void removeElement(String uuid) {
        storage.remove(new Resume(uuid));
    }

    @Override
    protected void replaceElement(Resume r) {
        storage.add(getPosition(r), r);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    public int size() {
        return storage.size();
    }
}
