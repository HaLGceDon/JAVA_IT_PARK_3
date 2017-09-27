import java.util.Scanner;
class HomeWork1 {
	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
    int x = scanner.nextInt();
	int c = x/5000;
	x = x - (5000*c);
	int v = x/1000;
	x = x - (1000*v);
	int b = x/500;
	x = x - (500*b);
	int n = x/100;
	x = x - (100*n);
	int m = x/50;
	x = x - (50*m);
	int l = x/10;
	x = x - (10*l);
	int k = x/5;
	x = x - (5*k);
	int j = x/2;
	x = x - (2*j);
	int h = x/1;
	System.out.println("5000 - " +c+ ", 1000 - "+v+ ", 500 - "+b+ ", 100 - "+n+ ", 50 - "+m+ ", 10 - "+l+ ", 5 - "+k+ ", 2 - "+j+ ", 1 - "+h);
	}
}