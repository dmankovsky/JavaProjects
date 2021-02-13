package com.company;

public class OuterClass {
    // fields

    static int staticField = 0; // static, class level... one staticField variable shared among all instances of OuterClass
    int instanceField; // non-static, instance-level... each instance of OuterClass gets its own instanceField

    public OuterClass() {
        instanceField = 1;
        System.out.println("Hello from OuterClass constructor!");
    }

    // 1. Static nested class

    public static class StaticNestedClass{
        // nested classes are members of the enclosing class
        // static nested classes can access static members (fields and methods) of the enclosing class
        // static nested classes ARE NOT ASSOCIATED WITH AN INSTANCE OF THE ENCLOSING CLASS
        // no this reference for StaticNestedClass and no this reference for OuterClass

        // contructor

        public StaticNestedClass() {
            System.out.println("Hello from the static nested class constructor!");
            System.out.println(staticField);
        }
    }

    // 2. Inner class (non-static)

    public class InnerClass {
        // inner classes ARE ASSOCIATED WITH AN INSTANCE OF THE ENCLOSING CLASS
        // inner classes can access static and non-static members of the enclosing class

        // instance level field
        int instanceField;

        // constructor
        public InnerClass(){
            instanceField = 100;
            System.out.println("Hello from the InnerClass constructor!");
            System.out.println("static field: " + staticField);
            System.out.println("instance field>" + this.instanceField);
            // this refers to this instance of InnerClass
            // OuterClass.this refers to this instance of OuterClass that this instance of InnerClass belongs to or is member of
            System.out.println("OuterClass' instanceField: " + OuterClass.this.instanceField);
        }
    }

    // 3. Local classes
    // need a method
    // 4. Anonymous classes
    // also need a method. The following used for both
    public void instanceMethod(){
        int localVariable = 500;

        //localVariable = 900 - this would break the code, since the var is not final or effectively final

        // 3. local class
        class LocalClass { //can also say public here
            // constructor
            public LocalClass(){
                System.out.println("Hello from the LocalClass constructor!");
                System.out.println("localVariable: " + localVariable);
                // can access both static and instance members of enclosing class:
                System.out.println("instance field: " + instanceField);
            }
        }

        // instantiate a LocalClass object (otherwise constructor above remains uncallable
        LocalClass localClass = new LocalClass();

        // local classes can access the local variables of the enclosing method
        // only if the local variables are final or "effectively final"
        // final means constant: final int localVariable = 500;
        // effectively final - you define a var once, and do not reassign it in what follows

        // 4. Anonymous class
        // does not have a name
        // use case: if there is just one spot in the code, where the class is used e.g. implement an interface, or subclass is a simple type
        // essentially, like a lambda for classes?
        // Example: we need a name of interface to implement or a class to extend in order to create an anonymous class
        // ... every class inherits directly or indirectly from Object. If we want to make a new generic class, the name we would use in place of its name would be
        // the name of its superclass - Object. But we are not going to name this new subclass of Object we are creating
        // let's extent object:
        Object myAnonymousClassObject = new Object() // nothing new here; but now I want to add some custom functionality to the Object subclass
                // can do it the long way: new class ... inherits/extends Object  - or just use anonymous class:
        {
            // override methods (ctrl + O to see the available methods; so its a full-blown class, just not referrable by name later in the code)
            @Override
            public String toString() {
                return "Hello!";
            }
        };
        System.out.println(myAnonymousClassObject); // this will implicitly invoke toString method on the type of the anonymous class that inherits from Object
    }

    // Local classes are used for event listeners and event-driven programming e.g. callbacks in GUIs: if someone presses a button in GUI, you want to invoke a method
}
