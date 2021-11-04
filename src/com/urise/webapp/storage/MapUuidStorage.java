package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractMapStorage {

    @Override
    protected Object findIfExists(Object uuid) {
        String pos = (String) getPosition((String)uuid);
        if (pos.isEmpty()) {
            throw new NotExistStorageException((String)uuid);
        }
        return pos;
    }

    @Override
    protected Object checkIfNotExists(Object uuid) {
        String pos = (String) getPosition((String)uuid);
        if (!pos.isEmpty()) {
            throw new ExistStorageException((String)uuid);
        }
        return uuid;
    }


    @Override
    protected String getPosition(Resume r) {

        return storage.containsKey(r.getUuid())? r.getUuid() : new String();
    }



}
