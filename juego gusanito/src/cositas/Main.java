package cositas;
import java.util.*;
public class Main 
{
	static int matriz[][] = new int[4][4];
	
	Main() {
		
	}
	
	public static void main(String[] args) 
	{ 
		LlenaMatriz();
		matriz[2][2]=0;
		ImprimeMatriz();
		System.out.print("Ingresa las coordenas");
		
		MovAbajo(0,2);
	}
	
	
	public static boolean vacio(int x, int y)
	{
		return matriz[x][y] == 0;
	}
	
	public static void MovDerecha(int x, int y)
	{
		//Falla si:
		if(y>1 || vacio(x,y) || vacio(x,y+1) || !vacio(x,y+2))
		//			actual		el comido		el nuevo
			return;//No se puede
		matriz[x][y+2]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x][y+1]=0;//El que se comi?
		ImprimeMatriz();
		
	}
	public static void MovIzquierda(int x, int y)
	{
		//Falla si:
		if(y<2 || vacio(x,y) || vacio(x,y-1) || !vacio(x,y-2))
		//			actual		el comido		el nuevo
			return;//No se puede
		matriz[x][y-2]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x][y-1]=0;//El que se comi?
		ImprimeMatriz();
		
	}
	public static void MovArriba(int x, int y)
	{
		//Falla si:
		if(x<2 || vacio(x,y) || vacio(x-1,y) || !vacio(x-2,y))
		//			actual		el comido		el nuevo
			return;//No se puede
		matriz[x-2][y]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x-1][y]=0;//El que se comi?
		ImprimeMatriz();
		
	}
	public static void MovAbajo(int x, int y)
	{
		//Falla si:
		if(x>1 || vacio(x,y) || vacio(x+1,y) || !vacio(x+2,y))
		//			actual		el comido		el nuevo
			return;//No se puede
		matriz[x+2][y]=1;//El nuevo
		matriz[x][y]=0;//El que se mueve(Donde estaba)
		matriz[x+1][y]=0;//El que se comi?
		ImprimeMatriz();
		
	}
	public static void Sucesor(int matriz[][])
	{
		int x=matriz.length;
		int y=matriz[0].length;
		List<int[][]> l = new ArrayList<int[][]>();
		for(int i=0; i<x ;i++)
		{
			for(int j=0; j<y ;j++)
			{
				if(matriz[i][j]==0)//Est? vacúŒ
					continue; //me lo salto
				if(matriz[i][j+1]==1 && matriz[i][j+2]==0)
				{
					
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void LlenaMatriz()
	{
		for(int i=0;i<matriz.length;i++)
		{
			for(int j=0;j<matriz.length;j++)
			{
				matriz[i][j]=1;
			}
		}
	}
	
	public static void ImprimeMatriz()
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
