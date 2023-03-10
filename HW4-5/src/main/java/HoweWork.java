import com.ibm.icu.text.RuleBasedNumberFormat;

import java.math.BigInteger;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import static java.lang.Integer.parseInt;
public class HoweWork {
    //[1,3999]
    public int romanToInt(String s) {
        int[] mass = new int[s.length()];
        for (int i = 0; i < mass.length; i++) {
            switch (s.toUpperCase().substring(i, i + 1)) {
                case "M":
                    mass[i] = 1000;
                    break;
                case "D":
                    mass[i] = 500;
                    break;
                case "C":
                    mass[i] = 100;
                    break;
                case "L":
                    mass[i] = 50;
                    break;
                case "X":
                    mass[i] = 10;
                    break;
                case "V":
                    mass[i] = 5;
                    break;
                case "I":
                    mass[i] = 1;
                    break;
            }
        }
        int number = 0;
        for (int i = 0; i < mass.length; i++) {
            if (i == (mass.length - 1)) {
                number = number + mass[i];
            } else if (mass[i] >= mass[i + 1]) {
                number += mass[i];
            } else if (mass[i] < mass[i + 1]) {
                number += (mass[i + 1] - mass[i]);
                i++;
            }
        }
        return number;
    }
    //[1,3999]
    public String intToRoman(int number) {
        String[] mass = String.valueOf(number).split("");
        String text = "";
        for (int i = 0; i < mass.length; i++) {
            switch (mass.length - i) {
                case 4:
                    for (int j = 0; j < parseInt(mass[i]); j++) {
                        text = text + "M";
                    }
                    break;
                case 3:
                    if (mass[i].contains("9")){
                        text = text + "CM";
                    }
                    if (Integer.parseInt(mass[i]) > 5 && Integer.parseInt(mass[i]) != 9){
                        text = text + "D";
                        for (int j = 0; j <Integer.parseInt(mass[i]) - 5; j++ ){
                            text = text + "C";
                        }
                    }
                    if (mass[i].contains("5")){
                        text = text + "D";
                    }
                    if (mass[i].contains("4")){
                        text = text + "CD";
                    }
                    if (Integer.parseInt(mass[i]) < 5 && Integer.parseInt(mass[i]) != 4){
                        for (int j = 0; j <Integer.parseInt(mass[i]); j++ ){
                            text = text + "C";
                        }
                    }
                    break;
                case 2:
                    if (mass[i].contains("9")){
                        text = text + "XC";
                    }
                    if (Integer.parseInt(mass[i]) > 5 && Integer.parseInt(mass[i]) != 9){
                        text = text + "L";
                        for (int j = 0; j <Integer.parseInt(mass[i]) - 5; j++ ){
                            text = text + "X";
                        }
                    }
                    if (mass[i].contains("5")){
                        text = text + "L";
                    }
                    if (mass[i].contains("4")){
                        text = text + "XL";
                    }
                    if (Integer.parseInt(mass[i]) < 5 && Integer.parseInt(mass[i]) != 4){
                        for (int j = 0; j <Integer.parseInt(mass[i]); j++ ){
                            text = text + "X";
                        }
                    }
                    break;
                case 1:
                    if (mass[i].contains("9")){
                        text = text + "IX";
                    }
                    if (Integer.parseInt(mass[i]) > 5 && Integer.parseInt(mass[i]) != 9){
                        text = text + "V";
                        for (int j = 0; j <Integer.parseInt(mass[i]) - 5; j++ ){
                            text = text + "I";
                        }
                    }
                    if (mass[i].contains("5")){
                        text = text + "V";
                    }
                    if (mass[i].contains("4")){
                        text = text + "IV";
                    }
                    if (Integer.parseInt(mass[i]) < 5 && Integer.parseInt(mass[i]) != 4){
                        for (int j = 0; j <Integer.parseInt(mass[i]); j++ ){
                            text = text + "I";
                        }
                    }
                    break;
            }
        }
        return text;
    }
    //?????????????? ?????????? ???? ?????????????????????
    public String palindrome(int number){
        String n = String.valueOf(number);
        int result = 0;
        StringBuilder stringBuilder = new StringBuilder();
        String N = String.valueOf(new StringBuilder(n).reverse());
        if (n.hashCode() != N.hashCode()){
            if(n.length() % 2 !=0) {
                n = n.substring(0, 1 + n.length() / 2) + String.valueOf(new StringBuilder(n).reverse().substring(n.length() / 2 + 1));
                if (Integer.parseInt(n) < number) {
                    n = n.substring(0, n.length() / 2) + String.valueOf(Integer.parseInt(n.substring(n.length() / 2, 1 + n.length() / 2)) + 1) + n.substring(1 + n.length() / 2);
                }
                result = Integer.parseInt(n);
            }
            else{
                n = n.substring(0,n.length()/2) + String.valueOf(new StringBuilder(n).reverse().substring( n.length() / 2 ));
                if (Integer.parseInt(n) < number) {
                    String r = String.valueOf(n.charAt(0));
                    for (int i = 1; i < n.length() - 1; i++){
                        r = r + (Integer.parseInt(String.valueOf(n.charAt(i))) + 1);
                    }
                    r = r + String.valueOf(n.charAt(n.length() - 1));
                    result = Integer.parseInt(r);
                }
                else {
                    result = Integer.parseInt(n);
                }
            }
            return "Can not buy.Not enough to palindrome: " + (result - number);
        }
        return "You can buy";
    }
    }
    //?????????????????? ?????????????????? ?????????????????? ?????????? ???? ??????????????, ?????? ???????? ?????? ???????????? ???????? ?????????????????????? ????????????????????????????????.
    public int factorial(int number){
        String[] mass = String.valueOf(number).split("");
        int sum = 1;
        for (int i = 0; i < mass.length; i++){
            sum = sum * Integer.parseInt(mass[i]);
        }
        return sum;
    }
    //?????????????? ???????????? ???????????? ?????????? (??????????????????????)
    public int reverse(int number){
        return Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf(number)).reverse()));
    }
