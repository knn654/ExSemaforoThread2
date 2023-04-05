import java.util.concurrent.Semaphore;


public class Main {
public static Semaphore semaforo;
	
	public static void main(String[] args) {
		
		int totalPratos = 5;
		int maxPratos = 1;
		semaforo = new Semaphore(maxPratos);
		
		for (int i = 0; i < totalPratos; i++) {
			Thread iniciarCozimentos = new Threads(i, semaforo);
			iniciarCozimentos.start();
		}
	}
}
