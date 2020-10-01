package com.aedyl.domain.combat;

import com.aedyl.domain.characteristics.Characteristics;
import com.aedyl.domain.fighter.Human;

import java.util.UUID;

public record Attacker(UUID id,
                       String name,
                       Characteristics characteristics) {
	public static Attacker fromHuman(Human attacker) {
		return new Attacker(attacker.uniqueId, attacker.name, attacker.getCharacteristics());
	}
}