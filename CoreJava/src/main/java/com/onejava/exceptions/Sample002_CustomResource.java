package com.onejava.exceptions;

public class Sample002_CustomResource {
    public static void main(String[] args) {
        try(Resource resource1 = new Resource("Resource 1");
            Resource resource2 = new Resource("Resource 2")){
            throw new RuntimeException();
        } catch (Exception e) {

        }
    }
}

class Resource implements AutoCloseable{
    private String name;

    public Resource(String name) {
        this.name = name;
    }

    // Here close() throws Exception. So catch block is required in TWR. If it doesn't throw exception then catch block is not required.
    @Override
    public void close() throws Exception {
        System.out.println("Closing the resource: " + name);
    }
}
