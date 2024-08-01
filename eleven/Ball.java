package eleven;


interface Moveable {
    void
    move();

    void
    stop();
}
    class Ball implements Moveable{
        public void move(){

            System.out.println("공이 움직인다");
        }


    public void stop(){
        System.out.println("공이 멈춘다.");
        }
    }

