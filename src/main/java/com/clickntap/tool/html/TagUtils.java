package com.clickntap.tool.html;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TagUtils {
	private static List<String> stopwords;

	public static List<Tag> autoTag(String text) {
		Map<String, Tag> tagMap = new HashMap<String, Tag>();
		String[] words = text.toLowerCase().split("[^a-z0-9-_']");
		for (String word : words) {
			if (word.length() >= 4 && !stopwords.contains(word)) {
				if (tagMap.containsKey(word))
					tagMap.get(word).inc();
				else
					tagMap.put(word, new Tag(word));
			}
		}
		List<Tag> tags = new ArrayList<Tag>();
		for (Tag tag : tagMap.values())
			tags.add(tag);
		Collections.sort(tags, new TagComparator());
		List<Tag> outTags = new ArrayList<Tag>();
		for (Tag tag : tags) {
			try {
				Integer.parseInt(tag.getName());
				continue;
			} catch (Exception e) {
			}
			if (tag.getCount() > 1)
				outTags.add(tag);

			if (outTags.size() > 100)
				break;
		}
		return outTags;
	}

	public static class TagComparator implements Comparator<Tag> {

		public int compare(Tag tag1, Tag tag2) {
			return tag2.getCount() - tag1.getCount();
		}

	}

	public static class Tag {
		private int count;
		private String name;

		public Tag(String name) {
			this.count = 1;
			this.name = name;
		}

		public void inc() {
			count++;
		}

		public String getName() {
			return name;
		}

		public String toString() {
			return getName() + "|" + getCount();
		}

		public int getCount() {
			return count;
		}
	}

	static {
		stopwords = new ArrayList<String>();
		stopwords.add("quot");
		stopwords.add("nbsp");
		stopwords.add("delle");
		stopwords.add("della");
		stopwords.add("nella");
		stopwords.add("sono");
		stopwords.add("alla");
		stopwords.add("agrave");
		stopwords.add("egrave");
		stopwords.add("igrave");
		stopwords.add("ograve");
		stopwords.add("ugrave");
		stopwords.add("cerca");
		stopwords.add("solo");
		stopwords.add("a's");
		stopwords.add("able");
		stopwords.add("about");
		stopwords.add("above");
		stopwords.add("according");
		stopwords.add("accordingly");
		stopwords.add("across");
		stopwords.add("actually");
		stopwords.add("after");
		stopwords.add("afterwards");
		stopwords.add("again");
		stopwords.add("against");
		stopwords.add("ain't");
		stopwords.add("all");
		stopwords.add("allow");
		stopwords.add("allows");
		stopwords.add("almost");
		stopwords.add("alone");
		stopwords.add("along");
		stopwords.add("already");
		stopwords.add("also");
		stopwords.add("although");
		stopwords.add("always");
		stopwords.add("am");
		stopwords.add("among");
		stopwords.add("amongst");
		stopwords.add("an");
		stopwords.add("and");
		stopwords.add("another");
		stopwords.add("any");
		stopwords.add("anybody");
		stopwords.add("anyhow");
		stopwords.add("anyone");
		stopwords.add("anything");
		stopwords.add("anyway");
		stopwords.add("anyways");
		stopwords.add("anywhere");
		stopwords.add("apart");
		stopwords.add("appear");
		stopwords.add("appreciate");
		stopwords.add("appropriate");
		stopwords.add("are");
		stopwords.add("aren't");
		stopwords.add("around");
		stopwords.add("as");
		stopwords.add("aside");
		stopwords.add("ask");
		stopwords.add("asking");
		stopwords.add("associated");
		stopwords.add("at");
		stopwords.add("available");
		stopwords.add("away");
		stopwords.add("awfully");
		stopwords.add("be");
		stopwords.add("became");
		stopwords.add("because");
		stopwords.add("become");
		stopwords.add("becomes");
		stopwords.add("becoming");
		stopwords.add("been");
		stopwords.add("before");
		stopwords.add("beforehand");
		stopwords.add("behind");
		stopwords.add("being");
		stopwords.add("believe");
		stopwords.add("below");
		stopwords.add("beside");
		stopwords.add("besides");
		stopwords.add("best");
		stopwords.add("better");
		stopwords.add("between");
		stopwords.add("beyond");
		stopwords.add("both");
		stopwords.add("brief");
		stopwords.add("but");
		stopwords.add("by");
		stopwords.add("c'mon");
		stopwords.add("c's");
		stopwords.add("came");
		stopwords.add("can");
		stopwords.add("can't");
		stopwords.add("cannot");
		stopwords.add("cant");
		stopwords.add("cause");
		stopwords.add("causes");
		stopwords.add("certain");
		stopwords.add("certainly");
		stopwords.add("changes");
		stopwords.add("clearly");
		stopwords.add("co");
		stopwords.add("com");
		stopwords.add("come");
		stopwords.add("comes");
		stopwords.add("concerning");
		stopwords.add("consequently");
		stopwords.add("consider");
		stopwords.add("considering");
		stopwords.add("contain");
		stopwords.add("containing");
		stopwords.add("contains");
		stopwords.add("corresponding");
		stopwords.add("could");
		stopwords.add("couldn't");
		stopwords.add("course");
		stopwords.add("currently");
		stopwords.add("definitely");
		stopwords.add("described");
		stopwords.add("despite");
		stopwords.add("did");
		stopwords.add("didn't");
		stopwords.add("different");
		stopwords.add("do");
		stopwords.add("does");
		stopwords.add("doesn't");
		stopwords.add("doing");
		stopwords.add("don't");
		stopwords.add("done");
		stopwords.add("down");
		stopwords.add("downwards");
		stopwords.add("during");
		stopwords.add("each");
		stopwords.add("edit");
		stopwords.add("edu");
		stopwords.add("eg");
		stopwords.add("eight");
		stopwords.add("either");
		stopwords.add("else");
		stopwords.add("elsewhere");
		stopwords.add("enough");
		stopwords.add("entirely");
		stopwords.add("especially");
		stopwords.add("et");
		stopwords.add("etc");
		stopwords.add("even");
		stopwords.add("ever");
		stopwords.add("every");
		stopwords.add("everybody");
		stopwords.add("everyone");
		stopwords.add("everything");
		stopwords.add("everywhere");
		stopwords.add("ex");
		stopwords.add("exactly");
		stopwords.add("example");
		stopwords.add("except");
		stopwords.add("far");
		stopwords.add("few");
		stopwords.add("fifth");
		stopwords.add("first");
		stopwords.add("five");
		stopwords.add("followed");
		stopwords.add("following");
		stopwords.add("follows");
		stopwords.add("for");
		stopwords.add("former");
		stopwords.add("formerly");
		stopwords.add("forth");
		stopwords.add("four");
		stopwords.add("from");
		stopwords.add("further");
		stopwords.add("furthermore");
		stopwords.add("get");
		stopwords.add("gets");
		stopwords.add("getting");
		stopwords.add("given");
		stopwords.add("gives");
		stopwords.add("go");
		stopwords.add("goes");
		stopwords.add("going");
		stopwords.add("gone");
		stopwords.add("got");
		stopwords.add("gotten");
		stopwords.add("greetings");
		stopwords.add("had");
		stopwords.add("hadn't");
		stopwords.add("happens");
		stopwords.add("hardly");
		stopwords.add("has");
		stopwords.add("hasn't");
		stopwords.add("have");
		stopwords.add("haven't");
		stopwords.add("having");
		stopwords.add("he");
		stopwords.add("he's");
		stopwords.add("hello");
		stopwords.add("help");
		stopwords.add("hence");
		stopwords.add("her");
		stopwords.add("here");
		stopwords.add("here's");
		stopwords.add("hereafter");
		stopwords.add("hereby");
		stopwords.add("herein");
		stopwords.add("hereupon");
		stopwords.add("hers");
		stopwords.add("herself");
		stopwords.add("hi");
		stopwords.add("him");
		stopwords.add("himself");
		stopwords.add("his");
		stopwords.add("hither");
		stopwords.add("hopefully");
		stopwords.add("how");
		stopwords.add("howbeit");
		stopwords.add("however");
		stopwords.add("i'd");
		stopwords.add("i'll");
		stopwords.add("i'm");
		stopwords.add("i've");
		stopwords.add("ie");
		stopwords.add("if");
		stopwords.add("ignored");
		stopwords.add("immediate");
		stopwords.add("in");
		stopwords.add("inasmuch");
		stopwords.add("inc");
		stopwords.add("indeed");
		stopwords.add("indicate");
		stopwords.add("indicated");
		stopwords.add("indicates");
		stopwords.add("inner");
		stopwords.add("insofar");
		stopwords.add("instead");
		stopwords.add("into");
		stopwords.add("inward");
		stopwords.add("is");
		stopwords.add("isn't");
		stopwords.add("it");
		stopwords.add("it'd");
		stopwords.add("it'll");
		stopwords.add("it's");
		stopwords.add("its");
		stopwords.add("itself");
		stopwords.add("just");
		stopwords.add("keep");
		stopwords.add("keeps");
		stopwords.add("kept");
		stopwords.add("know");
		stopwords.add("knows");
		stopwords.add("known");
		stopwords.add("last");
		stopwords.add("lately");
		stopwords.add("later");
		stopwords.add("latter");
		stopwords.add("latterly");
		stopwords.add("least");
		stopwords.add("less");
		stopwords.add("lest");
		stopwords.add("let");
		stopwords.add("let's");
		stopwords.add("like");
		stopwords.add("liked");
		stopwords.add("likely");
		stopwords.add("little");
		stopwords.add("look");
		stopwords.add("looking");
		stopwords.add("looks");
		stopwords.add("ltd");
		stopwords.add("mainly");
		stopwords.add("many");
		stopwords.add("may");
		stopwords.add("maybe");
		stopwords.add("me");
		stopwords.add("mean");
		stopwords.add("meanwhile");
		stopwords.add("merely");
		stopwords.add("might");
		stopwords.add("more");
		stopwords.add("moreover");
		stopwords.add("most");
		stopwords.add("mostly");
		stopwords.add("much");
		stopwords.add("must");
		stopwords.add("my");
		stopwords.add("myself");
		stopwords.add("name");
		stopwords.add("namely");
		stopwords.add("nd");
		stopwords.add("near");
		stopwords.add("nearly");
		stopwords.add("necessary");
		stopwords.add("need");
		stopwords.add("needs");
		stopwords.add("neither");
		stopwords.add("never");
		stopwords.add("nevertheless");
		stopwords.add("new");
		stopwords.add("next");
		stopwords.add("nine");
		stopwords.add("no");
		stopwords.add("nobody");
		stopwords.add("non");
		stopwords.add("none");
		stopwords.add("noone");
		stopwords.add("nor");
		stopwords.add("normally");
		stopwords.add("not");
		stopwords.add("nothing");
		stopwords.add("novel");
		stopwords.add("now");
		stopwords.add("nowhere");
		stopwords.add("obviously");
		stopwords.add("of");
		stopwords.add("off");
		stopwords.add("often");
		stopwords.add("oh");
		stopwords.add("ok");
		stopwords.add("okay");
		stopwords.add("old");
		stopwords.add("on");
		stopwords.add("once");
		stopwords.add("one");
		stopwords.add("ones");
		stopwords.add("only");
		stopwords.add("onto");
		stopwords.add("or");
		stopwords.add("other");
		stopwords.add("others");
		stopwords.add("otherwise");
		stopwords.add("ought");
		stopwords.add("our");
		stopwords.add("ours");
		stopwords.add("ourselves");
		stopwords.add("out");
		stopwords.add("outside");
		stopwords.add("over");
		stopwords.add("overall");
		stopwords.add("own");
		stopwords.add("particular");
		stopwords.add("particularly");
		stopwords.add("per");
		stopwords.add("perhaps");
		stopwords.add("placed");
		stopwords.add("please");
		stopwords.add("plus");
		stopwords.add("possible");
		stopwords.add("presumably");
		stopwords.add("probably");
		stopwords.add("provides");
		stopwords.add("que");
		stopwords.add("quite");
		stopwords.add("qv");
		stopwords.add("rather");
		stopwords.add("rd");
		stopwords.add("re");
		stopwords.add("really");
		stopwords.add("reasonably");
		stopwords.add("regarding");
		stopwords.add("regardless");
		stopwords.add("regards");
		stopwords.add("relatively");
		stopwords.add("respectively");
		stopwords.add("right");
		stopwords.add("said");
		stopwords.add("same");
		stopwords.add("saw");
		stopwords.add("say");
		stopwords.add("saying");
		stopwords.add("says");
		stopwords.add("second");
		stopwords.add("secondly");
		stopwords.add("see");
		stopwords.add("seeing");
		stopwords.add("seem");
		stopwords.add("seemed");
		stopwords.add("seeming");
		stopwords.add("seems");
		stopwords.add("seen");
		stopwords.add("self");
		stopwords.add("selves");
		stopwords.add("sensible");
		stopwords.add("sent");
		stopwords.add("serious");
		stopwords.add("seriously");
		stopwords.add("seven");
		stopwords.add("several");
		stopwords.add("shall");
		stopwords.add("she");
		stopwords.add("should");
		stopwords.add("shouldn't");
		stopwords.add("since");
		stopwords.add("six");
		stopwords.add("so");
		stopwords.add("some");
		stopwords.add("somebody");
		stopwords.add("somehow");
		stopwords.add("someone");
		stopwords.add("something");
		stopwords.add("sometime");
		stopwords.add("sometimes");
		stopwords.add("somewhat");
		stopwords.add("somewhere");
		stopwords.add("soon");
		stopwords.add("sorry");
		stopwords.add("specified");
		stopwords.add("specify");
		stopwords.add("specifying");
		stopwords.add("still");
		stopwords.add("sub");
		stopwords.add("such");
		stopwords.add("sup");
		stopwords.add("sure");
		stopwords.add("t's");
		stopwords.add("take");
		stopwords.add("taken");
		stopwords.add("tell");
		stopwords.add("tends");
		stopwords.add("th");
		stopwords.add("than");
		stopwords.add("thank");
		stopwords.add("thanks");
		stopwords.add("thanx");
		stopwords.add("that");
		stopwords.add("that's");
		stopwords.add("thats");
		stopwords.add("the");
		stopwords.add("their");
		stopwords.add("theirs");
		stopwords.add("them");
		stopwords.add("themselves");
		stopwords.add("then");
		stopwords.add("thence");
		stopwords.add("there");
		stopwords.add("there's");
		stopwords.add("thereafter");
		stopwords.add("thereby");
		stopwords.add("therefore");
		stopwords.add("therein");
		stopwords.add("theres");
		stopwords.add("thereupon");
		stopwords.add("these");
		stopwords.add("they");
		stopwords.add("they'd");
		stopwords.add("they'll");
		stopwords.add("they're");
		stopwords.add("they've");
		stopwords.add("think");
		stopwords.add("third");
		stopwords.add("this");
		stopwords.add("thorough");
		stopwords.add("thoroughly");
		stopwords.add("those");
		stopwords.add("though");
		stopwords.add("three");
		stopwords.add("through");
		stopwords.add("throughout");
		stopwords.add("thru");
		stopwords.add("thus");
		stopwords.add("to");
		stopwords.add("together");
		stopwords.add("too");
		stopwords.add("took");
		stopwords.add("toward");
		stopwords.add("towards");
		stopwords.add("tried");
		stopwords.add("tries");
		stopwords.add("truly");
		stopwords.add("try");
		stopwords.add("trying");
		stopwords.add("twice");
		stopwords.add("two");
		stopwords.add("un");
		stopwords.add("under");
		stopwords.add("unfortunately");
		stopwords.add("unless");
		stopwords.add("unlikely");
		stopwords.add("until");
		stopwords.add("unto");
		stopwords.add("up");
		stopwords.add("upon");
		stopwords.add("us");
		stopwords.add("use");
		stopwords.add("used");
		stopwords.add("useful");
		stopwords.add("uses");
		stopwords.add("using");
		stopwords.add("usually");
		stopwords.add("value");
		stopwords.add("various");
		stopwords.add("very");
		stopwords.add("via");
		stopwords.add("viz");
		stopwords.add("vs");
		stopwords.add("want");
		stopwords.add("wants");
		stopwords.add("was");
		stopwords.add("wasn't");
		stopwords.add("way");
		stopwords.add("we");
		stopwords.add("we'd");
		stopwords.add("we'll");
		stopwords.add("we're");
		stopwords.add("we've");
		stopwords.add("welcome");
		stopwords.add("well");
		stopwords.add("went");
		stopwords.add("were");
		stopwords.add("weren't");
		stopwords.add("what");
		stopwords.add("what's");
		stopwords.add("whatever");
		stopwords.add("when");
		stopwords.add("whence");
		stopwords.add("whenever");
		stopwords.add("where");
		stopwords.add("where's");
		stopwords.add("whereafter");
		stopwords.add("whereas");
		stopwords.add("whereby");
		stopwords.add("wherein");
		stopwords.add("whereupon");
		stopwords.add("wherever");
		stopwords.add("whether");
		stopwords.add("which");
		stopwords.add("while");
		stopwords.add("whither");
		stopwords.add("who");
		stopwords.add("who's");
		stopwords.add("whoever");
		stopwords.add("whole");
		stopwords.add("whom");
		stopwords.add("whose");
		stopwords.add("why");
		stopwords.add("will");
		stopwords.add("willing");
		stopwords.add("wish");
		stopwords.add("with");
		stopwords.add("within");
		stopwords.add("without");
		stopwords.add("won't");
		stopwords.add("wonder");
		stopwords.add("would");
		stopwords.add("would");
		stopwords.add("wouldn't");
		stopwords.add("yes");
		stopwords.add("yet");
		stopwords.add("you");
		stopwords.add("you'd");
		stopwords.add("you'll");
		stopwords.add("you're");
		stopwords.add("you've");
		stopwords.add("your");
		stopwords.add("yours");
		stopwords.add("yourself");
		stopwords.add("yourselves");
		stopwords.add("zero");
	}
}
