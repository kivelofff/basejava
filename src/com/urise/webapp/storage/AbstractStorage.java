package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage implements Storage{


    @Override
    public abstract void clear();

    protected abstract Object getPosition(Resume r) ;

    protected Object getPosition(String uuid) {
        return getPosition(new Resume(uuid, ""));
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

    public List<Resume> getAllSorted() {
        List<Resume> list = getAllElements();
        Collections.sort(list);
        return list;
    }

    protected abstract List<Resume> getAllElements();


    @Override
    public abstract int size();

    protected Object findIfExists(Object k) {
        String key = (String)k;
        Integer pos = (Integer)getPosition(key);
        if (pos<0) {
            throw new NotExistStorageException(key);
        }
        return pos;
    }

    protected Object checkIfNotExists(Object k) {
        String key = (String)k;
        Integer pos = (Integer)getPosition(key);
        if (pos>=0) {
            throw new ExistStorageException(key);
        }
        return -(pos+1);
    }

}
