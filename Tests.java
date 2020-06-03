package ru.geegbrains.Tests;

import ru.geegbrains.Tests.tester.annotations.AfterSuite;
import ru.geegbrains.Tests.tester.annotations.BeforeSuite;
import ru.geegbrains.Tests.tester.annotations.Test;

public class Tests {

    @BeforeSuite
    public void go(){
        System.out.println("We are going");
    }
    @Test(priority = Test.Priority.ONE)
      public void test1(){
        System.out.println("1");
    }
    @Test(priority = Test.Priority.TWO)
    public void test2(){
        System.out.println("2");
    }
    @Test(priority = Test.Priority.SIX)
    public void test3(){
        System.out.println("6");
    }

    @Test(priority = Test.Priority.FOUR)
    public void test4(){
        System.out.println("4");
    }

    @AfterSuite
    public void finish(){
        System.out.println("This is the END..... SKYFAAAAALL");
    }

}
