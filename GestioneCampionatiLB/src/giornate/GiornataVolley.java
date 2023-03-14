package giornate;

import java.io.Serializable;
import squadre.SquadraVolley;

/**
 * Classe che rappresenta una Giornata di Volley,
 * estende la classe Giornata specificando il tipo di squadra presente all'interno
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class GiornataVolley extends Giornata implements Serializable
{
	private static final long serialVersionUID = 1L;
	private SquadraVolley sq1;
	private SquadraVolley sq2;
	
	/**
	 * Costruttore che inizializza le variabili con valori presi dall'esterno, richiama anche il costruttore della classe padre.
	 * @param sq1
	 * @param sq2
	 */
	public GiornataVolley(SquadraVolley sq1, SquadraVolley sq2) 
	{
		super(sq1, sq2);
		this.sq1 = sq1;
		this.sq2 = sq2;
	}
	
	/**Getter e setter*/
	public SquadraVolley getSq1() {
		return sq1;
	}

	public void setSq1(SquadraVolley sq1) {
		this.sq1 = sq1;
	}

	public SquadraVolley getSq2() {
		return sq2;
	}

	public void setSq2(SquadraVolley sq2) {
		this.sq2 = sq2;
	}
	
}
