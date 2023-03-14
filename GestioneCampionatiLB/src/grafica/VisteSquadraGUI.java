package grafica;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

/**
 * Classe che permette di filtrare la classifica per numero giornata o per nome, contiene anche i componenti grafici
 * @author Lucrezia Buonpensiero
 *
 * @param <E>
 */
public class VisteSquadraGUI<E> extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField textField;
	private ArrayList<E> squadre;
	private ArrayList<E> arraySquadre;
	private ArrayList<E> appoggio;
	JComboBox comboBox;
	private boolean mod;
	private String titolo;

	/**
	 * Costruttore per la ricerca per nome squadra.
	 * Inizializza le variabili con valori esterni e genera i componenti grafici
	 * @param squadre
	 * @param mod se vale true cerco la squadra per nome
	 */
	public VisteSquadraGUI( ArrayList<E> squadre, boolean mod ) 
	{
		titolo = "Cerca per nome";
		this.squadre = squadre;
		this.mod = mod;
		Componenti();
		
		
	}
	
	/**
	 * Costruttore per la ricerca per numero giornata, genera la finestra e inizializza la ComboBox
	 * @param arraySquadre
	 * @param squadre
	 * @param mod se vale false cerco le squadre per la giornata selezionata (numero int)
	 */
	public VisteSquadraGUI( ArrayList<E> arraySquadre, ArrayList<E> squadre, boolean mod ) 
	{
		titolo = "Cerca per nome";
		this.squadre = squadre;
		this.arraySquadre = arraySquadre;
		this.mod = mod;
		this.appoggio = new ArrayList();
		Componenti();
		InizializzaComboBox();
		
	}
	
	public void Componenti()
	{
		setTitle(titolo);
		setIconImage(Toolkit.getDefaultToolkit().getImage("risorse/iconaFrame/iconaFrame.png"));
		setResizable(false);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 247, 162);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnCerca = new JButton("Evidenzia");
		btnCerca.addActionListener(this);
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCercaPerNome = new JLabel("Cerca per nome");
		
		comboBox = new JComboBox();
		
		JLabel lblCercaPerNumero = new JLabel("Cerca per numero giornata");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(lblCercaPerNumero)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(27, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(lblCercaPerNome)
					.addGap(18)
					.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(141, Short.MAX_VALUE)
					.addComponent(btnCerca)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblCercaPerNome)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblCercaPerNumero))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnCerca)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}

	/**Valori del combobox*/
	private void InizializzaComboBox()
	{
		String val;
		
		for(int i = 1 ; i <= arraySquadre.size()-1 ; i++ )
		{
			val = Integer.toString(i);
			comboBox.addItem(val);
		}
	}
	
	/**Metodo che ricerca la squadra per giornata
	 * genera un array di appoggio contenente le squadre con quel numero giornata
	 * 
	 * @param appoggio array contenente le giornate con uno specificato numero
	 * */
	private void CercaGiornata() 
	{
		/**Variabile di appoggio che contiene l'array con le squadre sotto l'indice selezionato*/
		appoggio = new ArrayList();
		/**Prendo la giornata selezionata dall'utente */
		int giornata = Integer.parseInt((String)comboBox.getSelectedItem());
		/**numero di partite per giornata*/
		int numPartite = squadre.size()/(arraySquadre.size()-1);
		
		/**Ciclo per prendere le partite di quella giornata*/
		for(int i = (numPartite*giornata)-1 , j=numPartite ; j != 0 ; j--,i--)
		{
			appoggio.add(squadre.get(i));
		}
		
	}
	
	
	@Override
	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare l'azione da effettuare
	 * 
	 * @see VistaNomeGUI
	 * 
	 * @param mod se è true cerco per nome, se è false inizializzo l'array con le partite da visualizzare sotto quel numero giornata e lo passo al visualizzatore della tabella
	 */
	public void actionPerformed(ActionEvent e) 
	{
		if (e.getActionCommand().equals("Evidenzia"))
		{
			if (mod)
			{
				VistaNomeGUI frameNome = new VistaNomeGUI(squadre, textField.getText());
				frameNome.setVisible(true);
			}
			else
			{
				CercaGiornata();
				VistaNomeGUI frameGiornata = new VistaNomeGUI(appoggio,comboBox.getSelectedIndex());
				frameGiornata.setVisible(true);
			}
			this.setVisible(false);
		}
		
	}
}
