package String.DataCompression;

import edu.princeton.cs.algs4.Alphabet;
import edu.princeton.cs.algs4.BinaryStdIn;
import edu.princeton.cs.algs4.BinaryStdOut;

public class Genome {
	public static void compress() {
		Alphabet DNA = new Alphabet("ACTG");
		String s = BinaryStdIn.readString();
		int N = s.length();
		BinaryStdOut.write(N);
		for(int i = 0; i < N; i++) {
			// ���ַ���˫λ��������ʾ
			int d = DNA.toIndex(s.charAt(i));
			BinaryStdOut.write(d, DNA.lgR());
		}
		BinaryStdOut.close();
	}
	public static void expand() {
		Alphabet DNA = new Alphabet("ACTG");
		int w = DNA.lgR();
		int N = BinaryStdIn.readInt();
		for(int i = 0; i < N; i++) {
			// ��ȡ2���أ�д��һ���ַ�
			char c = BinaryStdIn.readChar(w);
			BinaryStdOut.write(DNA.toChar(c));
		}
		BinaryStdOut.close();
	}
	
	public static void main(String[] args) {
		if(args[0].equals("-")) {
			compress();
		}
		if(args[0].equals("+")) {
			expand();
		}
	}
}