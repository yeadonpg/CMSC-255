/*
  THIS IS A PRE-MADE EXAMPLE OF A BASIC FILE READER / WRITER; PROVIDED BY THE LAB INSTRUCTOR
  */

package Labs.Lab_13;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.NumberFormatException;

/***********************************************************************************
 This program reads a file whose lines contain items and prices separated by tabs,
 like this:
 item name 1     price 1
 item name 2     price 2
 ...

 The program writes a file in which the items are left-aligned
 and the prices are right-aligned. The last line has the total
 of the prices.
 ************************************************************************************/
@SuppressWarnings("DanglingJavadoc")
public class ItemsLineByLine
{
    public static void main(String[] args) throws FileNotFoundException
    {

        /********************************************************************************
         * Prompt for the input and output file names
         * ****************************************************************************/
        Scanner console = new Scanner(System.in);
        System.out.print("Input file: ");
        String inputFileName = console.next();
        System.out.print("Output file: ");
        String outputFileName = console.next();

        /********************************************************************************
         * Construct the Scanner and PrintWriter objects for reading and writing
         * ****************************************************************************/
        File inputFile = new File(inputFileName);
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter(outputFileName);

        /********************************************************************************
         * Read the input and write the output
         * ****************************************************************************/
        double total = 0;

        /********************************************************************************
         * We read each item separated by a tab.  This allows us to have spaces in the item names
         * ****************************************************************************/
        in.nextLine();

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String[] tokens = line.split(",");
            double price = 0;

            String item = tokens[0];
            try{
                price = Double.parseDouble(tokens[1]);
            }
            catch (NumberFormatException e){
                System.out.println("Bad data: " + tokens[0] + " " + tokens[1]);
            }

            total = total + price;

            /********************************************************************************
             * We output the item and price
             * ****************************************************************************/
            out.printf("%-20s%10.2f%n", item, price);

        }

        /********************************************************************************
         * We output the total price
         * ****************************************************************************/
        out.printf("%-20s%10.2f%n", "Total:", total);

        in.close();
        out.close();
    }
}