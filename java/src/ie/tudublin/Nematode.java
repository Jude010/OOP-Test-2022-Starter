package ie.tudublin;




import processing.data.TableRow;

public class Nematode {

    private boolean legs;
    private String name;
    private String gender;
    private boolean eyes;
    private int length;
    
    public boolean isLegs() {
        return legs;
    }
    public void setLegs(boolean legs) {
        this.legs = legs;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    
    public boolean isEyes() {
        return eyes;
    }
    public void setEyes(boolean eyes) {
        this.eyes = eyes;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }


    public Nematode(TableRow row)
    {
        if( row.getInt("limbs") == 0 )
        {
            this.legs= false;
        }else
        {
            this.legs = true;
        }

        if( row.getInt("eyes") == 0)
        {
            this.eyes = false;
        }else
        {
            this.eyes = true;
        }

        this.length = row.getInt("length");

        this.gender = row.getString("gender");

        this.name = row.getString("name");
    }



    
}
