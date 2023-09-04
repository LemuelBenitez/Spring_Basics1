package com.springfw.practicespringframework.helloWorld;

import com.springfw.practicespringframework.game.GameRunner;
import com.springfw.practicespringframework.game.MarioGame;
import com.springfw.practicespringframework.game.PacManGame;
import com.springfw.practicespringframework.game.SuperContraGame;

public class AppGamingBasic {
	public static void main(String[] args) {
		//var marioGame = new MarioGame();
		//Was tightly coupled. GamingConsole interface is used to decouple
		//It is now loosely coupled as a result
		var game1 = new SuperContraGame();
		var game2 = new MarioGame();
		var game3 = new PacManGame();
		
		var gameRunner = new GameRunner(game3);
		//Wiring dependency."game" is a dependency
		//"game" is injected
		gameRunner.run();
	}

}
