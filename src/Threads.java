import java.util.concurrent.Semaphore;

public class Threads extends Thread{
	
	private int ID;
	private Semaphore semaforo;
	
	public Threads(int ID, Semaphore semaforo) {
		this.ID = ID;
		this.semaforo = semaforo;
	}
	
	public void run() {
		int valor = ID % 2;
		switch (valor) {
			case 0 :
				sopa();
				break;
			case 1:
				lasanha();
				break;
			default:
				System.out.println("Erro!");
				break;
		}
	}
	
	public void sopa() {
		int tempo = (int) (Math.random() * 301) + 500;
		for (int i = 1; i <= 6; i++) {
			double percentual = tempo / 0.1;
			System.out.println(ID + " - " + percentual + "%");
		}
		System.out.println("Prato # " + ID + " pronto! (Sopa de cebola)");
		entrega();
	}
	
	public void lasanha() {
		int tempo = (int) (Math.random() * 601) + 600;
		for (int i = 1; i <= 6; i++) {
			double percentual = tempo / 0.1;
			System.out.println(ID + " - " + percentual + "%");
		}
		System.out.println("Prato # " + ID + " pronto! (Lasanha a Bolonhesa)");
		entrega();
		
	}
	
	public void entrega() {
		int tempo = 500;
		try {
			semaforo.acquire();
			Thread.sleep(tempo);
			System.out.println("Entrega do prato #" + ID + " finalizada.");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
	}
}
