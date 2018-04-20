//*********************************imports*******************************************
import java.io.*;
import java.util.*;
/**
 * @author          Erinn Ferguson
 * description:     reads in data from a .csv file and converts the informartion
 *                  into an .xml file
 */
public class CityDataCreator {


    public static void main(String[] args) throws IOException{

        //*************************constants******************************************
        final String NEWLINE = "\n";    //newline constant
        final int cityNum;              //number of cities in file constant
        //*************************variables******************************************
        int cityArrayCount = 0;         //counter of cities
        int tempPop2012;                //current city population for 2012
        int tempPop2010;                //current city population for 2010

        //**************************objects*******************************************
        File fileName = new File("CityData.csv");           //input file name
        String outFile = "CityData.xml";                    //output file name
        Scanner scanner = new Scanner(fileName);            //scanner name
        ACity currentCity;                                  //ACity object
        FileWriter fileWriter = new FileWriter(outFile);    //FileWriter object
        BufferedWriter outStream = new BufferedWriter(fileWriter);//BufferedWriter object

        String line;            //string for the to be passed into the ACity constructor
        String xmlFormat;       //string of the ACity object converted to .xml format

        ArrayList<ACity> allOfTheCities = new ArrayList<>();

        //****************************method******************************************

        //beginning of the .xml file
        outStream.write("<?xml version= \"1.0\" encoding = \"UTF-8\"?>" + NEWLINE);
        outStream.write("<citydata>"+ NEWLINE);

        //take data from the .csv file and turn it into a ACity object
        while(scanner.hasNextLine()) {
            line = scanner.nextLine();
            currentCity = new ACity(line);

            allOfTheCities.add(cityArrayCount,currentCity);
            System.out.println(line);

            tempPop2010 = currentCity.getPop2010();
            tempPop2012 = currentCity.getPop2012();

            currentCity.popChangePctCalc(tempPop2010,tempPop2012);

            cityArrayCount++;

        }

        cityNum = allOfTheCities.size();        //finds the length of the arraylist

        //goes through array of ACity objects and prints them out in XML
        //format to the out file (CityData.xml)
        for(int i=0; i<cityNum; i++) {
            xmlFormat = allOfTheCities.get(i).convertToXML();
            outStream.write(xmlFormat);
            outStream.write(NEWLINE);
            System.out.println(xmlFormat);
        }

        //end of the .xml file
        outStream.write("</citydata>");

        outStream.close();

    }
}
