import java.io.*;

public class Rectangle implements Serializable {

    private double height;
    private double width;

    public Rectangle(double height, double width)
    {
        this.height = height;
        this.width = width;
    }

    public double Area()
    {
        return height * width;
    }

    public double Perimeter()
    {
        return 2 * (height + width);
    }

}