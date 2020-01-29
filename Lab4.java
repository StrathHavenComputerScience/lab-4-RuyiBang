public class Lab4
{
  public static void turnRight()
  {
    Robot.turnLeft();
    Robot.turnLeft();
    Robot.turnLeft();
  }
  
  public static void turnAround()
  {
    Robot.turnLeft();
    Robot.turnLeft();
  }

  public static void backUp()
  {
    turnAround();
    Robot.move();
    turnAround();
  }
  
  public static void completeBars()
  {
    int x = 1;
    int y = 1;
    while(Robot.frontIsClear()){
        Robot.move();
        x++;
    }
    turnAround();
    while(Robot.frontIsClear()){
        Robot.move();
    }
    turnRight();
    while(Robot.frontIsClear()){
        Robot.move();
        y++;
    }
    turnAround();
    while(Robot.frontIsClear()){
        Robot.move();
    }
    turnAround();
    for(int i =0; i<x; i++){
        for(int o=0; o<y;o++){
            if(Robot.onDark()){
                o=y;
                turnAround();
                while(Robot.frontIsClear()) {
                    Robot.move();
                }
                if(i<x-1){
                    Robot.turnLeft();
                    Robot.move();
                    Robot.turnLeft();
                }
            } else {
                Robot.makeDark();
                Robot.move();
            }
        }
    }
  }
  
  public static void testCompleteBars1()
  {
    Robot.load("bars1.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void testCompleteBars2()
  {
    Robot.load("bars2.txt");
    Robot.setDelay(0.025);
    completeBars();
  }
  
  public static void combinePiles()
  {
    int ex = 0;
  	int space = 1;
  	if (Robot.onDark()){
        	ex++;
    	}
  	while(Robot.frontIsClear()){
      	Robot.move();
      	space++;
      	if (Robot.onDark()){
        	ex++;
    	}
    	}
    	turnAround();
    	if (Robot.onDark()){
        	Robot.makeLight();
    	}
    	while(Robot.frontIsClear()){
        	Robot.move();
        	if (Robot.onDark()){
        	Robot.makeLight();
        	}
    	}
    	Robot.turnLeft();
    	Robot.move();
    	Robot.turnLeft();
    	for(int i =0; i<space; i++){
        	if(Robot.onDark() != true && ex > 0){
            	Robot.makeDark();
            	ex--;
        	}
        	if (i<space-1){
            	Robot.move();
        	}
    	}
  }

  public static void testCombinePiles1()
  {
    Robot.load("piles1.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void testCombinePiles2()
  {
    Robot.load("piles2.txt");
    Robot.setDelay(0.025);
    combinePiles();
  }
  
  public static void connectDots()
  {
    while(Robot.onDark()){
      boolean left = false;
      boolean front = false;
      boolean right = false;
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            left = true;
        }
        turnAround();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            front = true;
        }
        turnAround();
        Robot.move();
        Robot.move();
        Robot.turnLeft();
        Robot.move();
        Robot.move();
        if(Robot.onDark()){
            right = true;
        }
        turnAround();
        Robot.move();
        Robot.move();
        turnRight();
        if(left != false){
            Robot.turnLeft();
            Robot.move();
            Robot.makeDark();
            Robot.move();
        } 
        if (front != false){
            Robot.move();
            Robot.makeDark();
            Robot.move();
        } 
        if (right != false){
            turnRight();
            Robot.move();
            Robot.makeDark();
            Robot.move();
        }
        if (left != true && front != true && right != true){
            break;
        }
    }
  }
  
  public static void testConnectDots1()
  {
    Robot.load("connect1.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
  
  public static void testConnectDots2()
  {
    Robot.load("connect2.txt");
    Robot.setDelay(0.025);
    connectDots();
  }
}
