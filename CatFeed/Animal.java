public abstract class Animal {

    protected String name;
    protected float max_height = 0;
    protected float max_length_run = 0;
    protected float max_length_swim = 0;

    public Animal(){
        name = "Jane Doe";
    }

    public Animal(String name){
        this.name = name;
    }

    public void Jump(float height){
        System.out.println((height >= max_height) ? name + " can't" : name + " jumped " + height);
    }

    public void Run(float length){
        System.out.println((length >= max_length_run) ? name + " can't, too far" : name +
                " ran " + length);
    }

    public void Swim(float length) {
        System.out.println((length >= max_length_swim) ? name + " can't, too far" : name + " swam " +
                length);
    }

    // Геттеры и сеттеры для всех полей

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void setMax_length_run(float max_length_run){
        this.max_length_run = max_length_run;
    }

    public void setMax_length_swim(float max_length_swim){
        this.max_length_swim = max_length_swim;
    }

    public void setMax_height(float max_height){ this.max_height = max_height; }

    public float getMax_height(){ return max_height; }

    public float getMax_length_run(){
        return max_length_run;
    }

    public float getMax_length_swim(){
        return max_length_swim;
    }

}
