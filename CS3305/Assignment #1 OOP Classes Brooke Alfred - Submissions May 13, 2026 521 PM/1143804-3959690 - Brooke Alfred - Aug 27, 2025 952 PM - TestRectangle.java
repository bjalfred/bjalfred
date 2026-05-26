import java.util.Scanner;

public class TestRectangle {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);

        Rectangle myRectangle = new Rectangle(); // creating default rectangle

        System.out.println("Lets create a rectangle!");

        // user inputs
        System.out.println("Enter your width: ");
        double width= scanner.nextDouble();

        System.out.println("Enter your height: ");
        double height= scanner.nextDouble();

        //creating user rectangle
        Rectangle yourRectangle = new Rectangle(width,height);

        //printing out default ans user rectangles
        System.out.println("myRectangle: ");
        System.out.println("------------");
        System.out.println("Width:\t\t" + myRectangle.getWidth());
        System.out.println("Height:\t\t" + myRectangle.getHeight());
        System.out.println("Area:\t\t" + myRectangle.getArea());
        System.out.println("Perimeter:\t" + myRectangle.getPerimeter());
        System.out.println(myRectangle.printRectangle("myRectangle"));

        System.out.println("yourRectangle: ");
        System.out.println("------------");
        System.out.println("Width:\t\t" + yourRectangle.getWidth());
        System.out.println("Height:\t\t" + yourRectangle.getHeight());
        System.out.println("Area:\t\t" + yourRectangle.getArea());
        System.out.println("Perimeter:\t" + yourRectangle.getPerimeter());
        System.out.println(yourRectangle.printRectangle("yourRectangle"));




    }
}