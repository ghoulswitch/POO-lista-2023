package entendendoInterfaces;

public class Quadrado implements FiguraGeometrica {
	
	private int lado;
	
	public int getLado() {
		return lado;
		
	}
	
	public void setLado(int lado) {
		this.lado = lado;
		
	}

	public String getNomeFigura() {
		return "quadrado";
	}

	public int getArea() {
		int area = 0;
		area = lado * lado;
		return area;
	}

	public int getPerimetro() {
		int perimetro = 0;
		perimetro = lado * 4;
		return perimetro;
	}

}
