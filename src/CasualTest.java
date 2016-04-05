import java.security.KeyStoreException;

public class CasualTest {
    //parameter list with changeable length
    public static void printMax(int ...numbers){
        if(numbers.length==0){
            System.out.println("No elements");
            return;
        }
        int maxNumber=numbers[0];
        for(int i=1;i<numbers.length;i++){
            if(maxNumber<numbers[i])
                maxNumber=numbers[i];
        }
        System.out.println("The biggest number is "+maxNumber);
    }

    //binary search
    public static int binarySearch(int[] sortedArray,int key){
        int low=0;
        int high=sortedArray.length-1;
        if(key<sortedArray[low]||key>sortedArray[high])
            return -1;
        while(low<=high){
            int mid=(low+high)/2;
            if(sortedArray[mid]<key)
                high=mid;
            if(sortedArray[mid]>key)
                low=mid;
            if(sortedArray[mid]==key)
                return mid;
        }
        return -1;
    }

    //show array
    public static void showArray(double array[]){
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

    public static void main(String args[]) throws KeyStoreException {




        /**Hugo 20160107
         * some static function in Arrays Class
         *
         * sort()
         * can sort the value in an increasing sorting
         *
         * binarySearch()
         * can find the index of some key in the array
         *
         * equals()
         * can check out whether the two arrays are same8
         *
         * fill()
         * can fill some element into an array repeatedly from the index1 to index2 such as
         * fill(list,5)  :fill all the elements with 5
         * fill(list,1,3,8)   :fill all the element from index 1 to 3-1=2 with 8
         */
        /*
        double[] numbersArray={6.0,4.4,1.9,2.9,3.4,3.5};
        Arrays.sort(numbersArray);
        showArray(numbersArray);
        int index=Arrays.binarySearch(numbersArray,3.4);
        System.out.println("After sort, The index of 3.4 in the array is "+index);
        */


        /**Hugo 201607
         * Binary search
         */
        /*
        int[] intArrayTest1={2,3,12,24,33,68,90};
        int index=binarySearch(intArrayTest1,24);
        System.out.println("It has been find in the array, its index is "+index);
        */


        /**Hugo 20160107
         * parameter list with changeable length
         *//*
        final int sizeOfArray=100;
        int[] intArray=new int[sizeOfArray];
        for(int i=0;i<sizeOfArray;i++){
            intArray[i]=(int)(9+Math.random()*101);
        }
        printMax(9,34,12,90);//past the parameter with changeable length.
        printMax(intArray);//array can be regarded use past like that above.
        */


        /**Hugo 20160106
         *
         * (int)(Math.random()%101)
         * generate the random number
         * generate the random char
         */
        /*
        //generate the random number
        int randNumber=(int)(Math.random()%101);
        Scanner input=new Scanner(System.in);
        int inputNumber=input.nextInt();
        while(inputNumber!=randNumber){
            if(inputNumber>randNumber)
                System.out.println("too big");
            if(inputNumber<randNumber)
                System.out.println("too small");
            inputNumber=input.nextInt();
        }
        System.out.println("correct,you're so clever.");

        //generate the random char
        for(int i=0;i<100;i++){
            int randomChar=(int)((int)'a'+Math.random()*((int)'z'-(int)'a')+1);
            System.out.println((char)randomChar);
        }
        */


        /**Hugo 20160106
         *
         * JOptionPane.showInputDialog
         * JOptionPane.showMessageDialog
         * JOptionPane.showConfirmDialog   return JOptionPane.YES_OPTION(0),JOptionPane.NO_OPTION(1),JOptionPane.CANCEL(2)
         *
         * Integer.parseInt and Double.parseDouble
         * can help change the string like 2354 or 3425.34 into an integer or double number.
         */
        /*
        String inputInt= JOptionPane.showInputDialog(null, "input an integer", "Input Dialog Demo", JOptionPane.QUESTION_MESSAGE);
        int inputNumber=Integer.parseInt(inputInt);
        JOptionPane.showMessageDialog(null, "the number input by the client is "+inputNumber);
        System.out.println("The string " + inputInt + " has been exchanged into integer " + inputNumber);
        String set1=" 1 3 5 7\n"+" 9 11 13 15\n"+"17 19 21 23\n"+"25 27 29 31";

        int answer=JOptionPane.showConfirmDialog(null,"Is your birthday is in this numbers?\n"+set1);
        if(answer==JOptionPane.YES_OPTION)
            JOptionPane.showMessageDialog(null,"Right");
        if(answer==JOptionPane.NO_OPTION)
            JOptionPane.showMessageDialog(null,"false");
        if(answer==JOptionPane.CANCEL_OPTION)
            JOptionPane.showMessageDialog(null,"cancel");
        */

        /**Hugo 20160106
         * test the ASCII of the range of 'A' to 'Z' and 'a' to 'z'
         */
        /*
        String longString="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String longString2="abcdefghijklmnopqrstuvwxyz";
        char[] charArray=longString.toCharArray();
        //implement the ASCII of 'A' is 65 and 'a' is 97
        for(int i=0;i<charArray.length;i++){
            System.out.println("the char "+charArray[i]+" 's ASCII code is "+(int)(charArray[i]));
        }
        charArray=longString2.toCharArray();
        for(int i=0;i<charArray.length;i++){
            System.out.println("the char "+charArray[i]+" 's ASCII code is "+(int)(charArray[i]));
        }
        */


        /**Hugo 20160106
         * Panel Testing
         **/
        /*
        Frame f=new Frame("FrameTesting");
        Panel p1=new Panel();
        p1.setBackground(Color.black);

        Panel p2=new Panel();
        p2.setBackground(Color.gray);

        f.add(p1,BorderLayout.CENTER);
        f.add(p2,BorderLayout.NORTH);

        f.setSize(200,200);
        f.setVisible(true);
        */


    }
}