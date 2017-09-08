package cositas;
import java.util.*;
public class Main 
{
	public int matriz[][] = new int[4][4];
	
	Main() {
		LlenaMatriz();
	}
	
	Main(int[][] mat){
		this.matriz = mat;
	}
	
	public static void main(String[] args) 
	{ 
		Main m = new Main();
		m.matriz[2][2]=0;
		m.ImprimeMatriz();
		
		m.MovAbajo(0,2);
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
		ImprimeMatriz();
		
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
		ImprimeMatriz();
		
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
		ImprimeMatriz();
		
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
		ImprimeMatriz();
		
	}
	public void Sucesor()
	{
		int x=matriz.length;
		int y=matriz[0].length;
		List<int[][]> l = new ArrayList<int[][]>();
		for(int i=0; i<x ;i++)
		{
			for(int j=0; j<y ;j++)
			{
				if(matriz[i][j]==0)//Esta? vacio
					continue;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void LlenaMatriz()
	{
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				matriz[i][j]=1;
			}
		}
	}
	
	public void ImprimeMatriz()
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

}
