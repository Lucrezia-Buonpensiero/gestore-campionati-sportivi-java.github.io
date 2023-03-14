package grafica;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

/**
 * Classe che rappresenta l'interfaccia grafica generica della modifica di una squadra
 * 
 * @author Lucrezia Buonpensiero
 *
 * @param <E> tipo squadra
 * @see gestioneSquadre.ModificaSquadre
 */
public class modificaSquadraGUI<E> extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private ArrayList<E> squadre;
	private boolean mod;
	private JTable table;


	/**
	 * Costruttore che inizializza le variabili con i dati passati dall'esterno
	 * @param squadre
	 * @param mod se mod è true entra in modalità cancella, altrimenti modifica
	 * @param table
	 */
	public modificaSquadraGUI(ArrayList<E> squadre, boolean mod, JTable table) 
	{
		this.table = table;
		this.squadre = squadre;
		this.mod = mod;
		
		Componenti();
	}
	
	public void Componenti()
	{
		/**Creo etichette e bottoni*/
		JLabel lblNomeSquadraDa;
		JButton btnCerca = new JButton("Cerca");
	
		setTitle("Cerca");
		setBounds(100, 100, 343, 218);
		
		/** inizializzo content pane*/
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		/**Cambio il nome dell'etichetta a seconda della modalità in cui sono*/
		if (mod)
		{ lblNomeSquadraDa = new JLabel("Nome squadra da cancellare");}
		else
		{ lblNomeSquadraDa = new JLabel("Nome squadra da modificare");}
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		
		/**Aggiungo l'action listener al bottone*/
		btnCerca.addActionListener(this);
		
		/**
		 * Posizione componenti
		 */
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 146, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeSquadraDa))
					.addContainerGap(122, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(206, Short.MAX_VALUE)
					.addComponent(btnCerca)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(27)
					.addComponent(lblNomeSquadraDa)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
					.addComponent(btnCerca))
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	//getter e setter
	public JTextField getTxtNome() {
		return txtNome;
	}

	public void setTxtNome(JTextField txtNome) {
		this.txtNome = txtNome;
	}

	public ArrayList<E> getSquadre() {
		return squadre;
	}

	public void setSquadre(ArrayList<E> squadre) {
		this.squadre = squadre;
	}

	public boolean isMod() {
		return mod;
	}

	public void setMod(boolean mod) {
		this.mod = mod;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	/**
	 * ActionListener (ascoltatore degli eventi):
	 * a seconda della voce di menù effettuata
	 * permette di selezionare l'azione da compiere
	 * 
	 * @see gestioneSquadre.ModificaSquadre#CercaSquadra()
	 */
	@Override
	public void actionPerformed ( ActionEvent e )
	{
		if ( e.getActionCommand().equals("Cerca") )
		{
			CercaSquadra();
		}
	}

	public void CercaSquadra(){};
}
