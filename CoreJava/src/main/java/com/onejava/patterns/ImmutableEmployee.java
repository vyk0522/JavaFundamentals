package com.onejava.patterns;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class ImmutableEmployee {
    public static void main(String[] args) {
        Address address = new Address("Siri", "Mandya", "Karnataka", 1);
        Employee employee = new Employee(1, "Vivek", address);

        System.out.println("Pin code before modification = " + employee.getAddress().getPinCode());
        address.setPinCode(2);
        System.out.println("Pin code after modification = " + employee.getAddress().getPinCode());
        employee.getAddress().setPinCode(3);
        System.out.println("Pin code after modification = " + employee.getAddress().getPinCode());

    }

}

/*
A. Make class final. so it can’t be extended.
B. Make all fields private and final
C. Don't provide setters
D. If a field is a mutable object create defensive copies of it for getter methods
E. If a mutable object passed to the constructor must be assigned to a field create a defensive copy of it
 */
final class Employee{
    private final int id;
    @Getter
    private final String name;
    private final Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = copyAddress(address);
    }

    public Address getAddress() {
        return copyAddress(address);
    }

    // To create defensive copies of address
    private static Address copyAddress(Address address) {
        return new ObjectMapper().convertValue(address, Address.class);
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private String name;
    private String city;
    private String state;
    private long pinCode;
}
