package baekjoon.silver;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class SortByAge10814 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        Person[] list = new Person[num];
        
        for(int i=0; i<num; i++){
            list[i] = new Person(sc.nextInt(), sc.next());
        }

        Arrays.sort(list, new Comparator<Person>(){
            public int compare(Person o1, Person o2) {
                return o1.age - o2.age;
            }
        });

        for(int i=0; i<num; i++){
            System.out.println(list[i].age+" "+list[i].name);
        }
    }
    static class Person{
        int age;
        String name;
        
        public Person(int age, String name){
            this.age = age;
            this.name = name;
        }
    }
}
