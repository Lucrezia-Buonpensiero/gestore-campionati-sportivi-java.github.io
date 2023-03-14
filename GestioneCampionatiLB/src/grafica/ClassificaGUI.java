package grafica;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import gestione.ModelloTabella;
import gestione.ModelloTabellaRisultati;
import squadre.Squadra;

/*
 * Classe che gestisce il modello tabella per la visualizzazione della classifica finale
 * 
 * @see ModelloTabella
 */
public class ClassificaGUI<E> extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<Squadra> squadre;
	private String sport;
	
	/**
	 * Costruttore che inizializza le variabili con i valori passati dall'esterno e genera i componenti grafici
	 * @param squadre
	 * @param sport
	 */
	public ClassificaGUI(ArrayList<Squadra> squadre, String sport) 
	{
		this.squadre = squadre;
		this.sport = sport;
		
		setTitle("Classifica "+sport);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/icona"+sport+".png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/**Richiamo il metodo che aggiunge e personalizza i componenti nel frame*/
		Componenti();
	}
	
	public void Componenti()
	{
		/* Inizializzo il JPanel e Layout */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout( new BoxLayout(contentPane, BoxLayout.Y_AXIS) );
		
		
		/* JTable */
		ModelloTabella tab = new ModelloTabella(squadre);
		table = new JTable(tab);
		tab.fireTableDataChanged();
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);

		contentPane.add(jScrollPane);
		setContentPane(contentPane);
	}
}
