package service;

public class IllegalAliveException extends IllegalStateException {
    public static String DEFAULT_MESSAGE = "Нельзя покормить мертвое животное!";
    public static String DEFAULT_MESSAGE_FOR_BIRTH = "Нельзя создать животное с отрицательной массой!";
    public static String DEFAULT_MESSAGE_FOR_ANIMAL_KILL = "Нельзя убить мертвое!";


    public IllegalAliveException(String message) {
        super(message);
    }

    public IllegalAliveException() {
        super(DEFAULT_MESSAGE );
    }
}
