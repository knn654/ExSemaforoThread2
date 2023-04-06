import java.util.concurrent.Semaphore;

public class Threads extends Thread {

	private int ID;
	private Semaphore semaforo;

	public Threads(int ID, Semaphore semaforo) {
		this.ID = ID;
		this.semaforo = semaforo;
	}

	public void run() {
		int valor = ID % 2;
		switch (valor) {
		case 0:
			try {
				sopa();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		case 1:
			try {
				lasanha();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			break;
		default:
			System.out.println("Erro!");
			break;
		}
	}

	public void sopa() throws InterruptedException {
		int tempo = (int) (Math.random() * 301) + 500;
		int tempoTotal = tempo / 10;
		int percentual = 0;
		for (int i = 0; i <= tempoTotal; i++) {
			if (i % 10 == 0) {
				percentual = 10 + percentual;
				System.out.println("Cozimento do prato #" + ID + ": " + percentual + "%");
			}
			Thread.sleep(100);
		}
		System.out.println("Prato # " + ID + " pronto! (Sopa de cebola)");
		entrega();
	}

	public void lasanha() throws InterruptedException {
		int tempo = (int) (Math.random() * 601) + 600;
		int tempoTotal = tempo / 10;
		int percentual = 0;
		for (int i = 0; i <= tempoTotal; i++) {
			if (i % 10 == 0) {
				percentual = 10 + percentual;
				System.out.println("Cozimento do prato #" + ID + ": " + percentual + "%");
			}
			Thread.sleep(100);
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
