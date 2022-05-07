package com.example.resttemplate;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Stream;

@RestController
public class Controller {

    @GetMapping("/hello")
    public Object hello()
    {
        HashMap hashMap = new HashMap<>();
        hashMap.put(1,"hello");
        hashMap.put(2,"hello2");
        hashMap.put(3,"hello3");
        return hashMap;
    }

    @GetMapping("/hashmap")
    public Object hashmap()
    {
        HashMap hashMap1 = new HashMap();
        hashMap1.put(1,"hello");
        hashMap1.put(2,"hello2");
        hashMap1.put(3,"hello3");
        hashMap1.put(4,"hello4");

        HashMap hashMap2 = new HashMap();
        hashMap2.put(1,"hello");
        hashMap2.put(2,"hello2");
        hashMap2.put(3,"hello3");
        hashMap2.put(4,"hello4");

        ArrayList<HashMap> arrayList = new ArrayList<>();
        arrayList.add(hashMap1);
        arrayList.add(hashMap2);
        return arrayList;
    }

    @GetMapping("/person")
    public ArrayList<Person> person()
    {
        Person person = new Person(1,"이범기",26,"남성");
        Person person1 = new Person(2,"김민성",26,"남성");
        ArrayList<Person> people = new ArrayList<>();
        people.add(person);
        people.add(person1);
        return people;
    }


    @GetMapping("/filter")
    public Object filter()
    {
        Person person0 = new Person(0,"이범기",26,"남성");
        Person person1 = new Person(1,"김민성",21,"남성");
        Person person2 = new Person(2,"최성현",23,"남성");
        Person person3 = new Person(3,"이남성",23,"남성");
        Person person4 = new Person(4,"이민남",22,"남성");
        Person person5 = new Person(5,"김민순",22,"여성");
        Person person6 = new Person(6,"김남남",21,"남성");
        Person person7 = new Person(7,"김김여",24,"여성");

        ArrayList<Person> people = new ArrayList<>();
        people.add(person0);
        people.add(person1);
        people.add(person2);
        people.add(person3);
        people.add(person4);
        people.add(person5);
        people.add(person6);
        people.add(person7);

        Person[] arr= new Person[]{person0,person1,person3,person4,person5,person6,person7};        ///person0 ~ person7 까지 arr추가
        Stream<Person> stream = Arrays.stream(arr);                                                 ///Stream에 배열을 추가
        Stream<Person> streamOfArrayPart=Arrays.stream(arr,1,3);

        Stream<Person> stream1 = people.stream().filter(name->name.getName().contains("성"));        //성
        return stream1;
    }

//
//    @GetMapping("/filtertest")
//    public Object filtertest()
//    {
//        String[] arr = new String[]{"이범기","김민성"};
//
//    }



}



class Person {
    private int id;
    private String name;
    private int age;
    private String gender;

    public Person(int id, String name, int age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}