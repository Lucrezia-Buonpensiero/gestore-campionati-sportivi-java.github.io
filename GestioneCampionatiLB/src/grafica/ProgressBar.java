package grafica;

import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.Timer;

/**
 * Classe che crea una barra di progresso e genera l'animazione 
 * @author LuBu9
 *
 */
public class ProgressBar extends JFrame
{
	private static final long serialVersionUID = 1L;
	
	private JProgressBar pBar;
	private Timer t;
	private ActionListener al;

	/**
	 * Costruttore che inizializza i componenti grafici e genera l'animazione della barra di progresso
	 */
	public ProgressBar()
	{
		al = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if ( pBar.getValue() < 100 )
				{ pBar.setValue(pBar.getValue()+10); }
				else
				{ 
					t.stop(); 
					setVisible(false);
				}
			}
		};
		
		this.setLayout(new FlowLayout());
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("./risorse/iconaFrame/iconaFrame.png"));
		this.setTitle("Caricamento squadre in corso..");
		pBar = new JProgressBar(0,100);
		pBar.setValue(0);
		pBar.setStringPainted(true);
		
		this.setVisible(true);
		this.setSize(300, 100);
		this.add(pBar);
		t = new Timer(200,al);
		t.start();
	}
	
}
