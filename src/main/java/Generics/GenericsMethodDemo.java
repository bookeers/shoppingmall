package Generics;

public class GenericsMethodDemo {
    public static void main(String[] args) {

    }
}

class GenericMethod{
    static <T> GenericClass<T> returnGenericObject(){

        return new GenericClass<T>();
    }
}

class GenericClass<T> {
    T field;
}