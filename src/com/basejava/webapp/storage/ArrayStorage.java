package com.basejava.webapp.storage;

import com.basejava.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int size = 0;

    public void clear() {
        Arrays.fill(storage, 0, size, null);
        size = 0;
    }

    public void save(Resume r) {
        if (size < storage.length) {
            int pos = findPos(r.getUuid());
            if (pos == -1) {
                storage[size++] = r;
            } else {
                log("Error: impossible to save, resume with same uuid already exists in storage");
            }
        } else {
            log("Error: impossible to save, storage is full");
        }
    }

    public Resume get(String uuid) {
        int pos = findPos(uuid);
        return pos != -1 ? storage[pos] : null;
    }

    public void delete(String uuid) {
        int pos = findPos(uuid);
        if (pos != -1) {
            storage[pos] = storage[size-1];
            storage[size-1] = null;
            size--;
        } else {
            log("Error: impossible to update, resume does not exist in storage");
        }
    }

    public void update (Resume r) {
        int pos = findPos(r.getUuid());
        if (pos != -1) {
            storage[pos] = r;
            log("Resume with uuid: " + r.getUuid() + " successfully updated");
        } else {
            log("Error: impossible to update, resume does not exist in storage");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, size);
    }

    public int size() {
        return size;
    }

    public int getSize() {
        return size;
    }

    private int findPos(String uuid) {
        for (int i = 0; i < size; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    private void log(String msg) {
        System.out.println(msg);
    }
}
