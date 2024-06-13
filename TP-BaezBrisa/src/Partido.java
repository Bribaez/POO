
import java.time.LocalDate;

public class Partido {
	private Equipo equipo1;
	private Equipo equipo2;
	private int Goles1;
	private int Goles2;
	private String Fase;
	private static int cantPartidos;
	private LocalDate fecha;
	
	public Partido(Equipo equipo1, Equipo equipo2, int goles1, int goles2) {
		cantPartidos++;
		this.equipo1 = equipo1;
		this.equipo2 = equipo2;
		Goles1 = goles1;
		Goles2 = goles2;
		Fase = DeterminarFase();
		fecha = DeterminarFecha();
	}
	
	public Equipo getEquipo1() {
		return equipo1;
	}
	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}
	public Equipo getEquipo2() {
		return equipo2;
	}
	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}
	public int getGoles1() {
		return Goles1;
	}
	public void setGoles1(int goles1) {
		Goles1 = goles1;
	}
	public int getGoles2() {
		return Goles2;
	}
	public void setGoles2(int goles2) {
		Goles2 = goles2;
	}
	public String getFase() {
		return Fase;
	}
	public void setFase(String fase) {
		Fase = fase;
	}
	public static int getCantPartidos() {
		return cantPartidos;
	}
	public static void setCantPartidos(int cantPartidos) {
		Partido.cantPartidos = cantPartidos;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	
	@Override
	public String toString() {
		return "\nPartido [equipo1=" + equipo1.getNombre() + ", equipo2=" + equipo2.getNombre() + ", Goles1=" + Goles1 + ", Goles2=" + Goles2
				+ ", Fase=" + Fase + ", fecha=" + fecha + "]";
	}

	public String DeterminarFase() {
		if (cantPartidos<=4) {
			return "Cuartos";
		}
		if (cantPartidos>4 && cantPartidos<=6) {
			return "Semifinal";
		}
		if (cantPartidos>6 && cantPartidos<=7) {
			return "Final";
		}
		return "null";
	}
	
	public LocalDate DeterminarFecha() {
		if (cantPartidos<=4) {
			return LocalDate.now();
		}
		if (cantPartidos>4 && cantPartidos<=6) {
			return LocalDate.now().plusDays(2);
		}
		if (cantPartidos>6 && cantPartidos<=7) {
			return LocalDate.now().plusDays(4);
		}
		return null;
	}
	
	public Equipo DeterminarGanador() {
		if (this.getGoles1() > this.getGoles2()) {
			return this.getEquipo1();
		} else {
			return this.getEquipo2();
		}
	}


}