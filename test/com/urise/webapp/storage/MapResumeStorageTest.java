package com.urise.webapp.storage;

import static org.junit.Assert.*;

public class MapResumeStorageTest extends MapUuidStorageTest{
    @Override
    public void initStorage() {
        this.storage = new MapResumeStorage();
    }
}