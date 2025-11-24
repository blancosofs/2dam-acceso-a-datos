package ejerciciosAccesoDirecto;

public class fibo {

	public static void main(String[] args) {
		int serie = 10;
		int a=0, b=1;
		
		for (int i = 1; i <= serie; i++) {
			System.out.print(a+" ");
			
			int aux = a+b;
			a=b;
			b=aux;
		
		}
	}

}
