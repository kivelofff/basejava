package com.urise.webapp.storage;

import java.util.HashMap;

import static org.junit.Assert.*;

public class MapStorageTest extends AbstractStorageTest{

    @Override
    public void initStorage() {
        this.storage = new MapStorage(new HashMap<>());
    }
}