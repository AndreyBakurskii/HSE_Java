import java.util.HashMap;
import java.util.Map;

public class Parser {
    private String str;
    private Map<Character, Integer> count_symbol = new HashMap<Character, Integer>();

    public Parser(String s){
        this.str = s;
    }

    public String getString() {
        return this.str;
    }

    public Map<Character, Integer> getCountSymbol() {
        return this.count_symbol;
    }

    public String getCountSymbolAsString() {
        String result = "";
        for (Map.Entry<Character, Integer> entry : count_symbol.entrySet())
            result += String.format("%s: %d\n", entry.getKey(), entry.getValue());

        return result;
    }

    private boolean in_alphabet(Character c){
//        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        return alphabet.indexOf(c) != -1;
    }

    public void setCountSymbolMap(){

        for (int i = 0; i < str.length(); i++){
            Character symbol = this.str.charAt(i);

            if (in_alphabet(symbol))
                if (!this.count_symbol.containsKey(symbol))
                    this.count_symbol.put(symbol, 1);

                else this.count_symbol.put(symbol, this.count_symbol.get(symbol) + 1);
        };

    }
}
