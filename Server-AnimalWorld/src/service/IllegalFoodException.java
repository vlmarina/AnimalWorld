package service;

public class IllegalFoodException extends IllegalArgumentException {
    public static String DEFAULT_MESSAGE = "Нельзя покормить не своей едой!";
    public static String DEFAULT_MESSAGE_FOR_PREDATOR = "Нельзя съесть мертвое животное!";
    public static String DEFAULT_MESSAGE_FOR_HERBIVORE ="Нельзя покормить едой с нулевой массой!";

    public IllegalFoodException(String message) {
        super(message);
    }

    public IllegalFoodException() {
        super(DEFAULT_MESSAGE);
    }

}
