import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class testTink004a6 {
    public static void main(String[] args) {


        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("C://test2.txt"));
            int a = scanner.nextInt();      //количество чисел на бумажке - в массив
            int count = scanner.nextInt();      //кол-во изменений

            System.out.println("change: " + count);
            scanner.nextLine();

            int sumOld = 0;
            int[] massivMain = new int[a];  //создали стартовый массив
            for (int i = 0; i < massivMain.length; i++) {
                massivMain[i] = scanner.nextInt();
                sumOld += massivMain[i];        //просуммировали стартовый массив
            }
            System.out.println("massiv to work = " + Arrays.toString(massivMain));

            //int[] massiv = {221, 599, 879};
            //int sumOld = 0;
            //for (int i = 0; i < massiv.length; i++) {
            //    sumOld += massiv[i];
            //}

            System.out.println(sumOld);
            int[] resultMassiv = new int[massivMain.length];
            System.out.println(Arrays.toString(massivMain));

            for (int k = 0; k < massivMain.length; k++) {
                int countCopy = count;
                int[] buffer = Arrays.copyOf(massivMain, massivMain.length); //скопировали в новый массив buffer исходный массив
                int length = String.valueOf(buffer[k]).length();    //нашли длинну числа k

                String text = String.valueOf(massivMain[k]);    //первое число из массива преобразовали в стринг
                //String text = String.join(", ", String.valueOf(massiv[0]).split(""));
                System.out.println(text);
                String[] text1 = text.split("");   //создали стринг массив и внесли строковые цифры посимвольно через сплит (разделение по "")
                System.out.println(Arrays.toString(text1));

                int[] massivBHOC = new int[length];    //создали массив инта для внесения с преобразованием строкового в инт
                for (int i = 0; i < length; i++) {
                    massivBHOC[i] = Integer.parseInt(text1[i]);  //вносим = преобразуем
                }
                System.out.println(Arrays.toString(massivBHOC));
                //счетчик изменений - перенести в сканнер, верхняя часть
                for (int i = 0; i < massivBHOC.length; i++) {
                    if (massivBHOC[i] != 9 && countCopy > 0) {      //блок с изменением, если первое число не 9 - заменить на 9 и уменьшить счетчик, если 9 - пропустить
                        massivBHOC[i] = 9;
                        countCopy--;
                    }
                }

                int m = 0;                //собрали цифры из массива в 1 число
                for (int d : massivBHOC) {
                    m = 10 * m + d;
                }
                buffer[k] = m;  //присвоили это число в k элемент массива buffer
                int sumNew = 0;
                System.out.println(m);
                for (int i = 0; i < buffer.length; i++) {

                    sumNew += buffer[i];    //просуммировали буффер массив с измененным k элементом
                }
                int sumBuffer = sumNew - sumOld;    //нашли разницу с суммой базового массива
                resultMassiv[k] = sumBuffer;        //занесли результат в результмассив
                System.out.println(Arrays.toString(buffer));
            }
            System.out.println(Arrays.toString(resultMassiv));

            //находим максимальное значение в резульмассиве - если только 1 изменение
//        int max = resultMassiv[0];
//        for (int i = 1; i < resultMassiv.length; i++) {
//            if (resultMassiv[i] > max) {
//                max = resultMassiv[i];
//            }
//        }
//        System.out.println(max);

            //но если изменениый больше чем 1 - тогда результмассив отсортировать и просуммировать то количество элементов, сколько дается попыток изменений
            Arrays.sort(resultMassiv);
            System.out.println(Arrays.toString(resultMassiv));

            if (count > resultMassiv.length) {       // если количество изменений больше релультмассива - уменьшить количство попыток до длины результмассива
                count = resultMassiv.length;
            }

            int max = 0;
            for (int i = resultMassiv.length - count; i < resultMassiv.length; i++) {
                max += resultMassiv[i];     //суммируем последние (максимальные) значения

            }
            System.out.println(max);


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
