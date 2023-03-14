package grafica;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import gestione.ModelloTabellaGiornate;
import gestione.ModelloTabellaRisultati;
import giornate.CreazioneGiornateCalcio;
import giornate.CreazioneGiornateHockey;
import giornate.CreazioneGiornateVolley;
import giornate.Giornata;

/**
 * Classe che serve per visualizzare la tabella per l'inserimento dei punti e chiamare i metodi per aggiornarli
 * 
 * @author Lucrezia Buonpensiero
 *
 * @param <E>
 */
public class InserimentoRisultatiGUI<E> extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<E> casa;
	private ArrayList<E> trasferta;
	private String sport;
	private boolean mod;
	
	/**
	 * Costruttore che inizializza le variabili con valori esterni e genera i componenti della finestra
	 * @param casa
	 * @param trasferta
	 * @param sport
	 * @param mod se vale true è chiamato con array casa, altrimenti trasferta
	 */
	public InserimentoRisultatiGUI(ArrayList<E> casa, ArrayList<E> trasferta, String sport, boolean mod ) 
	{
		this.casa = casa;
		this.trasferta = trasferta;
		this.sport = sport;
		this.mod = mod;
		
		setTitle("Inserisci Risultati "+sport);
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
		
		/* JMenuBar*/
		JMenuBar menuBar = new JMenuBar();
		JMenu mnFile = new JMenu("File");
		JMenuItem mntmAggiorna = new JMenuItem("Aggiorna");
		
		menuBar.add(mnFile);
		mnFile.addSeparator();
		mnFile.add(mntmAggiorna);
		this.setJMenuBar(menuBar);
		
		/* JTable */
		ModelloTabellaRisultati tab;
		if(mod)
		{tab = new ModelloTabellaRisultati(casa,sport); }
		else
		{tab = new ModelloTabellaRisultati(trasferta,sport); }
		table = new JTable(tab);
		tab.fireTableDataChanged();
		
		mntmAggiorna.addActionListener(this);
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);
		
		

		contentPane.add(jScrollPane);
		setContentPane(contentPane);
	}

	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare l'azione da compiere
	 * 
	 * Premendo Aggiorna posso chiamare i metodi di aggiornamento dei punti
	 * 
	 * @see CreazioneGiornateCalcio chiamo il costruttore per aggiornare i punti
	 * @see CreazioneGiornateHockey
	 * @see CreazioneGiornateVolley
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case("Aggiorna"):
			{
				if (sport.equals("Calcio"))
				{
					CreazioneGiornateCalcio aggPtCalcio = new CreazioneGiornateCalcio(casa,trasferta,true);
				}
				if (sport.equals("Hockey"))
				{
					CreazioneGiornateHockey aggPtHockey = new CreazioneGiornateHockey(casa,trasferta,true);
				}
				if (sport.equals("Volley"))
				{
					CreazioneGiornateVolley aggPtVolley = new CreazioneGiornateVolley(casa,trasferta,true);
				}
				break;
			}
		}
		
	}
	
	
}
