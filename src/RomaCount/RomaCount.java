package RomaCount;

import java.util.HashMap;
import java.util.Map;

public class RomaCount {

    private final Map<Integer, String> romaMap = new HashMap<Integer, String>();
    private int arabNumber = 0;
    private boolean isNegative = false;

    public RomaCount()
    {
        romaMap.put(1, "I");
        romaMap.put(2, "II");
        romaMap.put(3, "III");
        romaMap.put(4, "IV");
        romaMap.put(5, "V");
        romaMap.put(6, "VI");
        romaMap.put(7, "VII");
        romaMap.put(8, "VIII");
        romaMap.put(9, "IX");
        romaMap.put(10, "X");

        romaMap.put(20, "XX");
        romaMap.put(30, "XXX");
        romaMap.put(40, "XL");
        romaMap.put(50, "L");
        romaMap.put(60, "LX");
        romaMap.put(70, "LXX");
        romaMap.put(80, "LXXX");
        romaMap.put(90, "XC");
        romaMap.put(100, "C");
    }

    private int romaIntoArabConvert(String romaNumber)
    {
        for (Map.Entry<Integer, String> entry:romaMap.entrySet())
        {
            if (entry.getValue().equals(romaNumber))
            {
                arabNumber =  entry.getKey();
            }
        }
        return arabNumber;
    }

    private String getRomaNumber (int arabNumber)
    {
        //Проверяем, что результат не равен 0
        if (arabNumber == 0)
            return "В римском счислении нет нуля!";

        //Проверка пришло ли арабское число > 10
        //Если да, то разбиваем его на составляющие и склеиваем, согласно списку romaMap
        int first = 0;
        int second = 0;
        String romaNumber = "";

        if (arabNumber > 10)
        {
            first = arabNumber/10*10;
            second = arabNumber%10;

            if (second != 0)
                romaNumber = romaMap.get(first) + "" + romaMap.get(second);
            else
                romaNumber = romaMap.get(first);
        }
        else
            romaNumber = romaMap.get(arabNumber);

       if (isNegative)
           return ("-"+romaNumber);
       else
           return romaNumber;
    }

    //првоеряем, что число римское от I до X включительно
    //return flag = true, если римское
    //return false, если нет
    public boolean isItRoma (String temp)
    {
        for (int i = 1; i < 11; i++)
        {
            if (romaMap.get(i).equals(temp))
               return true;
        }
        return false;
    }

    public String division(String a, String b)
    {
        int left = romaIntoArabConvert(a);
        int right = romaIntoArabConvert(b);
        return getRomaNumber(left/right);
    }

    public String multiplication(String a, String b)
    {
        int left = romaIntoArabConvert(a);
        int right = romaIntoArabConvert(b);
        return getRomaNumber(left*right);
    }

    public String addition(String a, String b)
    {
        int left = romaIntoArabConvert(a);
        int right = romaIntoArabConvert(b);
        return getRomaNumber(left+right);
    }

    public String subtraction(String a, String b)
    {
        int left = romaIntoArabConvert(a);
        int right = romaIntoArabConvert(b);
        int result = left - right;

        if (result > 0 || result == 0)
            return getRomaNumber(result);
        else
        {
            isNegative = true;
            int positiveNumber = deleteMinus(result);
            return getRomaNumber(positiveNumber);
        }
    }

    //Вытаскиваем минус
    public int deleteMinus(int negativeNumber)
    {
        int positiveNumber = 0;
        String[] splitter = (negativeNumber+"").split("-");
        positiveNumber = Integer.parseInt(splitter[1]);
        return positiveNumber;
    }
}
