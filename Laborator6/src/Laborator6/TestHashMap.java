package Laborator6;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Random;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.Iterator;
import java.util.Set;

public class TestHashMap{

    /* Definire date de test */
    
    static String[][] Studenti = { {"Popescu", "Ioana"},
                            {"Andrei", "Alexandru"},
                            {"Avram", "Alexandra"},
                            {"Butucel", "Razvan"},
                            {"Cernescu", "Diana"},
                            {"Davidoiu", "Claudiu"},
                            {"Enache", "Cristian"},
                            {"Ghideu", "Andrei"},
                            {"Ilie", "Adrian"},
                            {"Ilie", "Catalin"}
    };
    
    static String[] cnpUri =   { "2970106297200",
                            "1990305297201",
                            "2990101297202",
                            "1980806297203",
                            "2991101297204",
                            "1980709297205",
                            "1971203297206",
                            "1990502297207",
                            "1990402972508",
                            "1980730297298"
    };
    
    
    /* teminare definire date de test */
    
    static public class StudentDetails {
        String nume;
        String prenume;
        double[] noteLibRomana = new double[10];
        double[] noteMatematica = new double[10];
    }
    
    static StudentDetails student;
    
    public static void printStudent(String cnp, StudentDetails student) {
        System.out.println("[" + cnp + "] - " + student.prenume + ", " + student.nume);
        System.out.println("  note Romana: " + Arrays.toString(student.noteLibRomana));
        System.out.println("  note Mate:   " + Arrays.toString(student.noteMatematica));
    }

    public static HashMap<String, StudentDetails> catalog = new HashMap<String, StudentDetails>();
    public static LinkedHashMap<String, StudentDetails> lCatalog = new LinkedHashMap<String, StudentDetails>();
        
    public static void main(String []args){
        
        
        // 1. Creare catalog cu HashMap (generare note aleator intre 4 si 10)
        
        System.out.println("\nCatalogul (HashMap) este:");

        for (int i=0; i<10; i++) {
            student = new StudentDetails();
            student.nume = Studenti[i][0];
            student.prenume = Studenti[i][1];
            Random ran = new Random();
            for (int j=0; j<10; j++) {
                student.noteLibRomana[j] = ran.nextInt(7) + 4;
                student.noteMatematica[j] = ran.nextInt(7) + 4;
            }
            printStudent(cnpUri[i], student);
            catalog.put(cnpUri[i], student);
        }

        // Afisare informatii pentru studentul cu CNP introdus la consola:
        System.out.print("\nIntrodu CNP: ");
        Scanner scanner = new Scanner(System.in);
        String studCNP = scanner.nextLine();
        StudentDetails s = catalog.get(studCNP);
        if (s!=null) {
            System.out.println("\nDetaliile pentru studentul cu CNP: ["+studCNP+"] sunt:");
            printStudent(studCNP, s);
            System.out.println();
        } else {
            System.out.println("\nStudentul cu CNP: ["+studCNP+"] nu exista in catalog");
        }
        
        // 5. Rescriere detalii pentru studentul cu CNP introdus anterior la consola, 
        // daca exista in catalog CNP-ul respectiv
        if (s!=null) {
			// modificare prenume
            s.prenume = "Noname";
			// modificare a doua nota la Romana si la Mate
            s.noteLibRomana[2-1] = 10.0;
            s.noteMatematica[2-1] = 10.0;
            catalog.put(studCNP, s);
        }
        
        // re-afisare detalii catalog pentru acelasi student:
        s = catalog.get(studCNP);
        if (s!=null) {
            System.out.println("\nNoile detaliile pentru studentul cu CNP: ["+studCNP+"] sunt:");
            printStudent(studCNP, s);
            System.out.println();
        } else {
            System.out.println("\nStudentul cu CNP: ["+studCNP+"] nu exista in catalog");
        }
     
        
        // 2. Afisare catalog cu getKey()
        System.out.println("\nAfisare catalog (HashMap):");
        Set set = catalog.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry)iterator.next();
            String rCNP = (String) mentry.getKey();
            StudentDetails rSD = new StudentDetails();
            rSD = (StudentDetails) mentry.getValue();
            printStudent( rCNP, rSD );
        }


         // 3. Creare catalog cu LinkedHashMap (generare note aleator intre 4 si 10)

        System.out.println("\nCatalogul (LinkedHashMap) este:");

        for (int i=0; i<10; i++) {
            student = new StudentDetails();
            student.nume = Studenti[i][0];
            student.prenume = Studenti[i][1];
            Random ran = new Random();
            for (int j=0; j<10; j++) {
                student.noteLibRomana[j] = ran.nextInt(7) + 4;
                student.noteMatematica[j] = ran.nextInt(7) + 4;
            }
            printStudent(cnpUri[i], student);
            lCatalog.put(cnpUri[i], student);
        }

        // Afisarea catalogului generat cu LinkedHashMap
        System.out.println("\nAfisare catalog (LinkedHashMap):");
        Set lSet = lCatalog.entrySet();
        Iterator lIterator = lSet.iterator();
        while(lIterator.hasNext()) {
            Map.Entry lMentry = (Map.Entry)lIterator.next();
            String rCNP = (String) lMentry.getKey();
            StudentDetails rSD = new StudentDetails();
            rSD = (StudentDetails) lMentry.getValue();
            printStudent( rCNP, rSD );
        }

 
     }
}