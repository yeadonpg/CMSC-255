package Homework;

/**
 * (The Rectangle class)
 *
 * Following the example of the Circle class in Section 9.2, design a class named Rectangle to represent a rectangle.
 *
 * The class contains:
 *
 * - Two double data fields named width and height that specify the width and height of the rectangle.
 * The default values are 1 for both width and height.
 *
 * - A no-arg constructor that creates a default rectangle.
 *
 * - A constructor that creates a rectangle with the specified width and height.
 *
 * - A method named getArea() that returns the area of this rectangle.
 *
 * - A method named getPerimeter() that returns the perimeter.
 *
 *
 * Draw the UML diagram for the class and then implement the class.
 *
 * Write a test program that creates two Rectangle objects—one with width 4 and height 40 and the other
 * with width 3.5 and height 35.9.
 *
 * Display the width, height, area, and perimeter of each rectangle in this order.
 * **/
public class Exercise09_01 {

    public static class Rectangle {
        private double width = 0;
        private double height = 0;

        public Rectangle() {}

        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }

        public double getArea() {
            return this.width * this.height;
        }

        public double getPerimeter() {
            return 2 * (this.width + this.height);
        }

        public String toString() {
            String s1 = "The area of a rectangle with width " + this.width + " and";
            String s2 =  this.height + " is " + this.getArea();
            String s3 = "\nThe perimeter of a rectangle is " + this.getPerimeter();
            return s1 + " " + s2 + " " + s3;
        }
    }

    public static void main(String[] args) {
        Rectangle rect1 = new Rectangle(4, 40);
        Rectangle rect2 = new Rectangle(3.5, 35.9);

        System.out.println(rect1.toString());
        System.out.println(rect2.toString());
    }
}
