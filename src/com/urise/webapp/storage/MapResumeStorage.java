package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

public class MapResumeStorage extends AbstractMapStorage{

    @Override
    protected Object getPosition(String uuid) {
        return super.getPosition(uuid);
    }

    @Override
    protected Object getPosition(Resume r) {
        return storage.get(r.getUuid());
    }

    @Override
    protected Resume getElement(Object pos) {
        return (Resume)pos;
    }

    @Override
    protected void removeElement(Object pos) {
        Resume resume= (Resume) pos;
        storage.remove(resume.getUuid());
    }

    @Override
    protected void replaceElement(Resume r, Object pos) {
       storage.put(((Resume)pos).getUuid(), r);
    }

    @Override
    protected Object findIfExists(Object uuid) {
        Resume r = (Resume) getPosition((String)uuid);
        if (r==null) {
            throw new NotExistStorageException((String)uuid);
        }
        return r;
    }

    @Override
    protected Object checkIfNotExists(Object uuid) {
        Resume r = (Resume) getPosition((String)uuid);
        if (r != null) {
            throw new ExistStorageException((String)uuid);
        }
        return uuid;
    }
}
