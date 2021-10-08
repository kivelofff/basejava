package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{
    @Override
    protected int getPosition(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        return Arrays.binarySearch(storage, 0 , counter, resume);
    }

    @Override
    public void save(Resume r) {
        int pos = - getPosition(r.getUuid()) - 1;
        if (pos <0 || counter == LIMIT) {
            System.out.println("Resume already exist or storage is full!");
        } else {
            System.arraycopy(storage, pos, storage, pos + 1, counter - pos);
            storage[pos] = r;
            counter++;
        }

    }

    @Override
    public void delete(String uuid) {
        Resume resume = new Resume();
        resume.setUuid(uuid);
        int pos = getPosition(uuid);
        if (pos <0) {
            System.out.println("Resume doesn't exist!");
        } else {
            System.arraycopy(storage, pos+1, storage, pos, counter-pos);
            counter--;
        }
    }

    @Override
    public void update(Resume r) {
        int pos = getPosition(r.getUuid());
        if (pos <0) {
            System.out.println("Resume doesn't exist!");
        } else {
            storage[pos]=r;
        }
    }

}
