import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task12 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(findFirstAndLastDomainWithRegex(str));
        String letter = sc.nextLine();
        LinkedList<String> mails = findAllDomainFromRegex(letter);
        System.out.println(mails.get(1));
    }

    public static String findFirstAndLastDomainWithRegex(String mail) {
        Pattern emailRegex = Pattern.compile(".+@([a-z]+)(\\.([a-z]+))+");
        Matcher matcher = emailRegex.matcher(mail);
        StringBuilder stringBuilder = new StringBuilder();
        if (matcher.matches()) {
            stringBuilder.append("First domain is: ").append(matcher.group(1)).append("; ");
            stringBuilder.append("last domain is: ").append(matcher.group(3)).append(".");
        }
        return stringBuilder.toString();
    }

    public static LinkedList<String> findAllDomainFromRegex(String string) {
        Pattern emailRegex = Pattern.compile("[\\S]+@[a-z]+(\\.[a-z]+)+");
        LinkedList<String> mails = new LinkedList<>();
        Matcher matcher = emailRegex.matcher(string);
        while (matcher.find()) {
            mails.add(matcher.group());
        }
        return mails;
    }
}
