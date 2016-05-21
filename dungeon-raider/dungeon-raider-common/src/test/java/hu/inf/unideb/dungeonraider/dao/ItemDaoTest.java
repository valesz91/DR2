package hu.inf.unideb.dungeonraider.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.inf.unideb.dungeonraider.AbstractPersistenceTests;
import hu.inf.unideb.dungeonraider.domain.Armor;
import hu.inf.unideb.dungeonraider.domain.ItemType;
import hu.inf.unideb.dungeonraider.domain.Shield;
import hu.inf.unideb.dungeonraider.domain.Weapon;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemDaoTest extends AbstractPersistenceTests {

	private ItemDao itemDao;

	public ItemDao getItemDao() {
		return itemDao;
	}

	@Autowired
	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	@Test
	public void testAll() {

		Weapon weapon = new Weapon();
		weapon.setValue(100);
		weapon.setName("Knife");
		weapon.setType(ItemType.WEAPON);
		weapon.setPlayersCharacter(null);
		itemDao.saveOrUpdateWeapon(weapon);
		flushAndClear();
		Shield shield = new Shield();
		shield.setValue(100);
		shield.setName("Knife");
		shield.setType(ItemType.SHIELD);
		itemDao.saveOrUpdateShield(shield);
		flushAndClear();
		Armor armor = new Armor();
		armor.setWeight(10.0);
		armor.setValue(70);
		armor.setName("Cuirass");
		armor.setType(ItemType.ARMOR);
		itemDao.saveOrUpdateArmor(armor);

		Integer id = 1;
		flushAndClear();

		// Test weapon find
		Weapon testWeapon = itemDao.findWeaponById(1);
		Assert.assertNotNull(testWeapon);
		// Assert.assertEquals(100, testWeapon.getValue());
		Assert.assertEquals(id, testWeapon.getId());
		Assert.assertFalse(testWeapon.getType().equals(ItemType.ARMOR));

		// Test shield find
		Shield testShield = itemDao.findShieldById(1);
		Assert.assertNotNull(testShield);
		// Assert.assertEquals(100, testShield.getValue());
		Assert.assertEquals(id, testShield.getId());
		Assert.assertFalse(testShield.getType().equals(ItemType.WEAPON));

		// Test armor find
		Armor testArmor = itemDao.findArmorById(1);
		Assert.assertNotNull(testArmor);
		// Assert.assertEquals(100, testArmor.getValue());
		Assert.assertEquals(id, testArmor.getId());
		Assert.assertFalse(testArmor.getType().equals(ItemType.SHIELD));

		Integer exceptSize = 1;
		// Test armors list
		List<Armor> testArmors = itemDao.listAllArmor(2, null);
		Integer size = testArmors.size();
		Assert.assertNotNull(testArmors);
		Assert.assertEquals(exceptSize, size);

		// Test shields list
		List<Shield> testShields = itemDao.listAllShield(2, null);
		Integer size2 = testShields.size();

		Assert.assertNotNull(testShields);
		Assert.assertEquals(exceptSize, size2);

		// Test weapons list
		List<Weapon> testWeapons = itemDao.listAllWeapon(2, null);
		Integer size3 = testWeapons.size();

		Assert.assertNotNull(testWeapons);
		Assert.assertEquals(exceptSize, size3);
	}

}
