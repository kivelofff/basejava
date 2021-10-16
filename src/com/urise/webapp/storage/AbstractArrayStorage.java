package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage{
    public static final int LIMIT = 10000;
    protected final Resume[] storage = new Resume[LIMIT];
    protected int counter = 0;

    public void clear() {
        Arrays.fill(storage,0, counter+1, null);
        counter = 0;
    }

    public Resume get(String uuid) {
        int pos = getPosition(uuid);
        if (pos == -1) {
            throw new NotExistStorageException(uuid);
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


    public void update(Resume r) {
        int pos = getPosition(r.getUuid());
        if (pos <0) {
            throw new NotExistStorageException(r.getUuid());
        } else {
            storage[pos]=r;
        }
    }

    public void save(Resume r) {
        int pos = getPosition(r.getUuid());
        if (pos >=0 || counter == LIMIT) {
            throw new ExistStorageException(r.getUuid());
        } else {
            insertNewResume(r, pos);
            counter++;
        }

    }

    @Override
    public void delete(String uuid) {
        int pos = getPosition(uuid);
        if (pos <0) {
            throw new NotExistStorageException(uuid);
        } else {
            if (pos != counter-1) {
                System.arraycopy(storage, pos + 1, storage, pos, counter - pos - 1);
            }
            storage[counter-1]=null;
            counter--;

        }
    }

    protected abstract void insertNewResume(Resume r, int pos);

    protected abstract int getPosition(String uuid);
}
