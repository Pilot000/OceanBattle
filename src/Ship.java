import java.util.ArrayList;


public abstract class Ship
{
    boolean ShipDown = false;
    int shots;
    int  kindShipcount;
    ArrayList<String> locList = new ArrayList<String>();
    ArrayList<String> locListCopy = new ArrayList<String>();

    public abstract void down();


    /**
     * Created by Prof on 06.07.2015.
     */
    public static class oneKindShip extends Ship
    {
        public oneKindShip(){
            shots = 1;
            kindShipcount = 4;
        }


        public void down(){
            shots--;
            if (shots == 0){
                ShipDown = true;
            }
        }
    }

    /**
     * Created by Prof on 06.07.2015.
     */
    public static class twoKindShip extends Ship
    {
        public twoKindShip(){
            shots = 2;
            kindShipcount = 3;
        }


        public void down(){
            shots--;
            if (shots == 0){
                ShipDown = true;
            }
        }
    }

    /**
     * Created by Prof on 06.07.2015.
     */
    public static class threeKindShip extends Ship
    {
        public threeKindShip(){
            shots = 3;
            kindShipcount = 2;
        }


        public void down(){
            shots--;
            if (shots == 0){
                ShipDown = true;
            }
        }
    }

    /**
     * Created by Prof on 06.07.2015.
     */
    public static class fourKindShip extends Ship
    {
        public fourKindShip(){
            shots = 4;
            kindShipcount = 1;
        }


        public void down(){
            shots--;
            if (shots == 0){
                ShipDown = true;
            }
        }
    }
}
