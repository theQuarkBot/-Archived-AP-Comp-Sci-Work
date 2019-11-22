package workbook_questions;

public class Runner {
    public static void main(String[] args) {
        P one = new P();
        System.out.println(one.fun());
        one.go();
        one.whoot();
        System.out.println(one + "\n\n");
        one = new Q();
        System.out.println(one.fun());
        one.go();
        one.whoot();
        System.out.println(one);
    }
}