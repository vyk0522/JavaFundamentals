package com.onejava.patterns;

/*
If object1 and object2 are equal according to their equals() method, they must also have the same hash code.
If object1 and object2 have the same hash code, they do NOT have to be equal too.

If equal, then same hash codes too.
Same hash codes no guarantee of being equal.

 */
public class PersonEqualsHashCode {
    String name;
    int age;
    String address;
    boolean status;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        PersonEqualsHashCode person = (PersonEqualsHashCode) obj;

        if (age != person.age) return false;
        if (status != person.status) return false;
        if (!name.equals(person.name)) return false;
        return address.equals(person.address);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + age;
        result = 31 * result + address.hashCode();
        result = 31 * result + (status ? 1 : 0);
        return result;
    }
}