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
import hu.inf.unideb.dungeonraider.domain.Potion;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;
import hu.inf.unideb.dungeonraider.service.ItemException;
import hu.inf.unideb.dungeonraider.service.ItemService;
import hu.inf.unideb.dungeonraider.service.MissingEntityException;

@Service("itemService")
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;

	@Autowired
	private PlayersCharacterDao characterDao;

	@Override
	@Transactional(readOnly = true)
	public List<Armor> listArmors(int characterId, boolean canBuy) {

		Assert.notNull(characterId);
		Assert.notNull(canBuy);

		int totalResults = itemDao.countArmors();
		if (totalResults == 0) {
			return new LinkedList<Armor>();
		}

		System.out.println(totalResults);

		Integer maxPrice = null;
		if (canBuy) {
			PlayersCharacter pc = characterDao.findById(characterId);
			System.out.println(pc.getName());
			maxPrice = pc.getGold();
			System.out.println(maxPrice);

		} else {
			maxPrice = null;
		}

		List<Armor> list = itemDao.listAllArmor(totalResults, maxPrice);
		return list;

	}

	@Override
	@Transactional(readOnly = true)
	public List<Weapon> listWeapons(int characterId, boolean canBuy) {

		Assert.notNull(characterId);
		Assert.notNull(canBuy);

		int totalResults = itemDao.countWeapons();
		if (totalResults == 0) {
			return new LinkedList<Weapon>();
		}

		Integer maxPrice;
		if (canBuy) {
			maxPrice = characterDao.findById(characterId).getGold();

		} else {
			maxPrice = null;
		}

		List<Weapon> list = itemDao.listAllWeapon(totalResults, maxPrice);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Shield> listShields(int characterId, boolean canBuy) {

		Assert.notNull(characterId);
		Assert.notNull(canBuy);

		int totalResults = itemDao.countShields();
		if (totalResults == 0) {
			return new LinkedList<Shield>();
		}

		Integer maxPrice;
		if (canBuy) {
			maxPrice = characterDao.findById(characterId).getGold();

		} else {
			maxPrice = null;
		}

		List<Shield> list = itemDao.listAllShield(totalResults, maxPrice);
		return list;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Potion> listPotions(int characterId, boolean canBuy) {

		Assert.notNull(characterId);
		Assert.notNull(canBuy);

		int totalResults = itemDao.countPotions();
		if (totalResults == 0) {
			return new LinkedList<Potion>();
		}

		Integer maxPrice;
		if (canBuy) {
			maxPrice = characterDao.findById(characterId).getGold();

		} else {
			maxPrice = null;
		}

		List<Potion> list = itemDao.listAllPotion(totalResults, maxPrice);
		return list;
	}

	@Override
	@Transactional
	public void buy(ItemType type, Integer itemId, Integer characterId) {

		Assert.notNull(characterId);
		Assert.notNull(itemId);
		Assert.notNull(type);
		PlayersCharacter pc = characterDao.findById(characterId);

		if (pc == null) {
			throw new MissingEntityException(characterId);
		}

		switch (type) {
		case SHIELD:
			Shield toBuyS = itemDao.findShieldById(itemId);
			checkWeight(toBuyS, pc);
			checkGoldAndBuy(toBuyS.getValue(), pc);
			if (pc.getShields() == null) {
				pc.setShields(new LinkedList<Shield>());
			}
			pc.getShields().add(toBuyS);
			// toBuyS.setPlayersCharacter(pc);
			// itemDao.saveOrUpdateShield(toBuyS);
			break;
		case ARMOR:
			Armor toBuyA = itemDao.findArmorById(itemId);
			checkWeight(toBuyA, pc);
			checkGoldAndBuy(toBuyA.getValue(), pc);
			if (pc.getArmors() == null) {
				pc.setArmors(new LinkedList<Armor>());
			}
			pc.getArmors().add(toBuyA);
			break;
		case POTION:
			Potion toBuyP = itemDao.findPotionById(itemId);
			checkWeight(toBuyP, pc);
			checkGoldAndBuy(toBuyP.getValue(), pc);
			if (pc.getArmors() == null) {
				pc.setArmors(new LinkedList<Armor>());
			}
			pc.getPotions().add(toBuyP);
			break;
		case WEAPON:
			Weapon toBuyW = itemDao.findWeaponById(itemId);
			checkWeight(toBuyW, pc);
			checkGoldAndBuy(toBuyW.getValue(), pc);
			if (pc.getWeapons() == null) {
				pc.setWeapons(new LinkedList<Weapon>());
			}
			pc.getWeapons().add(toBuyW);
			break;
		}

		characterDao.saveOrUpdatePlayersCharacter(pc);
	}

	@Transactional
	private boolean checkGoldAndBuy(Integer value, PlayersCharacter pc) {

		int ch = 0;
		ch = pc.getGold() - value;
		if (ch >= 0) {
			pc.setGold(ch);
			characterDao.saveOrUpdatePlayersCharacter(pc);
		} else {
			throw new ItemException("error.youHaveNotEnoughGold");
		}
		return true;

	}

	private void checkWeight(Item item, PlayersCharacter pc) {
		if (pc.getLoadCapacity() < item.getWeight()) {
			throw new ItemException("error.tooHeawyItem");
		}

	}
}
