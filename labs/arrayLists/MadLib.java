/**
 * @author Neil Powers
 * Date: 2/2/18
 * Affiliation: EIHS - AP Comp Sci
 * Lab: MadLib - Main
 */

package arrayLists;

import java.util.ArrayList;

public class MadLib {
	private ArrayList<String> verbs = new ArrayList<String>();
	private ArrayList<String> nouns = new ArrayList<String>();
	private ArrayList<String> adjectives = new ArrayList<String>();

	public MadLib() {
		fillLists();

	}

	public void fillLists() {
		verbs.add("jumps");
		verbs.add("flys");
		verbs.add("skips");
		verbs.add("climbs");
		verbs.add("cleans");
		verbs.add("programs");
		verbs.add("runs");
		verbs.add("contradicts");
		verbs.add("accentuates");
		verbs.add("persuades");
		verbs.add("obscures");
		verbs.add("chronicles");
		verbs.add("continues");
		verbs.add("endures");
		verbs.add("happens");
		verbs.add("lives");
		verbs.add("prevails");
		verbs.add("remains");
		verbs.add("survives");
		verbs.add("stands");
		verbs.add("subsists");
		verbs.add("lasts");

		nouns.add("fox");
		nouns.add("dog");
		nouns.add("chicken");
		nouns.add("building");
		nouns.add("car");
		nouns.add("person");
		nouns.add("truck");
		nouns.add("thingamajigger");
		nouns.add("pig");
		nouns.add("person");
		nouns.add("skyscraper");
		nouns.add("rocket scientist");

		adjectives.add("blue");
		adjectives.add("funny");
		adjectives.add("silly");
		adjectives.add("tall");
		adjectives.add("fat");
		adjectives.add("skinny");
		adjectives.add("ridiculous");
		adjectives.add("random");
		adjectives.add("ridonculous");
		adjectives.add("quick");
		adjectives.add("brown");
		adjectives.add("lazy");
	}

	public String getRandomVerb() {
		return verbs.get((int) (Math.random() * verbs.size()));
	}

	public String getRandomNoun() {
		
		return nouns.get((int) (Math.random() * nouns.size()));
	}
	
	public String getRandomAdjective() {
		return adjectives.get((int) (Math.random() * adjectives.size()));
	}

	public String toString() {
		return String.format("The %s %s after the %s %s %s while the %s %s the %s." + "\n*Sigh, still not \"the quick brown fox jumps over the lazy dog\"",
				getRandomNoun(), getRandomVerb(), getRandomAdjective(), getRandomNoun(), getRandomVerb(), getRandomNoun(), getRandomVerb(), getRandomNoun());
	}
}