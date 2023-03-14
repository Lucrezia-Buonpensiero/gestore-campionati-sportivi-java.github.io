package gestioneSquadre;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;

import grafica.modificaSquadraGUI;
import squadre.SquadraCalcio;
import squadre.SquadraHockey;
import squadre.SquadraVolley;

/**
 * Classe che gestisce la modifica di una squadra estende l'interfaccia grafica per la modifica di una squadra
 * @author Lucrezia Buonpensiero
 *
 *@see grafica.modificaSquadraGUI
 * @param <E> tipo squadra
 */
public class ModificaSquadre<E> extends modificaSquadraGUI<E>
{
	private static final long serialVersionUID = 1L;
	
	protected ArrayList<E> squadre;
	protected JTable table;
	protected boolean mod;
	private String sport;
	
	/**
	 * 
	 * @param squadre array delle squadra
	 * @param mod se vale false entra in modalità modifica, altrimenti cancella
	 * @param table tabella
	 * @param sport nome sport
	 */
	public ModificaSquadre(ArrayList<E> squadre, boolean mod, JTable table, String sport) 
	{
		super(squadre, mod, table);
		this.sport = sport;
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/icona"+sport+".png"));
		this.table = table;
		this.squadre = squadre;
		this.mod = mod;
	}

	/**
	 * Metodo per modificare o cancellare una squadra.
	 * 
	 * In modalità modifica richiama la finestra per l'inserimento dati squadre in modalità modifica
	 * 
	 * In modalità cancella rimuove la squadra cercandola col metodo cercaSquadraMod che ritorna la posizione dell'elemento
	 * cercato all'interno dell'array. 
	 * Aggiorna la tabella.
	 * In modalità modifica richiama la finestra per l'inserimento dati squadre in modalità modifica. In modalità cancella rimuove la squadra cercandola col metodo cercaSquadraMod che ritorna la posizione dell'elemento
	 * @see gestioneSquadre.InserimentoDatiCalcio
	 * @see gestioneSquadre.InserimentoDatiHockey
	 * @see gestioneSquadre.InserimentoDatiVolley
	 * @see grafica.modificaSquadraGUI#CercaSquadra()
	 */
	public void CercaSquadra()
	{
		if (sport.equals("Calcio"))
		{
			GestioneSquadreCalcio m = new GestioneSquadreCalcio(squadre,sport);
			SquadraCalcio sq = new SquadraCalcio();
			sq.setNome(getTxtNome().getText());
			
			if( m.cercaSquadraMod(sq) >= 0  )
			{
				if (!(mod))
				{
					InserimentoDatiCalcio finestraMod = new InserimentoDatiCalcio(squadre, "Modifica Squadra", true, m.cercaSquadraMod(sq),table,sport);
					finestraMod.setVisible(true);	
				}
				else
				{
					squadre.remove(m.cercaSquadraMod(sq));
					table.repaint();
					JOptionPane.showMessageDialog(null, "Squadra cancellata correttaemente", "OK!", JOptionPane.INFORMATION_MESSAGE);
				}
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Squadra da modificare non trovata", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (sport.equals("Hockey"))
		{
			GestioneSquadreHockey m = new GestioneSquadreHockey(squadre,sport);
			SquadraHockey sq = new SquadraHockey();
			sq.setNome(getTxtNome().getText());
			
			if( m.cercaSquadraMod(sq) >= 0  )
			{
				if (!(mod))
				{
					InserimentoDatiHockey finestraMod = new InserimentoDatiHockey(squadre, "Modifica Squadra", true, m.cercaSquadraMod(sq),table,sport);
					finestraMod.setVisible(true);	
				}
				else
				{
					squadre.remove(m.cercaSquadraMod(sq));
					table.repaint();
					JOptionPane.showMessageDialog(null, "Squadra cancellata correttaemente", "OK!", JOptionPane.INFORMATION_MESSAGE);
				}
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Squadra da modificare non trovata", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		}
		if (sport.equals("Volley"))
		{
			GestioneSquadreVolley m = new GestioneSquadreVolley(squadre,sport);
			SquadraVolley sq = new SquadraVolley();
			sq.setNome(getTxtNome().getText());
			
			if( m.cercaSquadraMod(sq) >= 0  )
			{
				if (!(mod))
				{
					InserimentoDatiVolley finestraMod = new InserimentoDatiVolley(squadre, "Modifica Squadra", true, m.cercaSquadraMod(sq),table,sport);
					finestraMod.setVisible(true);	
				}
				else
				{
					squadre.remove(m.cercaSquadraMod(sq));
					table.repaint();
					JOptionPane.showMessageDialog(null, "Squadra cancellata correttaemente", "OK!", JOptionPane.INFORMATION_MESSAGE);
				}
				this.setVisible(false);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Squadra da modificare non trovata", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
			}
		}
		/*
		GestioneSquadreGenerica m = new GestioneSquadreGenerica(squadre,sport);
		Squadra sq = new Squadra();
		sq.setNome(getTxtNome().getText());
		
		if( m.cercaSquadraMod(sq) >= 0  )
		{
			if (!(mod))
			{
				InserimentoDatiSquadre finestraMod = new InserimentoDatiSquadre(squadre, "Modifica Squadra", true, m.cercaSquadraMod(sq),table,sport);
				finestraMod.setVisible(true);	
			}
			else
			{
				squadre.remove(m.cercaSquadraMod(sq));
				table.repaint();
				JOptionPane.showMessageDialog(null, "Squadra cancellata correttaemente", "OK!", JOptionPane.INFORMATION_MESSAGE);
			}
			this.setVisible(false);
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Squadra da modificare non trovata", "ATTENZIONE", JOptionPane.ERROR_MESSAGE);
		}
		*/
	}
}
