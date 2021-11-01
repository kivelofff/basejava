package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MapFullNameStorageTest extends MapStorageTest{
    private static final String FULL_NAME_1 = "fullname1";
    private static final String FULL_NAME_2 = "fullname2";
    private static final String FULL_NAME_3 = "fullname3";
    private static final String FULL_NAME_4 = "fullname4";

    @Override
    public void initStorage() {
        storage = new MapFullNameStorage(new HashMap<>());
    }

    @Override
    public void setUp() throws Exception {
        super.setUp();
        RESUME_1.setFullName(FULL_NAME_1);
        RESUME_2.setFullName(FULL_NAME_2);
        RESUME_3.setFullName(FULL_NAME_3);
        RESUME_4.setFullName(FULL_NAME_4);
    }

    @Override
    public void get() {
        Assert.assertEquals(new Resume(UUID_1, FULL_NAME_1), storage.get(FULL_NAME_1));
    }

    @Override
    public void update() {
        storage.update(new Resume(null, FULL_NAME_3));
        Assert.assertEquals(new Resume(null, FULL_NAME_3), storage.get(FULL_NAME_3));
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
}