package cn.msjava.coding;
/**
 * msJava
 *
 * @Description  剑指 Offer 05. 替换空格
 * @Date 2021-02-27
 */
public class Offer05 {

    public static String replaceSpace_01(String s){
        return s.replace(" ", "%20");
    }

    public static String replaceSpace_02(String s){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == ' ' ){
                sb.append("%20");
            }else {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    public static String replaceSpace_03(String s){
        int length = s.length();
        int spaceCount=0;
        for (int i = 0; i < length; i++) {
            if(s.charAt(i)==' '){
                spaceCount++;
            }
        }
        char[] array = new char[length + spaceCount*2];
        int size = 0;
        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                array[size++] = '%';
                array[size++] = '2';
                array[size++] = '0';
            } else {
                array[size++] = c;
            }
        }
        String newStr = new String(array, 0, size);
        return newStr;
    }


    public static void main(String[] args) {
        String s="I LOVE JAVA";
        String s1 = replaceSpace_01(s);
        String s2 = replaceSpace_02(s);
        String s3 = replaceSpace_03(s);
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
    }
}
