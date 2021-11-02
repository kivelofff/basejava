package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class MapFullNameStorageTest extends MapUuidStorageTest {


    @Override
    public void initStorage() {
        storage = new MapFullNameStorage();
    }

    @Override
    public void get() {
        Assert.assertEquals(new Resume(UUID_1, FULL_NAME_1), storage.get(FULL_NAME_1));
    }

    @Override
    public void update() {
        storage.update(new Resume("new uuid", FULL_NAME_3));
        Assert.assertEquals(new Resume("new uuid", FULL_NAME_3), storage.get(FULL_NAME_3));
    }

    @Override
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(new Resume(UUID_4, FULL_NAME_4), storage.get(FULL_NAME_4));
    }

    @Override
    public void delete() {
        storage.delete(FULL_NAME_4);
        storage.get(FULL_NAME_4);
    }

    @Override
    public void saveExist() {
        storage.save(new Resume(UUID_1, FULL_NAME_1));
    }

    @Override
    public void getAll() {
        assertEquals(storage.get(FULL_NAME_1), new Resume(UUID_1, FULL_NAME_1));
        assertEquals(storage.get(FULL_NAME_2), new Resume(UUID_2, FULL_NAME_2));
        assertEquals(storage.get(FULL_NAME_3), new Resume(UUID_3, FULL_NAME_3));;
    }
}