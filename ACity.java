import java.text.DecimalFormat;

/**
 * @author      Erinn Ferguson
 * description: class file for ACity objects,constructor takes in a line from
 *              the .csv file and assigns the data 
 */

public class ACity {

    /** newline constant    */
    private final String NEWLINE = "\n";
    /** tab constant    */
    private final String TAB = "\t";

    /** the sequence number of the city in the file*/
    private int seqNum;
    /** the name of the city*/
    private String city;
    /** the state that the city is in*/
    private String state;
    /** the population in the city in 2012*/
    private int pop2012;
    /** the population in the city in 2010*/
    private int pop2010;
    /** the area of the city in sq. mi*/
    private double area;
    /** the latitude of the city*/
    private double latitude;
    /** the longitude of the city*/
    private double longitude;

    /** the population change of the city between 2010 and 2012*/
    private double popChangePct;


    /**
     * Constructor, creates city object and assigns values
     * @param line the line taken from the file with all of the city
     *             information
     */
    public ACity(String line){
        /** the index of closest comma in the line*/
        int commaIndex;
        /** temporary variable to take the substring of the line to
         * add as a variable */
        int temp;

        commaIndex = line.indexOf(",");
        seqNum = Integer.parseInt(line.substring(0,commaIndex));

        temp = commaIndex+1;
        commaIndex = line.indexOf(",",temp);
        city = line.substring(temp,commaIndex);

        temp = commaIndex +1;
        commaIndex = line.indexOf(",",temp);
        state = line.substring(temp, commaIndex);

        temp = commaIndex +1;
        commaIndex = line.indexOf(",",temp);
        pop2012 = Integer.parseInt(line.substring(temp, commaIndex));

        temp = commaIndex +1;
        commaIndex = line.indexOf(",",temp);
        pop2010 = Integer.parseInt(line.substring(temp, commaIndex));

        temp = commaIndex +1;
        commaIndex = line.indexOf(",",temp);
        area = Double.parseDouble(line.substring(temp,commaIndex-6));

        temp = commaIndex +1;
        commaIndex = line.indexOf("N",temp);
        latitude = Double.parseDouble(line.substring(temp, commaIndex-1));

        temp = commaIndex +1;
        commaIndex = line.length();
        longitude = Double.parseDouble(line.substring(temp,commaIndex-1));

    }
    /** @return the population for 2012*/
    public int getPop2012(){
        return pop2012;
    }

    /** @return the population for 2010*/
    public int getPop2010(){
        return pop2010;
    }

    /**
     * Calculates the percent change of the populations for 2010 and 2012
     * @param pop2010 the population for 2010
     * @param pop2012 the population for 2012
     * @return the percent change between the two populations
     */
    public double popChangePctCalc(int pop2010, int pop2012){

        /** DecimalFormat object to format the population percent change to
         * the hundredth */
        DecimalFormat df = new DecimalFormat("0.00");

        popChangePct = ((double)(pop2012-pop2010)/(double)(pop2010))*100.0;
        popChangePct = Double.parseDouble(df.format(popChangePct));

        return popChangePct;

    }

    /**
     * Takes all of the objects information and converts it into an XML format
     * @return string in XML format
     */
    public String convertToXML(){

        return TAB+ "<name>" + NEWLINE +
                TAB + TAB + "<seqNum>"+ seqNum + "</seqNum>" + NEWLINE +
                TAB + TAB + "<city>" + city + "</city>" + NEWLINE +
                TAB + TAB + "<state>" + state + "</state>" + NEWLINE +
                TAB + TAB + "<pop2012>" + pop2012 + "</pop2012>" + NEWLINE +
                TAB + TAB + "<pop2010>" + pop2010 + "</pop2010>" + NEWLINE +
                TAB + TAB + "<popChangePct>" + popChangePct + "</popChangePct>" + NEWLINE +
                TAB + TAB + "<area>" + area + "</area>" + NEWLINE +
                TAB + TAB + "<latitude>" + latitude + "</latitude>" + NEWLINE +
                TAB + TAB + "<longitude>" + longitude + "</longitude>" + NEWLINE +
                TAB + "</name>";

    }


}
