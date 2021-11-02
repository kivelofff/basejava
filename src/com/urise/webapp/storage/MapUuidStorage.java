package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;

import java.util.Map;

public class MapUuidStorage extends AbstractMapStorage {


    @Override
    protected String getPosition(Resume r) {

        return storage.containsKey(r.getUuid())? r.getUuid() : new String();
    }


}
