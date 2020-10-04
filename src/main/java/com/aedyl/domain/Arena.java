package com.aedyl.domain;

import com.aedyl.domain.combat.AttackResult;
import com.aedyl.domain.combat.Round;
import com.aedyl.domain.fighter.Human;
import com.aedyl.domain.fighter.HumanComparator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Arena {

	private List<Human> survivors;
	private int nbOfRoundExecuted = 0;

	public Arena(List<Human> fighters) {
		this.survivors = new ArrayList<>(fighters);
	}

	public List<Round> fight(int numberOfRoundLimit) {
		List<Round> rounds = new ArrayList<>();
		while (survivors.size() > 1 && nbOfRoundExecuted < numberOfRoundLimit) {
			final List<AttackResult> attackResults = survivors.stream()
					.filter(Human::isAlive)
					.sorted(HumanComparator::compareByInitiative)
					.map(human -> human.fight(survivors))
					.collect(Collectors.toList());

			// reduce size of survivor list to avoid useless iteration
			survivors = survivors.stream().filter(Human::isAlive).collect(Collectors.toList());

			nbOfRoundExecuted++;
			rounds.add(new Round(nbOfRoundExecuted, attackResults));
		}
		return rounds;
	}

	public List<Human> getSurvivors() {
		return survivors;
	}

	public int getNbOfRoundExecuted() {
		return nbOfRoundExecuted;
	}

	public boolean hasEnoughFighters() {
		return survivors.size() > 1;
	}
}
