package SEG2106.core;
/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.19.0.3369 modeling language!*/



// line 1 "model.ump"
public class TrafficLight implements EventHandler
{
  @java.lang.annotation.Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
  public @interface umplesourcefile{int[] line();String[] file();int[] javaline();int[] length();}

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //TrafficLight State Machines
  public enum Status { modes, northAndSouthGreen, northAndSouthYellow, northAndSouthRed, westAndEastYellow, moderateNorthGreenLeftArrow, moderateNorthYellow, moderateSouthGreenLeftArrow, moderateSouthYellow, westAndEastGreen, moderateNorthAndSouthRed }
  private Status status;

  //------------------------
  // CONSTRUCTOR
  //------------------------
  private TrafficLightManager trafficLightManager; 
  public TrafficLight(TrafficLightManager trafficLightManager)
  {
	this.trafficLightManager = trafficLightManager;
	  
	setStatus(Status.moderateNorthGreenLeftArrow);
    
    trafficLightManager.addEventHandler(this);
  }

//------------------------
  // INTERFACE
  //------------------------


  public String getStatusFullName()
  {
    String answer = status.toString();
    return answer;
  }

  public Status getStatus()
  {
    return status;
  }

  public boolean normalTraffic()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus)
    {
      case modes:
        setStatus(Status.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean lowlTraffic()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus)
    {
      case modes:
        setStatus(Status.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }




  public boolean timerGreen()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus)
    {
      case northAndSouthGreen:
        setStatus(Status.northAndSouthYellow);
        wasEventProcessed = true;
        break;
      case northAndSouthRed:
        setStatus(Status.westAndEastYellow);
        wasEventProcessed = true;
        break;
      case moderateNorthGreenLeftArrow:
        setStatus(Status.moderateNorthYellow);
        wasEventProcessed = true;
        break;
      case moderateSouthGreenLeftArrow:
        setStatus(Status.moderateSouthYellow);
        wasEventProcessed = true;
        break;
      case westAndEastGreen:
        setStatus(Status.moderateNorthAndSouthRed);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  public boolean timerYellow()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus)
    {
      case northAndSouthYellow:
        setStatus(Status.northAndSouthRed);
        wasEventProcessed = true;
        break;
      case westAndEastYellow:
        setStatus(Status.northAndSouthGreen);
        wasEventProcessed = true;
        break;
      case moderateNorthYellow:
        setStatus(Status.moderateSouthGreenLeftArrow);
        wasEventProcessed = true;
        break;
      case moderateSouthYellow:
        setStatus(Status.westAndEastGreen);
        wasEventProcessed = true;
        break;
      case moderateNorthAndSouthRed:
        setStatus(Status.moderateNorthGreenLeftArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

  private void setStatus(Status aStatus)
  {
    status = aStatus;

    // entry actions and do activities
    switch(status)
    {
      case northAndSouthGreen:
        // line 19 "model.ump"
        trafficLightManager.northGreen();
        // line 20 "model.ump"
        trafficLightManager.southGreen();
        // line 21 "model.ump"
        trafficLightManager.westRed();
        // line 22 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthYellow:
        // line 27 "model.ump"
        trafficLightManager.northYellow();
        // line 28 "model.ump"
        trafficLightManager.southYellow();
        // line 29 "model.ump"
        trafficLightManager.westRed();
        // line 30 "model.ump"
        trafficLightManager.eastRed();
        break;
      case northAndSouthRed:
        // line 35 "model.ump"
        trafficLightManager.northRed();
        // line 36 "model.ump"
        trafficLightManager.southRed();
        // line 37 "model.ump"
        trafficLightManager.westGreen();
        // line 38 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case westAndEastYellow:
        // line 43 "model.ump"
        trafficLightManager.northRed();
        // line 44 "model.ump"
        trafficLightManager.southRed();
        // line 45 "model.ump"
        trafficLightManager.westYellow();
        // line 46 "model.ump"
        trafficLightManager.eastYellow();
        break;
      case moderateNorthGreenLeftArrow:
        // line 51 "model.ump"
        trafficLightManager.northGreenAndArrow();
        // line 53 "model.ump"
        trafficLightManager.westRed();
        // line 54 "model.ump"
        trafficLightManager.eastRed();
        // line 55 "model.ump"
        trafficLightManager.southRed();
        break;
      case moderateNorthYellow:
        // line 60 "model.ump"
        trafficLightManager.northYellow();
        // line 61 "model.ump"
        trafficLightManager.westRed();
        // line 62 "model.ump"
        trafficLightManager.eastRed();
        // line 63 "model.ump"
        trafficLightManager.southRed();
        break;
      case moderateSouthGreenLeftArrow:
        // line 69 "model.ump"
        trafficLightManager.northRed();
        // line 70 "model.ump"
        trafficLightManager.westRed();
        // line 71 "model.ump"
        trafficLightManager.eastRed();
        // line 72 "model.ump"
        trafficLightManager.southGreenAndArrow();
        break;
      case moderateSouthYellow:
        // line 78 "model.ump"
        trafficLightManager.northRed();
        // line 79 "model.ump"
        trafficLightManager.southYellow();
        // line 80 "model.ump"
        trafficLightManager.westRed();
        // line 81 "model.ump"
        trafficLightManager.eastRed();
        break;
      case westAndEastGreen:
        // line 87 "model.ump"
        trafficLightManager.northRed();
        // line 88 "model.ump"
        trafficLightManager.southRed();
        // line 89 "model.ump"
        trafficLightManager.westGreen();
        // line 90 "model.ump"
        trafficLightManager.eastGreen();
        break;
      case moderateNorthAndSouthRed:
        // line 95 "model.ump"
        trafficLightManager.northRed();
        // line 96 "model.ump"
        trafficLightManager.southRed();
        // line 97 "model.ump"
        trafficLightManager.westYellow();
        // line 98 "model.ump"
        trafficLightManager.eastYellow();
        break;
    }
  }

  public void delete()
  {}



  @Override
  public boolean moderateTraffic()
  {
    boolean wasEventProcessed = false;

    Status aStatus = status;
    switch (aStatus)
    {
      case modes:
        setStatus(Status.moderateNorthGreenLeftArrow);
        wasEventProcessed = true;
        break;
      default:
        // Other states do respond to this event
    }

    return wasEventProcessed;
  }

@Override
public boolean lowTraffic() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean highTraffic()
{
  boolean wasEventProcessed = false;

  Status aStatus = status;
  switch (aStatus)
  {
    case modes:
      setStatus(Status.northAndSouthGreen);
      wasEventProcessed = true;
      break;
    default:
      // Other states do respond to this event
  }

  return wasEventProcessed;
}

}