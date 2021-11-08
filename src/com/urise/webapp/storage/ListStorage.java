package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStorage extends AbstractStorage<Integer>{

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
        return Collections.binarySearch(storage, r, Resume.RESUME_UUID_COMPARATOR);
    }

    @Override
    protected void addElement(Resume r, Integer pos) {
        storage.add(r);
    }

    @Override
    protected Resume getElement(Integer pos) {
        return storage.get(pos);
    }

    @Override
    protected void removeElement(Integer pos) {
        int index = (Integer)pos;
        storage.remove(index);
    }

    @Override
    protected void replaceElement(Resume r, Integer pos) {
        storage.add(pos, r);

    }

    @Override
    protected List<Resume> getAllElements() {
        return new ArrayList<>(List.copyOf(storage));
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected boolean isExists(Integer pos) {
        return pos>=0;
    }
}
