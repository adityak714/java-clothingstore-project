package logic_classes;

class MainEF1 {

    public static void main(String[] args) {
        StartMenu startMenu = new StartMenu();

        try {
            startMenu.putOption();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
}
