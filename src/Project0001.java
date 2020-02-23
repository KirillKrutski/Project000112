import javafx.scene.chart.ValueAxis;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Project0001 extends JPanel {
    static int stb = 200;
    static int army_org =500;
    static int ind = 500;
    static int respect = 0;
    /*static int stbMax = 500;
    static int army_org_Max = 500;
    static int indMax = 500;
    static int respectMax = 500;*/
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите ваше имя , вождь !");
        String name = in.nextLine();
        System.out.println("Добро пожаловать в игру товарищ " + name);
        System.out.println("Чтобы начать игру нажмите 1 , если хотите выйти из программы нажмите 0");
        int Variable1 = in.nextInt();
        if (Variable1 == 1) {
            com_add(name);

        } else if (Variable1 == 0) {
            return;
        }
    }
    private static void com_add(String name) {
        Scanner in = new Scanner(System.in);
        System.out.println("Хотите добавить коммунизм в Россию? Введите если да - 1 , если нет - 0");
        int Variable2 = in.nextInt();
        if (Variable2 == 1) {
            com_add_into_country(name);
        } else {
            if (Variable2 == 0) {
                System.out.println("Вы убиты. Враг народа - товарищ " + name);
                return;
            }
        }
    }
    private static void com_add_into_country(String name) {

        Scanner in = new Scanner(System.in);
        System.out.println("Отлично! Вы добавили коммунизм в Россию. Теперь страна называется - СССР");
        System.out.println("Теперь скажите партии , какой коммунизм будет . Есть два варианта:");
        System.out.println("В отдельно взятой стране - 1");
        System.out.println("Всемирная революция - 0");
        int Variable3 = in.nextInt();
        if (Variable3 == 1) {
            In_a_single_country(stb, respect, army_org, ind , name);
        } else {
            if (Variable3 == 0) {
//revolution();
            }
        }
    }
    private static void In_a_single_country(int stb, int respect, int army_org, int ind , String name) {
        int l = 0;
        ArrayList<String> ChoiseList = new ArrayList<>();
        ChoiseList.add("Провести индустриализацию (+20 очков к стабильности)- 1");
        ChoiseList.add("Убрать оппозицию (-10 очков к стабильности, +100 очков к репутации)- 2");
        ChoiseList.add("Объявить войну - 3");
        ChoiseList.add("Земельные реформы - 4");
        ChoiseList.add( "Реформа в армии (-40 очков стабильности, + 20 к организации в армии) - 5");
        ChoiseList.add("Посмотреть состояние страны - 6");
//ChoiseList.add("Провести индустриализацию (+20 очков к стабильности)- 1");
/*String[] Array01 = new String[]{
"Провести индустриализацию (+20 очков к стабильности)- 1",
"Убрать оппозицию (-10 очков к стабильности, +100 очков к репутации)- 2",
"Объявить войну - 3", "Земельные реформы - 4",
"Реформа в армии (-40 очков стабильности, + 20 к организации в армии) - 5",
"Посмотреть состояние страны - 6"
};*/
        System.out.println("Хороший выбор , партия одобрила ваше решение!");
        System.out.println("Приведем нашу страну к величию!");
        System.out.println("Что в начале хотите сделать?");
/*for (int i = 0; i < Array01.length; i++) {
System.out.println(Array01[i]);
}*/
        for (int i = 0; i<ChoiseList.size();i++)
            System.out.println(ChoiseList.get(i));
        Scanner in = new Scanner(System.in);
        int Variable4 = in.nextInt();
        if (Variable4 == 1) {
            System.out.println();
            System.out.println("Индустриализация проведена!(+20 очков к стабильности , +50 очков к индустриализации)");
            System.out.println();
            if (stb <= 500) {
                stb = stb + 20;
                In_a_single_country(stb, respect, army_org, ind , name);
            } else {
                In_a_single_country(stb, respect, army_org, ind, name);
            }
            if (ind <= 500){
                ind = ind + 50;
                In_a_single_country(stb, respect, army_org, ind, name);
            } else {
                In_a_single_country(stb, respect, army_org, ind, name);
            }
        }
        if (Variable4 == 2) {
            System.out.println();
            System.out.println("Оппозиция убрана (-10 очков к стабильности, +100 очков к репутации)");
            System.out.println();
            if (stb <= 500) {
                stb = stb - 10;
            }
            if (respect <= 500) {
                respect = respect + 100;
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind, name);
            } else {
                respect = respect + 0;
                stb = stb + 0;
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind, name);
            }
        }
        if (Variable4 == 3) {
            declare_war(stb, respect, army_org, ind , name);
        }
        if (Variable4 == 6) {
            menu(stb, respect, army_org, ind, name);
        }
        if (Variable4 == 5) {
            if (army_org <= 500){
                army_org = army_org + 20;
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind, name);
            } else {
                army_org = army_org + 0;
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind, name);
            }
        }

        if (Variable4 == 4 && l == 0){

            land_reforms(name, l);


        } else if (Variable4 == 4 && l == 1){
            System.out.println();
            System.out.println(ANSI_RED + "Вы уже провели земельную реформу!" + ANSI_RESET);
            System.out.println();
            In_a_single_country(stb, respect, army_org, ind, name);
        }
    }
    private static void land_reforms(String name , int l) {
        l++;
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println(ANSI_RED + "Помните , что земельные реформы изменяются только один раз" + ANSI_RESET);
        System.out.println(ANSI_RED + "!Выбор кардинально влияет на дальнейшие события в игре!" + ANSI_RESET);
        System.out.println();
        System.out.println("Земельные реформы:");
        System.out.println("1.Коллективизация");
        System.out.println("2.Частная эксплуатация");
        int Variable5 = in.nextInt();
        if (Variable5 == 1){
            System.out.println();
            System.out.println("Коллективизация проведена, +100 очков к стабильности");
            System.out.println();
            if (stb <= 400) {
                stb = stb + 100;
                In_a_single_country(stb, respect, army_org, ind, name);
            } else {
                stb = stb + (500 - stb);
                In_a_single_country(stb, respect, army_org, ind, name);
            }
        }
    }
    private static void menu( int stb, int respect, int army_org, int ind, String name) {
        System.out.println();
        System.out.println("Стабильность " + " | " + stb);
        System.out.println("Репутация " + " | " + respect);
        System.out.println("Организация армии" + " | " + army_org);
        System.out.println("Индустриализация " + " | " + ind);
        System.out.println();
        In_a_single_country( stb, respect, army_org, ind , name);
    }
    private static void declare_war (int stb, int respect, int army_org, int ind , String name){
        System.out.println("Кому хотите объявить войну?");
        ArrayList<String> countryList = new ArrayList<>();
        countryList.add("Польша");
        countryList.add("Финляндия");
        countryList.add("Естонская республика");
        countryList.add("Латвийская республика");
        countryList.add("Литовская республика");
        countryList.add("Королевство Румыния");
        countryList.add("Турция");
        countryList.add("Иран");
        countryList.add("Афганистан");
        countryList.add("Манжоу-го (марионетка Японской империи)");
        if (army_org >= 400 && ind > 300) {
            for (int i = 0; i<countryList.size();i++)
                System.out.println(countryList.get(i));
            System.out.println("Введите название страны, которой вы ,товарищ " + name + " , хотите объявить войну.");
            Scanner nameCountry = new Scanner(System.in);
            String nc = nameCountry.nextLine();
            for (int i = 0;i<countryList.size();i++) {
                if (countryList.get(i).equals(nc)) {
                    System.out.println("Вы объявили войну " + countryList.get(i));
                    countryList.remove(i);
                    declare_country(respect , nc , army_org);
                }
            }
            nameCountry.close();
        } else {
            System.out.println();
            System.out.println(ANSI_RED + "У вас недостаточно организации в армии (<400)" +
                    " и не достаточная индустриализация страны (<300)" + ANSI_RESET);
            System.out.println();
            In_a_single_country(stb, respect, army_org, ind , name);
        }
    }
    private static void declare_country(int respect , String nc , int army_org) {
        System.out.println();
        System.out.println("Ведутся боевые действия");
        int a = (int) Math.random()*2;
        if (a == 0){
            System.out.println("Вы победили! Что хотите сделать с пораженным государством?");
            choose0001(nc, army_org);
        }
        if (a == 1){
            System.out.println(ANSI_RED + "Вы проиграли! Репутация -100!" + ANSI_RESET);
            respect = respect - 100;
        }
    }
    private static void choose0001(String nc,int army_org) {
        System.out.println();
        System.out.println("Аннексировать территорию(присоеденить) - 0");
        System.out.println("Сделать марионеточным государством - 1");
        Scanner in = new Scanner(System.in);
        int Variable6 = in.nextInt();
        if (Variable6 == 0){
            System.out.println();
            System.out.println("Вы аннексировали " + nc);
            army_org = army_org - 50;
        }
        if (Variable6 == 1){
            System.out.println();
            System.out.println("Вы сделали марионеточное государство " + nc);
            army_org = army_org - 10;
        }
    }
}