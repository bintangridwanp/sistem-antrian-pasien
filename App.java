public class App {
    public static void main(String[] args) {
    int pilih;
	
	do{
		tampilkanHeader();
		tampilkanMenu();
		
		pilih = input.nextInt();
		input.nextLine();
		
		System.out.println();
		
		switch (pilih){
			case 1:
				cariPasienNama();
				break;
				
			case 2:
				cariPasienGolongan();
				break;
			
			case 3:
				tambahPasien();
				break;
			
			case 4:
				editPasien();
				break;
			
			case 5:
				hapusPasien();
				break;
				
			case 6:
				tambahKeAntrian();
				break;
			
			case 7:
				tambahKeAntrianPrioritas();
				break;
			
			case 8:
				tampilkanAntrian();
				break;
			
			case 0:
				System.out.Println();
				break;
		}
	}
	
	while (pilih != 0);
    
}
