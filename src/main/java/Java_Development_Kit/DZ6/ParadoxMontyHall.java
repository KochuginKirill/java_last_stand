package Java_Development_Kit.DZ6;
import java.util.Random;
public class ParadoxMontyHall{
    public void play(int input){
        int winsWithSwitch = 0;
        int winsWithStay = 0;
        int gamesToPlay = input;
        Random random = new Random();
        for(int plays = 0;plays < gamesToPlay; plays++ ){
            int[] doors = {0,0,0};
            doors[random.nextInt(3)] = 1;
            int botChoice = random.nextInt(3);
            int opened;
            do{
                opened = random.nextInt(3);
            }while(doors[opened] == 1 || opened == botChoice);
            winsWithStay += doors[botChoice];
            winsWithSwitch += doors[3 - botChoice - opened];
        }
        System.out.println("C изменением выбора " + winsWithSwitch + " побед.");
        System.out.println("Без " + winsWithStay + " побед.");
    }
}
