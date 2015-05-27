package ru.domain.lesson2.ru.knaur.lesson.geekbrainsjava.java1.seabattle;

public class Game {
    public static Cell[][] cellsComputer = new Cell[10][10];
    public static Cell[][] cellsPlayer = new Cell[10][10];
    public static int scoreComputer = 0;



    public void start() {
        /*System.out.println("Введите свое имя: ");
        Scanner scanner = new Scanner(System.in);
*/
        Player player = new Player();
        //  System.out.println("Здравствуй, " + player.getName() + "!");
/*

        System.out.println("Если вы хотите играть в автоматическом режиме, нажмите 1, если в ручном - 2");
        Scanner scannerInt = new Scanner(System.in);


        if (scannerInt.nextInt() == 2)
            System.out.println("Пока ручной режим игры не реализованю Ждите обновлений! Начинается автоматическая игра");
        else System.out.println("Вы выбрали неверный вариант игры, начинаем автоматическую игру");
*/

        System.out.println("Начинаем игру");

        Field field = new Field();

        cellsComputer = field.setCells(cellsComputer); //вводим игровое поле компьютера
        cellsPlayer = field.setCells(cellsPlayer); //вводим поле игрока

        System.out.println("Корабли созданы");
        System.out.println();
        System.out.println("Поле расположено так:");

        //  printField(cellsComputer);

        cellsComputer = field.setShips(cellsComputer); //устанавливаем корабли на поле компьютера
       /* System.out.println();
        System.out.println("Введите координаты выстрела: (сначала буква, потом цифра)");*/

    }


}
