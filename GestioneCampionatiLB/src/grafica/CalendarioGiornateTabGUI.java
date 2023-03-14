package grafica;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import gestione.ModelloTabellaGiornate;
import giornate.CreazioneGiornateCalcio;
import giornate.CreazioneGiornateHockey;
import giornate.CreazioneGiornateVolley;
import giornate.Giornata;
import salvataggi.SalvaCaricaSquadre;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

/**
 * Classe che permette di visualizzare il calendario degli scontri in casa e in trasferta.
 * E' possibile salvare le giornate, cercare le squadre per numero giornata e per nome,
 * inserire i risultati casa e trasferta,visualizzare la classifica e cancellare tutti i risultati immessi
 * 
 * @author Lucrezia Buonpensiero
 *
 * @param <E>
 */
public class CalendarioGiornateTabGUI<E> extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private ArrayList<E> casa;
	private ArrayList<E> trasferta;
	private ArrayList<E> squadre;
	private String sport;

	/**
	 * Costruttore che inizializza gli array con i dati passati dall'esterno
	 * e inizializza la grafica della finestra.
	 * @param squadre
	 * @param casa
	 * @param trasferta
	 * @param sport
	 */
	public CalendarioGiornateTabGUI(ArrayList<E> squadre, ArrayList<E> casa , ArrayList<E> trasferta, String sport) 
	{
		this.squadre = squadre;
		this.casa = casa;
		this.trasferta = trasferta;
		this.sport = sport;
		
		setTitle("Calendario Giornate "+sport);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/icona"+sport+".png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		JMenu mnModifica = new JMenu("Modifica");
		JMenuItem mntmCancella = new JMenuItem("Cancella Risultati");
		JMenuItem mntmVisualizzaClassifica = new JMenuItem("Visualizza Classifica");
		JMenuItem mntmSalva = new JMenuItem("Salva Squadre");
		JMenuItem mntmRisultatiC = new JMenuItem("Inserisci Risultati Casa");
		JMenuItem mntmRisultatiT = new JMenuItem("Inserisci Risultati Trasferta");
		JMenu mnViste = new JMenu("Viste");
		JMenuItem mntmVistaGiornata = new JMenuItem("Cerca Giornata");
		JMenuItem mntmVistaNome = new JMenuItem("Cerca Nome");
		

		menuBar.add(mnFile);
		menuBar.add(mnViste);
		menuBar.add(mnModifica);

		mnViste.add(mntmVistaGiornata);
		mnViste.add(mntmVistaNome);
		mnViste.addSeparator();
		mnViste.add(mntmVisualizzaClassifica);
		
		
		mnFile.add(mntmSalva);
		mnModifica.add(mntmRisultatiC);
		mnModifica.add(mntmRisultatiT);
		mnModifica.addSeparator();
		mnModifica.add(mntmCancella);
		this.setJMenuBar(menuBar);
		
		/* JTable */
		ModelloTabellaGiornate tab = new ModelloTabellaGiornate((ArrayList<Giornata>)casa);
		table = new JTable(tab);
		tab.fireTableDataChanged();
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);
		
		mntmSalva.addActionListener(this);
		mntmVistaGiornata.addActionListener(this);
		mntmVistaNome.addActionListener(this);
		mntmRisultatiC.addActionListener(this);
		mntmRisultatiT.addActionListener(this);
		mntmVisualizzaClassifica.addActionListener(this);
		mntmCancella.addActionListener(this);

		contentPane.add(jScrollPane);
		setContentPane(contentPane);
	}

	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare l'azione da svolgere.
	 * 
	 * @see salvataggi.SalvaCaricaSquadre#SalvaCampionatoCalcio()
	 * @see salvataggi.SalvaCaricaSquadre#SalvaCampionatoHockey()
	 * @see salvataggi.SalvaCaricaSquadre#SalvaCampionatoVolley()
	 * @see salvataggi.SalvaCaricaSquadre#SalvaCampionato()
	 * 
	 * @see VisteSquadraGUI
	 * 
	 * @see InserimentoRisultatiGUI
	 * 
	 * @see ClassificaGUI
	 * @see CreazioneGiornateCalcio
	 * @see CreazioneGiornateHockey
	 * @see CreazioneGiornateVolley
	 */
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case("Salva Squadre"):
			{
				SalvaCaricaSquadre sq = new SalvaCaricaSquadre(squadre,casa,trasferta);
				
				if ( sport.equals("Calcio")){ sq.SalvaCampionatoCalcio(); }
				if ( sport.equals("Hockey")){ sq.SalvaCampionatoHockey(); }
				if ( sport.equals("Volley")){ sq.SalvaCampionatoVolley(); }
				
				sq.SalvaCampionato();
				break;
			}
			case("Cerca Giornata"):
			{
				VisteSquadraGUI frameCercaGiornata = new VisteSquadraGUI(squadre,casa,false);
				frameCercaGiornata.setVisible(true);
				break;
			}
			case("Cerca Nome"):
			{
				VisteSquadraGUI frameCercaNome = new VisteSquadraGUI(casa,true);
				frameCercaNome.setVisible(true);
				break;
			}
			case("Inserisci Risultati Casa"):
			{
				InserimentoRisultatiGUI tabInsRisC = new InserimentoRisultatiGUI(casa,trasferta,sport,true);
				tabInsRisC.setVisible(true);
				break;
			}
			case("Inserisci Risultati Trasferta"):
			{
				InserimentoRisultatiGUI tabInsRisT = new InserimentoRisultatiGUI(casa,trasferta,sport,false);
				tabInsRisT.setVisible(true);
				break;
			}
			case("Visualizza Classifica"):
			{
				ClassificaGUI classifica = new ClassificaGUI(squadre,sport);
				classifica.setVisible(true);
				break;
			}
			case("Cancella Risultati"):
			{
				if ( sport.equals("Calcio")){ CreazioneGiornateCalcio c = new CreazioneGiornateCalcio(casa,trasferta,false); }
				if ( sport.equals("Hockey")){ CreazioneGiornateHockey c = new CreazioneGiornateHockey(casa,trasferta,false); }
				if ( sport.equals("Volley")){ CreazioneGiornateVolley c = new CreazioneGiornateVolley(casa,trasferta,false); }
				break;
			}
		}
		
	}
}
