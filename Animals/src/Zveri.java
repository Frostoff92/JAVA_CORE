abstract class Animal {
    protected int distance;
    protected double high;

    abstract void run(int length);
    abstract void jump(double height);

    static void info(Object obj, boolean result) {
        System.out.println(obj.getClass().getName() + " : " + result);
    }
}

class Cat extends Animal {
    @Override
    void run(int length) {
        boolean result = length <= 200;
        if (result) distance = length;
        info(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 2;
        if (result) this.high = height;
        info(this,result);
    }

}

class Dog extends Animal {
    private int _lengthSwim;
    private int maxLength;

    Dog() {
        maxLength = Math.random() > 0.5 ?  400 : 600;
    }

    int getMAxLengtx() {
        return maxLength;
    }

    void swim(int length) {
        boolean result = length <= 10;
        if (result)
            this._lengthSwim = length;
        info(this,result);
    }
    @Override
    void run(int length) {
        boolean result = length <= maxLength;
        if (result)
            this.distance = length;
        info(this,result);
    }
    @Override
    void jump(double height) {
        boolean result = height <= 0.5;
        if (result)
            this.high = height;
        info(this,result);
    }
}



public class Zveri {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Animal cat = new Cat();

        cat.run(350);
        dog.run(600);

        cat.jump(2);
        dog.jump(0.5);

        dog.swim(11);
    }
}
