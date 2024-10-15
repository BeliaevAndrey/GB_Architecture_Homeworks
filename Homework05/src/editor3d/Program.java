package editor3d;

import editor3d.service.Editor3D;
import editor3d.service.ModelEditor;
import editor3d.service.TextureEditor;

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
                        case 8:
                            ModelEditor me = new ModelEditor(
                                    editor3D.getBusinessLogicalLayer());
                            TextureEditor te = new TextureEditor(
                                    editor3D.getBusinessLogicalLayer());
                            modelEditorMenu(me, te);
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

    void modelEditorMenu(ModelEditor modelEditor, TextureEditor textureEditor) {
        boolean flag = true;
        while(flag) {
            printModelEditorMenu();
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Going back to main menu.");
                            flag = false;
                            break;
                        // "1. Add model"
                        case 1: modelEditor.createModel(); break;
                        // "2. Edit model"
                        case 2:
                            System.out.print("Input model number: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                modelEditor.editModel(modelNo);
                            } else {
                                System.out.println("Incorrect model number!");
                            }
                            break;
                        // "3. Add texture"
                        case 3:
                            textureEditor.createTexture();
                            break;
                        // "4. Remove model"
                        case 4:
                            System.out.print("Input model number: ");
                            if (scanner.hasNextInt()) {
                                int modelNo = scanner.nextInt();
                                if (modelEditor.removeModel(modelNo)) System.out.println("Model removed");
                            } else {
                                System.out.println("Incorrect model number!");
                            }
                            break;
                        // "5. Remove Texture"
                        case 5:
                            System.out.print("Input texture number: ");
                            if (scanner.hasNextInt()) {
                                int textureNo = scanner.nextInt();
                                if (textureEditor.removeTexture(textureNo)) System.out.println("Texture removed.");;
                            } else {
                                System.out.println("Incorrect texture number!");
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

        System.out.println("*** MY 3D EDITOR ***");
        System.out.println("=======================");
        System.out.println("1. Open project");
        System.out.println("2. Save project");
        System.out.println("3. Display project parameters");
        System.out.println("4. Show all project models");
        System.out.println("5. Show all project textures");
        System.out.println("6. Render all models");
        System.out.println("7. Render a model");
        System.out.println("8. Model editor");
        System.out.println("0. EXIT APPLICATION");
        System.out.print("Choose menu point, please: ");

    }

    void printModelEditorMenu() {

        System.out.println("*** MODEL EDITOR ***");
        System.out.println("=======================");
        System.out.println("1. Add model");
        System.out.println("2. Edit model");
        System.out.println("3. Add texture");
        System.out.println("4. Remove model");
        System.out.println("5. Remove texture");
        System.out.println("0. BACK TO MAIN MENU");
        System.out.print("Choose menu point, please: ");

    }

}
