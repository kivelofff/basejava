package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int LIMIT = 10000;
    protected final Resume[] storage = new Resume[LIMIT];
    protected int counter = 0;

    public void clear() {
        Arrays.fill(storage,0, counter+1, null);
        counter = 0;
    }

    public Resume get(String uuid) {
        int pos = getPosition(uuid);
        if (pos == -1) {
            System.out.println("com.urise.webapp.model.Resume with uuid: " + uuid + " not found!");
            return null;
        } else {
            return storage[pos];
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, counter);
    }

    public int size() {
        return counter;
    }



    protected abstract int getPosition(String uuid);
}
