package com.aedyl.console;

import com.aedyl.domain.Game;

public class Main {


	public static void main(String[] args) {

		final int numberOfFighter = 1000;
		final int nbRoundByStep = 5;
		final int numberStep = 5;

		Game game = new Game();
		game.launch(numberOfFighter, nbRoundByStep, numberStep);
	}


}
