//Goalie Instantiable class

public class Goalie{
	String name;
	int sOG;
	int saves;

	public void stats(){

		double savePercent;
		if (sOG == 0){
			savePercent = 100;
		} else {
			savePercent = saves*100/sOG;
		}
		ConsoleIO.printLine(name+" has saved "+saves+" out of "+sOG+" shots for a save percent of "+savePercent+"%.");
	}

	public double savePercent(){
		double savePercent;
		if (sOG == 0){
			savePercent = 100;
		} else {
			savePercent = saves*100/sOG;
		}
		return savePercent;
	}

	//Scoreboard for hockey game
	public static void scoreBoard(int period, int homeGoals, int awayGoals){
		ConsoleIO.printLine("");
		ConsoleIO.printLine(" ------------------------- ");
		ConsoleIO.printLine("|       SCOREBOARD        |");
		ConsoleIO.printLine("|       Period "+period+"          |");
		ConsoleIO.printLine("|  HOME: "+homeGoals+"       AWAY: "+awayGoals+"  |");
		ConsoleIO.printLine(" ------------------------- ");
		ConsoleIO.printLine("");
	}

	//Catch num input
	public static int numEqls(int bottom, int top){
		int userIn = ConsoleIO.readInt();
		while (bottom - 1 >= userIn || top + 1 <= userIn) {
			ConsoleIO.print("Please enter a choice from "+bottom+" to "+top+": ");
			userIn = ConsoleIO.readInt();
		}
		return userIn;
	}
	//Compare values to return true if they equal one another
	public static boolean boo(int i, int j){
		boolean diff = false;
		if (i != j){diff = true;} return diff;
	}
}
