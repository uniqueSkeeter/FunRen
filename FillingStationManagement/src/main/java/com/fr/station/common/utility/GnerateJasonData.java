package com.fr.station.common.utility;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fr.station.common.bean.system.MenuItem;

/**
 * 
 * @author henry
 */
public class GnerateJasonData implements Serializable {

	// ------- Constants (static final) ----------------------------------------

	private static final long serialVersionUID = 1L;

	private static final String spaceStr = "     ";

	private static final String nodesStr = "nodes:[\n{";

	// ------- Static Variables (static) ---------------------------------------

	// ------- Instance Variables (private) ------------------------------------

	// ------- Constructors ----------------------------------------------------

	// ------- Instance Methods (public) ---------------------------------------

	public static String buildRootJasonData(MenuItem root) {
		boolean flag = true;
		StringBuilder ans = new StringBuilder();
		Map<Integer, List<MenuItem>> subNodeMap = getSubNodeMap(root);
		ans.append("var zNodes = [\n").append(spaceStr + "{ ");
		ans.append("name:" + "\"" + root.getName() + "\"" + ", " + "url:"
				+ "\"" + root.getId() + "\"" + ",\n");
		ans.append(spaceStr).append("nodes:[\n");
		for (MenuItem subNodes : root.getChildren()) {
			ans.append("{");
			ans.append("name:" + "\"" + subNodes.getName() + "\"" + ", "
					+ "url:" + "\"" + subNodes.getId() + "\"");
			ans.append(",\n");
			if (subNodeMap.containsKey(subNodes.getId()) && subNodeMap.get(subNodes.getId()) != null) {
				flag = false;
				buildSecondLevelJasonData(subNodeMap.get(subNodes.getId()), ans, flag);
			} else {
				ans.append("},");
			}
		}
		ans.append("\n]},\n];");
		return ans.toString();
	}

	// ------- Instance Methods (protected) ------------------------------------

	// ------- Instance Methods (private) --------------------------------------

	private static void buildSecondLevelJasonData(List<MenuItem> subNodesList,
			StringBuilder ans, boolean flag) {
		int i = 0;
			ans.append(spaceStr + spaceStr).append("nodes:[\n");
		for (MenuItem nodes : subNodesList) {
			i++;
			ans.append(spaceStr + spaceStr + "{");
			ans.append("name:" + "\"" + nodes.getName() + "\"" + ", " + "url:"
					+ "\"" + nodes.getId() + "\"}\n");
			if (i < subNodesList.size()) {
				ans.append(",");
			}
		}
		ans.append("]},");
	}

	private static Map<Integer, List<MenuItem>> getSubNodeMap(MenuItem root) {

		Map<Integer, List<MenuItem>> subNodeMap = new HashMap<Integer, List<MenuItem>>();
		for (MenuItem subNodes : root.getChildren()) {
			subNodeMap.put(subNodes.getId(), subNodes.getChildren());
		}
		return subNodeMap;
	}
}
