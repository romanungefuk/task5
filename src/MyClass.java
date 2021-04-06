import java.util.Random;

public class MyClass {
    private byte b;
    private short s;
    private int i;
    private long l;
    private float f;
    private double d;
    private String string;
    private Integer integer;
    private final char[] abc = new char[]{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    private final String[] calendar = new String[]{"January","February","March","April","May","June","July","August","September","October","November","December"};

    public char[] getAbc() {
        return abc;
    }

    public String[] getCalendar() {
        return calendar;
    }

    public int[] setNewRandomIntArray (int arrayLength, int maxValue) {
        int[] randomIntArray = new int[arrayLength];
        for (int j = 0; j < arrayLength; j++) {
            randomIntArray[j] = new Random().nextInt(maxValue) + 1;
        }
        return randomIntArray;
    }

    public int simpleSearch (int[] array, int searchedElement) throws IllegalArgumentException {
        for (int j = 0; j < array.length; j++) {
            if (array[j] == searchedElement) {
                return j;
            }
        }
        throw new IllegalArgumentException("No searched element found in selected array");
    }

    public MyClass(byte b, short s, int i, long l, float f, double d, String string, Integer integer) {
        this.b = b;
        this.s = s;
        this.i = i;
        this.l = l;
        this.f = f;
        this.d = d;
        this.string = string;
        this.integer = integer;
    }

    public MyClass() {

    }

    public void printInfo(){
        System.out.printf("byte is %d, short is %d, int is %d, long is %d, float is %5.2f, double is %5.2f, String is %s, Integer is %d",b,s,i,l,f,d,string,integer);
    }

    public boolean compare(byte that){return b == that;}

    public boolean compare(short that){return s == that;}

    public boolean compare(int that){return i == that;}

    public boolean compare(long that){return l == that;}

    public boolean compare(float that){return f == that;}

    public boolean compare(double that){return d == that;}

    public boolean compare(String that){return string.equals(that);}

    public boolean compare(Integer that){return integer.equals(that);}

    public int findCharNumberInAlphabet(char ch){

        for (int j = 0; j < abc.length; j++) {
            if (abc[j] == ch) {
                return j;
            }
        }
        return 0;
    }

}
