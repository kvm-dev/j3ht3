package ru.geekbrains.j3ht3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class j3ht3 {

    public static void main(String[] args) {
try {
    //для теста можно расскоментить соответствуюую задачу
    //task1();
    //task2();
    //task3();
}
catch (Exception e){
    e.printStackTrace();
}

    }
//задача 1 читаем файл около 50 байт (получилось чуть больше) в байтовый массив, выводим в консоль
    public static void task1() throws IOException {
        BufferedInputStream input = new BufferedInputStream(new FileInputStream("task1.txt"));
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int x;
        while((x = input.read()) != -1) {
            output.write(x);
        }
        byte[] b = output.toByteArray();
        System.out.println(Arrays.toString(b));
        input.close();
        output.close();
    }

    // задача 2 сшить 5 файлов в один
    public static void task2() throws IOException {
        ArrayList<InputStream> al = new ArrayList<>();

        for (int i = 1; i < 6; i++) {
            al.add(new FileInputStream("task2file" +i + ".txt"));
        }
        BufferedInputStream input = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        int x;
        while((x = input.read()) != -1) {
            System.out.print((char)x);
        }
        input.close();
    }
    //задача 3 - консольное приложение - будет просто методом, умеем читать файлы постранично, с учетом, что страница 1800 символов
    public static void task3() throws IOException {
        long startTime = System.currentTimeMillis(); //замеряем время
        final int PAGE_SIZE = 1800;
        RandomAccessFile raf = new RandomAccessFile("book.txt", "r");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter page:");
        int page = scanner.nextInt() - 1;
        raf.seek(page * PAGE_SIZE);
        for (int i = 0; i < PAGE_SIZE; i++) {
            System.out.print((char)raf.read());

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Total execution time: " + (endTime-startTime) + "ms");
        raf.close();
    }
    }
