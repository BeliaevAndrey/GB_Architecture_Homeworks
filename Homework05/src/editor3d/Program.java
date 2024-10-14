package editor3d;

import editor3d.service.Editor3D;

import java.util.Scanner;

public class Program {

    /**
     * Необходимо разделить на горизонтальные уровни "Редактор 30 графики".
     * Один пользователь. Программа работает на одном компьютере без выхода в сеть.
     *
     * Что видит пользователь, как взаимодействует? (Панель загрузки, блок редактирования, блок просмотра).
     * Какие задачи можно делать - функции системы? (Загрузить 3D модель, рассмотреть 3D модель, создать новую,
     * редактировать вершины, текстуры, сделать рендер, сохранить рендер).
     * Какие и где хранятся данные? (файлы 3D моделей, рендеры. анимация .., в файловой системе компьютера).
     *
     * Предложить варианты связывания всех уровней - сценарии использования. 3-4 сценария.
     * Сквозная функция - создать новую 3D модель, сделать рендер для печати на принтере.
     *
     * ==================================================
     * Д/З добавить 1-2 функции к программе, e.g.: удаление/добавление текстуры/модели к проекту.
     */

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        Program p = new Program();
        Editor3D editor3D = new Editor3D();
        p.menu(editor3D);

    }


    void menu(Editor3D editor3D) {
        boolean flag = true;
        while(flag) {
            printMenu();
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Finishing. Bye!");
                            flag = false;
                            break;
                        case 1:
                            System.out.print("Input name of project file: ");
                            String fileName = scanner.nextLine();
                            editor3D.openProject(fileName);
                            System.out.println("Project opened successfully.");
                            break;
                        case 2:
                            System.out.println("Saving a project...");
                            break;
                        case 3:
                            editor3D.showProjectSettings();
                            break;
                        case 4:
                            editor3D.printAllModels();
                            break;
                        case 5:
                            editor3D.printAllTextures();
                            break;
                        case 6:
                            editor3D.renderAll();
                            break;
                        case 7:
                            System.out.print("Input model number: ");
                            if (scanner.hasNextInt()) {
                                int i = scanner.nextInt();
                                editor3D.renderModel(i);
                            } else {
                                System.out.println("Incorrect model number!");
                            }
                            break;
                        default: System.out.println("Incorrect menu number!");
                    }
                } catch (Exception e ) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Input correct menu number.");
                scanner.nextLine();
            }

        }
    }

    void printMenu() {
        System.out.println("*** МОЙ 30 РЕДАКТОР ***");
        System.out.println("=======================");
        System.out.println("1. Открыть проект");
        System.out.println("2. Сохранить проект");
        System.out.println("3. Отобразить параметры проекта");
        System.out.println("4. Отобразить все модели проекта");
        System.out.println("5. Отобразить все текстуры проекта");
        System.out.println("6. Выполнить рендер всех моделей");
        System.out.println("7. Выполнить рендер модели");
        System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
        System.out.print("Пожалуйста, выберите пункт меню: ");
    }

}


