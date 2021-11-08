package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    protected Integer getPosition(Resume resume) {
        return Arrays.binarySearch(storage, 0 , counter, resume, Resume.RESUME_UUID_COMPARATOR);
    }

    protected void addElementToArray(Resume r, Integer pos) {
        Integer position = -(pos +1);
        System.arraycopy(storage, position, storage, position+1, counter - position);
        storage[position] = r;
        counter++;
    }

}
