package com.urise.webapp.model;

import java.util.ArrayList;
import java.util.List;

public class OrganisationSection {
    private List<Organisation> organisations;

    public OrganisationSection() {
        organisations = new ArrayList<>();
    }

    public List<Organisation> getOrganisations() {
        return organisations;
    }

    @Override
    public String toString() {
        return "OrganisationSection{" +
                "organisations=" + organisations +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrganisationSection that = (OrganisationSection) o;

        return organisations.equals(that.organisations);
    }

    @Override
    public int hashCode() {
        return organisations.hashCode();
    }
}
