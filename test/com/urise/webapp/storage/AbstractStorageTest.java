package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

public abstract class AbstractStorageTest {
    protected Storage storage;
    protected static final String UUID_1="uuid1";
    protected static final String UUID_2="uuid2";
    protected static final String UUID_3="uuid3";
    protected static final String UUID_4="uuid4";
    protected static final String FULL_NAME_1 = "fullname1";
    protected static final String FULL_NAME_2 = "fullname2";
    protected static final String FULL_NAME_3 = "fullname3";
    protected static final String FULL_NAME_4 = "fullname4";
    protected static final Resume RESUME_1 = new Resume(UUID_1, FULL_NAME_1);
    protected static final Resume RESUME_2 = new Resume(UUID_2, FULL_NAME_2);
    protected static final Resume RESUME_3 = new Resume(UUID_3, FULL_NAME_3);
    protected static final Resume RESUME_4 = new Resume(UUID_4, FULL_NAME_4);

    public abstract void initStorage();

    @Before
    public void setUp() throws Exception {
        if (storage == null) {
            initStorage();
        }
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume(UUID_1, FULL_NAME_1), storage.get(UUID_1));
    }

    @Test
    public void getAll() {
        Assert.assertEquals(Arrays.asList(new Resume[]{new Resume(UUID_1, FULL_NAME_1), new Resume(UUID_2, FULL_NAME_2), new Resume(UUID_3, FULL_NAME_3)}), storage.getAllSorted());
    }

    @Test
    public void size() {
        Assert.assertEquals(3, storage.size());
    }

    @Test(expected = NotExistStorageException.class)
    public void getNotExists() {
        storage.get("not_exist");
    }

    @Test(expected = Test.None.class)
    public void update() {
        storage.update(new Resume(UUID_3, ""));
    }
    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() {
        storage.update(new Resume("blablabla"));
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        Assert.assertEquals(new Resume(UUID_4, FULL_NAME_4), storage.get(UUID_4));
    }
    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1, FULL_NAME_1));
    }

    @Test(expected = NotExistStorageException.class)
    public void delete() {
        storage.delete(UUID_1);
        storage.get(UUID_1);
    }
    @Test(expected = NotExistStorageException.class)
    public void deleteNotExist() {
        storage.delete(UUID_4);
    }

}