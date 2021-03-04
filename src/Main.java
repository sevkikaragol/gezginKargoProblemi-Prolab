
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import jdk.nashorn.internal.parser.TokenType;
/**
 *
 * @author sevkikaragol
 */
public class Main {
    
  
    static ArrayList<String>sehirler=new ArrayList<>(); 
    
    static ArrayList<ArrayList<Integer>> array = new ArrayList<ArrayList<Integer>>();
    
    static ArrayList<ArrayList<Integer>> rotalar = new ArrayList<ArrayList<Integer>>();
    
    static ArrayList<Integer>noktalar=new ArrayList<Integer>();
    
    static int uzaklik[] = new int[81];
    
    static ArrayList<ArrayList<Integer>> rotalarYeni = new ArrayList<ArrayList<Integer>>();
    
    static int enKisaMesafe[]=new int[15];
    
     static int koordinat[][]=new int [81][2];
    
    static int sevk=0;
     
    public static int minMesafe(int uzaklik[], Boolean dKontrol[]) 
    { 
       
        int min=Integer.MAX_VALUE, minIndex = -1; 
  
        for (int v = 0; v < 81; v++) 
            if (dKontrol[v] == false && uzaklik[v]<=min) { 
                min = uzaklik[v]; 
                minIndex = v; 
            } 
  
        return minIndex; 
    } 
  
    public static void dijkstra(int graf[][], int dugum) 
    {   
        
        
        int i,j;
        int flag=0;
       
        for(i=0;i<81;i++){
            array.add(new ArrayList());
        }
        for(i=0;i<81;i++){
            array.get(i).add(i);
        }
       
        Boolean dKontrol[] = new Boolean[81]; 
  
        for (i=0;i<81;i++) { 
            uzaklik[i]=Integer.MAX_VALUE; 
            dKontrol[i]=false; 
        } 
  
     
        uzaklik[dugum]=0; 
  
        for(int s=0;s<81-1;s++) { 
            
            int u=minMesafe(uzaklik, dKontrol); 
  
            dKontrol[u]=true; 
            
            for(int v=0;v<81;v++) 
            {
            
            if (dKontrol[v]==false&&graf[u][v]!=0&&
            uzaklik[u]!=Integer.MAX_VALUE&&uzaklik[u]+graf[u][v]< uzaklik[v]){
                    uzaklik[v]=uzaklik[u]+graf[u][v];
                    
                    if(array.get(u).size()==1){
                        array.get(v).add(u);
                    }
                    else{
                      
                        for(flag=0;flag<array.get(u).size();flag++){
                            
                            array.get(v).add(array.get(u).get(flag));
                         
                        }
                    }
        }   
        }
        }
       
        for(i=0;i<81;i++){
            
            final int x=array.get(i).indexOf(dugum);
            
            
            while(true){
            
            if(array.get(i).size()==x+1) break;
                
            else{  
            int son=array.get(i).size()-1;
            array.get(i).remove(son);
                    }
            
        }
              
        }
        
          
        for(i=0;i<81;i++){
            
            Collections.reverse(array.get(i));
            
             
        }
     
    } 
        public static int minBul(Boolean kontrol[]){
            
           int enYakin=Integer.MAX_VALUE;
           int minIndex = 0;
           int i;
        
           
           for(i=0;i<noktalar.size();i++){
               
               if(kontrol[i]!=true&&uzaklik[noktalar.get(i)]<enYakin){
                   enYakin=uzaklik[noktalar.get(i)];
                        
                   minIndex=noktalar.get(i);
                   
               } 
               
           }
           
        return minIndex;
        
    }
        
