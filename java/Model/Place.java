package Model;

/**
 * created by ariadiki on 06/02/2022
 **/
public class Place {
    int rate,image,name;

    public Place(int name, int image) {
        this.name = name;
        this.rate = 0;
        this.image = image;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void increment()
    {
        if(this.rate < 10)
            this.rate++;
    }

    public void initial()
    {
        this.rate = 0;
    }

}
