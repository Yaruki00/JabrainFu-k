import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;

public class BF_interpreter {

    public static void main(String[] args) throws Exception {

    // memory
    byte buff[] = new byte[30000];
    Arrays.fill(buff, (byte) 0);

    // code
    String code_str = "+++++++++[>++++++++>+++++++++++>+++++<<<-]>.>++.+++++++..+++.>-.------------.<++++++++.--------.+++.------.--------.>+.";
    char code[] = code_str.toCharArray();
    
    // pointer and loop count
    int code_ptr = 0, buff_ptr = 0;
    
    // IO
    InputStreamReader consoleReader = new InputStreamReader(System.in);
    OutputStream outWriter = System.out;
    
    // interpreter
    for (; code_ptr < code.length; code_ptr++) {
	switch (code[code_ptr]) {
	case '>':
	    buff_ptr++;
	    break;
	case '<':
	    buff_ptr--;
	    break;
	case '+':
	    buff[buff_ptr]++;
	    break;
	case '-':
	    buff[buff_ptr]--;
	    break;
	case '.':
	    outWriter.write((char) buff[buff_ptr]);
	    outWriter.flush();
	    break;
	case ',':
	    buff[buff_ptr] = (byte) consoleReader.read();
	    break;
	case '[':
	    if (buff[buff_ptr] == 0) {
		code_ptr++;
		for (int loop_cnt = 1; loop_cnt > 0; code_ptr++) {
		    if (code[code_ptr] == '[') {
			loop_cnt++;
		    } else if (code[code_ptr] == ']') {
			loop_cnt--;
		    }
		}
	    }
	    break;
	case ']':
	    if (buff[buff_ptr] != 0) {
		code_ptr--;
		for (int loop_cnt = 1; loop_cnt > 0; code_ptr--) {
		    if (code[code_ptr] == '[') {
			loop_cnt--;
		    } else if (code[code_ptr] == ']') {
			loop_cnt++;
		    }
		}
		code_ptr++;
	    }
	    break;
	}

    }

    }

}
