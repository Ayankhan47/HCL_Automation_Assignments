public class Q4_StringOperations {

    public static void main(String[] args) {
        String s1 = "  Hello Java World  ";
        String s2 = "hello java world";
        String s3 = "Java";

        System.out.println("Original string        : '" + s1 + "'");
        System.out.println("length()               : " + s1.length());
        System.out.println("isEmpty()              : " + s1.isEmpty());
        System.out.println("charAt(2)              : " + s1.charAt(2));
        System.out.println("toString()             : " + s1.toString());
        System.out.println("equals(s2)             : " + s1.equals(s2));
        System.out.println("compareTo(s2)          : " + s1.compareTo(s2));
        System.out.println("contains(\"Java\")       : " + s1.contains("Java"));
        System.out.println("indexOf('a')           : " + s1.indexOf('a'));
        System.out.println("lastIndexOf('a')       : " + s1.lastIndexOf('a'));
        System.out.println("startsWith(\"  Hello\")  : " + s1.startsWith("  Hello"));
        System.out.println("endsWith(\"World  \")    : " + s1.endsWith("World  "));
        System.out.println("matches(\"[a-z ]+\")     : " + s2.matches("[a-z ]+"));
        System.out.println("substring(2, 7)        : " + s1.substring(2, 7));
        System.out.println("toLowerCase()          : " + s1.toLowerCase());
        System.out.println("trim()                 : '" + s1.trim() + "'");
        System.out.println("replace('l', 'L')      : " + s1.replace('l', 'L'));

        System.out.print("split(\" \")             : ");
        String[] parts = s1.trim().split(" ");
        for (String p : parts) System.out.print("[" + p + "] ");
        System.out.println();

        System.out.println("join(\"-\", parts)       : " + String.join("-", parts));
        System.out.println("valueOf(123)           : " + String.valueOf(123));
        System.out.println("valueOf(true)          : " + String.valueOf(true));
        System.out.println("valueOf(3.14)          : " + String.valueOf(3.14));

        StringBuffer sf = new StringBuffer("Hello");
        sf.append(" Buffer");
        StringBuilder sb = new StringBuilder("Hello");
        sb.append(" Builder");
        System.out.println("\nStringBuffer           : " + sf);
        System.out.println("StringBuilder          : " + sb);
    }
}
