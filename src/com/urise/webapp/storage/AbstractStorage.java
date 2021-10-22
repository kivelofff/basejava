package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collection;

public abstract class AbstractStorage implements Storage{


    @Override
    public abstract void clear();

    protected abstract int getPosition(Resume r);

    protected int getPosition(String uuid) {
        return getPosition(new Resume(uuid));
    }

    @Override
    public void save(Resume r) {
        if (getPosition(r)>=0) {
            throw new ExistStorageException(r.getUuid());
        } else {
            addElement(r);
        }
    }

    protected abstract void addElement(Resume r);

    @Override
    public Resume get(String uuid) {
        if (getPosition(uuid)<0) {
            throw new NotExistStorageException(uuid);
        }
        return getElement(uuid);
    }

    protected abstract Resume getElement(String uuid);

    @Override
    public void delete(String uuid) {
        if (getPosition(uuid)<0) {
            throw new NotExistStorageException(uuid);
        }
        removeElement(uuid);

    }



    protected abstract void removeElement(String uuid);

    @Override
    public void update(Resume r) {
        if (getPosition(r)<0) {
            throw new NotExistStorageException(r.getUuid());
        }
        replaceElement(r);
    }

    protected abstract void replaceElement(Resume r);

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract int size();
}
