// Name:		   Brooke Alfred
// Class:	   CS 3305/Section#02
// Term:		   Fall 2025
// Instructor:    Professor Bradley
// Assignment:    1
// IDE Name:	   <IntelliJ>

public class Rectangle {
    //setting default parameters
    private double width= 1.00;
    private double height= 1.00;

    public Rectangle ( ){
    }

    //overloaded constructor for user input
    public Rectangle( double newWidth, double newHeight){
        width=newWidth;
        height=newHeight;
    }

    // getters
    //returning width
    public double getWidth(){

        return width;
    }

    //returning height
    public double getHeight(){

        return height;
    }

    //returning the area formula
    public double getArea(){

        return width*height;
    }

    //returning the perimeter formula
    public double getPerimeter(){

        return (2*width) + (2*height);
    }

    //print function, using getters to display private information
    public String printRectangle(String objectName){
        return "Rectangle " + objectName + " is " + getWidth() + " units wide and " + getHeight() + " units high. ";

    }


}