        public static ArrayList clearFonks(ArrayList a)
        {  
            int i;
            for(i=0;i<81;i++){
                array.get(i).clear();
            }
            return array;
        }
        
        
        public static ArrayList rotaEkle(int plaka,int sayac)
        {
            rotalar.get(sayac).addAll(array.get(plaka));
            int boyut=rotalar.get(sayac).size();
            rotalar.get(sayac).remove(boyut-1);
                        
            return rotalar;
            
        } 
        
        
        public static int arrlKiyas(ArrayList a,ArrayList b){
            
        ArrayList<Integer> ortakElamanlar = new ArrayList<>(a);
        ortakElamanlar.retainAll(b);
		
        if(ortakElamanlar.size()==a.size())return 1;
        
        else return 0;
            
            
            
            
            
           
        }
       
   
    public static void main(String[] args) {
        
           int kmatrisi[][] =new int[81][81];
           int lineFlag=0;
           int z;
           try(Scanner reader = 
             new Scanner(new BufferedReader(new FileReader("src\\komsuluk.txt")))) {
            
            while (reader.hasNextLine()) {
                
                String line =reader.nextLine();
                String[] lineArray= line.split(",");
               for(z=0;z<81;z++){
                   
                   kmatrisi[lineFlag][z]= Integer.valueOf(lineArray[z]);
               }
               lineFlag++;
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Okumaya calistiginiz dosya bulunamadi!");
        } 
           catch (IOException ex) {
            System.out.println("Dosya acilirken bir hata ile karsilasildi!");
        }
           
          
           lineFlag=0;
           
           try(Scanner reader = 
             new Scanner(new BufferedReader(new FileReader("src\\sehirPikselleri.txt")))) {
            
            while (reader.hasNextLine()) {
                
                String line =reader.nextLine();
                String[] lineArray= line.split(",");
               for(z=0;z<2;z++){
                   
                   if(z==0){
                   koordinat[lineFlag][z]= (Integer.valueOf(lineArray[z]));
                   }
                   if(z==1){
                    koordinat[lineFlag][z]= (Integer.valueOf(lineArray[z]));
                   }
                  
               }
               lineFlag++;
            }
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Okumaya calistiginiz dosya bulunamadi!");
        } 
           catch (IOException ex) {
            System.out.println("Dosya acilirken bir hata ile karsilasildi!");
        }
           
        
        
        sehirler.add("Adana");
        sehirler.add("Adiyaman");
        sehirler.add("Afyonkarahisar");
        sehirler.add("Agri");
        sehirler.add("Amasya");
        sehirler.add("Ankara");
        sehirler.add("Antalya");
        sehirler.add("Artvin");
        sehirler.add("Aydin");
        sehirler.add("Balikesir");
        sehirler.add("Bilecik");
        sehirler.add("Bingol");
        sehirler.add("Bitlis");
        sehirler.add("Bolu");
        sehirler.add("Burdur");
        sehirler.add("Bursa");
        sehirler.add("Canakkale");
        sehirler.add("Cankiri");
        sehirler.add("Corum");
        sehirler.add("Denizli");
        sehirler.add("Diyarbakir");
        sehirler.add("Edirne");
        sehirler.add("Elazig");
        sehirler.add("Erzincan");
        sehirler.add("Erzurum");
        sehirler.add("Eskisehir");
        sehirler.add("Gaziantep");
        sehirler.add("Giresun");
        sehirler.add("Gumushane");
        sehirler.add("Hakkari");
        sehirler.add("Hatay");
        sehirler.add("Isparta");
        sehirler.add("Mersin");
        sehirler.add("Istanbul");
        sehirler.add("Izmir");
        sehirler.add("Kars");
        sehirler.add("Kastamonu");
        sehirler.add("Kayseri");
        sehirler.add("Kirklareli");
        sehirler.add("Kirsehir");
        sehirler.add("Kocaeli");
        sehirler.add("Konya");
        sehirler.add("Kutahya");
        sehirler.add("Malatya");
        sehirler.add("Manisa");
        sehirler.add("Kahramanmaras");
        sehirler.add("Mardin");
        sehirler.add("Mugla");
        sehirler.add("Mus");
        sehirler.add("Nevsehir");
        sehirler.add("Nigde");
        sehirler.add("Ordu");
        sehirler.add("Rize");
        sehirler.add("Sakarya");
        sehirler.add("Samsun");
        sehirler.add("Siirt");
        sehirler.add("Sinop");
        sehirler.add("Sivas");
        sehirler.add("Tekirdag");
        sehirler.add("Tokat");
        sehirler.add("Trabzon");
        sehirler.add("Tunceli");
        sehirler.add("Sanliurfa");
        sehirler.add("Usak");
        sehirler.add("Van");
        sehirler.add("Yozgat");
        sehirler.add("Zonguldak");
        sehirler.add("Aksaray");
        sehirler.add("Bayburt");
        sehirler.add("Karaman");
        sehirler.add("Kirikkale");
        sehirler.add("Batman");
        sehirler.add("Sirnak");
        sehirler.add("Bartin");
        sehirler.add("Ardahan");
        sehirler.add("Igdir");
        sehirler.add("Yalova");
        sehirler.add("Karabuk");
        sehirler.add("Kilis");
        sehirler.add("Osmaniye");
        sehirler.add("Duzce");
       
      
        
        
        
        
            Scanner scan=new Scanner(System.in);
            int tes;
            
            int i,j,k;

           
            

            System.out.println("!!!Sehir isimlerini girerken ilk harfi buyuk "+
                    "yaziniz ve Turkce karakter kullanmayiniz!!!");
            System.out.println("Sehir isimlerini tam ve aralarinda birer bosluk"+
                    " birakarak giriniz ya da alt alta giriniz.");
            
            System.out.println("");
            System.out.println("");
            System.out.print("\tKac sehire teslimat yapacaksiniz? :");
            tes=scan.nextInt();
            System.out.println("Hangi sehirlere teslimat yapacaksiniz? :");
            
              //yeni sürüme eklenecek
              for( i=0;i<tes;i++){
                    rotalarYeni.add(new ArrayList());
        }
            
            for(i=0;i<tes;i++){
                String sehir=scan.next();
                int a=sehirler.indexOf(sehir);
                noktalar.add(a);
            }
            for(i=0;i<tes;i++){
                    rotalar.add(new ArrayList());
        }
            
            int mesafe[]=new int[tes];
            int sayac=0;
            int dügüm;
            Boolean kontrol[]=new Boolean[tes];
            
            
            for(i=0;i<kontrol.length;i++){
                kontrol[i]=false;
            }
          
            while (sayac<tes) {
                
              dijkstra(kmatrisi,40);
              
                int falseSay=0;
                
                dügüm=noktalar.get(sayac);
                kontrol[sayac]=true;
                rotaEkle(dügüm,sayac);
               
                for(i=0;i<noktalar.size();i++){
                    if(rotalar.get(sayac).contains(noktalar.get(i))){
                        kontrol[i]=true;
                    }
                }
                
                for(i=0;i<kontrol.length;i++){
                    if(kontrol[i]==false) {falseSay++;}
                }
               
                mesafe[sayac]+=uzaklik[dügüm];
                clearFonks(array);
                dijkstra(kmatrisi,dügüm);
                
                
               for(i=0;i<falseSay;i++){
                  
                   int minIndex=minBul(kontrol);
                   
                   kontrol[noktalar.indexOf(minIndex)]=true;
                   
                   rotaEkle(minIndex, sayac);
                   
                   mesafe[sayac]+=uzaklik[minIndex];
                   clearFonks(array);
                   
                   dijkstra(kmatrisi,minIndex);
                   
               }
                
               
                rotaEkle(40, sayac);
                mesafe[sayac]+=uzaklik[40];
                rotalar.get(sayac).add(40);
                
                sayac++;
                for(i=0;i<kontrol.length;i++){
                    kontrol[i]=false;
                }
                clearFonks(array);
        }
   
        
         
         Boolean[] sKontrol=new Boolean[tes];
         
         for (i = 0; i <tes; i++) {
            sKontrol[i] =false;
            
        }
         
        int sSayac=0;
        int yeniRotaSay=0;
        while(sSayac<tes){
        int min=Integer.MAX_VALUE, minIndex = -1; 
  
        for (int v = 0; v < tes; v++) 
            if (sKontrol[v] == false && mesafe[v]<=min) { 
                min = mesafe[v]; 
                minIndex = v; 
                
            }
        
        if(sSayac==0){
            
            enKisaMesafe[0]=min;
            rotalarYeni.get(0).addAll(rotalar.get(minIndex));
            yeniRotaSay++;
        }
        
       
        
        if(sSayac!=0 && arrlKiyas(rotalarYeni.get(yeniRotaSay-1),rotalar.get(minIndex))!=1){
            
          enKisaMesafe[yeniRotaSay]=min;
          rotalarYeni.get(yeniRotaSay).addAll(rotalar.get(minIndex));
           yeniRotaSay++;
          
        }
        
        sKontrol[minIndex]=true;
        sSayac++;
        
        }
           
         
        // Rotalarin siralanmis halini bastirdigimiz yer.
            System.out.println("");
            System.out.println("Teslim yapacaginiz sehirler için rotalar ↓↓↓");
           for(i=0;i<5;i++){
               
           if(enKisaMesafe[i]!=0){
               
           for(k=0;k<rotalarYeni.get(i).size();k++){
               System.out.print("→"+sehirler.get(rotalarYeni.get(i).get(k)));
           }
           System.out.println(" !!Mesafe-> "+enKisaMesafe[i]+" kmdir..");
           sevk++;
           }
           
           }   
         
      
        /*   
           Rotalarin siralamanmamis halinin bastirildigi alan
        System.out.println("eski sistem");
         
            System.out.println("");
            System.out.println("Teslim yapacaginiz sehirler için rotalar ↓↓↓");
           for(i=0;i<tes;i++){
               
           for(k=0;k<rotalar.get(i).size();k++){
               System.out.print("→"+sehirler.get(rotalar.get(i).get(k)));
           }
           System.out.println(" !!Mesafe-> "+mesafe[i]+" kmdir..");
           } 
      */
           
        Ekran1 anaEkran=new Ekran1();
         anaEkran.setVisible(true);
        
         
        
        
}
    
}