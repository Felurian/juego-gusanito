package cositas;
import java.util.*;
public class Tablero 
{
	public int size = 4;
	public int matriz[][] = new int[size][size];
	
	Tablero() {
		llenaMatriz();
	}
	
	Tablero(Tablero t){ 		// copiar otro tablero
		int[][] m = t.matriz;
		for(int x=0; x < this.size; x++) {
			for(int y=0; y < this.size; y++) {
				this.matriz[x][y] = m[x][y];
			}
		}
	}
	
	public static void main(String[] args) 
	{ 
		Tablero m = new Tablero();
		m.matriz[2][2]=1;
		m.imprimeMatriz();
		
		
		//m.MovAbajo(0, 2);
		//List l = m.sucesor();
		//System.out.println("tablero sucesor 1:");
		//((Tablero)l.get(0)).imprimeMatriz();
		//System.out.println("tablero sucesor 2:");
		//((Tablero)l.get(1)).imprimeMatriz();
		//m.MovAbajo(0,2);
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
		for(int i=0; i<size ;i++)
		{
			for(int j=0; j<size ;j++)
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
	
	public void borraMatriz()
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
		int c = 0;
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				c += matriz[i][j];
			}
		}
		return c == 1;
	}
	
	public void ganar() {
		Tablero winner = null; 
		List<Tablero> s = this.sucesor();
		Tablero[] ts = (Tablero[]) s.toArray();
		for (Tablero tablero : ts) {
			if(tablero.winner()) {
				winner = tablero;
				break;
			}
				
		}
		winner.imprimeMatriz();
		System.out.println("ganamos!!!");
		
	}

}
