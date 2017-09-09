package cositas;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
public class Tablero 
{
	private final static int SIZE = 4;
	public int matriz[][] = new int[SIZE][SIZE];
	
	Tablero() {
		llenaMatriz();
		int r1 = ThreadLocalRandom.current().nextInt(0, SIZE);
		int r2 = ThreadLocalRandom.current().nextInt(0, SIZE);
		matriz[r1][r2] = 0;
	}
	
	Tablero(Tablero t){ 		// copiar otro tablero
		int[][] m = t.matriz;
		for(int x=0; x < SIZE; x++) {
			for(int y=0; y < SIZE; y++) {
				this.matriz[x][y] = m[x][y];
			}
		}
	}
	public static void main(String[] args) 
	{ 
		Scanner scanner = new Scanner(System.in);
		System.out.println("generando tablero aleatorio");
		Tablero m = new Tablero();
		System.out.println();
		m.imprimeMatriz();
		
		List<Tablero> g = m.ganar();
		if(g == null) {
			System.out.println("no existe ningun movimiento ganador!");
		} else {
			System.out.println("encontrada secuencia de movimientos ganadora!");
			for(int i =g.size()-1; i >= 0; i--) {
				g.get(i).imprimeMatriz();
			}
			System.out.println("Has ganado!!");
		}
		System.out.println("...Seguir jugando?");
		scanner.nextLine();
		main(args);
	}
	
	public boolean vacio(int x, int y)
	{
		return matriz[x][y] == 0;
	}
	public boolean puedeDerecha(int x, int y) {
		return !(y>1 || vacio(x,y) || vacio(x,y+1) || !vacio(x,y+2));
	}
	public  void MovDerecha(int x, int y)
	{
		if(!puedeDerecha(x,y))
			return;
		matriz[x][y+2]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x][y+1]=0;//El que se comi?
		//imprimeMatriz();
		
	}
	public boolean puedeIzquierda(int x, int y) {
		return !(y<2 || vacio(x,y) || vacio(x,y-1) || !vacio(x,y-2));
	}
	public  void MovIzquierda(int x, int y)
	{
		if(!puedeIzquierda(x,y))
			return;
		matriz[x][y-2]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x][y-1]=0;//El que se comi?
		//imprimeMatriz();
		
	}
	public boolean puedeArriba(int x, int y) {
		return !(x<2 || vacio(x,y) || vacio(x-1,y) || !vacio(x-2,y));
	}
	public  void MovArriba(int x, int y)
	{
		if(!puedeArriba(x, y))
			return;
		matriz[x-2][y]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x-1][y]=0;//El que se comi?
		//imprimeMatriz();
		
	}
	public boolean puedeAbajo(int x, int y) {
		return !(x>1 || vacio(x,y) || vacio(x+1,y) || !vacio(x+2,y));
	}
	public  void MovAbajo(int x, int y)
	{
		if(!puedeAbajo(x,y))
			return;
		matriz[x+2][y]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x+1][y]=0;//El que se comi?
		//imprimeMatriz();
		
	}
	public List<Tablero> sucesor()
	{
		//int x=matriz.length;
		//int y=matriz[0].length;
		List<Tablero> l = new ArrayList<Tablero>();
		for(int i=0; i<SIZE ;i++)
		{
			for(int j=0; j<SIZE ;j++)
			{
				if(matriz[i][j]==0) // cuadro vacio, no nos interesa
					continue;
				
				if(puedeIzquierda(i,j)){
					//System.out.println("izq");
					Tablero m2 = new Tablero(this); // creamos nueva matriz
					m2.MovIzquierda(i, j);
					l.add(m2);						// agregamos a la lista
				}
				if(puedeDerecha(i,j)){
					//System.out.println("der");
					Tablero m2 = new Tablero(this);
					m2.MovDerecha(i, j);
					l.add(m2);
				}
				if(puedeArriba(i,j)){
					//System.out.println("arr");
					Tablero m2 = new Tablero(this);
					m2.MovArriba(i, j);
					l.add(m2);
				}
				if(puedeAbajo(i,j)){
					//System.out.println("aba");
					Tablero m2 = new Tablero(this);
					m2.MovAbajo(i, j);
					l.add(m2);
				}
			}
		}
		return l;
	}
	

	public void llenaMatriz()
	{
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				matriz[i][j]=1;
			}
		}
	}
	
	public void borraMatriz() // no se usa
	{
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				matriz[i][j]=0;
			}
		}
	}
	
	public void imprimeMatriz()
	{
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				System.out.print(matriz[i][j]+"\t");
			}
			System.out.println();
			System.out.println();
		}
		System.out.println("\t ------------");
	}
	
	public boolean winner() {
		return contarUnos() == 1;
	}
	
	public int contarUnos() {
		int c = 0;
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				c += matriz[i][j];
			}
		}
		return c;
	}
	
	public List<Tablero> tablero2Lista() {
		List<Tablero> l = new ArrayList<Tablero>();
		l.add(this);
		return l;
	}
	public Tablero[] list2Array(List<Tablero> s) {
		return s.toArray(new Tablero[s.size()]);	// convertimos la lista en
												 	// arreglo de tamaño s.size()
	}
	public List<Tablero> ganar() {
		if(this.winner()) {
			return tablero2Lista();
		}
		List<Tablero> winner = null;
		List<Tablero> s = this.sucesor();
		Tablero[] ts = list2Array(s);
		for (Tablero tablero : ts) { // 1 vuelta por cada tablero en ts
			List<Tablero> ganador = tablero.ganar();
			if(ganador == null) // tablero no pudo ganar
				continue;
			winner = ganador;
			winner.add(this);
			break;
		}
		return winner;
		
	}
	public Tablero ganar2() { // no se necesita
		if(this.winner())
			return this;
		Tablero winner = null; 
		List<Tablero> s = this.sucesor();
		Tablero[] ts = (Tablero[]) s.toArray(new Tablero[s.size()]);
		for (Tablero tablero : ts) {
			Tablero ganador = tablero.ganar2();
			if(ganador == null)
				continue;
			winner = ganador;
			break;
		}
		return winner;
		
	}

}
