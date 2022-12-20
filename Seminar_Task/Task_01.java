package Seminar_Task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Task_01
 */
public class Task_01 {

    static ArrayList fillArray(String s, ArrayList list) {
        list.add(s);
        return list;
    }

    public static void main(String[] args) {
        ArrayList<String> fio = new ArrayList<>(Arrays.asList("Иванов Иван Иванович 35 true", 
        "Петров Петр Петрович 38 true",
        "Чижов Сергей Андреевич 40 true",
        "Королева Надежда Игоревна 21 false",
        "Семенова Мария Петровна 28 false"));
        //ArrayList<String> fio = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        // while (sc.hasNextLine()) {
        //     String str = sc.nextLine();
        //     if (str.equals("quit")) {
        //         break;
        //     } else fillArray(str, fio);
        // }

        // int index = 0;
        int index = fio.size()-1;
        
        while (index >= 0) {
            int max_value = Integer.parseInt(fio.get(index).split(" ")[3]);
            int c = -1;
            for(int i = 0; i < index; i++) {
                int current = Integer.parseInt(fio.get(i).split(" ")[3]);
                if (current > max_value) {
                    c = i;
                    max_value = current;
                }
            }
            if (c != -1) {
                String strTemp = fio.get(index);
                fio.set(index, fio.get(c));
                fio.set(c, strTemp);
            }
            index --;
        }
        while (index >= 0) {
            boolean gender = true;
            index --;
        }

        for (String s : fio) {
            String tmp[] = s.split(" ");
            System.out.println(tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3] + " " + tmp[4]);
        }
    }
}
