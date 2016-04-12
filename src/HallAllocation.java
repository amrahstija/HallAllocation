
public class HallAllocation {
    
    public static class Student {
        int slNo;
        String rollNo;
        String name;
        String hall;
        
        public void show(){
            System.out.println(slNo + ". " + rollNo + " " + name + ": " + hall);
        }
    }
    
    static Student[] batch = new Student[1200];
    static int count;
    
    public static void showAll(){
        for(int i=0; i<count; i++){
            batch[i].show();
        }
    }
    
    public static void showByHall(String hall){
        int hallCount = 0;
        for(int i=0; i<count; i++)
            if(batch[i].hall.equalsIgnoreCase(hall)){
                batch[i].show();
                hallCount++;
            }
        System.out.println("(" + hallCount + " students)");
    }
    
    public static void showByDep(String dep){
        int depCount = 0;
        for(int i=0; i<count; i++)
            if(batch[i].rollNo.substring(2, 4).equalsIgnoreCase(dep)){
                batch[i].show();
                depCount++;
            }
        System.out.println("(" + depCount + " students)");
    }
    
    public static void showByHallAndDep(String hall, String dep){
        int Count = 0;
        for(int i=0; i<count; i++)
            if(batch[i].hall.equalsIgnoreCase(hall) && batch[i].rollNo.substring(2, 4).equalsIgnoreCase(dep)){
                batch[i].show();
                Count++;
            }
        System.out.println("(" + Count + " students)");
    }
    
    public static void showByName (String name){
        for(int i=0; i<count; i++)
            if(batch[i].name.equalsIgnoreCase(name))
                batch[i].show();
    }
    public static void main(String[] args) {
        int i=0;
        String word = " ";                        //temporary variable to store words
        TextIO.readFile("src/halls");
        
        while(true){
            
            try{
            while(!((word = TextIO.getWord()).equals(Integer.toString(i + 1))));
            }catch(Exception e){
                break;
            }
            
            batch[i] = new Student();
            batch[i].slNo = i + 1;
            batch[i].name = "";
            
            while(!((word = TextIO.getWord()).startsWith("14"))){
                batch[i].name += " " + word;
            }
            batch[i].name = batch[i].name.trim();
            
            batch[i].rollNo = word;
            batch[i].hall =  TextIO.getWord();
            
            i++;
        }
        
        count = i;
        //showAll();
        /*String[] halls = {"RP", "RK", "MS", "VS", "LBS", "LLR", "AZAD", "PATEL", "NEHRU", "HJB", "JCB"};
        System.out.println("BY HALL:");
        for(i=0; i<halls.length; i++)
            showByHall(halls[i]);
        String[] deps = {"AE", "AG", "AR", "BT", "CE", "CH", "CS", "CY", "EC", "EE", "EX", "GG", "HS",
            "IE", "IM", "MA", "ME", "MI", "MT", "NA", "PH", "QD"};
        System.out.println("BY DEPARTMENT:");
        for(i=0; i<halls.length; i++)
            showByDep(deps[i]);
        */
        showByHallAndDep("rp", "ae");
    }
    
    
}
