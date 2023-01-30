package ie.tudublin;

public class Main
{

	public static void helloProcessing()
	{
		String[] a = {"MAIN"};
        processing.core.PApplet.runSketch( a, new HelloProcessing());
    }
	
	public static void main(String[] args)
	{
		System.out.println("Hello world");

		Cat ginger = new Cat("Ginger");

		while (ginger.getLives() > 1)
		{
			ginger.Kill();
		}
		
		Dog penny = new Dog();
		penny.setName("Penny");
		penny.speak();
	}
	
}