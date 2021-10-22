package com.urise.webapp.storage;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class ListStorageTest extends AbstractStorageTest{

    @Override
    public void initStorage() {
        this.storage = new ListStorage(new ArrayList<>());
    }
}