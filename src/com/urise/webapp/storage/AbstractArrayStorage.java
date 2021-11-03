package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int LIMIT = 10000;
    protected final Resume[] storage = new Resume[LIMIT];
    protected int counter = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counter + 1, null);
        counter = 0;
    }

    public Resume getElement(Object pos) {

        return storage[(Integer)pos];
    }

    protected List<Resume> getAllElements() {
         return Arrays.asList(Arrays.copyOf(storage, counter));
    }

    public int size() {
        return counter;
    }


    public void replaceElement(Resume r, Object pos) {

        storage[(Integer)pos] = r;

    }

    public void addElement(Resume r, Object pos) {
        if (counter == LIMIT) {
            throw new StorageException("Storage is full!", r.getUuid());
        }
        addElementToArray(r, (Integer)pos);


    }

    @Override
    public void removeElement(Object pos) {
        Integer position = (Integer)pos;
        System.arraycopy(storage, position + 1, storage, position, counter - position - 1);
        storage[counter - 1] = null;
        counter--;


    }

    protected abstract void addElementToArray(Resume r, int pos);


}