//    ???????? ?????? ??????????????: [1, 2, 3, 2, 0] ?? [5, 1, 2, 7, 3, 2]
//    ???????? ?????????????? [1, 2, 2, 3] (?????????????? ??????????????)
//    ?????????????????? ??????????????????: ???????????? n^2, ???????????? 2n
    public Object[] mass(Integer[] m, Integer[] n){
        String text = Stream.concat(Arrays.asList(m).stream(),Arrays.asList(n).stream())
                .sorted()
                .filter(integer -> integer <= 3 && integer != 0)
                .collect(Collectors.toList()).toString().replaceAll("\\W","");
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < text.length(); i++){
            int parseInt = Integer.parseInt(String.valueOf(text.charAt(i)));
            if (!list2.contains(parseInt)){
                list2.add(parseInt);
            }
            if (list2.contains(parseInt) && parseInt == 2 && list2.size() == 2){
                list2.add(parseInt);
            }
        }
        Integer[] b = list2.toArray(new Integer[0]);
        return new String[]{Arrays.toString(b)};
    }
    //(-40 ???? 40)
    public String randomNumber(int start, int end, int size){
        double[] mass = new double[size];
        double scale = Math.pow(10, 1);
        double max = mass[0];
        double min = mass[0];
        for (int i = 0; i < size; i++){
            mass[i] = Math.ceil(((Math.random()*((end - start))) + start)*scale)/scale;
        }
        for (int i = 0; i < mass.length; i++){
            if (max < mass[i]){
                max = mass[i];
            }
            if (min > mass[i]){
                min = mass[i];
            }
        }
        return Arrays.toString(mass) + "\nMax: " + max +"\nMin: " + min;
    }
    //???????????? ?????????? ???????????? ???????????? ??? 14.2 (???????? ???????????? ???????? ????????????????????)
    public String run(double[] time){
        double bestTime = time[0];
        int number = 1;
        for (int i = 0; i < time.length; i++){
            if (bestTime > time[i]){
                bestTime = time[i];
                number = i + 1;
            }
        }
        return "The best time: " + bestTime + "\nWinner number: " + number;
    }
    //?????????? ????????????????
    public String numberText(int number){
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(Locale.forLanguageTag("en"),RuleBasedNumberFormat.SPELLOUT);
        return ruleBasedNumberFormat.format(number);
    }
    //FizzBuzz
    public List<Object> fizzBuzz(int start,int end){
        String fizz = "Fizz";
        String buzz = "Buzz";
        String fizzBuzz = "FizzBuzz";
        IntStream intStream = IntStream.range(start,end);
                List<Object> list = intStream.mapToObj(i->i).collect(Collectors.toList());
        list = list.stream().map(e->{
            boolean b = Integer.parseInt(String.valueOf(e)) % 3 == 0;
            boolean b1 = Integer.parseInt(String.valueOf(e)) % 5 == 0;
            if (b && b1){return fizzBuzz;}
            else if (b){return fizz;}
            else if (b1){return buzz;}
            return e;})
                   .collect(Collectors.toList());
        return list;
    }
    //???????? ???????????? ????????:
    //AAAABBBCCXYZDDDDEEEFFFAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBB
    //???????????????????? ???????????????? ???????????? ????????:
    //A4B3C2XYZD4E3F3A6B28
    //?????????????? ???????????????? ?????????? ???????????????? ???????????????????? ???????????????????????????????? ????????????????.
    //???? ???????????? ?????????????????? ?????????? + ?????? ????????????????????, ?????????? ??????????????
    public String line(String text){
        LinkedHashMap<String,Integer> map = new LinkedHashMap<>();
        List.of(text.split("")).forEach(e->map.merge(e,1,(prev,one)->prev+one));
        String result = "";
        ArrayList<Integer> values = new ArrayList<>(map.values());
        List<String> keys = new ArrayList<>(map.keySet());
        for (int i = 0; i < keys.size(); i++){
            result = result + keys.get(i);
            if (values.get(i) != 1){
                result = result + values.get(i);
            }
        }
        return result;
    }
