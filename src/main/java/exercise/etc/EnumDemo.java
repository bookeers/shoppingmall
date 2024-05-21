package exercise.etc;
enum Menu {
    americano,
    latte,
    strawberryade,
    espresso
}

public class EnumDemo {
    Menu menu;

    EnumDemo(Menu menu) {
        this.menu = menu;
    }

    public void selectMenu() {
        switch (menu) {
            case americano:
                System.out.println("아메리카노");
                break;
            case latte:
                System.out.println("라떼");
                break;
            case strawberryade:
                System.out.println("딸기에이드");
                break;
            case espresso:
                System.out.println("에스프레소");
                break;
        }
    }
}