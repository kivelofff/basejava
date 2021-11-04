package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

public class MapResumeStorage extends AbstractMapStorage{
    @Override
    protected Object getPosition(Resume r) {
        return storage.containsKey(r.getUuid())? r : null;
    }


}
