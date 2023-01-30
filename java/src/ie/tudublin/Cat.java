package ie.tudublin;

public class Cat {

    private int numLives;
    String name;

    public Cat(String name)
    {
        numLives = 9;
        this.name = name;
    }

    public void Kill()
    {
        if (numLives > 0 )
        {
            numLives = numLives - 1;
            System.out.println("Ouch!");
        }
        else 
        {
            System.out.println("Dead!");
        }
    }

    public int getLives ()
    {
        return numLives;
    }
    
}
