package com.urise.webapp.storage;

import com.urise.webapp.exception.StorageException;
import com.urise.webapp.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArrayStorageTest extends AbstractStorageTest{

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
