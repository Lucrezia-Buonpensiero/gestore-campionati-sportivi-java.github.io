package grafica;

import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import gestione.ModelloTabella;
import gestione.ModelloTabellaVistaGiornata;
import gestione.ModelloTabellaVistaNome;
import squadre.Squadra;

/**
 * Classe che permette di visualizzare le squadre filtrate per nome o per numero giornata, a seconda del costruttore invocato
 * @author Lucrezia Buonpensiero
 * 
 * @see VisteSquadraGUI
 * @param <E>
 */
public class VistaNomeGUI<E> extends JFrame
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<E> squadre;
	private String nome;
	private int numeroGiornata;
	
	/**
	 * Costruttore chiamato per la ricerca delle squadre per nome
	 * @param squadre
	 * @param nome nome della squadra da cercare
	 */
	public VistaNomeGUI(ArrayList<E> squadre, String nome) 
	{
		this.squadre = squadre;
		this.nome = nome;
		
		setTitle("Classifica "+nome);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/iconaFrame.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/**Richiamo il metodo che aggiunge e personalizza i componenti nel frame*/
		Componenti();
	}
	
	/**
	 * Costruttore chiamato per la ricerca delle squadre per giornata
	 * 
	 * @param squadre
	 * @param numeroGiornata numero della giornata selezionato
	 */
	public VistaNomeGUI ( ArrayList<E> squadre, int numeroGiornata )
	{
		this.squadre = squadre;
		this.numeroGiornata = numeroGiornata;
		
		setTitle("Classifica Giornata "+(numeroGiornata+1));
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/iconaFrame.png"));
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/**Richiamo il metodo che aggiunge e personalizza i componenti nel frame*/
		Componenti2();
	}
	
	public void Componenti2()
	{
		/* Inizializzo il JPanel e Layout */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout( new BoxLayout(contentPane, BoxLayout.Y_AXIS) );
		
		
		/* JTable */
		ModelloTabellaVistaGiornata tab2 = new ModelloTabellaVistaGiornata(squadre,numeroGiornata);
		table = new JTable(tab2);
		tab2.fireTableDataChanged();
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);

		contentPane.add(jScrollPane);
		setContentPane(contentPane);
	}
	
	public void Componenti()
	{
		/* Inizializzo il JPanel e Layout */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout( new BoxLayout(contentPane, BoxLayout.Y_AXIS) );
		
		
		/* JTable */
		ModelloTabellaVistaNome tab = new ModelloTabellaVistaNome(squadre,nome);
		table = new JTable(tab);
		tab.fireTableDataChanged();
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);

		contentPane.add(jScrollPane);
		setContentPane(contentPane);
	}
}
