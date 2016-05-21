package hu.inf.unideb.dungeonraider.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import hu.inf.unideb.dungeonraider.dao.ItemDao;
import hu.inf.unideb.dungeonraider.dao.PlayersCharacterDao;
import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.Item;
import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;
import hu.inf.unideb.dungeonraider.domain.Race;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;
import hu.inf.unideb.dungeonraider.service.ConflictingEntityException;
import hu.inf.unideb.dungeonraider.service.ItemException;
import hu.inf.unideb.dungeonraider.service.MissingEntityException;
import hu.inf.unideb.dungeonraider.service.PlayerService;

@Service("playerService")
public class PlayerServiceImpl implements PlayerService {

	@Autowired
	private PlayersCharacterDao characterDao;
	@Autowired
	private ItemDao itemDao;

	@Override
	@Transactional
	public void createNewCharacter(Integer health, Integer dexterity, Integer strength, Integer quickness, String name, String password) {

		// PlayersCharacter actual = characterDao.findByNameAndPassword(name, password);

		PlayersCharacter maybeConflictByName = characterDao.findByName(name);
		List<String> conflictingPropertyNames = new LinkedList<String>();
		if (maybeConflictByName != null) {
			conflictingPropertyNames.add("name");
			throw new ConflictingEntityException(conflictingPropertyNames);
			// if (actual != null) {
			// List<String> conflictingPropertyNames = new LinkedList<String>();
			// if (actual.getName().equals(name))
			// conflictingPropertyNames.add("name");
			// if (actual.getPassword().equals(password))
			// conflictingPropertyNames.add("password");
			//
			// throw new ConflictingEntityException(conflictingPropertyNames);
		} else {

			PlayersCharacter character = new PlayersCharacter();
			character.setStrength(strength);
			character.setDexterity(dexterity);
			character.setQuickness(quickness);
			character.setHealth(health);

			character.setActualExp(0);
			character.setAttackPoints(20 + quickness * 2);
			Double ch = strength / 2.0;
			Integer damagePluss = ch.intValue();
			character.setDamagePoints(1 + damagePluss);
			character.setDefendPoints(40 + dexterity * 2);
			character.setGold(100);
			character.setHealthPoint(15 + health);
			character.setLoadCapacity(50.0 + (strength.doubleValue() * 2.0));

			character.setInventory(new LinkedList<Item>());
			character.setPosition(null);
			character.setName(name);
			character.setPassword(password);
			character.setRace(Race.HUMAN);

			// TODO set pozition tothe map first position
			characterDao.saveOrUpdatePlayersCharacter(character);
		}

	}

	@Override
	@Transactional
	public boolean equipItem(ItemType type, Integer itemId, Integer characterId) {

		Assert.notNull(characterId);
		Assert.notNull(itemId);
		Assert.notNull(type);
		PlayersCharacter pc = characterDao.findById(characterId);

		if (pc == null) {
			throw new MissingEntityException(characterId);
		}
		switch (type) {
		case SHIELD:
			Shield toEquipS = itemDao.findShieldById(itemId);
			if (pc.getShields().contains(toEquipS)) {
				pc.getShields().remove(toEquipS);
				if (pc.getLoadCapacity() < toEquipS.getWeight()) {
					throw new ItemException("error.tooHeawyItem");
				} else {
					pc.setActualShield(toEquipS);
					pc.setAttackPoints(pc.getAttackPoints() + toEquipS.getAtkMinus());
					pc.setDamagePoints(pc.getDamagePoints() + toEquipS.getDefPlus());
					pc.setLoadCapacity(pc.getLoadCapacity() - toEquipS.getWeight());
				}

				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			}

		case ARMOR:
			Armor toEquipA = itemDao.findArmorById(itemId);
			if (pc.getArmors().contains(toEquipA)) {
				pc.getArmors().remove(toEquipA);
				if (pc.getLoadCapacity() < toEquipA.getWeight()) {
					throw new ItemException("error.tooHeawyItem");
				} else {
					pc.setActualArmor(toEquipA);
					pc.setAttackPoints(pc.getAttackPoints() + toEquipA.getAtkMinus());
					pc.setDamagePoints(pc.getDamagePoints() + toEquipA.getDefPlus());
					pc.setHealth(pc.getHealth() + toEquipA.getHealthPlus());
					pc.setLoadCapacity(pc.getLoadCapacity() - toEquipA.getWeight());
				}

				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;

			}
		case WEAPON:
			Weapon toEquipW = itemDao.findWeaponById(itemId);
			if (pc.getWeapons().contains(toEquipW)) {
				pc.getWeapons().remove(toEquipW);
				if (pc.getLoadCapacity() < toEquipW.getWeight()) {
					throw new ItemException("error.tooHeawyItem");
				} else {
					pc.setActualWeapon(toEquipW);
					pc.setAttackPoints(pc.getAttackPoints() + toEquipW.getAtk());
					pc.setDamagePoints(pc.getDamagePoints() + toEquipW.getDef());
					pc.setDamagePoints(pc.getDamagePoints() + toEquipW.getDamage());
					pc.setLoadCapacity(pc.getLoadCapacity() - toEquipW.getWeight());
				}
			}
			characterDao.saveOrUpdatePlayersCharacter(pc);
			return true;
		case POTION:
			break;
		}
		return false;

	}

