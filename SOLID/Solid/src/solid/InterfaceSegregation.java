package solid;

interface Workable {
    void work();
}

interface Eatable {
    void eat();
}

class HumanWorker implements Workable, Eatable {
    @Override
    public void work() {
        System.out.println("Humano trabajando");
    }

    @Override
    public void eat() {
        System.out.println("Humano comiendo");
    }
}

class RobotWorker implements Workable {
    @Override
    public void work() {
        System.out.println("Robot trabajando");
    }
}

public class InterfaceSegregation {
    public static void main(String[] args) {
        HumanWorker humanWorker = new HumanWorker();
        RobotWorker robotWorker = new RobotWorker();

        humanWorker.work();
        humanWorker.eat();

        robotWorker.work();
    }
}