//    ???????????????????? ???????????????? ???????????????????????????????????? ???????????????? ?????????????????????? ?????????? ???? ??????????????.
//    ???????????? [1, 5, 6, 8, 4, 9] -> [1-1, 4-6, 8-9]
    public String sequence(Integer[] mass){
        String text = "";
        List<Integer> list = List.of(mass).stream().sorted().toList();
        for (int i = 0; i < list.size(); i++){
            text = text + list.get(i);
            if (i != list.size()-1 && list.get(i + 1) - list.get(i) > 1){
                text = text + " ";
            }
        }
        String[] t = text.split(" ");
        for (int i = 0; i < t.length; i++){
            if (t[i].length() == 1){
                t[i] = (t[i].charAt(0) + "-" + t[i].charAt(0)).trim();
            }
            if (t[i].length() >= 2){
                t[i] = (t[i].charAt(0) + "-" + t[i].charAt(t[i].length()-1)).trim();
            }
        }
        return Arrays.toString(t);
    }
//    ?????????????????? ??????????????
//    "the-stealth-warrior" gets converted to "theStealthWarrior"
//    "The_Stealth_Warrior" gets converted to "TheStealthWarrior"
    public String toCamelCase(String s){
        String text = "";
        for (int i = 0; i < s.length(); i++){
            if (s.substring(i,i+1).equals("-") || s.substring(i,i+1).equals("_")){
                text = text + s.toUpperCase().substring(i+1,i+2);
                i++;
                continue;
            }
            else {
                text = text + s.substring(i, i + 1);
            }
        }
    return text;
    }
    //?????????????? ??????????
    public int countBits(int n){
        String result = "";
        int bite = 0;
        if (n == 0){
            result = "0";
        }
        while (n > 0) {
            if (n % 2 == 0) {
                result = result + 0;
                n /= 2;
                continue;
            }
            if (n % 2 != 0) {
                bite++;
                result = result + 1;
                n /= 2;
                continue;
            }
        }
        return bite;
    }
    //???????????????????????????? ????????????
    public String statistic(BigInteger[] mass){
        List<BigInteger> list = Arrays.asList(mass);
        BigInteger max = list.stream().max(BigInteger::compareTo).get();
        BigInteger min = list.stream().min(BigInteger::compareTo).get();
        return "\nMax: " + max + "\nMin: " + min;
    }
}

