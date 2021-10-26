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
    protected Integer getPosition(Resume r) {
        return Collections.binarySearch(storage, r);
    }

    @Override
    protected void addElement(Resume r, Object pos) {
        storage.add((Integer) pos, r);
    }

    @Override
    protected Resume getElement(Object pos) {
        return storage.get((Integer)pos);
    }

    @Override
    protected void removeElement(Object pos) {
        int index = (Integer)pos;
        storage.remove(index);
    }

    @Override
    protected void replaceElement(Resume r, Object pos) {
        storage.add((Integer)pos, r);

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
