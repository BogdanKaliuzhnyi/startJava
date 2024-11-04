package lesson_2;

public class GuessNumber {

    int magicNumber;
    public boolean isGuessed;

    GuessNumber() {
        magicNumber = (int) (Math.random() * 100) + 1;
        isGuessed = false;
        System.out.println("Загадано число от 1 до 100, попробуйте его угадать");
    }

    public void playGame(Player player) {
        if (player.getNumber() != magicNumber) {
            System.out.println(player.getNumber() + (player.getNumber() > magicNumber ? " больше " : " меньше ") +
                    "того, что загадал компьютер");
            System.out.println("Ход переходит к другому игроку");
            return;
        }
        System.out.println("Игрок " + player.getName() + " победил!");
        isGuessed = true;
    }
}
