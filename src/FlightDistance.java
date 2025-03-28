public class FlightDistance{

    public static String[] calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double distance = Math.sin(MathUtils.degreeToRadian(lat1)) * Math.sin(MathUtils.degreeToRadian(lat2)) + Math.cos(MathUtils.degreeToRadian(lat1)) * Math.cos(MathUtils.degreeToRadian(lat2)) * Math.cos(MathUtils.degreeToRadian(theta));
        distance = Math.acos(distance);
        distance = MathUtils.radianToDegree(distance);
        distance = distance * 60 * 1.1515;
        /* On the Zero-Index, distance will be in Miles, on 1st-index, distance will be in KM and on the 2nd index distance will be in KNOTS*/
        String[] distanceString = new String[3];
        distanceString[0] = String.format("%.2f", distance * 0.8684);
        distanceString[1] = String.format("%.2f", distance * 1.609344);
        distanceString[2] = Double.toString(Math.round(distance * 100.0) / 100.0);
        return distanceString;
    }

    public static void displayMeasurementInstructions(){
        String symbols = "+---------------------------+";
        System.out.printf("\n\n %100s\n %100s", symbols, "| SOME IMPORTANT GUIDELINES |");
        System.out.printf("\n %100s\n", symbols);
        System.out.println("\n\t\t1. Distance between the destinations are based upon the Airports Coordinates(Latitudes && Longitudes) based in those cities\n");
        System.out.println("\t\t2. Actual Distance of the flight may vary from this approximation as Airlines may define their on Travel Policy that may restrict the planes to fly through specific regions...\n");
        System.out.println("\t\t3. Flight Time depends upon several factors such as Ground Speed(GS), AirCraft Design, Flight Altitude and Weather. Ground Speed for these calculations is 450 Knots...\n");
        System.out.println("\t\t4. Expect reaching your destination early or late from the Arrival Time. So, please keep a margin of ±1 hour...\n");
        System.out.println("\t\t5. The departure time is the moment that your plane pushes back from the gate, not the time it takes off. The arrival time is the moment that your plane pulls into the gate, not the time\n\t\t   it touches down on the runway...\n");
    }

}
