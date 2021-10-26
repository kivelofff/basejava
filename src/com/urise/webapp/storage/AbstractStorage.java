package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public abstract class AbstractStorage implements Storage{


    @Override
    public abstract void clear();

    protected abstract Object getPosition(Resume r);

    protected Object getPosition(String uuid) {
        return getPosition(new Resume(uuid));
    }

    @Override
    public void save(Resume r) {
        Object pos = checkIfNotExists(r.getUuid());
        addElement(r, pos);
    }

    protected abstract void addElement(Resume r, Object pos);

    @Override
    public Resume get(String uuid) {

        return getElement(findIfExists(uuid));
    }

    protected abstract Resume getElement(Object pos);

    @Override
    public void delete(String uuid) {
        removeElement(findIfExists(uuid));
    }

    protected abstract void removeElement(Object pos);

    @Override
    public void update(Resume r) {
        findIfExists(r.getUuid());
        replaceElement(r, findIfExists(r.getUuid()));
    }

    protected abstract void replaceElement(Resume r, Object pos);

    @Override
    public abstract Resume[] getAll();

    @Override
    public abstract int size();

    protected Object findIfExists(String uuid) {
        Integer pos = (Integer)getPosition(uuid);
        if (pos<0) {
            throw new NotExistStorageException(uuid);
        }
        return pos;
    }

    protected Object checkIfNotExists(String uuid) {
        Integer pos = (Integer)getPosition(uuid);
        if (pos>=0) {
            throw new ExistStorageException(uuid);
        }
        return -(pos+1);
    }

}
