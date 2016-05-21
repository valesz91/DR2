package hu.inf.unideb.dungeonraider.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import hu.inf.unideb.dungeonraider.AbstractPersistenceTests;
import hu.inf.unideb.dungeonraider.domain.PlayersCharacter;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PlayersCharacterDaoTest extends AbstractPersistenceTests {

	@Autowired
	private PlayersCharacterDao playersCharacterDao;

	@Test
	public void testAll() {

		PlayersCharacter pc = new PlayersCharacter();
		pc.setName("Name");
		pc.setGold(100);
		playersCharacterDao.saveOrUpdatePlayersCharacter(pc);
		flushAndClear();

		PlayersCharacter pc2 = playersCharacterDao.findById(1);
		Assert.assertNotNull(pc2);
		Assert.assertNull(pc2.getActualArmor());

		playersCharacterDao.deletePlayersCharacter(pc2);
		Assert.assertNull(playersCharacterDao.findById(1));
		flushAndClear();

		PlayersCharacter pc3 = new PlayersCharacter();
		String pasw = "TopSecret";
		String name = "Wolf";
		Integer gold = 90;
		pc3.setName(name);
		pc3.setPassword(pasw);
		pc3.setGold(gold);
		playersCharacterDao.saveOrUpdatePlayersCharacter(pc3);
		flushAndClear();

		PlayersCharacter pcTest = playersCharacterDao.findByNameAndPassword(name, pasw);
		Assert.assertNotNull(pcTest);
		Assert.assertEquals(name, pcTest.getName());
		Assert.assertEquals(pasw, pcTest.getPassword());

		PlayersCharacter pcTest2 = playersCharacterDao.findByName(name);
		Assert.assertNotNull(pcTest2);
		Assert.assertEquals(name, pcTest.getName());

		Assert.assertNull(playersCharacterDao.findByName("Drawen"));

		Assert.assertNull(playersCharacterDao.findByNameAndPassword("Drawen", "Password"));
	}
}
