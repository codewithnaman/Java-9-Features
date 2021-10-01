# Java 9 Features and Examples


### Feature 0 - _ variable name
From Java 9 onwards _ is a keyword now, and you can't use as variable now i.e. below is program will give you 
compilation error.
```java
public class VariableName {
    public static void main(String[] args) {
        int _ = 9; // java: as of release 9, '_' is a keyword, and may not be used as an identifier
    }
}
```
So, we can't write any variable name like _; and we shouldn't do that too from point of readability of code. But now 
that is also restricted from compiler. But still you can use __ as variable name like below example:
```java
public class VariableName {
    public static void main(String[] args) {
        int __ = 9;
        System.out.println(__);
    }
}
```
Still above code is not recommended best practice; as it make it your code hard to read.

### Feature 1 - Interface and private methods
[With Java 8, We started writing the implementation in interfaces using default and static method.](https://github.com/codewithnaman/Java-8-Features#feature-4---default-method-in-interfaces)
But we can't use private, protected and default access modifier with Java 8 in default and static method. With Java 9, 
we can use the private access modifier with default and static method.

Now Let's understand the reason why Java 9 introduced private access to default and static methods. The place where we 
can use private default or static method is a piece of code we want to use by multiple places; and don't want to expose
this piece of code to modify, then we can create private default or static method. By Creating a default private method,
we can call that method from multiple places within interface, without exposing code to child concrete class. Let's see
and example for this:
```java
public interface FindSystemInformation {

    default int numbersOfThreadsAvailable(){
        return numberOfCoresSystemHave();
    }

    default long totalMemory(){
        return getRuntime().totalMemory()/(1024*1024);
    }

    private int numberOfCoresSystemHave(){
        return getRuntime().availableProcessors();
    }

    private static Runtime getRuntime(){
        return Runtime.getRuntime();
    }

}

public class MySystemInformation implements FindSystemInformation {
    public static void main(String[] args) {
        MySystemInformation mySystemInformation = new MySystemInformation();
        //Number Of CPU are : 8
        System.out.println("Number Of CPU are : " + mySystemInformation.numbersOfThreadsAvailable());
        //Total JVM Memory is : 260
        System.out.println("Total JVM Memory is : "+ mySystemInformation.totalMemory());
    }
}
```
In above code we have used the getRuntime from multiple places, and it is not available for modifying the implementing 
class.

### Feature 2 - Try with resource improvement
With Java 7 we got new feature known as try with resources or Automatic Resource Management(ARM). Let's revise what
that feature was, and then we will see what improvement we got on this with Java 9.