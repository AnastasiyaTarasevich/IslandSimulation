package org.example.menu;

import org.example.constants.Constants;
import org.example.initializer.IslandInitializer;

import java.util.Scanner;
public class Menu {


    public static void printStarter() {
        System.out.println("--------------------Добро пожаловать в симулцию жизни на острове!------------------");
        System.out.println("Введите начальные параметры или оставьте по умолчанию\n");


        Constants.setIslandSize(getIslandSize());
        Constants.setTimeForGrow(getTimeForPlants());
        Constants.setDaysWithoutFood(getTimeForAnimals());
        Constants.setCONDITION(getConditions());
        System.out.println("\nНачальное состояние острова\n");
        IslandInitializer app = IslandInitializer.getInstance(Constants.ISLAND_SIZE);
        app.displayInitialIsland();
        app.displayIsland();
    }
   public static int getIslandSize() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите размер острова  (или нажмите Enter для использования размера по умолчанию "+ Constants.ISLAND_SIZE+"*" +Constants.ISLAND_SIZE+"): ");

        String sizeS=scanner.nextLine();

        int number;
        if (sizeS.isEmpty()) {
            number = Constants.ISLAND_SIZE;
        } else {
            number = Integer.parseInt(sizeS);
        }
        return number;
    }
   public static int getTimeForPlants() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество дней для роста растенмй в каждой клетке  (или нажмите Enter для использования дней по умолчанию "+ Constants.TIME_FOR_GROW+"): ");

        String sizeS=scanner.nextLine();

        int number;
        if (sizeS.isEmpty()) {
            number = Constants.TIME_FOR_GROW;
        } else {
            number = Integer.parseInt(sizeS);
        }
        return number;
    }

  public   static int getTimeForAnimals() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите количество дней, которые животные могут выдержать без еды  (или нажмите Enter для использования дней по умолчанию "+ Constants.DAYS_WITHOUT_FOOD+"): ");

        String sizeS=scanner.nextLine();

        int number;
        if (sizeS.isEmpty()) {
            number = Constants.DAYS_WITHOUT_FOOD;
        } else {
            number = Integer.parseInt(sizeS);
        }
        return number;
    }

   public static int getConditions()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите условие остановки симуляции : ");
        System.out.println("1. Все животные мертвы");
        System.out.println("2. Остались только хищники");
        System.out.println("3. Осталось только два вида животных");

        int number = scanner.nextInt();

        return number;
    }
}
