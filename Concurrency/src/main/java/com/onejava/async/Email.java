package com.onejava.async;

class Email{
    private int id;

    public Email(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Email{" +
                "id=" + id +
                '}';
    }
}
