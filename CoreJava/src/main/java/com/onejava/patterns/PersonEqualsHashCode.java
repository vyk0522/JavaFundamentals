package com.onejava.patterns;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
If object1 and object2 are equal according to their equals() method, they must also have the same hash code.
If object1 and object2 have the same hash code, they do NOT have to be equal too.

If equal, then same hash codes too.
Same hash codes no guarantee of being equal.

 */
public class PersonEqualsHashCode {
    public static void main(String[] args) {
        User u1 = new User("Vivek", 22);
        User u2 = new User("Vivek", 22);
        User u3 = new User("Vivek", 22);
        System.out.println(u1.equals(u2)); // It is true when we just override equals()

        Set<User> users = new HashSet<>();
        users.add(u1);
        users.add(u2);
        System.out.println(users.size()); // 1 but 2 When we don't override hashCode()
        System.out.println(users.size()); // 1 but 2 When we don't override equals()


        Person p1 = new Person("A", 1, "AA", true);
        Person p2 = new Person("A", 1, "AA", true);
        Map<Person, String> map =  new HashMap<>();
        map.put(p1, p1.getName());
        map.put(p2, p2.getName());
        Object employeeObj = p1;

        System.out.println(map.size());   // 1 but 2 when we make equals(person) As it invokes equals taking object method
        System.out.println(p1.equals(p2)); // true, true as it invokes equals taking person method
        System.out.println(p2.equals(employeeObj)); // true, false as it invokes equals taking object method

    }

}

@AllArgsConstructor
@EqualsAndHashCode
class User{
    private String name;
    private int age;
}



@AllArgsConstructor
@Getter
class Person{
    String name;
    int age;
    String address;
    boolean status;

    public boolean equals(Person obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Person person = (Person) obj;

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