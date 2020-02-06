package ua.training.flyweight;

import java.util.*;
import java.util.List;

public class FlyweightApp {
    public static void main(String[] args) {
        ShapeFactory shapeFactory = new ShapeFactory();
        List<Shape> shapeList = new ArrayList<>();
        shapeList.add(shapeFactory.getShape("point"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("square"));
        shapeList.add(shapeFactory.getShape("point"));
        shapeList.add(shapeFactory.getShape("circle"));
        shapeList.add(shapeFactory.getShape("square"));

        Random random = new Random();
        for (Shape s:shapeList) {
            int x = random.nextInt();
            int y = random.nextInt();
            s.draw(x,y);
        }


    }
}

interface Shape{
    void draw(int x, int y);
}

class Point implements Shape{
    @Override
    public void draw(int x, int y) {
        System.out.println("Draw a point with coordinates " + x + ", " + y);
    }
}

class Circle implements Shape{
    int r = 5;
    @Override
    public void draw(int x, int y) {
        System.out.println("Draw a circle with radius " + r + " and center in coordinates "
                + x + ", " + y);
    }
}

class Square implements Shape{
    int a = 10;

    @Override
    public void draw(int x, int y) {
        System.out.println("Draw a square with side " + a + " and center in coordinates "
                + x + ", " + y);
    }
}

class ShapeFactory {
    private static final Map<String, Shape> shapes = new HashMap<>();
    public Shape getShape(String shapeName) {

        Shape shape = shapes.get(shapeName);

        if(shape == null){
            switch (shapeName){
                case "square":
                    shape = new Square();
                    break;
                case "circle":
                    shape = new Circle();
                    break;
                case "point":
                    shape = new Point();
                    break;
            }
            shapes.put(shapeName, shape);
        }
        return shape;
    }
}
