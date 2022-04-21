package com.company;

import com.company.entity.TestEntity;
import com.company.service.TestFuntionalService;
import com.company.service.TestService;
import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<TestEntity> testEntities = new ArrayList<>();
        testEntities.add(new TestEntity("name", "1234"));
        testEntities.add(new TestEntity("emna", "12345"));
        testEntities.add(new TestEntity("aemm", "123456"));
        testEntities.add(new TestEntity("eman", "1234567"));
        testEntities.add(new TestEntity("nmae", "12345678"));
        System.out.println("");
        List<String> testEntityList = testEntities.parallelStream()
                .filter(testEntity -> testEntity.getPassword().length()==4)
                .sorted(comparing(TestEntity::getName))
                .map(TestEntity::getName)
                .collect(toList());

        testEntityList.stream().forEach(s -> {
            System.out.println(s);
        });
    }

}
