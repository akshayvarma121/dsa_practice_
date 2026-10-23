class Solution {
    public double[] internalAngles(int[] sides) {
        //Step 1 : Sorting side to identify the longest side 
        Arrays.sort(sides);
        double a = sides[0];
        double b = sides[1];
        double c = sides[2];

        //Cheecking if triangle exists or not 
        if(a+b<=c){
            return new double[0];
        }

        //Step 2 : Calculate angles in radians using law of cosines 
        double angleA = Math.acos((b*b+c*c-a*a)/(2*b*c));
        double angleB = Math.acos((a*a+c*c-b*b)/(2*a*c));
        double angleC = Math.acos((b*b+a*a-c*c)/(2*b*a));

        double[] angles = new double[]{
            Math.toDegrees(angleA),
            Math.toDegrees(angleB),
             Math.toDegrees(angleC)
        };

        Arrays.sort(angles);
        return angles;
        
    }
}