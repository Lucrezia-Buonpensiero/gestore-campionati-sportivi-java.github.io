package gestione;

import java.util.Comparator;
import squadre.Squadra;

/**
 * Classe che ordina le squadre per punti all'interno della tabella
 * @author Lucrezia Buonpensiero
 *
 */
public class Comparatore implements Comparator<Squadra> 
{
	public int compare(Squadra s1, Squadra s2) 
	{
		if (s1.getPunti() > s2.getPunti() )
		{ return -1; }
		else if (s1.getPunti() < s2.getPunti() )
		{ return 1; }
		
		return 0;
	}

}
