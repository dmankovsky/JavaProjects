package com.company;

public class ClassTester {
    public static void main(String[] args) {
        // NESTED CLASSES - defined inside the body of another class
        // outer class (enclosing class): a class that is not nested, but maybe has a nested class as a member
        // outer class can be public or package-private

        // 4 types of nested classes:
        // 1. static
        // 2. non-static (inner)
        // 3. local (non-static, defined inside a method)
        // 4. anonymous (local inner class without a name)

        //static field
        System.out.println(OuterClass.staticField);

        //non-static field(instance-level)
        OuterClass outerClass = new OuterClass();
        //instance field
        System.out.println(outerClass.instanceField);
        //play with staticField to prove there is only one variable shared among all outer class objects

        OuterClass outerClass2 = new OuterClass();
        outerClass.staticField++;
        System.out.println(outerClass.staticField);
        outerClass2.staticField++;
        System.out.println(outerClass2.staticField);

        // play with instance fields
        outerClass.instanceField++;
        System.out.println(outerClass.instanceField);
        outerClass2.instanceField++;
        System.out.println(outerClass2.instanceField);

        OuterClass.StaticNestedClass staticNestedClass = new OuterClass.StaticNestedClass();

        // for inner class an instance of Outer class is needed:

        OuterClass.InnerClass innerClass = outerClass.new InnerClass();

        outerClass.instanceMethod();

    }
}
