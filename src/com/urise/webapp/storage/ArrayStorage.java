package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {


 public void save(Resume r) {
        if (!ifExists(r.getUuid()) || !isFull()) {
            storage[counter++]=r;
        } else {
            System.out.println("resume is not exists or storage if full!");
        }
    }

    public void delete(String uuid) {
        int pos = getPosition(uuid);
        if (pos == -1) {
            System.out.println("com.urise.webapp.model.Resume with uuid: " + uuid + " not found!");
        } else {
            System.arraycopy(storage, pos + 1, storage, pos, storage.length - pos - 1);
            counter--;
        }
    }

    public void update(Resume r) {
        if(ifExists(r.getUuid())) {
            storage[getPosition(r.getUuid())] = r;
        } else {
            System.out.println("com.urise.webapp.model.Resume not found!");
        }

    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
  protected int getPosition(String uuid) {
        for (int i = 0; i < counter; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private boolean ifExists(String uuid) {
        return getPosition(uuid) != -1;
    }

    private boolean isFull() {
        return counter == storage.length-1;
    }
}
