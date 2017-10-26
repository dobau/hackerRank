import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaEndOfFile {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		List<String> lines = new ArrayList<String>();

		while (scan.hasNext()) {
			lines.add(scan.nextLine());
		}

		scan.close();

		for (int i = 0; i < lines.size(); i++) {
			System.out.printf("%d %s%n", i + 1, lines.get(i));
		}
	}
}
