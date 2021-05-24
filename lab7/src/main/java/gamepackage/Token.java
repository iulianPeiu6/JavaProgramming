package gamepackage;

import java.util.ArrayList;
import java.util.List;

public class Token {

    int firstNumber;

    int secondNumber;

    int value;

    public Token(int firstNumber, int secondNumber, int value) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.value = value;
    }

    public static List<Token> getDefaultTokenList(int n){
        List<Token> defaultTokens = new ArrayList<>();

        for (int i=0;i<n;i++)
            for (int j=i+1;j<n;j++){
                    Token token;
                    token = new Token(i + 1, j + 1, i + j + 2);
                    defaultTokens.add(token);
                }

        return defaultTokens;
    }

    @Override
    public String toString() {
        return "(" +
                firstNumber +
                ", " + secondNumber +
                ", " + value +
                ')';
    }

}
