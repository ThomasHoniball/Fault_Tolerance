import com.fault_tolerance.draw.Draw;
import com.fault_tolerance.draw.AsciiGraphic;
import com.fault_tolerance.draw.AsciiComponent;
import com.googlecode.lanterna.TextColor.ANSI;


public class Fault_Tolerance
{
	public static void main(String[] args) throws InterruptedException
	{
		Draw draw = new Draw();
		AsciiComponent openBar = new AsciiComponent(1, 1, '[');
		AsciiComponent bar = new AsciiComponent(1, 20, '#');
		AsciiComponent halfBar = new AsciiComponent(1, 10, '#');
		AsciiComponent emptyBar = new AsciiComponent(1, 10, '-', ANSI.RED);
		AsciiComponent closeBar = new AsciiComponent(1, 1, ']');
		AsciiGraphic graphic = new AsciiGraphic();
		graphic.addComponent(openBar);
		graphic.addComponent(bar);
		graphic.addComponent(closeBar);

		AsciiGraphic replace = new AsciiGraphic();
		replace.addComponent(openBar);
		replace.addComponent(halfBar);
		replace.addComponent(emptyBar);
		replace.addComponent(closeBar);
		draw.printDebug();
		draw.drawGraphic(graphic, 10, 10);
		draw.printDebug();
		Thread.sleep(1000);
		System.out.println("replace");
		draw.drawGraphic(replace, 10, 10);
		draw.printDebug();
		Thread.sleep(1000);
		wrapUp(5, draw);
		System.out.println(bar.toString());
		
	}

	public static void wrapUp(int seconds, Draw terminal) throws InterruptedException
	{
		for(int i = 0; i < seconds; i++)
		{
			System.out.println(i+1);
			Thread.sleep(1000);
		}
		terminal.close();
	}

}

