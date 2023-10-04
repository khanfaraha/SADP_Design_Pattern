class Vehicle 
{
   
    protected String name; 

    public Vehicle(String name) { 
        this.name = name;
    }
    
    public void drive() { 
        System.out.println(name + " is being driven.");
    }
}
class Toyota extends Vehicle 
{
    String model; 
    String Toyotaname;

   
    public Toyota(String name, String model) { 
        
        super(model); 
        this.model = model;
    }

   
    public void rev() { 
        System.out.println("BhoomBhoom");
    }

   
    public void accelerate(int speed) { 
        
        System.out.println(Toyotaname + " is accelerating to " + speed + " km/h.");
    }
}
class Task_2{
    public static void main(String[] args) 
    {
       
        Toyota toyota = new Toyota("Prado 6", "2023");
        
        System.out.println("Name: " + toyota.name);
        
        System.out.println("Model: " + toyota.model);
        
        toyota.drive();
        
        toyota.rev();
        
        toyota.accelerate(350);
    }
}