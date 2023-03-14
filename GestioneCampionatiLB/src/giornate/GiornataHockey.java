package giornate;

import java.io.Serializable;
import squadre.SquadraHockey;

/**
 * Classe che rappresenta una Giornata di Hockey,
 * estende la classe Giornata specificando il tipo di squadra presente all'interno
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class GiornataHockey extends Giornata implements Serializable
{
	private static final long serialVersionUID = 1L;
	private SquadraHockey sq1;
	private SquadraHockey sq2;
	private boolean assenzaSq1;
	private boolean assenzaSq2;
	
	/**
	 * Costruttore che inizializza le variabili con valori presi dall'esterno, richiama anche il costruttore della classe padre.
	 * @param sq1 squadra1
	 * @param sq2 squadra2
	 */
	public GiornataHockey(SquadraHockey sq1, SquadraHockey sq2) 
	{
		super(sq1, sq2);
		this.sq1 = sq1;
		this.sq2 = sq2;
	}
	
	/**getter e setter*/
	public SquadraHockey getSq1() {
		return sq1;
	}

	public void setSq1(SquadraHockey sq1) {
		this.sq1 = sq1;
	}

	public SquadraHockey getSq2() {
		return sq2;
	}

	public void setSq2(SquadraHockey sq2) {
		this.sq2 = sq2;
	}

	public boolean isAssenzaSq1() {
		return assenzaSq1;
	}

	public void setAssenzaSq1(boolean assenzaSq1) {
		this.assenzaSq1 = assenzaSq1;
	}

	public boolean isAssenzaSq2() {
		return assenzaSq2;
	}

	public void setAssenzaSq2(boolean assenzaSq2) {
		this.assenzaSq2 = assenzaSq2;
	}


}
