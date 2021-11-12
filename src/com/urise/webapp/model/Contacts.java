package com.urise.webapp.model;

import java.lang.reflect.Type;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class Contacts {

    EnumMap<ContactType, String> contacts;

    public Contacts(EnumMap<ContactType, String> contacts) {
        this.contacts = contacts;
    }

    public EnumMap<ContactType, String> getContacts() {
        return contacts;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "contacts=" + contacts +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contacts contacts1 = (Contacts) o;

        return contacts.equals(contacts1.contacts);
    }

    @Override
    public int hashCode() {
        return contacts.hashCode();
    }
}
