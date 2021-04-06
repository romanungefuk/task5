import java.util.Arrays;
import java.util.Random;

public class Task5 {
    public static void main(String[] args) {

        TimeManager timeManager = new TimeManager();
        MyClass myClass = new MyClass();
        Random random = new Random();

/*  *********Задание 5.1.*********
        Расчет факториала
        Расчет последовательности чисел Фибонначи
        Геометрические фракталы
*/

        /*
         *********Задание 5.2.*********
         */

//    try {
//        countdownForInfinite(100);
//    } catch (StackOverflowError e) {
//        System.out.println("Переполнение стека вызовов");
//    }


//        countdownWithCondition(100);

        /*
         *********Задание 5.3.*********
         */

//        stackExample();
//        Пример стека вызовов с рекурсией - расчет факториала числа n.
//        Для расчета по алгоритму factorial(n)=n*factorial(n-1) стек вызовов строится таким образом, что сначала
//        считаются factorial(1)=1,factorial(2)=factorial(1)*2=1*2=2,factorial(3)=factorial(2)*3=2*3=6 и т.д. вплоть до
//        factorial(n)

        /*
         *********Задание 5.4.*********
         */
//        task54(timeManager);

        /*
         *********Задание 5.5.*********
         */


//        task55(timeManager, myClass, random);

        /*
         *********Задание 5.6.*********
         */

//        task56(timeManager, myClass);


    }

    private static void task56(TimeManager timeManager, MyClass myClass) {
        int[] intArray = myClass.setNewRandomIntArray(100, 100);
        int[] intArrayCopy = Arrays.copyOf(intArray, intArray.length);

        System.out.println(Arrays.toString(intArray));
        timeManager.setStartTime();
        Arrays.sort(intArray);
        timeManager.setEndTime();
        System.out.println("Сортировка стандартным методом Arrays.sort() заняла " + timeManager.getRunTime() + " нс");
        System.out.println(Arrays.toString(intArray));

        timeManager.setStartTime();
        mergeSort(intArrayCopy);
        timeManager.setEndTime();
        System.out.println("Сортировка рекурсивным слиянием заняла " + timeManager.getRunTime() + " нс");
        System.out.println(Arrays.toString(mergeSort(intArray)));
    }

    private static int[] mergeSort(int[] intArray) {
        int length = intArray.length;
        if (length < 2) {
            return intArray;
        }
        int middle = length / 2;
        return mergeArrays(mergeSort(Arrays.copyOfRange(intArray, 0, middle)), mergeSort(Arrays.copyOfRange(intArray, middle, length)));
    }

    private static int[] mergeArrays(int[] arr1, int[] arr2) {
        int[] mergedArray = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < mergedArray.length; i++) {
            mergedArray[i] = arr1[index1] < arr2[index2] ? arr1[index1++] : arr2[index2++];
            if (index1 == arr1.length) {
                System.arraycopy(arr2, index2, mergedArray, ++i, arr2.length - index2);
                break;
            }
            if (index2 == arr2.length) {
                System.arraycopy(arr1, index1, mergedArray, ++i, arr1.length - index1);
                break;
            }
        }
        return mergedArray;

    }

    private static void task55(TimeManager timeManager, MyClass myClass, Random random) {
        int searchKey;
        int searchPosition;

        int[] intArray = myClass.setNewRandomIntArray(100, 1000);
        System.out.println(Arrays.toString(intArray));
        Arrays.sort(intArray);
        System.out.println(Arrays.toString(intArray));
        searchKey = intArray[random.nextInt(100)];

        timeManager.setStartTime();
        searchPosition = Arrays.binarySearch(intArray, searchKey);
        timeManager.setEndTime();
        System.out.println(searchPosition + " - стандартный бинарный поиск занял " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        searchPosition = binarySearchWithRecursion(intArray, searchKey, 0, intArray.length);
        timeManager.setEndTime();
        System.out.println(searchPosition + " - рекурсивный бинарный поиск занял " + timeManager.getRunTime() + " нс");
    }

    private static int binarySearchWithRecursion(int[] intArray, int searchKey, int leftIndex, int rightIndex) {

        if (leftIndex > rightIndex) {
            return -1;
        }

        int middle = (leftIndex + rightIndex) / 2;

        if (intArray[middle] == searchKey) {
            return middle;
        } else if (searchKey < intArray[middle]) {
            return binarySearchWithRecursion(intArray, searchKey, leftIndex, middle - 1);
        } else {
            return binarySearchWithRecursion(intArray, searchKey, middle + 1, rightIndex);
        }

    }

    private static void task54(TimeManager timeManager) {
        long factorial;

        timeManager.setStartTime();
        factorial = factorialWithCycle(25);
        timeManager.setEndTime();
        System.out.println(factorial);
        System.out.println("Вычисление факториала числа 25 методом с циклом заняло " + timeManager.getRunTime() + " нс");

        timeManager.setStartTime();
        factorial = factorialWithRecursion(25);
        timeManager.setEndTime();
        System.out.println(factorial);
        System.out.println("Вычисление факториала числа 25 методом рекурсии заняло " + timeManager.getRunTime() + " нс");
    }

    private static long factorialWithRecursion(int n) {
        long factorial;
        if (n == 1) {
            return 1;
        } else {
            factorial = factorialWithRecursion(n - 1) * n;
        }
        return factorial;
    }

    private static long factorialWithCycle(int n) {
        long factorial = 1;
        if (n < 0) {
            throw new IllegalArgumentException("Факториал считается только для положительных чисел");
        } else if (n == 1 || n == 0) {
            return 1;
        } else {
            while (n > 1) {
                factorial *= n;
                n--;
            }
        }
        return factorial;
    }


    private static void stackExample() {
        method1();
    }

    private static void method1() {
        method2();
    }

    private static void method2() {
        StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTraceElements) {
            System.out.println(stackTraceElement.getMethodName());
        }
    }

    private static void countdownForInfinite(int n) {
        System.out.println(n);
        n--;
        countdownForInfinite(n);
    }

    private static void countdownWithCondition(int n) {
        System.out.println(n);
        n--;
        if (n >= 0) {
            countdownWithCondition(n);
        }
    }
}
