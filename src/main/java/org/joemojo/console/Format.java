package org.joemojo.console;
/**
 * @author joe_mojo.
 */
public enum Format {
	NORMAL(0){
		@Override
		public String unset(){
			return "";
		}
	},
	BOLD(1),
	DIM(2),
	UNDERLINE(4),
	BLINK(5),
	REVERSE(7),
	HIDDEN(8),
	STRIKEOUT(9);

	private static final int RESET_DIFF = 20;
	private static final String ESCAPE_SEQ_START = "\u001b[";
	private static final char ESCAPE_SEQ_END = 'm';

	private final int code;
	private final String setSeq;
	private final String unsetSeq;

	Format(final int code){
		this.code = code;
		this.setSeq = ESCAPE_SEQ_START + code + ESCAPE_SEQ_END;
		this.unsetSeq = ESCAPE_SEQ_START + (code+RESET_DIFF) + ESCAPE_SEQ_END;
	}

	public String set(){
		return this.setSeq;
	}

	public String unset(){
		return this.unsetSeq;
	}

	public static String reset(){
		return Format.NORMAL.set();
	}
}
