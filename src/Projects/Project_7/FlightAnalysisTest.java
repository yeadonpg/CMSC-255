package Projects.Project_7;

import org.junit.Rule;
import org.junit.Test;

import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class FlightAnalysisTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
        public void parseDataGoodDataTest() throws IOException {
        // Invoke method
        ArrayList<Flight> actual = FlightAnalysis.parseData(generateGivenGoodInputFile());
        // Check results
        assertEquals("When checking the ArrayList returned from the parseData method given a file with all valid input data, we",goodInputArrayList(),actual);
    }

    @Test
        public void calcBestFareGoodDataTest(){
        Flight expected = new Flight("2017","Boise, ID","Spokane, WA",106.6399809,287);
        assertEquals("When checking the ArrayList returned from the calcBestFare method given an ArrayList of good flight data, we",expected,FlightAnalysis.calcBestFare(goodInputArrayList()));
    }

    @Test
        public void removeDataGoodDataTest(){
        ArrayList<Flight> goodInput = goodInputArrayList();
        FlightAnalysis.removeData(goodInput,toRemoveArrayList());
        assertEquals("When checking the ArrayList returned from the removeData method given an ArrayList of good flight data, we",goodInputDataRemovedArrayList(),goodInput);
    }

    @Test
        public void calcBestFarePerMileGoodDataTest(){
        Flight expected = new Flight("2018","Asheville, NC","Miami, FL (Metropolitan Area)",119.6646127,677);
        assertEquals("When checking the ArrayList returned from the calcBestFarePerMile method given an ArrayList of good flight data, we",expected,FlightAnalysis.calcBestFarePerMile(goodInputArrayList()));
    }

    @Test
        public void writeOutGoodData() throws IOException {
        final String OUTPUT_FILENAME = "output.txt";
        // Create input and output files and populate input file
        File outputFile = folder.newFile(OUTPUT_FILENAME);
        // Invoke method
        FlightAnalysis.writeOutData(goodInputArrayList(), outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);
        Scanner expectedScan = new Scanner(generateExpectedGoodOutputFile());
        int i = 1;
        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an ArrayList of good data, at line " +i+ " we",expectedScan.nextLine(),outputScan.nextLine());
            i++;
        }
        outputScan.close();
        expectedScan.close();
    }

    @Test
        public void writeOutBadData() throws IOException {
        final String OUTPUT_FILENAME = "output.txt";
        // Create input and output files and populate input file
        File outputFile = folder.newFile(OUTPUT_FILENAME);
        // Invoke method
        FlightAnalysis.writeOutData(badInputArrayList(), outputFile);
        // Check results
        assertTrue("Output file does not exist", outputFile.exists());
        Scanner outputScan = new Scanner(outputFile);
        Scanner expectedScan = new Scanner(generateExpectedBadOutputFile());
        int i = 1;
        while (outputScan.hasNextLine()){
            assertEquals("When checking the output file produced by writeOutData given an ArrayList of good data, at line " +i+ " we",expectedScan.nextLine(),outputScan.nextLine());
            i++;
        }
        outputScan.close();
        expectedScan.close();
    }

    @Test
        public void parseDataBadDataTest() throws IOException {
        // Invoke method
        ArrayList<Flight> actual = FlightAnalysis.parseData(generateGivenBadInputFile());
        // Check results
        assertEquals("When checking the ArrayList returned from the parseData method given a file with some invalid input data, we",badInputArrayList(),actual);
    }

    @Test
        public void calcBestFareBadDataTest(){
        Flight expected = new Flight("2018","Charlotte, NC","St. Louis, MO",0.0,0);
        assertEquals("When checking the ArrayList returned from the calcBestFare method given an ArrayList generated from FlightBadData.txt, we",expected,FlightAnalysis.calcBestFare(badInputArrayList()));
    }

    @Test
        public void removeDataBadDataTest(){
        ArrayList<Flight> badInput = badInputArrayList();
        FlightAnalysis.removeData(badInput,toRemoveArrayList());
        assertEquals("When checking the ArrayList returned from the removeData method given an ArrayList generated from FlightBadData.txt, we",badInputDataRemovedArrayList(),badInput);
    }

    @Test
        public void calcBestFarePerMileBadDataTest(){
        Flight expected = new Flight("2018","Asheville, NC","Miami, FL (Metropolitan Area)",119.6646127,677);
        assertEquals("When checking the ArrayList returned from the calcBestFarePerMile method given an ArrayList generated from FlightBadData.txt, we",expected,FlightAnalysis.calcBestFarePerMile(badInputArrayList()));
    }




    private File generateGivenGoodInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Year;city1;city2;mkt_fare;Distance;\n" +
                "2018;Asheville, NC;Miami, FL (Metropolitan Area);119.6646127;677;\n" +
                "2018;Asheville, NC;Tampa, FL (Metropolitan Area);111.1095983;514;\n" +
                "2018;Atlanta, GA (Metropolitan Area);Cincinnati, OH;273.9105411;377;\n" +
                "2018;Atlanta, GA (Metropolitan Area);Memphis, TN;289.8798238;332;\n" +
                "2018;Boise, ID;Seattle, WA;131.3517678;399;\n" +
                "2018;Boise, ID;Spokane, WA;110.8682953;287;\n" +
                "2018;Boise, ID;Sacramento, CA;129.1509692;437;\n" +
                "2018;Boston, MA (Metropolitan Area);Buffalo, NY;130.4956899;395;\n" +
                "2018;Boston, MA (Metropolitan Area);Richmond, VA;136.4161655;474;\n" +
                "2018;Buffalo, NY;New York City, NY (Metropolitan Area);136.4699697;292;\n" +
                "2018;Charlotte, NC;St. Louis, MO;291.2241703;575;\n" +
                "2018;Charlotte, NC;Detroit, MI;264.3863046;500;\n" +
                "2018;Charlotte, NC;Tampa, FL (Metropolitan Area);290.3426771;507;\n" +
                "2018;Charlotte, NC;Memphis, TN;284.7862224;511;\n" +
                "2018;Chicago, IL;Syracuse, NY;260.6205682;607;\n" +
                "2018;Chicago, IL;Tulsa, OK;271.9742993;585;\n" +
                "2018;Chicago, IL;Cincinnati, OH;133.352732;270;\n" +
                "2018;Chicago, IL;Richmond, VA;262.2001325;642;\n" +
                "2018;Cincinnati, OH;Minneapolis/St. Paul, MN;262.9060018;334;\n" +
                "2017;Asheville, NC;Miami, FL (Metropolitan Area);128.3915332;677;\n" +
                "2017;Asheville, NC;Tampa, FL (Metropolitan Area);124.4519219;514;\n" +
                "2017;Atlanta, GA (Metropolitan Area);Cincinnati, OH;313.655394;377;\n" +
                "2017;Atlanta, GA (Metropolitan Area);Memphis, TN;274.8223261;332;\n" +
                "2017;Boise, ID;Seattle, WA;129.4190566;399;\n" +
                "2017;Boise, ID;Spokane, WA;106.6399809;287;\n" +
                "2017;Boise, ID;Sacramento, CA;129.9119902;437;\n" +
                "2017;Boston, MA (Metropolitan Area);Richmond, VA;132.355884;395;\n" +
                "2017;Boston, MA (Metropolitan Area);Buffalo, NY;132.4186695;474;\n" +
                "2017;Buffalo, NY;New York City, NY (Metropolitan Area);117.7032929;292;\n" +
                "2017;Charlotte, NC;St. Louis, MO;273.6228611;575;\n" +
                "2017;Charlotte, NC;Detroit, MI;262.8762495;500;\n" +
                "2017;Charlotte, NC;Tampa, FL (Metropolitan Area);276.6002795;507;\n" +
                "2017;Charlotte, NC;Memphis, TN;269.731107;511;\n" +
                "2017;Chicago, IL;Richmond, VA;262.4844604;607;\n" +
                "2017;Chicago, IL;Tulsa, OK;270.3571121;585;\n" +
                "2017;Chicago, IL;Syracuse, NY;290.8316435;270;\n" +
                "2017;Chicago, IL;Cincinnati, OH;124.3163743;642;\n" +
                "2017;Cincinnati, OH;Minneapolis/St. Paul, MN;306.9397207;334;\n" +
                "2016;Asheville, NC;Miami, FL (Metropolitan Area);129.2055405;677;\n" +
                "2016;Asheville, NC;Tampa, FL (Metropolitan Area);126.5900629;514;\n" +
                "2016;Atlanta, GA (Metropolitan Area);Cincinnati, OH;298.0553139;377;\n" +
                "2016;Atlanta, GA (Metropolitan Area);Memphis, TN;306.4386275;332;\n" +
                "2016;Boise, ID;Seattle, WA;128.5387179;399;\n" +
                "2016;Boise, ID;Spokane, WA;114.2404508;287;\n" +
                "2016;Boise, ID;Sacramento, CA;119.774425;437;\n" +
                "2016;Boston, MA (Metropolitan Area);Richmond, VA;136.3048831;395;\n" +
                "2016;Boston, MA (Metropolitan Area);Buffalo, NY;139.2092115;474;\n" +
                "2016;Buffalo, NY;New York City, NY (Metropolitan Area);138.6866248;292;\n" +
                "2016;Charlotte, NC;St. Louis, MO;275.0473414;575;\n" +
                "2016;Charlotte, NC;Detroit, MI;328.1736089;500;\n" +
                "2016;Charlotte, NC;Tampa, FL (Metropolitan Area);269.3827727;507;\n" +
                "2016;Charlotte, NC;Memphis, TN;261.5784123;511;\n" +
                "2016;Chicago, IL;Richmond, VA;295.4702007;607;\n" +
                "2016;Chicago, IL;Cincinnati, OH;267.2074027;585;\n" +
                "2016;Chicago, IL;Tulsa, OK;270.4238455;270;\n" +
                "2016;Chicago, IL;Syracuse, NY;270.42;642;\n" +
                "2016;Cincinnati, OH;Minneapolis/St. Paul, MN;375.9145278;334;");
        write.close();
        return inputFile;
    }

    private File generateExpectedGoodOutputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print(
                "2018 Asheville, NC Miami, FL (Metropolitan Area) 119.6646127 677\n" +
                "2018 Asheville, NC Tampa, FL (Metropolitan Area) 111.1095983 514\n" +
                "2018 Atlanta, GA (Metropolitan Area) Cincinnati, OH 273.9105411 377\n" +
                "2018 Atlanta, GA (Metropolitan Area) Memphis, TN 289.8798238 332\n" +
                "2018 Boise, ID Seattle, WA 131.3517678 399\n" +
                "2018 Boise, ID Spokane, WA 110.8682953 287\n" +
                "2018 Boise, ID Sacramento, CA 129.1509692 437\n" +
                "2018 Boston, MA (Metropolitan Area) Buffalo, NY 130.4956899 395\n" +
                "2018 Boston, MA (Metropolitan Area) Richmond, VA 136.4161655 474\n" +
                "2018 Buffalo, NY New York City, NY (Metropolitan Area) 136.4699697 292\n" +
                "2018 Charlotte, NC St. Louis, MO 291.2241703 575\n" +
                "2018 Charlotte, NC Detroit, MI 264.3863046 500\n" +
                "2018 Charlotte, NC Tampa, FL (Metropolitan Area) 290.3426771 507\n" +
                "2018 Charlotte, NC Memphis, TN 284.7862224 511\n" +
                "2018 Chicago, IL Syracuse, NY 260.6205682 607\n" +
                "2018 Chicago, IL Tulsa, OK 271.9742993 585\n" +
                "2018 Chicago, IL Cincinnati, OH 133.352732 270\n" +
                "2018 Chicago, IL Richmond, VA 262.2001325 642\n" +
                "2018 Cincinnati, OH Minneapolis/St. Paul, MN 262.9060018 334\n" +
                "2017 Asheville, NC Miami, FL (Metropolitan Area) 128.3915332 677\n" +
                "2017 Asheville, NC Tampa, FL (Metropolitan Area) 124.4519219 514\n" +
                "2017 Atlanta, GA (Metropolitan Area) Cincinnati, OH 313.655394 377\n" +
                "2017 Atlanta, GA (Metropolitan Area) Memphis, TN 274.8223261 332\n" +
                "2017 Boise, ID Seattle, WA 129.4190566 399\n" +
                "2017 Boise, ID Spokane, WA 106.6399809 287\n" +
                "2017 Boise, ID Sacramento, CA 129.9119902 437\n" +
                "2017 Boston, MA (Metropolitan Area) Richmond, VA 132.355884 395\n" +
                "2017 Boston, MA (Metropolitan Area) Buffalo, NY 132.4186695 474\n" +
                "2017 Buffalo, NY New York City, NY (Metropolitan Area) 117.7032929 292\n" +
                "2017 Charlotte, NC St. Louis, MO 273.6228611 575\n" +
                "2017 Charlotte, NC Detroit, MI 262.8762495 500\n" +
                "2017 Charlotte, NC Tampa, FL (Metropolitan Area) 276.6002795 507\n" +
                "2017 Charlotte, NC Memphis, TN 269.731107 511\n" +
                "2017 Chicago, IL Richmond, VA 262.4844604 607\n" +
                "2017 Chicago, IL Tulsa, OK 270.3571121 585\n" +
                "2017 Chicago, IL Syracuse, NY 290.8316435 270\n" +
                "2017 Chicago, IL Cincinnati, OH 124.3163743 642\n" +
                "2017 Cincinnati, OH Minneapolis/St. Paul, MN 306.9397207 334\n" +
                "2016 Asheville, NC Miami, FL (Metropolitan Area) 129.2055405 677\n" +
                "2016 Asheville, NC Tampa, FL (Metropolitan Area) 126.5900629 514\n" +
                "2016 Atlanta, GA (Metropolitan Area) Cincinnati, OH 298.0553139 377\n" +
                "2016 Atlanta, GA (Metropolitan Area) Memphis, TN 306.4386275 332\n" +
                "2016 Boise, ID Seattle, WA 128.5387179 399\n" +
                "2016 Boise, ID Spokane, WA 114.2404508 287\n" +
                "2016 Boise, ID Sacramento, CA 119.774425 437\n" +
                "2016 Boston, MA (Metropolitan Area) Richmond, VA 136.3048831 395\n" +
                "2016 Boston, MA (Metropolitan Area) Buffalo, NY 139.2092115 474\n" +
                "2016 Buffalo, NY New York City, NY (Metropolitan Area) 138.6866248 292\n" +
                "2016 Charlotte, NC St. Louis, MO 275.0473414 575\n" +
                "2016 Charlotte, NC Detroit, MI 328.1736089 500\n" +
                "2016 Charlotte, NC Tampa, FL (Metropolitan Area) 269.3827727 507\n" +
                "2016 Charlotte, NC Memphis, TN 261.5784123 511\n" +
                "2016 Chicago, IL Richmond, VA 295.4702007 607\n" +
                "2016 Chicago, IL Cincinnati, OH 267.2074027 585\n" +
                "2016 Chicago, IL Tulsa, OK 270.4238455 270\n" +
                "2016 Chicago, IL Syracuse, NY 270.42 642\n" +
                "2016 Cincinnati, OH Minneapolis/St. Paul, MN 375.9145278 334"
        );

        write.close();
        return inputFile;
    }

    private File generateExpectedBadOutputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print(
                "2018 Asheville, NC Miami, FL (Metropolitan Area) 119.6646127 677\n" +
                "2018 Asheville, NC Tampa, FL (Metropolitan Area) 111.1095983 514\n" +
                "2018 Atlanta, GA (Metropolitan Area) Cincinnati, OH 273.9105411 377\n" +
                "2018 Atlanta, GA (Metropolitan Area) Memphis, TN 289.8798238 332\n" +
                "2018 Boise, ID Seattle, WA 131.3517678 399\n" +
                "2018 Boise, ID Spokane, WA 110.8682953 287\n" +
                "2018 Boise, ID Sacramento, CA 129.1509692 437\n" +
                "2018 Boston, MA (Metropolitan Area) Buffalo, NY 130.4956899 395\n" +
                "2018 Boston, MA (Metropolitan Area) Richmond, VA 136.4161655 474\n" +
                "2018 Buffalo, NY New York City, NY (Metropolitan Area) 136.4699697 292\n" +
                "2018 Charlotte, NC St. Louis, MO 0.0 0\n" +
                "2018 Charlotte, NC Detroit, MI 264.3863046 500\n" +
                "2018 Charlotte, NC Tampa, FL (Metropolitan Area) 290.3426771 507\n" +
                "2018 Charlotte, NC Memphis, TN 284.7862224 511\n" +
                "2018 Chicago, IL Syracuse, NY 260.6205682 607\n" +
                "2018 Chicago, IL Tulsa, OK 271.9742993 585\n" +
                "2018 Chicago, IL Cincinnati, OH 133.352732 270\n" +
                "2018 Chicago, IL Richmond, VA 262.2001325 642\n" +
                "2018 Cincinnati, OH Minneapolis/St. Paul, MN 262.9060018 334\n" +
                "2017 Asheville, NC Miami, FL (Metropolitan Area) 0.0 0\n" +
                "2017 Asheville, NC Tampa, FL (Metropolitan Area) 124.4519219 514\n" +
                "2017 Atlanta, GA (Metropolitan Area) Cincinnati, OH 313.655394 377\n" +
                "2017 Atlanta, GA (Metropolitan Area) Memphis, TN 274.8223261 332\n" +
                "2017 Boise, ID Seattle, WA 129.4190566 399\n" +
                "2017 Boise, ID Spokane, WA 106.6399809 287\n" +
                "2017 Boise, ID Sacramento, CA 129.9119902 437\n" +
                "2017 Boston, MA (Metropolitan Area) Richmond, VA 132.355884 395\n" +
                "2017 Boston, MA (Metropolitan Area) Buffalo, NY 132.4186695 474\n" +
                "2017 Buffalo, NY New York City, NY (Metropolitan Area) 0.0 0\n" +
                "2017 Charlotte, NC St. Louis, MO 273.6228611 575\n" +
                "2017 Charlotte, NC Detroit, MI 262.8762495 500\n" +
                "2017 Charlotte, NC Tampa, FL (Metropolitan Area) 276.6002795 507\n" +
                "2017 Charlotte, NC Memphis, TN 0.0 0\n" +
                "2017 Chicago, IL Richmond, VA 262.4844604 607\n" +
                "2017 Chicago, IL Tulsa, OK 270.3571121 585\n" +
                "2017 Chicago, IL Syracuse, NY 290.8316435 270\n" +
                "2017 Chicago, IL Cincinnati, OH 124.3163743 642\n" +
                "2017 Cincinnati, OH Minneapolis/St. Paul, MN 306.9397207 334\n" +
                "2016 Asheville, NC Miami, FL (Metropolitan Area) 129.2055405 677\n" +
                "2016 Asheville, NC Tampa, FL (Metropolitan Area) 126.5900629 514\n" +
                "2016 Atlanta, GA (Metropolitan Area) Cincinnati, OH 298.0553139 377\n" +
                "2016 Atlanta, GA (Metropolitan Area) Memphis, TN 306.4386275 332\n" +
                "2016 Boise, ID Seattle, WA 128.5387179 399\n" +
                "2016 Boise, ID Spokane, WA 114.2404508 287\n" +
                "2016 Boise, ID Sacramento, CA 119.774425 437\n" +
                "2016 Boston, MA (Metropolitan Area) Richmond, VA 136.3048831 395\n" +
                "2016 Boston, MA (Metropolitan Area) Buffalo, NY 0.0 0\n" +
                "2016 Buffalo, NY New York City, NY (Metropolitan Area) 138.6866248 292\n" +
                "2016 Charlotte, NC St. Louis, MO 275.0473414 575\n" +
                "2016 Charlotte, NC Detroit, MI 328.1736089 500\n" +
                "2016 Charlotte, NC Tampa, FL (Metropolitan Area) 269.3827727 507\n" +
                "2016 Charlotte, NC Memphis, TN 261.5784123 511\n" +
                "2016 Chicago, IL Richmond, VA 295.4702007 607\n" +
                "2016 Chicago, IL Cincinnati, OH 267.2074027 585\n" +
                "2016 Chicago, IL Tulsa, OK 0.0 0\n" +
                "2016 Chicago, IL Syracuse, NY 270.42 642\n" +
                "2016 Cincinnati, OH Minneapolis/St. Paul, MN 375.9145278 334"
        );

        write.close();
        return inputFile;
    }

    private File generateGivenBadInputFile() throws IOException {
        final String INPUT_FILENAME = "foo.txt";
        File inputFile = folder.newFile(INPUT_FILENAME);
        PrintWriter write = new PrintWriter(inputFile);
        write.print("Year;city1;city2;mkt_fare;Distance;\n" +
                "2018;Asheville, NC;Miami, FL (Metropolitan Area);119.6646127;677;\n" +
                "2018;Asheville, NC;Tampa, FL (Metropolitan Area);111.1095983;514;\n" +
                "2018;Atlanta, GA (Metropolitan Area);Cincinnati, OH;273.9105411;377;\n" +
                "2018;Atlanta, GA (Metropolitan Area);Memphis, TN;289.8798238;332;\n" +
                "2018;Boise, ID;Seattle, WA;131.3517678;399;\n" +
                "2018;Boise, ID;Spokane, WA;110.8682953;287;\n" +
                "2018;Boise, ID;Sacramento, CA;129.1509692;437;\n" +
                "2018;Boston, MA (Metropolitan Area);Buffalo, NY;130.4956899;395;\n" +
                "2018;Boston, MA (Metropolitan Area);Richmond, VA;136.4161655;474;\n" +
                "2018;Buffalo, NY;New York City, NY (Metropolitan Area);136.4699697;292;\n" +
                "2018;Charlotte, NC;St. Louis, MO;-291.224.1703;c;\n" +
                "2018;Charlotte, NC;Detroit, MI;264.3863046;500;\n" +
                "2018;Charlotte, NC;Tampa, FL (Metropolitan Area);290.3426771;507;\n" +
                "2018;Charlotte, NC;Memphis, TN;284.7862224;511;\n" +
                "2018;Chicago, IL;Syracuse, NY;260.6205682;607;\n" +
                "2018;Chicago, IL;Tulsa, OK;271.9742993;585;\n" +
                "2018;Chicago, IL;Cincinnati, OH;133.352732;270;\n" +
                "2018;Chicago, IL;Richmond, VA;262.2001325;642;\n" +
                "2018;Cincinnati, OH;Minneapolis/St. Paul, MN;262.9060018;334;\n" +
                "2017;Asheville, NC;Miami, FL (Metropolitan Area);hello;-677;\n" +
                "2017;Asheville, NC;Tampa, FL (Metropolitan Area);124.4519219;514;\n" +
                "2017;Atlanta, GA (Metropolitan Area);Cincinnati, OH;313.655394;377;\n" +
                "2017;Atlanta, GA (Metropolitan Area);Memphis, TN;274.8223261;332;\n" +
                "2017;Boise, ID;Seattle, WA;129.4190566;399;\n" +
                "2017;Boise, ID;Spokane, WA;106.6399809;287;\n" +
                "2017;Boise, ID;Sacramento, CA;129.9119902;437;\n" +
                "2017;Boston, MA (Metropolitan Area);Richmond, VA;132.355884;395;\n" +
                "2017;Boston, MA (Metropolitan Area);Buffalo, NY;132.4186695;474;\n" +
                "2017;Buffalo, NY;New York City, NY (Metropolitan Area);bb;cc;\n" +
                "2017;Charlotte, NC;St. Louis, MO;273.6228611;575;\n" +
                "2017;Charlotte, NC;Detroit, MI;262.8762495;500;\n" +
                "2017;Charlotte, NC;Tampa, FL (Metropolitan Area);276.6002795;507;\n" +
                "2017;Charlotte, NC;Memphis, TN;-2;0;\n" +
                "2017;Chicago, IL;Richmond, VA;262.4844604;607;\n" +
                "2017;Chicago, IL;Tulsa, OK;270.3571121;585;\n" +
                "2017;Chicago, IL;Syracuse, NY;290.8316435;270;\n" +
                "2017;Chicago, IL;Cincinnati, OH;124.3163743;642;\n" +
                "2017;Cincinnati, OH;Minneapolis/St. Paul, MN;306.9397207;334;\n" +
                "2016;Asheville, NC;Miami, FL (Metropolitan Area);129.2055405;677;\n" +
                "2016;Asheville, NC;Tampa, FL (Metropolitan Area);126.5900629;514;\n" +
                "2016;Atlanta, GA (Metropolitan Area);Cincinnati, OH;298.0553139;377;\n" +
                "2016;Atlanta, GA (Metropolitan Area);Memphis, TN;306.4386275;332;\n" +
                "2016;Boise, ID;Seattle, WA;128.5387179;399;\n" +
                "2016;Boise, ID;Spokane, WA;114.2404508;287;\n" +
                "2016;Boise, ID;Sacramento, CA;119.774425;437;\n" +
                "2016;Boston, MA (Metropolitan Area);Richmond, VA;136.3048831;395;\n" +
                "2016;Boston, MA (Metropolitan Area);Buffalo, NY;-139.2092115;happy;\n" +
                "2016;Buffalo, NY;New York City, NY (Metropolitan Area);138.6866248;292;\n" +
                "2016;Charlotte, NC;St. Louis, MO;275.0473414;575;\n" +
                "2016;Charlotte, NC;Detroit, MI;328.1736089;500;\n" +
                "2016;Charlotte, NC;Tampa, FL (Metropolitan Area);269.3827727;507;\n" +
                "2016;Charlotte, NC;Memphis, TN;261.5784123;511;\n" +
                "2016;Chicago, IL;Richmond, VA;295.4702007;607;\n" +
                "2016;Chicago, IL;Cincinnati, OH;267.2074027;585;\n" +
                "2016;Chicago, IL;Tulsa, OK;dd;-4;\n" +
                "2016;Chicago, IL;Syracuse, NY;270.42;642;\n" +
                "2016;Cincinnati, OH;Minneapolis/St. Paul, MN;375.9145278;334;");
        write.close();
        return inputFile;
    }

    private ArrayList<Flight> toRemoveArrayList(){
        Flight[] temp = {
                new Flight("2018","Atlanta, GA (Metropolitan Area)","Memphis, TN",289.8798238,332),
        new Flight("2018","Boston, MA (Metropolitan Area)","Buffalo, NY",130.4956899,395),
        new Flight("2017","Charlotte, NC","St. Louis, MO",273.6228611,575),
        new Flight("2017","Cincinnati, OH","Minneapolis/St. Paul, MN",306.9397207,334),
        new Flight("2016","Asheville, NC","Miami, FL (Metropolitan Area)",129.2055405,677),
        new Flight("2016","Buffalo, NY","New York City, NY (Metropolitan Area)",138.6866248,292)
        };

        return new ArrayList<>(Arrays.asList(temp));
    }

    private ArrayList<Flight> goodInputArrayList(){
        Flight[] temp = {new Flight("2018", "Asheville, NC", "Miami, FL (Metropolitan Area)", 119.6646127, 677),
        new Flight("2018", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 111.1095983, 514),
        new Flight("2018", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 273.9105411, 377),
        new Flight("2018", "Atlanta, GA (Metropolitan Area)", "Memphis, TN", 289.8798238, 332),
        new Flight("2018", "Boise, ID", "Seattle, WA", 131.3517678, 399),
        new Flight("2018", "Boise, ID", "Spokane, WA", 110.8682953, 287),
        new Flight("2018", "Boise, ID", "Sacramento, CA", 129.1509692, 437),
        new Flight("2018", "Boston, MA (Metropolitan Area)", "Buffalo, NY", 130.4956899, 395),
        new Flight("2018", "Boston, MA (Metropolitan Area)", "Richmond, VA", 136.4161655, 474),
        new Flight("2018", "Buffalo, NY", "New York City, NY (Metropolitan Area)", 136.4699697, 292),
        new Flight("2018", "Charlotte, NC", "St. Louis, MO", 291.2241703, 575),
        new Flight("2018", "Charlotte, NC", "Detroit, MI", 264.3863046, 500),
        new Flight("2018", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 290.3426771, 507),
        new Flight("2018", "Charlotte, NC", "Memphis, TN", 284.7862224, 511),
        new Flight("2018", "Chicago, IL", "Syracuse, NY", 260.6205682, 607),
        new Flight("2018", "Chicago, IL", "Tulsa, OK", 271.9742993, 585),
        new Flight("2018", "Chicago, IL", "Cincinnati, OH", 133.352732, 270),
        new Flight("2018", "Chicago, IL", "Richmond, VA", 262.2001325, 642),
        new Flight("2018", "Cincinnati, OH", "Minneapolis/St. Paul, MN", 262.9060018, 334),
        new Flight("2017", "Asheville, NC", "Miami, FL (Metropolitan Area)", 128.3915332, 677),
                new Flight("2017", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 124.4519219, 514),
                new Flight("2017", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 313.655394, 377),
        new Flight("2017", "Atlanta, GA (Metropolitan Area)", "Memphis, TN", 274.8223261, 332),
        new Flight("2017", "Boise, ID", "Seattle, WA", 129.4190566, 399),
        new Flight("2017", "Boise, ID", "Spokane, WA", 106.6399809, 287),
        new Flight("2017", "Boise, ID", "Sacramento, CA", 129.9119902, 437),
        new Flight("2017", "Boston, MA (Metropolitan Area)", "Richmond, VA", 132.355884, 395),
        new Flight("2017", "Boston, MA (Metropolitan Area)", "Buffalo, NY", 132.4186695, 474),
        new Flight("2017", "Buffalo, NY", "New York City, NY (Metropolitan Area)", 117.7032929, 292),
        new Flight("2017", "Charlotte, NC", "St. Louis, MO", 273.6228611, 575),
        new Flight("2017", "Charlotte, NC", "Detroit, MI", 262.8762495, 500),
        new Flight("2017", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 276.6002795, 507),
        new Flight("2017", "Charlotte, NC", "Memphis, TN", 269.731107, 511),
        new Flight("2017", "Chicago, IL", "Richmond, VA", 262.4844604, 607),
        new Flight("2017", "Chicago, IL", "Tulsa, OK", 270.3571121, 585),
        new Flight("2017", "Chicago, IL", "Syracuse, NY", 290.8316435, 270),
        new Flight("2017", "Chicago, IL", "Cincinnati, OH", 124.3163743, 642),
        new Flight("2017", "Cincinnati, OH", "Minneapolis/St. Paul, MN", 306.9397207, 334),
        new Flight("2016", "Asheville, NC", "Miami, FL (Metropolitan Area)", 129.2055405, 677),
                new Flight("2016", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 126.5900629, 514),
                new Flight("2016", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 298.0553139, 377),
        new Flight("2016", "Atlanta, GA (Metropolitan Area)", "Memphis, TN", 306.4386275, 332),
        new Flight("2016", "Boise, ID", "Seattle, WA", 128.5387179, 399),
        new Flight("2016", "Boise, ID", "Spokane, WA", 114.2404508, 287),
        new Flight("2016", "Boise, ID", "Sacramento, CA", 119.774425, 437),
        new Flight("2016", "Boston, MA (Metropolitan Area)", "Richmond, VA", 136.3048831, 395),
        new Flight("2016", "Boston, MA (Metropolitan Area)", "Buffalo, NY", 139.2092115, 474),
        new Flight("2016", "Buffalo, NY", "New York City, NY (Metropolitan Area)", 138.6866248, 292),
                new Flight("2016", "Charlotte, NC", "St. Louis, MO", 275.0473414, 575),
        new Flight("2016", "Charlotte, NC", "Detroit, MI", 328.1736089, 500),
        new Flight("2016", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 269.3827727, 507),
                new Flight("2016", "Charlotte, NC", "Memphis, TN", 261.5784123, 511),
        new Flight("2016", "Chicago, IL", "Richmond, VA", 295.4702007, 607),
        new Flight("2016", "Chicago, IL", "Cincinnati, OH", 267.2074027, 585),
        new Flight("2016", "Chicago, IL", "Tulsa, OK", 270.4238455, 270),
                new Flight("2016", "Chicago, IL", "Syracuse, NY", 270.42, 642),
                new Flight("2016", "Cincinnati, OH", "Minneapolis/St. Paul, MN", 375.9145278, 334)};


        return new ArrayList<>(Arrays.asList(temp));

    }

    private ArrayList<Flight> goodInputDataRemovedArrayList(){
        Flight[] temp =
                {new Flight("2018", "Asheville, NC", "Miami, FL (Metropolitan Area)", 119.6646127, 677),
                        new Flight("2018", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 111.1095983, 514),
                        new Flight("2018", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 273.9105411, 377),

                        new Flight("2018", "Boise, ID", "Seattle, WA", 131.3517678, 399),
                        new Flight("2018", "Boise, ID", "Spokane, WA", 110.8682953, 287),
                        new Flight("2018", "Boise, ID", "Sacramento, CA", 129.1509692, 437),

                        new Flight("2018", "Boston, MA (Metropolitan Area)", "Richmond, VA", 136.4161655, 474),
                        new Flight("2018", "Buffalo, NY", "New York City, NY (Metropolitan Area)", 136.4699697, 292),
                        new Flight("2018", "Charlotte, NC", "St. Louis, MO", 291.2241703, 575),
                        new Flight("2018", "Charlotte, NC", "Detroit, MI", 264.3863046, 500),
                        new Flight("2018", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 290.3426771, 507),
                        new Flight("2018", "Charlotte, NC", "Memphis, TN", 284.7862224, 511),
                        new Flight("2018", "Chicago, IL", "Syracuse, NY", 260.6205682, 607),
                        new Flight("2018", "Chicago, IL", "Tulsa, OK", 271.9742993, 585),
                        new Flight("2018", "Chicago, IL", "Cincinnati, OH", 133.352732, 270),
                        new Flight("2018", "Chicago, IL", "Richmond, VA", 262.2001325, 642),
                        new Flight("2018", "Cincinnati, OH", "Minneapolis/St. Paul, MN", 262.9060018, 334),
                        new Flight("2017", "Asheville, NC", "Miami, FL (Metropolitan Area)", 128.3915332, 677),
                        new Flight("2017", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 124.4519219, 514),
                        new Flight("2017", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 313.655394, 377),
                        new Flight("2017", "Atlanta, GA (Metropolitan Area)", "Memphis, TN", 274.8223261, 332),
                        new Flight("2017", "Boise, ID", "Seattle, WA", 129.4190566, 399),
                        new Flight("2017", "Boise, ID", "Spokane, WA", 106.6399809, 287),
                        new Flight("2017", "Boise, ID", "Sacramento, CA", 129.9119902, 437),
                        new Flight("2017", "Boston, MA (Metropolitan Area)", "Richmond, VA", 132.355884, 395),
                        new Flight("2017", "Boston, MA (Metropolitan Area)", "Buffalo, NY", 132.4186695, 474),
                        new Flight("2017", "Buffalo, NY", "New York City, NY (Metropolitan Area)", 117.7032929, 292),

                        new Flight("2017", "Charlotte, NC", "Detroit, MI", 262.8762495, 500),
                        new Flight("2017", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 276.6002795, 507),
                        new Flight("2017", "Charlotte, NC", "Memphis, TN", 269.731107, 511),
                        new Flight("2017", "Chicago, IL", "Richmond, VA", 262.4844604, 607),
                        new Flight("2017", "Chicago, IL", "Tulsa, OK", 270.3571121, 585),
                        new Flight("2017", "Chicago, IL", "Syracuse, NY", 290.8316435, 270),
                        new Flight("2017", "Chicago, IL", "Cincinnati, OH", 124.3163743, 642),


                        new Flight("2016", "Asheville, NC", "Tampa, FL (Metropolitan Area)", 126.5900629, 514),
                        new Flight("2016", "Atlanta, GA (Metropolitan Area)", "Cincinnati, OH", 298.0553139, 377),
                        new Flight("2016", "Atlanta, GA (Metropolitan Area)", "Memphis, TN", 306.4386275, 332),
                        new Flight("2016", "Boise, ID", "Seattle, WA", 128.5387179, 399),
                        new Flight("2016", "Boise, ID", "Spokane, WA", 114.2404508, 287),
                        new Flight("2016", "Boise, ID", "Sacramento, CA", 119.774425, 437),
                        new Flight("2016", "Boston, MA (Metropolitan Area)", "Richmond, VA", 136.3048831, 395),
                        new Flight("2016", "Boston, MA (Metropolitan Area)", "Buffalo, NY", 139.2092115, 474),
                        new Flight("2016", "Charlotte, NC", "St. Louis, MO", 275.0473414, 575),
                        new Flight("2016", "Charlotte, NC", "Detroit, MI", 328.1736089, 500),
                        new Flight("2016", "Charlotte, NC", "Tampa, FL (Metropolitan Area)", 269.3827727, 507),
                        new Flight("2016", "Charlotte, NC", "Memphis, TN", 261.5784123, 511),
                        new Flight("2016", "Chicago, IL", "Richmond, VA", 295.4702007, 607),
                        new Flight("2016", "Chicago, IL", "Cincinnati, OH", 267.2074027, 585),
                        new Flight("2016", "Chicago, IL", "Tulsa, OK", 270.4238455, 270),
                        new Flight("2016", "Chicago, IL", "Syracuse, NY", 270.42, 642),
                        new Flight("2016", "Cincinnati, OH", "Minneapolis/St. Paul, MN", 375.9145278, 334)};

        return new ArrayList<>(Arrays.asList(temp));

    }

    private ArrayList<Flight> badInputArrayList(){
        Flight[] temp = {
                new Flight("2018","Asheville, NC","Miami, FL (Metropolitan Area)",119.6646127,677),
                new Flight("2018","Asheville, NC","Tampa, FL (Metropolitan Area)",111.1095983,514),
                new Flight("2018","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",273.9105411,377),
                new Flight("2018","Atlanta, GA (Metropolitan Area)","Memphis, TN",289.8798238,332),
                new Flight("2018","Boise, ID","Seattle, WA",131.3517678,399),
                new Flight("2018","Boise, ID","Spokane, WA",110.8682953,287),
                new Flight("2018","Boise, ID","Sacramento, CA",129.1509692,437),
                new Flight("2018","Boston, MA (Metropolitan Area)","Buffalo, NY",130.4956899,395),
                new Flight("2018","Boston, MA (Metropolitan Area)","Richmond, VA",136.4161655,474),
                new Flight("2018","Buffalo, NY","New York City, NY (Metropolitan Area)",136.4699697,292),
                new Flight("2018","Charlotte, NC","St. Louis, MO",0.0,0),
                new Flight("2018","Charlotte, NC","Detroit, MI",264.3863046,500),
                new Flight("2018","Charlotte, NC","Tampa, FL (Metropolitan Area)",290.3426771,507),
                new Flight("2018","Charlotte, NC","Memphis, TN",284.7862224,511),
                new Flight("2018","Chicago, IL","Syracuse, NY",260.6205682,607),
                new Flight("2018","Chicago, IL","Tulsa, OK",271.9742993,585),
                new Flight("2018","Chicago, IL","Cincinnati, OH",133.352732,270),
                new Flight("2018","Chicago, IL","Richmond, VA",262.2001325,642),
                new Flight("2018","Cincinnati, OH","Minneapolis/St. Paul, MN",262.9060018,334),
                new Flight("2017","Asheville, NC","Miami, FL (Metropolitan Area)",0,0),
                new Flight("2017","Asheville, NC","Tampa, FL (Metropolitan Area)",124.4519219,514),
                new Flight("2017","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",313.655394,377),
                new Flight("2017","Atlanta, GA (Metropolitan Area)","Memphis, TN",274.8223261,332),
                new Flight("2017","Boise, ID","Seattle, WA",129.4190566,399),
                new Flight("2017","Boise, ID","Spokane, WA",106.6399809,287),
                new Flight("2017","Boise, ID","Sacramento, CA",129.9119902,437),
                new Flight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395),
                new Flight("2017","Boston, MA (Metropolitan Area)","Buffalo, NY",132.4186695,474),
                new Flight("2017","Buffalo, NY","New York City, NY (Metropolitan Area)",0,0),
                new Flight("2017","Charlotte, NC","St. Louis, MO",273.6228611,575),
                new Flight("2017","Charlotte, NC","Detroit, MI",262.8762495,500),
                new Flight("2017","Charlotte, NC","Tampa, FL (Metropolitan Area)",276.6002795,507),
                new Flight("2017","Charlotte, NC","Memphis, TN",0,0),
                new Flight("2017","Chicago, IL","Richmond, VA",262.4844604,607),
                new Flight("2017","Chicago, IL","Tulsa, OK",270.3571121,585),
                new Flight("2017","Chicago, IL","Syracuse, NY",290.8316435,270),
                new Flight("2017","Chicago, IL","Cincinnati, OH",124.3163743,642),
                new Flight("2017","Cincinnati, OH","Minneapolis/St. Paul, MN",306.9397207,334),
                new Flight("2016","Asheville, NC","Miami, FL (Metropolitan Area)",129.2055405,677),
                new Flight("2016","Asheville, NC","Tampa, FL (Metropolitan Area)",126.5900629,514),
                new Flight("2016","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",298.0553139,377),
                new Flight("2016","Atlanta, GA (Metropolitan Area)","Memphis, TN",306.4386275,332),
                new Flight("2016","Boise, ID","Seattle, WA",128.5387179,399),
                new Flight("2016","Boise, ID","Spokane, WA",114.2404508,287),
                new Flight("2016","Boise, ID","Sacramento, CA",119.774425,437),
                new Flight("2016","Boston, MA (Metropolitan Area)","Richmond, VA",136.3048831,395),
                new Flight("2016","Boston, MA (Metropolitan Area)","Buffalo, NY",0,0),
                new Flight("2016","Buffalo, NY","New York City, NY (Metropolitan Area)",138.6866248,292),
                new Flight("2016","Charlotte, NC","St. Louis, MO",275.0473414,575),
                new Flight("2016","Charlotte, NC","Detroit, MI",328.1736089,500),
                new Flight("2016","Charlotte, NC","Tampa, FL (Metropolitan Area)",269.3827727,507),
                new Flight("2016","Charlotte, NC","Memphis, TN",261.5784123,511),
                new Flight("2016","Chicago, IL","Richmond, VA",295.4702007,607),
                new Flight("2016","Chicago, IL","Cincinnati, OH",267.2074027,585),
                new Flight("2016","Chicago, IL","Tulsa, OK",0,0),
                new Flight("2016","Chicago, IL","Syracuse, NY",270.42,642),
                new Flight("2016","Cincinnati, OH","Minneapolis/St. Paul, MN",375.9145278,334)
        };


        return new ArrayList<>(Arrays.asList(temp));

    }

    private ArrayList<Flight> badInputDataRemovedArrayList(){
        Flight[] temp = {
                new Flight("2018","Asheville, NC","Miami, FL (Metropolitan Area)",119.6646127,677),
                new Flight("2018","Asheville, NC","Tampa, FL (Metropolitan Area)",111.1095983,514),
                new Flight("2018","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",273.9105411,377),
                new Flight("2018","Boise, ID","Seattle, WA",131.3517678,399),
                new Flight("2018","Boise, ID","Spokane, WA",110.8682953,287),
                new Flight("2018","Boise, ID","Sacramento, CA",129.1509692,437),
                new Flight("2018","Boston, MA (Metropolitan Area)","Richmond, VA",136.4161655,474),
                new Flight("2018","Buffalo, NY","New York City, NY (Metropolitan Area)",136.4699697,292),
                new Flight("2018","Charlotte, NC","St. Louis, MO",0.0,0),
                new Flight("2018","Charlotte, NC","Detroit, MI",264.3863046,500),
                new Flight("2018","Charlotte, NC","Tampa, FL (Metropolitan Area)",290.3426771,507),
                new Flight("2018","Charlotte, NC","Memphis, TN",284.7862224,511),
                new Flight("2018","Chicago, IL","Syracuse, NY",260.6205682,607),
                new Flight("2018","Chicago, IL","Tulsa, OK",271.9742993,585),
                new Flight("2018","Chicago, IL","Cincinnati, OH",133.352732,270),
                new Flight("2018","Chicago, IL","Richmond, VA",262.2001325,642),
                new Flight("2018","Cincinnati, OH","Minneapolis/St. Paul, MN",262.9060018,334),
                new Flight("2017","Asheville, NC","Miami, FL (Metropolitan Area)",0,0),
                new Flight("2017","Asheville, NC","Tampa, FL (Metropolitan Area)",124.4519219,514),
                new Flight("2017","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",313.655394,377),
                new Flight("2017","Atlanta, GA (Metropolitan Area)","Memphis, TN",274.8223261,332),
                new Flight("2017","Boise, ID","Seattle, WA",129.4190566,399),
                new Flight("2017","Boise, ID","Spokane, WA",106.6399809,287),
                new Flight("2017","Boise, ID","Sacramento, CA",129.9119902,437),
                new Flight("2017","Boston, MA (Metropolitan Area)","Richmond, VA",132.355884,395),
                new Flight("2017","Boston, MA (Metropolitan Area)","Buffalo, NY",132.4186695,474),
                new Flight("2017","Buffalo, NY","New York City, NY (Metropolitan Area)",0,0),
                new Flight("2017","Charlotte, NC","Detroit, MI",262.8762495,500),
                new Flight("2017","Charlotte, NC","Tampa, FL (Metropolitan Area)",276.6002795,507),
                new Flight("2017","Charlotte, NC","Memphis, TN",0,0),
                new Flight("2017","Chicago, IL","Richmond, VA",262.4844604,607),
                new Flight("2017","Chicago, IL","Tulsa, OK",270.3571121,585),
                new Flight("2017","Chicago, IL","Syracuse, NY",290.8316435,270),
                new Flight("2017","Chicago, IL","Cincinnati, OH",124.3163743,642),
                new Flight("2016","Asheville, NC","Tampa, FL (Metropolitan Area)",126.5900629,514),
                new Flight("2016","Atlanta, GA (Metropolitan Area)","Cincinnati, OH",298.0553139,377),
                new Flight("2016","Atlanta, GA (Metropolitan Area)","Memphis, TN",306.4386275,332),
                new Flight("2016","Boise, ID","Seattle, WA",128.5387179,399),
                new Flight("2016","Boise, ID","Spokane, WA",114.2404508,287),
                new Flight("2016","Boise, ID","Sacramento, CA",119.774425,437),
                new Flight("2016","Boston, MA (Metropolitan Area)","Richmond, VA",136.3048831,395),
                new Flight("2016","Boston, MA (Metropolitan Area)","Buffalo, NY",0,0),
                new Flight("2016","Charlotte, NC","St. Louis, MO",275.0473414,575),
                new Flight("2016","Charlotte, NC","Detroit, MI",328.1736089,500),
                new Flight("2016","Charlotte, NC","Tampa, FL (Metropolitan Area)",269.3827727,507),
                new Flight("2016","Charlotte, NC","Memphis, TN",261.5784123,511),
                new Flight("2016","Chicago, IL","Richmond, VA",295.4702007,607),
                new Flight("2016","Chicago, IL","Cincinnati, OH",267.2074027,585),
                new Flight("2016","Chicago, IL","Tulsa, OK",0,0),
                new Flight("2016","Chicago, IL","Syracuse, NY",270.42,642),
                new Flight("2016","Cincinnati, OH","Minneapolis/St. Paul, MN",375.9145278,334)
        };


        return new ArrayList<>(Arrays.asList(temp));

    }
}
