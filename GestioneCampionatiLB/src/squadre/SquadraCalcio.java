package squadre;

import javax.swing.ImageIcon;

/**
 * Classe che rappresenta una squadra di calcio
 * Estende la classe Squadra aggiungendo metodi non comuni a tutti gli sport
 * @see Squadra
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class SquadraCalcio extends Squadra
{
	private static final long serialVersionUID = 1L;
	private int numPareggi;
	
	/**
	 * Costruttore che inizializza le variabili della squadra di calcio con valori esterni
	 * @param nome nome squadra
	 * @param citta città squadra
	 * @param logo logo squadra
	 * @param numSetVinti numero set vinti
	 * @param numSetPersi numero set persi
	 * @param punti punteggio
	 * @param numVittorie numero vittorie
	 * @param numSconfitte numero sconfitte
	 * @param numPareggi numero pareggi
	 */
	public SquadraCalcio ( String nome, String citta, ImageIcon logo, int numSetVinti, int numSetPersi, int punti, int numVittorie, int numSconfitte, int numPareggi )
	{
		super(nome,citta,logo,numSetVinti,numSetPersi,punti,numVittorie,numSconfitte);
		this.numPareggi = numPareggi;
	}
	
	/**
	 * Costruttore vuoto
	 * @param numPareggi numero dei pareggi
	 */
	public SquadraCalcio ()
	{
		super();
		this.numPareggi = 0;
	}

	
	/**
	 * Metodo che imposta i punteggi in caso di pareggio della squadra
	 * Aumenta il numero dei punti e il contatore dei pareggi di 1
	 */
	public void Pareggio ()
	{
		super.setPunti(super.getPunti() + 1);
		numPareggi += 1;
	}

	//getter e setter
	public int getNumPareggi() 
	{ return numPareggi; }

	public void setNumPareggi(int numPareggi) 
	{this.numPareggi = numPareggi; }
}
