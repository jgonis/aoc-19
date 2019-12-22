package OpCodes;

public enum OpCodeNumber {
	ADD_OP(1),
	MULT_OP(2),
	INPUT_OP(3),
	OUTPUT_OP(4),
	JUMP_IF_TRUE_OP(5),
	JUMP_IF_FALSE_OP(6),
	LESS_THAN_OP(7),
	EQUALS_OP(8),
	HALT_OP(99);

	private final int _opCodeNumber;

	private OpCodeNumber(int opCodeNumber) {
		_opCodeNumber = opCodeNumber;
	}

	public int toInt() {
		return _opCodeNumber;
	}
}
