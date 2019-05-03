package lambdajavasprintgdp.ecogdp;

import lambdajavasprintgdp.ecogdp.models.GDP;

import java.util.ArrayList;

public class GDPList
{
	public ArrayList<GDP> gdpList = new ArrayList<>();

	public GDPList()
	{
		gdpList.add(new GDP("United States",20513000));
		gdpList.add(new GDP("China",1357267));
		gdpList.add(new GDP("Japan",570626));
		gdpList.add(new GDP("Germany",429140));
		gdpList.add(new GDP("United Kingdom",208899));
		gdpList.add(new GDP("France",294696));
		gdpList.add(new GDP("India",289992));
		gdpList.add(new GDP("Italy",286911));
		gdpList.add(new GDP("Brazil",109386));
		gdpList.add(new GDP("Canada",133706));
		gdpList.add(new GDP("South Korea",155608));
		gdpList.add(new GDP("Russia",176488));
		gdpList.add(new GDP("Spain",137047));
		gdpList.add(new GDP("Australia",127767));
		gdpList.add(new GDP("Mexico",199264));
		gdpList.add(new GDP("Indonesia",105268));
		gdpList.add(new GDP("Netherlands",709887));
		gdpList.add(new GDP("Saudi Arabia",69878));
		gdpList.add(new GDP("Turkey",13513));
		gdpList.add(new GDP("Switzerland",709118));
		gdpList.add(new GDP("Taiwan",802678));
		gdpList.add(new GDP("Sweden",54659));
		gdpList.add(new GDP("Poland",49478));
		gdpList.add(new GDP("Belgium",36055));
		gdpList.add(new GDP("Thailand",90120));
		gdpList.add(new GDP("Argentina",75429));
		gdpList.add(new GDP("Austria",59401));
		gdpList.add(new GDP("Norway",41439));
		gdpList.add(new GDP("United Arab Emirates",32612));
		gdpList.add(new GDP("Iran",30082));
		gdpList.add(new GDP("Nigeria",97472));
		gdpList.add(new GDP("South Africa",76679));
		gdpList.add(new GDP("Ireland",66448));
		gdpList.add(new GDP("Israel",65599));
		gdpList.add(new GDP("Hong Kong",60315));
		gdpList.add(new GDP("Denmark",54683));
		gdpList.add(new GDP("Malaysia",47290));
		gdpList.add(new GDP("Singapore",46621));
		gdpList.add(new GDP("Colombia",36940));
		gdpList.add(new GDP("Philippines",31678));
		gdpList.add(new GDP("Pakistan",906987));
		gdpList.add(new GDP("Chile",99887));
		gdpList.add(new GDP("Bangladesh",86275));
		gdpList.add(new GDP("Finland",76553));
		gdpList.add(new GDP("Egypt",49471));
		gdpList.add(new GDP("Czech Republic",44540));
		gdpList.add(new GDP("Vietnam",41434));
		gdpList.add(new GDP("Romania",39440));
		gdpList.add(new GDP("Portugal",37962));
		gdpList.add(new GDP("Iraq",30911));
		gdpList.add(new GDP("Peru",28944));
		gdpList.add(new GDP("Greece",18057));
		gdpList.add(new GDP("New Zealand",805997));
		gdpList.add(new GDP("Algeria",88342));
		gdpList.add(new GDP("Qatar",88295));
		gdpList.add(new GDP("Kazakhstan",84209));
		gdpList.add(new GDP("Hungary",56393));
		gdpList.add(new GDP("Kuwait",44523));
		gdpList.add(new GDP("Ukraine",26390));
		gdpList.add(new GDP("Morocco",18178));
		gdpList.add(new GDP("Angola",14504));
		gdpList.add(new GDP("Ecuador",907266));
		gdpList.add(new GDP("Slovakia",806940));
		gdpList.add(new GDP("Puerto Rico",904557));
		gdpList.add(new GDP("Venezuela",96328));
		gdpList.add(new GDP("Sri Lanka",92504));
		gdpList.add(new GDP("Kenya",89591));
		gdpList.add(new GDP("Ethiopia",83836));
		gdpList.add(new GDP("Oman",81682));
		gdpList.add(new GDP("Dominican Republic",81103));
		gdpList.add(new GDP("Guatemala",79109));
		gdpList.add(new GDP("Syria",77460));
		gdpList.add(new GDP("Myanmar",71543));
		gdpList.add(new GDP("Luxembourg",68993));
		gdpList.add(new GDP("Panama",66031));
		gdpList.add(new GDP("Bulgaria",63651));
		gdpList.add(new GDP("Uruguay",60933));
		gdpList.add(new GDP("Costa Rica",60816));
		gdpList.add(new GDP("Croatia",59971));
		gdpList.add(new GDP("Belarus",56934));
		gdpList.add(new GDP("Lebanon",56709));
		gdpList.add(new GDP("Tanzania",55645));
		gdpList.add(new GDP("Slovenia",54969));
		gdpList.add(new GDP("Macau",53961));
		gdpList.add(new GDP("Lithuania",52468));
		gdpList.add(new GDP("Ghana",51815));
		gdpList.add(new GDP("Serbia",47564));
		gdpList.add(new GDP("Cote d'Ivoire",45875));
		gdpList.add(new GDP("Azerbaijan",45592));
		gdpList.add(new GDP("Uzbekistan",43303));
		gdpList.add(new GDP("Libya",43236));
		gdpList.add(new GDP("Democratic Republic of the Congo",42692));
		gdpList.add(new GDP("Turkmenistan",42764));
		gdpList.add(new GDP("Jordan",41869));
		gdpList.add(new GDP("Paraguay",41851));
		gdpList.add(new GDP("Bolivia",41833));
		gdpList.add(new GDP("Tunisia",41662));
		gdpList.add(new GDP("Bahrain",39300));
		gdpList.add(new GDP("Cameroon",38445));
		gdpList.add(new GDP("Latvia",34286));
		gdpList.add(new GDP("Sudan",33249));
	}

	public GDP findGDP(CheckCountry tester)
	{
		for (GDP g : gdpList)
		{
			if (tester.test(g))
			{
				return g;
			}
		}
		return null;
	}

	public ArrayList<GDP> findGDPs(CheckCountry tester)
	{
		ArrayList<GDP> tempGDPlist = new ArrayList<>();

		for (GDP d : gdpList)
		{
			if (tester.test(d))
			{
				tempGDPlist.add(d);
			}
		}

		return tempGDPlist;
	}
}
