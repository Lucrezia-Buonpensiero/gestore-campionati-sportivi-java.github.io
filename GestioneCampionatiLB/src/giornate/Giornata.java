package giornate;

import java.io.Serializable;

import squadre.Squadra;

/**
 * Classe che rappresenta una giornata generica
 * con tutte le variabili comuni ad ogni giornata
 * 
 * @author Lucrezia Buonpensiero
 *
 *@see GiornataCalcio
 *@see GiornataHockey
 *@see GiornataVolley
 */
public class Giornata implements Serializable
{
	private static final long serialVersionUID = 1L;
	private Squadra sq1;
	private Squadra sq2;
	private int goalSq1;
	private int goalSq2;
	
	/**
	 * Costruttore che inizializza le variabili della giornata con valori esterni
	 * @param sq1 squadra1
	 * @param sq2 squadra2
	 */
	public Giornata ( Squadra sq1, Squadra sq2 )
	{
		this.sq1 = sq1;
		this.sq2 = sq2;
		goalSq1 = 0;
		goalSq2 = 0;
	}
	
	// getter e setter
	
	public Squadra getSq1() {
		return sq1;
	}

	public void setSq1(Squadra sq1) {
		this.sq1 = sq1;
	}

	public Squadra getSq2() {
		return sq2;
	}

	public void setSq2(Squadra sq2) {
		this.sq2 = sq2;
	}

	public int getGoalSq1() {
		return goalSq1;
	}

	public void setGoalSq1(int goalFatti) {
		this.goalSq1 = goalFatti;
	}

	public int getGoalSq2() {
		return goalSq2;
	}

	public void setGoalSq2(int goalSubiti) {
		this.goalSq2 = goalSubiti;
	}
}
