package squadre;

import java.io.Serializable;

import javax.swing.ImageIcon;

/**
 * Classe che rappresenta una squadra generica
 * con tutte le variabili comuni alle squadre di ogni sport.
 * @see SquadraCalcio
 * @see SquadraHockey
 * @see SquadraVolley
 * 
 * @author Lucrezia Buonpensiero
 *
 */
public class Squadra implements Comparable<Squadra>, Serializable
{
	private static final long serialVersionUID = 1L;
	
	protected String nome;
	protected String citta;
	protected ImageIcon logo;
	protected int numSetVinti;
	protected int numSetPersi;
	protected int punti;
	protected int numVittorie;
	protected int numSconfitte;
	
	/**
	 * Costruttore che inizializza le variabili della squadra con valori esterni
	 * @param nome nome squadra
	 * @param citta città squadra
	 * @param logo logo squadra
	 * @param numSetVinti numero set vinti
	 * @param numSetPersi numero set persi
	 * @param punti punteggio
	 * @param numVittorie numero vittorie
	 * @param numSconfitte numero sconfitte
	 */
	public Squadra( String nome, String citta, ImageIcon logo, int numSetVinti, int numSetPersi, int punti, int numVittorie, int numSconfitte )
	{
		this.nome = nome;
		this.citta = citta;
		this.logo = logo;
		this.numSetVinti = numSetVinti;
		this.numSetPersi = numSetPersi;
		this.punti = punti;
		this.numSconfitte = numSconfitte;
		this.numVittorie = numVittorie;
	}
	
	/**
	 * Costruttore vuoto che inizializza le variabili a 0
	 */
	public Squadra()
	{
		this.nome = null;
		this.citta = null;
		this.logo = new ImageIcon ("./risorse/iconeScudetti/iconaDefault.png");
		this.numSetVinti = 0;
		this.numSetPersi = 0;
		this.punti = 0;
		this.numVittorie = 0;
		this.numSconfitte = 0;
	}
	
	/**
	 * Metodo per ordinare la classifica punti
	 */
	public int compareTo ( Squadra s )
	{
		if ( s.getPunti() > punti )
			return -1;
		if ( s.getPunti() < punti )
			return 1;
		
		return 0;
	}
	
	/**
	 * Metodo che imposta i punti in caso di vittoria
	 */
	public void Vittoria ()
	{
		punti += 3;
		numVittorie += 1;
	}
	
	/**
	 * Metodo che imposta i punti in caso di sconfitta
	 */
	public void Sconfitta ()
	{ numSconfitte += 1; }
	
	//getter e setter
	public int getnumSetVinti() 
	{ return numSetVinti; }
	
	public int getnumSetPersi()
	{ return numSetPersi; }

	public void setnumSetVinti(int nsV) 
	{ this.numSetVinti = nsV; }
	
	public void setnumSetPersi(int nsP )
	{ this.numSetPersi = nsP; }

	public String getNome() 
	{ return nome; }

	public void setNome(String nome) 
	{ this.nome = nome; }

	public String getCitta() 
	{ return citta; }

	public void setCitta(String citta) 
	{ this.citta = citta; }

	public ImageIcon getLogo() 
	{ return logo; }

	public void setLogo(String logo) 
	{ this.logo = new ImageIcon(logo); }

	public int getPunti() 
	{ return punti; }

	public void setPunti(int punti) 
	{ this.punti = punti; }

	public int getNumVittorie() 
	{ return numVittorie; }

	public void setNumVittorie(int numVittorie) 
	{ this.numVittorie = numVittorie; }

	public int getNumSconfitte() 
	{ return numSconfitte; }

	public void setNumSconfitte(int numSconfitte) 
	{ this.numSconfitte = numSconfitte; }
}
