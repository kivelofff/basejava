package com.urise.webapp.storage;

import com.urise.webapp.exception.ExistStorageException;
import com.urise.webapp.exception.NotExistStorageException;
import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public abstract class AbstractArrayStorageTest {
    protected Storage storage;
    private static final String UUID_1="uuid1";
    private static final String UUID_2="uuid2";
    private static final String UUID_3="uuid3";
    private static final String UUID_4="uuid4";

    public abstract void initStorage();

    @Before
    public void setUp() throws Exception {
        if (storage == null) {
            initStorage();
        }
        storage.clear();
        storage.save(new Resume(UUID_1));
        storage.save(new Resume(UUID_2));
        storage.save(new Resume(UUID_3));
    }

    @Test
    public void clear() {
        storage.clear();
        Assert.assertEquals(0, storage.size());
    }

    @Test
    public void get() {
        Assert.assertEquals(new Resume(UUID_1), storage.get(UUID_1));
    }

    @Test
    public void getAll() {
        Assert.assertEquals(new Resume[]{new Resume(UUID_1), new Resume(UUID_2), new Resume(UUID_3)}, storage.getAll());
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
        storage.update(new Resume(UUID_3));
    }
    @Test(expected = NotExistStorageException.class)
    public void updateNotExists() {
        storage.update(new Resume("blablabla"));
    }

    @Test
    public void save() {
        storage.save(new Resume(UUID_4));
        Assert.assertEquals(new Resume(UUID_4), storage.get(UUID_4));
    }
    @Test(expected = ExistStorageException.class)
    public void saveExist() {
        storage.save(new Resume(UUID_1));
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

    @Test(expected = StorageException.class)
    public void overflow() {
        storage.clear();
        try {
            for (int i = 0; i < AbstractArrayStorage.LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (Exception e) {
            System.out.println(storage.size());
            Assert.fail();
        }
        storage.save(new Resume());
    }
}