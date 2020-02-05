import java.util.ArrayList;
import java.util.Scanner;

public class Project0001 {


    static int stb = 200;
    static int army_org = 140;
    static int ind = 50;
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
            com_add_into_country();
        } else {
            if (Variable2 == 0) {
                System.out.println("Вы убиты. Враг народа - товарищ " + name);
                return;
            }
        }
    }


    private static void com_add_into_country() {
        Scanner in = new Scanner(System.in);
        System.out.println("Отлично! Вы добавили коммунизм в Россию. Теперь страна называется - СССР");
        System.out.println("Теперь скажите партии , какой коммунизм будет . Есть два варианта:");
        System.out.println("В отдельно взятой стране - 1");
        System.out.println("Всемирная революция - 0");
        int Variable3 = in.nextInt();
        if (Variable3 == 1) {

            In_a_single_country(stb, respect, army_org, ind);
        } else {
            if (Variable3 == 0) {
//revolution();
            }
        }

    }


    private static void In_a_single_country(int stb, int respect, int army_org, int ind) {

        String[] Array01 = new String[]{
                "Провести индустриализацию (+20 очков к стабильности)- 1",
                "Убрать оппозицию (-10 очков к стабильности, +100 очков к репутации)- 2",
                "Объявить войну - 3", "Земельные реформы - 4",
                "Реформа в армии (-40 очков стабильности, + 20 к организации в армии) - 5",
                "Посмотреть состояние страны - 6"
        };
        System.out.println("Хороший выбор , партия одобрила ваше решение!");
        System.out.println("Приведем нашу страну к величию!");
        System.out.println("Что в начале хотите сделать?");
        for (int i = 0; i < Array01.length; i++) {
            System.out.println(Array01[i]);
        }
        Scanner in = new Scanner(System.in);
        int Variable4 = in.nextInt();
        if (Variable4 == 1) {
            System.out.println();
            System.out.println("Индустриализация проведена!(+20 очков к стабильности)");
            System.out.println();
            if (stb <= 500) {
                stb = stb + 20;
                In_a_single_country(stb, respect, army_org, ind);
            } else {
                In_a_single_country(stb, respect, army_org, ind);
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
                In_a_single_country(stb, respect, army_org, ind);
            } else {
                stb = stb + 0;
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind);
            }
            }
            if (Variable4 == 3) {
                declare_war(stb, respect, army_org, ind);
            }
            if (Variable4 == 6) {
                menu(stb, respect, army_org, ind);
            }


    }



    private static void menu( int stb, int respect, int army_org, int ind) {
        System.out.println();
        System.out.println("Стабильность     " + " " + stb);
        System.out.println("Репутация        " + " " + respect);
        System.out.println("Организация армии" + " " + army_org);
        System.out.println("Индустриализация " + " " + ind);
        System.out.println();

        In_a_single_country( stb,  respect, army_org, ind);

    }


    private static void declare_war (int stb, int respect, int army_org, int ind){

        System.out.println("Кому хотите объявить войну?");
        /*ArrayList countries = new ArrayList();
        countries.add(new Project0001("Польша"));
        countries.add(new ("Бегемот"));
        countries.add(new ("Бегемот"));
        countries.add(new ("Бегемот"));*/

        String[] Array02 = new String[]{"Польша", "Финляндия", "Королевство Румыния", "Турция"};
        for (int i = 0; i < Array02.length; i++) {
            System.out.println(Array02[i] + ", ");
            if (army_org >= 400 && ind > 300) {

            } else {
                System.out.println();
                System.out.println(ANSI_RED + "У вас недостаточно организации в армии (<400) и не достаточная индустриализация страны (<300)" + ANSI_RESET);
                System.out.println();
                In_a_single_country(stb, respect, army_org, ind);
            }
        }
    }
}

