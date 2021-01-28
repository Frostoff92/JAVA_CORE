public class Plate {

    protected float volume = 0;
    protected float food_volume = 0;

    public Plate(float volume){
        this.volume = volume;
    }

    public void fillPlate(float additional_food){
        float resulting_food = additional_food + this.food_volume;
        if (resulting_food > this.volume){
            this.food_volume = this.volume;
        }
        else{
            this.food_volume = resulting_food;
        }
    }

    public boolean emptyPlate(float food){
        float resulting_food = this.food_volume - food;
        boolean result = false;
        if (resulting_food >= 0){
            this.food_volume = resulting_food;
            result = true;
        }
        /* if (resulting_food == 0){
            System.out.println("Food is over. Let's fill the plate");
            this.food_volume = volume;
        } */
        return result;
    }

    public float getFood(){
        return this.food_volume;
    }

    public float getVolume(){
        return this.volume;
    }


}
