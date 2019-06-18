package utils;

public class UserInteractingHelper {

    private IOHelper ioHelper;

    public UserInteractingHelper(IOHelper ioHelper) {
        this.ioHelper = ioHelper;
    }

    public int takeUserChoice(int lowBorder, int highBorder) {

        while (true) {

            String answer = ioHelper.input("Enter your choice: ");

            try {
                int choice = Integer.parseInt(answer);

                if (checkUserChoice(choice, lowBorder, highBorder)) {

                    return choice;

                } else {
                    ioHelper.print("You should enter a correct number");
                }

            } catch (NumberFormatException e) {
                ioHelper.print("You should enter a correct number");
            }
        }
    }

    public boolean checkUserChoice(int choice, int lowBorder, int highBorder) {
        return choice >= lowBorder && choice <= highBorder;
    }

}
