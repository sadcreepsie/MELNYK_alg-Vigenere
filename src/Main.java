import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabetMap.put(c, c - 'A');
        }

        Scanner sc = new Scanner(System.in);
        System.out.print("Insert text to cryptate: ");
        String text = sc.nextLine();
        System.out.print("Insert code: ");
        String code = sc.nextLine();
        List<Character> textOr = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            char upperChar = Character.toUpperCase(text.charAt(i));
            textOr.add(upperChar);
        }
        List<Character> codeList = new ArrayList<>();
        for (int i = 0; i < code.length(); i++) {
            char upperChar = Character.toUpperCase(code.charAt(i));
            codeList.add(upperChar);
        }
        String textCrypted = "";
        Character charCrypted;
        int cnt = 0;
        for (int i = 0; i < text.length(); i++) {
            Character symOr = textOr.get(i);
            Character symCode;
            if (i > codeList.size() - 1) {
                if (cnt > codeList.size()-1){
                    cnt = 0;
                    symCode = codeList.get(cnt);
                }
                else {
                    symCode = codeList.get(cnt);
                }
                cnt++;
            }
            else {
                symCode = codeList.get(i);
            }
            int codeCrypt = alphabetMap.get(symCode) + alphabetMap.get(symOr);
            if (codeCrypt > 26){
                codeCrypt -= 26;
            }
            charCrypted = (char)('A' + codeCrypt);
            textCrypted += charCrypted;
        }
        System.out.println(textCrypted);
    }
}
