package Console;

import ArabCount.ArabCount;
import RomaCount.RomaCount;

import java.util.Scanner;

public class Console {

    private int k;
    private int arabLeft;  //арабские цифры до символа операции
    private int arabRight; //арабские цифры после символа операции
    private String romaLeft; //римские цифры до символа операции
    private String romaRight;//римские цифры после символа операции
    //private String currentRoma = "";
    private int count = 0;

    boolean arab = false;
    boolean roma = false;

    RomaCount romaCount = new RomaCount();

    //Ввод данных пользователем
    public String userInput()
    {
        System.out.println("Введите строку");
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    //Проверяем наличие символа операции в введенной пользователем строки
    public void existence(char[] input)
    {
        String[] operations = {"+", "-", "*", "/"};
        int tempCount = 0;

        for (char charSymbol:input)
        {
            String stringSymbol = Character.toString(charSymbol).trim();
            for (int i = 0; i<operations.length; i++)
            {
                if (stringSymbol.equals(operations[i]))
                    tempCount++;
            }
        }
        if (tempCount==0)
        {
            System.out.println("Нет ни одного символа операции\nВыход из программы");
            System.exit(0);
        }
    }

    //Принимаем строку пользователя и символ операции.
    //Делаем split по символу операции.
    //Убираем пробелы.
    //Проверяем на арабские и римские цифры.
    //Проверяем, что цифры от 1 до 10.
    public boolean checkNumbers (String userInput, String oper)
    {

        String[] tokens = userInput.split(oper);

        //Если попадается римская цифра, то count++.
        //Если на выходе получаем count = 2, то работаем с римскими цифрами.
        //Если count = 1 - то в строке римские и арабские цифры - выход из программы.
        //Если count = 0, то в строке только арабские цифры.
        //В остальных случаях - throw exception
        for (int i = 0; i < tokens.length; i++)
        {
            String currentRoma = tokens[i].trim().toUpperCase();
            boolean romaCheck = romaCheck(currentRoma, i);

            if (!romaCheck)
            {
                try {
                    String currentArab = tokens[i].trim();
                    k = Integer.parseInt(currentArab);

                    if (k>0 && k<11 && i==0)
                        arabLeft = k;

                    else if (k>0 && k<11 && i==1)
                        arabRight = k;

                    else
                        throw new Exception("Число " + k + " должно быть от 1 до 10!");

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    return false;
                }
            }
        }

        switch(count)
        {
            case (0):
                arab = true;
                break;

            case (1):
                System.out.println("СМЕШАННЫЕ ЧИСЛА!");
                return false;

            case(2):
                roma = true;
                break;
        }
        return true;
    }

    //Только Арабские цифры от юзера - return 0
    //Только Римские цифры от юзера - return 1
    public int arabOrRoma()
    {
        if (arab)
            return 0;
        else
            return 1;
    }

    //Проверяем, что юзер ввел только римские числа
    private boolean romaCheck(String romaNumber, int i)
    {
        if (romaCount.isItRoma(romaNumber) && i == 0)
        {count++; romaLeft = romaNumber; return true;}

        else if (romaCount.isItRoma(romaNumber) && i == 1)
        {count++; romaRight = romaNumber; return true;}

        return false;
    }

    public void printResult(int arabResult)
    {
            System.out.println(arabResult);
    }

    public void printResult(String romaResult)
    {
        System.out.println(romaResult);
    }

    public int getArabLeft()
    {
        return arabLeft;
    }

    public int getArabRight()
    {
        return arabRight;
    }

    public String getRomaLeft()
    {
        return romaLeft;
    }

    public String getRomaRight()
    {
        return romaRight;
    }

}
