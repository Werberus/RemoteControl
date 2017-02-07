public class test {
    public static void main(String args[]) {
        String test = "qwer = rewq";

        char chars[] = test.toCharArray();
        char testch[] = {chars[0], chars[1], chars[2], chars[3]};

        if (test.matches("^qwer.*"))
            System.out.print(test);
    }
}
