package com.company.streamPrec.service;

import com.company.streamPrec.entity.Trader;
import com.company.streamPrec.entity.Transaction;

import java.util.Arrays;
import static java.util.Comparator.comparing;
import java.util.List;
import java.util.Optional;
import static java.util.stream.Collectors.toList;

public class TestService {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactionList = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        //1번 문제
        System.out.println("----------------1번 문제 -------------------");
        System.out.println("1번 문제 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리");
        test1(transactionList);
        //2번 문제
        System.out.println("----------------2번 문제 -------------------");
        System.out.println("2번 문제 거래자가 근무하는 모든 도시를 중복 없이 나열");
        test2(transactionList);
        //3번 문제
        System.out.println("----------------3번 문제 -------------------");
        System.out.println("3번 문제 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하세요");
        test3(transactionList);

    }
    // 1번 문제 2011년에 일어난 모든 트랜잭션을 찾아 오름차순으로 정리
    public static void test1(List<Transaction> transactions){
        List<Transaction> transactionList
                = transactions.parallelStream()
                .filter(transaction -> transaction.getYear() ==2011)
                .sorted(comparing(Transaction :: getValue))
                .collect(toList());


        transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
    }

    // 2번 문제 거래자가 근무하는 모든 도시를 중복 없이 나열
    public static void test2(List<Transaction> transactions){
        List<String> transactionList
                = transactions.parallelStream()
                .map(transaction -> transaction.getTrader().getCity() )
                .distinct()
                .collect(toList());

        transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
    }
    // 3번 문제 케임브리지에서 근무하는 모든 거래자를 찾아서 이름순으로 정렬하세요
    public static void test3(List<Transaction> transactions){
        List<String> transactionList
                = transactions.parallelStream()
                        .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                        .sorted(comparing(transaction -> transaction.getTrader().getName()))
                        .map(transaction -> transaction.getTrader().getName())
                        .collect(toList());

        transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
    }
    // 4번 문제 모든 거래자의 이름을 알파벳순으로 정렬해서 반환하시오.
    public static void test4(List<Transaction> transactions){
        List<String> transactionList
                = transactions.parallelStream()
                .map(transaction -> transaction.getTrader().getName() )
                .sorted(comparing(o -> o.toString())).collect(toList());

        transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
    }
    // 5번 문제 밀라노에 거래자가 있는지?
    public static void test5(List<Transaction> transactions){
        boolean transactionList
                = transactions.parallelStream().anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(transactionList);
    }
    // 6번 문제 케임브리지에 거주하는 거래자의 모든 트랜잭션값을 출려하세요
    public static void test6(List<Transaction> transactions){
        List<Transaction> transactionList
                = transactions.parallelStream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .collect(toList());

        transactionList.forEach(transaction -> {
            System.out.println(transaction.toString());
        });
    }
    // 7번 전체 트랜잭션 중 최댓값은 얼마인가?
    public static void test7(List<Transaction> transactions){
        Optional<Transaction> max
                = transactions.parallelStream()
                .reduce((integer, integer2) -> integer.getValue() < integer2.getValue() ?  integer : integer2);

        System.out.println(max.get().toString());
    }
    // 8번 전체 트랜잭션 중 최솟값은 얼마인가?
    public static void test8(List<Transaction> transactions){
        Optional<Transaction> min
                = transactions.parallelStream()
                .reduce((integer, integer2) -> integer.getValue() < integer2.getValue() ?  integer2 : integer);

        System.out.println(min.get().toString());

    }

}
