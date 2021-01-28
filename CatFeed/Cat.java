public class Cat extends Animal {

    float appetite = 0;
    boolean satiety = false;

    public Cat(String name, float appetite){
        super(name);
        this.appetite = appetite;
        max_height = 2;
        max_length_run = 200;
    }

    public void Swim(float length){
        System.out.println(name + " can't swim. It's a cat");
    }

    public void Eat(Plate plate){
        if( plate.emptyPlate(this.appetite)){
            this.satiety = true;
        }
    }

    public boolean getSatiety(){
        return this.satiety;
    }

}

