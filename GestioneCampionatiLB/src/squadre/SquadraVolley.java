package squadre;

import javax.swing.ImageIcon;

/**
 * Classe che rappresenta una squadra di Volley
 * Estende la classe Squadra aggiungendo metodi non comuni a tutti gli sport
 * @see Squadra
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class SquadraVolley extends Squadra
{
	private static final long serialVersionUID = 1L;

	/**
	 * Costruttore che inizializza le variabili della squadra di Volley con valori esterni
	 * @param nome nome squadra
	 * @param citta città squadra
	 * @param logo logo squadra
	 * @param numSetVinti numero set vinti
	 * @param numSetPersi numero set persi
	 * @param punti punteggio
	 * @param numVittorie numero vittorie
	 * @param numSconfitte numero sconfitte
	 */
	public SquadraVolley ( String nome, String citta, ImageIcon logo, int numSetVinti, int numSetPersi, int punti, int numVittorie, int numSconfitte, int numPareggi )
	{
		super(nome,citta,logo,numSetVinti,numSetPersi,punti,numVittorie,numSconfitte);
	}
	
	/**
	 * Costruttore vuoto
	 */
	public SquadraVolley()
	{
		super();
	}
	
	/**
	 * Metodo che imposta i punti della squadra nel caso abbia vinto 3 a 2
	 * Incrementa il numero dei punti di 2 e il numero vittorie di 1
	 */
	public void Vittoria32 ()
	{
		super.setPunti(getPunti() + 2 );
		super.numVittorie += 1;
	}
	
	/*
	 * Metodo che imposta i punti della squadra nel caso abbia perso 2 a 3
	 * Incrementa il numero dei punti e delle sconfitte di 1
	 */
	public void Sconfitta23()
	{
		super.setPunti(getPunti() + 1);
		super.numSconfitte += 1;
	}
}
