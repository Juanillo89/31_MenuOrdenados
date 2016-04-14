package menuOrdenados;

/*
Menú: 
1.­ Introducir número entero. 
2.­ Listar números. 
3.­ Eliminar número. 
4.- Eliminar todos los números. 
5.­ Salir.
*/

import java.util.Scanner;

public class MenuOrdenados
{
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		int[] numeros = { Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE,
		Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE };
		int opcion = 0;
		int num;
		int cont = 0;
		boolean repetido;
		boolean encontrado;
		while(opcion != 5)
		{
			System.out.println("Menú:\n1.Introducir número entero.\n2.Listar números.\n3.Eliminar número.\n4.Eliminar todos los números.\n5.Salir.");
			opcion = sc.nextInt();
			switch(opcion)
			{
				case 1: // Introducir
					if(cont < 10)
					{
						System.out.print("Introduce número: ");
						num = sc.nextInt();
						encontrado = false;
						repetido = false;
						for(int i = 0; i < numeros.length && !repetido && !encontrado; i++)
						{
							if(num == numeros[i])
							{
								System.out.println("Número repetido.");
								repetido = true;
							}
							if(num < numeros[i] && !repetido)
							{
								for(int j = numeros.length - 2; j >= i; j--)
								{
									numeros[j + 1] = numeros[j];
								}	
								encontrado = true;
								numeros[i] = num;
								cont++;
							}
						}
					}
					else
					{
						System.out.println("Lista llena, borre antes un número.");
					}
				break;
				case 2: //Listar
					for(int i = 0; i < cont; i++)
					{
						System.out.println(numeros[i]);
					}
				break;
				case 3: //Eliminar
					System.out.print("Introduzca número a eliminar: ");
					num = sc.nextInt();
					encontrado = false;
					for(int i = 0; i < numeros.length && !encontrado; i++)
					{
						if(num == numeros[i])
						{
							for(int j = i; j < numeros.length - 1; j++)
							{
								numeros[j] = numeros[j + 1];
							}
							encontrado = true;
							System.out.println("Número eliminado.");
							cont--;						
						}
					}
					if(!encontrado)
					{
						System.out.println("El número no está en la lista.");
					}
				break;
				case 4: //Eliminar todos
					for(int i = 0; i < cont; i++)
					{					
						numeros[i] = Integer.MAX_VALUE;
					}
					cont = 0;
				break;
				case 5: // Salir
					System.out.println("Hasta luego.");
					break;
				default:
					System.out.println("Opción no válida.");
			}
		}
		sc.close();
		
	}
}

