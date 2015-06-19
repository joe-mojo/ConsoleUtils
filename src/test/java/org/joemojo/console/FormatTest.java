package org.joemojo.console;

import static org.fest.assertions.Assertions.*;
import org.junit.Test;

public class FormatTest {
	@Test public void sysout_bold(){
		final String actualTxtBold = "Normal text\t"+Format.BOLD.set()+"bold text"+Format.BOLD.unset()+".";
		assertThat(actualTxtBold).describedAs("Bold text inside normal text")
				.isEqualTo("Normal text\t\u001B[1mbold text\u001B[21m.");
		System.out.println(actualTxtBold);

		final String actualTxtBoldRst = "Normal text\t"+Format.BOLD.set()+"bold text"+Format.reset()+".";
		assertThat(actualTxtBoldRst).describedAs("Bold text inside normal text using reset")
				.isEqualTo("Normal text\t\u001B[1mbold text\u001B[0m.");
		System.out.println(actualTxtBoldRst);
	}

	@Test public void all_format_combined(){
		final String actualAllFmts = "Normal text "
				+ Format.BOLD.set() + "bold text "
				+ Format.DIM.set() + "dimmed text "
				+ Format.UNDERLINE.set() + "underlined text "
				+ Format.BLINK.set() + "blinking text "
				+ Format.REVERSE.set() + "reverse text "
				+ Format.HIDDEN.set() + "hidden text "
				+ Format.HIDDEN.unset() +"non-hidden text";
		assertThat(actualAllFmts).describedAs("All formats")
				.isEqualTo("Normal text \u001B[1mbold text \u001B[2mdimmed text \u001B[4munderlined text \u001B[5mblinking text \u001B[7mreverse text \u001B[8mhidden text \u001B[28mnon-hidden text");
		System.out.println(actualAllFmts);
	}

	public static void main(String[] args){
		FormatTest test = new FormatTest();
		test.sysout_bold();
		test.all_format_combined();
	}
}
