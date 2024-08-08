package solid;

abstract class Bird {
    abstract void move();
}

class FlyingBird extends Bird {
    @Override
    void move() {
        System.out.println("Volando");
    }
}

class NonFlyingBird extends Bird {
    @Override
    void move() {
        System.out.println("Caminando");
    }
}

public class LiskovSubstitution {
    public static void main(String[] args) {
        Bird flyingBird = new FlyingBird();
        Bird nonFlyingBird = new NonFlyingBird();

        flyingBird.move();
        nonFlyingBird.move();
    }
}
