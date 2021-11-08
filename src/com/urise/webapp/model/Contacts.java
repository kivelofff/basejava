package com.urise.webapp.model;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Contacts extends MapSection<Contacts.CONTACT_TYPE>{

    public Contacts(Map<CONTACT_TYPE, String> info) {
        super(info, SectionType.CONTACTS);
    }

    public Contacts() {
        super(SectionType.CONTACTS);
    }

    public enum CONTACT_TYPE {
        PHONE,
        SKYPE,
        EMAIL,
        LINKEDIN,
        GITHUB,
        STACKOVERFLOW,
        HOMEPAGE
    }


}
