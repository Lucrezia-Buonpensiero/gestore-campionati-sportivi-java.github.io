package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import gestione.ModelloTabella;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTable;
import javax.swing.JScrollPane;

/**
 * Classe che rappresenta l'interfaccia grafica generica della gestione delle squadre
 * 
 * @author Lucrezia Buonpensiero
 *
 * @param <E>
 * @see gestioneSquadre.GestioneSquadreCalcio
 * @see gestioneSquadre.GestioneSquadreHockey
 * @see gestioneSquadre.GestioneSquadreVolley
 */
public class GestioneSquadraGUI<E> extends JFrame implements ActionListener 
{
	private static final long serialVersionUID = 1L;
	protected ArrayList<E> squadre;
	private JPanel contentPane;
	protected JTable table;
	protected ModelloTabella tab;
	private ImageIcon icon;

	/**
	 * Crea il frame e inizializza l'array di squadre per passarlo al modello tabella
	 */
	public GestioneSquadraGUI( ArrayList<E> sq ) 
	{
		this.squadre = sq;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		/**Richiamo il metodo che aggiunge e personalizza i componenti nel frame*/
		Componenti();
	}
	
	/**Metodo che aggiunge i componenti al frame*/
	public void Componenti ()
	{
		/* Inizializzo il JPanel e Layout */
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout( new BoxLayout(contentPane, BoxLayout.Y_AXIS) );

		/* JMenuBar */
		JMenuBar menuBar = new JMenuBar();
		JMenu mnFile = new JMenu("File");
		JMenuItem mntmIniziaCampionato = new JMenuItem("Inizia Campionato");
		JMenuItem mntmSalva = new JMenuItem("Carica Squadre");

		mntmIniziaCampionato.addActionListener(this);
		mntmSalva.addActionListener(this);
		mnFile.add(mntmIniziaCampionato);
		mnFile.addSeparator();
		mnFile.add(mntmSalva);
		menuBar.add(mnFile);
		this.setJMenuBar( menuBar );

		/* Bottoni */
		JButton btnInserisci = new JButton("Inserisci");
		JButton btnModifica = new JButton("Modifica");
		JButton btnCancella = new JButton("Cancella");
		btnInserisci.addActionListener(this);
		btnModifica.addActionListener(this);
		btnCancella.addActionListener(this);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout( new BoxLayout(buttonPanel, BoxLayout.X_AXIS) );
		buttonPanel.add(btnInserisci);
		buttonPanel.add(btnModifica);
		buttonPanel.add(btnCancella);

		/* JTable */
		tab = new ModelloTabella(squadre);
		table = new JTable(tab);
		table.setFillsViewportHeight(true);
		
		/* Scrollpane */
		JScrollPane jScrollPane = new JScrollPane(table);

		contentPane.add(jScrollPane);
		contentPane.add(buttonPanel);


		setContentPane(contentPane);

	}
	
	@Override
	/**
	 * Metodo chiamato quando viene eseguita una delle azioni indicate
	 */
	public void actionPerformed(ActionEvent e) 
	{
		switch(e.getActionCommand())
		{
			case "Inserisci":
			{
				InserisciSquadra();
				break;
			}
			case "Modifica":
			{
				ModificaSquadra();
				break;
			}
			case "Cancella":
			{
				CancellaSquadra();
				break;
			}
			case "Inizia Campionato":
			{
				ControlloParitaSquadre();
				break;
			}
			case "Carica Squadre":
			{
				CaricaSquadre();
				break;
			}
			default:
				return;
		}
	}

	public void CancellaSquadra() {}
	public void ModificaSquadra() {};
	public void InserisciSquadra() {};
	public void ControlloParitaSquadre() {};
	public void CaricaSquadre() {};
}
