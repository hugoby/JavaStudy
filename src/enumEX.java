/**
 * Package_name PACKAGE_NAME
 * Project_name JavaStudy
 * Created by lenovo on 2015/12/10 15:44
 */
public class enumEX {
    public enum State{
        ON("ON",1),OFF("OFF",2);
        private String name;
        private int index;
        private State(String n,int in){
            name=n;
            index=in;
        }
        public String toString(){
            return this.index+ "_"+this.name;
        }
    }

    public static void main(String args[]){
        for(State s:State.values())    //call the function values()
            System.out.println(s.name());  //call the function name()
        State switchState=State.ON;
        switch (switchState){
            case ON:
                System.out.println("ON");
                System.out.println(switchState.toString());
                break;
            case OFF:
                System.out.println("OFF");
                break;
            default:
                break;
        }
    }
}
