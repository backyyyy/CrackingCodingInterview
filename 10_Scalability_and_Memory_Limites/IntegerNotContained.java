import java.util.Scanner;

// May 29, 2015
// Page 115

public class IntegerNotContained_10_3 {
	
	// If memory = 1 GB
	long numberOfInts = (long) Integer.MAX_VALUE + 1;
	byte[] bitfield = new byte [(int)(numberOfInts / 8)];
	
	void findOpenNumber() throws FileNotFoindException {
		Scanner in = new Scanner (new FileReader ("file.txt"));
		while(in.hasNext()) {
			int n = in.nextInt();
			bitfield [n/8] |= << (n % 8);
		}
		
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j);
					return;
				}
			}
		}
	}
	
	// If memory = 10 MB
	int bitsize = 1048576;
	int blockNum = 4096;
	byte[] bitfield = new byte[bitsize / 8];
	int[] blocks = new int[blockNum];
	
	void findOpenNumber() throws FileNotFoundException {
		int starting = -1;
		Scanner in = new Scanner (new FileReader ("file.txt"));
		while(in.hasNext()) {
			int n = in.nextInt();
			blocks[n / (bitfield.length * 8)] ++;
		}
		
		for(int i = 0; i < blocks.length; i++) {
			if(blocks[i] < bitfield.length * 8) {
				starting = i * bitfield.length * 8;
				break;
			}
		}
		
		in = new Scanner(new FileReader("file.txt"));
		while (in.hasNext()) {
			int n = in.nextInt();
			if (n >= starting && n < starting + bitfield.length * 8) {
				bitfield [(n-starting) / 8] |= 1 << ((n - starting) % 8);
			}
		}
		
		for (int i = 0; i < bitfield.length; i++) {
			for (int j = 0; j < 8; j++) {
				if((bitfield[i] & (1 << j)) == 0) {
					System.out.println(i * 8 + j + starting);
					return;
				}
			}
		}
	}
}
