//Name: Michael Pollock
//Time: 200 minutes
//Resources: NA


public class Hockey{
	public static void main(String [] args){
		//Get home and away goalies, set team point scores to 0
		Goalie homeG = new Goalie();
		Goalie awayG = new Goalie();
		int homeGoals = 0;
		int awayGoals = 0;

		//Name home and away goalies
		ConsoleIO.print("What is the name of the home team's goalie? ");
		homeG.name = ConsoleIO.readLine();
		ConsoleIO.print("What is the name of the visitor team's goalie? ");
		awayG.name = ConsoleIO.readLine();
		ConsoleIO.printLine("");

		//Record game action
		int choice = -1;
		int display = 0;//print choices every 5th submission
		int action = 0; //game plays
		int period = 1;
		boolean automate = false;
		ConsoleIO.printLine("Record game action as necessary.");
		while (period < 4){
			//Display every 5th action, take up less screen space, unless automating game
			if (display % 5 == 0 || display == 0 && !automate){
				ConsoleIO.printLine("");
				ConsoleIO.printLine("0) End period "+(period)+" of 3");
				ConsoleIO.printLine("1) Save by "+homeG.name+"!");
				ConsoleIO.printLine("2) "+homeG.name+" has been scored on!");
				ConsoleIO.printLine("3) Save by "+awayG.name+"!");
				ConsoleIO.printLine("4) "+awayG.name+" has been scored on!");
				ConsoleIO.printLine("5) Print current stats");
				ConsoleIO.printLine("6) Automate Play");
				ConsoleIO.printLine("");
			}
			action++;
			ConsoleIO.print("Period "+(period)+" of 3. Play # "+action+". Action: ");
			if (!automate){choice = Goalie.numEqls(0, 6);}
			display++;
			if (choice == 6){
				automate = true;
			}
			if (automate){
				if (Math.random()<.8 && display % 4 != 0){
					choice = 1+(int)(Math.random()*4);
				} else if (display % 4 == 0){
					choice = 5;
				} else {
					choice = 0;
				}
			}
			if (choice == 0){
				action--;
				ConsoleIO.printLine("");
				ConsoleIO.printLine("That's the end of period "+period+"!");
				ConsoleIO.printLine("We saw "+action+" play(s) that period.");
				Goalie.scoreBoard(period, homeGoals, awayGoals);
				action = 0;
				period++;
			}
			else if (choice == 1){
				ConsoleIO.printLine("Save by "+homeG.name+"!!");
				ConsoleIO.printLine("");
				homeG.sOG++;
				homeG.saves++;
			} else if (choice == 2){
				ConsoleIO.printLine("The visitors snuck one in!");
				ConsoleIO.printLine("");
				homeG.sOG++;
				awayGoals++;
			} else if (choice == 3){
				ConsoleIO.printLine("Save by "+awayG.name+"!!");
				awayG.sOG++;
				ConsoleIO.printLine("");
				awayG.saves++;
			} else if (choice == 4){
				ConsoleIO.printLine("Home Team GOOOAAAAAL!!!");
				ConsoleIO.printLine("");
				awayG.sOG++;
				homeGoals++;
			} else {
				Goalie.scoreBoard(period, homeGoals, awayGoals);
				ConsoleIO.printLine("Here are tonight's goalies current stats:");
				homeG.stats();
				awayG.stats();
				ConsoleIO.printLine("");
			}
		}

		//End of period 3 details
		ConsoleIO.printLine("That's the end of the third period!");
		ConsoleIO.printLine("Tonight's results brought to you by: DR KOW's CS-120 LAB 11");
		ConsoleIO.printLine("");
		Goalie.scoreBoard(period, homeGoals, awayGoals);
		ConsoleIO.printLine("");

		//Tie Breaker based save percentage set against random num generator

		//If, no shots on goal before end of game, generate random save percent so it doesn't go on forever
		//If savePercent is 100, lower by 1 so it doesn't go on forever.

		if (homeGoals > awayGoals){
			ConsoleIO.printLine("Wow, what a game! "+homeGoals+" to "+awayGoals+" with "+homeG.name+"'s team coming out on top!");
			homeG.stats();
		} else if (homeGoals < awayGoals){
			ConsoleIO.printLine("Wow, what a game! "+homeGoals+" to "+awayGoals+" with "+awayG.name+"'s team coming out on top!");
			awayG.stats();
		} else {
			ConsoleIO.printLine("Tie game! That means OOOOOOOOOverTIIIIIIIIMEEEEE");
			boolean goal = Goalie.boo(homeGoals, awayGoals);
			int otRound = 0;
			while (!goal){
				if (Math.random()*100 > Math.random()*(awayG.savePercent()*.2)+awayG.savePercent()*.8){
					otRound++;
					homeGoals++;
					goal = Goalie.boo(homeGoals, awayGoals);
					ConsoleIO.printLine("Home team GOOOAAAAL! "+homeG.name+"'s Team IS VICTORIOUS!!");
				} else {
					otRound++;
					ConsoleIO.printLine("A great shot, but a great block by "+awayG.name+"!");
				}
				if (Math.random()*100 > Math.random()*(homeG.savePercent()*.2)+homeG.savePercent()*.8 && !goal){
					otRound++;
					awayGoals++;
					goal = Goalie.boo(homeGoals, awayGoals);
					ConsoleIO.printLine("Away team GOOOAAAAL! "+awayG.name+"'s Team IS VICTORIOUS!!");
				} else if (!goal){
					otRound++;
					ConsoleIO.printLine("What a shot, AND WHAT A BLOCK by "+homeG.name+"!!!");
				}
			}
			ConsoleIO.printLine("");
			Goalie.scoreBoard(period, homeGoals, awayGoals);
			ConsoleIO.printLine("");
		}
	}
}