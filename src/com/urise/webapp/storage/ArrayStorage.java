package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


    @Override
    protected void addElementToArray(Resume r, Integer pos) {
        storage[counter++]=r;
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
  protected Integer getPosition(Resume r) {

        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(r.getUuid())) {
                return i;
            }
        }
        return -1;
    }
}
