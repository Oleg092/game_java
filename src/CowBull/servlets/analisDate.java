package CowBull.servlets;

import java.util.HashSet;

/**
 * Created by oleg on 28.03.18.
 */
public class analisDate {
    HashSet<Character> mySet = new HashSet<>();
    int k;
    int b;
    public analisDate() {

    }

    public boolean isCorrect(String num) {//проверка присылаемого пользователем числа
        //если пользователь прислал число, заполняем его цифрами множество
        for(int i = 0; i < 4; i++)
            if (Character.isDigit(num.charAt(i))) mySet.add(num.charAt(i));
        //далее проверка, если пользователь прислал несколько одинаковых цифр, или символы, отправляем на страницу error
        if (mySet.size() != 4) return false;
        else return true;
    }

    public String createNewNum() {//создание рандомного числа с 4 разными цифрами
        HashSet<Integer> mySet = new HashSet<>();
        int[] a = new int[4];
        while (mySet.size() != 4){
            mySet.clear();
            for (int i = 0; i < 4; i++) {
                a[i] = 0 + (int) (Math.random() * 10);
                mySet.add(a[i]);
            }
        }
        String newNum = "";
        for (int i = 0; i < 4; i++){
            newNum += Integer.toString(a[i]);
        }
        return newNum;
    }
    public int analisK(String num, String nump) { //сколько всего цифр угадано
        k = 0;
        System.out.println(num);
        System.out.println(nump);
        mySet.clear();
        for (int i = 0; i < 4; i++){//заполняем множество цифрами числа
            mySet.add(num.charAt(i));
            mySet.add(nump.charAt(i));
            System.out.println(num.charAt(i));
        }
        System.out.println(mySet.size());
        for (int i = 0; i < 4; i++){
            if (mySet.size() == i + 4)//если пользователь угадает, то размер мн-ва не изменится
                k = 4 - i;//чем меньше размер мн-ва, тем больше цифр угадано
        }
        return k;
    }

    public int analisB(String num, String nump){//сколько угаданных цифр стоят на своем месте
        b = 0;
        for (int i = 0; i < 4; i++){
            if (num.charAt(i) == nump.charAt(i))
                b++;
        }
        return b;
    }
}