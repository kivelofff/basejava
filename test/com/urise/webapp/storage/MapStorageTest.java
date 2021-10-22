package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;
import org.junit.Assert;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest{

    @Override
    public void initStorage() {
        this.storage = new MapStorage(new HashMap<>());
    }

    @Override
    public void getAll() {
        assertEquals(storage.get(UUID_1), new Resume(UUID_1));
        assertEquals(storage.get(UUID_2), new Resume(UUID_2));
        assertEquals(storage.get(UUID_3), new Resume(UUID_3));
    }
}