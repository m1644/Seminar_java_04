package Seminar_DZ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Task_02
 */
public class DZ_01 {

    static ArrayList<String> list_fname = new ArrayList<>();
    static ArrayList<String> list_lname = new ArrayList<>();
    static ArrayList<String> list_tname = new ArrayList<>();
    static ArrayList<Integer> list_age = new ArrayList<>();
    static ArrayList<Boolean> list_sex = new ArrayList<>();
    static List<Integer> linkedlist = new LinkedList<>();

    static void age() {
        int cnt = linkedlist.size()-1;
        while (cnt > -1) {
            int max_age = list_age.get(linkedlist.get(cnt));
            int index = cnt;
            for (int i = 0; i < cnt; i++){
                if (max_age < list_age.get(linkedlist.get(i))) {
                    max_age = list_age.get(linkedlist.get(i));
                    index = i;
                }
            }
            int tmp = linkedlist.get(cnt);
            linkedlist.set(cnt, linkedlist.get(index));
            linkedlist.set(index, tmp);
            cnt--;
        }
        linkedlist.forEach(
            i -> System.out.println(
                list_fname.get(i)+" "+list_tname.get(i)+" "+list_lname.get(i).toUpperCase().charAt(0)+". Age: "+list_age.get(i)+", Sex: "+list_sex.get(i)));
    }

    static void sex() {
        for (int j = 0; j < linkedlist.size(); j++) {
            if (list_sex.get(linkedlist.get(j))) {
                int tmpI = linkedlist.get(j);
                linkedlist.remove(j);
                linkedlist.add(0, tmpI);
            }        
        }
        linkedlist.forEach(j -> System.out.println(list_fname.get(j)+" "+list_tname.get(j)+" "+list_lname.get(j).toUpperCase().charAt(0)+". Age: "+list_age.get(j)+", Sex: "+list_sex.get(j)));
    }

    static void lname() {
        Collections.sort(list_lname);
        System.out.println(list_lname);  
    }

    static void putTo(String fio, int age, String gender) {
        list_age.add(age);
        String[] fio1 = fio.split(" ");
        list_fname.add(fio1[1]);
        list_lname.add(fio1[0]);
        list_tname.add(fio1[2]);
        if (gender.contains("М")) {list_sex.add(true);} else {list_sex.add(false);}
        linkedlist.add(list_age.size() - 1);
        System.out.println(fio + ". Age: " + age + ", Sex: " + gender);
    }

    public static void main(String[] args) {

        System.out.println("********** Вывод списка:");

        putTo("Иванов Иван Иванович", 21, "М");
        putTo("Иванова Ирина Ивановна", 20, "Ж");
        putTo("Петров Петр Петрович", 35, "М");
        putTo("Сидоров Сидр Сидрович", 22, "М");
        putTo("Зуева Марина Викторовна", 24, "Ж");
        putTo("Комова Светлана Петровна", 28, "Ж");
        putTo("Фёдоров Михаил Олегович", 44, "М");
        
        System.out.println();
        System.out.println("********** Сортировка по AGE:");
        age();
        System.out.println();
        System.out.println("********** Сортировка по SEX:");
        sex();
        System.out.println();
        System.out.println("********** Сортировка по lname:");
        lname();
    }
}
