package ua.com.igorka.oa.android.h2_fruitstore.entity;

/**
 * Created by igor9_000 on 17.02.2015.
 */
public class FruitFactory {

    public static final String APPLE = "Apple";
    public static final String CHERRY = "Cherry";
    private static final int APPLE_PRICE = 10;
    private static final int CHERRY_PRICE = 15;

    public static IFruit makeFruit(String fruit) {
        switch (fruit) {
            case APPLE:
                return new Apple(APPLE, APPLE_PRICE);
            case CHERRY:
                return new Cherry(CHERRY, CHERRY_PRICE);
        }
        throw new IllegalArgumentException();
    }
}
