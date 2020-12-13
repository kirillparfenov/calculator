import ArabCount.ArabCount;
import Console.Console;
import RomaCount.RomaCount;

public class Main {



    public static void main(String[] args) {

        final int ARAB = 0;
        final int ROMA = 1;

        boolean flag = false; //flag=1, когда строка пройдет проверку по всем условиям.

        int arabResult = 0;
        String romaResult = "";

        Console   console = new Console();
        ArabCount arabCount = new ArabCount();
        RomaCount romaCount = new RomaCount();

        //Получаем данные из консоли.
        //Переводим в массив символов для анализа.
        String userInput = console.userInput();
        char[] stringToCharArray = userInput.toCharArray();
        console.existence(stringToCharArray);

        for (char i:stringToCharArray)
        {
            //Перевод char в String для дальнейшего сравнения
            String temp = Character.toString(i);

            switch (temp)
            {
                case ("/"):
                    flag = console.checkNumbers(userInput, temp);

                    if (flag)
                        {
                            if (console.arabOrRoma() == ARAB) {
                                arabResult = arabCount.division(console.getArabLeft(), console.getArabRight());
                                console.printResult(arabResult);
                            }

                            else if (console.arabOrRoma() == ROMA) {
                                romaResult = romaCount.division(console.getRomaLeft(), console.getRomaRight());
                                console.printResult(romaResult);
                            }
                        }
                    break;

                case ("*"):
                    flag = console.checkNumbers(userInput, "\\*");
                    if (flag)
                    {
                        if (console.arabOrRoma() == ARAB) {
                            arabResult = arabCount.multiplication(console.getArabLeft(), console.getArabRight());
                            console.printResult(arabResult);
                        }

                        else if (console.arabOrRoma() == ROMA) {
                            romaResult = romaCount.multiplication(console.getRomaLeft(), console.getRomaRight());
                            console.printResult(romaResult);
                        }
                    }
                    break;

                case ("+"):
                    flag = console.checkNumbers(userInput, "\\+");
                    if (flag)
                    {
                        if (console.arabOrRoma() == ARAB) {
                            arabResult = arabCount.addition(console.getArabLeft(), console.getArabRight());
                            console.printResult(arabResult);
                        }

                        else if (console.arabOrRoma() == ROMA) {
                            romaResult = romaCount.addition(console.getRomaLeft(), console.getRomaRight());
                            console.printResult(romaResult);
                        }
                    }
                    break;

                case ("-"):
                    flag = console.checkNumbers(userInput, temp);
                    if (flag)
                    {
                        if (console.arabOrRoma() == ARAB) {
                            arabResult = arabCount.subtraction(console.getArabLeft(), console.getArabRight());
                            console.printResult(arabResult);
                        }

                        else if (console.arabOrRoma() == ROMA) {
                            romaResult = romaCount.subtraction(console.getRomaLeft(), console.getRomaRight());
                            console.printResult(romaResult);
                        }
                    }
                    break;
            }
        }
    }
}
