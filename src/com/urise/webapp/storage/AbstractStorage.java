package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage<T> implements Storage{


    @Override
    public abstract void clear();

    protected abstract T getPosition(Resume r) ;

    protected T getPosition(String uuid) {
        return getPosition(new Resume(uuid, ""));
    }

    @Override
    public void save(Resume r) {
        T pos = checkIfNotExists(r.getUuid());
        addElement(r, pos);
    }

    protected abstract void addElement(Resume r, T pos);

    @Override
    public Resume get(String uuid) {

        return getElement(findIfExists(uuid));
    }

    protected abstract Resume getElement(T pos);

    @Override
    public void delete(String uuid) {
        removeElement(findIfExists(uuid));
    }

    protected abstract void removeElement(T pos);

    @Override
    public void update(Resume r) {
        findIfExists(r.getUuid());
        replaceElement(r, findIfExists(r.getUuid()));
    }

    protected abstract void replaceElement(Resume r, T pos);

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllElements();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> getAllElements();


    @Override
    public abstract int size();

    protected T findIfExists(String k) {
        T pos = getPosition(k);
        if (pos<0) {
            throw new NotExistStorageException(k);
        }
        return pos;
    }

    protected T checkIfNotExists(String k) {
        T pos = getPosition(k);
        if (pos>=0) {
            throw new ExistStorageException(k);
        }
        return -(pos+1);
    }

}
