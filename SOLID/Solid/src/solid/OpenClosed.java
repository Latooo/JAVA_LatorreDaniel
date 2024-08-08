package solid;

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Dibujando Círculo");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Dibujando Cuadrado");
    }
}

class ShapeDrawer {
    public void drawShape(Shape shape) {
        shape.draw();
    }
}

public class OpenClosed {
    public static void main(String[] args) {
        Shape circle = new Circle();
        Shape square = new Square();

        ShapeDrawer drawer = new ShapeDrawer();
        drawer.drawShape(circle);
        drawer.drawShape(square);
    }
}
