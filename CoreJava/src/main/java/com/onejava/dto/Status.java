package com.onejava.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

/*
Constants must be defined first
Constructor can be private or package private
You cannot call enum type constructor directly
 */
@Getter
@AllArgsConstructor
public enum Status {
    NOT_STARTED(0){
        @Override
        public void m1() {
            //super.m1();
            System.out.println("Not Started M1");
        }
    }, IN_PROGRESS(1), UNDER_REVIEW(2), COMPLETED(3);
    private int statusValue;

    public void m1(){
        System.out.println("Common M1");
    }
}
