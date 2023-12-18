package Algor;
import java.util.ArrayList;
import java.util.Scanner;
public class Mapas {

private static int
salas, bifur, salasrestantes, ramificaciones,contador=0,
SalaN = (int)(Math.random() * 26+6),
diviN = (int)(Math.random() * 2+2),
bifurN= (int)(Math.random() * (diviN+(SalaN/diviN))),
ramN =  (int)(Math.random() * diviN+(bifurN/diviN)),
espacioN = (int)(Math.random() * 2+1),
bifurR = 0,ramificacionesA=0, ramificacionesB=0,bifurY=0, bifurX=0;

private static ArrayList <String> mapa= new ArrayList<String>();
private static ArrayList <Integer> coordenadasBifur= new ArrayList<Integer>();
private static int ultimaPosicionDeUno = UltimaPosicion(coordenadasBifur);
public static void main(String[]args) {
	menu();
}
	private static void menu() {
	Scanner sc= new Scanner (System.in);
	int op;
	do {
		System.out.println("1:Salas\n2:Bifurcaciones\n3:Ramificaciones\n4:Generar Mapa\n5:Salir");
		op=sc.nextInt();
		switch (op) {
		case 1:
			System.out.println("Introduzuca el numero de salas\n(Simpre mayor al numero de bifurcaciones)");
			salas();
			break;
		case 2:
			System.out.println("Introduzca el numero de bifurcaciones");
			bifurncaciones();
			break;
		case 3:
			System.out.println("Introduzca el numero de ramificaciones");
			ramificaciones();
			break;
		case 4:
			generar();
			break;
		case 5:
			System.out.println("Saliendo del programa");
			sc.close();
			break;
		default:
			System.out.println("Opción Invalida");
		}
}while(op!=4);
}
	private static void generar() {
if(bifur>salas) {
	System.out.println("ERROR 01:Las bifuraciones no pueden ser mayor a las salas");
	}else if (bifur==salas) {
		System.out.println("ERROR 02:Las bifuraciones no pueden igual a las salas");
	}else{
		System.out.println("Generando...");
		
				mapa.add(habitación());
				mapa.add(generarPasilloY());
				mapa.add(generarBifuraciones());
				mapa.add(generarRamificaciones());
			
		
	}
	System.out.println(bifurN+"BifurN");
	System.out.println(diviN+"Divisor");
	System.out.println(salas+"S");
	System.out.println(salasrestantes+"S.R");
	System.out.println(bifurR+"R");
	System.out.println(bifurY+"Y");
	System.out.println(bifurX+"X");
	System.out.println("Mapa Generado");
	for(int i=0;i<mapa.size(); i++) {
		System.out.print(mapa.get(i));
	}
}
	private static void bifurncaciones() {//hay un bug que cuando se pueda hay que solucionarlo
		Scanner sc= new Scanner(System.in);
		bifur=sc.nextInt();
		if (bifur>0) {
			salasrestantes=salas-(bifur+ramificaciones);
			bifurR=bifur-salasrestantes;
			if(bifurR>bifur || bifurR<0) {
				bifurR=0;
				for(int i=0;i<bifur;i++) {
					int desicion =(int)(Math.random()*2+1);  
					switch (desicion) {
					case 1:
						bifurY++;
						break;
					case 2:
						bifurX++;
						//Hay un bug prioritario, cuando son todos bifurX, no habran nunca bifur
						break;
					}
				}
			}else {
				for(int i=0;i<bifur;i++) {
					int desicion =(int)(Math.random()*2+1);  
					switch (desicion) {
					case 1:
						bifurY++;
						break;
					case 2:
						//Hay un bug prioritario, cuando son todos bifurX, no habran nunca bifur
						bifurX++;
						break;
					}
				}
			}

		}else if (bifur==0){
			salasrestantes=salas-(bifur+ramificaciones);
		}
		bifurY=2;
		bifurX=5;
	}
	private static void ramificaciones() {//hay un bug que cuando se pueda hay que solucionarlo
		Scanner sc= new Scanner(System.in);
		ramificaciones=sc.nextInt();
		for(int i=0;i<ramificaciones;i++) {
			int  n =(int)(Math.random() *2+1);      
			switch (n) {
			case 1:
				ramificacionesA++;
				break;
			case 2:
				//Hay un bug potencial, cuando los tipoB>bifur, exsistira (la posibilidad) una sala aislada
				ramificacionesB++;
				break;
			}    
}
System.out.println(ramificacionesA+"A");
System.out.println(ramificacionesB+"B");
}
	private static void salas() {
	Scanner sc= new Scanner(System.in);
	salas=sc.nextInt();
}
	private static String generarRamificaciones() {
	StringBuilder pasilloXString = new StringBuilder();
	//Imprime las ramificaciones ahora hay que decidir donde se imprimen si al lado o debajo
	//Pasillo y habitacion de abajo
	for (int j=0; j<3; j++) {
		for (int i =0; i< ramificacionesB; i++) {
			pasilloXString.append(" # ");
			pasilloXString.append("   ");
			contador=contador+6;
		}
	pasilloXString.append("\n");
	}
	for (int i =0; i<3; i++) {

		for (int j =0; j< ramificacionesB; j++) {
			pasilloXString.append("***");
			contador=contador+3;
			if(j==ramificacionesB+1) {
			}else {
				pasilloXString.append("   ");
				contador=contador+3;
			}
		}
	pasilloXString.append("\n");
	}        
	System.out.print(pasilloXString.toString());
	System.out.println(contador);    
	return pasilloXString.toString();
}
	private static String pasilloY () {
	StringBuilder pasilloY = new StringBuilder();
	contador++;
	for (int i =0; i< 1; i++) {
		pasilloY.append(" # ");
		if (i==salasrestantes-1) {                
		}else {
			pasilloY.append("   ");
			contador=contador+6;
		}

	}
	return pasilloY.toString();
}
	private static String BifurcacionEspacio() {
	StringBuilder EspacioBifurcacion = new StringBuilder();
	contador++;
	for (int i =0; i< 1; i++) {
		EspacioBifurcacion.append("   ");
			if (i==salasrestantes-1) {                
			}else {
				EspacioBifurcacion.append("   ");
				contador=contador+6;
			}

		}
	return EspacioBifurcacion.toString();
}
	private static String generarPasilloY() {//Pendiente de revisión
	StringBuilder pasilloYString = new StringBuilder();
	//Imprime los pasillos de abajo dependiendo de las bifurcaciones            
	if(bifurY>0) {
		for (int i=0;i<bifurY;i++) {
		espacioN = (int)(Math.random() * 2+1);
		System.out.println(espacioN+"EspacioN");
		switch (espacioN) {//Decide que lugares tendra un pasillo o no tendran
		case 1:
			coordenadasBifur.add(espacioN);
			break;
		case 2:
			coordenadasBifur.add(espacioN);
			break;
		}
	}
	ultimaPosicionDeUno = UltimaPosicion(coordenadasBifur);
	for (int j=0;j<3;j++) {//Tamaño del pasillo (3 de largo)
		int tamañoNuevo=coordenadasBifur.size()-ultimaPosicionDeUno;
		for(int i=0;i<=coordenadasBifur.size()-tamañoNuevo;i++) {
			switch (coordenadasBifur.get(i)) {
			//Imprime los lugares tendra un pasillo o no tendran
			case 1:
				pasilloYString.append(pasilloY()); 
				break;
			case 2:
				if(bifurY==1	) {
					pasilloYString.append(pasilloY());
				}else {
					pasilloYString.append(BifurcacionEspacio());
				}
				break;
			}
			}
	pasilloYString.append("\n");
	}
}
	return pasilloYString.toString();
}
	private static String generarBifuraciones() {//Cuando las bifur son espacio hay que convertirlos en ramificaciones para que no se pierdan
       //Imprime las habitaciones de abajo dependiendo de las bifurcaciones
       //Y tambien de las ramificaciones en caso que sea de izquierda a derecha
		StringBuilder bifurcacionString = new StringBuilder();
		ultimaPosicionDeUno = UltimaPosicion(coordenadasBifur);
		int tamañoNuevo=coordenadasBifur.size()-ultimaPosicionDeUno;
		int a=0;
  if(bifurY>0){

	for (int i =0; i<3; i++) {//Tamaño de las salas(3)
          contador++;          
      for (int j =0; j<=coordenadasBifur.size()-tamañoNuevo; j++) {
       switch (coordenadasBifur.get(j)) {
        case 1:
        		bifurcacionString.append("***");        
        		if (j!=coordenadasBifur.size()-tamañoNuevo) { 
                    bifurcacionString.append("   ");
                    contador=contador+6;
               }else {
            	   bifurcacionString.append(generarBifurcacionesX(i));         	   
               }
        		break;//Termina el case 1:
        	case 2:    
        		if (bifurY==1) {
        			
             	   bifurcacionString.append(generarBifurcacionesX(i));         	   
        		}else {
        		bifurcacionString.append(BifurcacionEspacio());  
        		a++;
        		}
        		break; //Termina el case 2:
        		}               
        	}
		//bifurcacionString.append("\n");//Pendiente de eliminar    	
        	}
	}
	for(int i=0;i<a;i++) {
		int  n =(int)(Math.random() *2+1);      
		switch (n) {
		case 1:
			ramificacionesA++;
			break;
		case 2:
			//Hay un bug potencial, cuando los tipoB>bifur, exsistira (la posibilidad) una sala aislada
			ramificacionesB++;
			break;
		}
	}
  	return bifurcacionString.toString();
 }
	private static int UltimaPosicion(ArrayList<Integer> lista) {
		int ultimaPosicion = -1;  // Inicializamos con un valor que indica que aún no hemos encontrado el 1
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) == 1) {
                ultimaPosicion = i;  // Actualizamos la última posición cuando encontramos un 1
            }
        }
        return ultimaPosicion;

	}
	private static String generarBifurcacionesX(int a) {
	StringBuilder bifurcacionesX = new StringBuilder();
		if (bifurX>0) {
			for(int i=0;i<bifurX;i++) {//Cantidad a Imprimir	
				if(a==1) {
					bifurcacionesX.append("###***");
					contador=contador+6;
				}else {
					bifurcacionesX.append("   ");				
					bifurcacionesX.append("***");

				}
				
				
				}
			}
	   
   
   /*if((ramificacionesA>0&&bifurY>0)||(ramificacionesA>0&&bifurX>0)) {    
	   for(int i=0;i<1;i++) {
		   if(i==0||i==2) {
			   bifurcacionesX.append("   ");
			   bifurcacionesX.append("***");
			   contador=contador+6;
		   }else {
			   bifurcacionesX.append("###***");
			   contador=contador+6;
		   }        
	   }
   }
   */
   bifurcacionesX.append("\n");
		return bifurcacionesX.toString();
		
	}
	private static String habitación() {;
	StringBuilder habitaciónString = new StringBuilder();
    for (int i = 0; i < salasrestantes; i++) {
    	habitaciónString.append("***");
        if (i!=salasrestantes-1) {   
            habitaciónString.append("   ");
            contador=contador+6;
        }
    }
  
    habitaciónString.append("\n");
//Imprime los pasillos restantes y los interiores
    for (int i=0; i < salasrestantes - 2;i++) {
    		habitaciónString.append("***###");
        	contador=contador+6;
       	}
    	habitaciónString.append("***");
    	for (int i=0; i<1;i++) {
    		contador=contador+6;
    		habitaciónString.append("###***");
    	}
    habitaciónString.append("\n");
//Imprime el bloque de abajo
    for(int i=0; i <salasrestantes; i++) {
    	habitaciónString.append("***");
        	if (i==salasrestantes-1) {
        	}else {
        	habitaciónString.append("   ");
        	contador=contador+6;
        	}
    	}
    habitaciónString.append("\n");
	return habitaciónString.toString();
	}

}
