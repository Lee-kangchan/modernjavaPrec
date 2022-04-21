package com.company.service;

public interface TestService {
    /**
     * 자바 8 문법
     * default를 붙이면 생략 불가능
     *
     * */
    public int add(int a, int b);
    default int del(int a, int b){ return a-b;}

}
