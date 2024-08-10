import java.util.Stack;//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String input ="  hsdhfgsh-35  ";
        System.out.println("number is " + extractNumber(input));
        System.out.println("number is " + extractNumber("  hsdhfgsh+34  "));
    }





    public static int extractNumber(String str){
        String num = "";
        boolean isNegative = false;
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            if (!Character.isDigit(aChar)) {
                if (aChar == '-') {
                    isNegative = true;
                }
                continue;
            }
            num += aChar;
        }
        if (isNegative) {
            return -Integer.parseInt(num);
        }
        return Integer.parseInt(num);
    }
}