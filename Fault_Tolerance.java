
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

public class Fault_Tolerance
{
	public static void main(String[] args) 
	{
		// System.out.println("HELLO WORLD");
		Terminal terminal = null;
		DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
		try
		{
			
			terminal = terminalFactory.createTerminal();
			terminal.clearScreen();
			// terminal.enterPrivateMode();
			terminal.putCharacter('H');
	        terminal.putCharacter('e');
	        terminal.putCharacter('l');
	        terminal.putCharacter('l');
	        terminal.putCharacter('o');
	        terminal.putCharacter('\n');

	        terminal.setCursorPosition(10,0);

	        //terminal.clearScreen();
			terminal.putCharacter('H');
	        terminal.putCharacter('e');
	        terminal.putCharacter('l');
	        terminal.putCharacter('l');
	        terminal.putCharacter(' ');
	        terminal.putCharacter('n');
	        terminal.putCharacter('o');
	        terminal.putCharacter('\n');


	        //System.out.println(terminal.getCursorPosition().toString());
			terminal.flush();
		}catch(Throwable e)
		{

		}
		
	}

}

