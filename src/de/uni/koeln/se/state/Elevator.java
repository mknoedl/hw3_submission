package de.uni.koeln.se.state;


public class Elevator {

    public static int current_Floor = 5;
    int dest_Floor;

    private Elv_States State = new Elv_States();

    public Elevator(int dest_floor) {
        this.dest_Floor = dest_floor;
        System.out.println("*** Destination floor is: " + dest_Floor);
        State.CurrentState = State.Idle;
        if(dest_floor>current_Floor){
            moving_up();
        }else if (dest_floor<current_Floor){
            moving_down();
        }
        arrive_atFloor();


    }

    private void arrive_atFloor() {
        if (current_Floor==dest_Floor){
            State.CurrentState = State.Idle;
            exit();
        }
    }

    private void moving_up() {
        if(current_Floor+1 <10){
            State.CurrentState = State.Moving_up;
            current_Floor++;
            System.out.println("Current floor: "+current_Floor);
            if(current_Floor != dest_Floor) {
                moving_up();
            }
        }

    }

    private void moving_down() {
        if(current_Floor+1 <10){
            State.CurrentState = State.Movinig_down;
            current_Floor--;
            System.out.println("Current floor: "+current_Floor);
            if(current_Floor != dest_Floor) {
                moving_down();
            }
        }
    }

    private void exit(){
        System.out.println("Exit");
    }
}
