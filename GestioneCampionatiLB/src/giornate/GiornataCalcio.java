package giornate;

import java.io.Serializable;
import squadre.SquadraCalcio;

/**
 * Classe che rappresenta una Giornata di Calcio,
 * estende la classe Giornata specificando il tipo di squadra presente all'interno
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class GiornataCalcio extends Giornata implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	private SquadraCalcio sq1;
	private SquadraCalcio sq2;
	
	/**
	 * Costruttore che inizializza le variabili con valori presi dall'esterno, richiama anche il costruttore della classe padre.
	 * @param sq1 squadra1
	 * @param sq2 squadra2
	 */
	public GiornataCalcio(SquadraCalcio sq1, SquadraCalcio sq2) 
	{
		super(sq1, sq2);
		this.sq1 = sq1;
		this.sq2 = sq2;
	}
	
	/**getter e setter*/
	public SquadraCalcio getSq1() 
	{return sq1;}

	public void setSq1(SquadraCalcio sq1) 
	{this.sq1 = sq1;}

	public SquadraCalcio getSq2() 
	{return sq2;}

	public void setSq2(SquadraCalcio sq2) 
	{this.sq2 = sq2;}

	

}
