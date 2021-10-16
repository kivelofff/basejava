package com.urise.webapp.storage;

import static org.junit.Assert.*;

public class SortedArrayStorageTest extends AbstractArrayStorageTest{

    @Override
    public void initStorage() {
        storage = new SortedArrayStorage();
    }
}