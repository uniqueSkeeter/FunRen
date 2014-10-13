package com.fr.station.card.ICCard.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.fr.station.common.bean.system.MenuItem;
import com.fr.station.common.utility.GnerateJasonData;

public class GnerateJasonDataTest {

	// ------- Constants (static final) ----------------------------------------

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	private MenuItem root;
	
	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		//root
		root = this.createMenuItem(1, 0, "url", "卡管理");
		// second 1
		MenuItem second1 = this.createMenuItem(2, 1, "url", "解卡业务");
		
		// second 11
		MenuItem second311 = this.createMenuItem(3, 2, "url", "test1");
		MenuItem second312 = this.createMenuItem(4, 2, "url", "test2");
		
		// second 2
		MenuItem second2 = this.createMenuItem(5, 1, "url", "充值");
		MenuItem second321 = this.createMenuItem(6, 5, "url", "缴费");
		MenuItem second322 = this.createMenuItem(7, 5, "url", "解灰");
		
		// second 2
		MenuItem second3 = this.createMenuItem(8, 1, "url", "Test");
		MenuItem second331 = this.createMenuItem(9, 8, "url", "Test");
		MenuItem second332 = this.createMenuItem(10, 8, "url", "Test");
		
		
		//build tree
		List<MenuItem> secondList = new ArrayList<MenuItem>();
		List<MenuItem> second1List = new ArrayList<MenuItem>();
		List<MenuItem> second2List = new ArrayList<MenuItem>();
		List<MenuItem> second3List = new ArrayList<MenuItem>();
		
		secondList.add(second1);
		secondList.add(second2);
		secondList.add(second3);
		
		second1List.add(second311);
		second1List.add(second312);
		
		second2List.add(second321);
		second2List.add(second322);
		
		second3List.add(second331);
		second3List.add(second332);
		
		root.setChildren(secondList);
		second1.setChildren(second1List);
		second2.setChildren(second2List);
		second3.setChildren(second3List);

	}

	@Test
	public void testGnerateJasonData() {
		String result = GnerateJasonData.buildRootJasonData(root);
		System.out.println(result);
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	private MenuItem createMenuItem(int id, int parentId, String url,
			String name) {

		MenuItem menuItem = new MenuItem();
		menuItem.setId(id);
		menuItem.setParentId(parentId);
		menuItem.setUrl(url);
		menuItem.setName(name);

		return menuItem;
	}

}
