package ua.training.visitor;

public class VisitorApp {
    public static void main(String[] args) {
//        Element engine = new EngineElement();
//        Element body = new BodyElement();
        Visitor hooligan = new HooliganVisitor();
//
//        engine.accept(hooligan);
//        body.accept(hooligan);

        CarElement car = new CarElement();
//        Visitor mechanic = new MechanicVisitor();
        car.accept(hooligan);
    }
}

interface Visitor {
    void visit(EngineElement engine);
    void visit (BodyElement body);
    void visit (WheelElement wheel);
    void visit(CarElement car);
}

interface Element{
    void accept(Visitor visitor);
}

class BodyElement implements Element {
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

    class EngineElement implements Element{
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

    class WheelElement implements Element{
    private String name;

        public String getName() {
            return name;
        }

        public WheelElement(String name) {
        this.name = name;
    }
        @Override
        public void accept(Visitor visitor) {
            visitor.visit(this);
        }
    }

    class CarElement implements Element {
        Element[] elements;

        public CarElement() {
            this.elements = new Element[] {
                    new WheelElement("переднее левое"), new WheelElement("переднее правое"),
                    new WheelElement("заднее левое"), new WheelElement("заднее правое"), new BodyElement(),
                    new EngineElement()};
            }

        @Override
        public void accept(Visitor visitor) {
            for (Element e:elements) {
                e.accept(visitor);
            }
            visitor.visit(this);
        }
    }

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement element) {
        System.out.println("Завел двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Постучал по корпусу");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Пнул "+ wheel.getName()+" колесо" );
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Покурил внутри машины");
    }
}


class MechanicVisitor implements Visitor {
    @Override
    public void visit(EngineElement element) {
        System.out.println("Проверил двигатель");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Отполировал кузов");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Проверил давление в шинах");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Заправил авто бензином");
    }
}


