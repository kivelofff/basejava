package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class AbstractArrayStorage extends AbstractStorage<Integer> {
    protected static final int LIMIT = 10000;
    protected final Resume[] storage = new Resume[LIMIT];
    protected int counter = 0;

    @Override
    public void clear() {
        Arrays.fill(storage, 0, counter + 1, null);
        counter = 0;
    }

    public Resume getElement(Integer pos) {

        return storage[pos];
    }

    protected List<Resume> getAllElements() {
         return Arrays.asList(Arrays.copyOf(storage, counter));
    }

    public int size() {
        return counter;
    }


    public void replaceElement(Resume r, Integer pos) {

        storage[pos] = r;

    }

    public void addElement(Resume r, Integer pos) {
        if (counter == LIMIT) {
            throw new StorageException("Storage is full!", r.getUuid());
        }
        addElementToArray(r, pos);


    }

    @Override
    public void removeElement(Integer pos) {
        System.arraycopy(storage, pos + 1, storage, pos, counter - pos - 1);
        storage[counter - 1] = null;
        counter--;


    }

    protected abstract void addElementToArray(Resume r, Integer pos);

    @Override
    protected boolean isExists(Integer pos) {
        return pos>=0;
    }
}
