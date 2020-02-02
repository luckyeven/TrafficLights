class TrafficLight
{

status {

  modes{
    normalTraffic()->northAndSouthGreen;
    lowlTraffic()->northAndSouthGreen;
    highTraffic()->northAndSouthGreen;
    moderateTraffic()->moderateNorthGreenLeftArrow;
  
  }
  


  
  northAndSouthGreen { 
    entry / { trafficLightManager.northGreen(); }
    entry / { trafficLightManager.southGreen(); }
    entry / { trafficLightManager.westRed(); }
    entry / { trafficLightManager.eastRed(); }
    timerGreen() -> northAndSouthYellow;
  }
  
  northAndSouthYellow {
    entry / { trafficLightManager.northYellow(); }
    entry / { trafficLightManager.southYellow(); }
    entry / { trafficLightManager.westRed(); }
    entry / { trafficLightManager.eastRed(); }
    
  }
  
  northAndSouthRed {
    entry / { trafficLightManager.northRed(); }
    entry / { trafficLightManager.southRed(); }
    entry / { trafficLightManager.westGreen(); }
    entry / { trafficLightManager.eastGreen(); }
    timerGreen() -> westAndEastYellow;
  }
  
  westAndEastYellow{
    entry / { trafficLightManager.northRed(); }
    entry / { trafficLightManager.southRed(); }
    entry / { trafficLightManager.westYellow(); }
    entry / { trafficLightManager.eastYellow(); }
    timerYellow() -> northAndSouthGreen;
  }

  moderateNorthGreenLeftArrow{
   entry/{ trafficLightManager.northGreenAndArrow(); } 
  
   entry/{trafficLightManager.westRed();}
   entry/{trafficLightManager.eastRed();}
   entry/{ trafficLightManager.southRed(); } 
   timerGreen()->moderateNorthYellow;
  
 }
  moderateNorthYellow{
    entry/{ trafficLightManager.northYellow(); } 
    entry/{ trafficLightManager.westRed(); } 
    entry/{ trafficLightManager.eastRed(); } 
    entry/{ trafficLightManager.southRed(); } 
    timerYellow()->moderateSouthGreenLeftArrow;
  
  }
  
  moderateSouthGreenLeftArrow{
    entry/{ trafficLightManager.northRed(); } 
    entry/{ trafficLightManager.westRed(); } 
    entry/{ trafficLightManager.eastRed(); } 
    entry/{ trafficLightManager.southGreenAndArrow(); } 
     
    timerGreen->moderateSouthYellow;
  
  }
  moderateSouthYellow{
    entry / { trafficLightManager.northRed(); }
    entry / { trafficLightManager.southYellow(); }
    entry / { trafficLightManager.westRed(); }
    entry / { trafficLightManager.eastRed(); }
    timerYellow->westAndEastGreen;
  
  
  }
  westAndEastGreen{
    entry / { trafficLightManager.northRed(); }
    entry / { trafficLightManager.southRed(); }
    entry / { trafficLightManager.westGreen(); }
    entry / { trafficLightManager.eastGreen(); }
   timerGreen-> moderateNorthAndSouthRed;
  }
  
  moderateNorthAndSouthRed{
    entry / { trafficLightManager.northRed(); }
    entry / { trafficLightManager.southRed(); }
    entry / { trafficLightManager.westYellow(); }
    entry / { trafficLightManager.eastYellow(); }
   timerYellow-> moderateNorthGreenLeftArrow;
  
  }
  
  
}
}