	@Override
	@Transactional
	public boolean dropItem(ItemType type, Integer itemId, Integer characterId) {

		Assert.notNull(characterId);
		Assert.notNull(itemId);
		Assert.notNull(type);
		PlayersCharacter pc = characterDao.findById(characterId);

		if (pc == null) {
			throw new MissingEntityException(characterId);
		}
		switch (type) {
		case SHIELD:
			Shield toEquipS = itemDao.findShieldById(itemId);
			if (pc.getShields().contains(toEquipS)) {
				pc.getShields().remove(toEquipS);
				pc.setLoadCapacity(pc.getLoadCapacity() - toEquipS.getWeight());

				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			}
		case ARMOR:
			Armor toEquipA = itemDao.findArmorById(itemId);
			if (pc.getArmors().contains(toEquipA)) {
				pc.getArmors().remove(toEquipA);
				pc.setLoadCapacity(pc.getLoadCapacity() - toEquipA.getWeight());

				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			}

		case WEAPON:
			Weapon toEquipW = itemDao.findWeaponById(itemId);
			if (pc.getWeapons().contains(toEquipW)) {
				pc.getWeapons().remove(toEquipW);
				pc.setLoadCapacity(pc.getLoadCapacity() - toEquipW.getWeight());
				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			}
		case POTION:
			break;
		}
		return false;

	}

	@Override
	@Transactional
	public boolean unEquipItem(ItemType type, Integer itemId, Integer characterId) {

		Assert.notNull(characterId);
		Assert.notNull(itemId);
		Assert.notNull(type);
		PlayersCharacter pc = characterDao.findById(characterId);

		if (pc == null) {
			throw new MissingEntityException(characterId);
		}

		switch (type) {
		case SHIELD:

			Shield toUnEquipS = itemDao.findShieldById(itemId);

			if (pc.getActualShield() == toUnEquipS) {
				pc.setActualShield(null);
				pc.getShields().add(toUnEquipS);

				pc.setAttackPoints(pc.getAttackPoints() - toUnEquipS.getAtkMinus());
				pc.setDamagePoints(pc.getDamagePoints() - toUnEquipS.getDefPlus());
				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			} else {
				throw new ItemException();
			}

		case ARMOR:
			Armor toUnEquipA = itemDao.findArmorById(itemId);

			if (pc.getActualArmor() == toUnEquipA) {
				pc.setActualArmor(null);
				pc.getArmors().add(toUnEquipA);

				pc.setAttackPoints(pc.getAttackPoints() - toUnEquipA.getAtkMinus());
				pc.setDamagePoints(pc.getDamagePoints() - toUnEquipA.getDefPlus());
				pc.setHealth(pc.getHealth() - toUnEquipA.getHealthPlus());
				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;
			} else {
				throw new ItemException();

			}
		case WEAPON:
			Weapon toUnEquipW = itemDao.findWeaponById(itemId);
			if (pc.getActualWeapon() == toUnEquipW) {
				pc.setActualWeapon(null);
				pc.getWeapons().add(toUnEquipW);

				pc.setAttackPoints(pc.getAttackPoints() - toUnEquipW.getAtk());
				pc.setDamagePoints(pc.getDamagePoints() - toUnEquipW.getDef());
				pc.setDamagePoints(pc.getDamagePoints() - toUnEquipW.getDamage());
				characterDao.saveOrUpdatePlayersCharacter(pc);
				return true;

			} else {
				throw new ItemException();

			}

		case POTION:
			break;
		}

		return false;

	}

	@Override
	@Transactional
	public PlayersCharacter findById(Integer id) {

		if (id != null) {
			return characterDao.findById(id);
		} else
			throw new MissingEntityException(id);
	}

	@Override
	@Transactional
	public PlayersCharacter findByNameAndPassword(String name, String password) {

		if (name != null & password != null) {
			return characterDao.findByNameAndPassword(name, password);
		} else
			throw new MissingEntityException(name);
	}

	@Override
	@Transactional
	public Double calculateItemsWeightByCharacter(Integer id) {
		PlayersCharacter pc;
		if (id != null) {
			pc = characterDao.findById(id);
		} else {
			throw new MissingEntityException(id);
		}

		Double weightsSum = null;

		// FIXME: streamel kéne összeadni

		// List<Item> allItems = pc.getInventory();
		// allItems.addAll(pc.getArmors());
		// allItems.addAll(pc.getWeapons());
		// allItems.addAll(pc.getPotions());

		// for (Item item : pc.getInventory().addAll(pc.getArmors())) {
		// weightsSum += item.getWeight();
		// }
		// for (Item item : pc.getArmors()) {
		// weightsSum += item.getWeight();
		// }

		return 10.0;
	}

}
