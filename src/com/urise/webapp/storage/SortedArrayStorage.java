package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    protected int getPosition(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0 , counter, resume);
    }

    protected void insertNewResume(Resume r, int pos) {
        System.arraycopy(storage, -pos-1, storage, -pos, counter + pos+1);
        storage[-pos-1] = r;
    }

}
