package by.training2019.autumn;

public class Strings {
    public static void main(String[] args) {
        /*
        * String equality examples.
        * */
        String str1 = "String #1";
        String str2 = "String #1";

        String str3 = new String("String #1");
        String str4 = new String("String #1").intern();

        String strArray1 = new String(new char[] {'s', 't', 'r', 'i', 'n', 'g'});
        String strArray2 = new String(new char[] {'s', 't', 'r', 'i', 'n', 'g'}, 0, 3);

        System.out.println("String pool: " + (str1 == str2));
        System.out.println("String pool: " + str1 == str2);
        System.out.println("String pool with new: " + (str1 == str3));
        System.out.println("String pool with new & intern: " + (str1 == str4));

        System.out.println("StrArray1: " + strArray1);
        System.out.println("StrArray2: " + strArray2);

        str1.concat(str2);
        System.out.println("String: " + str1);

        /*
        * StringBuilder and StringBuffer examples.
        * */
        StringBuffer strBuffer =  new StringBuffer(new String("Cat"));
        StringBuilder strBuilder = new StringBuilder(new StringBuilder("Dog"));

        System.out.println(strBuffer);
        System.out.println(strBuilder);


        strBuffer.append(" says Meow!");
        strBuilder.append(" says Bouw!");

        System.out.println("StringBuffer: " + strBuffer);
        System.out.println("StringBuilder: " + strBuilder);
    }
}
